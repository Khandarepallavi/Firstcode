package net.javaguides.usermanagement.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import com.mysql.cj.jdbc.Blob;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

import net.javaguides.usermanagement.dao.UserDAO;
import net.javaguides.usermanagement.model.User;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */


	
	@WebServlet("/")
	//@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
	@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 10, // 10MB
    maxRequestSize = 1024 * 1024 * 50)
	public class UserServlet extends HttpServlet {
		private UserDAO userDAO;
		
		public void init() {
			userDAO = new UserDAO();
		}

	     
	    // database connection settings
	    private String dbURL = "jdbc:mysql://localhost:3306/synergy5m?zeroDateTimeBehavior=convertToNull";
	    private String dbUser = "root";
	    private String dbPass = "Synergy5M@123";
	    
	     
	    protected void doPost(HttpServletRequest request,
	            HttpServletResponse response) throws ServletException, IOException {
	        // gets values of text fields
	    	 String industry = request.getParameter("txtcontent10");
	         System.out.println(request.getParameter("txtcontent10"));
	         
	         String category = request.getParameter("txtcontent11");
	         String sub_category=request.getParameter("txtcontent12");
	         String country = request.getParameter("txtcontent13");
	         String state = request.getParameter("txtcontent14");
	         String city = request.getParameter("txtcontent15");
	         String company_name = request.getParameter("company_name");
	         String address = request.getParameter("address");
	         int pin=Integer.parseInt(request.getParameter("pin"));
	         
	         String contact_person = request.getParameter("contact_person");
	         String email = request.getParameter("email");
	         String contact_number =request.getParameter("contact_number");
	         String landline = request.getParameter("landline");
	     
	         String gst_number=request.getParameter("gst_number");
	         String web_site = request.getParameter("web_site");
	         String type_of_business = request.getParameter("type_of_business");
	       
	         
	         
	       
	        InputStream inputStream = null; // input stream of the upload file
	         
	        // obtains the upload file part in this multipart request
	        Part filePart = request.getPart("product_catalouge");
	        if (filePart != null) {
	            // prints out some information for debugging
	            System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());
	             
	            // obtains input stream of the upload file
	            inputStream = filePart.getInputStream();
	        }
	         
	        Connection conn = null; // connection to the database
	        String message = null;  // message will be sent back to client
	         
	        try {
	        	

	        
	        	
	            // connects to the database
	            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
	 
	            // constructs SQL statement
	            String sql = "INSERT INTO users"+"(industry,category,sub_category,country,state,city,company_name,address,pin,contact_person,email,contact_number,landline,gst_number,web_site,type_of_business,product_catalouge) VALUES " +
	                    " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
	            PreparedStatement statement = conn.prepareStatement(sql);
	            statement.setString(1, industry);
	            statement.setString(2, category);
	            statement.setString(3, sub_category);
	            statement.setString(4, country);
	            statement.setString(5, state);
	            statement.setString(6, city);
	            statement.setString(7, company_name);
	            statement.setString(8, address);
	            statement.setInt(9, pin);
	            statement.setString(10, contact_person);
	            statement.setString(11, email);
	            statement.setString(12, contact_number);
	            statement.setString(13, landline);
	            statement.setString(14, gst_number);
	            statement.setString(15, web_site);
	            statement.setString(16, type_of_business);
	           
	          
	             
	            if (inputStream != null) {
	                // fetches input stream of the upload file for the blob column
	                statement.setBlob(17, inputStream);
	            }
	 
	            // sends the statement to the database server
	            int row = statement.executeUpdate();
	            if (row > 0) {
	                message = "File uploaded and saved into database";
	            }
	        }
	       
	    catch (SQLException ex) {
	            message = "ERROR: " + ex.getMessage();
	            ex.printStackTrace();
	        } finally {
	            if (conn != null) {
	                // closes the database connection
	                try {
	                    conn.close();
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }
	            // sets the message in request scope
	            request.setAttribute("Message", message);
	             
	            // forwards to the message page
	            getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
	        }
	    }
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		
		   

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			 case "/update_vendor":
             	updateVendorCode(request,response);
             	break;
			case "/update":
				updateUser(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		
		
		
    }
		
		
	

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = userDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	 private void updateVendorCode(HttpServletRequest request, HttpServletResponse response)
	    	    throws ServletException, IOException {
	    	        RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
	    	        dispatcher.forward(request, response);
	    	    }
	    
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		 String industry = request.getParameter("txtcontent10");
         System.out.println(request.getParameter("txtcontent10"));
         
         String category = request.getParameter("txtcontent11");
         String sub_category=request.getParameter("txtcontent12");
         String country = request.getParameter("txtcontent13");
         String state = request.getParameter("txtcontent14");
         String city = request.getParameter("txtcontent15");
         String company_name = request.getParameter("company_name");
         String address = request.getParameter("address");
         int pin=Integer.parseInt(request.getParameter("pin"));
         
         String contact_person = request.getParameter("contact_person");
         String email = request.getParameter("email");
         String contact_number =request.getParameter("contact_number");
         String landline = request.getParameter("landline");
     
         String gst_number=request.getParameter("gst_number");
         String web_site = request.getParameter("web_site");
         String type_of_business = request.getParameter("type_of_business");
       
         
         
         Part part= request.getPart("product_catalouge");
        
         if (part != null) {
             // prints out some information for debugging
             System.out.println(part.getName());
             System.out.println(part.getSize());
             System.out.println(part.getContentType());
         }
         Blob product_catalouge = null;
		User newUser = new User(industry,category,sub_category,country,state,city,company_name,address,pin,contact_person,email,contact_number,landline,gst_number,web_site,type_of_business,product_catalouge);
		userDAO.insertUser(newUser);
		response.sendRedirect("list");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int id=Integer.parseInt(request.getParameter("id"));
    	String vendor_code=request.getParameter("vendor_code");
        String industry = request.getParameter("txtcontent10");
        String category = request.getParameter("txtcontent11");
        String sub_category=request.getParameter("txtcontent12");
        String country =request.getParameter("txtcontent13");
        String state = request.getParameter("txtcontent14");
        String city = request.getParameter("txtcontent15");
        String company_name = request.getParameter("company_name");
        String address = request.getParameter("address");
        int pin=Integer.parseInt(request.getParameter("pin"));
 
        String contact_person = request.getParameter("contact_person");
        String email = request.getParameter("email");
        String contact_number=request.getParameter("contact_number");
        String landline = request.getParameter("landline");
       
        String gst_number=request.getParameter("gst_number");
        String web_site = request.getParameter("web_site");
        String type_of_business = request.getParameter("type_of_business");
       
        Part product_catalouge = request.getPart("product_catalouge");
        
       User newUser = new User(id,vendor_code,industry,category,sub_category,country,state,city,company_name,address,pin,contact_person,email,contact_number,landline,gst_number,web_site,type_of_business,product_catalouge);
       userDAO.updateUser(newUser);
       response.sendRedirect("list");
    }

	 private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        int id = Integer.parseInt(request.getParameter("id"));
			        userDAO.deleteUser(id);
			        response.sendRedirect("list");

			    }
	 
	 }
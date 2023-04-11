package net.javaguides.usermanagement.dao;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import net.javaguides.usermanagement.model.User;

public class UserDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/synergy5m?zeroDateTimeBehavior=convertToNull";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Synergy5M@123";

    private static final String INSERT_USERS_SQL = "INSERT INTO users"+"(industry,category,sub_category,country,state,city,company_name,address,pin,contact_person,email,contact_number,landline,gst_number,web_site,type_of_business,product_catalouge) VALUES " +
        " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

   
    private static final String SELECT_ALL_USERS = "SELECT * FROM users";
    		
    private static final String SELECT_USER_BY_ID = "select id,vendor_code,industry,category,sub_category,country,state,city,company_name,address,pin,contact_person,email,contact_number,landline,gst_number,web_site,type_of_business,product_catalouge from users where id =?";
    private static final String update_user ="update users SET vendor_code = concat(substr(industry,1,3),'0000',substr(category,1,3),id);";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set industry=?,category=?,sub_category=?,country=?,state=?,city=?,company_name=?,address=?,pin=?,contact_person=?,email=?,contact_number=?,landline=?,gst_number=?,web_site=?,type_of_business=?,product_catalouge=?where id=?;";

    public UserDAO() {}

    protected Connection getConnection() {
    	Connection connection = null;
        
        try {
            
        	
        	 Class.forName("com.mysql.cj.jdbc.Driver");
             connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
         } catch (SQLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         } catch (ClassNotFoundException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
         return connection;
        
    }

    public void insertUser(User user) throws SQLException  {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); 
        	PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getIndustry());
           // System.out.println(user.getIndustry().toString()+"indus");
            preparedStatement.setString(2, user.getCategory());
            preparedStatement.setString(3, user.getSub_category());
            preparedStatement.setString(4, user.getCountry());
            preparedStatement.setString(5, user.getState());
            preparedStatement.setString(6, user.getCity());
            preparedStatement.setString(7, user.getCompany_name());
            preparedStatement.setString(8, user.getAddress());
            preparedStatement.setInt(9, user.getPin());         
            preparedStatement.setString(10, user.getContact_person());
            preparedStatement.setString(11, user.getEmail());
            preparedStatement.setString(12, user.getContact_number());
            preparedStatement.setString(13, user.getLandline());        
            preparedStatement.setString(14, user.getGst_number());
            preparedStatement.setString(15, user.getWeb_site());
            preparedStatement.setString(16, user.getType_of_business());
            preparedStatement.setBlob(17, user.getProduct_catalouge());
           
            
            
           
            preparedStatement.executeUpdate();         
          
            try (Connection conn = getConnection();
            	
    		        PreparedStatement prepareStatement = conn.prepareStatement(update_user)){
            			prepareStatement.executeUpdate();    		        	
    		        	prepareStatement.close();
    		        	
    		        } catch (SQLException e) {
    		            printSQLException(e);
    		        }
           
        }
        catch (SQLException e) {
            printSQLException(e);
        }
       
    }
    

//   public boolean update_user(User user) throws SQLException {
//       boolean rowUpdated;
//        try (Connection connection = createConnection(); 
//      	PreparedStatement statement = connection.prepareStatement(update_user)) {
//        	statement.setString(1, user.getVendor_code());
//        	statement.setString(2, user.getIndustry());
//        	statement.setString(3, user.getCategory());
//        	statement.setString(4, user.getSub_category());
//        	statement.setString(5, user.getCountry());
//        	statement.setString(6, user.getState());
//        	statement.setString(7, user.getCity());
//         	statement.setString(8, user.getCompany_name());
//        	statement.setString(9, user.getAddress());
//        	statement.setInt(10, user.getPin());
//        	statement.setString(11, user.getContact_person());
//       	statement.setString(12, user.getEmail());
//       	statement.setString(13, user.getContact_number());
//        	statement.setString(14, user.getLandline());
//            statement.setString(15, user.getGst_number());
//            statement.setString(16, user.getWeb_site());
//            statement.setString(17, user.getType_of_business());
//            statement.setString(18, user.getProduct_catalouge());
//           
//            statement.setInt(19, user.getId()); 
//            
//
//            rowUpdated = statement.executeUpdate() > 0;
//        }
//        return rowUpdated;
//    }
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
        	PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL)) {
        	
        	
        	
            	
            	statement.setString(1, user.getIndustry());
            	statement.setString(2, user.getCategory());
            	statement.setString(3, user.getSub_category());
            	statement.setString(4, user.getCountry());
            	statement.setString(5, user.getState());
            	statement.setString(6, user.getCity());
             	statement.setString(7, user.getCompany_name());
            	statement.setString(8, user.getAddress());
            	statement.setInt(9, user.getPin());
            	statement.setString(10, user.getContact_person());
           	    statement.setString(11, user.getEmail());
           	    statement.setString(12, user.getContact_number());
            	statement.setString(13, user.getLandline());
                statement.setString(14, user.getGst_number());
                statement.setString(15, user.getWeb_site());
                statement.setString(16, user.getType_of_business());
                statement.setBlob(17, user.getProduct_catalouge());
               
                statement.setInt(18, user.getId()); 
                
    
               rowUpdated = statement.executeUpdate() > 0;
               statement.close();
        }
        return rowUpdated;
    }
     public User selectUser(int id) {
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String vendor_code = rs.getString("vendor_code");
                String industry = rs.getString("industry");
                String category = rs.getString("category");
                String sub_category = rs.getString("sub_category");
                String country = rs.getString("country");
                String state = rs.getString("state");
                String city = rs.getString("city");
                String company_name=rs.getString("company_name");
                String address = rs.getString("address");
                int pin = rs.getInt("pin");
                String contact_person =rs.getString("contact_person");
                String email = rs.getString("email");
                String contact_number = rs.getString("contact_number");
                String landline=rs.getString("landline");
                String gst_number = rs.getString("gst_number");
                String web_site = rs.getString("web_site");
                String type_of_business=rs.getString("type_of_business");
                Blob product_catalouge=rs.getBlob("product_catalouge");
                
                user = new User(id,vendor_code,industry,category,sub_category,country,state,city,company_name,address,pin,contact_person,email,contact_number,landline,gst_number,web_site,type_of_business,product_catalouge);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public List < User > selectAllUsers() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List < User > users = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	int id=rs.getInt("id");
            	String vendor_code=rs.getString("vendor_code");
            	String industry = rs.getString("industry");
            
                String category = rs.getString("category");
                String sub_category = rs.getString("sub_category");
                String country = rs.getString("country");
                String state = rs.getString("state");
                String city = rs.getString("city");
                String company_name=rs.getString("company_name");
                String address = rs.getString("address");
                int pin = rs.getInt("pin");
               
                String contact_person =rs.getString("contact_person");
                String email = rs.getString("email");
                String contact_number = rs.getString("contact_number");
                String landline=rs.getString("landline");
               
                String gst_number = rs.getString("gst_number");
                String web_site = rs.getString("web_site");
                String type_of_business=rs.getString("type_of_business");
             
                Blob product_catalouge=rs.getBlob("product_catalouge");
               
                users.add(new User(id,vendor_code,industry,category,sub_category,country,state,city,company_name,address,pin,contact_person,email,contact_number,landline,gst_number,web_site,type_of_business,product_catalouge));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }
    
    
		
    
        
    
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
        	PreparedStatement statement1 = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement1.setInt(1, id);
            rowDeleted = statement1.executeUpdate() > 0;
        }
        return rowDeleted;
    }

 

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

	


}

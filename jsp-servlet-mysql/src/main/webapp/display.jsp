<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Image Show</title>
    </head>
    <body>
        <%
            int ID = Integer.parseInt(request.getParameter("ID"));
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/synergy5m?zeroDateTimeBehavior=convertToNull", "root", "Synergy5M@123");
                Statement st = con.createStatement();
                String sql = "SELECT products_vatlog FROM productsnew where id=" + ID + "";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    String filename = rs.getString("filename");
        %>

        <table style="width:100%">
            <tr>
                <th>ID</th>
                <th>Image</th>

            </tr>
            <tr>
                <td><%=ID%></td><td>
                <td><td><image src="<%=filename%>" width="200" height="200"/></td>

            </tr>
        </table>
        <%
                }
            } catch (Exception e) {
                out.println(e);
            }
        %><br>
    <center><a href="viewAll.jsp">View All </a></center>
</body>
</html>
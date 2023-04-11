<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("userid");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "master";
String userid = "root";
String password = "Synergy5M@123";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<body>

<h1>Retrieve data from database in jsp</h1>
<table border="1">
<tr>
<td>industry</td>
<td>category</td>
<td>sub_category</td>
<td>country</td>


</tr>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from users";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>

<td><%=resultSet.getString("PRODUCT_NAME") %></td>
<td><%=resultSet.getString("GRADE") %></td>
<td><%=resultSet.getString("UNIT_OF_MEASUREMENT") %></td>
<td><%=resultSet.getString("HS_CODE") %></td>
<td><%=resultSet.getString("MANUFACTURER") %></td>
<td><%=resultSet.getString("COUNTRY") %></td>
<td><%=resultSet.getString("TDS") %></td>



</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table> 

</body>
</html>
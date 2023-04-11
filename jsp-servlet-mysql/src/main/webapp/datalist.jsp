<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<table width="700px" align="center" style="border: 1px solid #000000;">
		<tr>
			<td colspan=8 align="center" style="background-color: ffeeff"><b>USERS Record</b></td>
		</tr>
		<tr style="background-color: efefef;">
			<td><b>ID</b></td>

			<td><b>INDUSTRY</b></td>
			<td><b>CATEGORY</b></td>
			<td><b>SUB_CATEGORY</b></b></td>
			<td>COMPANY_NAME</b></td>
			<td><b>ADDRESS</b></td>
			<td><b>PIN</b></td>
			<td><b>COUNTRY</b></td>
			<td><b>CONTACT_PERSON</b></td>
			<td><b>STATE</b></td>
			<td><b>CITY</b></td>
			<td><b>MOBILE_NUMBER</b></td>
			<td><b>LANDLINE</b></td>
			<td><b>EMAIL</b></td>
			<td><b>GST_NUMBER</b></td>
			<td><b>WEBSITE</b></td>
			<td><b>TYPE_OF_BUSINESS</b></td>
			<td><b>PRODUCT NAME</b></td>
			<td><b>PRODUCT MANUFACTURING CAPACITY</b></td>
			<td><b>PRODUCT IMAGE</b></td>
			<td><b>PRODUCT CATALOUGE</b></td>
			<td><b>OTHER DETAILS</b></td>
		<tr>


		</tr>
		<%
		int count = 0;
		String color = "#F9EBB3";

		if (request.getAttribute("userList") != null) {
			ArrayList al = (ArrayList) request.getAttribute("userList");
			Iterator itr = al.iterator();

			while (itr.hasNext()) {

				if ((count % 2) == 0) {
			color = "#eeffee";
				} else {
			color = "#F9EBB3";
				}
				count++;
				ArrayList userList = (ArrayList) itr.next();
		%>
		<tr style="background-color:<%=color%>;">
			<td><%=userList.get(0)%></td>
			<td><%=userList.get(1)%></td>
			<td><%=userList.get(3)%></td>
			<td><%=userList.get(4)%></td>
			<td><%=userList.get(5)%></td>
			<td><%=userList.get(6)%></td>
			<td><%=userList.get(7)%></td>
			<td><%=userList.get(8)%></td>
			<td><%=userList.get(9)%></td>
			<td><%=userList.get(10)%></td>
			<td><%=userList.get(11)%></td>
			<td><%=userList.get(12)%></td>
			<td><%=userList.get(13)%></td>
			<td><%=userList.get(14)%></td>
			<td><%=userList.get(15)%></td>
			<td><%=userList.get(16)%></td>
			<td><%=userList.get(17)%></td>
			<td><%=userList.get(18)%></td>
			<td><%=userList.get(19)%></td>
			<td><%=userList.get(20)%></td>
			<td><%=userList.get(21)%></td>
			<td><%=userList.get(22)%></td>
		
		</tr>
		<%
		}
		}
		%>
		<%
		if (count == 0) {
		%>
		<tr>
			<td colspan=8 align="center" style="background-color: eeffee"><b>No
					Record</b></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>

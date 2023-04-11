<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style>
#id6{
  width:50%;

}
</style></head>


<body>

	<%@include file="header.html"%>
	<br>
	

	<div class="row">
		<div class="container">
          
			<h3 class="text-center">List of Users</h3>

			
				<i class="bi bi-download btn-lg float-end" onclick="exportData()"
					style="font-size: 28px; margin-top:-3.5rem; color: white; background-color: green;border-radius: 5px;"></i>
			

			
			<table id="tblStocks" class="table table-bordered" >

				<thead>
					<tr>
						<th>ID</th>
						<th>VENDOR_CODE</th>
						<th></th>
						<th>INDUSTRY</th>
						<th >CATEGORY</th>
						<th>SUB_CATEGORY</th>
						<th>COUNTRY</th>
						<th>STATE</th>
						<th>CITY</th>
						<th>COMPANY_NAME</th>
						<th>ADDRESS</th>
						<th>PIN</th>
						<th>CONTACT_PERSON</th>
						<th>EMAIL</th>
						<th>CONTACT_NUMBER</th>
						<th>LANDLINE</th>
						<th>GST_NUMBER</th>
						<th>WEBSITE</th>
						<th>TYPE_OF_BUSINESS</th>
						<th>PRODUCT CATALOUGE</th>
					</tr>
				</thead>

				<!--for(Todo todo: todos){-->
				<c:forEach var="user" items="${listUser}">
					<tbody>
						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.vendor_code}" /></td>
							
							<td><a href="edit?id=<c:out value='${user.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${user.id}' />">Delete</a></td>
							<td><c:out value="${user.industry}" /></td>
							<td ><c:out value="${user.category}" /></td>
							<td><c:out value="${user.sub_category}" /></td>
							<td><c:out value="${user.country}" /></td>
							<td><c:out value="${user.state}" /></td>
							<td><c:out value="${user.city}" /></td>
							<td><c:out value="${user.company_name}" /></td>
							<td><c:out value="${user.address}" /></td>
							<td><c:out value="${user.pin}" /></td>

							<td><c:out value="${user.contact_person}" /></td>
							<td><c:out value="${user.email}" /></td>

							<td><c:out value="${user.contact_number}" /></td>
							<td><c:out value="${user.landline}" /></td>

							<td><c:out value="${user.gst_number}" /></td>
							<td><c:out value="${user.web_site}" /></td>
							<td><c:out value="${user.type_of_business}" /></td>

							<td><c:out value="${user.product_catalouge}" /></td>




						</tr>
				</c:forEach>
				<!-- } -->
				</tbody>

			</table>
			
		</div>
	</div>
	<script>
	function exportData(){
    /* Get the HTML data using Element by Id */
    var table = document.getElementById("tblStocks");
 
    /* Declaring array variable */
    var rows =[];
 
      //iterate through rows of table
    for(var i=0,row; row = table.rows[i];i++){
        //rows would be accessed using the "row" variable assigned in the for loop
        //Get each cell value/column from the row
        column1 = row.cells[0].innerText;
        column2 = row.cells[1].innerText;
        column3 = row.cells[2].innerText;
        column4 = row.cells[3].innerText;
        column5 = row.cells[4].innerText;
        column6 = row.cells[5].innerText;
        column7 = row.cells[6].innerText;
        column8 = row.cells[7].innerText;
        column9 = row.cells[8].innerText;
        column10 = row.cells[9].innerText;
        column11 = row.cells[10].innerText;
        column12 = row.cells[11].innerText;
        column13 = row.cells[12].innerText;
        column14 = row.cells[13].innerText;
        column15 = row.cells[14].innerText;
        column16 = row.cells[15].innerText;
        column17= row.cells[16].innerText;
        column18= row.cells[17].innerText;
        column19= row.cells[18].innerText;
        
 
    /* add a new records in the array */
        rows.push(
            [
                column1,
                column2,
                column3,
                column4,
                column5,
                column6,
                column7,
                column8,
                column9,
                column10,
                column11,
                column12,
                column13,
                column14,
                column15,
                column16,
                column17,
                column18,
                column19,
                
            ]
        );
 
        }
        csvContent = "data:text/csv;charset=utf-8,";
         /* add the column delimiter as comma(,) and each row splitted by new line character (\n) */
        rows.forEach(function(rowArray){
            row = rowArray.join(",");
            csvContent += row + "\r\n";
        });
 
        /* create a hidden <a> DOM node and set its download attribute */
        var encodedUri = encodeURI(csvContent);
        var link = document.createElement("a");
        link.setAttribute("href", encodedUri);
        link.setAttribute("download", "Data_table.csv");
        document.body.appendChild(link);
         /* download the data file named "Stock_Price_Report.csv" */
        link.click();
}</script>



	<%@include file="footer.html"%>
</body>

</html>
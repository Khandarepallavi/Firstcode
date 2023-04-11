<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head><base><link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-responsive.css">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
	integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
	<style>
	.back {
  background-color: #ddd;
  border: none;
  color: black;
  padding-left: 25px;
   padding-right : 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  margin: 1px 0px;
  cursor: pointer;
  border-radius: 16px;
  height:30px;
}</style>
</head>

<body>

<div>
<button class="back" onclick="history.back()">.Back</button>

<h2 colspan=19 align="center"
style="background-color:ffeeff"><b>User Record</b></h2></div><i class="bi bi-download btn-lg float-end" onclick="exportData()"
					style="font-size: 28px; margin-top:-3.5rem; color: white; background-color: green;border-radius: 5px;"></i>
			</div>

<table  id="tblStocks" width="700px" align="center"
style="border:1px solid #000000;">

<tr style="background-color:efefef;">
<td><b>id</b></td>
<td><b>vendor_code</b></td>
<td><b>industry</b></td>
<td><b>category</b></td>
<td><b>sub_category</b></td>
<td><b>country</b></td>
<td><b>state</b></td>
<td><b>city</b></td>
<td><b>company_name</b></td>
<td><b>address</b></td>
<td><b>pin</b></td>
<td><b>contact_person</b></td>
<td><b>email</b></td>
<td><b>contact_number</b></td>
<td><b>landline</b></td>
<td><b>gst_number</b></td>
<td><b>web_site</b></td>
<td><b>type_of_business</b></td>
<td><b>product_catalouge</b></td>


</tr>
<%
int count=0;
String color = "#F9EBB3";


if(request.getAttribute("empList")!=null)
{
ArrayList al = (ArrayList)request.getAttribute("empList");
Iterator itr = al.iterator();


while(itr.hasNext()){

if((count%2)==0){
color = "#eeffee";
}
else{
color = "#F9EBB3";
}
count++;
ArrayList empList = (ArrayList)itr.next();
%>
<tr style="background-color:<%=color%>;">
<td><%=empList.get(0)%></td>
<td><%=empList.get(1)%></td>
<td><%=empList.get(2)%></td>
<td><%=empList.get(3)%></td>
<td><%=empList.get(4)%></td>
<td><%=empList.get(5)%></td>
<td><%=empList.get(6)%></td>
<td><%=empList.get(7)%></td>
<td><%=empList.get(8)%></td>
<td><%=empList.get(9)%></td>
<td><%=empList.get(10)%></td>
<td><%=empList.get(11)%></td>
<td><%=empList.get(12)%></td>
<td><%=empList.get(13)%></td>
<td><%=empList.get(14)%></td>
<td><%=empList.get(15)%></td>
<td><%=empList.get(16)%></td>
<td><%=empList.get(17)%></td>
<td><%=empList.get(18)%></td>
</tr>
<%
}
}
%>
<%
if(count==0){
%>
<tr>
<td colspan=19 align="center"
style="background-color:eeffee"><b>No Record</b></td>
</tr>
<%
}
%>
</table>
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
       
 
    /* add a new records in the array */
        rows.push(
            [
                column1,
                column2,
                column3,
                column4,
                column5,
                column6,
                column7
              
                
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
        link.setAttribute("download", "Search_Report.csv");
        document.body.appendChild(link);
         /* download the data file named "Stock_Price_Report.csv" */
        link.click();
}</script>

</body>
</html>
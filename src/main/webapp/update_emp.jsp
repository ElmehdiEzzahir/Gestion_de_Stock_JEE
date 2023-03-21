<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>update Employee</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/additem.css" />

</head>

<body>

<%@ page import="java.sql.*" %>

<%@ page import="Connection.DBconnection" %>

<%@ page import="Connection.SelectOP" %>

<%@ page import="java.util.ArrayList" %>

<%@ include file = "Adminnavbar.jsp" %>

<%
HttpSession Session = request.getSession(false);

if(Session == null || session.getAttribute("nom") != null &&  session.getAttribute("type").equals("Admin")) {
	System.out.println("working");
	
} else{
	System.out.print(Session.isNew());
	request.getRequestDispatcher("/login.jsp").forward(request, response);
}
%>

<% request.setAttribute("updateidjsp",request.getAttribute("updateid")); %>


<div class="Container">

<h1>Update Item</h1>

<form action="Controller" method="post">
  <input type="hidden" name="type" value="${sessionScope.type}">
  <input type="hidden" name="nom" value="${sessionScope.nom}">
<input type="hidden" name="actionControl" value="Updateemp">

<input type="hidden" name="updateidjsp" value=${ updateid } >


<label for="empname">EmployeeName:</label><br>

<input type='text' id='empname' name='empname' value=${ empname } required><br>


<label for="emppass">password:</label><br>

<input type='password' id='emppass' name='emppass' value=${ emppass } required><br>





<label for="emptype">Type:</label><br>

<select name="emptype" id="emptype" required>

<%

 ResultSet rsempp=SelectOP.getData("Select * from Gestion_EMP where emp_id="+request.getAttribute("updateid")+"");
 
 String type = request.getParameter("emptype");
	try {
	while(rsempp.next()) {

		 String mohy=rsempp.getString(4);
		 
		 switch (mohy) {

		 case "Admin": {

		 out.print("<option value='Admin' selected>Admin</option><option value='Sous Admin'>Sous Admin </option><option value='Employee'> Employee </option>");

		 break;

		 }

		 case "Sous Admin": {

		 out.print("<option value='Admin' >Admin</option><option value='Sous Admin' selected='selected'>Sous Admin </option><option value='Employee'> Employee </option>");

		 break;

		 }

		 case "employee": {

		 out.print("<option value='Admin' >Admin</option><option value='Sous Admin' >Sous Admin </option><option value='Employee' selected='selected'> Employee </option>");

		 break;

		 }


	}

	rsempp.close();

	}} catch (SQLException e) {


	e.printStackTrace();

	}



%>

</select>

<br><br>



<input type="submit" value="Submit changes">


</form>

</div>

</body>

</html>
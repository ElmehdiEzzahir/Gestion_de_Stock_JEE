<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add employees </title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/additem.css" />
<%

HttpSession Session = request.getSession(false);

if(Session == null || session.getAttribute("nom") != null &&  session.getAttribute("type").equals("Admin")) {
	System.out.println("working");
	
} else{
	request.getRequestDispatcher("/login.jsp").forward(request, response);
}
%>

</head>
<body>
<%@ page import="java.sql.*" %>
<%@ page import="Connection.DBconnection" %>
<%@ page import="Connection.SelectOP" %>

<%@ include file = "Adminnavbar.jsp" %>

    <div class="Container">
            <h1>Add Employees </h1>
  <form action="Controller" method="post">

  <input type="hidden" name="actionControl" value="addempform">
	  <input type="hidden" name="type" value="${sessionScope.type}">
  <input type="hidden" name="nom" value="${sessionScope.nom}">
  <label for="EmpName">EmpName:</label><br>
  <input type="text" id="EmpName" name="EmpName" required><br>
  
   <label for="Emp_password">Password:</label><br>
  <input type="text" id="Emp_password" name="Emp_password" required><br>
  
  <select name="selectName">
  <option value="Admin">Admin</option>
  <option value="Sous Admin">Sous Admin </option>
  <option value="Employee"> Employees </option>
  </select>
  <input type="submit" value="Submit">	

  <br><br>
  </form>
  </div>
  

</body>
</html>
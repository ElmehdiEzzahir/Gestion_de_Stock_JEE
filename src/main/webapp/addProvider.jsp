<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Add Provider</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/additem.css" />

</head>

<body>
<%@ include file = "navbar.jsp" %>

<%
HttpSession Session = request.getSession(false);

if(Session == null || session.getAttribute("nom") != null &&  session.getAttribute("type").equals("Sous Admin")) {
	System.out.println("working");
} else{
	System.out.print(Session.isNew());
	request.getRequestDispatcher("/login.jsp").forward(request, response);
}
%>

<div class="Container">

            <h1>Add Provider</h1>

<form action="Controller" method="post">

<input type="hidden" name="actionControl" value=Providerform>
  <input type="hidden" name="type" value="${sessionScope.type}">
  <input type="hidden" name="nom" value="${sessionScope.nom}">

<label for="Provider_Name">Provider Name:</label><br>

<input type="text" id="Provider_Name" name="Provider_Name" required><br>

<label for="Provider_company">Provider_company:</label><br>

<input type="text" id="Provider_company" name="Provider_company" required><br>

<label for="Provider_Age">Provider Age:</label><br>

<input type="number" id="Provider_Age" name="Provider_Age" required><br>

<label for="Provider_address">Provider_address:</label><br>

<textarea id="Provider_address" name="Provider_address" rows="6" cols="40"></textarea><br>

<input type="submit" value="Submit">

</form>
</div>>



</body>

</html>
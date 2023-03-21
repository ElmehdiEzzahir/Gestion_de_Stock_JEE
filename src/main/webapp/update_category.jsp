<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Update category</title>
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
            <h1>update Category</h1>

<form action="Controller" method="post">

 <input type="hidden" name="actionControl" value="updateCategory">
  <input type="hidden" name="updateidjsp" value=${ updateid } >
  <input type="hidden" name="type" value="${sessionScope.type}">
  <input type="hidden" name="nom" value="${sessionScope.nom}">
<label for="Category_Name">Category Name:</label><br>
<input type="text" id="Category_Name" name="Category_Name" value=${ catname } required><br>


<label for="Category_Description">Category_Description:</label><br>
<textarea id="Category_Description" name="Category_Description"  rows="8" cols="60">${ catedesc }</textarea><br>

<input type="submit" value="Submit">

</form>
</div>>


</body>

</html>
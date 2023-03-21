<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/navbar.css" />

<body>
<nav>
<h1>Gestion de Stock</h1>
  <div>
    <ul>
    <li><a href="index.jsp">Home</a></li>
    <li><a href="additem.jsp">AddItems</a></li>
    <li><a href="addProvider.jsp">AddProvider</a></li>
    <li><a href="addCategory.jsp">AddCategory</a></li>
    <li><form action="Controller"method="get">
<input class="logout" type="submit" name="logout" value="logout">
<input type="hidden" name="name" value="${sessionScope.nom}">
<input type="hidden" name="type" value="${sessionScope.type}">


</form></li>
  </ul>
  </div>
  

</nav>

</body>
</html>
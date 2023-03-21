<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddItemspage</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/additem.css" />

</head>
<body>
<%@ page import="java.sql.*" %>
<%@ page import="Connection.DBconnection" %>
<%@ page import="Connection.SelectOP" %>

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
            <h1>Add Items</h1>
  <form action="Controller" method="post">

  <input type="hidden" name="actionControl" value="Itemform">
  <input type="hidden" name="type" value="${sessionScope.type}">
  <input type="hidden" name="nom" value="${sessionScope.nom}">
	
  <label for="ItemName">ItemName:</label><br>
  <input type="text" id="ItemName" name="ItemName" required><br>
  
   <label for="Item_price">Item_price:</label><br>
  <input type="number" id="Item_price" name="Item_price" required><br>
  
  <label for="weight">Item_weight:</label><br>
  <input type="number" id="weight" name="weight" required><br>
  
  <label for="quantity">Item_Quantity:</label><br>
  <input type="number" id="quantity" name="quantity" required><br>
  
  <label for="Provider">Provider:</label><br>
  <select name="Provider" id="Provider" required>
   	<% ResultSet rs=SelectOP.getData("Select * from provider order by provider_id");
  		try{ 
  	     while(rs.next())
  	     {
  	    	 out.print("<option value="+rs.getString(2)+">"+rs.getString(2)+"</option>");
  	     }
  	     
  	     rs.close();
  	     }
  	     catch(Exception e){System.out.println(e);
  	     }
  		
  	    
  	%>
  </select>
  <br><br>
  
  <label for="Category">Category:</label><br>
  <select name="Category" id="Category" required>
     	<% ResultSet rs2=SelectOP.getData("Select * from category");
  		try{ 
  	     while(rs2.next())
  	     {
  	    	 out.print("<option value="+rs2.getString(2)+">"+rs2.getString(2)+"</option>");

  	     }
  	     
  	     rs2.close();
  	     }
  	     catch(Exception e){System.out.println(e);
  	     }
  		
  	    
  	%>

  </select>
 
        <div class='message'>
</div>

  <br><br>
  
  <label for="description">Item_Description:</label><br>
  <textarea id="description" name="description" rows="6" cols="40"></textarea><br>
  
  <input type="submit" value="Submit">
  
</form>
</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css" />
</head>
<body>
<%@ page import="java.sql.*" %>
<%@ page import="Connection.DBconnection" %>
<%@ page import="Connection.SelectOP" %>

<% DBconnection.createCon(); %>

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

<section id="Emps_tab">
<h1>Welcome ${sessionScope.nom} </h1>



<div class="tableContainer">
<table>
  <thead>
  
    <tr>
      <th>Emp ID</th>
      <th>Emp Name</th>
      <th>Emp Password</th>
      <th>Emp Type</th>
      <th>Update</th>
      <th>Delete</th>
    </tr>
  </thead>
  <tbody>
  	<% ResultSet rs_it=SelectOP.getData("Select * from Gestion_EMP order by emp_id");
 
  		 try{

  	     while(rs_it.next()){

  	    	 out.print("<tr><td>"+rs_it.getString(1)+"</td><td>"+rs_it.getString(2)+"</td><td>"+rs_it.getString(3)+"</td><td>"+rs_it.getString(4)+"</td><td><form action='Controller' method='post'><input type='hidden' name='actionControl' value='updateeid'> <input type='hidden' name='updatefrom' value='updatefromemp'><input type='hidden' name='idvalue' value="+rs_it.getString(1)+"><button type='submit'><i class='fa-solid fa-pen'></i></button></form></td><td><form action='Controller' method='post'><input type='hidden' name='actionControl' value='deleteid'> <input type='hidden' name='deletfrom' value='deletefromemp'><input type='hidden' name='idvalue' value="+rs_it.getString(1)+"><button type='submit'><i class='fa-solid fa-delete-left'></i></button></form></td></tr>");   	 
  	    	
  	    	}
  	   rs_it.close();
  		}catch(Exception e){
  			System.out.println(e);
  		}  		
  	%>
  </tbody>
</table>
</div>
</section>
<script src="https://kit.fontawesome.com/95b6582c87.js" crossorigin="anonymous"></script>

 </body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logs</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css" />
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
<body>


<div class="tableContainer">

<table>
  <thead>
    <tr>
      <th>Log ID</th>
      <th>Content</th>
    </tr>
  </thead>
  <tbody>
  	<% ResultSet rs_log=SelectOP.getData("Select * from Logs order by Log_ID");
 
  		 try{

  	     while(rs_log.next()){

  	    	 out.print("<tr><td>"+rs_log.getString(1)+"</td><td>"+rs_log.getString(3)+"</td></tr>");   	 
  	    	
  	    	}
  	   rs_log.close();
  		}catch(Exception e){
  			System.out.println(e);
  		}  		
  	%>
  </tbody>
</table>
</div>

</body>
</html>
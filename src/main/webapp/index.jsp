<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css" />
</head>
<body>
<%@ page import="java.sql.*" %>
<%@ page import="Connection.DBconnection" %>
<%@ page import="Connection.SelectOP" %>

<% DBconnection.createCon(); %>

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

<section id="items_tab">
<h1 class="hea">Welcome ${sessionScope.nom} </h1>




<div class="tableContainer">
<div class="navbar">
<a href="#provider_tab">provider table</a>
<a href="#category_tab">category table</a>
</div>
<table>
  <thead>
    <tr>
      <th>Item ID</th>
      <th>Item Name</th>
      <th>Item Price</th>
      <th>Item weight</th>
      <th>Item Quantity</th>
      <th>Provider Name</th>
      <th>Category</th>
      <th>Description</th>
      <th>Update</th>
      <th>Delete</th>
      

    </tr>
  </thead>
  <tbody>
  	<% ResultSet rs_it=SelectOP.getData("select * from items i,category c,provider p where i.category_id=c.category_id and i.provider_id = p.provider_id");
 
  		 try{

  	     while(rs_it.next()){
    	    	System.out.println(rs_it.getString(1));

  	    	 out.print("<tr><td>"+rs_it.getString(1)+"</td><td>"+rs_it.getString(3)+"</td><td>"+rs_it.getString(2)+"</td><td>"+rs_it.getString(4)+"</td><td>"+rs_it.getString(5)+"</td><td>"+rs_it.getString(13)+"</td><td>"+rs_it.getString(10)+"</td><td>"+rs_it.getString(8)+"</td><td><form action='Controller' method='post'><input type='hidden' name='actionControl' value='updateeid'> <input type='hidden' name='updatefrom' value='updatefromitems'><input type='hidden' name='idvalue' value="+rs_it.getString(1)+"><button type='submit'><i class='fa-solid fa-pen'></i></button></form></td><td><form action='Controller' method='post'><input type='hidden' name='name' value='${sessionScope.nom}'><input type='hidden' name='type' value='${sessionScope.type}'><input type='hidden' name='actionControl' value='deleteid'> <input type='hidden' name='deletfrom' value='deletefromitems'><input type='hidden' name='idvalue' value="+rs_it.getString(1)+"><button type='submit'><i class='fa-solid fa-delete-left'></i></button></form></td></tr>");   	 
  	    	

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
<section id="provider_tab">



<div class="tableContainer"> 
<div class="navbar">
<a href="#items_tab">items table</a>
<a href="#category_tab">category table</a>
</div>
<table>
  <thead>
    <tr>
      <th>Provider_ID</th>
      <th>Provider_Name</th>
       <th>Provider_company</th>
      <th>Provider_Age</th>
      <th>Provider_address</th>
      <th>Update</th>
      <th>Delete</th>
      
    </tr>
  </thead>
  <tbody>
  	<% ResultSet rsp=SelectOP.getData("Select * from Provider order by provider_id");
  		try{ 
  	     while(rsp.next())
  	     {
  	    	 out.print("<tr><td>"+rsp.getString(1)+"</td><td>"+rsp.getString(2)+"</td><td>"+rsp.getString(3)+"</td><td>"+rsp.getString(4)+"</td><td>"+rsp.getString(5)+"</td><td><form action='Controller' method='post'><input type='hidden' name='actionControl' value='updateeid'>  <input type='hidden' name='updatefrom' value='updatefromprov'><input type='hidden' name='idvalue' value="+rsp.getString(1)+"><button type='submit'><i class='fa-solid fa-pen'></i></button></form></td><td><form action='Controller' method='post'><input type='hidden' name='name' value='${sessionScope.nom}'><input type='hidden' name='type' value='${sessionScope.type}'><input type='hidden' name='actionControl' value='deleteid'><input type='hidden' name='deletfrom' value='deletefromprov'><input type='hidden' name='idvalue' value="+rsp.getString(1)+"><button type='submit'><i class='fa-solid fa-delete-left'></i></button></form></td></tr>");
 	     }
  	   rsp.close();
  	     }
  	     catch(Exception e){System.out.println(e);
  	     }
	    
  	%>
   </tbody>
</table>
</div>


</section>

<section id="category_tab">



<div class="tableContainer"> 
<div class="navbar">
<a href="#items_tab">items table</a>
<a href="#provider_tab">provider table</a>
</div>
<table>
  <thead>
    <tr>
      <th>Category_ID</th>
      <th>Category_Name</th>
      <th>Category_Description</th>
      <th>Update</th>
      <th>Delete</th>
    </tr>
  </thead>
  <tbody>
  
  
  	<% ResultSet rsc=SelectOP.getData("Select * from category order by Category_ID");
  		try{ 
  	     while(rsc.next())
  	     {
  	    	 out.print("<tr><td>"+rsc.getString(1)+"</td><td>"+rsc.getString(2)+"</td><td>"+rsc.getString(3)+"</td><td><form action='Controller' method='post'><input type='hidden' name='actionControl' value='updateeid'> <input type='hidden' name='updatefrom' value='updatefromcat'><input type='hidden' name='idvalue' value="+rsc.getString(1)+"><button type='submit'><i class='fa-solid fa-pen'></i></button></form></td><td><form action='Controller' method='post'><input type='hidden' name='name' value='${sessionScope.nom}'><input type='hidden' name='type' value='${sessionScope.type}'><input type='hidden' name='actionControl' value='deleteid'> <input type='hidden' name='deletfrom' value='deletefromcat'><input type='hidden' name='idvalue' value="+rsc.getString(1)+"><button type='submit'><i class='fa-solid fa-delete-left'></i></button></form></td></tr>");
 	     }
  	   rsc.close();
  	     }
  	     catch(Exception e){System.out.println(e);
  	     }	    
  	%>
    </tbody>
</table>
</div>

</section>


<script src="https://kit.fontawesome.com/95b6582c87.js" crossorigin="anonymous"></script>

 </body>
</html>
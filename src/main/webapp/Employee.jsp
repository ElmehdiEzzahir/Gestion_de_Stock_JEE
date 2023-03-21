<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EMP DASHBORD </title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/search.css" />
</head>
<body>
<%@ page import="java.sql.*" %>
<%@ page import="Connection.DBconnection" %>
<%@ page import="Connection.SelectOP" %>

<% DBconnection.createCon(); %>

<%@ include file = "empnav.jsp" %>

<%

HttpSession Session = request.getSession(false);

if(Session == null || session.getAttribute("nom") != null &&  session.getAttribute("type").equals("Employee")) {
	System.out.println("working");
	
} else{
	System.out.print(Session.isNew());
	request.getRequestDispatcher("/login.jsp").forward(request, response);
}
%>

<section id="items_tab">
<h1>Welcome ${sessionScope.nom} </h1>

${ searchTerm }

<% System.out.println(request.getAttribute("searchTerm")+" lllllllllllllllllllllllllllllllllll"); %>
<div  >

<form  action="Controller" method="post">
        <input type="hidden" name='actionControl' value="searchform">
         <input type="hidden" name='searchfrom' value="searchfromitem">
       <input type="text"  name="searchTerm">
      <button type="submit">Search</button>
    </form>
    

</div>
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
      
      

    </tr>
  </thead>
  <tbody>
  	<% ResultSet rs_it=SelectOP.getData("select * from items i,category c,provider p where i.category_id=c.category_id and i.provider_id = p.provider_id");
 
  		 try{

  	     while(rs_it.next()){

  	    	 out.print("<tr><td>"+rs_it.getString(1)+"</td><td>"+rs_it.getString(3)+"</td><td>"+rs_it.getString(2)+"</td><td>"+rs_it.getString(4)+"</td><td>"+rs_it.getString(5)+"</td><td>"+rs_it.getString(13)+"</td><td>"+rs_it.getString(10)+"</td><td>"+rs_it.getString(8)+"</td></tr>");   	 
  	    	
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

<form  action="Controller" method="post">
        <input type="hidden" name='actionControl' value="searchform">
         <input type="hidden" name='searchfrom' value="searchfromproviders">
       <input type="text"  name="searchTerm">
      <button type="submit">Search for providers</button>
    </form>
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
      
    </tr>
  </thead>
  <tbody>
  	<% ResultSet rsp=SelectOP.getData("Select * from Provider order by provider_id");
  		try{ 
  	     while(rsp.next())
  	     {
  	    	 out.print("<tr><td>"+rsp.getString(1)+"</td><td>"+rsp.getString(2)+"</td><td>"+rsp.getString(3)+"</td><td>"+rsp.getString(4)+"</td><td>"+rsp.getString(5)+"</td></tr>");
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

<form  action="Controller" method="post">
        <input type="hidden" name='actionControl' value="searchform">
         <input type="hidden" name='searchfrom' value="searchfromcategory">
       <input type="text"  name="searchTerm">
      <button type="submit">Search for category</button>
    </form>

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
      
    </tr>
  </thead>
  <tbody>
  
  <%
  
  	ResultSet rsch=SelectOP.getData("Select * from category order by Category_ID");
  		try{ 
  	     while(rsch.next())
  	     {
  	    	 out.print("<tr><td>"+rsch.getString(1)+"</td><td>"+rsch.getString(2)+"</td><td>"+rsch.getString(3)+"</td><td></td></tr>");
	     }
  	   rsch.close();
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
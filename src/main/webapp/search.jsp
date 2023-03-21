<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search page</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/search.css" />
<body>
<%@ page import="java.sql.*" %>
<%@ page import="Connection.DBconnection" %>
<%@ page import="Connection.SelectOP" %>
<%@ include file = "searchnav.jsp" %>


<%

HttpSession Session = request.getSession(false);

if(Session == null || session.getAttribute("nom") != null &&  session.getAttribute("type").equals("Employee")) {
	System.out.println("working");
	
} else{
	System.out.print(Session.isNew());
	request.getRequestDispatcher("/login.jsp").forward(request, response);
}
%>




<%
if(request.getAttribute("searchfrom").equals("searchfromitem")){
	
	System.out.println(request.getAttribute("searchfrom")+" lllllllllllllllllllllllllllllllllll");

ResultSet rs_it=SelectOP.getData("SELECT * FROM items WHERE UPPER(item_name) LIKE UPPER('%" + request.getAttribute("searchTerm") + "%')");
int count  = 0 ;

	try {
	    if (rs_it.next()) {
	        out.print("<table><tr><th>Item_ID</th><th>Item_Name</th><th>Item_price</th><th>Item_weight</th><th>Item_QTY</th><th>Description</th></tr>");
	        do {
	            out.print("<tr><td>"+rs_it.getString(1)+"</td><td>"+rs_it.getString(3)+"</td><td>"+rs_it.getString(2)+"</td><td>"+rs_it.getString(4)+"</td><td>"+rs_it.getString(5)+"</td><td>"+rs_it.getString(8)+"</td></tr>");
	        } while (rs_it.next());
	        out.print("</table>");
	    } else {
	        out.print(" <h1> No item is found !!! </h1>");
	    } 
	rs_it.close();
	}catch(Exception e){
		System.out.println(e);
	}  	
}else if(request.getAttribute("searchfrom").equals("searchfromproviders")){
	System.out.println(request.getAttribute("searchfrom")+" bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
	
	ResultSet rs_it=SelectOP.getData("SELECT * FROM Provider WHERE UPPER(Provider_Name) LIKE UPPER('%" + request.getAttribute("searchTerm") + "%')");
	int count  = 0 ;

		try {
		    if (rs_it.next()) {
		        out.print("<table><tr><th>Provider_ID</th><th>Provider_Name</th><th>Provider_Compagnie</th><th>Provider_Age</th><th>Provider_address</th> </tr>");
		        do {
		            out.print("<tr><td>"+rs_it.getString(1)+"</td><td>"+rs_it.getString(2)+"</td><td>"+rs_it.getString(3)+"</td><td>"+rs_it.getString(4)+"</td><td>"+rs_it.getString(5)+"</td></tr>");
		        } while (rs_it.next());
		        out.print("</table>");
		    } else {
		        out.print(" <h1> No item is found !!! </h1>");
		    } 
		rs_it.close();
		}catch(Exception e){
			System.out.println(e);
		}  	
	
}
else if(request.getAttribute("searchfrom").equals("searchfromcategory")){
	System.out.println(request.getAttribute("searchfrom")+" cccccccccccccccccccccccccccccccccccccccc"+request.getAttribute("searchTerm") );
	
	ResultSet rs_it=SelectOP.getData("SELECT * FROM Category WHERE UPPER(Category_Name) LIKE UPPER('%" + request.getAttribute("searchTerm") + "%')");
	int count  = 0 ;

		try {
		    if (rs_it.next()) {
		        out.print("<table><tr><th>Category_ID</th><th>Category_Name</th><th>Category_Description</th></tr>");
		        do {
		            out.print("<tr><td>"+rs_it.getString(1)+"</td><td>"+rs_it.getString(2)+"</td><td>"+rs_it.getString(3)+"</td></tr>");
		        } while (rs_it.next());
		        out.print("</table>");
		    } else {
		        out.print(" <h1> No item is found !!! </h1>");
		    } 
		rs_it.close();
		}catch(Exception e){
			System.out.println(e);
		}  
}

%>
  </tbody>
</table>

</body>
</html>
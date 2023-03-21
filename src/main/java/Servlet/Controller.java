package Servlet;

import jakarta.servlet.ServletException;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import Bean.Items;
import Bean.category;
import Bean.employees;
import Bean.provider;

import java.sql.*;
import Connection.SelectOP;
import Connection.Transactions;
/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String logout =request.getParameter("logout");
		String name=request.getParameter("name");
		String type=request.getParameter("type");

		HttpSession Session = request.getSession(false);
		if(logout.equals("logout")) {
			System.out.println("logout");
            try {
    	        String Query="insert into Logs values (sequence_logs.nextval,TO_DATE('"+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now())+"','dd/MM/yyyy HH24:mi:ss'),'"+type+" "+name+" Logged out at"+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now())+"')";
    	        Transactions.DATA(Query,"Log Added Successfully");
		} catch (Exception e) {
	        System.out.println(e);
	 
		}
			Session.invalidate();
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actioncontrol = request.getParameter("actionControl");
		switch (actioncontrol) {
		case "login":{
			
			String nom=request.getParameter("nom");
			String password=request.getParameter("password");
			String type=request.getParameter("type");
			
	        switch(type) {

	        case "Admin":{

	        	ResultSet log=SelectOP.getData("select * from Gestion_EMP");
	        	HttpSession session ;	
	        	try {
					while(log.next()) {
						System.out.println(" from Admin "+nom+" "+password+" "+type);
						System.out.println(log.getString(2)+" "+log.getString(3)+" "+log.getString(4));
						if(log.getString(2).equals(nom) && log.getString(3).equals(password) && log.getString(4).equals(type)) {
//	    				Cookie cookie = new Cookie("nom",nom);
//	    				cookie.setMaxAge(60);
//	    				response.addCookie(cookie);
							session = request.getSession(true);
							session.setAttribute("nom", nom);
							session.setAttribute("type", type);
				            try {
					    	        String Query="insert into Logs values (sequence_logs.nextval,TO_DATE('"+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now())+"','dd/MM/yyyy HH24:mi:ss'),'Admin "+nom+" Logged in at "+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now())+"')";
					    	        Transactions.DATA(Query,"Log Added Successfully");
							} catch (Exception e) {
						        System.out.println(e);
						 
							}
							request.getRequestDispatcher("/Admin.jsp").forward(request, response);;
						}else {
							request.getRequestDispatcher("/login.jsp").forward(request, response);
						}
					}
				} catch (SQLException  e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	break;
	        }
	        case "Employee":{

	        	ResultSet log=SelectOP.getData("select * from Gestion_EMP");
	        	HttpSession session ;	
	        	
	        		try {
						while(log.next()) {
							System.out.println(" from emp "+nom+" "+password+" "+type);
							System.out.println(log.getString(2)+" "+log.getString(3)+" "+log.getString(4));
				if(log.getString(2).equals(nom) && log.getString(3).equals(password) && log.getString(4).equals(type)) {
//					Cookie cookie = new Cookie("nom",nom);
//					cookie.setMaxAge(60*60);
//					response.addCookie(cookie);
						session = request.getSession(true);
						session.setAttribute("nom", nom);
						session.setAttribute("type", type);
			            try {
			    	        String Query="insert into Logs values (sequence_logs.nextval,TO_DATE('"+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now())+"','dd/MM/yyyy HH24:mi:ss'),'Employee "+nom+" Logged in at "+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now())+"')";
			    	        Transactions.DATA(Query,"Log Added Successfully");
					} catch (Exception e) {
				        System.out.println(e);
				 
					}
						request.getRequestDispatcher("/Employee.jsp").forward(request, response);
}
     	else {
						request.getRequestDispatcher("/login.jsp");
}
						}
					} catch (SQLException  e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	
	        	break;
	        }
	        case "Sous Admin":{
	        	ResultSet log=SelectOP.getData("select * from Gestion_EMP");
	        	HttpSession session ;	
	        		try {
						while(log.next()) {
							System.out.println(" from sous_admin "+nom+" "+password+" "+type);
							System.out.println(log.getString(2)+" "+log.getString(3)+" "+log.getString(4));
					if(log.getString(2).equals(nom) && log.getString(3).equals(password) && log.getString(4).equals(type)) {
//	 				Cookie cookie = new Cookie("nom",nom);
//	 				cookie.setMaxAge(60*60);
//	 				response.addCookie(cookie);
						session = request.getSession(true); 	
						session.setAttribute("nom", nom);
						session.setAttribute("type", type);
			            try {
			    	        String Query="insert into Logs values (sequence_logs.nextval,TO_DATE('"+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now())+"','dd/MM/yyyy HH24:mi:ss'),'Sous_Admin "+nom+" Logged in at "+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now())+"')";
			    	        Transactions.DATA(Query,"Log Added Successfully");
					} catch (Exception e) {
				        System.out.println(e);
				 
					}
						request.getRequestDispatcher("/index.jsp").forward(request, response);
	}else {
						request.getRequestDispatcher("/login.jsp");
}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	
	        	break;
	        }  
	        }
			
			break;
		}
		case "Itemform": {
			
			Boolean isvalid=false;
			
			Items item = new Items();
	        item.setItem_Name(request.getParameter("ItemName"));
	        item.setItem_price(Integer.valueOf(request.getParameter("Item_price")));
	        item.setItem_weight(Integer.valueOf(request.getParameter("weight")));
	        item.setItem_QTY(Integer.valueOf(request.getParameter("quantity")));
	        ResultSet provider_id=SelectOP.getData("select provider_id from provider where upper(provider_name)like upper('"+request.getParameter("Provider")+"')");
	        try {
	     	     while(provider_id.next())
	     	     {
				item.setProvider_id(provider_id.getInt(1));
		      }

			} catch (SQLException e) {

				e.printStackTrace();
			}

	        ResultSet category_id=SelectOP.getData("select category_id from category where upper(category_name)like upper('"+request.getParameter("Category")+"')");
	        try {
	    	     while(category_id.next()) {

				item.setCategory_id(category_id.getInt(1));}
			} catch (SQLException err) {
				err.printStackTrace();
			}    
	        item.setDescritpion(request.getParameter("description"));
	        
	        String nom = request.getParameter("nom");
	        String type =request.getParameter("type");
 
            try {
    	        String Query="insert into items values (sequence_items.nextval,"+item.getItem_price()+",'"+item.getItem_Name()+"','"+item.getItem_weight()+"','"+item.getItem_QTY()+"','"+item.getProvider_id()+"','"+item.getCategory_id()+"','"+item.getDescritpion()+"')" ;
    	        Transactions.DATA(Query,"Item Added Successfully");
    	        isvalid=true;
			} catch (Exception e) {
		        System.out.println(e);
		 
			}
            System.out.println(Transactions.IsValid);
            if (Transactions.IsValid) {
	            try {
	    	        String Query="insert into Logs values (sequence_logs.nextval,TO_DATE('"+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now())+"','dd/MM/yyyy HH24:mi:ss'),'"+type+" "+nom+" Added item "+item.getItem_Name()+" at "+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now())+"')";
	    	        Transactions.DATA(Query,"Log Added Successfully");
			} catch (Exception e) {
		        System.out.println(e);
		 
			}
            	response.sendRedirect("index.jsp");

			}
            else {
            	response.sendRedirect("Error.jsp");
            }
			break;
			}
			case "Providerform": {
				
				Boolean isValid= false;
				 provider pr = new provider();

				 pr.setProvider_name(request.getParameter("Provider_Name"));

				 pr.setProvider_age(Integer.valueOf(request.getParameter("Provider_Age")));

				 pr.setProvider_address(request.getParameter("Provider_address"));

				 pr.setCompany_name(request.getParameter("Provider_company"));
				 
			        String nom = request.getParameter("nom");
			        String type =request.getParameter("type");
				 try {
				String Query2="insert into provider values (sequence_provider.nextval,'"+pr.getProvider_name()+"','"+pr.getCompany_name()+"',"+pr.getProvider_age()+",'"+pr.getProvider_address()+"')" ;
				 Transactions.DATA(Query2,"Provider Added Successfully");
				  	        }
		catch (Exception e) {
			System.out.println(e);
			 		}
			if(Transactions.IsValid) {
	            try {
	    	        String Query="insert into Logs values (sequence_logs.nextval,TO_DATE('"+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now())+"','dd/MM/yyyy HH24:mi:ss'),'"+type+" "+nom+" Added provider "+pr.getProvider_name()+" at "+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now())+"')";
	    	        Transactions.DATA(Query,"Log Added Successfully");
			} catch (Exception e) {
		        System.out.println(e);
		 
			}
						 response.sendRedirect("index.jsp");
					 }else {
						 response.sendRedirect("Error.jsp");
					 }
			break;
			}
			case "AddCategory":{
				category ct = new category();
				ct.setCategory_name(request.getParameter("Category_Name"));
				ct.setCategory_description(request.getParameter("Category_Description"));
		        String nom = request.getParameter("nom");
		        String type =request.getParameter("type");

				 try {
						String Query3="insert into Category values (sequence_category.nextval,'"+ct.getCategory_name()+"','"+ct.getCategory_description()+"')" ;
						 Transactions.DATA(Query3,"category Added Successfully");
						  	        }
				catch (Exception e) {
					System.out.println(e);
				}
					if(Transactions.IsValid) {
			            try {
			    	        String Query="insert into Logs values (sequence_logs.nextval,TO_DATE('"+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now())+"','dd/MM/yyyy HH24:mi:ss'),'"+type+" "+nom+" Added category "+ct.getCategory_name()+" at "+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now())+"')";
			    	        Transactions.DATA(Query,"Log Added Successfully");
					} catch (Exception e) {
				        System.out.println(e);
				 
					}
								 response.sendRedirect("index.jsp");
							 }else {
								 response.sendRedirect("Error.jsp");
							 }
				break;
			}
			
			case "deleteid":{
				int deleteID= Integer.valueOf(request.getParameter("idvalue"));
				String deletfrom=request.getParameter("deletfrom");
	        	HttpSession session ;	

				session = request.getSession(true);
				String nom=(String)session.getAttribute("nom");
				String type=(String)session.getAttribute("type");
				if(deletfrom.equals("deletefromitems")) {

					try {
				        String Query="DELETE FROM items where item_id="+deleteID;
				        Transactions.DATA(Query,"Item Deleted Successfully");

					} catch (Exception e) {
						System.out.println(e);
					}
					if(Transactions.IsValid) {

			            try {
			    	        String Query="insert into Logs values (sequence_logs.nextval,TO_DATE('"+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now())+"','dd/MM/yyyy HH24:mi:ss'),'"+type+" "+nom+" deleted item_ID "+deleteID+" at "+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now())+"')";
			    	        Transactions.DATA(Query,"Log Added Successfully");
					} catch (Exception e) {
				        System.out.println(e);
				 
					}
						 response.sendRedirect("index.jsp");
					 }else {
						 response.sendRedirect("Error.jsp");
					 }
	            	
				}
				else if(deletfrom.equals("deletefromprov")) {

					try {
				        String Query="DELETE FROM Provider where Provider_ID="+deleteID;
				        Transactions.DATA(Query,"provider Deleted Successfully");

					} catch (Exception e) {
						System.out.println(e);
					}
					if(Transactions.IsValid) {
			            try {
			    	        String Query="insert into Logs values (sequence_logs.nextval,TO_DATE('"+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now())+"','dd/MM/yyyy HH24:mi:ss'),'"+type+" "+nom+" deleted provider_ID "+deleteID+" at "+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now())+"')";
			    	        Transactions.DATA(Query,"Log Added Successfully");
					} catch (Exception e) {
				        System.out.println(e);
				 
					}
						 response.sendRedirect("index.jsp");
					 }else {
						 response.sendRedirect("Error.jsp");
					 }	            	
				}
				else if(deletfrom.equals("deletefromcat")) {
					try {
				        String Query="DELETE FROM category where category_id="+deleteID;
				        Transactions.DATA(Query,"category Deleted Successfully");

					} catch (Exception e) {
						System.out.println(e);
					}
					if(Transactions.IsValid) {
			            try {
			    	        String Query="insert into Logs values (sequence_logs.nextval,TO_DATE('"+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now())+"','dd/MM/yyyy HH24:mi:ss'),'"+type+" "+nom+" deleted category_ID "+deleteID+" at "+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now())+"')";
			    	        Transactions.DATA(Query,"Log Added Successfully");
					} catch (Exception e) {
				        System.out.println(e);
				 
					}
						 response.sendRedirect("index.jsp");
					 }else {
						 response.sendRedirect("Error.jsp");
					 }
				}

				else if(deletfrom.equals("deletefromemp")) {
					try {

					String Query="DELETE FROM Gestion_EMP where emp_id="+deleteID;

					Transactions.DATA(Query,"employee Deleted Successfully");

					} catch (Exception e) {

					System.out.println(e);

					}
					if(Transactions.IsValid) {
			            try {
			    	        String Query="insert into Logs values (sequence_logs.nextval,TO_DATE('"+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now())+"','dd/MM/yyyy HH24:mi:ss'),'"+type+" "+nom+" deleted employee_ID "+deleteID+" at "+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now())+"')";
			    	        Transactions.DATA(Query,"Log Added Successfully");
					} catch (Exception e) {
				        System.out.println(e);
				 
					}
					response.sendRedirect("Admin.jsp");

					}else {

					response.sendRedirect("Error.jsp");

					}

					}
				break;
			}
			
			case "updateeid":{
				
				int updateID= Integer.valueOf(request.getParameter("idvalue"));
				request.setAttribute("updateid", updateID);
				
				if(request.getParameter("updatefrom").equals("updatefromitems")) {
					ResultSet rsite=SelectOP.getData("Select * from items where item_id="+ updateID +" ");
					try {
						while(rsite.next()) {
							request.setAttribute("ItemName", rsite.getString(3));
							request.setAttribute("Item_price", rsite.getString(2));
							request.setAttribute("weight", rsite.getString(4));
							request.setAttribute("quantity", rsite.getString(5));
							request.setAttribute("description", rsite.getString(8));
							}

						}catch(SQLException e) {
							e.printStackTrace();
						}
					request.setAttribute("nom", request.getParameter("nom"));
					request.setAttribute("type", request.getParameter("type"));
					
					request.getRequestDispatcher("update_item.jsp").forward(request, response);
					System.out.println(updateID+" cn");
				}else if(request.getParameter("updatefrom").equals("updatefromprov")) {
					
					ResultSet rspro=SelectOP.getData("Select * from provider where Provider_ID="+ updateID +" ");
					try {
						while(rspro.next()) {
							request.setAttribute("provname", rspro.getString(2));
							request.setAttribute("provcomp", rspro.getString(3));
							request.setAttribute("provage", rspro.getString(4));
							request.setAttribute("provadd", rspro.getString(5));
						}
						rspro.close();
					} catch (SQLException e) {
					
						e.printStackTrace();
					}
					request.setAttribute("nom", request.getParameter("nom"));
					request.setAttribute("type", request.getParameter("type"));
					request.getRequestDispatcher("update_provider.jsp").forward(request, response);
					System.out.println(updateID+" cn");
				}
			else if(request.getParameter("updatefrom").equals("updatefromcat")) {
				
				ResultSet rscat=SelectOP.getData("Select * from category where Category_ID="+ updateID +" ");
				try {
					while(rscat.next()) {
						request.setAttribute("catname", rscat.getString(2));
						request.setAttribute("catedesc", rscat.getString(3));
						
					}
					rscat.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
				request.setAttribute("nom", request.getParameter("nom"));
				request.setAttribute("type", request.getParameter("type"));
				request.getRequestDispatcher("update_category.jsp").forward(request, response);
				System.out.println(updateID+" cn");
			}
				
			else if(request.getParameter("updatefrom").equals("updatefromemp")) {

				

				ResultSet rsempp=SelectOP.getData("Select * from Gestion_EMP where emp_id="+ updateID +" ");

				try {

				while(rsempp.next()) {

				request.setAttribute("empname", rsempp.getString(2));

				request.setAttribute("emppass", rsempp.getString(3));

				request.setAttribute("emptype", rsempp.getString(4));

				}

				rsempp.close();

				} catch (SQLException e) {


				e.printStackTrace();

				}

				request.setAttribute("nom", request.getParameter("nom"));
				request.setAttribute("type", request.getParameter("type"));
				
				request.getRequestDispatcher("update_emp.jsp").forward(request, response);

				System.out.println(updateID+" cn");

				}
			
				break;	
			}
			case "UpdateItemForm":{
				
				int updateIDForm= Integer.valueOf(request.getParameter("updateidjsp"));
				Items item = new Items();
		        item.setItem_Name(request.getParameter("ItemName"));
		        item.setItem_price(Integer.valueOf(request.getParameter("Item_price")));
		        item.setItem_weight(Integer.valueOf(request.getParameter("weight")));
		        item.setItem_QTY(Integer.valueOf(request.getParameter("quantity")));
		        item.setDescritpion(request.getParameter("description"));
				String nom=request.getParameter("nom");
				String type=request.getParameter("type");
		        ResultSet provider_id=SelectOP.getData("select provider_id from provider where upper(provider_name)like upper('"+request.getParameter("Provider")+"')");
		        try {
		     	     while(provider_id.next())
		     	     {
					item.setProvider_id(provider_id.getInt(1));
			      }

				} catch (SQLException e) {
				
					e.printStackTrace();
				}

		        ResultSet category_id=SelectOP.getData("select category_id from category where upper(category_name)like upper('"+request.getParameter("Category")+"')");
		        try {
		    	     while(category_id.next()) {

					item.setCategory_id(category_id.getInt(1));}
				} catch (SQLException err) {
					// TODO Auto-generated catch block
					err.printStackTrace();
				}
		        try {
		        String Qy="update items set Item_price="+item.getItem_price()+", Item_Name='"+item.getItem_Name()+"', Item_weight="+item.getItem_weight()+",Item_QTY="+item.getItem_QTY()+" , Provider_ID="+item.getProvider_id()+", Category_ID="+item.getCategory_id()+", Description='"+item.getDescritpion()+"' where Item_ID="+updateIDForm+"";
		        Transactions.DATA(Qy,"item updated Successfully");
		        }
			catch (Exception e) {
				System.out.println(e);
				
			}
		        if (Transactions.IsValid) {
		            try {
		    	        String Query="insert into Logs values (sequence_logs.nextval,TO_DATE('"+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now())+"','dd/MM/yyyy HH24:mi:ss'),'"+type+" "+nom+" Updated item "+item.getItem_Name()+" at "+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now())+"')";
		    	        Transactions.DATA(Query,"Log Added Successfully");
				} catch (Exception e) {
			        System.out.println(e);
			 
				}
	            	response.sendRedirect("index.jsp");

				}
	            else {
	            	response.sendRedirect("Error.jsp");
	            }

				break;
			}
			case "updateProviderform":{
				int updateIDForm= Integer.valueOf(request.getParameter("updateidjsp"));
				
				provider pr= new provider();
				pr.setProvider_name(request.getParameter("Provider_Name"));
				pr.setCompany_name(request.getParameter("Provider_company"));
				pr.setProvider_age(Integer.valueOf(request.getParameter("Provider_Age")));
				pr.setProvider_address(request.getParameter("Provider_address"));
				String nom=request.getParameter("nom");
				String type=request.getParameter("type");
				try {
					
					String qp="update provider set Provider_Name='"+pr.getProvider_name()+"',Provider_Compagnie='"+pr.getCompany_name()+"',Provider_Age="+pr.getProvider_age()+",Provider_address='"+pr.getProvider_address()+"' where Provider_ID="+updateIDForm+"";
					 Transactions.DATA(qp,"provider updated Successfully");
				}catch(Exception e) {
					e.printStackTrace();
				}
				System.out.println(Transactions.IsValid);
				if (Transactions.IsValid) {
		            try {
		    	        String Query="insert into Logs values (sequence_logs.nextval,TO_DATE('"+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now())+"','dd/MM/yyyy HH24:mi:ss'),'"+type+" "+nom+" Updated provider "+pr.getProvider_name()+" at "+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now())+"')";
		    	        Transactions.DATA(Query,"Log Added Successfully");
				} catch (Exception e) {
			        System.out.println(e);
			 
				}
	            	response.sendRedirect("index.jsp");
				}
	            else {
	            	response.sendRedirect("Error.jsp");

	            }
				break;
			}
			case "updateCategory":{
				int updateIDForm= Integer.valueOf(request.getParameter("updateidjsp"));
				
				category ct= new category();
				ct.setCategory_name(request.getParameter("Category_Name"));
				ct.setCategory_description(request.getParameter("Category_Description"));
				String nom=request.getParameter("nom");
				String type=request.getParameter("type");

				try {
					
					String qc="update category set Category_Name='"+ct.getCategory_name()+"',Category_Description='"+ct.getCategory_description()+"'where Category_ID="+updateIDForm+"";
					 Transactions.DATA(qc,"category updated Successfully");
				}catch(Exception e) {
					e.printStackTrace();
				}
				System.out.println(Transactions.IsValid);
				if (Transactions.IsValid) {
		            try {
		    	        String Query="insert into Logs values (sequence_logs.nextval,TO_DATE('"+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now())+"','dd/MM/yyyy HH24:mi:ss'),'"+type+" "+nom+" Updated category "+ct.getCategory_name()+" at "+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now())+"')";
		    	        Transactions.DATA(Query,"Log Added Successfully");
				} catch (Exception e) {
			        System.out.println(e);
			 
				}
	            	response.sendRedirect("index.jsp");
				}
	            else {
	            	response.sendRedirect("Error.jsp");

	            }
				break;
			}
			case "searchform":{
				 String searchTerm = request.getParameter("searchTerm");
	    	    	System.out.print(searchTerm);
	    	    	String searchfrom = request.getParameter("searchfrom");
	    	    	
	    	    	request.setAttribute("searchTerm", searchTerm);
	    	    	request.setAttribute("searchfrom", searchfrom);
	    	    	
	    	    	request.getRequestDispatcher("search.jsp").forward(request, response);
	    	    	
	    	    

//			     ResultSet rs=SelectOP.getData("SELECT item_name, item_price, item_qty FROM items WHERE UPPER(item_name) LIKE UPPER('%" + searchTerm + "%')");	 
//			     try {
//			    	  while (rs.next()) {
//				           System.out.print("<tr>");
//				           System.out.print("<td>" + rs.getString("item_name") + "</td>");
//				           System.out.print("<td>" + rs.getDouble("item_price") + "</td>");
//				           System.out.print("<td>" + rs.getInt("item_qty") + "</td>");
//				           System.out.print("</tr>");
//				       }
//						
//					} catch (SQLException err) {
//						// TODO Auto-generated catch block
//						err.printStackTrace();
//					}
			     
			     break; 	 
			}
			case "addempform": {
				employees emp = new employees();

				emp.setEmp_name(request.getParameter("EmpName"));
				emp.setEmp_password(request.getParameter("Emp_password"));
				emp.setEmp_type(request.getParameter("selectName"));
				String nom=request.getParameter("nom");
				String type=request.getParameter("type");

				try {
				String Query="insert into Gestion_EMP values (sequence_emp.nextval,'"+emp.getEmp_name()+"','"+emp.getEmp_password()+"','"+emp.getEmp_type()+"')" ;
				Transactions.DATA(Query,"employee Added Successfully");

				} catch (Exception e) {
				System.out.println(e);
				}
				System.out.println(Transactions.IsValid);

				if (Transactions.IsValid) {
		            try {
		    	        String Query="insert into Logs values (sequence_logs.nextval,TO_DATE('"+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now())+"','dd/MM/yyyy HH24:mi:ss'),'"+type+" "+nom+" Added "+emp.getEmp_type()+" "+emp.getEmp_name() +" at "+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now())+"')";
		    	        Transactions.DATA(Query,"Log Added Successfully");
				} catch (Exception e) {
			        System.out.println(e);
			 
				}
				response.sendRedirect("Admin.jsp");

				}
				else {

				response.sendRedirect("Error.jsp");

				}
				break;
				}
			
			case "Updateemp":{
				int updateIDForm= Integer.valueOf(request.getParameter("updateidjsp"));

				employees employees = new employees();

				employees.setEmp_name(request.getParameter("empname"));

				employees.setEmp_password(request.getParameter("emppass"));

				employees.setEmp_type(request.getParameter("emptype"));
				String nom=request.getParameter("nom");
				String type=request.getParameter("type");

				try {

				String Qy="update Gestion_EMP set emp_Name='"+employees.getEmp_name()+"', emp_password='"+employees.getEmp_password()+"',emp_type='"+employees.getEmp_type()+"' where emp_id="+updateIDForm+"";

				Transactions.DATA(Qy,"employee updated Successfully");
				}
				catch (Exception e) {
				System.out.println(e);
				}

				if (Transactions.IsValid) {
		            try {
		    	        String Query="insert into Logs values (sequence_logs.nextval,TO_DATE('"+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now())+"','dd/MM/yyyy HH24:mi:ss'),'"+type+" "+nom+" updated "+employees.getEmp_type()+" "+employees.getEmp_name() +" at "+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now())+"')";
		    	        Transactions.DATA(Query,"Log Added Successfully");
				} catch (Exception e) {
			        System.out.println(e);
			 
				}

				response.sendRedirect("Admin.jsp");

				}

				else {

				response.sendRedirect("Error.jsp");

				}
				break;

				}
			
		default:
			throw new IllegalArgumentException("Unexpected value: " + actioncontrol);
			
		}
//		doGet(request, response);
	}

}

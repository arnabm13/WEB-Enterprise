package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import bean.*;
import model.*;

public class loginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
      public static Boolean status_guest=false;
	 HashMap <String,CustomerDetails> customerdetails = new HashMap <String,CustomerDetails>() ;
	 
	 public loginServlet()
	 {
       
        
     }
	 
	 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
	processRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
		
		
	    processRequest(request,response);
             
	
	}
	 
		
		
		
	
	protected void processRequest(HttpServletRequest request, 
            HttpServletResponse response)
    throws ServletException, IOException 
	{
		
		String reqtype = request.getParameter("reqtype").toString();
		
		
		switch(reqtype)
			{
				case "login":
				{
					login(request,response);
					break;
				}
				
				case "Signup":
				{
					Signup(request,response);
					break;
				}
				
				default:
				{
					break;
				}
			}
			
	}
	
	public void login(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		customerdetails=MySqlDataStoreUtilities.getUsers();

		PrintWriter out = response.getWriter();		
		response.setContentType("text/html");
		System.out.println(request.getParameter("uname"));
		String temp1=request.getParameter("uname");
		String temp2=request.getParameter("psw");
		//String userid=request.getParameter("userid");
		String check=request.getParameter("submit");
		Float price1,price2,totalprice;
		String fid1,fid2,depart,ret,fdep1,fdep2,farr1,farr2,fsource,fdest;
		Integer count;

		/*if (check.equals("Guest Login")){
            price1=Float.parseFloat(request.getParameter("pricef1"));
		    price2=Float.parseFloat(request.getParameter("pricef2"));
		    totalprice=Float.parseFloat(request.getParameter("Totalprice"));
		    fid1=request.getParameter("Fid1");
			fid2=request.getParameter("Fid2");
			depart=request.getParameter("depart");
			ret=request.getParameter("ret");
			fdep1=request.getParameter("Fdep1");
			fdep2=request.getParameter("Fdep2");
			farr1=request.getParameter("Farr1");
			farr2=request.getParameter("Farr2");
			fsource=request.getParameter("Fsource");
			fdest=request.getParameter("Fdest");
			count=Integer.parseInt(request.getParameter("count"));
		}*/
		
		String username=temp1.trim();
		String password=temp2.trim();
		
			
		if(customerdetails.containsKey(username))
		{
			
			String pass=(customerdetails.get(username)).pass;
			if(pass.equals(password))
			{
				//createSeession --
				//session.user = userdetail.get(uname);
				HttpSession session = request.getSession();
				 session.setAttribute("uname", customerdetails.get(username).uname);
				 session.setAttribute("utype", (customerdetails.get(username)).utype);

					if (check.equals("Guest Login")){
						price1=Float.parseFloat(request.getParameter("pricef1"));
					    price2=Float.parseFloat(request.getParameter("pricef2"));
					    totalprice=Float.parseFloat(request.getParameter("Totalprice"));
					    fid1=request.getParameter("Fid1");
						fid2=request.getParameter("Fid2");
						depart=request.getParameter("depart");
						ret=request.getParameter("ret");
						fdep1=request.getParameter("Fdep1");
						fdep2=request.getParameter("Fdep2");
						farr1=request.getParameter("Farr1");
						farr2=request.getParameter("Farr2");
						fsource=request.getParameter("Fsource");
						fdest=request.getParameter("Fdest");
			            count=Integer.parseInt(request.getParameter("count"));
						 session.setAttribute("price1",price1);
						 session.setAttribute("price2",price2);
						 session.setAttribute("totalprice",totalprice);
						 session.setAttribute("fid1",fid1);
						 session.setAttribute("fid2",fid2);
						 session.setAttribute("depart",depart);
						 session.setAttribute("ret",ret);
						 session.setAttribute("fdep1",fdep1);
						 session.setAttribute("fdep2",fdep2);
						 session.setAttribute("farr1",farr1);
						 session.setAttribute("farr2",farr2);
						 session.setAttribute("fsource",fsource);
						 session.setAttribute("fdest",fdest);
						 session.setAttribute("count",count);
						 session.setAttribute("check",check);
						}
			String name=String.valueOf(session.getAttribute("uname"));
			String type=(String)session.getAttribute("utype");
			switch(type)
			{
				case "STR_MGR":
				{
					response.sendRedirect("StoreManager.jsp");
					break;
				}
					
				case "CUST":
				{       if (check.equals("Guest Login")){
						response.sendRedirect("booking.jsp");

					} else{
					response.sendRedirect("Customer.jsp");
				          }
				}
				default:
				{
					
				}

			}
			}
		else{
			
			 String title = "Login Error";
				 String Error= "Login Error- Invalid Password ";
				 String docType =
				 "<!doctype html public \"-//w3c//dtd html 4.0 " +
				 "transitional//en\">\n";
				 out.println(docType +
				"<html>\n" +
				"<head><title>" + title + "</title></head>\n"+
				"<body bgcolor=\"#f0f0f0\">\n" +
				"<h1 align=\"center\">" + Error + "</h1>\n" +
				"<p><a href=\"index.jsp\">Try Login again </a>" + "</p>\n");
			}
		}
	else{
		
		 String title = "Login Error";
			 String Error= "Login Error- Invalid Username";
			 String docType =
			 "<!doctype html public \"-//w3c//dtd html 4.0 " +
			 "transitional//en\">\n";
			 out.println(docType +
			"<html>\n" +
			"<head><title>" + title + "</title></head>\n"+
			"<body bgcolor=\"#f0f0f0\">\n" +
			"<h1 align=\"center\">" + Error + "</h1>\n" +
			"<p><a href=\"login.html\">Try Login again </a>" + "</p>\n");
		
		}      	     
	}
	


public void Signup(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("In Registration");
		customerdetails=MySqlDataStoreUtilities.getUsers();
		
		String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String uname = request.getParameter("uname");
        String email = request.getParameter("email");
		String pass = request.getParameter("psw");
		String utype= request.getParameter("type");
		 
		if(uname != null && uname.length() != 0 && pass != null && pass.length() != 0) 
		{
			PrintWriter out = response.getWriter();		
			response.setContentType("text/html");
            
			if (customerdetails.containsKey(uname)) 
            {
            out.println("Username Already used");

			} 

            else 
            {
			System.out.println("In Registration-else");
			CustomerDetails user1=new CustomerDetails(fname,lname,email,uname,pass,utype);
			MySqlDataStoreUtilities.InsertUser(user1);
			response.sendRedirect("index.jsp");
				
		
			}	
		}
		}

}
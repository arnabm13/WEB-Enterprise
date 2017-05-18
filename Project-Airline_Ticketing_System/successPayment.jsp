<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Airline-ticket-booking - Home</title>
<link rel="stylesheet" href="styles.css" type="text/css" />

</head>
<body>
<%          
            response.setContentType("text/html");
			String userid=String.valueOf(session.getAttribute("uname"));
            session.setAttribute("uname",userid);


        out.println("<div id='header'>");																																																																													
		out.println("<a href='index.jsp' class='logo'><img src='images/logo.jpg' alt='' width='274' height='90' /></a>");																																								
	    out.println("<div class ='top'>");
        
		out.println("<span class ='account' id='account' style='float:right'><a>"+userid+"</a>|<a href='LogoutServlet.jsp'><button style='width:auto;'>Logout</button></a></span>");

		out.println("</div>");

			out.println("<ul id='menu'>");
			out.println("<li><a href='Customer.jsp'>Home</a></li>");
			out.println("<li><a href='Customer.jsp'>Flights & Deals</a></li>");
			out.println("<li><a href='OrderPage.jsp'>My Bookings</a></li>");
			out.println("<li><a href='AddReview.jsp'>Reviews</a></li>");
			out.println("<li><a href='Customer.jsp'>Contact us</a></li>");
		out.println("</ul>");
	out.println("</div>");
	 %>

<div id="container">


<%@ page import= "java.io.*"%>
<%@ page import= "javax.servlet.ServletException"%>
<%@ page import= "javax.servlet.annotation.WebServlet"%>
<%@ page import= "javax.servlet.http.HttpServlet"%>
<%@ page import= "javax.servlet.http.HttpServletRequest"%>
<%@ page import= "javax.servlet.http.HttpServletResponse"%>
<%@ page import= "java.util.Arrays"%>
<%@ page import= "java.util.List"%>
<%@ page import= "java.util.Set"%>
<%@ page import= "java.util.Date"%>
<%@ page import= "java.util.*"%>
<%@ page import= "javax.servlet.*"%>
<%@ page import= "javax.servlet.http.*"%>
<%@ page import= "bean.*"%>
<%@ page import= "model.*"%>


<%
	//HashMap<String, Flight> flightdetail = new HashMap<String, Flight>();
	try
		{

		Random rand = new Random();
		String  Bid = "B"+String.valueOf(rand.nextInt(1000) + 1);
		//PrintWriter out = response.getWriter();		
		response.setContentType("text/html");
		String fid1=request.getParameter("fid1");
		//String Uid=request.getParameter("uname");
		String fid2=request.getParameter("fid2");
		String depart=request.getParameter("depart");//date
		String ret=request.getParameter("ret");//date
		String dep1=request.getParameter("fdep1");
		String arr1=request.getParameter("fdep2");
		String dep2=request.getParameter("farr1");
		String arr2=request.getParameter("farr2");
		String place1=request.getParameter("fsource");
		String place2=request.getParameter("fdest");
		int count=Integer.parseInt(request.getParameter("count"));
		Float price1=Float.parseFloat(request.getParameter("price1"));
		Float price2=Float.parseFloat(request.getParameter("price2"));
		Float totalprice=Float.parseFloat(request.getParameter("totalprice"));
		Float totalprice1= Float.parseFloat(String.valueOf(count*price1));
		Float totalprice2= Float.parseFloat(String.valueOf(count*price2));
		String Ftype="Domestic";
		int rcount=MySqlDataStoreUtilities.selectRowCount();
		for( int i=1;i<=count;i++)
		{
			
			String Pname=request.getParameter("Pname"+i);
			Integer Page=Integer.parseInt(request.getParameter("Page"+i));
			String Psex=request.getParameter("Psex"+i);
			
			Integer Num=rcount+i;
			MySqlDataStoreUtilities.InsertBooking(Bid,Num,Pname,Page,Psex);
			

		}

		MySqlDataStoreUtilities.InsertOrder(Bid,fid1,userid,place1,place2,dep1,arr1,Ftype,totalprice1,count,depart);
		MySqlDataStoreUtilities.InsertOrder(Bid,fid2,userid,place2,place1,dep2,arr2,Ftype,totalprice2,count,ret);
		MySqlDataStoreUtilities.updateflightcount(fid1,depart);
		MySqlDataStoreUtilities.updateflightcount(fid2,ret);

		   out.println("<br><font color='DarkBlue'><b>Your booking has been done successfully.Your booking ID - "+Bid+".</font></b>"); 
		   out.println("<br><br>");
		   out.println("<a href='OrderPage.jsp'>Click here to view your booking.</a>");
		   //out.println(fid1);
		   //out.println(fid2);
		
		
		}
		catch(Exception e){}
%>
<%@include file="footer.jsp"%>
</body>
</html>
<%@page import="connectdb.*" %> 
<%@page import="medicinetrackerapplication.User" %> 
 <%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
try{
			String memail = request.getParameter("memail");
			Connection con = ConnectDB.connect();
			
			PreparedStatement ps13 = con.prepareStatement("update medicalforapproval_tbl set status=? where memail=?");
			ps13.setString(1,"approved");
			ps13.setString(2,memail);
			int j = ps13.executeUpdate();
	        if(j>0)
			{
				response.sendRedirect("MedicalToBeApproved.jsp");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
%>
</body>
</html>
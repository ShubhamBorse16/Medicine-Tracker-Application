<%@page import="connectdb.*" %> 
<%@page import="medicinetrackerapplication.User" %> 
<%@page import="java.sql.*" %>
<%@page import="java.time.LocalDate" %> 
<%@page import="java.time.temporal.ChronoUnit" %> 

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
        try {
            Connection con = ConnectDB.connect();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT medexpirydate FROM medicine_tbl");

            while (rs.next()) {
                LocalDate currentDate = LocalDate.now();
                LocalDate givenDate = rs.getDate("medexpirydate").toLocalDate();
                long diff = ChronoUnit.DAYS.between(currentDate, givenDate);
                
                // Update the diff and status for each row
                PreparedStatement ps11 = con.prepareStatement("UPDATE medicine_tbl SET diff=?, status=? WHERE medexpirydate=?");
                ps11.setLong(1, diff);
                ps11.setString(2, (diff < 90) ? "Needtobereplaced" : "");
                ps11.setDate(3, rs.getDate("medexpirydate"));
                ps11.executeUpdate();
            }

            response.sendRedirect("RemoveMedicine.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>
</body>
</html>

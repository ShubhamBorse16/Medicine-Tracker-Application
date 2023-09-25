package medicinetrackerapplication;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectdb.ConnectDB;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		try
		{
			Connection con=ConnectDB.connect();	
		String aname=request.getParameter("aname");
		String apassword=request.getParameter("apassword");	
		PreparedStatement ps1=con.prepareStatement("select * from admin_tbl where aname=? and apassword=?");
		ps1.setString(1,aname);
		ps1.setString(2,apassword);
		ResultSet rs=ps1.executeQuery();
		if(rs.next())
		{
			response.sendRedirect("adminpannel.html");
		}
		else
		{
			response.sendRedirect("adminlogin.html");
		}
		}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}

}

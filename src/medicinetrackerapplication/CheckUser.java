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
 * Servlet implementation class CheckUser
 */
@WebServlet("/CheckUser")
public class CheckUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUser() {
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
		try{
		int i=0;
			String uemail = request.getParameter("uemail");
			User.setEmail(uemail);
			String upassword = request.getParameter("upassword");
			String lat=request.getParameter("lat");
			String lng=request.getParameter("lng");
			User.setLatitude(lat);
			User.setLongitude(lng);
			System.out.println(User.getLatitude());
			
			Connection con = ConnectDB.connect();
			PreparedStatement ps1=con.prepareStatement("select * from user_tbl where uemail=? and upassword=?");
		    ps1.setString(1,uemail);	
			ps1.setString(2,upassword);
			PreparedStatement ps11=con.prepareStatement("update user_tbl set latitude=?,longitude=? where uemail=? and upassword=?");
		    ps11.setString(1,lat);	
			ps11.setString(2,lng);
			ps11.setString(3,uemail);	
			ps11.setString(4,upassword);
			ResultSet rs = ps1.executeQuery();
			i= ps11.executeUpdate();
			while(rs.next())
			{
				i=1;
			
			}
			if(i==1)
			{
				response.sendRedirect("userpannel.html");
			}
			else
			{
				response.sendRedirect("userlogin.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

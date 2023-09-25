package medicinetrackerapplication;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectdb.ConnectDB;


/**
 * Servlet implementation class AddForApproval
 */
@WebServlet("/AddForApproval")
public class AddForApproval extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddForApproval() {
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
			String mname = request.getParameter("mname");
			String moname = request.getParameter("moname");
			String mcontact = request.getParameter("mcontactnumber");
			String memail = request.getParameter("memail");
			String mpassword = request.getParameter("mpassword");
			String lat=request.getParameter("lat");
			String lng=request.getParameter("lng");
			Connection con =ConnectDB.connect();
			PreparedStatement ps1=con.prepareStatement("insert into medicalforapproval_tbl values (?,?,?,?,?,?,?,?,?)");
			ps1.setInt(1,0);
			ps1.setString(2,mname);
			ps1.setString(3,moname);
			ps1.setString(4,memail);	
			ps1.setString(5,mcontact);	
			ps1.setString(6,mpassword);	
			ps1.setString(7,"pending");	
			ps1.setString(8,lat);	
			ps1.setString(9,lng);	
			int i = ps1.executeUpdate();
			if(i==1)
			{
				response.sendRedirect("actiondone.html");
			}
			else
			{
				response.sendRedirect("registermedical.html");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

package medicinetrackerapplication;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectdb.ConnectDB;
import medicinetrackerapplication.User;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
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
			String uname = request.getParameter("uname");
			String uemail = request.getParameter("uemail");
			String umob= request.getParameter("umob");
			String uadress = request.getParameter("uadress");
			String lat=request.getParameter("lat");
			String lng=request.getParameter("lng");
			String upassword = request.getParameter("upassword");
			User.setName(uname);
			Connection con = ConnectDB.connect();
			PreparedStatement ps1=con.prepareStatement("insert into user_tbl values (?,?,?,?,?,?,?,?)");
			ps1.setInt(1,0);
			ps1.setString(2,uname);
			ps1.setString(3,uemail);
			ps1.setString(4,umob);
			ps1.setString(5,uadress);	
			ps1.setString(6,upassword);
			ps1.setString(7,lat);	
			ps1.setString(8,lng);
			
			int i = ps1.executeUpdate();
			if(i==1)
			{
				response.sendRedirect("Welcome.html");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

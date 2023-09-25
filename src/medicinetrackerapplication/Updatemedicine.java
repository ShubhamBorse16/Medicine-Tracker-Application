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

/**
 * Servlet implementation class Updatemedicine
 */
@WebServlet("/Updatemedicine")
public class Updatemedicine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updatemedicine() {
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
			String medname = request.getParameter("medname");
		
			String medprice= request.getParameter("medprice");
			String quantityavailable = request.getParameter("quantityavailable");
			Connection con = ConnectDB.connect();
			PreparedStatement ps1=con.prepareStatement("update medicine_tbl set medprice=?,quantityavailable=? where medname=?");
			ps1.setString(1,medprice);
			ps1.setString(2,quantityavailable);	
			ps1.setString(3,medname);	
			int i = ps1.executeUpdate();
			if(i==1)
			{
				response.sendRedirect("actiondone.html");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

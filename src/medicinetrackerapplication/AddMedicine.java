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
 * Servlet implementation class AddMedicine
 */
@WebServlet("/AddMedicine")
public class AddMedicine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMedicine() {
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
			String medbrandname = request.getParameter("medbrandname");
			String medprice= request.getParameter("medprice");
			String quantityavailable = request.getParameter("quantityavailable");
			String mname =User.getName();
			String medadddate = request.getParameter("medadddate");
			String medexpirydate = request.getParameter("medexpirydate");
		
			Connection con = ConnectDB.connect();
			
			PreparedStatement ps1=con.prepareStatement("insert into medicine_tbl values (?,?,?,?,?,?,?,?,?,?)");
			ps1.setInt(1,0);
			ps1.setString(2,medname);
			ps1.setString(3,medbrandname);
			ps1.setString(4,medprice);
			ps1.setString(5,quantityavailable);	
			ps1.setString(6,mname);
			ps1.setString(7,medadddate);
			ps1.setString(8,medexpirydate);
			ps1.setString(9,"0");
			ps1.setString(10,"-");
			System.out.println(mname);
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

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
 * Servlet implementation class BuyMedicines
 */
@WebServlet("/BuyMedicines")
public class BuyMedicines extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyMedicines() {
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
			String medname = request.getParameter("medname");
			String medprice= request.getParameter("medprice");
			String quantity = request.getParameter("quantity");
			String mname =request.getParameter("mname");
			String uadress =request.getParameter("uadress");
			Connection con = ConnectDB.connect();
			
			PreparedStatement ps1=con.prepareStatement("insert into order_tbl values (?,?,?,?,?,?,?,?)");
			ps1.setInt(1,0);
			ps1.setString(2,uname);
			ps1.setString(3,medname);
			ps1.setString(4,mname);
			ps1.setString(5,medprice);	
			ps1.setString(6,quantity);
			ps1.setString(7,"pending");
			ps1.setString(8,uadress);
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

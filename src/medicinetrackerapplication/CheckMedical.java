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
 * Servlet implementation class CheckMedical
 */
@WebServlet("/CheckMedical")
public class CheckMedical extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckMedical() {
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
				String memail = request.getParameter("memail");
				String mpassword = request.getParameter("mpassword");
				String mname=request.getParameter("mname");
                User.email=memail;
                User.setName(mname);
				Connection con = ConnectDB.connect();
				PreparedStatement ps1=con.prepareStatement("select * from medicalforapproval_tbl where memail=? and mpassword=? and status=?");
			    ps1.setString(1,memail);	
				ps1.setString(2,mpassword);
				ps1.setString(3,"approved");
				
				ResultSet rs = ps1.executeQuery();
				if(rs.next())
				{
					response.sendRedirect("medicalpannel.html");
				}
				else
				{
					response.sendRedirect("medicallogin.html");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}

}

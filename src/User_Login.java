

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/User_Login")
public class User_Login extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	Connection con=null;
	ResultSet rs=null;
	ResultSet rs1=null;

	PreparedStatement ps=null;
	PreparedStatement ps1=null;
	PrintWriter out=null;

	
	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);		
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");		
			    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/final_db_sf","root","");
				
			} 
			catch (ClassNotFoundException | SQLException e)
			{
			
				e.printStackTrace();
			}
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}
			
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		
		String uname=request.getParameter("uname");
		String password=request.getParameter("upwd");
		String role="temp";
		String city=null;
		String status=null;
		
		request.getSession().setAttribute("uname2",uname);
		int count=0;
		
		try {
			ps=con.prepareStatement("select * from users where username=? and password=?");
		//	ps1=con.prepareStatement("select city from users where username=?");
			ps.setString(1, uname);
			ps.setString(2, password);
			//ps1.setString(1, uname);
			rs=ps.executeQuery();	
			//rs1=ps1.executeQuery();
			while(rs.next())
			{
				role=rs.getString(15);
				city=rs.getString(6);
				status=rs.getString(10);
				count++;
			}
			
			
		
			
			if(count>0)
			{
					
				if(role.equals("user"))
				{
					request.getSession().setAttribute("city", city);
					//request.getSession().setAttribute("uid", rs.getInt(2));
					response.sendRedirect("http://localhost:8080/Smart_Finder/homeAfterLogin.jsp");
				}
				else
				{
					if(status.equals("pending"))
					{
						response.sendRedirect("http://localhost:8080/Smart_Finder/Login.jsp");
					}
					else
					{
						response.sendRedirect("http://localhost:8080/Smart_Finder/service_provider.jsp");
					}
				}
			}
					
			else{
					
					RequestDispatcher rd=request.getRequestDispatcher("/Login.jsp");
					rd.forward(request, response);
					//response.sendRedirect("http://localhost:8080/Online_Krushi_Product_System/seller.jsp");
				}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}

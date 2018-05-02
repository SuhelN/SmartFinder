

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.ParseConversionEvent;







@WebServlet("/sp_requirement")
public class requirement_serv extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	Connection con=null;
   
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");		
		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/new_smart_finder","root","");
			
		} 
		catch (ClassNotFoundException | SQLException e)
		{
		
			e.printStackTrace();
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
				//response.getWriter().append("Served at: ").append(request.getContextPath());
				doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		Date date = new Date();
		String con_type=request.getParameter("con_type");
		String comment=request.getParameter("comment");
		String name=request.getParameter("sp_name");
		String sp_id=("select sp_id from service_provider where sp_username=name");
		String d=date.toString();
		String uname=(String) request.getSession().getAttribute("sessname");
		//String u_id="select u_id from users where username=uname";
		
		
	
		PreparedStatement ps=null;
		HttpSession  session= request.getSession();
		
		
		
			try {
				ps=con.prepareStatement("insert into requirement (sp_id,date,description) values(?,?,?,?)");
				ps.setString(1,sp_id);
				//ps.setString(2,u_id);
				ps.setString(3,d);
				ps.setString(4,comment);
				int n=ps.executeUpdate();
				ps.close();
				
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			
			
			
			
		
	} 
	
}	



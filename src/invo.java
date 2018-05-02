

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/invo")
public class invo extends HttpServlet 
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
		int price=Integer.parseInt(request.getParameter("price"));
		/* HttpSession session=request.getSession(false);  
	        int uid=(int)session.getAttribute("uid");*/
		
		int uid=6;
		
		try {
			ps=con.prepareStatement("select * from request where u_id=?");
			ps.setInt(1, uid);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				ps=con.prepareStatement("insert into invoice(req_id,u_id,date,charges) values(?,?,?,?)");
				ps.setInt(1, rs.getInt(1));
				ps.setInt(2, uid);
				ps.setString(3,rs.getString(5));
				ps.setInt(4, price);
				
				ps.executeUpdate();

			}
			
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

}

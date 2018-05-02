

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


@WebServlet("/pestcontrolServ")
public class pestcontrolServ extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
   
	Connection con=null;
	ResultSet rs=null;
	ResultSet rs1=null;
	int uid=0;
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
		 //Date date = new Date();
		 /* start change data format*/
		 long millis=System.currentTimeMillis();  
	        java.sql.Date date=new java.sql.Date(millis);
		 /* end change data format*/
		 System.out.println("eth prynt ala ka");
		 
		 String sp=request.getParameter("sp_name");
		 String cont=request.getParameter("con_type");
		 
		System.out.println("SPPPPPP"+sp);
		System.out.println(sp);
		System.out.println("connnnnnnnn"+cont);
		
		
		 
			String u_name= (String) request.getSession().getAttribute("uname2");
			System.out.println("kashachi value="+u_name);
		
		String work_type= request.getParameter("pest_type");
		String area= request.getParameter("area");
		
		try {
			ps1=con.prepareStatement("select u_id from users where username=?");
			ps1.setString(1,u_name);
			ResultSet rs=ps1.executeQuery();
			
			while(rs.next())
			{
			 uid= rs.getInt(1);
			System.out.println("uid comes here ="+uid);
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		
		
		
		
		String service="pest Control";
		
		
		int total_price=100*Integer.parseInt(area);
		
	
		String datee=date.toString();
		
		System.out.println(datee);
		
		
		try {
			ps=con.prepareStatement("insert into request(u_id,service,date,con_type,sp_name,work_type,area,total_price) values(?,?,?,?,?,?,?,?)");
			ps.setInt(1,uid);
			ps.setString(2,service);
			ps.setString(3,datee);
			ps.setString(4,cont);
			ps.setString(5,sp);
			ps.setString(6,work_type);
			ps.setString(7,area);
			ps.setInt(8,total_price);

			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("http://localhost:8080/Smart_Finder/homeAfterLogin.jsp");
		
	
	}

}



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.relation.Role;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.ParseConversionEvent;







@WebServlet("/registration")
public class registration extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	Connection con=null;
   
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		con=(Connection)config.getServletContext().getAttribute("dbconnection");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
				response.getWriter().append("Served at: ").append(request.getContextPath());
				doGet(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			
		String fname=request.getParameter("sp_fname");
		String lname=request.getParameter("sp_lname");
		String email=request.getParameter("sp_email");
		String uname=request.getParameter("sp_uname");
		String pwd=request.getParameter("pwd");
		String cno=request.getParameter("sp_cnumber");
		String address=request.getParameter("sp_address");
		String city=request.getParameter("sp_city");
		String question=request.getParameter("question");
		String answer=request.getParameter("answer");
		String s_id=request.getParameter("sp_interest");
		String radio=request.getParameter("role");
		
		
		PrintWriter out=response.getWriter();
		int count=0;
		PreparedStatement ps,ps1;
		HttpSession  session= request.getSession();
		try
		{
			ps=con.prepareStatement("select * from users where email=?");
		ps.setString(1,email);
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			count++;
		}
		
		if(count>=1)
		{
	        session.setAttribute("already_exist","Username/EmailID Already Exist");  
			/*RequestDispatcher rd=request.getRequestDispatcher("/Register_Patient.jsp");
			rd.forward(request, response);*/
			request.getRequestDispatcher("/SignUp.jsp").include(request, response);
			
			/*Cookie c=new Cookie("already_exist","UsernameEmailIDAlreadyExit");
			response.addCookie(c);
			RequestDispatcher rd=request.getRequestDispatcher("/Register_Patient.jsp");
			rd.forward(request, response);*/
		}
		else
		{
			if(radio.equals("serviceprovider"))
			{
				ps=con.prepareStatement("insert into users (username,password,fname,lname,city,address,cno,service,status,email,question,answer,role) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,uname);
				ps.setString(2,pwd);
				ps.setString(3,fname);
				ps.setString(4,lname);
				ps.setString(5,city);	
				ps.setString(6,address);
				ps.setString(7,cno);
				ps.setString(8,s_id);
				ps.setString(9, "pending");
				ps.setString(10,email);
				ps.setString(11,question);
				ps.setString(12,answer);
		
				ps.setString(13, radio );
				
				
				int n=ps.executeUpdate();
				
				ps.close();
			}
			else
			{
				ps.close();
				if(radio.equals("customer"))
				{
					ps=con.prepareStatement("insert into users (username,password,fname,lname,city,address,cno,email,question,answer,role) values(?,?,?,?,?,?,?,?,?,?,?)");
					ps.setString(1,uname);
					ps.setString(2,pwd);
					ps.setString(3,fname);
					ps.setString(4,lname);
					ps.setString(5,city);	
					ps.setString(6,address);
					ps.setString(7,cno);
					ps.setString(8,email);
					ps.setString(9,question);
					ps.setString(10,answer);
			
					ps.setString(11, radio );
					
					
					int n=ps.executeUpdate();
					
					ps.close();
				
				ps.close();
				}
			}
		}
	} 
	catch (SQLException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}	
}


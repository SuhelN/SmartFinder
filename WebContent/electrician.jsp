<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<%ResultSet resultset =null;%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Electrician</title>
 <!-- css -->
<link href="css/slider.css" rel="stylesheet" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
</head>
<body>
	<header>
       <div align="right"> 
       <a href="http://localhost:8080/Smart_Finder/homeAfterLogin.jsp">Home</a>
       	<a href="http://localhost:8080/Smart_Finder/index.jsp"><button>Log Out</button></a>
       </div>
	</header>
	
	<h1 align="center">Electrician Service</h1>
	
	<!-- Slider -->
     <div id="cssSlider" align="center">
  <div id="sliderImages">
		<img id="si_1" src="img/client1.png" alt="" />
		<img id="si_2" src="img/client2.png" alt="" />
		<img id="si_3" src="img/client3.png" alt="" />
		
		<div style="clear:left;"></div>
	</div>
</div>
    
		
	<!-- end slider -->
	
	<!-- 	hide show jquery start -->
<script type="text/javascript">
    $(function () {
        $("#con_type").change(function () {
            if ($(this).val() == "new") {
                $("#model").show();
                $("#model2").hide();
            } else {
                $("#model").hide();
                 $("#model2").show(); 
            }
        });
    });
</script>
<!-- 	hide show jquery end -->
	<div align="center">
<form action="http://localhost:8080/Smart_Finder/electricianServ" method="post">
    <select name="con_type" id="con_type">
    <option value="new">New Connection</option>
    <option value="old">Old Connetion</option>
 </select>
 
 <select name="model" id="model">
    <option value="1BHK">1BHK</option>
    <option value="2BHK">2BHK</option>
     <option value="Bunglo">Bunglo</option>
 </select>
 <div name="model2" id="model2">
 <span>Mention your requirments</span><input type="text" name="requirement" id="requirement" />
    </div>
  <br><br>
  
  <%
  String ct=(String)request.getSession().getAttribute("city");
  System.out.println(ct);
  try 
	{
	  Connection con=null;
		ResultSet rs=null;
		Class.forName("com.mysql.jdbc.Driver");		
	    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/final_db_sf","root","");
	    Statement statement = con.createStatement() ;
	    resultset =statement.executeQuery("select * from users where service='electrician' and role='service_provider' and status='approved' and city='"+ct+"'") ;
	} 
	catch (ClassNotFoundException | SQLException e)
	{
	
		e.printStackTrace();
	}
  
  

 
  %>
  
 <br/> <br/>
 <select name="sp_name">
  <%  while(resultset.next()){ %>
  
      <option value="<%= resultset.getString(2)%>"><%=resultset.getString(2)%></option>
       
  <% }%>
  </select>
  <input type="submit" value="Submit" />
</form>
</div>
</body>


</html>
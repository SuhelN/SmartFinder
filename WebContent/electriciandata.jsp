<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Mechanic</h1>
<%
//String id = request.getParameter("userId");
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/final_db_sf";
//String dbName = "final_db_sf";
String userId = "root";
String password = "";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<h2 align="center"><font><strong>Retrieve data from database in jsp</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="#A52A2A">
<td><b>request id</b></td>
<td><b>user id</b></td>
<td><b>Service</b></td>
<td><b>Status</b></td>
<td><b>Date</b></td>
<td><b>Connection Type</b></td>
<td><b>Problem</b></td>
<td><b>Service Provider Name</b></td>
<td><b>Work Type</b></td>
<td><b>Area</b></td>
<td><b>Total Price</b></td>
</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM request where service='electrician'";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr bgcolor="#DEB887">

<td><%=resultSet.getString("req_id") %></td>
<td><%=resultSet.getString("u_id") %></td>
<td><%=resultSet.getString("service") %></td>
<td><%=resultSet.getString("status") %></td>
<td><%=resultSet.getString("date") %></td>
<td><%=resultSet.getString("con_type") %></td>
<td><%=resultSet.getString("problem") %></td>
<td><%=resultSet.getString("sp_name") %></td>
<td><%=resultSet.getString("work_type") %></td>
<td><%=resultSet.getString("area") %></td>
<td><%=resultSet.getString("total_price") %></td>

</tr>

<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</body>
</html>
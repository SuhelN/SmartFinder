<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<header>
        <div class="navbar navbar-default navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar "></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="homeAfterLogin.jsp"><img src="img/smartlogo.jpg" alt="logo"/></a>
                </div>
                <div class="navbar-collapse collapse " >
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="homeAfterLogin.jsp">Home</a></li> 
							 <li class="dropdown">
                        <a href="#" data-toggle="dropdown" class="dropdown-toggle">About Us <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="afterloginabout.jsp">Company</a></li>
                            
                        </ul>
                    </li>
						<li><a href="afterloginservices.jsp">Services</a></li> 
                        <li><a href="afterlogincontact.jsp">Contact</a></li>
                        <li><a href="Login.jsp">Log Out</a></li>
                        <!-- <li><a href="login/Login.jsp">Log In</a></li>
 -->                        
                    </ul>
                </div>
            </div>
        </div>
	</header>
</body>
</html>
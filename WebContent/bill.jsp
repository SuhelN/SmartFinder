<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Bill</h1>
	
<!-- Start	button for workdone -->
	<INPUT TYPE="BUTTON" VALUE="Button 1" ONCLICK="button1()">
	<SCRIPT LANGUAGE="JavaScript">
            
               function button1()
               {
                   document.form1.buttonName.value = "button 1"
                   form1.submit()
               }    
               
            
        </SCRIPT>
	<!-- end button for workdone -->
</body>
</html>
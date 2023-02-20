<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
    if(request.getParameter("username")=="bhagyashree" && request.getParameter("password")=="bhagyashree")
    {
    	response.setContentType("text/html");
    	out.write("Welcome to Learner's academy");
    
    }
%>
<form action="StudentRecordRetrieve">
Enter the class no: <input type="text" name="classname"><br/>
<h3> <input type="submit" value="click"></h3>
</form>
</body>
</html>
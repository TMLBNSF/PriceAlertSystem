<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:errors path="student1.*" />

<p style = color:red >${error}</p>
<%-- <h1>${headerMessage}</h1> --%>
<form action="/SpringWebProjectDemo/checkLogin.html" method="post">

Email:
<input type="text" name="email">
<br>
password:
<input type="text" name="password">
<br>

<input type="submit" value="Submit">
</form>

</body>
</html>
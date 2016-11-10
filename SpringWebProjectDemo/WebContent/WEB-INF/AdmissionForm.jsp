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

<h1>${headerMessage}</h1>
<form action="/SpringWebProjectDemo/submitNewInfo.html" method="post">
Student Name: 
<input type="text" name="studentName">
Student Hobby:
<input type="text" name="studentHobby">
Student Mobile:
<input type="text" name="studentMobile">
Student DOB:
<input type="text" name="studentDOB">
Student Skills:
<select name="studentSkills" multiple>
<option value="java">Java</option>
<option value="c++">C++</option>
<option value="c#">C#</option>
</select>
<br>
Student ADDRESS:<br>
Street:
<input type="text" name="studentAddress.street"><br>
City:
<input type="text" name="studentAddress.city"><br>
Country:
<input type="text" name="studentAddress.country"><br>


<input type="submit" value="Submit">
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%-- <h1>${student1.studentName}</h1>
<h1>${student1.studentHobby}</h1>
<h1>${student1.studentDOB}</h1>
<h1>${student1.studentMobile}</h1>
<h1>${student1.studentSkills}</h1>

 <h2>${student1.studentAddress.street}</h2>
 <h2>${student1.studentAddress.city}</h2>
<h2>${student1.studentAddress.country}</h2> --%>


<h1>${user.firstname}</h1>
<h1>${user.lastname}</h1>
<h1>${user.email}</h1>
<h1>${user.password}</h1>


<ul>
			<c:forEach var="user" items="${userList}">
				<li>${user.firstname}</li>
				<li>${user.lastname}</li>
				<li>${user.email}</li>
			</c:forEach>
		</ul>




</body>
</html>
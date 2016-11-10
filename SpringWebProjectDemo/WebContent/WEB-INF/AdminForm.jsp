<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"> </script> 
    <script src="https://code.angularjs.org/1.2.3/angular.min.js"></script>      
<style>
input[type=submit] {
    width: 15%;
    /* background-color: #4CAF50; */
    background-color:#008CBA;
    color: white;
    padding: 0px 20px;
    margin-top: 10px;
     margin-left: 20px ;
         display: inline-block;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=text]{
    width: 15%;
    padding: 14px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

</style>
</head>
<body>

<h1>ADMIN PAGE</h1>

<form:errors path="item.*" />

<h2>${success}</h2>

<table class="table">
<tr class="danger">
<th>ITEM ID</th>
<th>ITEM_NAME</th>
<th>ITEM_PRICE</th>
</tr>
			<c:forEach var="item" items="${itemList}">
				<tr class="info">
				<td>${item.itemId}</td>
				<td>${item.itemName}</td>
				<td>${item.itemPrice}</td>
				<tr>
			</c:forEach>
			
		</table>
		<br>


<form name="adminForm" action="/SpringWebProjectDemo/updatePrice.html" method="post">

		Item ID:
		<input class="form-control" type="text" name="itemId" ng-minlength="5" ng-maxlength="5" required>
	
		
		Price Update: 
		<input class="form-control" type="text" name="itemPrice" ng-maxlength="4">
		
		<input class="form-control" type="submit" Value=Update>
</form>
</body>
</html>


<!-- <script>


function updateValue(f)
{
	var p = f;
	document.getElementById("demo").innerHTML = p;
	document.getElementById("demo").value = p;
	}

</script>
 -->
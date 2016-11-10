<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trouser</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>

<!-- NAVBAR
================================================== -->
  <body>
   <div class="navbar-wrapper">
      <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="">MapProd</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li><a href="/SpringWebProjectDemo/Home.html">Home</a></li>
                <li class="dropdown">
          			<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Products<span class="caret"></span></a>
          			<ul class="dropdown-menu" aria-labelledby="dropdownMenu3">
  						
  						<li class="dropdown-header">Clothes</li>
  							<li><a href="/SpringWebProjectDemo/Shirt.html">&nbsp;&nbsp;Shirts</a></li>
  							<li><a href="/SpringWebProjectDemo/Trouser.html">&nbsp;&nbsp;Trouser</a></li>
  						<li role="separator" class="divider"></li>	
						<li class="dropdown-header">Gadgets</li>
							<li><a href="/SpringWebProjectDemo/CellPhone.html">&nbsp;&nbsp;CellPhone</a></li>
  							<li><a href="/SpringWebProjectDemo/Laptop.html">&nbsp;&nbsp;Laptop</a></li>
          			</ul>
        		</li>
                <li><a href="/SpringWebProjectDemo/About.html">About</a></li>
                <li><a href="/SpringWebProjectDemo/Contact.html">Contact</a></li>
                  <li><a href=#> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${user1.email}</a></li>
                <li><a href="/SpringWebProjectDemo/logout"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LOGOUT</a></li>
  
              </ul>
            </div>
          </div>
        </nav>

      </div>
    </div>
       	
    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->
	<b><b><b>
    <div class="container marketing">
		<ol class="breadcrumb">
    		<li><a href="/SpringWebProjectDemo/Home.html">Home</a></li>
    		<li><a href="/SpringWebProjectDemo/Clothes.html">Clothes</a></li>
    		<li class="active">Trouser</a></li>
    	
   <%--  		<li>${user1.firstname}</li> --%>
    	</ol><!-- /.breadcrumb -->
   
   
    <div class="row">
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading">Old Navy</div>
        <div class="panel-body"><img src="images/trouser1.jpg" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">
        	<form action="/SpringWebProjectDemo/Detail.html" method="post">
   				<input type="hidden" value="${user1.userid}" name="userid">
 		       	<input type="hidden" value="${user1.email}" name="email">
   				<button name="itemId" class="btn btn-primary btn-block" value="10005" type="submit">View Details</button>
 
   			</form>
        	
        </div>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading">Denim Cargo</div>
        <div class="panel-body"><img src="images/trouser2.jpg" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">
        	<form action="/SpringWebProjectDemo/Detail.html" method="post">
   				<input type="hidden" value="${user1.userid}" name="userid">
 		       	<input type="hidden" value="${user1.email}" name="email">
   				<button name="itemId" class="btn btn-primary btn-block" value="10006" type="submit">View Details</button>
 
   			</form>
        	
        </div>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading">Livis Signature</div>
        <div class="panel-body"><img src="images/trouser3.jpg" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">
        	<form action="/SpringWebProjectDemo/Detail.html" method="post">
   						<input type="hidden" value="${user1.userid}" name="userid">
 		       	<input type="hidden" value="${user1.email}" name="email">
   				<button name="itemId" class="btn btn-primary btn-block" value="10007" type="submit">View Details</button>
 
   			</form>
        	
        </div>
      </div>
    </div>
  </div>


<br><br>
      <!-- FOOTER -->
      <footer>
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>&copy; MapProd, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
      </footer>

    </div><!-- /.container -->

</body>
</html>
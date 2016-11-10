
<html lang="en" ng-app>
  <head>
    <meta charset="UTF-8">
    <title>Login Form</title>    
    
    <link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css'>    
    <link rel="stylesheet" href="css/style.css">     
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"> </script> 
    <script src="https://code.angularjs.org/1.2.3/angular.min.js"></script>      
  </head>
  <body>
  
      <div class="wrapper">
    <form class="form-signin" name="loginForm" action="/SpringWebProjectDemo/checkLogin.html" method="post">       
      <h3 style="color:red">${sessionexpire}</h3>
      <h2 class="form-signin-heading">Login</h2>
      <input type="email" class="form-control" ng-model="user.email" name="email" placeholder="Email" required/>
      <span ng-show="loginForm.email.$dirty && loginForm.email.$error.required">This is a required field</span>
      <span ng-show="loginForm.email.$dirty && loginForm.email.$invalid">This field is invalid </span>
      
      <input type="password" class="form-control" ng-model="user.password" name="password" placeholder="Password" required ng-minlength="6"/>
      <span ng-show="loginForm.password.$dirty && loginForm.password.$error.required">This is a required field</span>
      <span ng-show="loginForm.password.$dirty && loginForm.password.$error.minlength">Minimum length required is 6</span>
      <span ng-show="loginForm.password.$dirty && loginForm.password.$invalid">This field is invalid </span>      
      <br><button class="btn btn-lg btn-primary btn-block" type="submit" ng-disabled="loginForm.$invalid">Login</button>
      <a href="/SpringWebProjectDemo/registration" class="btn.btn-link" text-align:"right">New User</a>   
    </form>    
  </div>
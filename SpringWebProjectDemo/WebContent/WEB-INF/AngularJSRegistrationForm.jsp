
<html lang="en" ng-app>
  <head>
    <meta charset="UTF-8">
    <title>SignUp Form</title>    
    
    <link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css'>    
    <link rel="stylesheet" href="css/style2.css">     
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"> </script> 
    <script src="https://code.angularjs.org/1.2.3/angular.min.js"></script>      
  </head>
  <body>
      <div class="wrapper">
    <form class="form-signin" name="registrationForm" action="/SpringWebProjectDemo/submituser.html" method="post">      
      <h2 class="form-signin-heading">SignUp</h2>
      <input type="text" class="form-control" ng-pattern="/^[a-zA-Z\s]*$/" ng-model="user.firstname" name="firstname" placeholder="Enter your First Name" required/>
              <span ng-show="registrationForm.firstname.$dirty && registrationForm.firstname.$error.required">This is a required field</span>
              <span ng-show="registrationForm.firstname.$dirty && registrationForm.firstname.$error.pattern">Only alphabets are allowed</span>
      
     <br><input type="text" class="form-control" ng-pattern="/^[a-zA-Z]*$/" ng-model="user.lastname" name="lastname" placeholder="Last Name" required/>
     <span ng-show="registrationForm.lastname.$dirty && registrationForm.lastname.$error.required">This is a required field</span>
     <span ng-show="registrationForm.lastname.$dirty && registrationForm.lastname.$error.pattern">Only alphabets without space are allowed</span>      
     
     <br><input type="number" class="form-control" ng-model="user.phonenumber" name="phonenumber" placeholder="Phone Number" required ng-minlength="10" 
                   ng-maxlength="10"/>
     <span ng-show="registrationForm.phonenumber.$dirty && registrationForm.phonenumber.$error.required ">This is a required field</span>    
     <span ng-show="((registrationForm.phonenumber.$error.minlength ||
                           registrationForm.phonenumber.$error.maxlength) && 
                           registrationForm.phonenumber.$dirty) ">
                           phone number should be 10 digits
     </span>
     
     <select class="form-control" ng-model="carrier" id="carrier" name="carrier"  required>
                                            <option value="" disabled>-- Select Carrier --</option>
                                            <option  value="{{user.phonenumber}}@txt.att.net">AT&T</option>
                                            <option  value="{{user.phonenumber}}@vtext.com">Verizon</option>
                                            <option  value="{{user.phonenumber}}@messaging.sprintpcs.com">Sprint</option>
                                            <option  value="{{user.phonenumber}}@tmomail.net">T-Mobile</option>
                                            <option  value="">Other</option>
     </select>
    
     <span style="color:red" ng-show="registrationForm.carrier.$dirty && registrationForm.carrier.$error.required">Carrier field is required</span>
    
     <br><input type="email" class="form-control" ng-model="user.email" name="email" placeholder="Email" required/>
     <span ng-show="registrationForm.email.$dirty && registrationForm.email.$error.required">This is a required field</span>
     <span ng-show="registrationForm.email.$dirty && registrationForm.email.$invalid">Invalid email </span>
     
     <br><input type="password" class="form-control" ng-model="user.password" name="password" placeholder="Password" required ng-minlength="6"/>
     <span ng-show="registrationForm.password.$dirty && registrationForm.password.$error.required">This is a required field</span>
     <span ng-show="registrationForm.password.$dirty && registrationForm.password.$error.minlength">Minimum length required is 6</span>
     <span ng-show="registrationForm.password.$dirty && registrationForm.password.$invalid">This field is invalid </span>
     
     <br><input type="password" class="form-control" ng-confirm-field ng-model="user.cpassword" confirm-against="password" name="cpassword" required placeholder="Re-Type Password" />
     <span ng-show="registrationForm.cpassword.$dirty && registrationForm.cpassword.$error.required">Retype password</span>
     <span ng-show="(registrationForm.cpassword.$dirty && registrationForm.cpassword.$dirty) && (user.password != user.cpassword)" style="color:red">
        	  Password mismatched</span>
     <br><button class="btn btn-lg btn-primary btn-block" type="submit" value="Register" ng-disabled="registrationForm.$invalid">Sign Up</button>
        <a href="/SpringWebProjectDemo/signin.html" class="btn.btn-link" text-align:"right">Existing User</a> 
    </form>    
  </div>
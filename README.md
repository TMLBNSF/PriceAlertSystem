# PriceAlertSystem

The project developed is a price alerting system. Users can select a product and set alerts on desired products. Once the admin updates the price, users receive alerts in the form of Email and SMS in real-time.

The project is develop using spring framework, client side validations using angular JS following MVC architecture

Files Description
1. It has 3 bean classes for saving item details, setting up alert details and saving user information.

2. There are 7 contollers 

a. admincontroller to update prices in the database

b. alert controller to set alerts

c. email controller to send emails

d. phone controller for sending texts

e. Redirect-controller which redirects to different pages

f. User Login controller is to login and sign up user into the database.

3. All database implementations are present in com.pkg.daoimplementation

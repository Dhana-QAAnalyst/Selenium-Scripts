@validatePO
Feature: As a logged in user, I want to view the order details of purchased items 

Background:
	Given The application is launched 
	And the user is on the login page
	When the user enters the valid "test.user202515@gmail.com" and "test.user" 
	And clicks on Log in button
	Then the login confirmation should be displayed with user "test.user202515@gmail.com"
	
Scenario:
	Given the logged in user is on My account - Orders page
	When the user clicks on Details on the order matching to Order Info "Order Number: 2088439"
	Then Product Name "Smartphone" and Total price "107.00" should be displayed for the user

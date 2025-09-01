@logOut
Feature: As a logged in user, I want to log off from the site 

Background:
	Given The application is launched 
	And the user is on the login page
	When the user enters the valid "test.user202515@gmail.com" and "test.user" 
	And clicks on Log in button
	Then the login confirmation should be displayed with user "test.user202515@gmail.com"
	
Scenario:
	Given The logged in user is on the home page of Demo Web Shop 
	When the user click on Log out from the main menu
	Then the user is navigated back to landing page
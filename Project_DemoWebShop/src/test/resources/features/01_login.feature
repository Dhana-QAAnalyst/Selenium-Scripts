@logIn
Feature: As a registered user, I want to Login to Demo Web Shop application so that I can access my account
Scenario: login with valid credentials
	Given The application is launched 
	And the user is on the login page
	When the user enters the valid "test.user202515@gmail.com" and "test.user" 
	And clicks on Log in button
	Then the login confirmation should be displayed with user "test.user202515@gmail.com"
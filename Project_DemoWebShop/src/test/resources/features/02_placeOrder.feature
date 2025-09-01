@placeOrder
Feature: As a logged in user, I want to add an item to cart and process checkout so that I can purchase a product from the site 

Background:
	Given The application is launched 
	And the user is on the login page
	When the user enters the valid "test.user202515@gmail.com" and "test.user" 
	And clicks on Log in button
	Then the login confirmation should be displayed with user "test.user202515@gmail.com"

Scenario: Place an order
	Given  the logged in user is on Cell phones category page
	When the user successfully adds a Smartphone product to cart
	And the user proceeds to Checkout "Smartphone" after validating order details in cart page
	And the user confirms the order after entering shipping and payment details 
	Then the order confirmation message with Order number should be displayed
	

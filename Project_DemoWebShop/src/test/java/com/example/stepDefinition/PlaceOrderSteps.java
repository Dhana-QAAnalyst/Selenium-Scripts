package com.example.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

import org.openqa.selenium.WebDriver;

import com.example.Pages.*;
import com.example.Utils.*;

public class PlaceOrderSteps {
	
	WebDriver driver = DriverManager.getDriver();
	HomePage home = new HomePage(driver);
	CellPhonesPage cell = new CellPhonesPage(driver);
	ShoppingCartPage cart = new ShoppingCartPage(driver);
	CheckoutPage check = new CheckoutPage(driver);
	OrderSuccessPage success = new OrderSuccessPage(driver);
	
	@Given("the logged in user is on Cell phones category page")
	public void navigateToCellPhonesPage() {
		home.toCellPhonesPage();		
	}
	
	@When("the user successfully adds a Smartphone product to cart")
	public void verifyAddToCart() {
		cell.addToCart();		
	}
	
	@And("the user proceeds to Checkout {string} after validating order details in cart page")
	public void validateOrderDetails(String expectedProductName) {
		String actualProductName = cart.getProductName();
		Assert.assertEquals(expectedProductName, actualProductName);
		
		double unitPrice = cart.returnUnitPrice();
		int qty = cart.returnQty();
		double RHS = cart.returnTotalPrice();
		double LHS = unitPrice * qty;
		double delta = 0.000001;
		Assert.assertEquals(LHS, RHS, delta);
		
		cart.estimateShipping("Canada", "Alberta");
		cart.checkOut();
	}
	
	@And("the user confirms the order after entering shipping and payment details")
	public void confirmOrder() {
		check.placeOrder();		
	}
	
	@Then("the order confirmation message with Order number should be displayed")
	public void validateOrderConfirmation() {
		String orderNumber = success.getOrderNumber();
		ConfigReaderWriter.setProperty(orderNumber);
	}

}

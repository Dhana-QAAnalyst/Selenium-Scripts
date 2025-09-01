package com.example.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.example.Pages.*;
import com.example.Utils.*;

public class ValidatePOSteps {
	
	WebDriver driver = DriverManager.getDriver();
	HomePage home = new HomePage(driver);
	MyAccountPage acc = new MyAccountPage(driver);
	
	@Given("the logged in user is on My account - Orders page")
	public void navigateToOrders() {
		home.toMyAccountPage();
		acc.toOrdersPage();		
	}
	
	@When("the user clicks on Details on the order matching to Order Info {string}")
	public void lookForMatchingOrder(String orderInfo) {
		int orderIndex = acc.findOrder(orderInfo);
		acc.clickOnMatchingOrder(orderIndex);
	}
	
	@Then("Product Name {string} and Total price {string} should be displayed for the user")
	public void validateDetails(String productName, String price) {
		String actualProduct = acc.getProductName();
		String actualPrice = acc.getTotalPrice();
		Assert.assertEquals(productName, actualProduct);
		Assert.assertEquals(price, actualPrice);
	}

}

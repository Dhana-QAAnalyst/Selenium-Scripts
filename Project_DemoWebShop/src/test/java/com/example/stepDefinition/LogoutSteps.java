package com.example.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;

import com.example.Pages.*;
import com.example.Utils.*;

public class LogoutSteps {
	
	WebDriver driver = DriverManager.getDriver();
	HomePage home = new HomePage(driver);
	
	@Given("The logged in user is on the home page of Demo Web Shop")
	public void homePageConfirmation() {
		String expected = ConfigReaderWriter.getProperty("home.WelcomeMessage");
		String actual = home.getWelcomeMessage();
		Assert.assertEquals(expected, actual);
	}
	
	@When("the user click on Log out from the main menu")
	public void clickOnLogout() {
		home.logOut();
	}
	
	@Then("the user is navigated back to landing page")
	public void validateLogOut() {
		String expectedURL = ConfigReaderWriter.getProperty("app.url");
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(expectedURL, actualURL);
	}

}

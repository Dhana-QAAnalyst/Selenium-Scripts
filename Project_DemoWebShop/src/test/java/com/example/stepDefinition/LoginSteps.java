package com.example.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;

import com.example.Utils.ConfigReaderWriter;
import com.example.Utils.DriverManager;

import com.example.Pages.*;

public class LoginSteps {
	
	WebDriver driver = DriverManager.getDriver();
	LandingPage Land = new LandingPage(driver);
	LoginPage logIn = new LoginPage(driver);
	HomePage home = new HomePage(driver);
		
	@Given("The application is launched")
	public void launchApp() {
		String url = ConfigReaderWriter.getProperty("app.url");
		driver.get(url);
	}
	
	@And("the user is on the login page")
	public void clickOnLogin() {
		Land.clickOnLoginLink();
		String expected = ConfigReaderWriter.getProperty("login.SignInText");
		String actual = logIn.getSignInText();
		Assert.assertEquals(expected, actual);
	}
	
	@When("the user enters the valid {string} and {string}")
	public void enterCredentials(String email, String password) {
		logIn.typeEmailandPassoword(email, password);
	}
	
	@And("clicks on Log in button")
	public void clickOnLoginButton() {
		logIn.submitLogin();
	}

	@Then("the login confirmation should be displayed with user {string}")
	public void confirmLoginSuccess(String email) {
		String actual = home.validateUserInfo();
		Assert.assertEquals(email,actual);
	}
}

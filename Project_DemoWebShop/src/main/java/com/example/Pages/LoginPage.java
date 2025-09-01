package com.example.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	By SignInText = By.xpath("//*[@class='page-title']/h1");
	By emailInput = By.xpath("//*[@id='Email']");
	By passwordInput = By.xpath("//*[@id='Password']");
	By loginButton = By.xpath("//input[@value='Log in']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	public String getSignInText() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(SignInText));		
		return text.getText();
	}
	
	public void typeEmailandPassoword(String email, String password) {
		driver.findElement(emailInput).sendKeys(email);
		driver.findElement(passwordInput).sendKeys(password);		
	}
	
	public void submitLogin() {
		driver.findElement(loginButton).click();
	}

}

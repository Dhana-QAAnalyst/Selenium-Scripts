package com.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	WebDriver driver; 
	By loginLink = By.xpath("//a[@class='ico-login']");
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnLoginLink() {
		driver.findElement(loginLink).click();
	}
}

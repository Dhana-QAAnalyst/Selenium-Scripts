package com.example.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderSuccessPage {
	
	WebDriver driver;
	WebDriverWait wait;
	By thankYouHeader = By.xpath("//h1[text()='Thank you']");
	By orderNumber = By.xpath("(//ul[@class='details']/li)[1]");
	
	public OrderSuccessPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	public String getOrderNumber() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(thankYouHeader));
		String orderNo = driver.findElement(orderNumber).getText();
		return orderNo;
	}
	

}

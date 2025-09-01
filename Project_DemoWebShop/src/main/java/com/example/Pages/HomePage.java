package com.example.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	
	By userEmail = By.xpath("//div[@class='header-links']//a[@class='account']");
	By electronicsCategory = By.xpath("//ul[@class='top-menu']//a[@href='/electronics']");
	By cellPhonesOption = By.xpath("//a[@href='/cell-phones']");
	By welcomeMessage = By.xpath("(//div[@class='topic-html-content-body']/p)[1]");
	By logoutLink = By.xpath("//a[@class='ico-logout']");
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		actions = new Actions(driver);
	}
	
	public String validateUserInfo() {
	wait = new WebDriverWait(driver,Duration.ofSeconds(60));
	WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(userEmail));
	return email.getText();	
	}
	
	public void toCellPhonesPage() {
		WebElement electronics = driver.findElement(electronicsCategory);
		actions.moveToElement(electronics).perform();
		
		WebElement cellPhones = wait.until(ExpectedConditions.visibilityOfElementLocated(cellPhonesOption));
		cellPhones.click();
	}
	
	public void toMyAccountPage() {
		driver.findElement(userEmail).click();
	}
	
	public String getWelcomeMessage() {
		String message = driver.findElement(welcomeMessage).getText();
		return message;
	}
	
	public void logOut() {
		driver.findElement(logoutLink).click();
	}
}

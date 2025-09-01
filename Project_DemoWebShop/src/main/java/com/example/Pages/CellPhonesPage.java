package com.example.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CellPhonesPage {
	
	WebDriver driver;
	WebDriverWait wait;
	By cellPhonesHeader = By.xpath("//h1[text()='Cell phones']");
	By addToCartBtn = By.xpath("(//input[@type='button' and @value='Add to cart'])[1]");
	By successToastMessage = By.xpath("//p[text()='The product has been added to your ']");
	By shoppingCartLink = By.xpath("//a[@href='/cart' and text()='shopping cart']");
	
	public CellPhonesPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));		
	}
	
	public void addToCart() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(cellPhonesHeader));
		driver.findElement(addToCartBtn).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(successToastMessage));
		driver.findElement(shoppingCartLink).click();		
	}

}

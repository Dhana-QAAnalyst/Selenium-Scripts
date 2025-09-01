package com.example.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	
	WebDriver driver;
	WebDriverWait wait;
	By checkOutHeader = By.xpath("//h1[text()='Checkout']");
	By submitBillingAddress = By.xpath("//div[@id='billing-buttons-container']/input");
	By shippingAddressHeader = By.xpath("//h2[text()='Shipping address']");
	By submitShippingAddress = By.xpath("//div[@id='shipping-buttons-container']/input");
	By shippingMethodHeader = By.xpath("//h2[text()='Shipping method']");
	By submitShippingMethod = By.xpath("//input[@class='button-1 shipping-method-next-step-button']");
	By paymentMethodHeader = By.xpath("//h2[text()='Payment method']");
	By submitPaymentMethod = By.xpath("//input[@class='button-1 payment-method-next-step-button']");
	By payemntInfoHeader = By.xpath("//h2[text()='Payment information']");
	By submitPaymentInfo = By.xpath("//input[@class='button-1 payment-info-next-step-button']");
	By confirmOrderHeader = By.xpath("//h2[text()='Confirm order']");
	By confirmOrderBtn = By.xpath("//input[@class='button-1 confirm-order-next-step-button']");
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	public void placeOrder() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkOutHeader));
		driver.findElement(submitBillingAddress).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(shippingAddressHeader));
		wait.until(ExpectedConditions.elementToBeClickable(submitShippingAddress)).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(shippingMethodHeader));
		wait.until(ExpectedConditions.elementToBeClickable(submitShippingMethod)).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(paymentMethodHeader));
		wait.until(ExpectedConditions.elementToBeClickable(submitPaymentMethod)).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(payemntInfoHeader));
		wait.until(ExpectedConditions.elementToBeClickable(submitPaymentInfo)).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOrderHeader));
		wait.until(ExpectedConditions.elementToBeClickable(confirmOrderBtn)).click();
	}

}

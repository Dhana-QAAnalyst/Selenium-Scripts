package com.example.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage {
	
	WebDriver driver;
	WebDriverWait wait;
	By shoppingCartHeader = By.xpath("//h1[text()='Shopping cart']");
	By productName = By.xpath("//a[@class='product-name']");
	By itemUnitPrice = By.xpath("//span[@class='product-unit-price']");
	By itemQuanity = By.xpath("//input[starts-with(@name,'itemquantity')]");
	By totalPrice = By.xpath("//span[@class='product-subtotal']");
	By countryDropDown = By.id("CountryId");
	By provinceDropDown = By.id("StateProvinceId");
	By postalCodeInput = By.id("ZipPostalCode");
	By estimateShippingbtn = By.xpath("//input[@value='Estimate shipping']");
	By termsofserviceCheck = By.id("termsofservice"); 
	By checkoutBtn = By.id("checkout");
	
	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	public String getProductName() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartHeader));
		String productNameText = driver.findElement(productName).getText();
		return productNameText;
	}
	
	public double returnUnitPrice() {
		String unitPriceStr = driver.findElement(itemUnitPrice).getText();
		double unitPrice = Double.valueOf(unitPriceStr);
		return unitPrice;		
	}
		
	public int returnQty() {
		WebElement qtyElt = driver.findElement(itemQuanity);
		String qtyStr = qtyElt.getAttribute("value");
		int qty = Integer.valueOf(qtyStr);
		return qty;
	}
	
	public double returnTotalPrice() {
		String totalStr = driver.findElement(totalPrice).getText();
		double total = Double.valueOf(totalStr);
		return total;
	}
	
	public void estimateShipping(String countryText, String provinceText) {
		WebElement country = driver.findElement(countryDropDown);
		Select selectCountry = new Select(country);
		selectCountry.selectByVisibleText(countryText);
		
		WebElement province = driver.findElement(provinceDropDown);
		Select selectProvince = new Select(province);
		selectProvince.selectByVisibleText(provinceText);
		
		WebElement postalCode = driver.findElement(postalCodeInput);
		postalCode.clear();
		postalCode.sendKeys("A1B 2C3");
		
		driver.findElement(estimateShippingbtn).click();
	}
	
	public void checkOut() {
		driver.findElement(termsofserviceCheck).click();
		driver.findElement(checkoutBtn).click();		
	}

}

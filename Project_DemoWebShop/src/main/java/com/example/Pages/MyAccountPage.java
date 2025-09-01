package com.example.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	By ordersLink = By.xpath("//a[@href='/customer/orders' and @class='inactive']");
	By orderNumbersList = By.xpath("//div[@class='section order-item']//strong");
	By detailsButtonList = By.xpath("//input[@value='Details']");
	By orderInfoHeader = By.xpath("//h1[text()='Order information']");
	By productNameText = By.xpath("//*[@class='a-left name']/em/a");
	By totalPrice = By.xpath("//*[@class='nobr']/strong");
	
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait (driver, Duration.ofSeconds(20));
	}
	
	public void toOrdersPage() {
		WebElement ordersOption = wait.until(ExpectedConditions.visibilityOfElementLocated(ordersLink));
		ordersOption.click();		
	}
	
	public int findOrder(String orderInfo) {
		List<WebElement> ordersList = driver.findElements(orderNumbersList);
		int index = -1;
		for(int i=0; i<ordersList.size();i++) {
			String orderListText = ordersList.get(i).getText();
			if (orderListText.equals(orderInfo)) {
				index = i;
				break;
			}
		}
		System.out.print("index found"+index);
		return index;
	}
	
	public void clickOnMatchingOrder(int id) {
		
		List<WebElement> detailsButton = driver.findElements(detailsButtonList);
			detailsButton.get(id).click();
		}
	
	public String getProductName() {
		String pName = driver.findElement(productNameText).getText();
		return pName;
	}
	
	public String getTotalPrice() {
		String price = driver.findElement(totalPrice).getText();
		return price;
	}
}

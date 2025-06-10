package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage_ultimateqa {
	
	WebDriver driver;
	WebDriverWait wait;
	By headerLocation = By.cssSelector("#Automation_Practice > span > strong > span > span");
	By loginLink = By.linkText("Login automation");
		
	public HomePage_ultimateqa(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	
	public String getPageHeader() {
		
		String headerText = driver.findElement(headerLocation).getText();		
		return headerText;
		
	}
	public void clickOnLoginLink() {
		
		driver.findElement(loginLink).click();	
		
	}
}

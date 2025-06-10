package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage_ultimateqa {
	
	WebDriver driver;
	WebDriverWait wait;
	By headerLocation = By.cssSelector("h2.page__heading");
	
	public LoginPage_ultimateqa(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	public String getLoginPageHeader() {
		
		wait = new WebDriverWait (driver,Duration.ofSeconds(60));
		WebElement headerText = wait.until(ExpectedConditions.visibilityOfElementLocated(headerLocation));		
		return headerText.getText();
	}

}

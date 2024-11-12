package Pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	By searchBoxName = By.name("search");
	String deviceModel = "iphone";
	By clickBtn = By.cssSelector(".btn.btn-light.btn-lg");

	public HomePage(WebDriver driver){
		this.driver = driver;
	}

	public void searchItem () {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBoxName));
		search.sendKeys(deviceModel);
		driver.findElement(clickBtn).click();	
	}	
}
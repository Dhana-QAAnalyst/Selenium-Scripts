package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {
	
	WebDriver driver;
	By headerXPath = By.xpath("//*[@id=\"content\"]/h2");
	
	
	public SearchResultsPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public String SearchHeader() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		WebElement textHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(headerXPath));
		return textHeader.getText();		 
	}
}

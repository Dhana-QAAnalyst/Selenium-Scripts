package stepDefinition;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class SearchFunction {
	WebDriver driver;
	@Given("The user launches the openCart website")
	public void The_user_launches_the_openCart_website() throws Throwable{
		System.setProperty("Webdriver.chrome.driver","\"C:\\Users\\dhana\\Downloads\\chromedriver_win32\\chromedriver.exe\"");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/");	
	}
	
	@When("the user types deviceModel {string} and hit search button")
	public void the_user_types_deviceModel_and_hit_search_button (String deviceModel) throws Throwable{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search")));
		search.sendKeys(deviceModel);
		driver.findElement(By.cssSelector(".btn.btn-light.btn-lg")).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//Wait ww = new FluentWait(driver)
				//.withTimeout(Duration.ofSeconds(10))
				//.pollingEvery(Duration.ofSeconds(2))
				//.ignoring(NoSuchElementException.class);
		//WebElement link = (WebElement) ww.until(new Function<WebDriver,WebElement>(){
		//public WebElement apply (WebDriver driver) {
		//	return driver.findElement(By.id("ID"));
		//}
		//});
	}
	
	@Then("Device models are displayed with details")
	public void Device_models_are_displayed_with_details() throws Throwable{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		WebElement textHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/h2")));
		String text = textHeader.getText();
		Assert.assertTrue("Search is failed",text.equals("Products meeting the search criteria"));
		driver.quit();
		}
}

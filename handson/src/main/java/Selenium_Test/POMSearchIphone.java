package Selenium_Test;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.HomePage;
import Pages.SearchResultsPage;

public class POMSearchIphone {

	public static void main(String[] args) {
		WebDriver driver;
		HomePage objHome;
		SearchResultsPage objSearch;
		System.setProperty("Webdriver.chrome.driver","\"C:\\Users\\dhana\\Downloads\\chromedriver_win32\\chromedriver.exe\"");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/");		
		objHome = new HomePage(driver);
		objHome.searchItem();
		objSearch = new SearchResultsPage(driver);
		String text = objSearch.SearchHeader();		
		Assert.assertTrue("Search is failed",text.equals("Products meeting the search criteria"));
		driver.quit();
		System.out.print("hi");
	}
}
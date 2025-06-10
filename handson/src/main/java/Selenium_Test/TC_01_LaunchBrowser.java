package Selenium_Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_01_LaunchBrowser {

	public static void main(String[] args) {
		System.setProperty("Webdriver.chrome.driver","\"C:\\Program Files\\chromedriver_win32\\chromedriver.exe\"");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.quit();
	}
}
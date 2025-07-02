package Selenium_Test;

import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TC_03_SeleniumGrid_LaunchBrowser {

	@Test(description = "TestID: 01 - Verify selenium grid setup - Chrome broswer")
	public void Test01_Chorome() throws Exception {
		ChromeOptions options = new ChromeOptions();
		//options.setCapability("browserName", "chrome");
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"),options);
		driver.get("https://www.google.com");
		System.out.println("This is "+driver.getTitle()+" from Chrome");
		driver.quit();
	}
	
	@Test(description = "TestID: 02 - Verify selenium grid setup - Edge broswer")
	public void Test02_Edge() throws Exception {
		EdgeOptions options = new EdgeOptions();
		//options.setCapability("browserName", "MicrosoftEdge");
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"),options);
		driver.get("https://www.google.com");
		System.out.println("This is "+driver.getTitle()+ " from Edge");
		driver.quit();
	}
}

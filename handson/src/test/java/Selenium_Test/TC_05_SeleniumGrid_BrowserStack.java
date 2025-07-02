package Selenium_Test;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import io.github.cdimascio.dotenv.Dotenv;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.HomePage_ultimateqa;
import Pages.LoginPage_ultimateqa;

public class TC_05_SeleniumGrid_BrowserStack {
	
	WebDriver driver;
	HomePage_ultimateqa objHome;
	LoginPage_ultimateqa objLogin;
	
	Dotenv dot = Dotenv.load();
	String baseurl = "https://ultimateqa.com/automation";
	String username = dot.get("BROWSERSTACK_USERNAME");
	String accessKey = dot.get("BROWSERSTACK_ACCESS_KEY");
	String browserStackURL = "https://"+username+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub";
	
	@BeforeTest
	public void EnovironmentSetup() throws Exception {
		
		ChromeOptions options = new ChromeOptions();
		options.setCapability("browserVersion","latest");
		Map<String, Object> bStackOptions = new HashMap<>();
		bStackOptions.put("os","Windows");
		bStackOptions.put("osVersion", "11");
		bStackOptions.put("sessionName", "Login functionality - remote chrome");
		bStackOptions.put("buildName", "Build_"+System.currentTimeMillis());
		options.setCapability("bstack:options", bStackOptions);		
		driver = new RemoteWebDriver(new URL(browserStackURL), options);
		objHome = new HomePage_ultimateqa(driver);
		objLogin = new LoginPage_ultimateqa(driver);
		
	}

	@Test(description="Test01_Verify remote execution using BrowserStack - Chrome")
	public void Test01_Login() {
		driver.get(baseurl);
		System.out.println(objHome.getPageHeader());
		objHome.clickOnLoginLink();
		String loginHeader = objLogin.getLoginPageHeader();
		Assert.assertEquals("Welcome!", loginHeader.trim());
		
	}		
		
	@AfterTest
	public void TearDown() {
		
		driver.quit();
		
	}		

}

package Selenium_Test;

import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.HomePage_ultimateqa;
import Pages.LoginPage_ultimateqa;

public class TC_04_SeleniumGrid_ParallelExecution {
	
	WebDriver driver;
	HomePage_ultimateqa objHome;
	LoginPage_ultimateqa objLogin;
	String baseurl = "https://ultimateqa.com/automation";
	
	@BeforeTest
	public void EnovironmentSetup() throws Exception {
		
		ChromeOptions options = new ChromeOptions();
		driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
		objHome = new HomePage_ultimateqa(driver);
		objLogin = new LoginPage_ultimateqa(driver);
		
	}

	@Test(description="Test01_Verify Parallel execution using Selenium Grid - Chrome")
	public void Test01_Login() {
		driver.get(baseurl);
		System.out.println(objHome.getPageHeader());
		objHome.clickOnLoginLink();
		String loginHeader = objLogin.getLoginPageHeader();
		Assert.assertEquals("Welcome!", loginHeader.trim());
		
	}		
		
	@AfterTest
	public void TearDown() {
		
		driver.close();
		
	}		
}
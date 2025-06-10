package Selenium_Test;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TC_06_BrowserStack_ParallelExecution {
	
	@Test(description = "TestID: 01 - Verify parallel execution using BrowserStack - Firefox broswer")
	public void Test01_Firefox() throws Exception {
		
		String baseurl = "https://ultimateqa.com/automation";
		String username = "dhanalakshmikris_rXWcKq";
		String accessKey = "XhD4nxYR24uD4ZsP9pGd";
		String browserStackURL = "https://"+username+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub";
		
		FirefoxOptions options = new FirefoxOptions();
        options.setCapability("browserVersion", "latest");
        
        Map<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("os", "Windows");
        bstackOptions.put("osVersion", "11");
        bstackOptions.put("sessionName", "Firefox on BrowserStack");
        bstackOptions.put("buildName", "Build_"+System.currentTimeMillis());
        options.setCapability("bstack:options", bstackOptions);

        WebDriver driver = new RemoteWebDriver(new URL(browserStackURL), options);
		
		driver.get("https://www.google.com");
		System.out.println("This is "+driver.getTitle()+" from Firefox");
		driver.quit();
	}

}

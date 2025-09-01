package com.example.stepDefinition;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.example.Utils.DriverManager;
import com.example.Utils.ScreenshotHelper;

import io.cucumber.java.After;

public class Hooks {
	
	@Before
	public void setUp() {
		DriverManager.getDriver();
		}
	
	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshotBytes = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotBytes, "image/png", "Failure Screenshot");
			String path = ScreenshotHelper.captureScreenshot(DriverManager.getDriver(), scenario.getName());
        } 
		DriverManager.quitDriver();
	}
}

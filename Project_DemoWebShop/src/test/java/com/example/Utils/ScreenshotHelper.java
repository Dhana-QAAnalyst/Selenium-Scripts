package com.example.Utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotHelper {
	
	    public static String captureScreenshot(WebDriver driver, String scenarioName) {
	        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	        String filePath = "target/screenshots/" + scenarioName + "_" + timestamp + ".png";

	        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        File destFile = new File(filePath);

	        try {
	            Files.createDirectories(destFile.getParentFile().toPath());
	            Files.copy(srcFile.toPath(), destFile.toPath());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return filePath;
	    }
}

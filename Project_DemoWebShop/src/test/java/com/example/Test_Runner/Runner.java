package com.example.Test_Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features", 
		glue = ("com.example.stepDefinition"),
		tags = "@logIn or @placeOrder or @validatePO or @logOut",
		plugin = {
				"pretty", 
				"html:target/cucumber-report.html", 
				"json:target/cucumber-report.json",
				},
		monochrome = true
		)

public class Runner{
	
}

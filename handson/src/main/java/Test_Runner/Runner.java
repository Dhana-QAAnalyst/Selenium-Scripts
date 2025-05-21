package Test_Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="Features", 
		glue=("stepDefinition"),
		plugin = {"pretty", "html:target/cucumber-report.html"}
		)
public class Runner {

}
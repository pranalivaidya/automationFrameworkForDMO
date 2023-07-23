package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
	features = ("src/test/resources/features"),
	glue = {"stepDefinition","generic"},
	plugin = {"pretty" , "html:target/cucumber-reports/reports.html"},
	
	tags = ""
		
		
		)

public class testRunner {

}

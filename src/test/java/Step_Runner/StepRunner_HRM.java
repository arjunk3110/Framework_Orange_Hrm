package Step_Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = {"src/test/resources/Feature_Files/Login_HRM.feature"},
	    glue = {"Step_Definitions"},
	    plugin = {
	        "pretty",
	         "html:target/cucumber-html-report1.html",
	         "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
	        //"tech.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
	    },
	    monochrome = true
	)

public class StepRunner_HRM extends AbstractTestNGCucumberTests {
}

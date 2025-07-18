package Step_Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = {"src/test/resources/Feature_Files/Login_HRM.feature"},
    
    	
    glue = {"Step_Definitions"}, // restrict glue to avoid scanning other classes (e.g., your listener)
    plugin = {
        "pretty",
        "html:target/cucumber-html-report.html", // basic Cucumber HTML report
      //  "tech.grasshopper.extentreports.cucumber7.adapter.ExtentCucumberAdapter" // Extent report adapter
        
    },
    monochrome = true
)
public class StepRunner_HRM extends AbstractTestNGCucumberTests {
}


package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
		  plugin = {"pretty", "html:target/cucumber-reports"},
        glue = "stepdefs",
        features = "src/test/resources/features/loan.feature"
)
public class TestRunner extends AbstractTestNGCucumberTests {

}

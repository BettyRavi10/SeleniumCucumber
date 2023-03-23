package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {".//Features/"},
		glue = "stepDefinitions",
		dryRun = false,
		publish=true,
		monochrome=true, tags = "@tag2 ",
		plugin = {"pretty", "html:test-output"	})
		
				
public class TestRun {
 
}

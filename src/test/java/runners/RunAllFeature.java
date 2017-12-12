package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:", glue = "classpath:", format = {"pretty", "html:target/report"})
public class RunAllFeature {
}
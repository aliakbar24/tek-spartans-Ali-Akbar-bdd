package tek.bdd.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features/SecurityTest.feature", // Directory for Feature file
        glue = "tek.bdd.steps",//Package for all the steps
        dryRun = true
)
public class TestRunner {
}

package support;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "definitions",
        plugin = {"json:target/cucumber.json"},
        //"pretty","html:target/site/cucumber-pretty",
        tags = "@API-REST-ASSURED")
//json:target/cucumber-report/cucumber.json

public class runTest {

}

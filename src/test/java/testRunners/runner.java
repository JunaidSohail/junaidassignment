package testRunners;

import org.junit.runner.RunWith;
import io.cucumber.testng.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions(	

features ="src/test/resources/feature/api.feature", glue = "stepDefinations")


public class runner {

}

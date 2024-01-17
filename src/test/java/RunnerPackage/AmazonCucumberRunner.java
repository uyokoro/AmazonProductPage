package RunnerPackage;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/features" }, glue = { "CucumberTestCases" })

public class AmazonCucumberRunner extends AbstractTestNGCucumberTests {

}

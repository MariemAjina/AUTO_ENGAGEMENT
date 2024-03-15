package runners;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ConfigFileReader;

import java.io.File;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps"},
        // tags = {"@SmokeTest, @Login"},
        //tags = {"@CompleteProfile"},
        tags = {"@ANATOMY,@Content-Check"},
        format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        },plugin = {"json:target/cucumber-reports/CucumberTestReport.json",
        "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"})

public class TestNGRunner {
    private TestNGCucumberRunner testNGCucumberRunner;

    /*
     * AppiumDriverFactory appiumDriverFactory =
     * AppiumDriverFactory.getInstanceOfAppiumDriverFactory(); AppiumDriver driver =
     * appiumDriverFactory.getDriver();
     */

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        //driver.quit();
        Reporter.loadXMLConfig(new File(ConfigFileReader.getConfigPropertyVal("reportConfigPath")));
        testNGCucumberRunner.finish();

    }

}

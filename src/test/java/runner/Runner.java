package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
       // dryRun = false,
        //monochrome = false,
	     plugin = {"html:target/cucumber-html/cucumber.html", "json:target/cucumber-json/cucumber.json"},
         glue = {"gluesteps"},
         features = "src/test/resources/tests"
   
        
)
public class Runner {
   /* @AfterClass
    public static void close() {
        W.close();
    }*/
}

package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.example.utils.W;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
		dryRun = false,
		monochrome = false,
		plugin = {"html:target/cucumber-html/cucumber.html", "json:target/cucumber-json/cucumber.json"},
		glue = {"gluesteps"},
		tags= "@regression" ,
		features = "src/test/resources/tests/Google.feature"

		)
public class Runner {
	@AfterClass
	public static void close() {
		W.close();
	}
}

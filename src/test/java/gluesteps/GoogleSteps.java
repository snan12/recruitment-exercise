package gluesteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.example.utils.W;

import GooglePage.GooglePage;


public class GoogleSteps {
	WebDriver webdriver;
	
	public GoogleSteps() {
	System.setProperty("webdriver.chrome.driver","D:\\Automation-Exercise\\chromedriver.exe");
	this.webdriver= W.getDriver();
	}
	
    @Given("url {string} is launched")
    public void url_is_launched(String param) {
    	
        new GooglePage(webdriver,"launch url",param).run();
    }

    
    @When("About page is shown")
    public void about_page_is_shown() {
    	 new GooglePage(webdriver,"check page").run();
    }

    @Then("page displays {string}")
    public void page_displays(String param) {
    	 new GooglePage(webdriver,"check message",param).run();
    }

    @When("searching for {string}")
    public void searching_for(String param) {
    	 new GooglePage(webdriver,"search word",param).run();
    }

    @Then("results contain {string}")
    public void results_contain(String param) {
    	 new GooglePage(webdriver,"search result",param).run();
    }

    @Then("result stats are displayed")
    public void result_stats_are_displayed(String result, int count) {
    	 new GooglePage(webdriver,result,count).run();
    }

    @Then("number of {string} is more than {int}")
    public void number_of_is_more_than(String string, int count) {
    	 new GooglePage(webdriver,"search result",count).run();
    }

}

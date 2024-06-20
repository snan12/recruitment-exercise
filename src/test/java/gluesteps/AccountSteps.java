package gluesteps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.example.utils.W;

import account.Account;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountSteps {
	
	WebDriver webdriver;
	
	public AccountSteps() {
	  String filePath = "D:\\TestProject\\Automation-Exercise\\src\\test\\resources\\tests\\Bank-Statement-Template-1-TemplateLab.pdf";
	  System.setProperty("webdriver.chrome.driver","D:\\Automation-Exercise\\chromedriver.exe");
	  this.webdriver= W.getDriver();
	  
	}

    @Given("^Account exists for Acc No\\. \"([^\"]*)\" with Name \"([^\"]*)\"$")
    public void verifyAccountExists(String accNumber, String accName) {
    	try {
    		
       new Account(webdriver,accNumber,accName,"searchAccount").run();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    }

    
    @And("deposits are made")
    
    public void VerifydepositsAreMade(DataTable dt) {
        try {
        	new Account(webdriver,dt,"deposits").run();
        } catch(Exception e) {
    		e.printStackTrace();
    	}
    }

    @And("withdrawls are made")
    public void VerifywithdrawlsAreMade(DataTable dt) {
    try {
    	new Account(webdriver,dt,"withdrawls").run();
    } catch(Exception e) {
		e.printStackTrace();
	}
    }
    
    @When("statement is produced")
    public void downloadStatement(DataTable dt) {
        try {
        	new Account(webdriver,dt,"downloadStatement").run();
        } catch(Exception e) {
    		e.printStackTrace();
    	}
        }
 

 @Then("statement includes {string}")
 public void verifyStatement(String  param) {
     try {
     	new Account(webdriver,"verifyStatement",param).run();
     } catch(Exception e) {
 		e.printStackTrace();
 	}
     
     }
 
 @Then("^statement includes \"([^\"]*)\"$")
 public void statementIncludes(String text) {
     try {
         new Account(webdriver, "verifyStatement", text).run();
     } catch (Exception e) {
         e.printStackTrace();
     }
 }

 @After
 public void tearDown() {
     W.close();
}
}
        
        
        
    
        
    

    
    
    

    
 

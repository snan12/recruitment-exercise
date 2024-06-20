package account;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import io.cucumber.datatable.DataTable;
public class Account {
	WebDriver webdriver;
	DataTable dt;
	String accNumber;
	String accName;
	String accDetails;
	String accountNumber="//input[@id='accountNumber']";
	String accountName="//input[@id='accountName']";
	String submit="//input[@id='submit']";
	String accountExists="div[@id='accountExsits']";
	String transcationRows="//tr[@class='transaction']";
	String downloadStatement="//input[@id='downloadStatement']";
	Map<String,String> actualTable =null;
	String transcation="";
	
	public Account(WebDriver webdriver, String accNumber,String accName,String transcation) {
		this.webdriver = webdriver;
		this.accName = accName;
		this.accNumber = accNumber;
		this.transcation = transcation;
		
	}
	
	public Account(WebDriver webdriver,DataTable dt,String Transcation,String name){
		this.webdriver =webdriver;
		this.dt =dt;
		this.transcation = transcation;
	} 

	
	
	public Account(WebDriver webdriver,DataTable dt,String Transcation){
		this.webdriver =webdriver;
		this.dt =dt;
		this.transcation = transcation;
	}


	public Account(WebDriver webdriver,String Transcation, String param){
		this.webdriver =webdriver;
		this.dt =dt;
		this.transcation = transcation;
	}


public void run() throws Exception{
	switch(transcation) {
	case"searchAccount":
		verifyAccount(accNumber,accName);
		break;
	case "deposits":
		verifyTranscations(dt);
		break;
	case "withdrawls":
		verifyTranscations(dt);
		break;	
	case "downloadstatements":
		verifyDownloadStatements();
		break;
	case "verifyStatement":
		verifyAccountstatement(accDetails);
		break;
	case "verifyAccount":
		verifyAccountstatement(accDetails);
		break;
	}
		
}

public void verifyAccount(String accNumber, String accName) {
	
	webdriver.get("file:///C:/Users/Deepa/OneDrive/Desktop/AccountPage.html");//it's a dummy url
	System.out.println("print" + accNumber);
	System.out.println("print" + accName);
	webdriver.findElement(By.xpath(accNumber)). sendKeys(accNumber);
	webdriver.findElement(By.xpath(accName)). sendKeys(accName);
	webdriver.findElement(By.xpath(submit)). click();
	assertTrue("Account is not found!",webdriver.findElement(By.xpath(accountExists)).isDisplayed());
	
}

public void verifyTranscations(DataTable dt) {

	List<Map<String,Integer>> expTranscation = dt.asMaps(String.class ,Integer.class);
	System.out.println("print column1" + expTranscation.get(0));
	System.out.println("print column2" + expTranscation.get(1));
	System.out.println("print cucumber table size" + expTranscation.size());
	for(Map<String , Integer > ele : expTranscation) {
		webdriver.findElements(By.xpath(transcationRows)).stream().forEach(tr-> {
			Assert.assertEquals(ele.get(0) , tr.findElement(By.tagName("th")).getText());
			Assert.assertEquals(ele.get(1) , tr.findElement(By.tagName("td")).getText());
			
		});
		
	}
}

public void verifyDownloadStatement() {
	
	if(webdriver.findElement(By.xpath("downloadStatement")).isDisplayed()) {
		webdriver.findElement(By.xpath("downloadStatement")).click();
	}
}


public void verifyDownloadStatements() {
	
	
}

public void verifyAccountstatement(String accDetails) {
	
}


}

		
		

	

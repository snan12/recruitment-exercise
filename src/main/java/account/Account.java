package account;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import io.cucumber.datatable.DataTable;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;

public class Account {
	WebDriver webdriver;
	DataTable dt;
	String accNumber;
	String accName;
	String accDetails;
	String accountNumber="//input[@id='accountNumber']";
	String accountName="//input[@id='accountName']";
	String submit="//button[@id='submitButton']";
	String accountExists="//div[@id='accountExists']";
	String transcationRows="//tr[@class='transaction']";
	String downloadStatement="//input[@id='downloadStatement']";
	String produceStatementButton="//button[@id='produceStatementButton']";
	Map<String,String> actualTable =null;
	String transcation="";
	
	public Account(WebDriver webdriver,String transcation){
		this.webdriver =webdriver;
		this.transcation = transcation;
	}
	
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
		System.out.println("print here"+dt);
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
		verifyDownloadStatement();
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
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("print" + accNumber);
	System.out.println("print" + accName);
	webdriver.findElement(By.xpath(accNumber)). sendKeys(accNumber);
	webdriver.findElement(By.xpath(accName)). sendKeys(accName);
	webdriver.findElement(By.xpath(submit)). click();
	assertTrue("Account is not found!",webdriver.findElement(By.xpath(accountExists)).isDisplayed());
	
}

public void verifyTranscations(DataTable dt) {

	List<Map<String,String>> dataTableTranscation = dt.asMaps(String.class ,String.class);
	Map<String, String> htmlTransactionTableMap =  new HashMap();
	List<Map<String,String>> hashMapListObj = null;
	System.out.println("print table" + dataTableTranscation);
	System.out.println("print column1" + dataTableTranscation.get(0));
	System.out.println("print column2" + dataTableTranscation.get(1));
	System.out.println("print cucumber table size" + dataTableTranscation.size());
	for(Map<String , String > ele : dataTableTranscation) {
		System.out.println("print column1" + ele.get(0));
		System.out.println("print column2" + ele.get(1));
	}
		webdriver.findElements(By.xpath(transcationRows)).stream().forEach(tr-> {
			String colone = tr.findElement(By.tagName("th")).getText();
			String coltwo = tr.findElement(By.tagName("td")).getText();
			htmlTransactionTableMap.put(colone, coltwo);
			hashMapListObj.add(htmlTransactionTableMap);
		});
		
		Assert.assertTrue(dataTableTranscation.equals(hashMapListObj));
		
		

}

public void verifyDownloadStatement() {
	
	if(webdriver.findElement(By.xpath("produceStatementButton")).isDisplayed()) {
		webdriver.findElement(By.xpath("produceStatementButton")).click();
		
	}
}


public void verifyAccountstatement(String accDetails) throws IOException {
	String filePath="D:\\TestProject\\Automation-Exercise\\src\\test\\resources\\tests\\Bank-Statement-Template-1-TemplateLab.pdf";
	File file = new File(filePath);
		PDDocument document = null;
		try {
			document = Loader.loadPDF(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PDFTextStripper stripper = new PDFTextStripper();
		String text;
		try {
			text = stripper.getText(document);
			System.out.println(text);
			Assert.assertTrue(text.contains("John Smith"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        //Assert.assertTrue(text.contains("Account Type"));
        //Assert.assertTrue(text.contains("Location"));
		
	

	
}


}

		
		

	

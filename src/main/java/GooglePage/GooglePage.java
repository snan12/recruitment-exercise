package GooglePage;

//import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import dev.failsafe.internal.util.Assert;

public class GooglePage {
	WebDriver webdriver = null;
	String param;
	String conditionToVerify="";
	int count;
	WebElement scrollbar;
	JavascriptExecutor js;
	
	String about="//a[text()='About']";
	String mission="//h1[contains(text(),'Our mission')]";
	String search="//textarea[@name='q']";
	String homepage="//h3[text()='Home - BBC News']";
	String acceptAll = "//button[@id='L2AGLb']";
	
	
	public GooglePage(WebDriver webdriver, String conditionToVerify) {
		this.webdriver=webdriver;
		this.conditionToVerify = conditionToVerify;
	}
	
	public GooglePage(WebDriver webdriver, String conditionToVerify, String param) {
		this.webdriver = webdriver;
		this.conditionToVerify = conditionToVerify;
		this.param=param;
	}

	public GooglePage(WebDriver webdriver, String conditionToVerify, int count) {
		this.webdriver = webdriver;
		this.conditionToVerify = conditionToVerify;
		this.count=count;
	}
	public void run() {
		System.out.println("Running condition: " + conditionToVerify);
		switch(conditionToVerify) {
		case"launch url":
			System.out.println("Launching URL: " + param);
			webdriver.get(param);
			//assertEquals(param+"/",webdriver.getCurrentUrl());
			//Screenshot.take(webdriver,new File(""),"firstpage.png");
			break;
		case "check page":
			System.out.println("Checking About page");
			//assertTrue(webdriver.findElement(By.xpath(about)).isDisplayed());
			//Screenshot.take(webdriver,new File(""),"aboutpage.png");
			break;
		case "check message":
			System.out.println("Checking message: " + param);
			 scrollbar = webdriver.findElement(By.xpath(acceptAll));
			js = (JavascriptExecutor) webdriver;
			js.executeScript("arguments[0].scrollIntoView();", scrollbar);
			webdriver.findElement(By.xpath(acceptAll)).click();
			if(webdriver.findElement(By.xpath(about)).isDisplayed()) {
			webdriver.findElement(By.xpath(about)).click();
			}
			
			String missionstat = webdriver.findElement(By.xpath(mission)).getText();
			System.out.println("Print mission" + missionstat);
			//assertEquals(param+"not displayed",param,missionstat);
			//Screenshot.take(webdriver,new File("")),"missionpage.png");
			break;
		case "search word":
			System.out.println("Searching for word: " + param);
			 scrollbar = webdriver.findElement(By.xpath(acceptAll));
			 js = (JavascriptExecutor) webdriver;
			js.executeScript("arguments[0].scrollIntoView();", scrollbar);
			webdriver.findElement(By.xpath(acceptAll)).click();
			if(webdriver.findElement(By.xpath(search)).isDisplayed()) {
				webdriver.findElement(By.xpath(search)).click();
			webdriver.findElement(By.xpath(search)).sendKeys(param);
			}
			webdriver.findElement(By.xpath(search)).sendKeys(Keys.ENTER);
			break;
		case "search result":
			System.out.println("Checking search result: " + param);
		    if(webdriver.findElement(By.xpath(homepage)).isDisplayed()) {
			String bbcHomepage = webdriver.findElement(By.xpath(homepage)).getText();
		    }
			//Assert.assertEquals(param+"not displayed",param,bbcHomePage);
			//Screenshot.take(webdriver,new File(""),"bbcHomePage.png");
			break;
		case "results":
			break;
		case"seconds":
			break;
	}

	/*public void verifyAccount(String accNumber,String accName) {
		webdriver.get("file://");
		System.out.println("print" + accNum);
	}*/

}}

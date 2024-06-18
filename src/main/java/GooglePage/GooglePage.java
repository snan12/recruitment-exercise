package GooglePage;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GooglePage {
	WebDriver webdriver = null;
	String param;
	String conditionToVerify="";
	int count;
	String about="//";
	String mission="";
	String search="";
	String homepage="";
	
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
		switch(conditionToVerify) {
		case"launch url":
			webdriver.get(param);
			//Assert.assertEquals(param+"/",webdriver.getCurrentUrl());
			//Screenshot.take(webdriver,new File(""),"firstpage.png");
			break;
		case "check page":
			Assert.assertTrue(webdriver.findElement(By.xpath(about)).isDisplayed());
			//Screenshot.take(webdriver,new File(""),"aboutpage.png");
			break;
		case "check message":
			String missionstat = webdriver.findElement(By.xpath(mission)).getText();
			System.out.println("print stat" +missionstat);
			Assert.assertEquals(param+"not displayed",param,missionstat);
			//Screenshot.take(webdriver,new File("")),"missionpage.png");
			break;
		case "search word":
			webdriver.navigate().back();
			webdriver.findElement(By.xpath(search)).sendKeys(param);
			//Screenshot.take(webdriver,""),"searchpage.png");
			break;
		case "search result":
			String bbcHomepage = webdriver.findElement(By.xpath(homepage)).getText();
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

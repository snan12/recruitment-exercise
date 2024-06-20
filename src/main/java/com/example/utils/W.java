package com.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class W {
	
	    private static WebDriver driver;

	    public static WebDriver getDriver() {
	        if (driver == null) {
	            System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver-win64\\chromedriver.exe"); 
	            driver = new ChromeDriver();
	        }
	        return driver;
	    }

	    public static void close() {
	        if (driver != null) {
	            driver.quit();
	            driver = null;
	        }
	    }
	}



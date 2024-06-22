package com.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.example.utils.*;

public class W  {
	
	    private static WebDriver driver;

	    public WebDriver getWebDriver() {
	        ChromeOptions chromeOptions = new ChromeOptions();
	        chromeOptions.addArguments("--start-maximized");
	        return driver = new ChromeDriver(chromeOptions);
	        
	 
	    }

	    public static void close() {
	        try {
				try {
					driver.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}



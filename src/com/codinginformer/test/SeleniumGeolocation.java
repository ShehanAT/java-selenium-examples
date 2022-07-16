package com.codinginformer.test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumGeolocation {

	@Before
	public void initFirefox() {
		Properties properties = new Properties();
		System.setProperty("webdriver.gecko.driver", System.getenv("GEEKODRIVER_PATH"));
		System.setProperty("webdriver.firefox.bin", System.getenv("FIREFOX_PATH"));
		WebDriver driver = new FirefoxDriver();
	}
	
	@Test
	public void checkGeolocation() {
		String baseUrl = "https://selenium-testing-website.herokuapp.com/upload";
		
		WebDriver driver = new FirefoxDriver();

    	driver.get(baseUrl);
    	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
			
			
	}
}

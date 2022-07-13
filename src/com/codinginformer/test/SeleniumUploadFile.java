package com.codinginformer.test;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumUploadFile {

	@Before
	public void initFirefox() {
		Properties properties = new Properties();
		System.setProperty("webdriver.gecko.driver", System.getenv("GEEKODRIVER_PATH"));
		System.setProperty("webdriver.firefox.bin", System.getenv("FIREFOX_PATH"));
		WebDriver driver = new FirefoxDriver();
	}
	
	
	@Test 
	public void uploadFile() {
	        String baseUrl = "http://the-internet.herokuapp.com/upload";
	       
	        WebDriver driver = new FirefoxDriver();

	        driver.get(baseUrl);
	        WebElement uploadElement = driver.findElement(By.id("file-upload"));
	 
	        
	        uploadElement.sendKeys("C:\\newhtml.html");


	        driver.findElement(By.id("file-submit")).click();

			// Next steps: if image file is uploaded, check for the existence of the image in the following page. If not, check for the existence of non-image page in the following page
	}
 	
	
}

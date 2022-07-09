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

public class SeleniumUploadGitHubProfilePic {

	@Before
	public void initFirefox() {
		Properties properties = new Properties();
		System.setProperty("webdriver.gecko.driver", System.getenv("GEEKODRIVER_PATH"));
		System.setProperty("webdriver.firefox.bin", System.getenv("FIREFOX_PATH"));
		WebDriver driver = new FirefoxDriver();
	}
	
//	@Test 
//	public void uploadFile() {
//	        String baseUrl = "http://the-internet.herokuapp.com/upload";
//	       
//	        WebDriver driver = new FirefoxDriver();
//
//	        driver.get(baseUrl);
//	        WebElement uploadElement = driver.findElement(By.id("file-upload"));
//	 
//	        
//	        uploadElement.sendKeys("C:\\newhtml.html");
//
//
//	        driver.findElement(By.id("file-submit")).click();
//	}
 	
	
	@Test
	public void uploadGitHubProfilePic() throws Exception{
	   WebDriver driver = new FirefoxDriver();
		driver.get("https://github.com/settings/profile");
		Thread.sleep(2000);// Xpath for Edit button

		WebElement usernameField = driver.findElement(By.xpath("//input[@id='login_field']"));
		WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
		
		usernameField.sendKeys(System.getenv("GITHUB_USERNAME"));
		passwordField.sendKeys(System.getenv("GITHUB_PASSWORD"));
		
		WebElement loginSubmitBtn = driver.findElement(By.xpath("//input[@value='Sign in']"));
		
		((RemoteWebDriver) driver).executeScript("arguments[0].click();", loginSubmitBtn);
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		WebElement file = driver.findElement(By.xpath("//div[@class='position-absolute bg-gray-dark rounded-2 text-white px-2 py-1 left-0 bottom-0 ml-2 mb-2']"));
		file.click(); //link text locator for uploading a photo..
		WebElement addFile = driver.findElement(By.linkText("Upload a photo..."));
		addFile.click();
		
		
		// Mention the own path of the file location

		// Add file method 
		addFile.sendKeys("C:\\newhtml.html");// For setting a profile picture

		driver.findElement(By.linkText("Set new profile picture")).click();
		Thread.sleep(2000);// Image name can be of your choice

		if(driver.findElement(By.xpath(".//a[text()='caps.jpeg']")).isDisplayed()) {
//			assertTrue(true, "Profile picture is Uploaded");
			System.out.println("Profile pic is uploaded");
		}else {
//			assertTrue(false, "Profile picture not Uploaded");
			System.out.println("Profile pic is not uploaded");
		}
	}
}

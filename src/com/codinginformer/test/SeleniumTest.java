package com.codinginformer.test;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeTest;

public class SeleniumTest {

		@Before
		public void initFirefox() {
			Properties properties = new Properties();
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\sheha\\OneDrive\\Documents\\JavaApplications\\geckodriver\\geckodriver.exe");
			System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			WebDriver driver = new FirefoxDriver();
		}
	
	 	@Test
	    public void safariTest() {
	        WebDriver driver = new FirefoxDriver();
	        driver.get("https://the-internet.herokuapp.com/");
	        driver.quit();
	    }
	    
	 	@Test
	    public void cypressTest() throws InterruptedException {
	        WebDriver driver = new FirefoxDriver();
	        driver.get("https://example.cypress.io/");
	        Thread.sleep(3000);
	        driver.quit();
	    }
	    
	    @Test
	    public void shoppingCartTest() throws InterruptedException {
	        WebDriver driver = new FirefoxDriver();
	        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
	        Thread.sleep(3000);
	        driver.quit();
	    }
	
}

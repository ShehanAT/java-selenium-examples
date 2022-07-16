package com.codinginformer.test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

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
		String baseUrl = "https://selenium-testing-website.herokuapp.com/geolocation";
		
		FirefoxProfile geoDisabled = new FirefoxProfile();
		geoDisabled.setPreference("geo.enabled", true);
		geoDisabled.setPreference("geo.provider.use_corelocation", true);
		geoDisabled.setPreference("geo.prompt.testing", true);
		geoDisabled.setPreference("geo.prompt.testing.allow", true);
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability(FirefoxDriver.PROFILE, geoDisabled);
		
		@SuppressWarnings("deprecation")
		WebDriver driver = new FirefoxDriver(capabilities);

    	driver.get(baseUrl);
    	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		driver.findElement(By.id("get-geolocation")).click();
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		Assert.assertNotNull(driver.findElement(By.id("lat-value")).getText());
		Assert.assertNotNull(driver.findElement(By.id("long-value")).getText());
			
			
	}
}

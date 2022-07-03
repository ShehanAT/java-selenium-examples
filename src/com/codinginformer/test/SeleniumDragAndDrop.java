package com.codinginformer.test;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeTest;

public class SeleniumDragAndDrop {
	
	@Before
	public void initFirefox() {
		Properties properties = new Properties();
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\sheha\\OneDrive\\Documents\\JavaApplications\\geckodriver\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		WebDriver driver = new FirefoxDriver();
	}
	
	
 	@Test
    public void dragAndDropElement() {
        WebDriver driver = new FirefoxDriver();

    	driver.get("https://www.globalsqa.com/demo-site/draganddrop/#Accepted%20Elements");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		
		
		WebElement acceptedElementsTab = driver.findElement(By.xpath("//*[@id='Accepted Elements']"));

		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		((RemoteWebDriver) driver).executeScript("arguments[0].click();", acceptedElementsTab);

		WebElement iframe = driver.findElement(By.cssSelector("iframe[data-src='../../demoSite/practice/droppable/accepted-elements.html']"));
		System.out.println("Selected Iframe: ");
		System.out.println(iframe.getTagName());
		driver.switchTo().frame(iframe);
		
		WebElement dragElement = driver.findElement(By.xpath("//*[@id='draggable']"));
		WebElement dropElement = driver.findElement(By.xpath("//*[@id='droppable']"));
		
		Actions dragAndDropAction = new Actions(driver);
		dragAndDropAction.moveToElement(dragElement).dragAndDrop(dragElement, dropElement).build().perform();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
//		driver.quit();
 	}
}

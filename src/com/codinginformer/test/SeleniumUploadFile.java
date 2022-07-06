package com.codinginformer.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumUploadFile {

	public static void main(String[] args) throws IOException, InterruptedException {
		   // TODO Auto-generated method stub
		 
		   WebDriver d = new FirefoxDriver();
		   
		   d.get("https://ps.uci.edu/~franklin/doc/file_upload.html");
		   d.manage().window().maximize();
		   d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			
//		   d.manage().window().maximize(); //always write wait code after this
//		   d.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); //for page load
//		   d.get("https://www.monsterindia.com/seeker/registration"); //Testing webpage
//		   d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //for Implicit wait
		 
//		   JavascriptExecutor js = (JavascriptExecutor); //Scrolling using JavascriptExecutor
//		   js.executeScript("window.scrollBy(0,380)");//Scroll Down to file upload button (+ve)
//		   Thread.sleep(3000);
		 
		   // FILE UPLOADING USING SENDKEYS ....
		 
		   WebElement fileUpload = d.findElement(By.xpath("//input[@value='Send File']"));
		   //click on ‘Choose file’ to upload the desired file
		   
		   fileUpload.sendKeys(System.getenv("FILE_UPLOAD_PATH");); //Uploading the file using sendKeys
		   System.out.println("File is Uploaded Successfully");
		 
		   }
}

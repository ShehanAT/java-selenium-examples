package test.utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({ExtentITestListenerClassAdapter.class, ReportListener.class})
public class BaseTest {
	protected static WebDriver driver;
//	protected WelcomePage welcomePage;
	
	public static WebDriver getDriver() {
		return driver;
	}

	@BeforeMethod
	public void preCondition() {
		
	}
	
	@AfterMethod
	public void postCondition() {
		
	}
}

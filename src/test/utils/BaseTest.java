package test.utils;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({ExtentITestListenerClassAdapter.class, ReportListener.class})
public class BaseTest {
	protected static WebDriver driver;
	protected WelcomePage welcomePage;
	
	public static WebDriver getDriver() {
		return driver;
	}

	@BeforeMethod
	public void preCondition() {
		driver = new DriverFactory().createInstance();
		driver.manage().window().maximize();
		driver.get(returnConfigValue("url.base"));
		welcomePage = new WelcomePage(driver)
				
	}
	
	@AfterMethod
	public void postCondition() {
		driver.quit();
	}
}

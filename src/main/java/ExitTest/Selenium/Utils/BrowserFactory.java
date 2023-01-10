package ExitTest.Selenium.Utils;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class BrowserFactory {
	
	public static WebDriver driver;
	public static ExtentTest test;
	public static ExtentReports extent;
	
	String browserName = ReadingPropertiesFile.getProperty("browser");
	String browserMode = ReadingPropertiesFile.getProperty("browserMode");
	
	Logger log =  LogManager.getLogger(BrowserFactory.class);
	 
	@BeforeSuite
	public void initializeDriver() throws IOException {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty(ReadingPropertiesFile.getProperty("driverChrome"), ReadingPropertiesFile.getProperty("chromeDriverPath"));
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty(ReadingPropertiesFile.getProperty("driverFirefox"), ReadingPropertiesFile.getProperty("firefoxDriverPath"));
		}
		
		else if(browserName.equalsIgnoreCase("edge")) {
			System.setProperty(ReadingPropertiesFile.getProperty("driverEdge"), ReadingPropertiesFile.getProperty("edgeDriverPath"));
		}
		
		else {
			System.out.println("Not a valid browser");
		}
		
	}
	
	 @BeforeTest
	   public void openBrowser() {
		 
			 if(browserName.equalsIgnoreCase("Chrome")) {
				 
				 ChromeOptions options = new ChromeOptions();
				 options.addArguments(browserMode);
				 options.addArguments("start-maximized");
				 driver = new ChromeDriver(options);
				 log.info("Opening Chrome browser in "+ browserMode +" mode");
			 }
			 
			 else if(browserName.equalsIgnoreCase("Firefox")) {
				 
				  FirefoxOptions options = new FirefoxOptions();
				  options.addArguments(browserMode);
				  options.addArguments("start-maximized");
				  driver = new FirefoxDriver(options);
				  log.info("Opening Firefox browser in "+ browserMode +" mode");
			 }
			 
			 else if(browserName.equalsIgnoreCase("Edge")) {
				 
				 EdgeOptions options = new EdgeOptions();
				 options.addArguments(browserMode);
				 options.addArguments("start-maximized");
				 driver = new EdgeDriver(options);
				 log.info("Opening Firefox browser in "+ browserMode +" mode");
			 }

		   driver.manage().window().maximize();
		   extent = ExtentManager.getInstance("reports//ExtentReport.html");
		   
	   }
	 
	 @BeforeMethod
	 public void startTest(Method method) throws Exception{
		
		 test = extent.startTest(method.getName());
		 
		 log.info("Opening Flipkart.com");
		 driver.get(ReadingPropertiesFile.getProperty("url"));
		 
		 log.info("Testcase "+method.getName()+" started");
	 }
	 
	 @AfterMethod
	 public void status(ITestResult result) {
		 
		 if(result.getStatus()==ITestResult.SUCCESS) {
			 test.log(LogStatus.PASS, "Test case passed");
			 log.info("Testcase " + result.getName() + " passed");
			 System.out.println(result.getName() + " : Passed");
		 }
		 else if(result.getStatus()==ITestResult.FAILURE) {
			 log.info("Testcase " + result.getName() + " failed");
			 System.out.println(result.getName() + " : Failed");
			 String screenshotPath = Screenshots.takeScreenShot(driver, result.getName());
			 test.log(LogStatus.ERROR, result.getThrowable());
			 test.log(LogStatus.FAIL, "Test case failed");
			 test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		 }
		 else if(result.getStatus()==ITestResult.SKIP) {
			 test.log(LogStatus.SKIP, "Test case skipped");
			 log.info("Testcase " + result.getName() + " skipped");
			 System.out.println(result.getName() + " : Skipped");
		 }
		 
		 extent.flush();
	 }
	 
	 @AfterSuite
	   public void quitBrowser() {
		 log.info("Quitting Browser");
		   driver.quit();
		   log.info("Browser closed");
	   }
}

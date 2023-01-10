package ExitTest.Selenium.Pages;

import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ExitTest.Selenium.Utils.ReadingPropertiesFile;

public class AboutUsPage {

	WebDriver driver;
	WebDriverWait wait;
	Logger log = LogManager.getLogger(AboutUsPage.class);
	
	// Constructor to initialize driver
	
	public AboutUsPage(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	/********************************* Locators *********************/
	
	@FindBy(xpath = "//a[contains(text(),'About Us')]")
	WebElement btn_aboutUs;
	
	@FindBy(xpath = "//button[contains(text(),'✕')]")
	WebElement btn_close;
	
	// Method to open about us page
	
	public void aboutUs() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		try {
			wait.until(ExpectedConditions.visibilityOf(btn_close)).click();          // try-catch block to handle login popup
		}
		catch(Exception e) {}
		
		// Code snippet to go to bottom of page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		log.info("Scrolled to bottom of page");
		
		wait.until(ExpectedConditions.elementToBeClickable(btn_aboutUs)).click();            // waiting till button is clickable
		log.info("Clicked on 'About Us'");
		
		wait.until(ExpectedConditions.titleContains(ReadingPropertiesFile.getProperty("aboutUsTitle")));      // waiting till page title loads
		log.info("About Us page opened");
	}
}

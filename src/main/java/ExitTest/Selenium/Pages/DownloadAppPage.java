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

public class DownloadAppPage {

	WebDriver driver;
	WebDriverWait wait;
	Logger log = LogManager.getLogger(SellerPage.class);
	
	// Constructor to initialize driver
	
	public DownloadAppPage(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	/************************ Locators ******************/
	
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/a[1]/span[1]")
	WebElement btn_becomeSeller;
	
	@FindBy(xpath = "//body/div[@id='app']/div[4]/div[1]/div[3]/ul[1]/li[3]/a[1]/img[1]")
	WebElement btn_googlePlay;
	
	@FindBy(xpath = "//body/div[@id='app']/div[4]/div[1]/div[3]/ul[1]/li[2]/a[1]/img[1]")
	WebElement btn_appStore;
	
	@FindBy(xpath = "//button[contains(text(),'✕')]")
	WebElement btn_close;
	
	public void downloadFromAppStore() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		try {
			wait.until(ExpectedConditions.visibilityOf(btn_close)).click();                 // try-catch block to handle login popup
		}
		catch(Exception e) {}
		
		log.info("Clicking on 'Become a Seller'");
		wait.until(ExpectedConditions.visibilityOf(btn_becomeSeller)).click();
		
		// Code snippet to go to bottom of page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		log.info("Scrolled to bottom of page");
		
		wait.until(ExpectedConditions.visibilityOf(btn_appStore)).click();
		log.info("Clicked on App Store button");
		
		wait.until(ExpectedConditions.titleContains(ReadingPropertiesFile.getProperty("appleKeyword")));
		log.info("Redirected to App Store");
	}
	
	public void downloadFromGooglePlay() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		try {
			wait.until(ExpectedConditions.visibilityOf(btn_close)).click();             // try-catch block to handle login popup
		}
		catch(Exception e) {}
		
		log.info("Clicking on 'Become a Seller'");
		wait.until(ExpectedConditions.visibilityOf(btn_becomeSeller)).click();
		
		// Code snippet to go to bottom of page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		log.info("Scrolled to bottom of page");
		
		wait.until(ExpectedConditions.visibilityOf(btn_googlePlay)).click();
		log.info("Clicked on Google Play Button");
		
		wait.until(ExpectedConditions.titleContains(ReadingPropertiesFile.getProperty("googleKeyword")));
		log.info("Redirected to Google Play Store");
	}
	
	
}

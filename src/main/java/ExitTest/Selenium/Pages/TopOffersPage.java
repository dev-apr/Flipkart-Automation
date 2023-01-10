package ExitTest.Selenium.Pages;

import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ExitTest.Selenium.Utils.ReadingPropertiesFile;

public class TopOffersPage {

	WebDriver driver;
	WebDriverWait wait;
	Logger log = LogManager.getLogger(TopOffersPage.class);
	
	// Constructor to initialize driver
	
	public TopOffersPage(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	/*********************** Locators ********************************/
	
	@FindBy(xpath = "//div[contains(text(),'Top Offers')]")
	WebElement btn_offers;
	
	@FindBy(xpath = "//button[contains(text(),'✕')]")
	WebElement btn_close;
	
	// Method to view offers
	
	public void viewOffers() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		try { 
			wait.until(ExpectedConditions.visibilityOf(btn_close)).click();             // try-catch block to handle login popup
		}
		catch(Exception e) {}
		
		log.info("Clicking on 'Top Offers'");
		wait.until(ExpectedConditions.visibilityOf(btn_offers)).click();
		
		wait.until(ExpectedConditions.titleContains(ReadingPropertiesFile.getProperty("offerKeyword")));   // Waiting till page loads
		log.info("Top Offers page opened");
	}
}

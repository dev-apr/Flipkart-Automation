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

public class FlipkartPlusPage {

	WebDriver driver;
	WebDriverWait wait;
	Logger log = LogManager.getLogger(CartPage.class);
	
	// Constructor to initialize driver
	
	public FlipkartPlusPage(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	/******************************* Locators ****************************/
	
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[2]")
	WebElement btn_flipkartPlus;
	
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[1]/div[1]/a[1]/div[1]/div[1]/img[2]")
	WebElement btn_coinBalance;
	
	@FindBy(xpath = "//button[contains(text(),'✕')]")
	WebElement btn_close;
	
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[2]/div[1]/a[1]/div[1]/div[1]/img[2]")
	WebElement btn_rewardStore;
	
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[1]/div[2]/div[4]/div[1]/a[1]/div[1]/div[1]/img[2]")
	WebElement btn_claimedRewards;
	
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[1]/div[2]/div[5]/div[1]/div[1]/div[1]/a[1]")
	WebElement btn_viewAll;
	
	// Method to view coin balance
	
	public void checkCoinBalance() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		try {
			wait.until(ExpectedConditions.visibilityOf(btn_close)).click();
		}
		catch(Exception e) {}
		
		log.info("Clicking flipkart plus button");
		wait.until(ExpectedConditions.visibilityOf(btn_flipkartPlus)).click();
		
		log.info("Clicking on 'My Coin Balance'");
		wait.until(ExpectedConditions.visibilityOf(btn_coinBalance)).click();
		
		wait.until(ExpectedConditions.titleContains(ReadingPropertiesFile.getProperty("coinsKeyword")));   // waiting till page loads
	}
	
	// Method to view available rewards
	
	public void viewRewards() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		log.info("Clicking flipkart plus button");
		wait.until(ExpectedConditions.visibilityOf(btn_flipkartPlus)).click();
		
		log.info("Clicking on 'My Reward Store'");
		wait.until(ExpectedConditions.visibilityOf(btn_rewardStore)).click();
		
		wait.until(ExpectedConditions.titleContains(ReadingPropertiesFile.getProperty("rewardKeyword")));       // waiting till page loads
		
	}
	
	// Method to view claimed rewards
	
	public void claimedRewards() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));       // try-catch block to handle login popup
		
		log.info("Clicking flipkart plus button");
		wait.until(ExpectedConditions.visibilityOf(btn_flipkartPlus)).click();
		
		log.info("Clicking on 'My Reward Store'");
		wait.until(ExpectedConditions.visibilityOf(btn_rewardStore)).click();
		
		log.info("Clicking on 'View Claimed Rewards'");
		wait.until(ExpectedConditions.visibilityOf(btn_claimedRewards)).click();
		
		wait.until(ExpectedConditions.titleContains(ReadingPropertiesFile.getProperty("claimedKeyword")));           // waiting till page title loads
	}
	
	// Method to see exclusive offers
	
	public void exclusiveOffers() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));                 // try-catch block to handle login popup
		
		log.info("Clicking flipkart plus button");
		wait.until(ExpectedConditions.visibilityOf(btn_flipkartPlus)).click();
		
		log.info("Clicking on 'My Reward Store'");
		wait.until(ExpectedConditions.visibilityOf(btn_rewardStore)).click();
		
		log.info("Clicking on 'View All'");
		wait.until(ExpectedConditions.visibilityOf(btn_viewAll)).click();

		wait.until(ExpectedConditions.titleContains(ReadingPropertiesFile.getProperty("exclusiveKeyword")));         // waiting till page title loads
	}
}

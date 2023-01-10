package ExitTest.Selenium.Pages;

import java.time.Duration;
import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuyProductPage {

	WebDriver driver;
	WebDriverWait wait;
	Logger log = LogManager.getLogger(BuyProductPage.class);
	
	// Constructor to initialize driver
	
	public BuyProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*************************** Locators ********************************/
	
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/input[1]")
	WebElement txt_search;
	
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/button[1]")
	WebElement btn_search;
	
	@FindBy(xpath = "//div[contains(text(),'APPLE iPhone 14 (Purple, 128 GB)')]")
	WebElement btn_iphone;
	
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/button[1]")
	WebElement btn_addToCart;
	
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/form[1]/button[1]")
	WebElement btn_buyNow;
	
	@FindBy(xpath = "//a[contains(text(),'APPLE iPhone 14 (Purple, 128 GB)')]")
	public WebElement txt_iphone;
	
	@FindBy(xpath = "//button[contains(text(),'✕')]")
	WebElement btn_close;
	
	@FindBy(xpath = "//span[contains(text(),'CONTINUE')]")
	WebElement btn_continue;
	
	// Method to add item to cart
	
	public void addToCart(String product) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		try {
			wait.until(ExpectedConditions.visibilityOf(btn_close)).click();        // try-catch block to handle login popup
		}
		catch(Exception e) {}
		
		log.info("Searching for product");
		wait.until(ExpectedConditions.visibilityOf(txt_search)).sendKeys(product);        // waiting till element is visible then sending keys to enter
		btn_search.click();
		
		wait.until(ExpectedConditions.visibilityOf(btn_iphone)).click();                 // waiting till button is visible then clicking      
		
		// Code snippet for switching to newly opened tab
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(0));
	    driver.close();  
	    driver.switchTo().window(tabs2.get(1));
	    
		
		wait.until(ExpectedConditions.visibilityOf(btn_addToCart)).click();
		log.info("Add to cart button clicked");
		wait.until(ExpectedConditions.visibilityOf(txt_iphone));
		log.info("Product added to cart");
		
	}
	
	// Method to buy product
	
	public void buyProduct(String product) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		try {
			wait.until(ExpectedConditions.visibilityOf(btn_close)).click();                  // try-catch block to handle login popup
		}
		catch(Exception e) {}
		
		log.info("Searching for product");
		wait.until(ExpectedConditions.visibilityOf(txt_search)).sendKeys(product);
		btn_search.click();
		
		wait.until(ExpectedConditions.visibilityOf(btn_iphone)).click();
		
		// Code snippet for switching to newly opened tab
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(0));
	    driver.close();
	    driver.switchTo().window(tabs2.get(1));
	    
	    wait.until(ExpectedConditions.visibilityOf(btn_buyNow)).click();
		wait.until(ExpectedConditions.visibilityOf(btn_continue));
		log.info("On checkout page");
	}
}

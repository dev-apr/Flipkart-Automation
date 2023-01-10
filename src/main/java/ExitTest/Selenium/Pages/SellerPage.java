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

public class SellerPage {

	WebDriver driver;
	WebDriverWait wait;
	Logger log = LogManager.getLogger(SellerPage.class);
	
	// Constructor to initialize driver
	
	public SellerPage(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	/************************************* Locators *********************************/
	
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/a[1]/span[1]")
	WebElement btn_becomeSeller;
	
	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/button[1]")
	WebElement btn_startSelling;
	
	@FindBy(xpath = "//body/div[@id='app-container']/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/input[1]")
	WebElement txt_mobile;
	
	@FindBy(xpath = "//body/div[@id='app-container']/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[2]/input[1]")
	WebElement txt_email;
	
	@FindBy(xpath = "//body/div[@id='app-container']/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/input[1]")
	WebElement txt_gstin;
	
	@FindBy(xpath = "//span[contains(text(),'Register & Continue')]")
	WebElement btn_register;
	
	@FindBy(xpath = "//button[contains(text(),'✕')]")
	WebElement btn_close;
	
	@FindBy(xpath = "//span[contains(text(),'Login')]")
	WebElement btn_login;
	
	@FindBy(xpath = "//body/div[@id='app']/div[3]/section[1]/section[1]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]")
	WebElement txt_phone;
	
	@FindBy(xpath = "//span[contains(text(),'Next')]")
	WebElement btn_next;
	
	@FindBy(xpath = "//div[contains(text(),'The account does not exist, please enter valid acc')]")
	public WebElement txt_error;
	
	// Method to register for seller
	
	public void sellerRegister(String mobile, String email, String gstin) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		try {    
			wait.until(ExpectedConditions.visibilityOf(btn_close)).click();           // try-catch block to handle login popupv
		}
		catch(Exception e) {}
		
		log.info("Clicking on 'Become a Seller'");
		wait.until(ExpectedConditions.visibilityOf(btn_becomeSeller)).click();         // waiting till button is visible then clicking
		
		log.info("Clicking on 'Start Selling'");
		wait.until(ExpectedConditions.visibilityOf(btn_startSelling)).click();
		
		log.info("Registering for seller");
		wait.until(ExpectedConditions.visibilityOf(txt_mobile)).sendKeys(mobile);           // waiting till element is visible then sending keys
		wait.until(ExpectedConditions.visibilityOf(txt_email)).sendKeys(email);
		wait.until(ExpectedConditions.visibilityOf(txt_gstin)).sendKeys(gstin);
		btn_register.click();
	}
	
	public void sellerLogin(String phone) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		try {
			wait.until(ExpectedConditions.visibilityOf(btn_close)).click();        // try-catch block to handle login popup
		}
		catch(Exception e) {}
		
		log.info("Clicking on 'Become a Seller'");
		wait.until(ExpectedConditions.visibilityOf(btn_becomeSeller)).click();     // waiting till button is visible then clicking
		
		log.info("Clicking on Login");
		wait.until(ExpectedConditions.visibilityOf(btn_login)).click();
		
		log.info("Entering mobile no.");
		wait.until(ExpectedConditions.visibilityOf(txt_phone)).sendKeys(phone);        // waiting till element is visible then sending keys
		
		btn_next.click();
		
		wait.until(ExpectedConditions.visibilityOf(txt_error));
	}
	
}

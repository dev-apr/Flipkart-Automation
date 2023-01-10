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

public class CreateAccountPage {

	WebDriver driver;
	WebDriverWait wait;
	Logger log = LogManager.getLogger(CreateAccountPage.class);
	
	// Constructor to initialize driver
	
	public CreateAccountPage(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	/************************************* Locators ************************************************/
	
	@FindBy(xpath = "//a[contains(text(),'New to Flipkart? Create an account')]")
	WebElement btn_createAcc;
	
	@FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/input[1]")
	WebElement txt_mobile;
	
	@FindBy(xpath = "//span[contains(text(),'CONTINUE')]")
	WebElement btn_continue;
	
	@FindBy(xpath = "//span[contains(text(),'Signup')]")
	public WebElement btn_signUp;
	
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement btn_login;
	
	// Method for creating new account
	
	public void createNewAccount(String mobile){
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		try {
			wait.until(ExpectedConditions.visibilityOf(btn_login)).click();          // try-catch block to handle login popup
		}
		catch(Exception e) {}
		
		log.info("Creating new account");
		log.info("Clicking 'Create an account' button");
		wait.until(ExpectedConditions.visibilityOf(btn_createAcc)).click();            // waiting till button is visible then clicking
		log.info("Entering mobile no.");
		
		wait.until(ExpectedConditions.visibilityOf(txt_mobile)).sendKeys(mobile);
		btn_continue.click();
		log.info("OTP sent for creating new account");
	}
	
	// Method for asserting whether the signup button is displayed or not
	
	public boolean isButtonDisplayed(WebElement btn) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(btn));
		
		return btn.isDisplayed();
	}
}

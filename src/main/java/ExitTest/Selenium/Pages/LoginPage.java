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

public class LoginPage{
	
	WebDriver driver;
	WebDriverWait wait;
	Logger log = LogManager.getLogger(LoginPage.class);
	
	// Constructor to initialize driver
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	/*********************************** Locators ***********************************************/

	@FindBy(xpath = "//a[contains(text(), 'Login')]")
	WebElement btn_login;
	
	@FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/input[1]")
	WebElement txt_email;
	
	@FindBy(xpath = "//button[contains(text(), 'Request OTP')]")
	WebElement btn_otp;
	
	@FindBy(xpath = "//span[contains(text(),'CONTINUE')]")
	public WebElement btn_continue;
	
	@FindBy(xpath = "//button[contains(text(),'Verify')]")
	public WebElement btn_verify;
	
	// Method for logging into website
	
	public void loginFlipkart(String email) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(txt_email)).sendKeys(email);                // waiting till element is visible then sending keys to enter
		btn_otp.click();
		
	}
	
	//  Method for asserting whether the button is displayed or not
	
	public boolean isButtonDisplayed(WebElement btn) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(btn));
		return btn.isDisplayed();
	}
}

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

public class CareersPage {

	WebDriver driver;
	WebDriverWait wait;
	Logger log = LogManager.getLogger(SellerPage.class);
	
	// Constructor to initialize driver
	
	public CareersPage(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	/********************* Locators ******************/
	
	@FindBy(xpath = "//a[contains(text(),'Careers')]")
	WebElement btn_careers;
	
	@FindBy(xpath = "//a[@id='candidate-login-before']")
	WebElement btn_candidateLogin;
	
	@FindBy(xpath = "//body/app-root[1]/app-login[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]")
	WebElement txt_email;
	
	@FindBy(xpath = "//body/app-root[1]/app-login[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/input[1]")
	WebElement txt_password;
	
	@FindBy(xpath = "//body/app-root[1]/app-login[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/input[1]")
	WebElement checkbox_robot;
	
	@FindBy(xpath = "//button[@id='loginbtn']")
	WebElement btn_login;
	
	@FindBy(xpath = "//button[contains(text(),'✕')]")
	WebElement btn_close;
	
	@FindBy(xpath = "//span[contains(text(),'Sorry! Looks like you typed it wrong. Please try a')]")
	public WebElement txt_error;
	
	// Method to log into careers portal of website
	
	public void candidateLogin(String email, String password) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		try {
			wait.until(ExpectedConditions.visibilityOf(btn_close)).click();              // try-catch block to handle login popup
		}
		catch(Exception e) {}
		
		wait.until(ExpectedConditions.visibilityOf(btn_careers)).click();                // waiting till button is visible
		log.info("Clicked on Careers button");
		
		wait.until(ExpectedConditions.visibilityOf(btn_candidateLogin)).click();           // waiting till button is visible
		log.info("Clicked on 'Candidate Login'");
		
		wait.until(ExpectedConditions.visibilityOf(txt_email)).sendKeys(email);           // waiting till element is visible then sending keys to enter
		log.info("Entering Credentials");
		txt_password.sendKeys(password);
		
		wait.until(ExpectedConditions.elementToBeClickable(checkbox_robot)).click();        // waiting to check reCaptcha
		btn_login.click();
		
		wait.until(ExpectedConditions.visibilityOf(txt_error));                  // waiting till error is visible
		
	}
	
}

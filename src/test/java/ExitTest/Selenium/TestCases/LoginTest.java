package ExitTest.Selenium.TestCases;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import ExitTest.Selenium.Pages.LoginPage;
import ExitTest.Selenium.Utils.BrowserFactory;
import ExitTest.Selenium.Utils.ReadingPropertiesFile;


public class LoginTest  extends BrowserFactory{
	
	Logger log = LogManager.getLogger(LoginTest.class);
	
	String invalidEmail = ReadingPropertiesFile.getProperty("invalidEmail");
	String validEmail = ReadingPropertiesFile.getProperty("validEmail1");
	
	//Test method for verifying log in functionality using invalid credentials
	
	@Test(priority = 1)
	public void invalidLogin() throws InterruptedException {
		
		LoginPage login = new LoginPage(driver);
		log.info("Entering invalid email/phone");
		login.loginFlipkart(invalidEmail);
		Assert.assertTrue(login.isButtonDisplayed(login.btn_continue));
		
	}
	
	//Test method for verifying log in functionality using valid credentials
	
	@Test(enabled = false)       // This test is disabled, i.e., it will not run
	public void validLogin() throws InterruptedException {
		
		LoginPage login = new LoginPage(driver);
		log.info("Entering valid email/phone");
		login.loginFlipkart(validEmail);
		Assert.assertTrue(login.isButtonDisplayed(login.btn_verify));
	}
	
}

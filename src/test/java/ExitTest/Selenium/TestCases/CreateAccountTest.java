package ExitTest.Selenium.TestCases;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import ExitTest.Selenium.Pages.CreateAccountPage;
import ExitTest.Selenium.Utils.BrowserFactory;
import ExitTest.Selenium.Utils.ReadingPropertiesFile;

public class CreateAccountTest extends BrowserFactory{
	
	Logger log = LogManager.getLogger(CreateAccountTest.class);
	String phone = ReadingPropertiesFile.getProperty("phone");

	// Test method to verify create account functionality
	@Test
	public void createAccount(){
		
		CreateAccountPage createAccountPage = new CreateAccountPage(driver);
		createAccountPage.createNewAccount(phone);
		Assert.assertTrue(createAccountPage.isButtonDisplayed(createAccountPage.btn_signUp));
	}
}

package ExitTest.Selenium.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import ExitTest.Selenium.Pages.CareersPage;
import ExitTest.Selenium.Utils.BrowserFactory;
import ExitTest.Selenium.Utils.ReadingPropertiesFile;

public class CareersTest extends BrowserFactory{

	String email = ReadingPropertiesFile.getProperty("validEmail");
	String password = ReadingPropertiesFile.getProperty("password");
	String errorMessage = ReadingPropertiesFile.getProperty("loginError");
	
	// Test method to verify working of login feature on careers page
	
	@Test
	public void candidateLogin() {
		
		CareersPage career = new CareersPage(driver);
		career.candidateLogin(email, password);
		Assert.assertEquals(career.txt_error.getText(), errorMessage);
	}
}

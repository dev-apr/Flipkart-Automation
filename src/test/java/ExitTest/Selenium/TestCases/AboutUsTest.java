package ExitTest.Selenium.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import ExitTest.Selenium.Pages.AboutUsPage;
import ExitTest.Selenium.Utils.BrowserFactory;
import ExitTest.Selenium.Utils.ReadingPropertiesFile;

public class AboutUsTest extends BrowserFactory{

	String pageTitle = ReadingPropertiesFile.getProperty("aboutUsTitle");
	
	// Test method to verify functionality of AboutUs 
	
	@Test
	public void aboutUs() {
		
		AboutUsPage about = new AboutUsPage(driver);
		about.aboutUs();
		Assert.assertEquals(driver.getTitle(), pageTitle);
	}
}

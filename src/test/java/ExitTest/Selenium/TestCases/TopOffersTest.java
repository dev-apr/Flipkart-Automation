package ExitTest.Selenium.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import ExitTest.Selenium.Pages.TopOffersPage;
import ExitTest.Selenium.Utils.BrowserFactory;
import ExitTest.Selenium.Utils.ReadingPropertiesFile;

public class TopOffersTest extends BrowserFactory{

	String pageTitle = ReadingPropertiesFile.getProperty("offerPageTitle");
	
	// Test method to verify working of top offers button's functionality
	
	@Test
	public void viewOffers() {
		TopOffersPage offers = new TopOffersPage(driver);
		offers.viewOffers();
		Assert.assertEquals(driver.getTitle(), pageTitle);
	}
}

package ExitTest.Selenium.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import ExitTest.Selenium.Pages.SearchPage;
import ExitTest.Selenium.Utils.BrowserFactory;
import ExitTest.Selenium.Utils.ReadingPropertiesFile;

public class SearchProductTest extends BrowserFactory{

	// Test method to verify working of search functionality
	
	@Test
	public void searchItem() {
		SearchPage searchPage = new SearchPage(driver);
		searchPage.searchProduct(ReadingPropertiesFile.getProperty("product"));
		Assert.assertEquals(driver.getTitle(), ReadingPropertiesFile.getProperty("jacketPageTitle"));
	}
}

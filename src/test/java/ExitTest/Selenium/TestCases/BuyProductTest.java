package ExitTest.Selenium.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import ExitTest.Selenium.Pages.BuyProductPage;
import ExitTest.Selenium.Utils.BrowserFactory;
import ExitTest.Selenium.Utils.ReadingPropertiesFile;

public class BuyProductTest extends BrowserFactory{
	
	String product = ReadingPropertiesFile.getProperty("itemName");
	String productName = ReadingPropertiesFile.getProperty("productName");
	String currentUrl = ReadingPropertiesFile.getProperty("checkoutUrl");

	
	// Test method to verify add to cart functionality
	@Test(priority = 1)
	public void addToCart() {
		
		BuyProductPage add = new BuyProductPage(driver);
		add.addToCart(product);
		Assert.assertEquals(add.txt_iphone.getText(), productName);
	}
	
	// Test method to verify buy product functionality
	@Test(priority = 0)
	public void buyProduct() {
		
		BuyProductPage buy = new BuyProductPage(driver);
		buy.buyProduct(product);
		Assert.assertEquals(driver.getCurrentUrl(), currentUrl);
	}
}

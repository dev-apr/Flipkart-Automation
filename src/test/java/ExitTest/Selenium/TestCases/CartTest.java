package ExitTest.Selenium.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import ExitTest.Selenium.Pages.CartPage;
import ExitTest.Selenium.Utils.BrowserFactory;
import ExitTest.Selenium.Utils.ReadingPropertiesFile;

public class CartTest extends BrowserFactory{

	String pageTitle = ReadingPropertiesFile.getProperty("cartPageTitle");
	String emptyCartMessage = ReadingPropertiesFile.getProperty("emptyCartMessage");
	String currentUrl = ReadingPropertiesFile.getProperty("placeOrderUrl");
	
	// Test method to verify view cart functionality
	
	@Test(priority =  0)
	public void viewCart() {
		
		CartPage cart = new CartPage(driver);
		cart.viewCart();
		Assert.assertEquals(driver.getTitle(), pageTitle);
	}
	
	// Test method to verify remove from cart functionality
	
	@Test(priority =  2)
	public void removeFromCart() {
		
		CartPage cart = new CartPage(driver);
		cart.removeFromCart();
		Assert.assertEquals(cart.txt_emptyCart.getText(), emptyCartMessage);
	}
	
	// Test method to verify place order from cart functionality
	@Test(priority =  1)
	public void placeOrder() {
		
		CartPage cart = new CartPage(driver);
		cart.placeOrder();
		Assert.assertEquals(driver.getCurrentUrl(), currentUrl);
		
	}
	
}

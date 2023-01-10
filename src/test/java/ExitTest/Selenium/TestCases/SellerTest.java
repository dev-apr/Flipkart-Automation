package ExitTest.Selenium.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import ExitTest.Selenium.Pages.SellerPage;
import ExitTest.Selenium.Utils.BrowserFactory;
import ExitTest.Selenium.Utils.ReadingPropertiesFile;

public class SellerTest extends BrowserFactory{

	String phone = ReadingPropertiesFile.getProperty("phone");
	String email = ReadingPropertiesFile.getProperty("invalidEmail");
	String gstin = ReadingPropertiesFile.getProperty("gstin");
	String pageTitle = ReadingPropertiesFile.getProperty("sellerPageTitle");
	String errorMessage = ReadingPropertiesFile.getProperty("errorMessage");
	
	// Test method to verify become seller functionality
	
	@Test(priority = 0)
	public void becomeSeller() {
		SellerPage becomeseller = new SellerPage(driver);
		becomeseller.sellerRegister(phone, email, gstin);
		Assert.assertEquals(driver.getTitle(), pageTitle);
	}
	
	// Test method to verify login functionality on seller page
	
	@Test(priority = 1)
	public void sellerLogin() {
		SellerPage seller = new SellerPage(driver);
		seller.sellerLogin(phone);
		Assert.assertEquals(seller.txt_error.getText(), errorMessage);
	}
}

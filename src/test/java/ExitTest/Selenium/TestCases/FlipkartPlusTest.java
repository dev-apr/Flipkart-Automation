package ExitTest.Selenium.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import ExitTest.Selenium.Pages.FlipkartPlusPage;
import ExitTest.Selenium.Utils.BrowserFactory;
import ExitTest.Selenium.Utils.ReadingPropertiesFile;

public class FlipkartPlusTest extends BrowserFactory{

	String coinsPageUrl = ReadingPropertiesFile.getProperty("coinsPageUrl");
	String rewardsPageUrl = ReadingPropertiesFile.getProperty("rewardsPageUrl");
	String claimedPageUrl = ReadingPropertiesFile.getProperty("claimedPageUrl");
	String exclusivePageTitle = ReadingPropertiesFile.getProperty("exclusivePageTitle");
	
	// Test method to verify that user is able to see coins in account
	
	@Test(priority = 0)
	public void coinBalance() {
		
		FlipkartPlusPage plus = new FlipkartPlusPage(driver);
		plus.checkCoinBalance();
		Assert.assertEquals(driver.getCurrentUrl(), coinsPageUrl);
	}
	
	// Test method to verify that user is able to view available rewards
	
	@Test(priority = 1)
	public void viewRewards() {
		
		FlipkartPlusPage plus = new FlipkartPlusPage(driver);
		plus.viewRewards();
		Assert.assertEquals(driver.getCurrentUrl(), rewardsPageUrl);
	}
	
	// Test method to verify that user is able to view claimed rewards
	
	@Test(priority = 2)
	public void viewClaimedRewards() {
		
		FlipkartPlusPage plus = new FlipkartPlusPage(driver);
		plus.claimedRewards();
		Assert.assertEquals(driver.getCurrentUrl(), claimedPageUrl);
	}
	
	// Test method to verify that user is able to view exclusive offers
	
	@Test(priority = 3)
	public void viewExclusiveOffers() {
		
		FlipkartPlusPage plus = new FlipkartPlusPage(driver);
		plus.exclusiveOffers();
		Assert.assertEquals(driver.getTitle(), exclusivePageTitle);
	}
}


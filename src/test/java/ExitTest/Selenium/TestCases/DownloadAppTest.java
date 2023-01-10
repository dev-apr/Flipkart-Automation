package ExitTest.Selenium.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import ExitTest.Selenium.Pages.DownloadAppPage;
import ExitTest.Selenium.Utils.BrowserFactory;
import ExitTest.Selenium.Utils.ReadingPropertiesFile;

public class DownloadAppTest extends BrowserFactory{

	
	String appStoreTitle = ReadingPropertiesFile.getProperty("appStorePageTitle");
	String playStoreTitle = ReadingPropertiesFile.getProperty("playStorePageTitle");
	
	// Test method to verify working of download feature from app store
	@Test(priority = 0)
	public void appStoreDownload() {
		
		DownloadAppPage download = new DownloadAppPage(driver);
		download.downloadFromAppStore();
		Assert.assertEquals(driver.getTitle(), appStoreTitle);
	}
	
	// Test method to verify working of download feature from play store
	@Test(priority = 1)
	public void playStoreDownload() {
		
		DownloadAppPage download = new DownloadAppPage(driver);
		download.downloadFromGooglePlay();
		Assert.assertEquals(driver.getTitle(), playStoreTitle);
	}
}

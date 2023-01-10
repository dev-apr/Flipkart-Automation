package ExitTest.Selenium.Pages;

import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ExitTest.Selenium.Utils.ReadingPropertiesFile;

public class SearchPage {

	WebDriver driver;
	WebDriverWait wait;
	
	Logger log = LogManager.getLogger(SearchPage.class);
	
	// Constructor to initialize driver
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	/****************************** Locators *****************************/
	
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/input[1]")
	WebElement txt_search;
	
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/button[1]")
	WebElement btn_search;
	
	@FindBy(xpath = "//button[contains(text(),'✕')]")
	WebElement btn_close;
	
	// Method to search product
	
	public void searchProduct(String product) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		try {
			wait.until(ExpectedConditions.visibilityOf(btn_close)).click();            // try-catch block to handle login popup
		}
		catch(Exception e) {}
		
		log.info("Searching for product");
		wait.until(ExpectedConditions.visibilityOf(txt_search)).sendKeys(product);      // waiting till element is visible then sending keys
		btn_search.click();
		
		wait.until(ExpectedConditions.titleContains(ReadingPropertiesFile.getProperty("productKeyword")));        // waiting till searched items appear
	}
}

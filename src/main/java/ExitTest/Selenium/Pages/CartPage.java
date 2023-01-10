package ExitTest.Selenium.Pages;

import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ExitTest.Selenium.Utils.ReadingPropertiesFile;

public class CartPage {

	WebDriver driver;
	WebDriverWait wait;
	Logger log = LogManager.getLogger(CartPage.class);
	
	// Constructor to initialize driver
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	/**************************** Locators ***************************/
	
	@FindBy(xpath = "//span[contains(text(),'Cart')]")
	WebElement btn_cart;
	
	@FindBy(xpath = "//button[contains(text(),'✕')]")
	WebElement btn_close;
	
	@FindBy(xpath = "//div[contains(text(),'Remove')]")
	WebElement btn_remove;
	
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]")
	WebElement btn_REMOVE;
	
	@FindBy(xpath = "//div[contains(text(),'Missing Cart items?')]")
	public WebElement txt_emptyCart;
	
	@FindBy(xpath = "//span[contains(text(),'Place Order')]")
	WebElement btn_placeOrder;
	
	@FindBy(xpath = "//span[contains(text(),'CONTINUE')]")
	WebElement btn_continue;
	
	// Method to view cart
	
	public void viewCart() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		try {
			wait.until(ExpectedConditions.visibilityOf(btn_close)).click();
		}
		catch(Exception e) {}
		
		log.info("Opening Cart");
		wait.until(ExpectedConditions.visibilityOf(btn_cart)).click();
		
		wait.until(ExpectedConditions.titleContains(ReadingPropertiesFile.getProperty("cartKeyword")));    // Waitng till page is loaded
		log.info("Cart page opened");
	}
	
	// Method to remove item from cart
	
	public void removeFromCart() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		try {
			wait.until(ExpectedConditions.visibilityOf(btn_close)).click();
		}
		catch(Exception e) {}
		
		log.info("Opening Cart");
		wait.until(ExpectedConditions.visibilityOf(btn_cart)).click();
		
		wait.until(ExpectedConditions.titleContains(ReadingPropertiesFile.getProperty("cartKeyword")));    // Waitng till page is loaded
		log.info("Cart page opened");
		
		
		// For scrolling till remove button is visible
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", btn_remove);
		btn_remove.click();
		log.info("Clicked on 'Remove'");
		
		wait.until(ExpectedConditions.elementToBeClickable(btn_REMOVE)).click();
		wait.until(ExpectedConditions.visibilityOf(txt_emptyCart));
		log.info("Item removed from cart");
	}
	
	// Method to place order from cart
	
	public void placeOrder() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		try {
			wait.until(ExpectedConditions.visibilityOf(btn_close)).click();          // try-catch block to handle login popup
		}
		catch(Exception e) {}
		
		log.info("Opening Cart");
		wait.until(ExpectedConditions.visibilityOf(btn_cart)).click();
		
		wait.until(ExpectedConditions.visibilityOf(btn_placeOrder)).click();;    // Waitng till page is loaded
		log.info("Clicked on 'Place Order'");
		
		wait.until(ExpectedConditions.visibilityOf(btn_continue));
		log.info("Order placed");
		
		
	}
	
}

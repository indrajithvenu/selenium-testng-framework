package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver=driver;		
	}
	
	By cartProductTitle = By.cssSelector("[data-test='product-title']");
	By removeButton = By.cssSelector(".btn-danger");
	By emptyCartMessage = By.xpath("//p[contains(text(),'The cart is empty')]");
	
	public String getCartProductName() {
		
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(cartProductTitle));
	    
	    return driver.findElement(cartProductTitle).getText();
		
	}
	
	public void removeProduct() {
		
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(removeButton));
	    
	    driver.findElement(removeButton).click();
		
	}
	
	public String getEmptyCartMessage() {
		
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartMessage));
	    
	    return driver.findElement(emptyCartMessage).getText();
		
	}

}

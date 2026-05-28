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
	
	public String getCartProductName() {
		
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.visibilityOfElementLocated(cartProductTitle));
	    
	    return driver.findElement(cartProductTitle).getText();
		
	}

}

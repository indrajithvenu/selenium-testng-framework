package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	
	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By addToCartButton = By.id("btn-add-to-cart");
	By productName = By.cssSelector("[data-test='product-name']");
	
	
	public void addToCart() {
		
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
	    
	    driver.findElement(addToCartButton).click();
		
	}
	
	public String getProductName() {
		
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
	    
	    return driver.findElement(productName).getText();
		
	}

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;	

public class HeaderComponent {
	
	WebDriver driver;
	
	public HeaderComponent(WebDriver driver) {
		this.driver = driver;
	}
	
	By profileMenuButton = By.id("menu");
	By signOutButton = By.cssSelector("[data-test='nav-sign-out']");
	By openCartIcon = By.cssSelector("[data-test='nav-cart']");
	By successToast = By.cssSelector(".toast-success");
	
	public void signOut() {

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    wait.until(ExpectedConditions.elementToBeClickable(profileMenuButton));

		    driver.findElement(profileMenuButton).click();

		    wait.until(ExpectedConditions.visibilityOfElementLocated(signOutButton));
			   
		    driver.findElement(signOutButton).click();		

		
	}
	
	public void openCart() {
		
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	    wait.until(ExpectedConditions.elementToBeClickable(openCartIcon));

	    WebElement cart = driver.findElement(openCartIcon);	

	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    js.executeScript("arguments[0].click();", cart);
		
	}

}

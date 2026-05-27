package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;	
import java.util.List;
import org.openqa.selenium.WebElement;


public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By searchBox = By.id("search-query");
	By searchButton = By.cssSelector("[data-test='search-submit']");
	By searchCaption = By.cssSelector("[data-test='search-caption']");
	By noResult = By.cssSelector("[data-test='no-results']");
	By productCards = By.cssSelector("[data-test='search_completed'] a[href*='/product/'][data-test^='product-']");
	
	
	public void searchProduct(String productName) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(searchBox));
		
		driver.findElement(searchBox).sendKeys(productName);
		driver.findElement(searchButton).click();
		
	}
	
	public String getSearchCaption() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchCaption));
		
		return driver.findElement(searchCaption).getText();

	}
	
	public int getDisplayedProductCount() {
		

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.visibilityOfElementLocated(productCards));	

		List<WebElement> products = driver.findElements(productCards);

		return products.size();
		
	}
	
	
	public String getNoResultMessage() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(noResult));

		return driver.findElement(noResult).getText(); 
	}

}

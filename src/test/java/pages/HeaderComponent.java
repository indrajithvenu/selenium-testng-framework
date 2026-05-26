package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
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
	
	public void signOut() {

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    System.out.println("profile button- before click");

		    wait.until(ExpectedConditions.elementToBeClickable(profileMenuButton));

		    driver.findElement(profileMenuButton).click();
		    System.out.println("profile button- after click");
		    wait.until(ExpectedConditions.visibilityOfElementLocated(signOutButton));
		    System.out.println("signout button- visibility buttn");
			   
		    driver.findElement(signOutButton).click();		
		    System.out.println("signout button- after clixk");
		
	}

}

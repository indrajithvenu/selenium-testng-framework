package pages;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import java.time.Duration;	

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver= driver;
	}
	
	By signInButton =By.cssSelector("[data-test='nav-sign-in']");	
	By emailField =By.id("email");
	By passwordField =By.id("password");	
	By loginButton =By.cssSelector("[data-test='login-submit']");	
	By loginErrorMessage = By.cssSelector("[data-test='login-error']");	
	By emailRequiredError = By.id("email-error");
	By passwordRequiredError= By.id("password-error");
	
	
	public void enterEmail(String email) {
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10)); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
		
		driver.findElement(emailField).sendKeys(email);;
		
	}
	
	public void enterPassword(String password) {
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10)); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
		
		driver.findElement(passwordField).sendKeys(password);
		
	}
	
	public void clickLoginButton() {
		
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));	
		
		driver.findElement(loginButton).click();
		
	}
	
	public void clickSignIn() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.elementToBeClickable(signInButton));
	    System.out.println("Trying to click Sign In");
	    driver.findElement(signInButton).click();
	    System.out.println("clicked Sign In");
	}	
	
	public String getLoginErrorMessage() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(loginErrorMessage));

	    return driver.findElement(loginErrorMessage).getText();
	}
	
	public String getEmailRequiredErrorMessage() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));		
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailRequiredError));
		
		return driver.findElement(emailRequiredError).getText();
		
	}
	
	public String getPasswordRequiredErrorMessage() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordRequiredError));
		
		return driver.findElement(passwordRequiredError).getText();
	}
	
	public boolean isSignInButtonDisplayed() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(signInButton));
		
		return driver.findElement(signInButton).isDisplayed();	
	}
	
	
}

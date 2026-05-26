package tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;	
import org.testng.annotations.Test;
import org.testng.Assert;

import base.BaseClass;
import pages.LoginPage;
import pages.HeaderComponent;

public class LoginTest extends BaseClass{

	@Test
	public void verifyLogin() {	
		
		LoginPage loginPage= new LoginPage(driver);
		
		loginPage.clickSignIn();
		loginPage.enterEmail("customer2@practicesoftwaretesting.com");
		loginPage.enterPassword("welcome01");
		loginPage.clickLoginButton();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("account"));
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		Assert.assertTrue(currentUrl.contains("account"));
		
	
			
	}
	
	@Test
	public void verifyInvalidLogin() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickSignIn();
		loginPage.enterEmail("customer2@practicesoftwaretesting.com");
		loginPage.enterPassword("wrongpassword");
		loginPage.clickLoginButton();
		
		String actualErrorMessage = loginPage.getLoginErrorMessage();
		Assert.assertEquals(actualErrorMessage, "Invalid email or password");
		
	}
	
	@Test
	public void verifyEmptyEmailValidation() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickSignIn();
		loginPage.enterPassword("wrongpassword");
		loginPage.clickLoginButton();
		
		String actualErrorMessage = loginPage.getEmailRequiredErrorMessage();
		Assert.assertEquals(actualErrorMessage, "Email is required");
		
	}
	
	@Test
	public void verifyEmptyPasswordValidation() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickSignIn();
		loginPage.enterEmail("customer2@practicesoftwaretesting.com");
		loginPage.clickLoginButton();
		
		String actualErrorMessage= loginPage.getPasswordRequiredErrorMessage();
		Assert.assertEquals(actualErrorMessage, "Password is required");
		
	}
	
	@Test
	public void verifySignOut() {
		
		LoginPage loginPage= new LoginPage(driver);
		HeaderComponent headerComponent = new HeaderComponent(driver);
		
		loginPage.clickSignIn();
		loginPage.enterEmail("customer2@practicesoftwaretesting.com");
		loginPage.enterPassword("welcome01");
		loginPage.clickLoginButton();
		
		headerComponent.signOut();
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(loginPage.isSignInButtonDisplayed());
		
		
		
	}
}

package tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;	
import org.testng.annotations.Test;
import org.testng.Assert;

import base.BaseClass;
import pages.LoginPage;
import pages.HeaderComponent;
import utils.TestData;


public class LoginTest extends BaseClass{

	@Test
	public void verifyLogin() {	
		
		LoginPage loginPage= new LoginPage(driver);
		
		loginPage.clickSignIn();
		loginPage.enterEmail(TestData.EMAIL);
		loginPage.enterPassword(TestData.PASSWORD);
		loginPage.clickLoginButton();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("account"));
		
		String currentUrl = driver.getCurrentUrl();
		
		Assert.assertTrue(currentUrl.contains("account"));
		
	
			
	}
	
	@Test
	public void verifyInvalidLogin() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickSignIn();
		loginPage.enterEmail(TestData.EMAIL);
		loginPage.enterPassword(TestData.INVALID_PASSWORD);
		loginPage.clickLoginButton();
		
		String actualErrorMessage = loginPage.getLoginErrorMessage();
		Assert.assertEquals(actualErrorMessage, TestData.INVALID_EMAIL_OR_PASSWORD_MESSAGE);
		
	}
	
	@Test
	public void verifyEmptyEmailValidation() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickSignIn();
		loginPage.enterPassword(TestData.INVALID_PASSWORD);
		loginPage.clickLoginButton();
		
		String actualErrorMessage = loginPage.getEmailRequiredErrorMessage();
		Assert.assertEquals(actualErrorMessage, TestData.EMAIL_REQUIRED_MESSAGE);
		
	}
	
	@Test
	public void verifyEmptyPasswordValidation() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickSignIn();
		loginPage.enterEmail(TestData.EMAIL);
		loginPage.clickLoginButton();
		
		String actualErrorMessage= loginPage.getPasswordRequiredErrorMessage();
		Assert.assertEquals(actualErrorMessage, TestData.PASSWORD_REQUIRED_MESSAGE);
		
	}
	
	@Test
	public void verifySignOut() {
		
		LoginPage loginPage= new LoginPage(driver);
		HeaderComponent headerComponent = new HeaderComponent(driver);
		
		loginPage.clickSignIn();
		loginPage.enterEmail(TestData.EMAIL);
		loginPage.enterPassword(TestData.PASSWORD);
		loginPage.clickLoginButton();
		
		headerComponent.signOut();
		Assert.assertTrue(loginPage.isSignInButtonDisplayed());
		
	}
}

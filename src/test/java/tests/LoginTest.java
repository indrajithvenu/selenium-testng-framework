package tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;	
import org.testng.annotations.Test;
import org.testng.Assert;

import base.BaseClass;
import pages.LoginPage;

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
		
		
		try {
			Thread.sleep(5000);
			
		} catch (InterruptedException e) {
            e.printStackTrace();
        }
			
	}
}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.CartPage;
import pages.HeaderComponent;
import pages.HomePage;
import pages.ProductPage;

public class HomePageTest extends BaseClass{
	
	@Test
	public void verifyValidProductSearch() {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.searchProduct("saw");
		
		String caption = homePage.getSearchCaption();
		int productCount = homePage.getDisplayedProductCount();
		
		
		Assert.assertTrue(productCount > 0);			
		Assert.assertTrue(caption.contains("saw"));
		
	}
	
	@Test
	public void verifyInvalidProductSearch() {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.searchProduct("xyz");
		
		String caption = homePage.getSearchCaption();
		String noResultMessage = homePage.getNoResultMessage();
		
		
		Assert.assertTrue(caption.contains("xyz"));
		Assert.assertEquals(noResultMessage,"There are no products found.");
		
	}
	
	
	  @Test
	    public void verifyAddToCart(){
	    
		  HomePage homePage = new HomePage(driver);
		  ProductPage productPage = new ProductPage(driver);
		  HeaderComponent headerComponent = new HeaderComponent(driver);
		  CartPage cartPage = new CartPage(driver);
		  
		  homePage.searchProduct("pliers");
		  homePage.openFirstProduct();
		  
		  String expectedProductName = productPage.getProductName().trim();
		  productPage.addToCart();
		  
		  headerComponent.openCart();
		  String actualProductName = cartPage.getCartProductName().trim();

		  Assert.assertTrue(expectedProductName.contains(actualProductName));
		  
		  
	    	
	    }

}

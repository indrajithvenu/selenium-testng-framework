package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.CartPage;
import pages.HeaderComponent;
import pages.HomePage;
import pages.ProductPage;
import utils.TestData;


public class CartTest extends BaseClass{
	
	
	  @Test
	    public void verifyAddToCart(){
	    
		  HomePage homePage = new HomePage(driver);
		  ProductPage productPage = new ProductPage(driver);
		  HeaderComponent headerComponent = new HeaderComponent(driver);
		  CartPage cartPage = new CartPage(driver);
		  
		  homePage.searchProduct(TestData.SEARCH_PRODUCT);
		  homePage.openFirstProduct();
		  
		  String expectedProductName = productPage.getProductName().trim();
		  productPage.addToCart();
		  
		  headerComponent.openCart();
		  String actualProductName = cartPage.getCartProductName().trim();

		  Assert.assertTrue(expectedProductName.contains(actualProductName));
		  
	    }
	  
	  @Test
	  public void verifyRemoveFromCart() {
		  
		  HomePage homePage = new HomePage(driver);
		  ProductPage productPage = new ProductPage(driver);
		  HeaderComponent headerComponent = new HeaderComponent(driver);
		  CartPage cartPage = new CartPage(driver);
		  
		  homePage.searchProduct(TestData.SEARCH_PRODUCT);
		  homePage.openFirstProduct();
		  
		  productPage.addToCart();
		  headerComponent.openCart();
		  
		  Assert.assertFalse(cartPage.getCartProductName().isEmpty());
		  
		  cartPage.removeProduct();
		  String emptyCartMessage =cartPage.getEmptyCartMessage();
		  
		  Assert.assertEquals(emptyCartMessage,TestData.EMPTY_CART_MESSAGE);
		  
	  }

}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.CartPage;
import pages.HeaderComponent;
import pages.HomePage;
import pages.ProductPage;

public class CartTest extends BaseClass{
	
	
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
	  
	  @Test
	  public void verifyRemoveFromCart() {
		  
		  HomePage homePage = new HomePage(driver);
		  ProductPage productPage = new ProductPage(driver);
		  HeaderComponent headerComponent = new HeaderComponent(driver);
		  CartPage cartPage = new CartPage(driver);
		  
		  homePage.searchProduct("hammer");
		  homePage.openFirstProduct();
		  
		  productPage.addToCart();
		  headerComponent.openCart();
		  
		  Assert.assertFalse(cartPage.getCartProductName().isEmpty());
		  
		  cartPage.removeProduct();
		  String emptyCartMessage =cartPage.getEmptyCartMessage();
		  
		  Assert.assertEquals(emptyCartMessage,"The cart is empty. Nothing to display.");
		  
	  }

}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import utils.TestData;

public class HomePageTest extends BaseClass{
	
	@Test
	public void verifyValidProductSearch() {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.searchProduct(TestData.SEARCH_PRODUCT);
		
		String caption = homePage.getSearchCaption();
		int productCount = homePage.getDisplayedProductCount();
		
		
		Assert.assertTrue(productCount > 0);			
		Assert.assertTrue(caption.contains(TestData.SEARCH_PRODUCT));
		
	}
	
	@Test
	public void verifyInvalidProductSearch() {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.searchProduct(TestData.INVALID_SEARCH_PRODUCT);
		
		String caption = homePage.getSearchCaption();
		String noResultMessage = homePage.getNoResultMessage();
		
		
		Assert.assertTrue(caption.contains(TestData.INVALID_SEARCH_PRODUCT));
		Assert.assertEquals(noResultMessage,TestData.NO_PRODUCT_FOUND_MESSAGE);
		
	}
	
	


}

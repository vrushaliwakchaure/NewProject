/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProvider1;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

/**
 * @author winma
 *
 */
public class AddToCartPagetTest extends BaseClass{

		//no direct connection between index class and test class so will create object to call methods
		IndexPage indexPage;
		LoginPage loginPage;
		AccountCreationPage accountCreationPage;
		SearchResultPage searchResultPage;
		AddToCartPage addToCartPage;
		
		//launch browser by launchApp method
		@Parameters("browser")
		@BeforeMethod(groups= {"Smoke", "Sanity", "Regression"})
		public void setup(String browser) {
			launchApp(browser);
		}
		
		@AfterMethod(groups= {"Smoke", "Sanity", "Regression"})
		public void tearDown() {
			getDriver().quit();
		}
		
		@Test(groups={"Sanity", "Regression"}, dataProvider = "getProduct", dataProviderClass = DataProvider1.class)
		public void addToCartTest(String productName, String qty, String size) throws Throwable {
			
			Log.startTestCase("addToCartTest");
			Log.info("Validating user able to add product to cart");
			
			indexPage = new IndexPage();
			searchResultPage=indexPage.searchProduct(productName);
			addToCartPage=searchResultPage.clickOnProduct();
			addToCartPage.enterQuantity(qty);
			addToCartPage.selectSize(size);
			addToCartPage.clickOnAddToCart();
			boolean result =addToCartPage.validateAddToCart();
			Assert.assertTrue(result);
			
			Log.info("User successfully added the product to the cart");
			
			
			Log.info("Validating price of the product afetr adding to the cart");
			Double bPrice=addToCartPage.confirmBeforePrice();
			
			
			Double aPrice=addToCartPage.confirmAfterPrice();
			Double aPri=aPrice/(Double.parseDouble(qty));
			
			System.out.println("Before price***********"+bPrice);
			System.out.println("After price***********"+aPri);
			
			
			Assert.assertEquals(bPrice, aPri,"Price is not matching after product adding to cart");
			Log.info("Price is matching after adding the product to cart");
			
			
			
			Log.endTestCase("addToCartTest");
			
		}
		
		
		/*@Test(groups="Regression")
		public void ConfirmPriceBeforeAndAfter() {
			
			Log.startTestCase("ConfirmPriceBeforeAndAfter");
			
			
			
			
			
			
			
			Log.endTestCase("ConfirmPriceBeforeAndAfter");
			
		}*/
			
		
	
	
}

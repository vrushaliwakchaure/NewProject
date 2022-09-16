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
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummary;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;
import com.mystore.utility.Log;

/**
 * @author winma
 *
 */
public class EndToEndTest extends BaseClass{

	//no direct connection between index class and test class so will create object to call methods
		IndexPage indexPage;
		LoginPage loginPage;
		AccountCreationPage accountCreationPage;
		SearchResultPage searchResultPage;
		AddToCartPage addToCartPage;
		OrderPage orderPage;
		AddressPage addressPage;
		ShippingPage shippingPage;
		PaymentPage paymentPage;
		OrderSummary orderSummary;
		OrderConfirmationPage orderConfirmationPage;
		
		
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
		
		@Test(groups="Regression" ,dataProvider = "getProduct", dataProviderClass = DataProvider1.class)
		public void endToEndTest(String productName, String qty, String size) throws Throwable {
			
			Log.startTestCase("EndToEnd Test");
			
			indexPage = new IndexPage();
			searchResultPage=indexPage.searchProduct(productName);
			addToCartPage=searchResultPage.clickOnProduct();
			addToCartPage.enterQuantity(qty);
			addToCartPage.selectSize(size);
			addToCartPage.clickOnAddToCart();
			orderPage=addToCartPage.clickOnCheckOut();
			loginPage= orderPage.clickOnCheckOut();
			addressPage=loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
			shippingPage=addressPage.clickOnCheckOut();
			shippingPage.clickTheTerms();
			paymentPage=shippingPage.clickOnCheckOut();
			orderSummary=paymentPage.clickOnPaymentMethod();
			orderConfirmationPage=orderSummary.clickOnConfirmOrderBtn();
			String actualMessage=orderConfirmationPage.validateConfirmMessage();
			String expectedMessage="Your order on My Store is complete.";
			Assert.assertEquals(actualMessage, expectedMessage);
			Log.info("Actual and expected message is match ");
			
			Log.endTestCase("EndToEnd Test");
			
		}
}

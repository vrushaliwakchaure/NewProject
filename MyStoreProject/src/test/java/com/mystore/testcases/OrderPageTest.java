/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.actiondrivers.Action;
import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProvider1;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

/**
 * @author winma
 *
 */
public class OrderPageTest extends BaseClass{

	//no direct connection between index class and test class so will create object to call methods
	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountCreationPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	
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
	
	@Test (groups="Regression", dataProvider = "getProduct", dataProviderClass = DataProvider1.class)
	public void verifyTotalPrice(String productName, String qty, String size) throws Throwable {
		
		Log.startTestCase("verifyTotalPriceTest");
		
		Log.info("Validate the actual total price and expected total price");
		
		indexPage = new IndexPage();
		searchResultPage=indexPage.searchProduct(productName);
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		orderPage=addToCartPage.clickOnCheckOut();
		Double unitPrice=orderPage.getUnitPrice();
		Double totalPrice=orderPage.getTotalPrice();
		
		//Double totalExpectedPrice =unitPrice*2+2;
		Double totalExpectedPrice =(unitPrice*(Double.parseDouble(qty)))+2;
		
		//Action.fluentWait(driver, totalExpectedPrice, 10);
		System.out.println("total exp==="+totalExpectedPrice);
		System.out.println("Unit==="+unitPrice);
		System.out.println("total==="+totalPrice);
		Assert.assertEquals(totalPrice, totalExpectedPrice, "Expected total price not match with Total price");
		
		Log.info("Expected total price match with Total price ");
		
		Log.endTestCase("verifyTotalPriceTest");
		
	}
}

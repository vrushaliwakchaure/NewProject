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
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

/**
 * @author winma
 *
 */
public class HomePageTest extends BaseClass{

	//no direct connection between index class and test class so will create object to call methods
			IndexPage indexPage;
			LoginPage loginPage;
			HomePage homePage;
			
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
			
			@Test(groups="Smoke")
			public void wishListTest() throws Throwable {
				
				Log.startTestCase("WishList");
				Log.info("Verifying the WishList");
				
				indexPage = new IndexPage();
				loginPage =indexPage.clickOnSignIn();
				homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
				boolean result = homePage.validateMyWishList();
				Assert.assertTrue(result);
				
				Log.info("WishList verified successfully");
				Log.endTestCase("WishList");
				
			}
			
			@Test(groups="Smoke")
			public void orderHistoryandDetailTest() throws Throwable {
				
				Log.startTestCase("OrderHistoryPage");
				Log.info("Verifying the OrderHistoryPage");
				
				indexPage = new IndexPage();
				loginPage =indexPage.clickOnSignIn();
				homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
				boolean result = homePage.validateOrdreHistory();
				Assert.assertTrue(result);
				
				Log.info("OrderHistoryPage verified successfully");
				Log.endTestCase("OrderHistoryPage");
			}
}

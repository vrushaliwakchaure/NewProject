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
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

/**
 * @author winma
 *
 */
public class SearchResultPageTest extends BaseClass{

	//no direct connection between index class and test class so will create object to call methods
		IndexPage indexPage;
		LoginPage loginPage;
		AccountCreationPage accountCreationPage;
		SearchResultPage searchResultPage;
		
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
		
		@Test(dataProvider ="searchProduct", dataProviderClass=DataProvider1.class, groups="Smoke")
		public void productAvailabilityTest(String productName) throws Throwable {
			
			Log.startTestCase("productAvailabilityTest");
			Log.info("Validating product avilability");
			
			indexPage = new IndexPage();
			searchResultPage=indexPage.searchProduct(productName);
			boolean result = searchResultPage.isProductAvailable();
			Assert.assertTrue(result);
			
			Log.info("Search product is available");
			Log.endTestCase("productAvailabilityTest");
		}
	
	
}

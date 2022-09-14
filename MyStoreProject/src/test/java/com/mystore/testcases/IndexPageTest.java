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
import com.mystore.pageobjects.IndexPage;
import com.mystore.utility.Log;

/**
 * @author winma
 *
 */
public class IndexPageTest extends BaseClass{

	//no direct connection between index class and test class so will create object to call methods
	IndexPage indexPage;
	
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
	public void verifyLogo() throws Throwable {
		Log.startTestCase("IndexPage");
		indexPage = new IndexPage();
		
		Log.info("User is going to verifying logo");
		boolean result=indexPage.validateLogo();
		Assert.assertTrue(result);
		Log.info("Logo verification is success");
		
	}
	
	@Test(groups="Smoke")
	public void verifyTitle() {
		
		Log.info("User is going to verifying Hpome Page Title");
		String actTitle=indexPage.getMyStoreTitle();
		
		Assert.assertEquals(actTitle, "My Store","Home Page Title not match");
		Log.info("Home page title verification is success");
		Log.endTestCase("IndexPage");
	}
	

}

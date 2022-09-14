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
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

/**
 * @author winma
 *
 */
public class AccountCreationPageTest extends BaseClass {

	//no direct connection between index class and test class so will create object to call methods
	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountCreationPage;
	
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
	
	@Test(groups="Sanity",dataProvider ="email" ,dataProviderClass = DataProvider1.class)
	public void verifyCreateAccountPageTest(String email1) throws Throwable {
		
		Log.startTestCase("verifyCreateAccountPageTest");
		
		Log.info("Validating if user able to land on Account creation page");
		
		indexPage = new IndexPage();
		loginPage =indexPage.clickOnSignIn();
		accountCreationPage=loginPage.createNewAccount(email1);
		
		System.out.println("***********"+email1);
		
		boolean result = accountCreationPage.validateAccountCreationPage();
		Assert.assertTrue(result);
		
		Log.info("User successfuly lands on Account creation page");
		
		Log.endTestCase("verifyCreateAccountPageTest");
	}
	
}

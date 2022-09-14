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
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

/**
 * @author winma
 *
 */
public class LoginPageTest extends BaseClass{

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
		
		@Test(dataProvider ="credentials", dataProviderClass=DataProvider1.class, groups= {"Smoke", "Sanity"})
		public void loginTest(String uname, String pswd) throws Throwable {
			Log.startTestCase("loginTest");
			indexPage = new IndexPage();
			
			Log.info("User is going to click on Sign In");
			loginPage =indexPage.clickOnSignIn();
			
			Log.info("Enter username and password");
			//homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			
			homePage=loginPage.login(uname,pswd);
			
			String actualURL=homePage.getCurrURL();
			String expectedURL="http://automationpractice.com/index.php?controller=my-account";
			
			Log.info("Verifying if user is able to login");
			Assert.assertEquals(actualURL, expectedURL,"Invalid Credentials");
			
			Log.info("User login is success");
			Log.endTestCase("loginTest");
			
		}
	
}

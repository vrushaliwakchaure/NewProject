/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.Action;
import com.mystore.base.BaseClass;

/**
 * @author winma
 *
 */
public class LoginPage extends BaseClass {

	@FindBy(xpath="//input[@id='email']")
	WebElement userName;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement password;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement signInBtn;
	
	@FindBy(xpath="//input[@id='email_create']")
	WebElement emailForNewAccount;
	
	@FindBy(xpath="//button[@name='SubmitCreate']")
	WebElement createNewAccountBtn;
	
	//initialize the above all the objects as below
		public LoginPage() {
			PageFactory.initElements(getDriver(), this);
		}
		
		//this method return to homepage
		public HomePage login(String uname, String pswd) throws Throwable {
			Action.type(userName, uname);
			Action.type(password, pswd);
			Action.click(getDriver(), signInBtn);
			return new HomePage();
		}
		
		//this method return to Address page
		public AddressPage login1(String uname, String pswd) throws Throwable {
			Action.type(userName, uname);
			Action.type(password, pswd);
			Action.click(getDriver(), signInBtn);
			return new AddressPage();
		}
		
		public AccountCreationPage createNewAccount(String NewEmail) {
			Action.type(emailForNewAccount, NewEmail);
			Action.click(getDriver(), createNewAccountBtn);
			return new AccountCreationPage();
		}
	
}

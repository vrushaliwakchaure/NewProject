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
public class AccountCreationPage extends BaseClass{

	@FindBy(xpath="//h1[text()='Create an account']")
	WebElement formTitle;
	
	//initialize the above all the objects as below
	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateAccountCreationPage() throws Throwable{
		//return Action.isDisplayed(getDriver(), formTitle);
		boolean result = formTitle.isDisplayed();
		return result;
	}
}

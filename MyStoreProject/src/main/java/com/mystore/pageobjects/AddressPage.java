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
public class AddressPage extends BaseClass{

	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement proceedToCheckOut;
	
	//initialize the above all the objects as below
	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public ShippingPage clickOnCheckOut(){
		Action.click(getDriver(), proceedToCheckOut);
		return new ShippingPage();
	}	
	
}

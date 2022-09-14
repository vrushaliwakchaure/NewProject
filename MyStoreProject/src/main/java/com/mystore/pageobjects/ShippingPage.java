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
public class ShippingPage extends BaseClass{
	
	@FindBy(xpath="//input[@id='cgv']")
	WebElement terms;
	
	@FindBy(xpath="//*[@id=\"form\"]/p/button/span")
	WebElement proceedToCheckOutBtn;
	
	//initialize the above all the objects as below
	public ShippingPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickTheTerms() {
		Action.click(getDriver(), terms);
	}
	
	
	public PaymentPage clickOnCheckOut(){
		Action.click(getDriver(), proceedToCheckOutBtn);
		return new PaymentPage();
	}
	

}

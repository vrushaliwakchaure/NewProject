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
public class OrderSummary extends BaseClass{

	@FindBy(xpath ="//span[text()='I confirm my order']")
	WebElement confirmOrder;
	
	//initialize the above all the objects as below
	public OrderSummary() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderConfirmationPage clickOnConfirmOrderBtn() {
		Action.click(getDriver(), confirmOrder);
		return new OrderConfirmationPage();
	}
}

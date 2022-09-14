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
public class PaymentPage extends BaseClass{

	@FindBy(xpath="//a[contains(text(),'Pay by bank wire')]")
	WebElement bankWireMethod;
	
	@FindBy(xpath="//a[contains(text(),'Pay by check')]")
	WebElement payByCheckMethod;
	
	//initialize the above all the objects as below
	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderSummary clickOnPaymentMethod() {
		Action.click(getDriver(), bankWireMethod);
		return new OrderSummary();
	}
	
	
	
}

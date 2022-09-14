/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

/**
 * @author winma
 *
 */
public class OrderConfirmationPage extends BaseClass{

	@FindBy(xpath="//p/strong[contains(text(),'Your order on My Store is complete')]")
	WebElement confirmMessag;
	
	//initialize the above all the objects as below
	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String validateConfirmMessage() {
		String confirmMsg = confirmMessag.getText();
		return confirmMsg;
	}
}

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
public class OrderPage extends BaseClass{

	@FindBy(xpath="//td[@class='cart_unit']/span/span")
	WebElement unitPrice;
	
	@FindBy(xpath="//td[@id='total_price_container']") 
	WebElement totalPrice;
	
	
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement proceedToCheckOut;
	
	//initialize the above all the objects as below
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public double getUnitPrice() {
		//Action.fluentWait(driver, unitPrice, 10);
		String unitPrice1 = unitPrice.getText();//get price as text
		String unit = unitPrice1.replaceAll("[^a-zA-Z0-9]", "");//remove $ sign from the text
		double finalUnitPrice= Double.parseDouble(unit);//convert string to double
		return finalUnitPrice/100;//got the value without decimal so divide by 100
		
	}
	
	public double getTotalPrice() {
		String totalPrice1 = totalPrice.getText();//get price as text
		String tot = totalPrice1.replaceAll("[^a-zA-Z0-9]", "");//remove $ sign from the text
		double finalTotalPrice= Double.parseDouble(tot);//convert string to double
		return finalTotalPrice/100;//got the value without decimal so divide by 100
		
	}
	
	public LoginPage clickOnCheckOut() throws Throwable{
		Action.click(getDriver(), proceedToCheckOut);
		return new LoginPage();
	}
	
}

/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mystore.actiondrivers.Action;
import com.mystore.base.BaseClass;

import jdk.internal.org.jline.utils.Log;

/**
 * @author winma
 *
 */
public class AddToCartPage extends BaseClass{

	@FindBy(xpath="//input[@name='qty']")
	WebElement quantity;
	
	@FindBy(xpath="//select[@id='group_1']")
	WebElement size;
	
	@FindBy(xpath="//span[@id='our_price_display']")
	WebElement priceOnAddToCartPage;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//h2/i") 
	WebElement addToCartMessage;
	
	@FindBy(xpath="//span[@id='layer_cart_product_price']")
	WebElement cartPagePrice;
	
	@FindBy(xpath="//a[@class='btn btn-default button button-medium']")
	WebElement proceedToCheckOutBtn;
	
	//initialize the above all the objects as below
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enterQuantity(String quantity1) throws Throwable{
		Action.type(quantity, quantity1);
	}
	
	public void selectSize(String size1) throws Throwable{
		Action.selectByVisibleText(size1, size);
	}
	
	public void clickOnAddToCart() throws Throwable{
		Action.click(getDriver(), addToCartBtn);
	}
	
	public boolean validateAddToCart() throws Throwable{
		
		Action.fluentWait(getDriver(), addToCartMessage,20);
		return Action.isDisplayed(getDriver(), addToCartMessage);
	}
	
	public OrderPage clickOnCheckOut() {
		Action.fluentWait(getDriver(), proceedToCheckOutBtn, 10);
		Action.JSClick(getDriver(), proceedToCheckOutBtn);
		return new OrderPage();
	}
	
	public double confirmBeforePrice() {
		
		String beforePrice = priceOnAddToCartPage.getText();//get price as text
		String beforeP = beforePrice.replaceAll("[^a-zA-Z0-9]", "");//remove $ sign from the text
		double finalBeforeP= Double.parseDouble(beforeP);//convert string to double
		return finalBeforeP/100;
	}
		
	public double confirmAfterPrice() {
		String afterPrice = cartPagePrice.getText();//get price as text
		String afterP = afterPrice.replaceAll("[^a-zA-Z0-9]", "");//remove $ sign from the text
		double finalAfterP= Double.parseDouble(afterP);//convert string to double
		return finalAfterP/100;
		
		}
	
}

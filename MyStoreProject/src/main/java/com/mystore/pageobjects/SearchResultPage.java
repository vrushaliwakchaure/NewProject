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
public class SearchResultPage extends BaseClass{

	@FindBy(xpath="//*[@id=\"center_column\"]//img")
	WebElement productResult;
	
	//initialize the above all the objects as below
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	//check product availability
	public boolean isProductAvailable() throws Throwable{
		return Action.isDisplayed(getDriver(), productResult);
	}
	
	//click on the product
	public AddToCartPage clickOnProduct() {
		Action.click(getDriver(), productResult);
		return new AddToCartPage();
	}
}

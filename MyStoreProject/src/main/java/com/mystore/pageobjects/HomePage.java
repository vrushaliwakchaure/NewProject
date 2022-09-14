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
public class HomePage extends BaseClass{

	@FindBy(xpath="//span[text()='My wishlists']")
	WebElement myWishList;
	
	@FindBy(xpath="//span[text()='Order history and details']")
	WebElement orderHistory;
	
	//initialize the above all the objects as below
			public HomePage() {
				PageFactory.initElements(getDriver(), this);
			}
			
	public boolean validateMyWishList() throws Throwable{
		 return Action.isDisplayed(getDriver(), myWishList);
	}
	
	public boolean validateOrdreHistory() throws Throwable{
		return Action.isDisplayed(getDriver(), orderHistory);
	}
	
	public String getCurrURL() {
		String homePageURL=getDriver().getCurrentUrl();
		return homePageURL;
	}
	
}

package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass{
	
	@FindBy(xpath="//a[@class='login']")
	WebElement signInBtn;
	
	@FindBy(xpath="//*[@id=\"header_logo\"]/a/img")
	WebElement myStoreLogo;
	
	@FindBy(xpath="//input[@name='search_query']")
	WebElement searchProductBox;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement searchButton;
	
	//initialize the above all the objects as below
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	//click on Sign In button
	public LoginPage clickOnSignIn() throws Throwable {
		Action.click(getDriver(), signInBtn);
		return new LoginPage();
	}
	
	//validate logo on index page
	public boolean validateLogo() throws Throwable {
		return Action.isDisplayed(getDriver(), myStoreLogo);
	}
	
	//verify the title of the page
	public String getMyStoreTitle() {
		String myStoreTitle = getDriver().getTitle();
		return myStoreTitle;
	}
	
	//search method for product search
	public SearchResultPage searchProduct(String productName) {
		Action.type(searchProductBox, productName);
		Action.click(getDriver(), searchButton);
		return new SearchResultPage();//reurn searchResult page so changed return type
	}
	
	
	
	
}

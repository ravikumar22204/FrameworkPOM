package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class YourTranPage extends TestBase {

	@FindBy(xpath="//*[@id='heading-section-desktop']/h2")
	WebElement yourTransactionText;
	
	public YourTranPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean trantext(){
		return yourTransactionText.isDisplayed();	
	}
}

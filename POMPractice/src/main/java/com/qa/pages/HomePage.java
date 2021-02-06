package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//a[text()='Amazon Pay']")
	WebElement amazonPayLink;
	@FindBy(xpath="//*[@id='ViewStatement']/span/a/div[2]/span")
	WebElement yourtransactionLink;
	
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public void amazonPayLinkLinksHome(){
		amazonPayLink.click();
	}
	
	public YourTranPage transactionsLink(){
		yourtransactionLink.click();
		return new YourTranPage();
	}
	
}

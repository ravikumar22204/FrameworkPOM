package com.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class LoginPage extends TestBase {
	
	//Page factory or Object repository
	@FindBy(id="nav-logo-sprites")
	WebElement logo;
	@FindBy(xpath="//a[@id='nav-link-accountList']")
	WebElement accountlink;
	@FindBy(id="ap_email")
	WebElement username;
	@FindBy(xpath="//input[@id='continue']")
	WebElement continuebutton;
	@FindBy(id="ap_password")
	WebElement password;
	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement loginbutton;
	
	@FindBy(id="nav-item-signout")
	WebElement signout;
	
	//Initialize the page objects: through constructor
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLogo(){
		return logo.getTagName();
	}
	
	public HomePage login(String un, String pwd){
		accountlink.click();
		username.sendKeys(un);
		continuebutton.click();
		password.sendKeys(pwd);
		//loginbutton.click();
		
		return new HomePage(); //since after login it wil get Homepage so we will return HomePage and also return type is HomePage
	}
	
	public void signout(){
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		signout.click();
	}
}

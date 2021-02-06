package com.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	Logger log= Logger.getLogger(LoginPageTest.class);
	public LoginPageTest(){
		super();
	}
	
	@BeforeTest
	public void setUp(){
		
		initialization();
		log.info("Launch browser");
		log.warn("Logo may be incorrect");
		loginPage= new LoginPage();
	}
	
	@Test(priority=1)
	public void logoTest(){
		String logo=loginPage.validateLogo();
		Assert.assertEquals(logo, "a");
	}
	@Test(priority=2)
	public void loginTest(){
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	//@AfterTest
	public void pageLogout(){
		loginPage.signout();
	}
	//@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}

package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase; //short cut to import is : ctrl+shift+o
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.YourTranPage;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	YourTranPage yourTranPage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeTest
	public void setUp(){
		
		initialization();
		loginPage= new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void amazonPayLink(){
		homePage.amazonPayLinkLinksHome();
	}
	
	@Test(priority=2)
	public void transactionLink(){
		homePage.transactionsLink();
	}
	
	@Test(priority=3)
	public void verifytitle(){
		boolean tranText=yourTranPage.trantext();
		Assert.assertTrue(tranText);
	}
}

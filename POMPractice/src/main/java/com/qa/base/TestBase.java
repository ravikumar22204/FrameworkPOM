package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		
		try {
			prop=new Properties();
			FileInputStream ip= new FileInputStream("C:\\Users\\e5547080\\workspace\\POMPractice\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		String browserName=prop.getProperty("browser");
		if(browserName.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\RK\\SeleniumFiles\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(browserName.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\RK\\SeleniumFiles\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else{
			System.setProperty("webdriver.ie.driver", "C:\\RK\\SeleniumFiles\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
}

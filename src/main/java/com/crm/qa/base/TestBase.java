package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	
	//Global variables which can be used throughout the class
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;


	//Creating a constructor of Test Base class
	
	public TestBase(){

		try {
	//Write code from reading a Property File//
			
			prop= new Properties();
			FileInputStream ip= new FileInputStream("C:/Users/USER/workspace/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // End of Constructor
	
	
	//Initialization method of Driver//
	
	public static void initialization(){
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Eclipse and Selenium\\All project file\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Eclipse and Selenium\\All project file\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
	//WebDriverEvent Listener//
	/*WebEventListener.java class is the listener class under com.crm.qa.util package*/
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
	//launch the url//
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	
	
	

}

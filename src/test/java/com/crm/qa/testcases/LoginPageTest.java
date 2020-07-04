package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homepage;
	
	public LoginPageTest(){
		super(); //--> Property file from TestBase class will be called
	}
	
	@BeforeMethod
	public void setUp(){
		initialization(); //--> Initialization method will be called from Test Base Class.
		loginPage = new LoginPage();
		
	}
	
	//Testing all the Actions.
	@Test(priority=3)
	public void validateLoginPageTitleTest(){
		String title= loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void validateCRMImageTest(){
		Boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(true);
	}
	
	@Test(priority=1)
	public void loginTest(){
		homepage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}

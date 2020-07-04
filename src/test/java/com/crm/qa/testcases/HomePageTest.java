package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactPage;
	
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(enabled=false)
	public void verifyHomePageTitleTest(){
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO", "Home Page title not found");
	}
	
	@Test(enabled=false)
	public void verifyUserNameLabelTest(){
		testUtil.switchToFrame();
		Boolean flag = homePage.verifyUserNameLabel();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void contactsLinkClickTest(){
		testUtil.switchToFrame();
		contactPage = homePage.contactsLinkClick();
		System.out.println("Hello");
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}

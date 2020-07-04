package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	String sheetname = "Contacts";
	
	
	public ContactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil = new TestUtil();
		loginPage= new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.contactsLinkClick();
		
	}
	
	
	@Test(enabled=false)
	public void verifyContactsLabelTest(){
		String title = contactsPage.verifyContactsLabel();
		Assert.assertEquals(title, "Contacts");
		System.out.println(title);
	}
	
	@Test(enabled=false)
	public void selectCheckBoxByTest(){
		contactsPage.selectCheckBoxBy("abhilasha Sharma");
	}
	
	@DataProvider
	public Object[][] contactPageTestData(){
		
		Object[][] data = TestUtil.dataProviderCode(sheetname);
		return data;
	}
	
	@Test(dataProvider = "contactPageTestData")
	public void newContactsInformationTest(String Prefix, String FirstName, String LastName, String Company){
		
		homePage.newContactsLinkClick();
		contactsPage.newContactsInformation(Prefix, FirstName, LastName, Company);
	}
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}

package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Defining Object Repository or Page Factory of Login Page//
	
	//If there is no id, name in locator, then we will use xpath//
	
	@FindBy(name="username")
	@CacheLookup
	WebElement username;         //---> we can use any customarize names for WebElements
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signUpBtn;
	
	@FindBy(xpath="//a[@class='navbar-brand']/img[@class='img-responsive']")
	WebElement crmLogo;
	
	
	//Initializing Page Objects //
	//Constructor//
	
	public LoginPage(){
		
	PageFactory.initElements(driver, this); 
		
	//--> driver, all the web elements will be called (signUpBtn,crmLogo, etc).
	//--> this, current class object will be called. you can also write LoginPage.class instead of this.
	
	}     //End of LoginPage Constructor//    
	
	//Actions//
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();  //--> Since after login, Home page is the landing page.
		
	}
	

}

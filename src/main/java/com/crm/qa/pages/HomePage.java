package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Demo User')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyUserNameLabel(){
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage contactsLinkClick(){
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage dealsLinkClick(){
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage tasksLinkClick(){
		tasksLink.click();
		return new TasksPage();
	}
	
	public void newContactsLinkClick(){
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		Actions action= new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		System.out.println("New contact name is : " +newContactsLink.getText());
		newContactsLink.click();
	}
	
	
	
	
	
	

}

package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(xpath="//form[@id='contactForm']//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyContactsLabel(){
		return contactLabel.getText();
	}
	
	public void selectCheckBoxBy(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"']/parent::td/preceding-sibling::td[@class='datalistrow']/input[@type='checkbox' and @name='contact_id']")).click();
	}
	
	public void newContactsInformation(String title, String fName, String lName, String companyName){
		Select select = new Select(driver.findElement(By.xpath("//select[@name='title']")));
		select.selectByValue(title);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		company.sendKeys(companyName);
		saveBtn.click();
	}
	


}

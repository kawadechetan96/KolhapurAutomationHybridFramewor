package com.kolhapur.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kolhapur.testbase.TestBase;

public class FeedBackPage extends TestBase{
	
	
	@FindBy(id="your-name")
	WebElement name;
	
	@FindBy(id="your-email")
	WebElement email;
	
	@FindBy(id="your-subject")
	WebElement subject;
	
	@FindBy(id="your-message")
	WebElement message;
	
																		public FeedBackPage()
																		{
																			PageFactory.initElements(driver, this);
																		}
																		
																		public void passdata(String uname, String uemail, String usubject, String umessage)
																		{
																			name.sendKeys(uname);
																			email.sendKeys(uemail);
																			subject.sendKeys(usubject);
																			message.sendKeys(umessage);
																		}
	
																		
}

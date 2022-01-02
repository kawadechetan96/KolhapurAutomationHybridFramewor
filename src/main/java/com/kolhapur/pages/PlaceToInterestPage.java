package com.kolhapur.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kolhapur.testbase.TestBase;

public class PlaceToInterestPage extends TestBase{

	
	@FindBy(css="div.wpb_column.vc_column_container.vc_col-sm-9")
	WebElement capturetext;
	
	public PlaceToInterestPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String capturetext()
	{
		return capturetext.getText();
	}
	
	
}

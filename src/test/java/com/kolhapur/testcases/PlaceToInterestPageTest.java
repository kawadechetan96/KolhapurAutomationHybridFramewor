package com.kolhapur.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kolhapur.pages.HomePage;
import com.kolhapur.pages.PlaceToInterestPage;
import com.kolhapur.testbase.TestBase;

public class PlaceToInterestPageTest extends TestBase{
	
	PlaceToInterestPage palcetointerestpage;
	HomePage homepage;
	
	public PlaceToInterestPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{
		initialization();
		palcetointerestpage=new PlaceToInterestPage();
		homepage=new HomePage();
	}
	@Test(priority=1)
	public void capturetext_test()
	{
		homepage.place_to_interest();
		String text=palcetointerestpage.capturetext();
		System.out.println(text);
	}
	
}

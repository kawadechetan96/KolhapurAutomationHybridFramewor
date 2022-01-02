package com.kolhapur.testcases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.kolhapur.pages.HomePage;
import com.kolhapur.pages.PlaceToInterestPage;
import com.kolhapur.testbase.TestBase;
import com.kolhapur.utils.Testutils;



public class HomePageTest extends TestBase{
	
	
	HomePage homepage;
	
	
																	public HomePageTest(){
																		super();
																	}
																	
																	@BeforeMethod
																	public void setup(){
																		initialization();
																		homepage=new HomePage();
																	}
																	
																	@Test(priority=1, enabled=false)
																	 public void verify_directory_link_test() {
																		homepage.verify_directory_link();
																		String title=driver.getTitle();
																		System.out.println(title);
																		Assert.assertEquals(title, "Directory | Kolhapur | India");
																	 }
																																		
																	@Test(priority=2, enabled=false)
																	public void verify_public_utilities_link_test() throws Exception{
																		homepage.verify_public_utilities_link();
																		String title=driver.getTitle();
																		System.out.println(title);
																		Assert.assertEquals(title, "Public Utilities | Kolhapur | India");
																	}
																	
																	@Test(priority=3, enabled=false)
																	public void verify_howtosearch_link_test(){
																		homepage.verify_how_to_search_link();
																		String title=driver.getTitle();
																		System.out.println(title);
																		Assert.assertEquals(title, "How to Reach | Kolhapur | India");
																	}
																	
																	@Test(priority=4, enabled=false)
																	public void verify_feedback_link_test(){
																		homepage.verify_feedback_link();
																		String title=driver.getTitle();
																		Assert.assertEquals(title, "Feedback | Kolhapur | India");
																	}
																	
																	@Test(priority=5, enabled=false)
																	public void verify_digital_india_logo_test(){
																			boolean logo=homepage.verify_digital_india_logo();
																			Assert.assertTrue(logo);
																	}
																	
																	@Test(priority=6)
																	public void verify_newupdate_test()
																	{
																		String update=homepage.verify_newupdate();
																		Assert.assertEquals(update, "NEWS / UPDATES");
																	}
																	
																	@Test(priority=7)
																	public void  place_to_interest_test()
																	{
																		homepage.place_to_interest();
																		Assert.assertEquals(driver.getTitle(), "Places of Interest | Kolhapur | India");
																	}
																	@AfterMethod
																	public void teardown(ITestResult result){		
																		if(ITestResult.FAILURE==result.getStatus())
																		{
																			Testutils.screenshot();
																		}
																		driver.close();
																	}
}

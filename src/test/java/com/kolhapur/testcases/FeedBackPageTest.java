package com.kolhapur.testcases;


import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kolhapur.pages.FeedBackPage;
import com.kolhapur.pages.HomePage;
import com.kolhapur.testbase.TestBase;
import com.kolhapur.utils.Testutils;

public class FeedBackPageTest extends TestBase {
	
						HomePage homepage;
						FeedBackPage feedbackpage;
	
	
																public FeedBackPageTest()
																{
																	super();
																}
	
																@BeforeMethod
																public void setup()
																{
																	initialization();
																	homepage=new HomePage();
																	feedbackpage=new FeedBackPage();
																	
																}
																
																@Test(priority=1 ,dataProvider="passdata")
																public void passdata_test(String uname, String uemail, String usubject, String umessage)
																{
																	homepage.verify_feedback_link();
																	feedbackpage.passdata(uname, uemail, usubject, umessage);
																}
																
																@DataProvider(name="passdata")
																public Object[][]  excel()
																{
																	Object[][] data=Testutils.excelconfig("feedback");
																	return data;
																}
																
																@AfterMethod
																public void teardown(ITestResult result)
																{		
																	if(ITestResult.FAILURE==result.getStatus())
																	{
																		Testutils.screenshot();
																	}
																	driver.close();
																}

}

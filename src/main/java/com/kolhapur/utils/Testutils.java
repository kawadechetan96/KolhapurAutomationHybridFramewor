package com.kolhapur.utils;

import java.io.File;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.kolhapur.testbase.TestBase;

public class Testutils extends TestBase{
	
	
											/***select menu to submenu item mouseover code***/
											public static void actions(WebElement sourceelement, WebElement targetelement)
											{
												Actions act=new Actions(driver);
												act.moveToElement(sourceelement).moveToElement(targetelement).build().perform();
												
											}
	
											/*** Mouseover code***/
											public static void actions(WebElement sourceelement)
											{
												Actions act=new Actions(driver);
												act.moveToElement(sourceelement).build().perform();	
											}
											
											
											public static void screenshot() 
											{
												try{
															TakesScreenshot ts=(TakesScreenshot)driver;
															File	source=ts.getScreenshotAs(OutputType.FILE);
															//String currentDir = System.getProperty("user.dir");
															FileUtils.copyFile(source, new File("./screenshots/ "+ System.currentTimeMillis()+ ".png"));
													}catch(Exception e){System.out.println("exception catch"+e.getMessage());}	
											}
}

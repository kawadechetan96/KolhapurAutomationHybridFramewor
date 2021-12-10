package com.kolhapur.utils;

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

}

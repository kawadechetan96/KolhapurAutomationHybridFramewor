package com.kolhapur.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kolhapur.testbase.TestBase;
import com.kolhapur.utils.Testutils;

public class HomePage extends TestBase{
	
	
	@FindBy(xpath="//a[text()='Directory']")
	WebElement directory;
	
	@FindBy(xpath="//a[text()='STD & PIN Codes']")
	WebElement pincode;
	
	@FindBy(xpath="//a[text()='Public Utilities']")
	WebElement publicutilies;
	
	@FindBy(xpath="//a[text()='How to Reach']")
	WebElement howtosearch;
	
																public HomePage()
																{
																	PageFactory.initElements(driver, this);
																}
																
																public DirectoryPage verify_directory_link()
																{
																	directory.click();
																	return new DirectoryPage();
																}
														
																/*** Mouseover code***/
																public PublicUtilitiesPage verify_publicutilities_link()
																{
																	Testutils.actions(directory);
																	publicutilies.click();
																	return new PublicUtilitiesPage();
																}
																
																/***select menu to submenu item mouseover code***/
																public HowToSearch verify_howtosearch_link()
																{
																	Testutils.actions(directory,publicutilies);
																	howtosearch.click();														
																	return new HowToSearch();
																}
}

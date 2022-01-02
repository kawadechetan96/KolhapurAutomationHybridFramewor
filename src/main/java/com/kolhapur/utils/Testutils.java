package com.kolhapur.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.kolhapur.testbase.TestBase;

public class Testutils extends TestBase{
	
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	
/********************************select menu to submenu item mouseover code**************************************************/
											public static void actions(WebElement sourceelement, WebElement targetelement)
											{
												Actions act=new Actions(driver);
												act.moveToElement(sourceelement).moveToElement(targetelement).build().perform();
												
											}
	
/********************************************** Mouseover code***********************************************************/
											public static void actions(WebElement sourceelement)
											{
												Actions act=new Actions(driver);
												act.moveToElement(sourceelement).build().perform();	
											}
											
/********************************** *******Capture Screenshot**************************************************************/
											public static void screenshot() 
											{
												try{
															TakesScreenshot ts=(TakesScreenshot)driver;
															File	source=ts.getScreenshotAs(OutputType.FILE);
															//String currentDir = System.getProperty("user.dir");
															FileUtils.copyFile(source, new File("./screenshots/ "+ System.currentTimeMillis()+ ".png"));
													}catch(Exception e){System.out.println("exception catch"+e.getMessage());}	
											}
											
/************************************************Excel data generic function*************************************************/
											public static Object[][] excelconfig(String sheetname)
											{
												File source=new File("./ExcelFile/ExcelConfig.xlsx");
												try
												{
												FileInputStream fis=new FileInputStream(source);
												wb=new XSSFWorkbook(fis);
												}catch(Exception e){System.out.println("Exception Catch:-"+e.getMessage());}
												sheet=wb.getSheet(sheetname);
												
												int row=sheet.getLastRowNum();
												int column=sheet.getRow(1).getLastCellNum();
												
												Object[][] data=new Object[row][column];
												
												for(int i=0; i<row; i++)
												{
													for(int j=0; j<column; j++)
													{
														data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
													}
												}
													return data;
											}
/*****************************************HighLight Flash element**********************************************************/											
										
											public static void flash(WebElement element ,WebDriver driver){
												String bgcolor=element.getCssValue("backgroundColor");
															for(int i=0; i<20; i++){
																changeColor("rgb(0,200,0)",element, driver);
																changeColor(bgcolor,element, driver);
															}
												}
											
											public static void changeColor(String color, WebElement element, WebDriver driver){
												JavascriptExecutor js=((JavascriptExecutor)driver);
												js.executeScript("arguments[0].style.backgroundColor =' "+ color +" ' ", element);
												
												try{
													Thread.sleep(20);
												}catch(Exception e){}
											}
											
/**********************************************Highlight Border*****************************************************************/

											public static void drawBorder(WebElement element, WebDriver driver){
												JavascriptExecutor js=(JavascriptExecutor)driver;
												js.executeScript("arguments[0].style.border=' 3px solid red' ", element);		
											}
											
/************************************************Generate Alert****************************************************************/	
											
											public static void generateAlert(String message, WebDriver driver){
												JavascriptExecutor js=(JavascriptExecutor)driver;
												js.executeScript("alert(' "+message+" ');");
											}

/************************************************Click on Element**********************************************************/
											
											public static void clickElementByJS(WebElement element, WebDriver driver){
												JavascriptExecutor js=(JavascriptExecutor)driver;
												js.executeScript("arguments[0].click();",element);
											}
											
/*************************************************Send value*************************************************************/
											
											public static void sendValueByJS(WebElement element, WebDriver driver){
												JavascriptExecutor js=(JavascriptExecutor)driver;
												js.executeScript("arguments[0].value='chetankavade' ",element);
											}
											
/************************************************Refresh browser**********************************************************/	
											
											public static void refershBrowserByJS(WebDriver driver){
												JavascriptExecutor js=(JavascriptExecutor)driver;
												js.executeScript("history.go(0)");
											}
											
/**************************************GetTitle****************************************************************************/
											
											public static String getTitleByJS(WebDriver driver){
												JavascriptExecutor js=(JavascriptExecutor)driver;
												String title =js.executeScript("return document.title;").toString();
												return title;
											}
											
/*******************************************Get All Text In Page **********************************************************/	
											
											public static String getPageInnerText(WebDriver driver){
												JavascriptExecutor js=(JavascriptExecutor)driver;
												String pagetext=js.executeScript("return document.documentElement.innerText;").toString();
												return pagetext;
											}
											
/*****************************************Scroll Page Down**************************************************************/
											
											public static void scrollPageDown(WebDriver driver){
												JavascriptExecutor js=(JavascriptExecutor)driver;
												js.executeScript("window.scrollTo(0,document.body.scrollHeight)");	
											}
											
/****************************************Scroll to particular element*******************************************************/
											
											public static void scrollIntoView(WebElement element, WebDriver driver){
												JavascriptExecutor js=(JavascriptExecutor)driver;
												js.executeScript("arguments[0].scrollIntoView(true);",element);	
											}
																						
												
										
}

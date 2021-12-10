package com.kolhapur.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.kolhapur.testbase.TestBase;

public class Testutils extends TestBase{
	
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	
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
											
											/**** Capture Screenshot******/
											public static void screenshot() 
											{
												try{
															TakesScreenshot ts=(TakesScreenshot)driver;
															File	source=ts.getScreenshotAs(OutputType.FILE);
															//String currentDir = System.getProperty("user.dir");
															FileUtils.copyFile(source, new File("./screenshots/ "+ System.currentTimeMillis()+ ".png"));
													}catch(Exception e){System.out.println("exception catch"+e.getMessage());}	
											}
											
											
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
												
												
												
										
}

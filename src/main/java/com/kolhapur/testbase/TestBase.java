package com.kolhapur.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.kolhapur.utils.WebEventListner;

public class TestBase {

	
	public static WebDriver driver;
	public static Properties pro;
	public static EventFiringWebDriver e_driver;
    public static WebEventListner eventlistner;
		
												public TestBase()
												{
													try{
													File source=new File("E:/Selenium Programs/KolhapurAutomationHybridFramework/src/main/java/com/kolhapur/configuration/config.property");
													FileInputStream fis=new FileInputStream(source);
													pro=new Properties();
													pro.load(fis);
													}catch(Exception e){System.out.println("Exception catch:-"+e.getMessage());}
												}
												
												public static void initialization()
												{
													String browser1=pro.getProperty("browser");
													
													if(browser1.equals("chrome"))
													{
														System.setProperty("webdriver.chrome.driver", "E:/SetUp/Selenium/Driver's/chromedriver_win32/chromedriver.exe");
														driver=new ChromeDriver();				
													}
													else if(browser1.equals("firefox"))
													{
														
													}
													
													e_driver=new EventFiringWebDriver(driver);
													eventlistner=new WebEventListner();
													e_driver.register(eventlistner);
													driver=e_driver;
													
													
													
												driver.manage().deleteAllCookies();
													driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
													driver.manage().window().maximize();
													
													driver.get(pro.getProperty("url"));
												}
	
	
	
	
}

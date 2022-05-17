package com.BaseClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelReader;

public class Baseclass {
	
	
	public static  WebDriver driver=null;
	public  Properties config=new Properties();
	public static Properties OR=new Properties();
	public static FileInputStream fis;
	public static Logger log=Logger.getLogger(Baseclass.class);
	public static  String fileName;
	public static ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+
			"\\src\\main\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public SoftAssert assert1=new SoftAssert();
	//public static String browser;
	
	@BeforeMethod
	@Parameters("browser")
	public  void setup(String browser)
	{
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\main\\resources\\properties\\log4j.properties");
		log.info("Test execution started");
		
	//	if(driver==null)
		{
			try {
				fis=new FileInputStream(
						System.getProperty("user.dir")+"\\src\\main\\resources\\properties\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//if(config.getProperty("browser").equals("chrome"))
			if(browser.equals("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				log.debug("chrome launched");
				log.info("Chrome Browser Launched");
				
			}else 
				//if(config.getProperty("browser").equals("edge"))
			if(browser.equals("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
				log.debug("Edge launched");
				log.info("Edge Browser Launched");
			}
			
			driver.get(config.getProperty("site"));
			log.info("Navigated to : " +config.getProperty("testsiteurl"));
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
			
		}
		
			
	}
	
	
//	public static void quit()
//	{
//		driver.quit();
//	}
	
	
//	@AfterTest
//	public void tearsDown()
//	{
//		
//		if(driver!=null)
//		{
//			driver.quit();
//		}
//	}
}

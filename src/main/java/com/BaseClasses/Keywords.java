package com.BaseClasses;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import listeners.ExtentListeners;

public class Keywords extends Baseclass {
	
	  //public static String fileName;
		
		
	    public static void captureScreenshot() throws IOException {

			Date d = new Date();
			fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

			File screenshot = ((TakesScreenshot) Baseclass.driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(".//reports//" + fileName));
		}
	    
	   public void  click(String key)
	    {
		   try {
	    	if(key.endsWith("_XPATH"))
	    	{
	    		driver.findElement(By.xpath(OR.getProperty(key))).click();
	    	}
	    	else if(key.endsWith("_ID"))
	    	{
	    		driver.findElement(By.id(OR.getProperty(key))).click();
	    	}
	    	else if(key.endsWith("_CSS"))
	    	{
	    		driver.findElement(By.cssSelector(OR.getProperty(key))).click();
	    	}
	    	log.info("Clicking on :"+key);
	    	ExtentListeners.test.log(Status.INFO, "Clicking on:-"+key);
	    	 }
		   catch(Throwable t)
		   {
	    	ExtentListeners.test.log(Status.FAIL, "Error while clicking on the Element - "+key +
	    			"Here's the exception message---->"+t.getMessage());
	    	Assert.fail();
		   }
		   
		   
	    }
	   
	   public void  type(String key,String value)
	    {
		   try {
	    	if(key.endsWith("_XPATH"))
	    	{
	    		driver.findElement(By.xpath(OR.getProperty(key))).sendKeys(value);
	    	}
	    	else if(key.endsWith("_ID"))
	    	{
	    		driver.findElement(By.id(OR.getProperty(key))).sendKeys(value);
	    	}
	    	else if(key.endsWith("_CSS"))
	    	{
	    		driver.findElement(By.cssSelector(OR.getProperty(key))).sendKeys(value);
	    	}
	    	log.info("Clicking on :"+key);
	    	ExtentListeners.test.log(Status.INFO, "Typing in element:-" + key +","+" "+ "Entered value as:-"+value);
	    	 }
		   catch(Throwable t)
		   {
	    	ExtentListeners.test.log(Status.FAIL, "Error while typing in an Element - "+key +
	    			"Here's the exception message---->"+t.getMessage());
	    	Assert.fail();
		   }
		   
		   
	    }
	   
	   
}

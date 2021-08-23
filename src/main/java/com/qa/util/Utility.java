package com.qa.util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility extends BaseClass{
   // for screen shot:
	      public static void captureScreen(String name) throws IOException   {
	    	
		     	TakesScreenshot ts = (TakesScreenshot) driver;
		     	File src = ts.getScreenshotAs(OutputType.FILE);
		     	File file = new File("Screenshot/"+name+".png");
			    FileUtils.copyFile(src, file );
		
	}
	//for scroll up down:
	      public static void scrollUpDown(WebElement element) {
	    	  JavascriptExecutor js = (JavascriptExecutor) driver;
	    	  js.executeScript("arguments[0].scrollIntoView();" , element );
	}
	//for date Picker:
	      public static void setDate(WebElement element,String value,String date) {
	    	  JavascriptExecutor js=(JavascriptExecutor) driver;
	    	  js.executeScript("arguments[0].setAttribute('"+value+"','"+date+"');",element);
	      }
	 
	//for alert handling:
	      public static void alertAccept() {
	    	  driver.switchTo().alert().accept();
	      }
	      public static void alertDismiss() {
	    	  driver.switchTo().alert().dismiss();   	    
	      }
	      public static void alertAccept(String value) {
	    	  driver.switchTo().alert().sendKeys(value);
	    	  driver.switchTo().alert().accept();
	      }
	      public static void alertDismiss(String value) {
	    	  driver.switchTo().alert().sendKeys(value);  
	    	  driver.switchTo().alert().dismiss();
	      }
    
    //for frame Handling:
	      public static void switchToFrame(int index) {
	    	  driver.switchTo().frame(index);
	      }
	      public static void switchToFrame(String value) {
	    	  driver.switchTo().frame(value);
	      }
	      public static void switchToFrame(WebElement webelement) {
	    	  driver.switchTo().frame(webelement);
	      }
	      public static void toParentframe() {
	    	  driver.switchTo().parentFrame();    	   	
	      }
	      public static void toDefaultcontent() {
	    	  driver.switchTo().defaultContent();  	
	      }
	      
    
    //for windows handling:
	      public static void getWindowId() {
	    	  Set<String> all_Id = driver.getWindowHandles();
	    	  for (String id : all_Id) {
	    		  System.out.println(id);
			String title = driver.switchTo().window(id).getTitle();
				System.out.println(title);
				System.out.println();
	    	  }
	      }
	      public static void switchToWindow(String value) {
	    	  Set<String> all_Id = driver.getWindowHandles();
	    	  for (String id : all_Id) {
	    		  String title = driver.switchTo().window(id).getTitle();
	    		  if(title.contains(value)) 
	    			  break;	    		  
	    	  }
	      }
	//Radio button & Check box & drop down :
	      public static void getText(By target) {
	    	  List<WebElement> options= driver.findElements(target);
	          int size =  options.size();
	          System.out.println(size);
	          for (WebElement ele : options) {
	 			String text = ele.getText();
	 			System.out.println(text);
	          }
	      }
	//Select: drop down:
	      public static void selectByIndex(WebElement element,int index) {
	      	new Select(element).selectByIndex(index);
	      }
	      public static void selectByValue(WebElement element,String value) {
	      	new Select(element).selectByValue(value);
	      }
	      public static void selectByText(WebElement element,String text) {
	      	new Select(element).selectByVisibleText(text);
	      }
	      public static boolean isMultiple(WebElement element) {
	    	return new Select(element).isMultiple();
	      }
	      public static  void getOptions(WebElement element){
	    	  List<WebElement> options= new Select(element).getOptions();
	    	  for ( WebElement ele : options) {
	  			String text = ele.getText();
	  			System.out.println(text);
	    	  }  
	      }
	//implicitlyWait:
	      public static  void implicitlyWait(long timeout) {
             driver.manage().timeouts().implicitlyWait(timeout,TimeUnit.SECONDS);
	      }
	      
	//for explicitly wait:
	      public static void waitAndSendkey(long timeOut,WebElement element, String keyValue) {
	    	  WebDriverWait wait = new WebDriverWait(driver, timeOut );
	    	  wait.until(ExpectedConditions.visibilityOf(element));
	    	                     //elementToBeClickable
	    	  element.sendKeys(keyValue);   	    	
    }
	      public static void waitAndClick(int timeOut,WebElement element) {
	    	  WebDriverWait wait = new WebDriverWait(driver, timeOut );
	    	  wait.until(ExpectedConditions.visibilityOf(element));
	    	  element.click();
    }    
}


package com.qa.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Javascript extends Utility
{
        static JavascriptExecutor js = (JavascriptExecutor) driver; 
         
      public static void sendKeys(WebElement element, String value)
      {
    	  js.executeScript("arguments[0].value='"+value+"'", element);
      }
      public static void click(WebElement element)
      {
    	  js.executeScript("arguments[0].click();", element);
      }
      public static String getTitle()
      {
    	    String title=js.executeScript("return document.title").toString();
			return title;
      }
      public static String getPageText()
      {
    	    String title=js.executeScript("return document.documentElement.innerText").toString();
			return title;
      }
      public static String getCurrentUrl()
      {
    	    String title=js.executeScript("return document.URL").toString();
			return title;
      }
      public static void navigateTo(String url)
      {
    	  js.executeScript("window.location='"+url+"'");
      }
      public static void refresh()
      {
    	  js.executeScript("history.go(0)");
      }
      public static void generateAlert(String msg)
      {
    	  js.executeScript("alert('"+msg+"')");
      }
      
      
}

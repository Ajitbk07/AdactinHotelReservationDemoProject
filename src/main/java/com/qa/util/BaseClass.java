package com.qa.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class BaseClass {
	
		public static WebDriver driver;

	public static WebDriver getBrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", 
					System.getProperty("user.dir")+("/Driver/chromedriver.exe"));
			driver= new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir")+("/Driver/msedgedriver.exe"));
			driver= new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", 
					System.getProperty("user.dir")+("/Driver/geckodriver.exe"));
			driver= new FirefoxDriver();
		}
		else {
			System.out.println("Invalid...");
		}
		driver.manage().window().maximize();
		return driver;
	}
	public static String getUrl(String value) {
		    driver.get(value);
			return value;
	}
	public static String getCurrentUrl() {
			return driver.getCurrentUrl();
	}
	public static void checkUrl(String expUrl,String actUrl) {
		if(expUrl.equals(actUrl)) {
			System.out.println("Url is correct");
		}else {
			System.out.println("Url is not correct");
			System.out.println("Actual Url is : "+ actUrl);
			System.out.println("Expected Url is : "+ expUrl);
		}
	}
	public static String getPageTitle()
	{
	    return driver.getTitle();
	}
	
	public static void sendTo(WebElement element, String value) {
	     element.sendKeys(value);		
	}
	public static void clickOn(WebElement element) {
		element.click();
	}
	public static void toClear(WebElement element) {
		element.clear();
	}
	//locators:
	public static WebElement byId(String value) {
		   return driver.findElement(By.id(value));   
		}
	public static WebElement byName(String value) {
		   return driver.findElement(By.name(value));   
	 	}
	public static WebElement byXpath(String value) {
		   return driver.findElement(By.xpath(value));   
		}
	public static WebElement byCss(String value) {
		   return driver.findElement(By.cssSelector(value));  		   
		}
	public static WebElement byLinkText(String value) {
		   return driver.findElement(By.linkText(value));   
		}
	
	//Navigation :
	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}
	public static void navigation(String value) {
		if(value.equalsIgnoreCase("back")) 
		driver.navigate().back();	
		else if(value.equalsIgnoreCase("forward"))
		driver.navigate().forward();
		else if(value.equalsIgnoreCase("refresh"))
		driver.navigate().refresh();	
	}
	
	//Actions :	
	public static void moveToElement(WebElement target) {
		Actions act= new Actions(driver);
			act.moveToElement(target).build().perform();
	}
	public static void contextClick(WebElement target) {
		new Actions(driver).contextClick(target).build().perform();
	}
	public static void dragAndDrop(WebElement from,WebElement to) {
		new Actions(driver).dragAndDrop(from, to).build().perform();
	}
	public static void doubleClick(WebElement target) {
		new Actions(driver).doubleClick(target).build().perform();
	}
	public static void clickAndHold(WebElement target) {
		new Actions(driver).clickAndHold(target).build().perform();
	}
	public static void actClick(WebElement target) {
		
		new Actions(driver).click(target).build().perform();
	}
	public static void release(WebElement target) {
		new Actions(driver).release(target).build().perform();
	}
	
	//Robot:
	public static void robot (int a) throws AWTException {
		Robot bot = new Robot();
		bot.keyPress(a);
	
		
	}
	public static void robot(String key) throws AWTException {
		Robot bot = new Robot();
		if(key.equalsIgnoreCase("KeyUp"))
			bot.keyPress(KeyEvent.VK_UP);
		else if(key.equalsIgnoreCase("KeyDown"))
			bot.keyPress(KeyEvent.VK_DOWN);
	}
}

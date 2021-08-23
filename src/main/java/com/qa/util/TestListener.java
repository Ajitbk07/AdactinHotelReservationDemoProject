package com.qa.util;

import java.io.IOException;
import org.testng.ITestListener;
import org.testng.ITestResult;




public class TestListener implements ITestListener{
   
	public void onTestFailure(ITestResult result) 
	{
		try 
		{
			String name = result.getMethod().getMethodName();
			Utility.captureScreen(name);
		} catch (IOException e) {}
		
	}
	
	}

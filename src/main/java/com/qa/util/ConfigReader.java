package com.qa.util;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader
{       
	      
	     static Properties prop = null;
         public static Properties initProperties()  
         {   
        	 if(prop==null)
        	 {
        	 try 
        	 {
        	 FileInputStream fi = new FileInputStream("src/main/resources/config.properties");
        	 prop = new Properties();
        	 prop.load(fi);
			 } catch (Exception e) {
				System.out.println(e.getMessage());
			 }
        	 }
        	return prop; 
         }
}

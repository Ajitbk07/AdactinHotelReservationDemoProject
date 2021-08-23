package com.qa.tests;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.*;
import com.adactin.pom.NewUserRegistrationPage;
import com.qa.util.CT;
import com.qa.util.ConfigReader;
import com.qa.util.ExcelReader;
import com.qa.util.Utility;

@Listeners(com.qa.util.TestListener.class)
public class NewUserRegistrationTest 
{       
	   Properties prop;
	   ExcelReader read = new ExcelReader();
	   List<Map<String,String>> data;
	   @BeforeTest
	   private void init() throws Exception
	   {
		  prop = ConfigReader.initProperties();
		  data = read.getData(prop.getProperty("xl-path"),"Test Data");
	   }
      @BeforeClass
       private void setUp()
      {
             Utility.getBrowser(prop.getProperty("browser"));
             Utility.implicitlyWait(CT.TIMEOUT);
	  }
      @BeforeMethod()
       private void setURL()
       {
    	     Utility.getUrl(prop.getProperty("url"));
    	     /*
    	      * verify with build2 
    	      */
    	     // NewUserRegistrationPage.goToNewBuild();
       }
      
      @Test(enabled =false,priority=1)
       private void verifyRegisterAccountWithValidData()
       {
    	  NewUserRegistrationPage.
     	  AccountRegistration(data, CT.TEST_DATA_1).
     	  clickRegisterButton().
    	  verifyRegisteration();
       }
      
      @Test(priority=4,enabled=false)
      private void verifyRegisterAccountWithInvalidCaptchaText() 
      {
    	 NewUserRegistrationPage.
    	 AccountRegistration(data, CT.TEST_DATA_1).
    	 clickRegisterButton().
    	 verifyCaptchaErrorMessage();
	  }
      
      @Test(priority=3)
      private void verifyRegisterAccountWithInvalidEmailFormat() 
      {
    	 NewUserRegistrationPage.
    	 AccountRegistration(data, CT.TEST_DATA_2).
    	 clickRegisterButton().
    	 verifyInvalidEmailErrorMessage();
	  }
      @Ignore
      @Test(priority=2)
      private void verifyRegisterAccountWithExistingEmailId() 
      {
    	 NewUserRegistrationPage.
    	 AccountRegistration(data, CT.TEST_DATA_4).
    	 clickRegisterButton().
    	 verifyInvalidEmailErrorMessage();
	  }
      
      @Test(priority=5,enabled =true)
      private void verifyMismatchedConfirmPasswordRegisteration()
      {   
     	 NewUserRegistrationPage.
     	 AccountRegistration(data, CT.TEST_DATA_3).
     	 clickRegisterButton().
 	     verifyConfirmPasswordErrorMessage();
      }
      @Test(priority=6,enabled =true)
      private void verifyRegisterAccountWihtoutFillingData()
      {
    	  NewUserRegistrationPage.clickNewUserRegisteration().
    	  clickRegisterButton().
    	  verifyAllErrorMessagesOfEmptyField();
      }
      @Test(priority=7,enabled =true)
      private void verifyRegisterAccountFieldWithSpaceCharacter() 
      {  
    	
 	     NewUserRegistrationPage.clickNewUserRegisteration().
 	     enterUsername(CT.SPACE).
 	     enterPassword(CT.SPACE).
 	     enterConfirmPassword(CT.SPACE).
 	     enterFullName(CT.SPACE).
 	     enterEmailAddress(CT.SPACE).
 	     waitToEnterCaptcha().
 	     tickTheTermsAndCondition().
 	     clickRegisterButton().
 	     verifyErrorMessagesforSpaceAcceptance();
	  }
      @Test(priority=8)
      private void verifyPageTitle()
      {
    	NewUserRegistrationPage.clickNewUserRegisteration(); 
    	String actTitle=Utility.getPageTitle();
        Assert.assertEquals(actTitle,CT.PAGE_TITLE_REGISTERATION,"Title not matched");
      }
      @Test(priority=9)
      private void verifyResetButtonTask()
      {
    	  NewUserRegistrationPage.
    	  AccountRegistration(data,CT.TEST_DATA_1).
          clickResetButtonAndVerify();
      }
      @Test(dataProvider ="testData",priority=10)
      private void verifyMinCharLimitofUsername(String name,String pass)
      {
    	  NewUserRegistrationPage.clickNewUserRegisteration().    
          enterUsername(name).
          enterPassword(pass).
          clickRegisterButton().
    	  verifyCharLimitErrorMessage(name.length(),pass.length());
      }
      @DataProvider
      private Object[][] testData()
      {
    	  Object[][] obj= {{"Arundas","Arund"},
    			           {"Arunarun","Arund7"}};
    	  return obj;
      }
     @AfterClass
     private void tearDown() 
     {
           Utility.driver.quit();
	 }
}

package com.adactin.pom;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.util.CT;
import com.qa.util.Utility;

public class NewUserRegistrationPage extends Utility
{
       
        private NewUserRegistrationPage()
        {
      	    PageFactory.initElements(driver,this);
        }
        
      @FindBy(id ="username")
      private WebElement username;
      @FindBy(id ="password")
      private WebElement password;
      @FindBy(id ="re_password")
      private WebElement confirm_password;
      @FindBy(id ="full_name")
      private WebElement fullname;
      @FindBy(id ="email_add")
      private WebElement email;
      @FindBy(id ="captcha-form")
      private WebElement captchaText;
      @FindBy(id ="tnc_box")
      private WebElement terms_conditions;
      @FindBy(id ="Submit")
      private WebElement register_btn;
      @FindBy(id ="Reset")
      private WebElement reset;
      @FindBy(xpath ="//a[text()='Terms & Conditions']")
      private WebElement terms_conditions_link;
      @FindBy(xpath ="//a[text()='Go back to Login page']")
      private WebElement go_to_login;
      @FindBy(xpath="//a[text()='New User Register Here']")
      private static WebElement userRegistration;
      @FindBy(xpath="//td[@class='reg_success']")
      private WebElement emailVerification;
  
      //for error message
      
      @FindBy(id="username_span")
      private WebElement username_span;
      @FindBy(id="password_span")
      private WebElement password_span;
      @FindBy(id="re_password_span")
      private WebElement re_password_span;
      @FindBy(id="full_name_span")
      private WebElement full_name_span;
      @FindBy(id="email_add_span")
      private WebElement email_add_span;
      @FindBy(id="captcha_span")
      private WebElement captcha_span;
      @FindBy(id="tnc_span")
      private WebElement tnc_span;
      
      
  
 static NewUserRegistrationPage register=new NewUserRegistrationPage(); 
     
	
    public NewUserRegistrationPage enterUsername(String name)
    {
    	sendTo(username, name);
    	return register;
    }
    public NewUserRegistrationPage enterPassword(String name)
    {
    	sendTo(password, name);
    	return register;
    }
    public NewUserRegistrationPage enterConfirmPassword(String name)
    {
    	sendTo(confirm_password, name);
    	return register;
    }
    public NewUserRegistrationPage enterFullName(String name)
    {
    	sendTo(fullname, name);
    	return register;
    }
    public NewUserRegistrationPage enterEmailAddress(String name)
    {
    	sendTo(email, name);
    	return register;
    }
    public NewUserRegistrationPage tickTheTermsAndCondition()
    {
    	   clickOn(terms_conditions);
    	return register;
    }
    public NewUserRegistrationPage clickRegisterButton()
    {
    	if(register_btn.isDisplayed()&&register_btn.isEnabled())
    	{
        	clickOn(register_btn);
    	}
    	return register;
    }
    public NewUserRegistrationPage waitToEnterCaptcha()
    { 
         try {
			Thread.sleep(12000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	return register;
    }
    public static NewUserRegistrationPage clickNewUserRegisteration()
    {
    	 clickOn(userRegistration);
		return register;
    }
    public static void goToNewBuild()
    {
    	clickOn(byXpath("//strong[text()='Go to Build 2 '] "));
    }
    public static NewUserRegistrationPage AccountRegistration(List<Map<String,String>> data,int index)
    {    
    	 clickNewUserRegisteration().
	     enterUsername(data.get(index).get("username")).
	     enterPassword(data.get(index).get("password")).
	     enterConfirmPassword(data.get(index).get("c_password")).
	     enterFullName(data.get(index).get("fullname")).
	     enterEmailAddress(data.get(index).get("email")).
	     waitToEnterCaptcha().
	     tickTheTermsAndCondition();
	     
    	return register;
    }
    public void verifyRegisteration()
    {
    	String msg = emailVerification.getText();
    	boolean  value = false;
	     if(msg.contains("email verification code has been sent to your email address"))
	     {
	    	 value =true;
         }
	     Assert.assertTrue(value,"can able to register account with invalid data");
    }
    public NewUserRegistrationPage clickResetButtonAndVerify()
    {  
    	if(reset.isDisplayed()&&reset.isEnabled())
    	{
    	clickOn(reset);
    	}
    	clickRegisterButton().
    	verifyAllErrorMessagesOfEmptyField();
		return register;
    }
    public NewUserRegistrationPage verifyAllErrorMessagesOfEmptyField()
    {
    	String user ="Username is Empty";
    	String pass ="Password is Empty";
    	String c_pass ="Confirm Password is Empty";
    	String fname ="Full Name is Empty";
    	String email ="Email Address is Empty";
    	String captcha ="Captcha is Empty";
    	String tnc ="You must agree to Terms and Conditions";
    	boolean value =false;
    	if(user.equals(username_span.getText())&&
    			pass.equals(password_span.getText())&&
    			c_pass.equals(re_password_span.getText())&&
    			fname.equals(full_name_span.getText())&&
    			email.equals(email_add_span.getText())&&
    			captcha.equals(captcha_span.getText())&&
    			tnc.equals(tnc_span.getText())) 
    	{
    		value = true;
    	}
    	Assert.assertTrue(value,"Expected error messages not shown");
    	return register;
    }
    public NewUserRegistrationPage verifyCaptchaErrorMessage()
    {
    	String tnc ="Captcha is Invalid";
    	boolean value =false;
    	if(tnc.equals(captcha_span.getText())) 
    	{
    	    value = true;
    	}
    	Assert.assertTrue(value,"Expected error messages not shown");
		return register;
    }
    public NewUserRegistrationPage verifyConfirmPasswordErrorMessage()
    {
    	String pass ="Passwords Do Not Match";
    	boolean value =false;
    	if(pass.equals(re_password_span.getText())) 
    	{
    	    value = true;
    	}
    	Assert.assertTrue(value,"Expected error messages not shown");
		return register;
    }
    public NewUserRegistrationPage verifyInvalidEmailErrorMessage()
    {
    	String mail ="Email Address is Invalid";
    	String exist="Email Address is already in use";
    	String act =email_add_span.getText(); String exp="";
    	if(act.equals(mail)) 
    	{
    	    exp=mail;
    	}
    	else if(act.equals(exp))
    	{
    		exp=exist;
    	}
    	Assert.assertEquals(act,exp,"Expected error message not shown");
		return register;
    }
    public NewUserRegistrationPage verifyErrorMessagesforSpaceAcceptance()
    {
    	String message ="Only Alpha Numeric characters are allowed";
    	boolean value =false;
    	if(message.equals(username_span.getText())&&
    			message.equals(full_name_span.getText()))
    	{
    	    value = true;
    	}
    	Assert.assertTrue(value,"Expected error messages not shown");
		return register;
    }
	public void verifyCharLimitErrorMessage(int u_len, int p_len) 
	{
		String umsg = "Username must contain minimum 8 characters";
		String pmsg = "Password must contain minimum 6 characters";
		String act=" ",exp=" ";
		if(u_len<8)
		{
			  exp=umsg;act=username_span.getText();
		}
		if(p_len<6)
		{
			  exp=pmsg;act=password_span.getText();
		}
		Assert.assertEquals(act,exp,"Expected error messages not shown" );
	}
}

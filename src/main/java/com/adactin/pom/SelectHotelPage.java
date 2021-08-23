package com.adactin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage {
	public WebDriver driver;
	@FindBy(id="radiobutton_0")
	private WebElement selectHotel;
	@FindBy(id="continue")
	private WebElement submit;
	
	public SelectHotelPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getSelectHotel() {
		return selectHotel;
	}
    public WebElement getSubmit() {
		return submit;
	}
}

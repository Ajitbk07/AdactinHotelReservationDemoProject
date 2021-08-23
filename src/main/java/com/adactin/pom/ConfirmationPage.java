package com.adactin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
public WebDriver driver;
	
	public ConfirmationPage (WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id ="search_hotel")
	private WebElement  searchHotel;
	@FindBy(id ="my_itinerary")
	private WebElement  myItinerary;
	@FindBy(id ="logout")
	private WebElement  logout;
	
	public WebElement getSearchHotel() {
		return searchHotel;
	}
	public WebElement getMyItinerary() {
		return myItinerary;
	}
	public WebElement getLogout() {
		return logout;
	}
}

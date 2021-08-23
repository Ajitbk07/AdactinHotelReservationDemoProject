package com.adactin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage {
	
	public WebDriver driver;
     
	@FindBy(id ="location")
	private WebElement location;
	@FindBy(id ="hotels")
	private WebElement hotel;
	@FindBy(id ="room_type")
	private WebElement roomtype;
	@FindBy(id ="room_nos")
	private WebElement roomsCount;
	@FindBy(id ="datepick_in")
	private WebElement checkIndate;
	@FindBy(id ="datepick_out")
	private WebElement checkOutDate;
	@FindBy(id ="adult_room")
	private WebElement adultsCount;
	@FindBy(id ="child_room")
	private WebElement childrenCount;
	@FindBy(id ="Submit")
	private WebElement search;
	
	public SearchHotelPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getLocation() {
		return location;
	}
	public WebElement getHotel() {
		return hotel;
	}
	public WebElement getRoomtype() {
		return roomtype;
	}
	public WebElement getRoomsCount() {
		return roomsCount;
	}
	public WebElement getCheckIndate() {
		return checkIndate;
	}
	public WebElement getCheckOutDate() {
		return checkOutDate;
	}
	public WebElement getAdultsCount() {
		return adultsCount;
	}
	public WebElement getChildrenCount() {
		return childrenCount;
	}
	public WebElement getSearch() {
		return search;
	}
	
}

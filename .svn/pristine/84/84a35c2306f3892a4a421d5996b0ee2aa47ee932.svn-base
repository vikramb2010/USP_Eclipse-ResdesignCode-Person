package com.uspeclipse.pageobjects.person;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.uspeclipse.commonservices.GenericActions;
import com.uspeclipse.pageobjects.home.Home_pageobjects;

public class EndPersonAddress_pageobject {

	private WebDriver driver=null;
	private static final Logger logger = Logger.getLogger(EndPersonAddress_pageobject.class);
	GenericActions elements = null;
	Home_pageobjects homepageobject = null;
	AddPersonAddress_pageobjects addpersonaddresspageobject=null;
	
	public EndPersonAddress_pageobject(WebDriver driver){
		this.driver=driver;
		homepageobject = PageFactory.initElements( driver, Home_pageobjects.class);
		addpersonaddresspageobject = PageFactory.initElements(driver, AddPersonAddress_pageobjects.class);
		elements = new GenericActions(driver);
	}

	// Select Button in PersonAddress table
	public final By  SelectButton=By.xpath("//*[@id = 'personDetailsAddressViewResults']/div[1]/div/table/tbody[2]/tr/td[6]/span/ul/li/a");
	// End Button in PersonAddress table
	public final By  EndAddressButton=By.xpath("//*[@id = 'personDetailsAddressViewResults']/div[1]/div/table/tbody[2]/tr/td[6]/span/ul/li/ul/li[1]/a");
	// Location xpath in End address screen.
	public final By  Location=By.xpath("//*[@id = 'endPersonAddressForm']/fieldset/div[1]/div[2]/div");
	// End year xpath in End address screen.
	public final By  EndYear=By.id("fuzzyEndYEAR");
	// End Month xpath in End address screen.
	public final By  EndMonthDropdownbox=By.id("fuzzyEndMONTH");
	// End year xpath in End address screen.
	public final By  EndDayDropdownbox=By.id("fuzzyEndDAY");
	// End Reason xpath in End address screen.
	public final By  EndReason=By.id("endReason-input");
	// yes button xpath in End address screen.
	public final By  YesButton=By.xpath("//div[3]/span/button[1]");
	// No button xpath in End address screen.
	public final By  NoButton=By.xpath("//div[3]/span/button[2]");
	// End Person overlay xpath in End address screen.
	public final By  EndPersonOverlay=By.xpath("//div[3]/span/button[2]");
	// Address Panel overlay xpath in End address screen.
	public final By  AddressPanel=By.xpath("//*[@id = 'personDetails']/div/div[5]");
	// End date xpath in Address table .
	public final By  AddressTableEndDate=By.xpath("//*[@id ='personDetailsAddressViewResults']/div[1]/div/table/tbody[2]/tr[1]/td[3]");
	// End Person Methods

	
	// Clicking on Yes Button
	public void clickOnYesButton() {
		logger.info("Clicking on Yes Button");
		elements.waitForElementFluently( YesButton, 30);
		elements.buttonClick(YesButton);
		elements.waitForPageLoaded();
		elements.waitForElementFluently(
				homepageobject.PersonLink, 30);
		elements.waitForElementFluently( AddressPanel,
				30);
		elements.waitForElementFluently(
				AddressTableEndDate, 30);

	}

	//Clicking on select Button
	public void clickOnSelectButton() {
		logger.info("Clicking on Select Button");
		elements.waitForElementFluently( SelectButton,
				30);
		elements.buttonClick(SelectButton);

	}

	//Clicking on End Address Button
	public void clickOnEndAddressButton() {
		logger.info("Clicking on End Address Button");
		elements.waitForElementFluently(
				EndAddressButton, 30);
		elements.buttonClick(EndAddressButton);

	}

	//Clicking on No button
	public void clickOnNoButton() {
		logger.info("Clicking on No Button");
		elements.waitForElementFluently( NoButton, 30);
		elements.buttonClick(NoButton);

	}

	//Providing value in End year Textbox
	public void enterEndyear(String value) {
		logger.info("Providing " + value + " in End Year Textbox");
		elements.waitForElementFluently( EndYear, 30);
		elements.inputValue(EndYear, value);

	}

	//Selecting value from month dropdownbox
	public void selectValuefromMonthDropdownbox(String value) {
		logger.info("Selecting " + value + " from Month Dropdown");
		elements.waitForElementFluently(
				EndMonthDropdownbox, 30);
		elements.selectDropdown(EndMonthDropdownbox, value);

	}

	//selecting value from day dropdown box
	public void selectValuefromDayDropdownbox(String value) {
		logger.info("Selecting " + value + " from Day Dropdown");
		elements.waitForElementFluently(
				EndDayDropdownbox, 30);
		elements.selectDropdown(EndDayDropdownbox, value);

	}

	//selecting value from end reason drop down box 
	public void selectValuefromEndReasonDropdownbox(String value) {
		logger.info("Selecting " + value + " from End Reason Dropdown");
		elements.waitForElementFluently( EndReason, 30);
		elements.selectDropdown(EndReason, value);

	}

	/*
	 * public boolean isconfirmationMessagedisplayed {
	 * elements.waitForElementFluently(AddLocationlink,
	 * 30); return elements.isElementPresent(
	 * AddLocationlink); }
	 */

	//Fetching Actual end date from address grid
	public String getActualEndDateFromAddressgrid() {
		logger.info("Getting Actual End Date from Address grid");
		elements.waitForElementFluently(
				AddressTableEndDate, 30);
		return elements.getText(AddressTableEndDate);
	}

	//Getting Text from location
	public String getTextFromLocation() {
		logger.info("Getting Text from Location");
		elements.waitForElementFluently( Location, 30);
		return elements.getText(Location);
	}

	//Ending a address
	public void endAddress(String Endyear, String EndMonth, String EndDay,
			String Endreason) {
		logger.info("Ending an Address");
		enterEndyear(Endyear);
		selectValuefromMonthDropdownbox(EndMonth);
		selectValuefromDayDropdownbox(EndDay);
		selectValuefromEndReasonDropdownbox(Endreason);
		clickOnYesButton();
	}
}

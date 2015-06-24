package com.uspeclipse.pageobjects.person;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.uspeclipse.commonservices.GenericActions;
import com.uspeclipse.pageobjects.home.Home_pageobjects;

public class RemovePersonAddress_pageobject {

	private WebDriver driver = null;
	private static final Logger logger = Logger
			.getLogger(RemovePersonAddress_pageobject.class);
	GenericActions elements = null;

	Home_pageobjects homepageobject = null;
	AddPersonAddress_pageobjects addpersonaddresspageobject = null;
	EndPersonAddress_pageobject endpersonaddresspageobject = null;

	public RemovePersonAddress_pageobject(WebDriver driver) {
		this.driver = driver;
		homepageobject = PageFactory.initElements(driver,
				Home_pageobjects.class);
		addpersonaddresspageobject = PageFactory.initElements(driver,
				AddPersonAddress_pageobjects.class);
		endpersonaddresspageobject = PageFactory.initElements(driver,
				EndPersonAddress_pageobject.class);
		elements = new GenericActions(driver);
	}

	// YesButton in Remove Address Overlay
	public final By YesButton = By.xpath("//div[3]/span/button[1]");
	// Remove Address Overlay
	public final By RemovePersonAddressOverlay = By
			.xpath("//*[@id = 'person']/div[4]/div[1]");
	// NoButton in Remove Address Overlay
	public final By NoButton = By.xpath("//div[3]/span/button[2]");
	// Remove Button
	public final By RemoveButton = By
			.xpath("//*[@id = 'personDetailsAddressViewResults']/div[1]/div/table/tbody[2]/tr/td[6]/span/ul/li/ul/li[2]/a");
	// Confirmation Message on Deleting Record
	public final By ConfirmationMessageOnDeletingRecord = By
			.xpath("//*[@id='headerMessage']/div[1]/h4");

	// Methods for Remove person Address

	// Verifying whether address is displayed in address table
	public boolean addressDisplayedInAddressTable() {
		return elements
				.isElementPresent(addpersonaddresspageobject.TableFirstAddress);
	}

	// Fetching the Text of Confirmation message on Deleting Address
	public String confirmationMessageonDeletingAddress() {
		logger.info("Fetching the Text of Confirmation message on Deleting Address");
	//	elements.waitForElementFluently(homepageobject.HomeLink, 30);
		elements.waitForElementFluently(ConfirmationMessageOnDeletingRecord, 10);
		return elements.getText(ConfirmationMessageOnDeletingRecord);
	}

	// Clicking on yes button
	public void clickOnYesButton() {
		logger.info("Clicking on yes button");
		elements.waitForElementFluently(RemovePersonAddressOverlay, 30);
		elements.buttonClick(YesButton);
	}

	// Clicking on Remove Button
	public void clickOnRemoveButton() {
		logger.info("Clicking on Remove Button");
		elements.waitForElementFluently(
				RemoveButton, 30);
		elements.buttonClick(RemoveButton);
	}

}

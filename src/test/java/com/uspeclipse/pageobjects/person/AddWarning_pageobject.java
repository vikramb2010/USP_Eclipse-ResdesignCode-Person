package com.uspeclipse.pageobjects.person;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.uspeclipse.commonservices.GenericActions;
import com.uspeclipse.pageobjects.home.Home_pageobjects;
import com.uspeclipse.setup.Initialization;

public class AddWarning_pageobject {
	private WebDriver driver=null;
	private static  Logger logger = Logger.getLogger(AddWarning_pageobject.class);
	GenericActions elements = null;
	Home_pageobjects homepageobject = null;
	AddPerson_pageobject addpersonpageobject = null;
	
	public AddWarning_pageobject(WebDriver driver){
		this.driver=driver;
		homepageobject = PageFactory.initElements( driver, Home_pageobjects.class);
		addpersonpageobject = PageFactory.initElements( driver, AddPerson_pageobject.class);
		elements = new GenericActions(driver);
	}

	public final By  AddWarningButton=By.id("viewAddEditWarningButton");
	public final By  AddWarningOverlay=By.xpath("//div[2]");
	public final By  WarningTypeCheckbox=By.id("RISK_1");
	public final By WarningTypeCheckboxList=By.xpath("//div[@id='personWarningDialog']/fieldset/div/div");
	public final By  WarningDetailsTextBox=By.id("note");
	public final By  AddWarningSaveButton=By.xpath("//button[2]");
	public final By  AddWarningCancelButton=By.xpath("//button[3]");
	// Red Triangle Warning Icon
	public final By  WarningIcon=By.xpath("//small/a");

	public void clickonAddWarningButton() throws InterruptedException {
		logger.info("Clicking on Warning Button on Person Detail page");
		if (!(Initialization.browserName).equals("firefox")) {
			elements.waitForElementFluently(
					homepageobject.HomeLink, 30);
			driver.navigate().refresh();
		}

		elements.waitForElementFluently(
				homepageobject.HomeLink, 30);
		elements.waitForElementFluently(
				AddWarningButton, 30);
		elements.buttonClick(AddWarningButton);
	}

	public boolean isAddWarningButtonDisplayed() {
		logger.info("Checking if Add Warning Button is Displayed");
		elements.waitForElementFluently(
				homepageobject.HomeLink, 10);
		return elements.isDisplayed(AddWarningButton);
	}

	public void enterWarningDetails(String value) {
		logger.info("Provide Warning Details");
		elements.waitForElementFluently(
				WarningDetailsTextBox, 10);
		elements.inputValue(WarningDetailsTextBox, value);
	}

	public void clickonAddWarningSaveButton() {
		logger.info("Clicking on Add Warning Save button");
		elements.waitForElementFluently(
				AddWarningSaveButton, 10);
		elements.buttonClick(AddWarningSaveButton);
	}

	public void clickonAddWarningCancelButton() {
		logger.info("Clicking on Add Warning Cancel button");
		elements.waitForElementFluently(
				AddWarningCancelButton, 10);
		elements.buttonClick(AddWarningCancelButton);
	}

	public boolean isWarningIconDisplayed() {
		boolean result = false;
		logger.info("Checking if Warning Icon is Displayed");
		elements.waitForElementFluently(homepageobject.HomeLink, 10);
		elements.waitForElementFluently(addpersonpageobject.ConfirmationMessage, 10);
		if ((elements.isElementPresent( WarningIcon)) == true) {
			logger.info("Warning Icon is Displayed");
			result = elements.isElementPresent(WarningIcon);
		} else
			logger.error("Warning Icon is not Displayed");
		return result;
	}

	public void clickonWarningTypeCheckbox() {
		logger.info("Click on Warning Type Checkbox");

		elements.waitForElementFluently(
				AddWarningOverlay, 10);
		// if ((Initialization.browserName).equals("chrome")) {
		elements.buttonClick(WarningTypeCheckbox);
		/*
		 * } else { Random number = new Random(); int i = number.nextInt(6);
		 * System.out.println(i); List<WebElement> checkboxlist =
		 * WarningTypeCheckboxList; WebElement value =
		 * checkboxlist.get(i).findElement( By.xpath("./label/input"));
		 * elements.buttonClick(value, driver); }
		 */

	}
}

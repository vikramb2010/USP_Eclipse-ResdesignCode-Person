package com.uspeclipse.pageobjects.person;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.uspeclipse.commonservices.GenericActions;
import com.uspeclipse.pageobjects.home.Home_pageobjects;
import com.uspeclipse.setup.Initialization;

public class EditPersonRecord_pageobject {
	private WebDriver driver=null;
	private static  Logger logger = Logger.getLogger(EditPersonRecord_pageobject.class);
	GenericActions elements = null;
	Home_pageobjects Home = null;
	AddPerson_pageobject Person =null;
	
	public EditPersonRecord_pageobject(WebDriver driver){
		this.driver=driver;
		Home = PageFactory.initElements(driver, Home_pageobjects.class);
		Person = PageFactory.initElements( driver, AddPerson_pageobject.class);
		elements = new GenericActions(driver);
	}

	public final By  PersonSelectLink=By.xpath("//span/ul/li/a");
	public final By  SwitchFocustoLink=By.xpath("//li/ul/li/a");
	public final By  EditPersonDetailsButton=By.xpath("//button[@id='editPersonDetailsButton']");  //By.id("editPersonDetailsButton");
	public final By  ChangePersonRolesButton=By.id("changePersonRoles");
	public final By  OverlayTitle=By.id("labelledby");
	public final By  NarrativeTextonChangeRole=By.xpath("// form/div/div/div/span");
	public final By  NarrativeTextonEditForm=By.id("describedby");
	public final By  PersonRoleClientRadioButton=By.id("person_roleClient");
	public final By  PersonRoleProfessionalRadioButton=By.id("person_roleProfessional");
	public final By  ProceedButton=By.xpath("//div[3]/span/button");
	public final By  CancelButton=By.xpath("//button[2]");
	public final By  ProfessionalTitleDropDown=By.id("professionalTitle-input");
	public final By  OrganisationTextBox=By.id("organisationName-input");
	public final By  SaveButton=By.xpath("//div[3]/span/button");
	public final By  EditPersonOverlay=By.xpath("//div[contains(@class,'UpdatePersonView')]");

	
	public void clickonPersonSelectLink() throws InterruptedException {
		logger.info("Clicking on Person Select Link for the Searched Person");
		elements.waitForElementToBeClickable(
				PersonSelectLink, 10);
		if ((Initialization.browserName).equals("chrome"))
			driver.navigate().refresh();
		elements.waitForElementFluently(
				PersonSelectLink, 10);
		elements.buttonClick(PersonSelectLink);
		elements.waitForElementFluently(
				SwitchFocustoLink, 10);
	}

	public void clickonSwitchFocustoLink() {
		logger.info("Clicking on Switch to Focus Link for the Searched Person");
		elements.waitForElementFluently(
				SwitchFocustoLink, 10);
		elements.buttonClick(SwitchFocustoLink);
		elements.waitForElementFluently( Home.HomeLink,
				10);
	}

	public boolean isEditPersonDetailsButtonDisplayed() {
		logger.info("Checking if Edit Person details button is Displayed");
		return elements.isDisplayed(EditPersonDetailsButton);
	}

	public String getNarrativeTextonChangeRole() {
		logger.info("Getting Narrative Text on Change Role Overlay");
		elements.waitForElementFluently(
				NarrativeTextonChangeRole, 10);
		return elements.getText(NarrativeTextonChangeRole);
	}

	public String getNarrativeTextonEditForm() {
		logger.info("Getting Narrative Text on Edit Form");
		elements.waitForElementFluently(
				NarrativeTextonEditForm, 10);
		return elements.getText(NarrativeTextonEditForm);
	}

	public String getOverlayTitle() {
		logger.info("Getting Title on Edit Person Overlay");
		elements.waitForElementFluently( OverlayTitle,
				10);
		return elements.getText(OverlayTitle);
	}

	public boolean isPersonRoleRadioButtonDisplayed(String value) {
		logger.info("Checking if " + value
				+ "Person Role Radio button Displayed");
		boolean result = false;
		if (value.equals("client"))
			result = elements.isDisplayed(PersonRoleClientRadioButton);
		else if (value.equals("professional"))
			result = elements.isDisplayed(PersonRoleProfessionalRadioButton);
		return result;
	}

	public void clickonPersonRoleRadioButton(String value) {
		logger.info("Clicking on " + value + "Person Role Radio button");
		if (value.equals("client"))
			elements.buttonClick(PersonRoleClientRadioButton);
		else if (value.equals("professional"))
			elements.buttonClick(PersonRoleProfessionalRadioButton);
	}

	public boolean isPersonRoleClientRadioButtonSelected() {
		logger.info("Checking if Client Person Role Radio Button is Selected");
		elements.waitForElementFluently(
				PersonRoleClientRadioButton, 10);
		return elements.isSelected(PersonRoleClientRadioButton);
	}

	public boolean isProceedButtonDisplayed() {
		logger.info("Checking if Proceed Button is Displayed");
		return elements.isDisplayed(ProceedButton);
	}

	public boolean isCancelButtonDisplayed() {
		logger.info("Checking if Cancel Button is Displayed");
		return elements.isDisplayed(CancelButton);
	}

	public void clickonProceedButton() {
		logger.info("Clicking on Proceed Button");
		elements.waitForElementFluently( ProceedButton,
				10);
		elements.buttonClick(ProceedButton);
	}

	public void selectOptionfromProfessionalTitleDropDown(String value) {
		logger.info("Selecting " + value + " from Professional Title Dropdown");
		elements.waitForElementFluently(
				ProfessionalTitleDropDown, 10);
		elements.selectDropdown(ProfessionalTitleDropDown, value);
	}

	public void enterOrganisation(String value) {
		logger.info("Providing " + value + " in Organisation Textbox");
		elements.waitForElementFluently(
				OrganisationTextBox, 10);
		elements.inputValue(OrganisationTextBox, value);
	}

	public void clickonSaveButton() {
		logger.info("Clicking on Save Button");
		elements.waitForElementFluently( SaveButton, 10);
		elements.buttonClick(SaveButton);
	}

	public void editPersonDetails(String edittitle, String editforename,
			String editmiddlename, String editsurname, String editproftitle,
			String organisation) {
		logger.info("Editing Person Details");
		Person.selectOptionfromTitleDropdown(edittitle);
		if (!(editforename).equals(""))
			Person.enterForename(editforename);
		if (!(editmiddlename).equals(""))
			Person.enterMiddlename(editmiddlename);
		Person.enterSurname(editsurname);
		selectOptionfromProfessionalTitleDropDown(editproftitle);
		enterOrganisation(organisation);
		clickonSaveButton();
	}

	public void clickonEditPersonDetailsButton() {
		logger.info("Clicking on Edit Person Details button");
		elements.waitForElementFluently(EditPersonDetailsButton, 10);
		elements.buttonClick(EditPersonDetailsButton);
	}

	public boolean isEditPersonOverlayDisplayed() {
		logger.info("Checking if Edit Person Overlay is Displayed");
		return elements.isDisplayed(EditPersonOverlay);
	}

	public boolean isEditPersonFormFieldDisplayed(String value) {
		logger.info("Checking if " + value
				+ " is Displayed on Edit Person Form");
		boolean result = false;
		if (value.equals("title"))
			result = elements.isDisplayed(Person.TitleDropdown);
		else if (value.equals("forename"))
			result = elements.isDisplayed(Person.ForenameTextbox);
		else if (value.equals("middlename"))
			result = elements.isDisplayed(Person.MiddlenameTextbox);
		else if (value.equals("surname"))
			result = elements.isDisplayed(Person.SurnameTextbox);
		else if (value.equals("proftitle"))
			result = elements.isDisplayed(ProfessionalTitleDropDown);
		else if (value.equals("organisation"))
			result = elements.isDisplayed(OrganisationTextBox);
		else if (value.equals("save"))
			result = elements.isDisplayed(SaveButton);
		else if (value.equals("cancel"))
			result = elements.isDisplayed(CancelButton);
		return result;
	}
}

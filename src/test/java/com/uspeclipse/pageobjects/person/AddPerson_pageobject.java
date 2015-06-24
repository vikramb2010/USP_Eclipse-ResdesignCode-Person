package com.uspeclipse.pageobjects.person;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.uspeclipse.commonservices.GenericActions;
import com.uspeclipse.pageobjects.home.Home_pageobjects;
import com.uspeclipse.setup.Initialization;

public class AddPerson_pageobject {
	private WebDriver driver;
	private static  Logger logger = Logger.getLogger(AddPerson_pageobject.class);
	GenericActions elements =null;
	Home_pageobjects Home = null;
	
	public AddPerson_pageobject(WebDriver driver){
		this.driver = driver;
		this.Home=PageFactory.initElements(driver, Home_pageobjects.class);
		elements = new GenericActions(driver);
	}
	
	// Button to add a new person
	public final By AddPersonButton = By.id("addPersonButton");			//  -- By.xpath("//a[@id='addPersonButton']");
	// Add Person title on the Overlay
	public final By AddPersonOverlay=By.id("labelledby");
	// Narrative Text on the first screen of Overlay after click on Add Person button
	public final By NarrativeText=By.id("personRoleSelectNarrative");
	// Client/Carer Checkbox Input
	public final By ClientCheckboxInput=By.id("person_roleClient-input");
	// Other Checkbox Input
	public final By OtherCheckboxInput=By.id("person_roleOther-input");
	// Professional Checkbox Input
	public final By ProfessionalCheckboxInput=By.id("person_roleProfessional-input");
	// Proceed button on first screen of overlay
	public final By ProceedButton=By.xpath("//div[3]/span/button");
	// Cancel button on first screen of overlay
	public final By CancelButton=By.xpath("//button[2]");
	// Narrative Text on the second screen of Overlay
	public final By NarrativeText1=By.xpath("//form/div/div/div/span");
	public final By TitleDropdown=By.xpath("//select[@id='title-input']");
	public final By DefaultTitleDropdown=By.xpath("//select[@id='title-input']/option");
	public final By ForenameTextbox=By.id("forename-input");
	public final By MiddlenameTextbox=By.id("middleNames-input");
	public final By SurnameTextbox=By.id("surname-input");
	public final By CalendarIcon=By.xpath("//span/a/i");
	public final By CalendarDisplay=By.xpath("//*[@id='person']/div[2]/div/div/div");
	public final By DOBYearTextbox=By.id("fuzzyDOBYEAR");
	public final By DOBMonthDropdown=By.id("fuzzyDOBMONTH");
	public final By DOBDayDropdown=By.id("fuzzyDOBDAY");
	public final By AgeTextbox=By.id("age-input");
	public final By DOBEstimatedCheckbox=By.id("dateOfBirthEstimated-input");
	public final By MaleGenderRadioButton=By.xpath("//fieldset/div/div/label/input");
	public final By FemaleGenderRadioButton=By.xpath("//fieldset/div/div[2]/label/input");
	public final By IndeterminateGenderRadioButton=By.xpath("//fieldset/div/div[3]/label/input");
	public final By UnknownGenderRadioButton=By.xpath("//fieldset/div/div[4]/label/input");
	public final By EthnicityDropdown=By.id("ethnicity-input");
	public final By DefaultEthnicityDropdown=By.xpath("//select[@id='ethnicity-input']/option");
	public final By NHSFirstThreeDigits=By.id("nhsFirstThreeDigits-input");
	public final By NHSSecondThreeDigits=By.id("nhsSecondThreeDigits-input");
	public final By NHSLastFourDigits=By.id("nhsLastFourDigits-input");
	public final By SaveButton=By.xpath("//div[contains(@class,'NewPersonView')]//button[contains(.,'save')]");
	public final By CancelButton1=By.xpath("//button[contains(.,'cancel')]");
	public final By ConfirmationMessage=By.xpath("//div[@id='headerMessage']//h4");  //  //div[@id='headerMessage']/div[1]/h4
	public final By PersonName=By.xpath("//*[@id='personContext']/span[2]");
	public final By personName=By.xpath("//*[@id='personDetailsIdentificationAccordion']/div/div/div[1]/div[2]");
	public final By PersonType=By.xpath("//*[@id='personDetailsIdentificationAccordion']/div/div/div[5]/div[2]");
	public final By OrganisationTextbox=By.xpath("//div[@id='personDetailsIdentificationAccordion']/div/div/div[4]/div[2]");
	public final By AddPersonRoles=By.id("addPersonRoles");
	public final By ChangePersonRolesButton=By.id("changePersonRoles");
	public final By CloseButton=By.xpath("//div[contains(@class,'NewPersonView')]//button[contains(.,'Close')]");
	public final By EstimatedDOBIcon=By.xpath("//div[3]/div[2]/span");
	public final By TitleList=By.xpath("//select[@id='title-input']/option");
	public final By DOBMonthList = By.xpath("//*[@id='fuzzyDOBMONTH']/option");

	// Add Warning Button
	public final By AddWarningButton=By.xpath("//a[@id='viewAddEditWarningButton']");

	// Red Triangle Warning Icon
	public final By WarningButton=By.xpath("//*[contains(@class,'icon-warning-sign')]");

	public boolean isAddNewPersonButtonDisplayed() {
		logger.info("Checking if Add Person button is Displayed on Home page");
		if (Initialization.browserName.equals("android")) {
			elements.buttonClick(Home.MenuExpandButton);
			elements.waitForElementFluently(Home.HomeLink, 10);
			elements.buttonClick(Home.MenuCloseButton);
		} else
			elements.waitForElementFluently(Home.HomeLink, 10);
		return elements.isDisplayed(AddPersonButton);
	}

	public void clickonAddNewPersonButton() {
		logger.info("Clicking on Add Person Button");
		elements.waitForElementFluently(Home.HomeLink, 15);
		elements.buttonClick(AddPersonButton);
		elements.Waitformilliseconds(2000);
		elements.waitForElementFluently(AddPersonOverlay, 10);
	}

	public boolean isAddNewPersonOverlayDisplayed() {
		logger.info("Checking if Add Person Overlay is Displayed");
		return elements.isDisplayed(AddPersonOverlay);
	}

	public String getNarrativeText() {
		logger.info("Getting Narrative text on the Add Person Overlay");
		return elements.getText(NarrativeText);
	}

	public boolean isPersonTypeCheckboxDisplayed(String value) {
		logger.info("Checking if " + value
				+ " Checkbox is Displayed on Add Person Overlay");
		boolean result = false;
		if (value.equals("client"))
			result = elements.isDisplayed(ClientCheckboxInput);
		else if (value.equals("other"))
			result = elements.isDisplayed(OtherCheckboxInput);
		else if (value.equals("professional"))
			result = elements.isDisplayed(ProfessionalCheckboxInput);
		return result;
	}

	public boolean isPersonTypeCheckboxSelected(String value) {
		logger.info("Checking if " + value
				+ " Checkbox is Selected on Add Person Overlay");
		boolean result = true;
		if (value.equals("client"))
			result = elements.isSelected(ClientCheckboxInput);
		else if (value.equals("other"))
			result = elements.isSelected(OtherCheckboxInput);
		else if (value.equals("professional"))
			result = elements.isSelected(ProfessionalCheckboxInput);
		return result;
	}

	public boolean isProceedButtonDisplayed() {
		logger.info("Checking if Proceed Button is Displayed on Add Person Overlay");
		return elements.isDisplayed(ProceedButton);
	}

	public boolean isCancelButtonDisplayed() {
		logger.info("Checking if Cancel Button is Displayed on Add Person Overlay");
		return elements.isDisplayed(CancelButton);
	}

	public void clickonPersonTypeCheckbox(String value) {
		logger.info("Clicking on " + value + " Chekbox on Add Person Overlay");
		if (value.equals("client"))
			elements.buttonClick(ClientCheckboxInput);
		else if (value.equals("other"))
			elements.buttonClick(OtherCheckboxInput);
		else if (value.equals("professional"))
			elements.buttonClick(ProfessionalCheckboxInput);
	}

	public void clickonProceedButton() {
		logger.info("Clicking on Proceed Button on Add Person Overlay");
		elements.buttonClick(ProceedButton);
		elements.waitForElementFluently( NarrativeText1,
				10);
	}

	public String getNarrativeTextonForm() {
		logger.info("Getting Narrative Text on Add Person Form");
		return elements.getText(NarrativeText1);
	}

	public String getDefaultTitleinDropdown() {
		logger.info("Getting Default value from Title Dropdown on Add Person Form");
		return elements.getText(DefaultTitleDropdown);
	}

	public boolean isOptionsofTitleDropdownnotEmpty() {
		logger.info("Verifying if Title Dropdown is not Empty");
		boolean titleopt = true;
		List<WebElement> titleoptions = elements.getElementListWithIdentification(TitleList);
		for (WebElement options : titleoptions) {
			if ((options.getText()).equals(""))
				titleopt = false;
		}
		return titleopt;
	}

	public void enterDOBYear(String value) {
		logger.info("Providing " + value
				+ " in the Year Text box on Add Person Form");
		elements.inputValue(DOBYearTextbox, value);
	}

	public boolean isDOBDropdownEnabled(String value) {
		logger.info("Checking if " + value
				+ " Dropdown is enabled on Add Person Form");
		boolean result = true;
		if (value.equals("DOBMonth"))
			result = elements.isEnabled(DOBMonthDropdown);
		else if (value.equals("DOBDay"))
			result = elements.isEnabled(DOBDayDropdown);
		return result;
	}

	public boolean checkDOBMonthOptions() {
		logger.info("Verifying the Options in the Month Dropdown on Add Person Form");
		List<WebElement> monthoptions = elements.getElementListWithIdentification(DOBMonthList);
		boolean monthopt = false;
		List<String> months = Arrays.asList("", "Jan", "Feb", "Mar", "Apr",
				"May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
		int i = 0;
		for (WebElement options : monthoptions) {
			if ((options.getText()).equals(months.get(i).toString())) {
				monthopt = true;
			}
			i++;
		}
		return monthopt;
	}

	public void clickonCloseButton() {
		logger.info("Clicking on Close button on Add Person Form");
		// elements.scrollPageUp(driver);
		elements.waitForElementFluently(
				AddPersonOverlay, 10);
		elements.buttonClick(CloseButton);
		elements.waitForElementFluently(
				AddPersonButton, 10);
	}

	public void clickonCancelButtononForm() {
		logger.info("Clicking on Cancel button on Add Person Form");
		elements.waitForElementFluently( CancelButton1,
				10);
		elements.buttonClick(CancelButton1);
		if (!(Initialization.browserName).equals("android"))
			elements.waitForElementFluently(
					AddPersonButton, 10);
	}
	
	
	public void clickCancelOnFirstAddOverlay(){
		logger.info("Clicking on Cancel button on Add Person Form");
		elements.waitForElementFluently( CancelButton,10);
		elements.buttonClick(CancelButton);
	}

	public void selectOptionfromTitleDropdown(String value) {
		logger.info("Selecting " + value
				+ " from Title Dropdown on Add Person Form");
		elements.waitForElementFluently( TitleDropdown,
				10);
		elements.selectDropdown(TitleDropdown, value);
	}

	public void enterForename(String value) {
		logger.info("Providing " + value
				+ " in Forename Textbox on Add Person Form");
		elements.inputValue(ForenameTextbox, value);
	}

	public void enterMiddlename(String value) {
		logger.info("Providing " + value
				+ " in Middlename Textbox on Add Person Form");
		elements.inputValue(MiddlenameTextbox, value);
	}

	public void enterSurname(String value) {
		logger.info("Providing " + value
				+ " in Surname Textbox on Add Person Form");
		elements.inputValue(SurnameTextbox, value);
	}

	public void selectOptionfromDOBMonthDropdown(String value) {
		logger.info("Selecting " + value
				+ " from Month Dropdown on Add Person Form");
		elements.waitForElementFluently(
				DOBMonthDropdown, 10);
		elements.selectDropdown(DOBMonthDropdown, value);
	}

	public void selectOptionfromDOBDayDropdown(String value) {
		logger.info("Selecting " + value
				+ " from Day Dropdown on Add Person Form");
		elements.waitForElementFluently( DOBDayDropdown,
				10);
		elements.selectDropdown(DOBDayDropdown, value);
	}

	public void clickonGenderRadioButton(String value) {
		logger.info("Clicking on " + value + " Gender on Add Person Form");
		if (value.equals("Male"))
			elements.buttonClick(MaleGenderRadioButton);
		else if (value.equals("Female"))
			elements.buttonClick(FemaleGenderRadioButton);
		else if (value.equals("Indeterminate"))
			elements.buttonClick(IndeterminateGenderRadioButton);
		else if (value.equals("Unknown"))
			elements.buttonClick(UnknownGenderRadioButton);
	}

	public boolean isnGenderRadioButtonDisplayed(String value) {
		logger.info("Checking if " + value
				+ " Gender is Displayed on Add Person Form");
		boolean result = false;
		if (value.equals("Male"))
			result = elements.isDisplayed(MaleGenderRadioButton);
		else if (value.equals("Female"))
			result = elements.isDisplayed(FemaleGenderRadioButton);
		else if (value.equals("Indeterminate"))
			result = elements.isDisplayed(IndeterminateGenderRadioButton);
		else if (value.equals("Unknown"))
			result = elements.isDisplayed(UnknownGenderRadioButton);
		return result;
	}

	public void selectOptionfromEthnicityDropDown(String value) {
		logger.info("Selecting " + value
				+ " from Ethnicity Dropdown on Add Person Form");
		elements.selectDropdown(EthnicityDropdown, value);
	}

	public void clickonSaveButton() {
		logger.info("Clicking on Save Button on Add Person Form");
		elements.waitForElementFluently( SaveButton, 10);
		elements.buttonClick(SaveButton);
	}

	public void AddNewPerson(String persontype, String title, String forename,
			String middlename, String surname, String byear, String bmonth,
			String bday, String gender, String ethnicity) {
		logger.info("Adding a New Person to the System");
		elements.waitForElementFluently(Home.HomeLink, 20);
		clickonAddNewPersonButton();
		clickonPersonTypeCheckbox(persontype);
		clickonProceedButton();
		selectOptionfromTitleDropdown(title);
		enterForename(forename);
		enterMiddlename(middlename);
		enterSurname(surname);
		enterDOBYear(byear);
		if (!(bmonth).equals(""))
			selectOptionfromDOBMonthDropdown(bmonth);
		if (!(bmonth).equals(""))
			selectOptionfromDOBDayDropdown(bday);
		clickonGenderRadioButton(gender);
		selectOptionfromEthnicityDropDown(ethnicity);
		clickonSaveButton();
	}

	public String verifyConfirmationMessage() {
		logger.info("Verifying Confirmation message");
		elements.waitForElementFluently(ConfirmationMessage, 5);
		return elements.getText(ConfirmationMessage);
	}

	public boolean isConfirmationMessageDisplayed() {
		logger.info("Checking if Confirmation Message is Displayed after adding a person");
		elements.waitForElementFluently(ConfirmationMessage, 10);
		return driver.findElement(ConfirmationMessage).isDisplayed();
		//return elements.isDisplayed(ConfirmationMessage);
	}

	public String verifyPersonDetails() {
		logger.info("Verifying Person Details of recently added person");
		elements.waitForElementFluently( PersonName, 10);
		String personname = elements.getText(PersonName);
		String name = personname.substring(0, personname.indexOf("(") - 1);
		return name;
	}

	public String verifyPersonType() {
		logger.info("Verifying Person Type of Recently added person");
		elements.waitForElementFluently( PersonType, 10);
		String type = null;
		String persontype = elements.getText(PersonType);
		boolean rolelink = elements.isElementPresent(
				ChangePersonRolesButton);
		if (rolelink == true) {
			type = persontype.substring(21);
		} else {
			type = persontype.substring(9);
		}
		return type;
	}

	public String getOrganisationfromTextbox() {
		logger.info("Getting Organisation from Text box on Person Details page");
		elements.waitForElementFluently(
				OrganisationTextbox, 10);
		return elements.getText(OrganisationTextbox);
	}

	public boolean isPersonRoleLinkDisplayed(String value) {
		logger.info("Checking if " + value
				+ " Person Role link is Displayed on Person Detail page");
		boolean result = false;
		if (value.equals("Add"))
			result = elements.isDisplayed(AddPersonRoles);
		else if (value.equals("Change"))
			result = elements.isDisplayed(ChangePersonRolesButton);
		return result;
	}

	public void clickonPersonRoleLink(String value) {
		logger.info("Clicking on " + value
				+ " Person Role on Person Detail page");
		if (value.equals("Add"))
			elements.buttonClick(AddPersonRoles);
		else if (value.equals("Change"))
			elements.buttonClick(ChangePersonRolesButton);
	}

	public boolean verifyEstimatedAge(String value) throws InterruptedException {
		logger.info("Verifying Estimated Age");
		elements.waitForData( AgeTextbox, 10, "39");
		String estimatedage = elements.getText(AgeTextbox);
		System.out.println(estimatedage);
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int age = (Integer.parseInt(value) - year) + 1;
		boolean result = false;
		if (Integer.parseInt(estimatedage) == age)
			result = true;
		return result;
	}

	public String getDefaultEthnicityinDropdown() {
		logger.info("Getting Default value from Ethnicity Dropdown on Add Person Form");
		elements.waitForElementFluently(
				DefaultEthnicityDropdown, 10);
		return elements.getText(DefaultEthnicityDropdown);
	}

	public String getPersonName() {
		logger.info("Getting Person Name from Person Detail page");
		elements.waitForElementFluently( PersonName, 10);
		return elements.getText(PersonName);
	}

	public String getPersonNamefromHeader() {
		logger.info("Getting Person Name from Person Detail page");
		elements.waitForElementFluently( PersonName, 10);
		String person = elements.getText(PersonName);
		return person.substring(0, person.indexOf("(")).trim();
	}

	public String getPersonID() {
		logger.info("Getting Person ID from the Person Detail page");
		elements.waitForElementFluently( PersonName, 10);
		String personname = elements.getText(PersonName);
		String personId = personname.substring(personname.indexOf("(") + 1,
				personname.indexOf(")"));
		return personId;
	}

	public boolean isEstimatedDOBIconDisplayed() {
		logger.info("Checking if Estimated DOB icon is Displayed on Person Detail page");
		elements.waitForElementFluently(
				EstimatedDOBIcon, 10);
		return elements.isDisplayed(EstimatedDOBIcon);
	}

	public void clickonCalenderIcon() {
		logger.info("Clicking on Calendar Icon on Add Peron Form");
		elements.waitForElementFluently( CalendarIcon,
				10);
		elements.buttonClick(CalendarIcon);
	}

	public boolean isCalendarDisplayed() {
		logger.info("Checking if Calendar is Displayed on Add Person Form");
		elements.waitForElementFluently(
				CalendarDisplay, 10);
		return elements.isDisplayed(CalendarDisplay);
	}

	public void mouseHoveronAddPersonButton() {
		logger.info("Mouse Hover on Add Person Button");
		elements.waitForElementFluently( Home.HomeLink,
				10);
		elements.mouseHover( AddPersonButton);
	}

	public String getAddPersonToolTipText(String value) {
		logger.info("Getting Tool Tip of Add Person Button");
		elements.waitForElementFluently( Home.HomeLink,
				10);
		return elements.getAttribute(AddPersonButton, value);
	}

	public void clickonAddWarning() {
		elements.waitForElementFluently(AddWarningButton, 10);
		elements.buttonClick(AddWarningButton);
		elements.Waitformilliseconds(2000);
	}

	// Click Red Triangle Warning Icon
	public void clickWarningIcon() {
		elements.buttonClick(WarningButton);
	}
}

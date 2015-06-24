package com.uspeclipse.pageobjects.casenotes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.uspeclipse.commonservices.GenericActions;
import com.uspeclipse.pageobjects.home.Home_pageobjects;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;

public class AddEntryPerson_pageobject {

	private WebDriver driver;
	Home_pageobjects homepageobject = null;
	AddPerson_pageobject addpersonpageobject = null;
	Home_pageobjects Home = null;
	SourceFilter_pageobject srcfilterpageobject = null;
	private static Logger logger = Logger
			.getLogger(AddEntryPerson_pageobject.class);
	GenericActions elements = null;

	public AddEntryPerson_pageobject(WebDriver driver) {
		this.driver = driver;
		this.homepageobject = PageFactory.initElements(
				driver,Home_pageobjects.class);
		this.addpersonpageobject = PageFactory.initElements(
				driver,AddPerson_pageobject.class);
		this.srcfilterpageobject = PageFactory.initElements(
				driver,SourceFilter_pageobject.class);
		elements = new GenericActions(driver);
	}

	public final By LoggedinUsername=By.xpath ("//span[@class='username']");
	public final By PractitionerFilter=	By.xpath ("//select[@id='caseNoteEntryFilter_practitioner']/option");
	public final By AddCaseNoteButton= By.xpath( "//li[@id='addCaseNoteButton']/a");
	// div[11]");
	public final By AddCaseNoteOverlay=	By.xpath ("//div[contains(@class,'NewCaseNoteEntryView')]");
	public final By PersonIcon=	By.xpath ("//a[@class='source-and-practitioner pop-over']");
	
	public final By PopupDisplay=By.id ("overlay-panels");
	
	public final By SourceTextBox=By.id ("entryForm_source");
	
	public final By SourceOrganisationTextBox=By.id ("entryForm_sourceOrganisation");
	
	public final By PractitionerTextBox=By.id ("entryForm_practitioner");
	
	public final By PractitionerOrganisationTextBox=By.id ("entryForm_practitionerOrganisation");
	
	public final By ImpactIcon=By.xpath ("//a[@class='impact impact-unknown pop-over']");
	
	public final By PositiveImpactRadioButton=By.id ("caseNoteEntryAddForm_impactPositive");
	
	public final By NegativeImpactRadioButton=By.id ("caseNoteEntryAddForm_impactNegative");
	
	public final By NeutralImpactRadioButton=By.id ("caseNoteEntryAddForm_impactNeutral");
	
	public final By UnknownImpactRadioButton=By.id ("caseNoteEntryAddForm_impactUnknown");
	
	public final By EditPositiveImpactRadioButton=By.id ("caseNoteEntryEditForm_impactPositive");
	
	public final By EditNegativeImpactRadioButton=By.id ("caseNoteEntryEditForm_impactNegative");
	
	public final By EditNeutralImpactRadioButton=By.id ("caseNoteEntryEditForm_impactNeutral");
	
	public final By EditUnknownImpactRadioButton=By.id ("caseNoteEntryEditForm_impactUnknown");
	
	public final By ViewPositiveImpactRadioButton=By.id ("caseNoteEntryViewForm_impactPositive");
	
	public final By ViewNegativeImpactRadioButton=By.id ("caseNoteEntryViewForm_impactNegative");
	
	public final By ViewNeutralImpactRadioButton=By.id ("caseNoteEntryViewForm_impactNeutral");
	
	public final By ViewUnknownImpactRadioButton=By.id ("caseNoteEntryViewForm_impactUnknown");
	
	public final By CaseNotesSaveButton=By.xpath ("//button[contains(text(),'Save')]");
	
	// button[contains(text(),'Cancel')]");
	public final By CaseNotesCancelButton=By.xpath ("//button[3]");
	
	// button[contains(text(),'Cancel')]");
	public final By ViewCaseNoteCancelButton=By.xpath ("//button[2]");
	
	public final By ErrorMessageBox=By.xpath ("//div[@class='message message-block message-error']");
	
	public final By EntryTypeMandatoryMessage=By.xpath ("//a[contains(text(),'Entry type is mandatory.')]");
	
	public final By EntryMandatoryMessage=By.xpath ("//a[contains(text(),'Entry is mandatory.')]");
	
	public final By FutureDateErrorMessage=By.xpath ("//a[contains(text(),'Entry date must be valid - today or earlier')]");
	
	public final By SelectCurrentDateLink=By.xpath ("//a[@class='currentDate small']");
	
	public final By SelectCurrentDateTimeLink=By.xpath ("//a[@class='currentDateTime small']");
	
	public final By AddEntryTypeDropdown=By.id ("caseNoteEntryAddForm_entryType");
	
	public final By AddEntryTextbox=By.id ("caseNoteEntryAddForm_event");
	
	public final By SelectButton=By.xpath ("//a[contains(text(),'select')]");
	
	// a[@class='viewCaseNoteEntry']");
	public final By ViewCaseNoteButton=By.xpath ("//a[contains(text(),'view this entry')]");
	
	// div[9]");
	public final By ViewCaseNoteOverlay=By.xpath ("//div[contains(@class,'ViewCaseNoteEntryView')]");
	
	public final By ViewCaseNoteFields=By.id ("caseNoteEntryDialog");
	
	public final By ViewEntryDateTextbox=By.xpath ("//div[@class='value eventDateValue']");
	
	public final By ViewEntryTypeTextbox=By.xpath ("//div[@class='pure-u-1-2 l-box entryType']/div[2]");
	
	public final By ViewEntryTextbox=By.xpath ("//div[@class='value richTextInput eventValue']");
	
	public final By ViewDateIcon=By.xpath ("//a[@class='dates pop-over']");
	
	public final By ViewRecordedDate=By.id ("entryForm_recordedDate");
	
	public final By ViewLastEditedDate=By.id ("entryForm_editedDate");
	
	// a[@class='editCaseNoteEntry']");
	public final By EditCaseNoteButton=By.xpath ("//a[contains(text(),'edit this entry')]");
	
	// div[11]");
	public final By EditCaseNoteOverlay=By.xpath ("//div[contains(@class,'UpdateDraftCaseNoteEntryView')]");
	public final By EditEntryTextbox=	By.id ("caseNoteEntryEditForm_event");
	public final By EditEntryTypeDropdown=	By.id ("caseNoteEntryEditForm_entryType");
	public final By EntryDateYearTextbox=	By.id ("fuzzyEventDateYEAR");
	public final By EntryDateMonthDropdown=	By.id ("fuzzyEventDateMONTH");
	public final By EntryDateDayDropdown=	By.id ("fuzzyEventDateDAY");
	public final By EntryDateHourDropdown=	By.id ("fuzzyEventDateHOUR");
	public final By EntryDateMinuteDropdown=	By.id ("fuzzyEventDateMINUTE");
	public final By EditEntryDropdown=	By.id ("caseNoteEntryEditForm_entryType");
	public final By EditEntryTypeTextbox=	By.id ("caseNoteEntryEditForm_event");
	public final By AddedCaseNoteEntry=	By.xpath ( "//div[@id='generalCaseNoteEntryResults']/div/div/table/tbody[2]/tr");
	// div[@By.id='generalCaseNoteEntryResults']/div/div/table/tbody[2]/tr/td[9]");
	public final By AddedCaseNoteEntryPractitioner=	By.xpath ("//tr[1]/td[@data-title='Practitioner']");
	// tr[1]/td[@data-title='Entry date']");
	public final By AddedCaseNoteEntryDate= 	By.xpath ("//div[@id='generalCaseNoteEntryResults']/div/div/table/tbody[2]/tr[2]/td");
	// tr[3]/td[@data-title='Entry date']");
	public final By LastAddedCaseNoteEntryDate= By.cssSelector ("tr:nth-child(3)>td[data-title='Entry date']");
	public final By LastAddedCaseNoteEntryDate1=By.cssSelector ("tr:nth-child(4)>td[data-title='Entry date']");
	
	public final By CompleteButton=By.xpath ("//button[contains(text(),'Complete')]");
	
	public final By AddedCaseNoteEntryList= 	 By.xpath ("//div[@id='generalCaseNoteEntryResults']/div/div/table/tbody[2]/tr");
	public final By PractitionerFilterList= 	 By.xpath ("//select[@id='caseNoteEntryFilter_practitioner']/option"); 
	public final By ConfirmationMessage= 	By.xpath ("//*[contains(text(),'Case Note entry successfully')]");
	public final By PersonConfirmationMessage=	By.xpath ("//*[contains(text(),'Person successfully added')]");
	public final By NoCaseNotePage=	By.xpath ("//*[contains(text(),'There are no Case Note entries to display.')]");
	public final By UpdateConfirmationMessage=	By.xpath ("//*[contains(text(),'Case Note entry successfully updated')]");
	
	public String getLoggedinPractitionerName() {
		logger.info("Getting Logged in user's Practitioner Name");
		elements.waitForElementFluently( LoggedinUsername, 10);
		String username = elements.getText(LoggedinUsername);
		return username.substring(0, username.indexOf("(")).trim();
	}

	public boolean isPractitionerDisplayedinPractitionerFilter() {
		logger.info("Checking if Practitioner is Displayed in Practitioner Filter");
		return elements.isElementPresent( PractitionerFilter);
	}

	public String getPractitionerNameinPractitionerFilter() {
		logger.info("Getting Practitioner Name from Practitioner Filter");
		elements.waitForElementFluently( PractitionerFilter, 10);
		return elements.getText(PractitionerFilter).trim();
	}

	public void clickonAddCaseNoteButton() {
		logger.info("Clicking on Add Case Note Button");
		elements.waitForElementFluently( AddCaseNoteButton, 10);
		elements.buttonClick(AddCaseNoteButton);
		elements.waitForPageLoaded();
		elements.waitForElementFluently( AddCaseNoteOverlay, 10);
	}

	public boolean isAddCaseNoteButtonDisplayed() {
		logger.info("Checking if Add Case Button is Displayed");
		return elements.isElementPresent( AddCaseNoteButton);
	}

	public boolean isAddCaseNoteOverlayDisplayed() {
		logger.info("Checking if Add Case Note Overlay is Displayed");
		elements.waitForElementFluently( CaseNotesSaveButton, 10);
		return elements.isDisplayed(AddCaseNoteOverlay);
	}

	public void clickonPersonIcon() {
		logger.info("Clicking on Person Icon");
		elements.waitForElementFluently( PersonIcon, 10);
		elements.buttonClick(PersonIcon);
	}

	public String getPractitionerName() {
		logger.info("Getting Practitioner Name from Practitioner Text box");
		elements.waitForElementFluently( PractitionerTextBox, 10);
		return elements.getAttribute(PractitionerTextBox, "value");
	}

	public String getPractitionerOrg() {
		logger.info("Getting Practitioner Organisation Name from Practitioner Organisation Text box");
		elements.waitForElementFluently(
				PractitionerOrganisationTextBox, 10);
		return elements.getAttribute(PractitionerOrganisationTextBox, "value");
	}

	public boolean isMandatoryErrorMessageDisplayed(String value) {
		logger.info("Checking if " + value
				+ " Mandatory Error Message is Displayed");
		boolean result = false;
		elements.waitForElementFluently( ErrorMessageBox, 10);
		if (value.equals("Entry Type"))
			result = elements.isDisplayed(EntryTypeMandatoryMessage);
		else if (value.equals("Entry"))
			result = elements.isDisplayed(EntryMandatoryMessage);
		return result;
	}

	public String getMandatoryErrorMessageText(String value) {
		logger.info("Getting " + value + " Mandatory Error Message Text");
		String result = null;
		elements.waitForElementFluently( ErrorMessageBox, 10);
		if (value.equals("Entry Type"))
			result = elements.getText(EntryTypeMandatoryMessage);
		else if (value.equals("Entry"))
			result = elements.getText(EntryMandatoryMessage);
		return result;
	}

	public void selectEntryType(String value) {
		logger.info("Selecting " + value + " from Entry Type Dropdown");
		elements.waitForElementFluently( AddEntryTypeDropdown, 10);
		elements.selectDropdown(AddEntryTypeDropdown, value);
	}

	public void clickonEntryTextBox() {
		elements.waitForElementFluently( AddEntryTextbox, 10);
		elements.buttonClick(AddEntryTextbox);
	}

	public void enterEntry(String value) {
		logger.info("Providing " + value + " Entry Text box");
		elements.waitForElementFluently( AddEntryTextbox, 10);
		elements.inputValueinRichTextbox( AddEntryTextbox, value);
	}

	public void clickonCaseNoteSaveButton() {
		logger.info("Clicking on Case Note Save Button");
		elements.waitForElementFluently( CaseNotesSaveButton, 10);
		elements.buttonClick(CaseNotesSaveButton);
	}

	public void clickonCaseNoteCompleteButton() {
		logger.info("Clicking on Case Note Complete Button");
		elements.waitForElementFluently( CompleteButton, 10);
		elements.buttonClick(CompleteButton);
	}

	public void clickonViewCaseNoteCancelButton() {
		logger.info("Clicking on Case Note Cancel Button");
		elements.waitForElementFluently( ViewCaseNoteCancelButton, 10);
		elements.buttonClick(ViewCaseNoteCancelButton);
	}

	public void clickonCaseNoteCancelButton() {
		logger.info("Clicking on Case Note Cancel Button");
		elements.waitForElementFluently( CaseNotesCancelButton, 10);
		elements.buttonClick(CaseNotesCancelButton);
	}

	public boolean isCaseNoteEntryAdded() {
		logger.info("Checking if the Case Note Entry is Added");
		elements.waitForElementFluently( ConfirmationMessage, 30);
		elements.waitForElementFluently(
				srcfilterpageobject.CaseNotesEntryResultTable, 10);
		return elements.isDisplayed(AddedCaseNoteEntry);
	}

	public String getCaseNoteEntryAddedPractitioner() {
		logger.info("Getting Practitioner Name from Added Case Note Entry");
		elements.waitForElementFluently( AddedCaseNoteEntryPractitioner,
				30);
		// elements.waitForElementFluently(
		// AddedCaseNoteEntryPractitioner, 10);
		String text = elements.getText(AddedCaseNoteEntryPractitioner);
		String practitioner = text.substring(0, text.indexOf("(")).trim();
		return practitioner;
	}

	public boolean isPersonPopupFieldsDisplayed(String value) {
		logger.info("Checking if " + value + " is Displayed in Person pop up");
		boolean result = false;
		elements.waitForElementFluently( PopupDisplay, 10);
		if (value.equals("Source"))
			result = elements.isDisplayed(SourceTextBox);
		else if (value.equals("Source Org"))
			result = elements.isDisplayed(SourceOrganisationTextBox);
		else if (value.equals("Practitioner"))
			result = elements.isDisplayed(PractitionerTextBox);
		else if (value.equals("Practitioner Org"))
			result = elements.isDisplayed(PractitionerOrganisationTextBox);
		return result;
	}

	public void clickonImpactIcon() {
		logger.info("Clicking on Impact Icon");
		elements.waitForElementFluently( ImpactIcon, 10);
		elements.buttonClick(ImpactIcon);
	}

	public boolean isImpactPopupFieldsDisplayed(String value) {
		logger.info("Checking if " + value + " is Displayed in Impact pop up");
		boolean result = false;
		elements.waitForElementFluently( PopupDisplay, 10);
		if (value.equals("Positive"))
			result = elements.isDisplayed(PositiveImpactRadioButton);
		else if (value.equals("Negative"))
			result = elements.isDisplayed(NegativeImpactRadioButton);
		else if (value.equals("Neutral"))
			result = elements.isDisplayed(NeutralImpactRadioButton);
		else if (value.equals("Unknown"))
			result = elements.isDisplayed(UnknownImpactRadioButton);
		return result;
	}

	public void clickonSelectButton() {
		logger.info("Clicking on Select Button");
		elements.waitForElementFluently( SelectButton, 10);
		elements.buttonClick(SelectButton);
	}

	public void clickonViewCaseNoteButton() {
		logger.info("Clicking on View Case Note Button");
		elements.waitForElementFluently( ViewCaseNoteButton, 10);
		elements.buttonClick(ViewCaseNoteButton);
	}

	public boolean isViewCaseNoteOverlayDisplayed() {
		logger.info("Checking if View Case Note Overlay is Displayed");
		return elements.isDisplayed(ViewCaseNoteOverlay);
	}

	public boolean isViewCaseNoteFieldsEnabled(String value) {
		logger.info("Checking if " + value
				+ " is Disabled on View Case Note Overlay");
		boolean result = false;
		elements.waitForElementFluently( ViewCaseNoteOverlay, 10);
		if (value.equals("Entry Date"))
			result = elements.isEnabled(ViewEntryDateTextbox);
		else if (value.equals("Entry Type"))
			result = elements.isEnabled(ViewEntryTypeTextbox);
		else if (value.equals("Entry"))
			result = elements.isEnabled(ViewEntryTextbox);
		return result;
	}

	public boolean isViewCaseNoteFieldsDisabled() {
		logger.info("Checking if View Case Note Fields are Disabled on View Case Note Overlay");
		if (elements.getAttribute(ViewCaseNoteFields, "class")
				.equalsIgnoreCase("pure-g-r readonly"))
			return true;
		else
			return false;
	}

	public void clickonDateIcon() {
		logger.info("Clicking on Date Icon");
		elements.waitForElementFluently( ViewDateIcon, 10);
		elements.buttonClick(ViewDateIcon);
	}

	public boolean isViewDateFieldsDisplayed(String value) {
		logger.info("Checking if " + value
				+ " Date is Displayed on View Case Note Overlay");
		boolean result = false;
		elements.waitForElementFluently( PopupDisplay, 10);
		if (value.equals("Recorded"))
			result = elements.isDisplayed(ViewRecordedDate);
		else if (value.equals("Last Edited"))
			result = elements.isDisplayed(ViewLastEditedDate);
		return result;
	}

	public void clickonEditCaseNoteButton() {
		logger.info("Clicking on Edit Case Note Button");
		elements.waitForElementFluently( EditCaseNoteButton, 10);
		elements.buttonClick(EditCaseNoteButton);
	}

	public boolean isEditCaseNoteOverlayDisplayed() {
		logger.info("Checking if Edit Case Note Overlay is Displayed");
		return elements.isDisplayed(EditCaseNoteOverlay);
	}

	public void enterEditEntry(String value) {
		logger.info("Providing " + value + " Entry Text box");
		elements.waitForElementFluently( EditEntryTextbox, 10);
		elements.inputValueUsingInnerHTML( EditEntryTextbox, value);
	}

	public void selectEditEntryType(String value) {
		logger.info("Selecting " + value + " from Entry Type Dropdown");
		elements.waitForElementFluently( EditEntryTypeDropdown, 10);
		elements.selectDropdown(EditEntryTypeDropdown, value);
	}

	public boolean isEditCaseNoteFieldsEnabled(String value) {
		logger.info("Checking if " + value
				+ " is Enabled on Edit Case Note Overlay");
		boolean result = false;
		elements.waitForElementFluently( EditCaseNoteOverlay, 10);
		if (value.equals("Entry Date"))
			result = elements.isEnabled(EntryDateYearTextbox);
		else if (value.equals("Entry Type"))
			result = elements.isEnabled(EditEntryTypeTextbox);
		else if (value.equals("Entry"))
			result = elements.isEnabled(EditEntryDropdown);
		else if (value.equals("Source"))
			result = elements.isEnabled(SourceTextBox);
		else if (value.equals("Source Org"))
			result = elements.isEnabled(SourceOrganisationTextBox);
		return result;
	}

	public void clickonEditImpactLevelRadioButton(String value) {
		logger.info("Clicking on " + value + " Impact Radio Button");
		elements.waitForElementFluently( PopupDisplay, 10);
		if (value.equals("Positive"))
			elements.buttonClick(EditPositiveImpactRadioButton);
		else if (value.equals("Negative"))
			elements.buttonClick(EditNegativeImpactRadioButton);
		else if (value.equals("Neutral"))
			elements.buttonClick(EditNeutralImpactRadioButton);
		else if (value.equals("Unknown"))
			elements.buttonClick(EditUnknownImpactRadioButton);

		elements.waitForPageLoaded();
	}

	public void clickonAddImpactLevelRadioButton(String value) {
		logger.info("Clicking on " + value + " Impact Radio Button");
		elements.waitForElementFluently( PopupDisplay, 10);
		if (value.equals("Positive"))
			elements.buttonClick(PositiveImpactRadioButton);
		else if (value.equals("Negative"))
			elements.buttonClick(NegativeImpactRadioButton);
		else if (value.equals("Neutral"))
			elements.buttonClick(NeutralImpactRadioButton);
		else if (value.equals("Unknown"))
			elements.buttonClick(UnknownImpactRadioButton);
	}

	public void provideValueinDateField(String value, String text) {
		logger.info("Providing " + text + " in " + value
				+ " field of Entry Date Section");
		elements.waitForElementFluently( AddCaseNoteOverlay, 10);
		if (value.equals("Year")) {
			elements.waitForElementFluently( EntryDateYearTextbox, 10);
			elements.inputValue(EntryDateYearTextbox, text);
		} else if (value.equals("Month")) {
			elements.waitForElementFluently( EntryDateMonthDropdown, 10);
			elements.selectDropdown(EntryDateMonthDropdown, text);
		} else if (value.equals("Day")) {
			elements.waitForElementFluently( EntryDateDayDropdown, 10);
			elements.selectDropdown(EntryDateDayDropdown, text);
		} else if (value.equals("Hour")) {
			elements.waitForElementFluently( EntryDateHourDropdown, 10);
			elements.selectDropdown(EntryDateHourDropdown, text);
		} else if (value.equals("Minute")) {
			elements.waitForElementFluently( EntryDateMinuteDropdown, 10);
			elements.selectDropdown(EntryDateMinuteDropdown, text);
		}
		elements.waitForPageLoaded();
	}

	public String getEntryDatefromCaseNoteResultTable() {
		logger.info("Getting Entry Date from Case Notes Result");
		elements.waitForElementFluently( AddedCaseNoteEntryDate, 10);
		return elements.getText(AddedCaseNoteEntryDate);
	}

	public void AddCaseNoteEntry(String year, String month, String day,
			String hour, String minute, String entrytype, String entryvalue) {
		logger.info("Adding a Case Note");
		elements.waitForElementFluently( AddCaseNoteButton, 10);
		clickonAddCaseNoteButton();
		if (!year.equals(""))
			provideValueinDateField("Year", year);
		if (!month.equals(""))
			provideValueinDateField("Month", month);
		if (!day.equals(""))
			provideValueinDateField("Day", day);
		if (!hour.equals(""))
			provideValueinDateField("Hour", hour);
		if (!minute.equals(""))
			provideValueinDateField("Minute", minute);
		selectEntryType(entrytype);
		enterEntry(entryvalue);
		clickonCaseNoteSaveButton();
	}

	public boolean isEntryDateFieldsEnabled(String value) {
		logger.info("Checking if " + value
				+ " is Enabled in Entry Date Section");
		boolean result = false;
		elements.waitForElementFluently( AddCaseNoteOverlay, 10);
		elements.waitForPageLoaded();
		if (value.equals("Year")) {
			result = elements.isEnabled(EntryDateYearTextbox);
		} else if (value.equals("Month")) {
			result = elements.isEnabled(EntryDateMonthDropdown);
		} else if (value.equals("Day")) {
			result = elements.isEnabled(EntryDateDayDropdown);
		} else if (value.equals("Hour")) {
			result = elements.isEnabled(EntryDateHourDropdown);
		} else if (value.equals("Minute")) {
			result = elements.isEnabled(EntryDateMinuteDropdown);
		}
		return result;
	}

	public void clickonSelectCurrentDateLink() {
		logger.info("Clciking on Select Current Date Link");
		elements.waitForElementFluently( SelectCurrentDateLink, 10);
		elements.buttonClick(SelectCurrentDateLink);
	}

	public void clickonSelectCurrentDateTimeLink() {
		logger.info("Clciking on Select Current Date Time Link");
		elements.waitForElementFluently( SelectCurrentDateTimeLink, 10);
		elements.buttonClick(SelectCurrentDateTimeLink);
	}

	public String getEnteredDate() {
		logger.info("Getting the Date after clicking on Select Current Date");
		elements.waitForElementFluently( AddCaseNoteOverlay, 10);
		String year = elements.getText(EntryDateYearTextbox);
		String month = elements.getAttribute(EntryDateMonthDropdown, "value");
		String day = elements.getAttribute(EntryDateDayDropdown, "value");
		String date = year + month + day;
		return date;
	}

	public String getEnteredDateTime() {
		logger.info("Getting the Date Time after clicking on Select Current Date Time");
		elements.waitForElementFluently( AddCaseNoteOverlay, 10);
		String year = elements.getText(EntryDateYearTextbox);
		String month = elements.getText(EntryDateMonthDropdown);
		String day = elements.getText(EntryDateDayDropdown);
		String hour = elements.getText(EntryDateHourDropdown);
		String minute = elements.getText(EntryDateMinuteDropdown);
		String datetime = year + month + day + hour + minute;
		return datetime;
	}

	public boolean isFutureDateErrorMessageDisplayed() {
		logger.info("Checking if Future Date Error Message is Displayed");
		elements.waitForElementFluently( ErrorMessageBox, 10);
		return elements.isDisplayed(FutureDateErrorMessage);
	}

	public String getFutureDateErrorMessage() {
		logger.info("Getting Future Date Eror Message Text");
		elements.waitForElementFluently( ErrorMessageBox, 10);
		return elements.getText(FutureDateErrorMessage);
	}

	public boolean isAddedCaseNoteCorrect(String value) {
		logger.info("Checking if Added Case Note is Correct");
		boolean result = false;
		for (WebElement options : elements.getElementListWithIdentification(AddedCaseNoteEntryList) ) {
			if (value
					.equals(options.findElement(By.xpath("./td[5]")).getText())) {
				result = true;
			} else
				result = false;
		}
		return result;
	}

	public boolean isAddedCaseNoteCorrectforMultipleLines(String value) {
		logger.info("Checking if Added Case Note is Correct");
		boolean result = false;
		String text = "";
		for (int i = 0; i < 20; i++) {
			text = (value + i + " ") + text;
		}
		String entryText = text.trim();
		System.out.println(entryText);
		for (WebElement options : elements.getElementListWithIdentification(AddedCaseNoteEntryList) ) {
			System.out.println(options.findElement(By.xpath("./td[5]"))
					.getText().trim());
			if (entryText.equals(options.findElement(By.xpath("./td[5]"))
					.getText().trim())) {
				result = true;
			} else
				result = false;
		}
		return result;
	}

	public boolean isPractitionerDisplayedCorrect(String value, String value1) {
		boolean result = false;
		for (WebElement options : elements.getElementListWithIdentification(PractitionerFilterList)) {
			if ((options.getText().equals(value))
					|| (options.getText().equals(value1))) {
				result = true;
			}
		}
		return result;
	}

	public boolean isImpactPopupDisplayed() {
		return elements.isDisplayed(PopupDisplay);
	}

	public String getSelectedImpactLevelonAddForm() {
		String result = null;
		if (elements.isSelected(PositiveImpactRadioButton) == true)
			result = "Positive";
		else if (elements.isSelected(NegativeImpactRadioButton) == true)
			result = "Negative";
		else if (elements.isSelected(NeutralImpactRadioButton) == true)
			result = "Neutral";
		else if (elements.isSelected(UnknownImpactRadioButton) == true)
			result = "Unknown";
		return result;
	}

	public String getSelectedImpactLevelonViewForm() {
		String result = null;
		if (elements.isSelected(ViewPositiveImpactRadioButton) == true)
			result = "Positive";
		else if (elements.isSelected(ViewNegativeImpactRadioButton) == true)
			result = "Negative";
		else if (elements.isSelected(ViewNeutralImpactRadioButton) == true)
			result = "Neutral";
		else if (elements.isSelected(ViewUnknownImpactRadioButton) == true)
			result = "Unknown";
		return result;
	}

	public String getSelectedImpactLevelonEditForm() {
		String result = null;
		if (elements.isSelected(EditPositiveImpactRadioButton) == true)
			result = "Positive";
		else if (elements.isSelected(EditNegativeImpactRadioButton) == true)
			result = "Negative";
		else if (elements.isSelected(EditNeutralImpactRadioButton) == true)
			result = "Neutral";
		else if (elements.isSelected(EditUnknownImpactRadioButton) == true)
			result = "Unknown";
		return result;
	}

	public void enterSource(String value) {
		logger.info("Providing " + value + " Source Text box");
		elements.waitForElementFluently( SourceTextBox, 10);
		elements.inputValue(SourceTextBox, value);
	}

	public void enterSourceOrganisation(String value) {
		logger.info("Providing " + value + " Source Organisation Text box");
		elements.waitForElementFluently( SourceOrganisationTextBox, 10);
		elements.inputValue(SourceOrganisationTextBox, value);
	}

	public void enterValueinEntryTextBox(String value) {
		logger.info("Providing " + value + " in the Entry Text box");
		elements.waitForElementFluently( AddEntryTextbox, 10);
		String text = "";
		for (int i = 0; i < 20; i++) {
			text = (value + i + " ") + text;
		}
		elements.inputValueUsingInnerHTML( AddEntryTextbox, text);
		System.out.println(text);
	}

	public String getDateofRecentlyAddedCaseNote() {
		logger.info("Getting Date of Recently Added Case Note");
		elements.waitForElementFluently( LastAddedCaseNoteEntryDate, 10);
		return elements.getText(LastAddedCaseNoteEntryDate);
		// return driver.findElement(
		// By.xpath("//tr[3]/td[@data-title='Entry date']")).getText();
	}

	public String getDateTimeofRecentlyAddedCaseNote() {
		logger.info("Getting Date Time of Recently Added Case Note");
		elements.waitForElementFluently( LastAddedCaseNoteEntryDate1, 10);
		return elements.getText(LastAddedCaseNoteEntryDate1);
		// return driver.findElement(
		// By.xpath("//tr[4]/td[@data-title='Entry date']")).getText();
	}

	public String getCurrentDateTimeLess5Hours() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR, -5);
		String fiveHourBack = (new SimpleDateFormat("dd-MMM-yyyy HH:mm"))
				.format(cal.getTime());
		return fiveHourBack;
	}

	public String get5HoursLess() {
		int hour = (Calendar.getInstance()).get(Calendar.HOUR_OF_DAY);
		int time = hour - 5;
		String hr;
		if (time < 10) {
			hr = "0" + String.valueOf(time);
		} else {
			hr = String.valueOf(time);
		}
		return hr;
	}

	public boolean isConfirmationMessageDisplayed() {
		logger.info("Checking if Confirmation Message is Displayed");
		elements.waitForElementFluently( ConfirmationMessage, 10);
		return elements.isDisplayed(ConfirmationMessage);
	}

	public String verifyConfirmationMessage() {
		logger.info("Verifying Confirmation message text");
		elements.waitForElementFluently( ConfirmationMessage, 10);
		return elements.getText(ConfirmationMessage);
	}

	public String verifyUpdateConfirmationMessage() {
		logger.info("Verifying Update Confirmation message text");
		elements.waitForElementFluently( UpdateConfirmationMessage, 10);
		return elements.getText(UpdateConfirmationMessage);
	}

	public boolean isPersonConfirmationMessageDisplayed() {
		logger.info("Checking if Person Added Confirmation Message is Displayed");
		elements.waitForElementFluently( PersonConfirmationMessage, 10);
		return elements.isDisplayed(PersonConfirmationMessage);
	}

	public void waitForConfirmationMessage() {
		logger.info("Waiting for Confirmation Message");
		elements.waitForElementFluently( ConfirmationMessage, 10);
	}

	public int randomNumber() {
		int max = 100;
		int min = 1;
		Random random = new Random();
		int randomNum = random.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	public boolean isFilterFormDisplayed() {
		String attribute = elements.getAttribute(
				srcfilterpageobject.FilterByForm, "hidden");
		if (attribute.equals("hidden"))
			return true;
		else
			return false;
	}

	public void clearEntryDateYearField() {
		logger.info("Clearing value from Year section of Entry Date Field");
		elements.waitForElementFluently( EntryDateYearTextbox, 10);
		elements.clearValue(EntryDateYearTextbox);
	}

	public void waitForNoCaseNotePage() {
		logger.info("Waiting for No case note result page");
		elements.waitForElementFluently( NoCaseNotePage, 10);
	}

	public String getUKTime(String component) {
		logger.info("Getting current " + component + " of the UK Time");
		String result = null;
		Calendar calendar = new GregorianCalendar();
		calendar.setTimeZone(TimeZone.getTimeZone("Europe/London"));
		if (component.equals("Hour")) {
			SimpleDateFormat format = new SimpleDateFormat("HH");
			format.setTimeZone(TimeZone.getTimeZone("Europe/London"));
			result = format.format(GregorianCalendar.getInstance().getTime());
		} else if (component.equals("Minute")) {
			SimpleDateFormat format = new SimpleDateFormat("mm");
			format.setTimeZone(TimeZone.getTimeZone("Europe/London"));
			result = format.format(GregorianCalendar.getInstance().getTime());
		} else if (component.equals("Year")) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy");
			format.setTimeZone(TimeZone.getTimeZone("Europe/London"));
			result = format.format(GregorianCalendar.getInstance().getTime());
		} else if (component.equals("Month")) {
			SimpleDateFormat format = new SimpleDateFormat("MMM");
			format.setTimeZone(TimeZone.getTimeZone("Europe/London"));
			result = format.format(GregorianCalendar.getInstance().getTime());
		} else if (component.equals("Day")) {
			SimpleDateFormat format = new SimpleDateFormat("dd");
			format.setTimeZone(TimeZone.getTimeZone("Europe/London"));
			result = format.format(GregorianCalendar.getInstance().getTime());
		}
		return result;
	}

	public String getCurrentUKDateTime() {
		logger.info("Getting Current UK Date Time");
		SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
		format.setTimeZone(TimeZone.getTimeZone("Europe/London"));
		String UKtime = format
				.format(GregorianCalendar.getInstance().getTime());
		return UKtime;
	}
}

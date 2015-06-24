package com.uspeclipse.pageobjects.casenotes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uspeclipse.commonservices.GenericActions;
import com.uspeclipse.commonservices.MultipleBrowser;
import com.uspeclipse.pageobjects.home.Home_pageobjects;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;

public class EditCaseNotes_pageobjects {
	
	private WebDriver driver;
	
	private static  Logger logger = Logger.getLogger(EditCaseNotes_pageobjects.class);
	GenericActions elements = null;
	
	Date curDate = new Date();
	TimeZone london = TimeZone.getTimeZone("Europe/London");
	SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.UK);
	
	String SaveCaseNoteTimestamp=null;
	String CompleteCaseNoteTimestamp=null;
	
	public EditCaseNotes_pageobjects(WebDriver driver){
		this.driver = driver;
		elements = new GenericActions(driver);
	}
	

    // Button to Add Case Note
	public final By Addbutton=	By.xpath ( "//li[@id='addCaseNoteButton']//a");
	// Order By Button
	public final By OrderBybutton=	By.xpath ("//li[@id='orderby_button']/ul/li/a");
	// Re Order Button
	public final By ReOrderbutton=	By.xpath ("//li[@id='orderCaseNoteButton']/a");
	// Re Order Button
	public final By Btn_Finish=	By.xpath ("//li[@id='orderCaseNoteButton']/a");
	// Entry date Row
	public final By EntryDateRow=	By.xpath ("//div[@id='caseNoteEntryAddForm_fuzzyEventDate']");

	// Sort By Last Edited Date Button
	public final By SortByLastEditedDatebutton=	By.xpath ("//a[@class='sort-by-lastedited-date']");
	
    // Button to Save Case Note
	public final By Savebutton=	By.xpath ( "//*[contains(@class, 'yui3-button pure-button-primary')]");
	
    // Button to Save Case Note
	public final By Cancelbutton=	By.xpath ( "//button[@class='yui3-button pure-button-active']//..//button[@class='yui3-button pure-button-secondary']");

	
    // Button to Select 
	public final By Selectbutton=	By.xpath ( "//tbody[@class='pure-table-data']//a[@class='pure-menu-label']");

	
    // Button to Edit 
	public final By EditEntry=	By.xpath ( "//tbody[@class='pure-table-data']//a[contains(text(),'edit this entry')]");

	
    // Button to View 
	public final By ViewEntry=	By.xpath ( "//tbody[@class='pure-table-data']//a[contains(text(),'view this entry')]");

	
	// Button to Complete
	public final By CompleteEntry=	By.xpath ( "//tbody[@class='pure-table-data']//a[contains(text(),'complete this entry')]");

	
	// button to Delete
	public final By DeleteEntry=	By.xpath ( "//tbody[@class='pure-table-data']//a[contains(text(),'delete this entry')]");

	
	// button to Remove
	public final By RemoveEntry=	By.xpath ( "//tbody[@class='pure-table-data']//a[contains(text(),'remove this entry')]");

	
	// Practioner name
	//By.xpath ( "//tbody[@class='pure-table-data']//td[@class='pure-table-col-practitioner  pure-table-cell ']");
	//public final By PractionerColumnData=
	public final By PractionerColumnData=	By.xpath ( "//tbody[@class='pure-table-data']//td[contains(@class, 'pure-table-col-practitioner  pure-table-cell')]");

	
	//  year text box
	public final By YearTextbox=	By.xpath ( "//form[@id='caseNoteEntryAddForm']//input[@name='YEAR']");

	   
	//month drop down box
	public final By MonthDropdown=	By.xpath ( "//form[@id='caseNoteEntryAddForm']//select[@name='MONTH']");

	   
 	//  day drop down box
	public final By DayDropdown=		By.xpath ( "//form[@id='caseNoteEntryAddForm']//select[@name='DAY']");

	
	//  Complete Case Note Entry View Yes Button
	public final By btn_Yes_CompleteCaseNoteView=		By.xpath ( "//div[contains(@class,'CompleteNoteEntryView')]//button[contains(text(),'Yes')]");

	
//	Edit Forms - 
	//  year text box
	public final By EditYearTextbox=	By.xpath ( "//*[@id='fuzzyEventDateYEAR']");

	   
	//month drop down box
	public final By EditMonthDropdown=	By.xpath ( "//*[@id='fuzzyEventDateMONTH']");

	   
 	//  day drop down box
	public final By EditDayDropdown=		By.xpath ( "//*[@id='fuzzyEventDateDAY']");

	
//  Hour drop down box
	public final By EditHourDropdown=	By.xpath ( "//*[@id='fuzzyEventDateHOUR']");

	   
	//Minute drop down box
	public final By EditMinuteDropdown=	By.xpath ( "//*[@id='fuzzyEventDateMINUTE']");

	
 	//  entry type drop down box
	public final By EntryType=		By.xpath ( "//form[@id='caseNoteEntryAddForm']//select[@name='entryType']");

	
	//  Event text box
	public final By EventTextbox=	By.xpath ( "//form[@id='caseNoteEntryAddForm']//div[@id='caseNoteEntryAddForm_event']");

	
 	//  entry type drop down box
	public final By EntryTypeEdit=		By.xpath ( "//form[@id='caseNoteEntryEditForm']//select[@name='entryType']");

	
	//  Event text box
	public final By EventEditTextbox=	By.xpath ( "//form[@id='caseNoteEntryEditForm']//div[@id='caseNoteEntryEditForm_event']");

	
	// Last Edited date button
	public final By LastEdited=		By.xpath ( "//div[@class='pure-u-1 l-box']//a[starts-with(@class, 'dates pop-over')]");

	
	// Last edited date label
	public final By LastEditedLabel=	By.xpath ( "//input[@id='entryForm_editedDate']");

	
	// Practioner Text box in Perople
	public final By PractionerTextAreaText=	By.xpath ( "//select[@id='caseNoteEntryFilter_practitioner']//option[2]");

	
	// Prationer Text Box Data
	public final By PractionerTextAreaData=	By.xpath ( "//select[@id='caseNoteEntryFilter_practitioner']//option"); 

	

	public final By FilterButton=	By.xpath ( "//span[contains(text(),'Filter')]");
	
	
	public final By FilterButtonStatus=By.xpath ( "//li[@id='caseNoteEntryFilterButton']//a");
	
	
	public final By Homebutton=By.xpath ( "//a[contains(text(),'Home')]");
	
	// Errors 
	
	public final By ErrorText= By.xpath ( "//a[@class='error-key']"); 
	
	// Errors 
	
	public final By Error=By.xpath ( "//div[@class='message message-block message-error']//h4[contains(text(),'Sorry, there was a problem with the form')]");
	
	// Current Date Link
	
	public final By CurrentDate=By.xpath ( "//*[contains(@class,'currentDate small')]");
	
	// Current DateTime Link
	
	public final By CurrentDateTime=By.xpath ( "//*[contains(@class,'currentDateTime small')]");
	
	// Impact Button
	
	public final By Impactbutton=By.xpath ( "//ul[@id='popup-menu']//a[starts-with(@class, 'impact impact')]");
	
	// Positive Impact Radio button
	
	public final By PositiveImpactbutton=By.xpath ( "//*[@id='caseNoteEntryEditForm_impactPositive']");
	
	
	public final By PositiveImpactbutton_AdCaseNote=By.xpath ( "//*[@id='caseNoteEntryAddForm_impactPositive']");
	
	// Last Impact Icon
	
	public final By ImpactIconLabel=By.xpath ( "//td[@class='pure-table-col-impact  pure-table-cell ']//i[@class='icon-ok impact-positive']");
	
	// Entry value from CAse note list
	
	public final By EntryCasenote=By.xpath ( "//*[contains(@class,'pure-table-col-event truncatedRichText pure-table-cell')]");
	
	// Source Button
	
	public final By Sourcebutton=By.xpath ( "//ul[@id='popup-menu']//a[starts-with(@class, 'source-and-practitioner')]");
	
	// Source Text Box
	
	public final By SourceTextBox=By.xpath ( "//*[@id='entryForm_source']");
	
	// Source Org Text Box
	
	public final By SourceOrgTextBox=By.xpath ( "//*[@id='entryForm_sourceOrganisation']");
	
	// Soure org Table Data
	
	public final By SourceCasenote=By.xpath ( "//*[contains(@class,'pure-table-col-source  pure-table-cell')]");
	
	// Filter Warning
	
	public final By FilterWarning=By.xpath ( "//div[@id='caseNoteFilterInfo']//h4");
	
	// Edit Form Complete Warning
	
	public final By txt_CompleteWarning=By.xpath ( "//div[@class='yui3-widget-bd']//h4[contains(text(),'Completing a Case Note entry will stop any further edits')]");
	
	// Complete Case Note Form Complete Warning
	public final By txt_CompleteWarning_CompleteEntryForm=	By.xpath ( "//div[contains(@class,'CompleteNoteEntryView')]//h4[contains(text(),'Completing a Case Note entry will stop any further edits')]");


	// Case Note List First Row
	public final By FirstRow=	By.xpath ( "//tbody[@class='pure-table-data']/tr[1]");


	public final By RemoveCaseNoteEntryPopup=	By.xpath ("//div[@class = 'yui3-panel-content yui3-widget-stdmod']//h4[contains(.,'Removing a Case Note entry may result')]");

	
	public final By EditCaseNoteEntryPopup=	By.xpath ("//div[@class = 'yui3-panel-content yui3-widget-stdmod']//span[contains(.,'editing a Case Note entry')]");

	
	public final By AddCaseNoteEntryPopup=	By.xpath ("//div[@class = 'yui3-panel-content yui3-widget-stdmod']//span[contains(.,'adding a Case Note entry')]");

	
	// Case Note List Second Row
	public final By SecondRow=	By.xpath ( "//tbody[@class='pure-table-data']/tr[2]");

	
	// Entry value from CAse note list
	public final By EntryCasenotes=By.xpath ( "//*[contains(@class,'pure-table-col-event truncatedRichText pure-table-cell')]");

	
	// Delete Warning
	public final By DeleteWarning=	By.xpath ( "//div[contains(@class,'pure-alert pure-alert-block pure-alert-warning')]//h4");

		
	// Overlay
	
	public final By OverlayPresence=By.xpath ( "//div[@class='yui3-widget-bd']");
	
	// Entry Event Dates from Case note list
	
	public final By EntryEventDates=By.xpath ( "//*[contains(@class, 'pure-table-col-eventDate!calculatedDate  pure-table-sorted pure-table-cell ')]//a");
	
	
	public final By Btn_No_RemoveCaseNoteEntryPopup=By.xpath ("//div[@class = 'yui3-panel-content yui3-widget-stdmod']//button[contains(.,'No')]");
	
	
	public final By Btn_Yes_RemoveCaseNoteEntryPopup=By.xpath ("//div[@class = 'yui3-panel-content yui3-widget-stdmod']//button[contains(.,'Yes')]");
	
	
	public final By Lbl_EntryType=By.xpath ("//tbody[@class = 'pure-table-data']//td[contains(text(),'Day Care')]");
	
	
	public final By Lbl_Entry=By.xpath ("//tbody[@class = 'pure-table-data']//td[contains(text(),'Test Case Note')]");
	
	
	public final By Btn_No_DeleteCaseNoteEntryPopup=By.xpath ("//div[@class = 'yui3-panel-content yui3-widget-stdmod']//button[contains(.,'No')]");
	
	
	public final By Btn_Yes_DeleteCaseNoteEntryPopup=By.xpath ("//div[@class = 'yui3-panel-content yui3-widget-stdmod']//button[contains(.,'Yes')]");
	
	
	public final By Btn_Yes_DeleteCaseNote=By.xpath ("//div[contains(@class, 'HideCaseNoteEntryView')]//button[contains(.,'Yes')]");
	
	
	public final By Lbl_DeletedCaseNoteConfirmation=By.xpath ("//div[@id='headerMessage']//h4[contains(text(),'Case Note entry successfully deleted')]");

	
	public final By 	Chkbox_caseNoteEntryFilter_statusDeleted=By.xpath ("//div[@id='caseNoteView']//input[@id='caseNoteEntryFilter_statusDeleted']");

	
	public final By 	Img_CompletedCaseNote=By.xpath ("//i[@class='icon-state icon-state-complete']");

	
	public final By Img_DraftedCaseNote=By.xpath ("//tbody[@class='pure-table-data']//i[@class='icon-state icon-state-draft']");
	
	
	public final By Img_DeletedCaseNote=By.xpath ("//i[@class='icon-state icon-state-deleted']");
	
	
	public final By Link_Select_ForDeletedCaseNoteEntry=By.xpath ("//i[@class='icon-state icon-state-deleted']//..//..//a[@class='pure-menu-label']");
	
	
	public final By Link_ViewEntry_ForDeletedCaseNoteEntry=By.xpath ("//i[@class='icon-state icon-state-deleted']//..//..//a[contains(text(),'view this entry')]");

	
	public final By Link_DeleteEntry_ForDeletedCaseNoteEntry=By.xpath ("//i[@class='icon-state icon-state-deleted']//..//..//a[contains(text(),'delete this entry')]");
	
	
	public final By Link_EditEntry_ForDeletedCaseNoteEntry=By.xpath ("//i[@class='icon-state icon-state-deleted']//..//..//a[contains(text(),'edit this entry')]");
	
	
	public final By Link_CompleteEntry_ForDeletedCaseNoteEntry=By.xpath ("//i[@class='icon-state icon-state-deleted']//..//..//a[contains(text(),'complete this entry')]");
	
	
	public final By Link_EntryDate=By.xpath ("//td[contains(@class, 'pure-table-col-eventDate!calculatedDate')]//a");

	
	public final By CompleteButton=By.xpath ( "//button[contains(text(),'Complete')]");
	
	
	public final By btn_Save=By.xpath ( "//button[contains(text(), 'Save')]");
		
	
	public final By CompleteStatus=By.xpath ( "//td[contains(@class, 'pure-table-col-status  pure-table-cell')]//span[contains(text(),'State-complete')]");
	
	
	public final By btn_Edit_ViewCaseNote=By.xpath ( "//div[contains(@class,'ViewCaseNoteEntryView')]//button[contains(text(),'Edit')]");
	
	
	public final By btn_Cancel_CompleteCaseNote=By.xpath ( "//div[contains(@class, 'UpdateCompleteCaseNoteEntryView')]//button[contains(.,'Cancel')]");

	
	
		
	
	public String getPractionerNamefromFilterPeopleTab()
	{	
		String msg = null;
		for(WebElement element : elements.getElementListWithIdentification(PractionerTextAreaData))
		{
			logger.info("Text Area Data: "+ element.getText().trim());
			msg = msg + element.getText().trim();
		}
		return msg.toLowerCase();
	}
	
	public void Click(String ElementName) throws NoSuchElementException, InterruptedException {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("Clicking on " + ElementName);
		if (ElementName.equals("SaveCaseNote"))
			{
			elements.buttonClick(Savebutton);
			format.setTimeZone(london);
			SaveCaseNoteTimestamp = format.format(curDate);
			}
		else if (ElementName.equals("AddCaseNote"))
			{
			elements.waitForElementFluently( Addbutton, 10);
			elements.buttonClick(Addbutton);
			}
		else if(ElementName.equals("Select"))
			elements.buttonClick(Selectbutton);
		else if(ElementName.equals("SaveCase"))
			{ 
			format.setTimeZone(london);
			SaveCaseNoteTimestamp = format.format(curDate);
			elements.buttonClick(btn_Save);
			}
		else if(ElementName.equals("EditEntry"))
			elements.buttonClick(EditEntry);
		else if(ElementName.equals("RemoveEntry"))
			elements.buttonClick(RemoveEntry);
		else if(ElementName.equals("ViewEntry"))
			elements.buttonClick(ViewEntry);
		else if(ElementName.equals("PractionerTextArea"))
			elements.buttonClick(PractionerTextAreaText);
		else if(ElementName.equals("OrderBy"))
			elements.buttonClick(OrderBybutton);
		else if(ElementName.equals("SortByLastEditedDate"))
			elements.buttonClick(SortByLastEditedDatebutton);
		else if(ElementName.equals("FilterButton"))
		{
			elements.waitForElementFluently( FilterButton, 25);
			elements.buttonClick(FilterButton);
		}
			else if(ElementName.equals("Home"))
			elements.buttonClick(Homebutton);
		else if(ElementName.equals("LastEdited"))	
			{
				elements.buttonClick(LastEdited);
			}
		else if(ElementName.equals("CurrentDateLink"))
			 elements.buttonClick(CurrentDate);
		else if(ElementName.equals("CurrentDateTimeLink"))
			elements.buttonClick(CurrentDateTime);
		else if(ElementName.equals("Impact"))
		{	
			elements.buttonClick(Impactbutton);
		}
		else if(ElementName.equals("DeleteEntry"))
			elements.buttonClick(DeleteEntry);
		else if(ElementName.equals("PositiveImpact"))
			elements.buttonClick(PositiveImpactbutton);
		else if(ElementName.equals("PositiveImpactbutton_AdCaseNote"))
			elements.buttonClick(PositiveImpactbutton_AdCaseNote);
		else if(ElementName.equals("Sourcebutton"))
			elements.buttonClick(Sourcebutton);
		else if(ElementName.equals("ReOrderbutton"))
			elements.buttonClick(ReOrderbutton);
		else if (ElementName.equals("Cancel")) {
			//(new WebDriverWait( 60)).until(ExpectedConditions.elementToBeClickable(elements.getElementWithIdentification(Cancelbutton)));
			elements.waitForElementToBeClickable(Cancelbutton, 50);
			elements.buttonClick(Cancelbutton);
		}
		else if(ElementName.equals("RemoveCaseNoteEntry_No_Button"))
				elements.buttonClick(Btn_No_RemoveCaseNoteEntryPopup);
			
		else if(ElementName.equals("RemoveCaseNoteEntry_Yes_Button"))
			elements.buttonClick(Btn_Yes_RemoveCaseNoteEntryPopup);
		else if(ElementName.equals("Btn_Finish"))
			elements.buttonClick(Btn_Finish);
		else if(ElementName.equals("DeleteCaseNoteEntry_No_Button"))
			elements.buttonClick(Btn_No_DeleteCaseNoteEntryPopup);
		
		else if(ElementName.equals("DeleteCaseNoteEntry_Yes_Button"))
			elements.buttonClick(Btn_Yes_DeleteCaseNoteEntryPopup);
		else if(ElementName.equals("Btn_Yes_DeleteCaseNote"))
			elements.buttonClick(Btn_Yes_DeleteCaseNote);
		else if(ElementName.equals("CompleteCaseNoteEntry_Yes_Button"))
			elements.buttonClick(Btn_Yes_DeleteCaseNoteEntryPopup);
		else if(ElementName.equals("CompleteCaseNoteEntry_No_Button"))
			elements.buttonClick(Btn_No_DeleteCaseNoteEntryPopup);
		else if(ElementName.equals("IncludeDeletedCasenotes_Checkbox"))
			elements.buttonClick(Chkbox_caseNoteEntryFilter_statusDeleted);
		else if(ElementName.equals("SelectDeletedEntry"))
			elements.buttonClick(Link_Select_ForDeletedCaseNoteEntry);
		
		else if(ElementName.equals("DeleteEntryForDeletedRecord"))
			elements.buttonClick(Link_DeleteEntry_ForDeletedCaseNoteEntry);
		else if(ElementName.equals("EditEntryForDeletedRecord"))
			elements.buttonClick(Link_EditEntry_ForDeletedCaseNoteEntry);
		else if(ElementName.equals("CompleteEntryForDeletedRecord"))
			elements.buttonClick(Link_CompleteEntry_ForDeletedCaseNoteEntry);
		else if(ElementName.equals("ViewEntryForDeletedRecord"))
			elements.buttonClick(Link_ViewEntry_ForDeletedCaseNoteEntry);
		else if(ElementName.equals("CompleteEntry"))
			elements.buttonClick(CompleteEntry);
		else if(ElementName.equals("CompleteButton"))
			{elements.buttonClick(CompleteButton);
			format.setTimeZone(london);
			CompleteCaseNoteTimestamp = format.format(curDate);
			logger.info("CompleteCaseNoteTimestamp " + CompleteCaseNoteTimestamp);
			}
		else if(ElementName.equals("btn_Yes_CompleteCaseNoteView"))
			elements.buttonClick(btn_Yes_CompleteCaseNoteView);
		else if(ElementName.equals("btn_Edit_ViewCaseNote"))
			elements.buttonClick(btn_Edit_ViewCaseNote);
		else if(ElementName.equals("btn_Cancel_CompleteCaseNote"))
			elements.buttonClick(btn_Cancel_CompleteCaseNote);
	}
	
	public void SelectDropDown(String ElementName, String Value) {
		logger.info("Selecting "+ Value + " from Dropdown");
		if (ElementName.equals("CaseMonth"))
			elements.selectDropdown(MonthDropdown, Value);
		else if (ElementName.equals("CaseDay"))
		{	
			elements.selectDropdown(DayDropdown, Value);
		}
		else if (ElementName.equals("EntryType"))
		{
			elements.selectDropdown(EntryType, Value);
		}
		else if (ElementName.equals("EntryTypeEdit"))
		{
			elements.selectDropdown(EntryTypeEdit, Value);
		}
		else if(ElementName.equals("EditMonthDropdown"))
		{
			elements.selectDropdown(EditMonthDropdown, Value);
		}
		else if(ElementName.equals("EditHourDropdown"))
		{
			elements.selectDropdown(EditHourDropdown, Value);
		}
		else if(ElementName.equals("EditMinuteDropdown"))
		{
			elements.selectDropdown(EditMinuteDropdown, Value);
		}
		else if(ElementName.equals("EditDayDropdown"))
		{
			elements.selectDropdown(EditDayDropdown, Value);
		}
	}

	public void InputValue(String ElementName, String Value) {
		logger.info("Input "+ Value+ " to the Text Box");
		if (ElementName.equals("CaseYear"))
			elements.inputValue(YearTextbox, Value);
		else if (ElementName.equals("Event"))
		{	elements.waitForElementFluently( EventTextbox, 20);
			//elements.inputValue(EventTextbox, Value);
			elements.inputValueUsingInnerHTML( EventTextbox, Value);
		}
		else if (ElementName.equals("EventEdit"))
		{	elements.waitForElementFluently( EventEditTextbox, 20);
			//elements.inputValue(EventEditTextbox, Value);
			elements.inputValueUsingInnerHTML( EventEditTextbox, Value);
		}
		else if (ElementName.equals("EditYearTextbox"))
		{
			elements.inputValue(EditYearTextbox, Value);
		}
		else if (ElementName.equals("SourceTextBox"))
			elements.inputValue(SourceTextBox, Value);
		else if (ElementName.equals("SourceOrgTextBox"))
			elements.inputValue(SourceOrgTextBox, Value);
	}
	
	public String getPractionerName()
	{	
		elements.waitForElementFluently( PractionerColumnData, 20);
		logger.info("getPractionerName() : " + elements.getElementWithIdentification(PractionerColumnData).getText().trim().toLowerCase());
		return elements.getElementWithIdentification(PractionerColumnData).getText().trim().toLowerCase();
	}
	
	public String getLastEditedDate()
	{
		elements.waitForElementFluently( LastEditedLabel, 10);
		return elements.getElementWithIdentification(LastEditedLabel).getAttribute("value").trim();
	}
	
	public boolean CheckForElementExistence(String ElementName) throws InterruptedException {

		if (ElementName.equals("LastEdited")) {
			return elements.isElementPresent( LastEdited);
		}
		else if(ElementName.equals("ViewEntry"))
			return elements.isElementPresent( ViewEntry);
		else if(ElementName.equals("EditEntry"))
			return elements.isElementPresent( EditEntry);
		else if(ElementName.equals("CompleteEntry"))
			return elements.isElementPresent( CompleteEntry);
		else if(ElementName.equals("DeleteEntry"))
			return elements.isElementPresent( DeleteEntry);
		else if(ElementName.equals("RemoveEntry"))
			return elements.isElementPresent( RemoveEntry);
		else if(ElementName.equals("Error"))
			return elements.isElementPresent( Error);
		else if(ElementName.equals("PositiveImpact"))
			return elements.isElementPresent( ImpactIconLabel);
		else if(ElementName.equals("ImpactButton"))
			return elements.isElementPresent( Impactbutton);
		else if(ElementName.equals("CurrentDate"))
			return elements.isElementPresent( CurrentDate);
		else if(ElementName.equals("CurrentDateTime"))
			return elements.isElementPresent( CurrentDateTime);
		else if(ElementName.equals("EntryDateRow"))
			return elements.isElementPresent( EntryDateRow);
		else if(ElementName.equals("OverlayPresence"))
			return elements.isElementPresent( OverlayPresence);
		else if(ElementName.equals("RemoveCaseNoteEntryPopup"))
			return elements.isElementPresent( RemoveCaseNoteEntryPopup);
		else if(ElementName.equals("Entry"))
			return elements.isElementPresent( Lbl_Entry);
		else if(ElementName.equals("EntryType"))
			return elements.isElementPresent( Lbl_EntryType);
		else if(ElementName.equals("DeleteEntryOverlay"))
			return elements.isElementPresent( OverlayPresence);
		else if(ElementName.equals("DeleteEntryConfirmation"))
			return elements.isElementPresent( Lbl_DeletedCaseNoteConfirmation);
		
		else if(ElementName.equals("CompletedCaseNoteRecord"))
			return elements.isElementPresent( Img_CompletedCaseNote);
		else if(ElementName.equals("DraftedCaseNoteRecord"))
			return elements.isElementPresent( Img_DraftedCaseNote);
		else if(ElementName.equals("DeletedCaseNoteRecord"))
			return elements.isElementPresent( Img_DeletedCaseNote);
		else if(ElementName.equals("EditCaseNoteEntryPopup"))
			return elements.isElementPresent( EditCaseNoteEntryPopup);
		else if(ElementName.equals("AddCaseNoteEntryPopup"))
			return elements.isElementPresent( AddCaseNoteEntryPopup);
		else if(ElementName.equals("CompleteStatus"))
			return elements.isElementPresent( CompleteStatus);
		else if(ElementName.equals("PositiveImpact"))
			return elements.isElementPresent( PositiveImpactbutton);
		else if(ElementName.equals("Savebutton"))
			return elements.isElementPresent( Savebutton);
		else if(ElementName.equals("EditYearTextbox"))
			return elements.isElementPresent( EditYearTextbox);
		else if(ElementName.equals("PositiveImpactbutton_AdCaseNote"))
			return elements.isElementPresent( PositiveImpactbutton_AdCaseNote);
		else if(ElementName.equals("Impact"))
		{	
			return elements.isElementPresent( Impactbutton);
		}
		
		return false;
	}
	
	public String SaveCaseNoteTimeStamp()
	{
		return SaveCaseNoteTimestamp.trim();
	}
	public String CompleteCaseNoteTimeStamp()
	{
		return CompleteCaseNoteTimestamp.trim();
	}
	
	public String getErrorMessage() throws InterruptedException
	{
		String msg = null;
		for(WebElement error : elements.getElementListWithIdentification(ErrorText))
		{	
			msg += error.getText().trim();
		}
		
		if(CheckForElementExistence("Error"))
		{
			msg += elements.getElementWithIdentification(Error).getText().trim();
		}
		return msg;
	}
	
	public void waitFortheElement() throws InterruptedException
	{	// For a Specific Scenarios when Event Field is not visible when the Case Note is added
		Thread.sleep(7000);
	}
	
	public String getDatafromCaseNoteList(String ElementName)
	{
		if (ElementName.equals("EntryNote")) {
			return elements.getElementWithIdentification(EntryCasenote).getText().trim();
		}
		else if(ElementName.equals("SourceCasenote"))
		{
			return elements.getElementWithIdentification(SourceCasenote).getText().trim();
		}
		else if(ElementName.equals("Link_EntryDate"))
		{
			return elements.getElementWithIdentification(Link_EntryDate).getText().trim();
		}
		else
			return "";
	}

	
	public String getCaseNotesEvent(String RowName)
	{
		List<String> Events = new ArrayList<String>();
		for(WebElement event : elements.getElementListWithIdentification(EntryCasenotes))
		{
			Events.add(event.getText().trim());
		}
		if(RowName.equals("FirstRow"))
			return Events.get(0);
		else if(RowName.equals("SecondRow"))
			return Events.get(1);
		else
			return Events.get(0);
	}
	
	public String getCaseNotesEventDates(String RowName)
	{
		List<String> EventDates = new ArrayList<String>();
		for(WebElement date : elements.getElementListWithIdentification(EntryEventDates))
		{
			EventDates.add(date.getText().trim());
		}
		if(RowName.equals("FirstRow"))
			return EventDates.get(0);
		else if(RowName.equals("SecondRow"))
			return EventDates.get(1);
		else
			return EventDates.get(0);
	}
	
	public String getWarnings(String ElementName)
	{
		if(ElementName.equals("FilterWarning"))
			return elements.getElementWithIdentification(FilterWarning).getText().trim();
		else if(ElementName.equals("DeleteWarning"))
			return elements.getElementWithIdentification(DeleteWarning).getText().trim();
		else if(ElementName.equals("CompleteWarning"))
			return elements.getElementWithIdentification(txt_CompleteWarning).getText().trim();
		else if(ElementName.equals("CompleteWarning_CompleteEntryForm"))
			return elements.getElementWithIdentification(txt_CompleteWarning_CompleteEntryForm).getText().trim();
		else
			return "";
	}
	
	public void DragandDrop(String ElementName1, String ElementName2)
	{	if(ElementName1.equals("FirstRow") && ElementName2.equals("SecondRow"))
			elements.DragDrop( elements.getElementWithIdentification(FirstRow), elements.getElementWithIdentification(SecondRow));	
	}
	
	public String getStatus(String ElementName)
	{
		if(ElementName.equals("FilterButton"))
			return elements.getElementWithIdentification(FilterButtonStatus).getAttribute("aria-disabled").trim();
		else
			return null;
	}
	

	public Boolean checkNoChangeinCasenoteEntry(String EntryType, String Entry) throws InterruptedException {
		Boolean retVal = false;
		if(EntryType.equals("Day Care") && Entry.equals("Test Case Note"))
		{
			retVal = (CheckForElementExistence("Entry") && CheckForElementExistence("EntryType"));
		}
		
		return retVal;
	}


}
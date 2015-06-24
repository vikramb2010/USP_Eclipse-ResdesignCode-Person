package com.uspeclipse.pageobjects.casenotes;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.uspeclipse.commonservices.GenericActions;
import com.uspeclipse.commonservices.MultipleBrowser;
import com.uspeclipse.pageobjects.home.Home_pageobjects;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;
import com.uspeclipse.setup.Initialization;
import com.uspeclipse.setup.LoggerHelper;


public class CaseNoteRecordUncompletion_pageobject{
	
	
	private WebDriver driver;
	Home_pageobjects homepageobject = null;
	AddPerson_pageobject addpersonpageobject =null;
	Home_pageobjects Home = null;
	SourceFilter_pageobject sourcefilterpageobject = null;
	PractitionerOrganisationFilter_pageobject practitionerorganisationfilterpageobject = null;
	EditCaseNotes_pageobjects editcasenotepageobject = null;
	private static  Logger logger = Logger.getLogger(CaseNoteRecordUncompletion_pageobject.class);
	GenericActions elements =null;
	
	public CaseNoteRecordUncompletion_pageobject(WebDriver driver){
		this.driver = driver;
		this.homepageobject= PageFactory.initElements(
				 driver,Home_pageobjects.class);
		this.addpersonpageobject = PageFactory.initElements(
				 driver, AddPerson_pageobject.class);
		this.sourcefilterpageobject = PageFactory.initElements(
				 driver,SourceFilter_pageobject.class);
		this.practitionerorganisationfilterpageobject = PageFactory.initElements(
				 driver,PractitionerOrganisationFilter_pageobject.class);
		
	    this.editcasenotepageobject	=PageFactory.initElements( driver, EditCaseNotes_pageobjects.class);
		elements = new GenericActions(driver);
	}
	

	public final By PractitionerFilterSelectedIndicator=By.xpath ("//div[@id='caseNoteFilterContext']//span[contains(text(),'Practitioner')]//a[@class='removePractitioner']");
	public final By CaseNoteUncompleteButton= 	By.xpath ("//li[contains(@class,'pure-menu-can-have-children pure-menu-has-children pure-menu-open')]//ul[contains(@class,'pure-menu pure-menu-children')]//li[contains(@class,'pure-menu-item')]//a[contains(@class,'unCompleteCaseNoteEntry')]");
	
	public final By CaseNoteUncompleteMessage= 	By.xpath ("//*[@class = 'pure-alert pure-alert-block pure-alert-warning']//h4[contains(text(),'Uncompleting a Case Note entry will create a new draft entry for further editing')]");
	public final By UncompleteYesButton= 	By.xpath ("//div[contains(@class,'UnCompleteCaseNoteEntryView')]//div[contains(@class,'yui3-widget-ft')]//span[@class='yui3-widget-buttons']//button[contains(.,'Yes')][1]");
	public final By FirstImagePositionofstatusColumn=	By.cssSelector ("tr:nth-child(1)>td:nth-child(10)>i.icon-state.icon-state-draft");
	public final By SecondImagePositionofstatusColumn= 	By.cssSelector ("tr:nth-child(2)>td:nth-child(10)>i.icon-state.icon-state-deleted");
	
	public final By DraftRecordEntryDate=	By.xpath ("//tr[1]/td[4]/a");
	public final By DraftRecordEntryDateinViewEntryPanel=	By.xpath ("//*[@class = 'value eventDateValue']");
	public final By DeletedRecordEntrydate=	By.xpath ("//tr[2]/td[4]/a");
	public final By RecordedDate=		By.id ("entryForm_recordedDate");
	public final By LastEditedDate=	By.id ("entryForm_editedDate");
	public final By Recordeddatepopup=	By.xpath ("//*[@id='popup-menu']//*[@class='dates pop-over']");
	public final By SelectButtonofDeletedRecordinPosition2=	By.xpath ("//tr[2]/td[11]/span/ul/li/a");
	
	public final By SortByRecordedDate=	By.xpath ("//a[@class='sort-by-recorded-date']");
	
	public final By SortByEventDate=	By.xpath ("//a[@class='sort-by-eventdate']");
	public final By CaseNotesUncompleteCancelButton=	By.xpath ("//div[contains(@class,'UnCompleteCaseNoteEntryView')]//div[contains(@class,'yui3-widget-ft')]//span[@class='yui3-widget-buttons']//button[contains(.,'Cancel')][1]");
	public final By CaseNotesUncompleteCloseButton=	By.xpath ("//div[8]/div[1]/div[1]/span/button");
	public final By CaseNotesViewButtonatSecondPosition=	By.xpath ("//tr[2]//*[contains(text(),'view this entry')]");
	
	public final By CompleteEntryOverlayafterClickingOnCompleteButton=	By.xpath ("//*[@id ='caseNote']//*[@class='yui3-panel-content yui3-widget-stdmod']");
	public final By CompleteEntryHeaderOverlayafterClickingonCompleteButton= 	By.xpath ("//*[@id ='caseNote']//*[@class='yui3-panel-content yui3-widget-stdmod']");
	public final By CompleteEntryFooterOverlayafterClickingonCompleteButton= 	By.xpath ("//*[@id ='caseNote']//*[@class='yui3-widget-ft']");
	public final By IncludeDeletedCheckbox= 	By.xpath ("//div[@id='caseNoteView']//input[@id='caseNoteEntryFilter_statusDeleted']");
	public final By UnCompleteEntryFooterOverlayafterClickingonUnCompleteButton= 	By.xpath ("//div[8]/div[1]/div[3]");
	public final By UnCompleteEntryOverlayafterClickingonUnCompleteButton= 	By.xpath ("//div[8]/div[1]");
	public final By CancelButtonunderViewCasenoteofDraftrecord= 	By.xpath ("//div[contains(@class,'ViewCaseNoteEntryView')]//div[contains(@class,'yui3-widget-ft')]//span[@class='yui3-widget-buttons']//button[@class='yui3-button pure-button-secondary']");
	public final By CancelButtonunderViewCasenoteofDeletedrecord=	By.xpath ("//div[contains(@class,'ViewCaseNoteEntryView')]//div[contains(@class,'yui3-panel-content yui3-widget-stdmod')]//div[contains(@class,'yui3-widget-ft')]//span[@class='yui3-widget-buttons']//button[contains(.,'Cancel')][1]");
	
	
	//Methods
	
	 public String getDraftEntrydate(){
    	logger.info("Fetching the Text from Confirmation Message after saving Address");
 		elements.waitForElementFluently(DraftRecordEntryDate, 40);
 		return elements.getText(DraftRecordEntryDate);
 			}
     
	
	 public String getDeletedEntrydate(){
	    	logger.info("Fetching the Text from Confirmation Message after saving Address");
	 		elements.waitForElementFluently(DeletedRecordEntrydate, 40);
	 		return elements.getText(DeletedRecordEntrydate);
	 			}
	     
	
	 public String getDraftRecordEntrydateinViewEntryPanel(){
	    	logger.info("Fetching the Text from Confirmation Message after saving Address");
	 		elements.waitForElementFluently(DraftRecordEntryDateinViewEntryPanel, 40);
	 		return elements.getText(DraftRecordEntryDateinViewEntryPanel);
	 			}
	
	
	 public String getDraftRecordEntryRecordeddateinViewEntryPanel(){
	    	logger.info("Fetching the Text from Confirmation Message after saving Address");
	 		elements.waitForElementFluently(RecordedDate, 40);
	 		return elements.getAttribute(RecordedDate,"value");
	 			}
	
	 public String getDraftRecordEntryLastEditeddateinViewEntryPanel(){
	    	logger.info("Fetching the Text from Confirmation Message after saving Address");
	 		elements.waitForElementFluently(LastEditedDate, 40);
	 		return elements.getAttribute(LastEditedDate,"value");
	 			}
	
	 public String getDeletedRecordEntryRecordeddateinViewEntryPanel(){
	    	logger.info("Fetching the Text from Confirmation Message after saving Address");
	 		elements.waitForElementFluently(RecordedDate, 40);
	 		return elements.getAttribute(RecordedDate, "value");
	 			}
	
	 public String getDeletedRecordEntryLastEditeddateinViewEntryPanel(){
	    	logger.info("Fetching the Text from Confirmation Message after saving Address");
	 		elements.waitForElementFluently(LastEditedDate, 40);
	 		return elements.getAttribute(LastEditedDate,"value");
	 			}
	
	 public void SelectRecordedDateUnderOrderBYbutton() {
			logger.info("Clicking on Recorded pop up menu");
			elements.waitForElementFluently(
					SortByRecordedDate, 40);
			elements.buttonClick(SortByRecordedDate);
			elements.waitForPageLoaded();
		}
	
	 public void SelectEventDateUnderOrderBYbutton() {
			logger.info("Clicking on Recorded pop up menu");
			elements.waitForElementFluently(
					SortByEventDate, 40);
			elements.buttonClick(SortByEventDate);
			elements.waitForElementFluently( editcasenotepageobject.Selectbutton,40);
			elements.waitForPageLoaded();
		}
	 
	 
	
	 public void clickonSelectButtonofDeletedRecord() {
			logger.info("Clicking on Recorded pop up menu");
			elements.waitForElementFluently(
					SelectButtonofDeletedRecordinPosition2, 40);
			elements.buttonClick(SelectButtonofDeletedRecordinPosition2);
		}
	
	
	 public void clickonRecordedPopupMenu() {
			logger.info("Clicking on Recorded pop up menu");
			elements.waitForElementFluently(
					Recordeddatepopup, 40);
			elements.buttonClick(Recordeddatepopup);
		}
	

	// Methods for Case Note Uncompletion button
	
	public void clickonCaseNoteUncompleteButton() {
		logger.info("Clicking on Case Note Uncomplete Button");
		elements.waitForElementFluently( SecondImagePositionofstatusColumn, 30);
		elements.waitForElementFluently( SelectButtonofDeletedRecordinPosition2, 30);
		elements.waitForElementFluently(
				CaseNoteUncompleteButton, 40);
		elements.waitForElementFluently(homepageobject.HomeLink, 30);
		elements.waitForElementFluently(homepageobject.PersonLink, 30);
		elements.waitForElementFluently(homepageobject.CasenoteLink, 30);
		elements.buttonClick(CaseNoteUncompleteButton);
	}

	
	public String messageShownonUncompletingaCasenote() {
   	 logger.info("Fetching the Text after clicking on uncompleting a case note");
   	elements.waitForElementFluently(
			CaseNoteUncompleteMessage, 40);		
	 		return elements.getText(CaseNoteUncompleteMessage);
	}
	
	public void clickonCaseNoteUncompleteYesButton() {
		logger.info("Clicking on Case Note Uncomplete yes Button");
		elements.waitForElementFluently(
				UncompleteYesButton, 40);		
		elements.buttonClick(UncompleteYesButton);
		elements.waitForElementFluently(homepageobject.HomeLink, 30);
		elements.waitForElementFluently(homepageobject.PersonLink, 30);
		elements.waitForElementFluently(homepageobject.CasenoteLink, 30);
		elements.waitForElementFluently( editcasenotepageobject.Selectbutton,30);
		elements.waitForPageLoaded();
		
	}

	
	public void clickonCaseNoteUncompleteCancelButton() {
		logger.info("Clicking on Case Note uncomplete Cancel Button");	
		elements.waitForElementFluently(CaseNotesUncompleteCancelButton, 40);
		elements.buttonClick(CaseNotesUncompleteCancelButton);
	}
	
	
	
	public void clickonCaseNoteCancelButtonUnderviewpanelofdraftrecord() {
		logger.info("Clicking on Case Note uncomplete Cancel Button");		
		elements.waitForElementFluently( CancelButtonunderViewCasenoteofDraftrecord, 40);		
		elements.buttonClick(CancelButtonunderViewCasenoteofDraftrecord);	
	}
	
	
	public void clickonCaseNoteCancelButtonUnderviewpanelofdeletedrecord() {
		logger.info("Clicking on Case Note uncomplete Cancel Button");		
		elements.waitForElementFluently( CancelButtonunderViewCasenoteofDraftrecord, 40);
		elements.buttonClick(CancelButtonunderViewCasenoteofDraftrecord);
	}
	
	
	public void clickonCaseNoteViewButtonatSecondPosition() {
		logger.info("Clicking on Case Note uncomplete Cancel Button");		
		elements.waitForElementFluently( CaseNotesViewButtonatSecondPosition, 40);
		elements.waitForElementFluently(homepageobject.HomeLink, 30);
		elements.waitForElementFluently(homepageobject.PersonLink, 30);
		elements.waitForElementFluently(homepageobject.CasenoteLink, 30);
		elements.waitForElementFluently( editcasenotepageobject.Selectbutton,30);
		elements.buttonClick(CaseNotesViewButtonatSecondPosition);
		
	}
	
	
	public void clickonCompleteCaseNoteEntryYesButton() {
		logger.info("Clicking on Case Note entry yes Button");
		elements.waitForElementFluently( CompleteEntryHeaderOverlayafterClickingonCompleteButton, 30);
		elements.waitForElementFluently( CompleteEntryFooterOverlayafterClickingonCompleteButton, 30);		
		elements.waitForElementFluently( editcasenotepageobject.Btn_Yes_DeleteCaseNoteEntryPopup, 40);
		elements.buttonClick(editcasenotepageobject.Btn_Yes_DeleteCaseNoteEntryPopup);
		elements.waitForElementFluently( editcasenotepageobject.Selectbutton,30);
	}
	
	
	public void clickonIncludeDeletedCheckbox() {	
	elements.waitForElementFluently( IncludeDeletedCheckbox, 50);
	elements.waitForElementToBeClickable( IncludeDeletedCheckbox,  50);
	elements.buttonClick(IncludeDeletedCheckbox);

	}

	public void clickonCloseIcon() {		
		elements.waitForElementFluently( CaseNotesUncompleteCloseButton, 50);
		elements.waitForElementToBeClickable(CaseNotesUncompleteCloseButton,  50);
		elements.buttonClick(CaseNotesUncompleteCloseButton);

		}
	
	
	
}

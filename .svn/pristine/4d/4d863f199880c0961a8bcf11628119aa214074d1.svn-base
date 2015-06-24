package com.uspeclipse.testscripts.casenotes;

import java.io.IOException;
import java.util.Collection;

import jxl.read.biff.BiffException;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import com.uspeclipse.commonservices.Constants;
import com.uspeclipse.commonservices.GenericActions;
import com.uspeclipse.commonservices.MultipleBrowser;
import com.uspeclipse.dataprovider.casenotes.DateFilter_dataprovider;
import com.uspeclipse.helper.Parallelized;
import com.uspeclipse.interfaces.SmokeTest;
import com.uspeclipse.pageobjects.casenotes.*;
import com.uspeclipse.pageobjects.home.Home_pageobjects;
import com.uspeclipse.pageobjects.login.EclipseLogin_pageobject;
import com.uspeclipse.pageobjects.person.SearchPerson_pageobjects;
import com.uspeclipse.setup.Initialization;
import com.uspeclipse.setup.LoggerHelper;
import com.uspeclipse.testscripts.casenotes.AddEntryPersonScenario2_TestCaseID35635.InnerClass;

@RunWith(Parallelized.class)
@Category(SmokeTest.class)
public class UncompletingACasenoteRecordScenario1_TestCaseID33040 {
	
	private WebDriver driver = null;
	private String browsertype = "";
	private Initialization Login_To_Application=null;
	Logger logger = Logger.getLogger(UncompletingACasenoteRecordScenario1_TestCaseID33040.class);
	
	
	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}

	public UncompletingACasenoteRecordScenario1_TestCaseID33040(String type) {
		Thread.currentThread().setName(type);
		driver = (new MultipleBrowser()).getBrowserDriver(type, this.getClass()
				.getSimpleName());
		browsertype = type.toLowerCase();

	}

	@Before
	public void setUp() throws Throwable {
		Login_To_Application = new Initialization();
		Login_To_Application.Start(browsertype, driver);
	}

	@After
	public void finished() {
		logger.info("End of test");
		logger.info("closing and exiting browser");
		driver.close();
		driver.quit();
	}

	//@RunWith(DataProviderRunner.class)
	public static class InnerClass {
		static WebDriver driver = null;
		static Logger logger = null;
	
	 /* Test Case for ID 33040(Scenario 1) - This test case tests that it is possible to un-complete a Case Note record and then re-order the case note records and ensure that the un-completed 
	  * record is shown in the correct location in the results table */
	
	@Test
	
	public void UncompletingACasenoteRecordScenario1_Test()
			throws IOException,
			NoSuchMethodException, SecurityException, InterruptedException, BiffException, InvalidFormatException {
	
		GenericActions elements = new GenericActions(driver);
		SoftAssertions soft = new SoftAssertions();
		//Page objects are Initialized here 	    	
    	
    	Home_pageobjects homepageobject = PageFactory.initElements(driver,
				Home_pageobjects.class);
		SearchPerson_pageobjects searchpageobject = PageFactory.initElements(
				driver, SearchPerson_pageobjects.class);
		SourceFilter_pageobject srcfilterpageobject = PageFactory.initElements(
				driver, SourceFilter_pageobject.class);
		PractitionerOrganisationFilter_pageobject practitionerorganisationfilterpageobject = PageFactory.initElements(
				driver,PractitionerOrganisationFilter_pageobject.class );

        PractitionerFilter_pageobject practitionerfilterpageobject = PageFactory.initElements(driver,
				PractitionerFilter_pageobject.class);
        EditCaseNotes_pageobjects editcasenotepageobject = PageFactory.initElements(driver, EditCaseNotes_pageobjects.class);
    	
        AddEntryPerson_pageobject addentrypageobject = PageFactory
				.initElements(driver, AddEntryPerson_pageobject.class);
        
        CaseNoteRecordUncompletion_pageobject casenoteuncompletionpageobject =  PageFactory
				.initElements(driver, CaseNoteRecordUncompletion_pageobject.class);
        
        EclipseLogin_pageobject eclipse_pageobject = PageFactory.initElements(
				driver, EclipseLogin_pageobject.class);
        
        
        
		//Step 1 : Logging in as Manager
		logger.info("Logging in as manager");	
        eclipse_pageobject.LoginAgainBySwitchingRole("manager");
		
		
		//Step 2:	Select a client from either the 'Your recently accessed records' list or the 'Your case load' list or search for a client from the quick person search at the top of the screen
		logger.info("Step 2 - Select a client from either the 'Your recently accessed records' list or the 'Your case load' list or search for a client from the quick person search at the top of the screen");
		searchpageobject.enterSearchText("Mark Henry");
		homepageobject.clickonAutoSuggestioninSearch();
        
        
		//Step 3 : Click on CasenoteLink
		logger.info("Step 3 - Click on Case Notes Menu item");
		homepageobject.clickonCasenoteLink();
		
		// Step 4 : User checks the Include deleted checkbox
		logger.info("Step 4 - User checks the Include deleted checkbox");
		editcasenotepageobject.Click("IncludeDeletedCasenotes_Checkbox");

	    //Step 5 : User selects Un-complete this entry for a completed case note record
		logger.info("Step 5 - User selects Un-complete this entry for a completed case note record");
		addentrypageobject.clickonAddCaseNoteButton();
		addentrypageobject.clickonSelectCurrentDateLink();
		addentrypageobject.selectEntryType("Day Care");
		addentrypageobject.enterEntry("Test Case Note");
		
		addentrypageobject.clickonCaseNoteCompleteButton();		
		casenoteuncompletionpageobject.clickonCompleteCaseNoteEntryYesButton();
		//elements.waitForElementFluently(driver, locator, seconds);
		editcasenotepageobject.Click("Select");
		casenoteuncompletionpageobject.clickonCaseNoteUncompleteButton();		
		soft.assertThat(casenoteuncompletionpageobject.messageShownonUncompletingaCasenote().contains("Uncompleting a Case Note entry will create a new draft entry for further editing and will mark the current completed entry as deleted. Are you sure you want to uncomplete this entry?")).isTrue();
		
		
		 //Step 6 : Click on cancel Button 
		logger.info("Step 6 - Click on cancel Button");
	 
		driver.navigate().refresh();
	  
	    if ((Initialization.browserName.equals("chrome"))||(Initialization.browserName.equals("ios-ipad"))){
	    Thread.sleep(60000);	    	
	    }
	
	     
	     //Step 7 : User selects Un-complete this entry for a completed case note record
	     logger.info("Step 7 - User selects Un-complete this entry for a completed case note record");
	     editcasenotepageobject.Click("IncludeDeletedCasenotes_Checkbox");
	     editcasenotepageobject.Click("Select");
		 casenoteuncompletionpageobject.clickonCaseNoteUncompleteButton();
		
		
		//Step 8 : Click on yes button
		 logger.info("Step 8 - Click on yes button");
		 casenoteuncompletionpageobject.clickonCaseNoteUncompleteYesButton();
		
		String Draftstatus =  elements.getElementWithIdentification(casenoteuncompletionpageobject.FirstImagePositionofstatusColumn).getAttribute("title");
		String Deletedstatus =  elements.getElementWithIdentification(casenoteuncompletionpageobject.SecondImagePositionofstatusColumn).getAttribute("title");
		soft.assertThat(Draftstatus.contains("Draft")).as("Draft Record is displayed above the Deleted Record").isTrue();
		soft.assertThat(Deletedstatus.contains("Deleted")).as("Deleted Record is displayed below the Draft Record ").isTrue();
		
		
		//Step 9 : selects the newly created draft record and presses View this entry
		logger.info("Step 9 - selects the newly created draft record and presses View this entry");
		String EntryDateofDraftrecord = casenoteuncompletionpageobject.getDraftEntrydate();
		String EntryDateofDeletedrecord	= casenoteuncompletionpageobject.getDeletedEntrydate();
	
		editcasenotepageobject.Click("Select");
		editcasenotepageobject.Click("ViewEntry");
	
		String EntryDateofDraftrecordinViewPanel = casenoteuncompletionpageobject.getDraftRecordEntrydateinViewEntryPanel();
		casenoteuncompletionpageobject.clickonRecordedPopupMenu();
		
		String LasteditedDateofDraftRecord = casenoteuncompletionpageobject.getDraftRecordEntryLastEditeddateinViewEntryPanel();
		String RecordedDateofDraftRecord = 	casenoteuncompletionpageobject.getDraftRecordEntryRecordeddateinViewEntryPanel();	
		
		addentrypageobject.clickonViewCaseNoteCancelButton();
		
		casenoteuncompletionpageobject.clickonSelectButtonofDeletedRecord();
		casenoteuncompletionpageobject.clickonCaseNoteViewButtonatSecondPosition();
		casenoteuncompletionpageobject.clickonRecordedPopupMenu();
		
		String LasteditedDateofDeletedRecord = casenoteuncompletionpageobject.getDeletedRecordEntryLastEditeddateinViewEntryPanel();
		String RecordedDateofDeletedRecord = casenoteuncompletionpageobject.getDeletedRecordEntryRecordeddateinViewEntryPanel();	
		logger.info("Recorded date of deleted record" + RecordedDateofDeletedRecord);
		logger.info("Recorded date of draft record" + RecordedDateofDraftRecord);
		addentrypageobject.clickonViewCaseNoteCancelButton();
		
		soft.assertThat(EntryDateofDraftrecordinViewPanel.contains(EntryDateofDeletedrecord)).as("Draft entry date record should have the same entry date as the deleted record").isTrue();
		soft.assertThat(RecordedDateofDraftRecord.equals(RecordedDateofDeletedRecord)).as(" Recorded date of the draft record should be different to the recorded date of the deleted record").isFalse();
		soft.assertThat(LasteditedDateofDraftRecord.contains(LasteditedDateofDraftRecord)).as("Last edited date of the draft record should be the same as the last edited date of the deleted recordd").isTrue();
		
		
		//Step 11 : Click on Order By button and selects recorded date
		logger.info("Step 11 - Click on Order By button and selects recorded date");
		editcasenotepageobject.Click("OrderBy");
		
		casenoteuncompletionpageobject.SelectRecordedDateUnderOrderBYbutton();
		soft.assertThat(Draftstatus.contains("Draft")).as("Draft record is displayed in proper location on selection of recorded date under order by button").isTrue();
		soft.assertThat(Deletedstatus.contains("Deleted")).as("Deleted record is displayed in proper location on selection of recorded date under order by button").isTrue();
		
		
		//Step 12 : clicks on Order By button and selects last edited date
		logger.info("Step 12 - clicks on Order By button and selects last edited date");
		editcasenotepageobject.Click("OrderBy");
		editcasenotepageobject.Click("SortByLastEditedDate");
		soft.assertThat(LasteditedDateofDraftRecord.contains(LasteditedDateofDraftRecord)).as("Last edited date of the draft record should be the same as the last edited date of the deleted recordd").isTrue();
		
		
		//Step 13 : clicks on Order By button and selects event date (default).
		logger.info("Step 13 - clicks on Order By button and selects event date (default)");
		editcasenotepageobject.Click("OrderBy");
		casenoteuncompletionpageobject.SelectEventDateUnderOrderBYbutton();
		
		soft.assertThat(Draftstatus.contains("Draft")).as("Draft record is displayed in proper location on selection of event date under order by button").isTrue();
		soft.assertThat(Deletedstatus.contains("Deleted")).as("Deleted record is displayed in proper location on selection of event date under order by button").isTrue();
		
		//Step 14 :clicks on Re-order
		logger.info("Step 14 - clicks on Re-order");
		editcasenotepageobject.Click("ReOrderbutton");	
		String Warning = editcasenotepageobject.getWarnings("FilterWarning");
		soft.assertThat(Warning.contains("Filters are disabled while re-ordering. Group Case Note entries are not included")).as("Warning Message : Fiter is not Avaliable").isTrue();
		
		
		//Step 15 : User clicks on Finish
		logger.info("Step 14 - clicks on Finish");
		editcasenotepageobject.Click("Btn_Finish");
		soft.assertThat(editcasenotepageobject.getStatus("FilterButton").equalsIgnoreCase("false")).as("Filter Button is Enabled").isTrue();
		
		  soft.assertAll();
	}
}
	
	@Test
	public void UncompletingACasenoteRecordScenario1_Test() throws Exception {
		logger.info("Starting inner class execution");
		InnerClass.driver = this.driver;
		InnerClass.logger = this.logger;
		Result runResult = JUnitCore.runClasses(InnerClass.class);
		Login_To_Application.CaptureResults(runResult);
	}
}

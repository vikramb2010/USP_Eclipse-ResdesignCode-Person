package com.uspeclipse.testscripts.casenotes;

import java.util.Collection;

import org.apache.log4j.Logger;
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
import com.uspeclipse.dataprovider.casenotes.EditCaseNote_dataprovider;
import com.uspeclipse.helper.Parallelized;
import com.uspeclipse.interfaces.SmokeTest;
import com.uspeclipse.pageobjects.casenotes.AddEntryPerson_pageobject;
import com.uspeclipse.pageobjects.casenotes.EditCaseNotes_pageobjects;
import com.uspeclipse.pageobjects.home.Home_pageobjects;
import com.uspeclipse.pageobjects.login.EclipseLogin_pageobject;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;
import com.uspeclipse.pageobjects.person.SearchPerson_pageobjects;
import com.uspeclipse.setup.Initialization;


@RunWith(Parallelized.class)
@Category(SmokeTest.class)
public class CaseNoteCompete_TestCaseID33035 {

	private WebDriver driver = null;
	private String browsertype = "";
	private Initialization Login_To_Application=null;
	Logger logger = Logger.getLogger(CaseNoteCompete_TestCaseID33035.class);

	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}

	public CaseNoteCompete_TestCaseID33035(String type) {
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
	
	@RunWith(DataProviderRunner.class)
	public static class InnerClass {
		static WebDriver driver = null;
		static Logger logger = null;

		@Test
		@UseDataProvider(location = EditCaseNote_dataprovider.class, value = "EditCase")
		public void EditCaseNote(String title, String forename,String middlename, String surname, String byear, String bmonth, String bday, String ethnicity,
				String caseyear, String casemonth, String caseday, String entrytype, String event, String entrytypeupdate1, String entrytypeupdate2, String entries, String source, String sourceorg) throws Exception
		{
			SoftAssertions soft = new SoftAssertions();
			GenericActions elements = new GenericActions(driver);
			Home_pageobjects homepageobject = PageFactory.initElements(driver,Home_pageobjects.class);
			AddPerson_pageobject addpersonpageobject = PageFactory.initElements(driver, AddPerson_pageobject.class);
			SearchPerson_pageobjects searchpersonpageobject = PageFactory.initElements(driver, 	SearchPerson_pageobjects.class);
			EditCaseNotes_pageobjects editcasenotepageobject = PageFactory.initElements(driver, EditCaseNotes_pageobjects.class);
			EclipseLogin_pageobject eclipse_pageobject = PageFactory.initElements(driver, EclipseLogin_pageobject.class);
			
			logger.info("Step 1-2 - Select a client from either the Your recently accessed records list or the Your case load list or search for a client from the quick person search at the top of the screen User selects Case Notes from the Menu.");
			addpersonpageobject.AddNewPerson("client", title, forename, middlename, surname, byear, bmonth, bday, "Male", ethnicity);
			String personid = addpersonpageobject.getPersonID();
			elements.waitForPageLoaded();
			searchpersonpageobject.enterSearchText(personid);
			//searchpersonpageobject.enterSearchText("PER3595");
			
			logger.info("Step 1-3 - Click on Case Notes Menu item");
			homepageobject.clickonCasenoteLink();
			elements.waitForPageLoaded();
			
	    	logger.info("Step 1-4 - User clicks on +add button");
			logger.info("Adding a Case Note");
			editcasenotepageobject.Click("AddCaseNote");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("AddCaseNoteEntryPopup")).as("Add Overlay is Present-1").isTrue();
			
			logger.info("Step 1-5 -User clicks on the Select current date and time link, User enters details in the Entry field, User selects an Entry Type, User clciks on 'Person' and '?' icon at the bottom of the overlay");
			editcasenotepageobject.Click("CurrentDateTimeLink");
			editcasenotepageobject.SelectDropDown("EntryType", entrytype);
			editcasenotepageobject.InputValue("Event", event);
			editcasenotepageobject.Click("Sourcebutton");
			editcasenotepageobject.InputValue("SourceTextBox", source);
			editcasenotepageobject.InputValue("SourceOrgTextBox", sourceorg);
			editcasenotepageobject.Click("Impact");
			editcasenotepageobject.Click("PositiveImpactbutton_AdCaseNote");
			
			logger.info("Step 1-6 - User presses the complete button");
			editcasenotepageobject.Click("CompleteButton");
			logger.info("Complete Warning Message: " + editcasenotepageobject.getWarnings("CompleteWarning"));
			soft.assertThat(editcasenotepageobject.getWarnings("CompleteWarning").equals("Completing a Case Note entry will stop any further edits to the Case Note entry field. Are you sure you want to complete this entry?")).as("Complete Warning Message should be displayed").isTrue();
			
			logger.info("Step 1-7 - User presses no");
			editcasenotepageobject.Click("CompleteCaseNoteEntry_No_Button");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("AddCaseNoteEntryPopup")).as("Add Overlay is Present-2").isTrue();
			
			logger.info("Step 1-8 - User presses cancel button");
			editcasenotepageobject.Click("Cancel");
			
			logger.info("Step 1-9 - User clicks on +add button");
			editcasenotepageobject.Click("AddCaseNote");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("AddCaseNoteEntryPopup")).as("Add Overlay is Present-3").isTrue();
			
			logger.info("Step 1-10- User clicks on the Select current date and time link, User enters details in the Entry field, User selects an Entry Type, User clciks on 'Person' and '?' icon at the bottom of the overlay");
			editcasenotepageobject.Click("CurrentDateTimeLink");
			editcasenotepageobject.SelectDropDown("EntryType", entrytype);
			editcasenotepageobject.InputValue("Event", event);
			editcasenotepageobject.Click("Sourcebutton");
			editcasenotepageobject.InputValue("SourceTextBox", source);
			editcasenotepageobject.InputValue("SourceOrgTextBox", sourceorg);
			editcasenotepageobject.Click("Impact");
			editcasenotepageobject.Click("PositiveImpactbutton_AdCaseNote");
			
			logger.info("Step 1-11 - User presses the complete button");
			editcasenotepageobject.Click("CompleteButton");
			logger.info("Complete Warning Message: " + editcasenotepageobject.getWarnings("CompleteWarning"));
			soft.assertThat(editcasenotepageobject.getWarnings("CompleteWarning").equals("Completing a Case Note entry will stop any further edits to the Case Note entry field. Are you sure you want to complete this entry?")).as("Complete Warning Message should be displayed").isTrue();

			logger.info("Step 1-12 - User presses yes");
			editcasenotepageobject.Click("CompleteCaseNoteEntry_Yes_Button");
			
			String ErrorMsg2 = editcasenotepageobject.getErrorMessage();
			if(ErrorMsg2 != null)
			{
				editcasenotepageobject.SelectDropDown("CaseMonth", casemonth);
				editcasenotepageobject.Click("CompleteButton");
				editcasenotepageobject.Click("CompleteCaseNoteEntry_Yes_Button");
			}
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("CompleteStatus")).as("Complete Status should be present").isTrue();
			logger.info("Deleting this entry");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("DeleteEntry");
			editcasenotepageobject.Click("Btn_Yes_DeleteCaseNote");
			elements.waitForPageLoaded();
		
			logger.info("Creating a Draft Case Note");
			editcasenotepageobject.Click("AddCaseNote");
			editcasenotepageobject.InputValue("CaseYear", caseyear);
			editcasenotepageobject.SelectDropDown("CaseMonth", casemonth);
			editcasenotepageobject.SelectDropDown("CaseDay", caseday);
			editcasenotepageobject.SelectDropDown("EntryType", entrytype);
			editcasenotepageobject.InputValue("Event", event);
			editcasenotepageobject.waitFortheElement();
			editcasenotepageobject.Click("SaveCase");
			elements.waitForPageLoaded();
			
			logger.info("Step 1-13 - User has a draft case note, User clicks on Edit this entry from the Select menu");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("EditEntry");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("EditCaseNoteEntryPopup")).as("Edit Overlay is Present-1").isTrue();
			
			logger.info("Step 1-14 - User edits the text in the Entry field");
			editcasenotepageobject.SelectDropDown("EntryTypeEdit", entrytypeupdate1);
			editcasenotepageobject.InputValue("EventEdit", entrytypeupdate2);
			
			logger.info("Step 1-15 - User presses the complete button");
			editcasenotepageobject.Click("CompleteButton");
			logger.info("Complete Warning Message: " + editcasenotepageobject.getWarnings("CompleteWarning"));
			soft.assertThat(editcasenotepageobject.getWarnings("CompleteWarning").equals("Completing a Case Note entry will stop any further edits to the Case Note entry field. Are you sure you want to complete this entry?")).as("Complete Warning Message should be displayed").isTrue();

			logger.info("Step 1-16 - User presses no");
			editcasenotepageobject.Click("CompleteCaseNoteEntry_No_Button");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("EditCaseNoteEntryPopup")).as("Edit Overlay is Present-2").isTrue();
			
			logger.info("Step 1-17 - User presses cancel");
			editcasenotepageobject.Click("Cancel");
			
			logger.info("Deleting this entry");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("DeleteEntry");
			editcasenotepageobject.Click("Btn_Yes_DeleteCaseNote");
			elements.waitForPageLoaded();
			
			logger.info("Creating a Draft Case Note");
			editcasenotepageobject.Click("AddCaseNote");
			editcasenotepageobject.InputValue("CaseYear", caseyear);
			editcasenotepageobject.SelectDropDown("CaseMonth", casemonth);
			editcasenotepageobject.SelectDropDown("CaseDay", caseday);
			editcasenotepageobject.SelectDropDown("EntryType", entrytype);
			editcasenotepageobject.InputValue("Event", event);
			editcasenotepageobject.waitFortheElement();
			editcasenotepageobject.Click("SaveCase");
			elements.waitForPageLoaded();
			
			logger.info("Step 1-18 - User has a draft case note, User clicks on Edit this entry from the Select menu");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("EditEntry");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("EditCaseNoteEntryPopup")).as("Edit Overlay is Present-4").isTrue();
	
			logger.info("Step 1-19 - User edits the text in the Entry field");
			editcasenotepageobject.SelectDropDown("EntryTypeEdit", entrytypeupdate1);
			editcasenotepageobject.InputValue("EventEdit", entrytypeupdate1);
			
			logger.info("Step 1-20 - User presses the complete button");
			editcasenotepageobject.Click("CompleteButton");
			logger.info("Complete Warning Message: " + editcasenotepageobject.getWarnings("CompleteWarning"));
			soft.assertThat(editcasenotepageobject.getWarnings("CompleteWarning").equals("Completing a Case Note entry will stop any further edits to the Case Note entry field. Are you sure you want to complete this entry?")).as("Complete Warning Message should be displayed").isTrue();

			logger.info("Step 1-21 - User presses yes");
			editcasenotepageobject.Click("CompleteCaseNoteEntry_Yes_Button");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("CompleteStatus")).as("Complete Status should be present").isTrue();
			
			String EntryCaseData = editcasenotepageobject.getDatafromCaseNoteList("EntryNote");
			logger.info("EntryCaseData: " + EntryCaseData);
			logger.info("Entries :" + entrytypeupdate1);
			soft.assertThat(EntryCaseData.trim().equals(entrytypeupdate1)).as("Validating Entries in the Case note list").isTrue();
			
			logger.info("Deleting this entry");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("DeleteEntry");
			editcasenotepageobject.Click("Btn_Yes_DeleteCaseNote");
			elements.waitForPageLoaded();
			
			logger.info("Creating a Draft Case Note");
			editcasenotepageobject.Click("AddCaseNote");
			editcasenotepageobject.InputValue("CaseYear", caseyear);
			editcasenotepageobject.SelectDropDown("CaseMonth", casemonth);
			editcasenotepageobject.SelectDropDown("CaseDay", caseday);
			editcasenotepageobject.SelectDropDown("EntryType", entrytype);
			editcasenotepageobject.InputValue("Event", event);
			editcasenotepageobject.waitFortheElement();
			editcasenotepageobject.Click("SaveCase");
			elements.waitForPageLoaded();
			
			logger.info("Step 1-22 - User has a draft case note, User clicks on complete this entry from the Select menu");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("CompleteEntry");
			soft.assertThat(editcasenotepageobject.getWarnings("CompleteWarning_CompleteEntryForm").equals("Completing a Case Note entry will stop any further edits to the Case Note entry field. Are you sure you want to complete this entry?")).as("Complete Warning Message should be displayed").isTrue();
			
			logger.info("Step 1-23 - User presses yes");
			editcasenotepageobject.Click("btn_Yes_CompleteCaseNoteView");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("CompleteStatus")).as("Complete Status should be present").isTrue();
			
			logger.info("Step 1-24 - User has a completed case note, User clicks on Edit this entry from the Select menu");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("EditEntry");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("EditCaseNoteEntryPopup")).as("Edit Overlay is Present-5").isTrue();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("EditYearTextbox")).as("Year Text Box is Present").isTrue();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("EntryTypeEdit")).as("Entry Type should not be present").isFalse();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("EventEdit")).as("Event Text box should not be present").isFalse();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("Impact")).as("Impact is Active-1").isTrue();
			//editcasenotepageobject.Click("Impact");
			//soft.assertThat(editcasenotepageobject.CheckForElementExistence("PositiveImpactbutton_AdCaseNote")).as("PositiveImpact is Present-1").isTrue();
			
			logger.info("Step 1-25- User presses cancel");
			editcasenotepageobject.Click("btn_Cancel_CompleteCaseNote");
			
			logger.info("Step 1-26 - User has a completed case note, User clicks on view this entry from the Select menu");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("ViewEntry");
			
			logger.info("Step 1-27 - User presses the edit button");
			editcasenotepageobject.Click("btn_Edit_ViewCaseNote");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("EditCaseNoteEntryPopup")).as("Edit Overlay is Present-5").isTrue();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("EditYearTextbox")).as("Year Text Box is Present").isTrue();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("EntryTypeEdit")).as("Entry Type should not be present").isFalse();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("EventEdit")).as("Event Text box should not be present").isFalse();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("Impact")).as("Impact is Active-2").isTrue();
			//editcasenotepageobject.Click("Impact");
			//soft.assertThat(editcasenotepageobject.CheckForElementExistence("PositiveImpactbutton_AdCaseNote")).as("PositiveImpact is Present-2").isTrue();
			
			logger.info("Step 1-28- User presses cancel");
			editcasenotepageobject.Click("btn_Cancel_CompleteCaseNote");
			
			logger.info("Step 1-29 - Click on Logout");
			editcasenotepageobject.Click("Home");
			eclipse_pageobject.EclipseLogout();
			
			soft.assertAll();

		}
	}

	@Test
	public void CaseNoteCompete_TestCaseID33035_Test() throws Exception {
		logger.info("Starting inner class execution");
		InnerClass.driver = this.driver;
		InnerClass.logger = this.logger;
		Result runResult = JUnitCore.runClasses(InnerClass.class);
		Login_To_Application.CaptureResults(runResult);
	}


}

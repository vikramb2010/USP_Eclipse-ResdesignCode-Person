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
import com.uspeclipse.dataprovider.casenotes.DeleteCaseNote_dataprovider;
import com.uspeclipse.dataprovider.person.AddNewPerson_dataprovider;
import com.uspeclipse.helper.Parallelized;
import com.uspeclipse.interfaces.SmokeTest;
import com.uspeclipse.pageobjects.casenotes.AddEntryPerson_pageobject;
import com.uspeclipse.pageobjects.casenotes.EditCaseNotes_pageobjects;
import com.uspeclipse.pageobjects.casenotes.SourceFilter_pageobject;
import com.uspeclipse.pageobjects.home.Home_pageobjects;
import com.uspeclipse.pageobjects.login.EclipseLogin_pageobject;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;
import com.uspeclipse.pageobjects.person.EditPersonRecord_pageobject;
import com.uspeclipse.pageobjects.person.SearchPerson_pageobjects;
import com.uspeclipse.setup.Initialization;
import com.uspeclipse.setup.LoggerHelper;
import com.uspeclipse.testscripts.casenotes.DeletedFilter_TestCaseID32976.InnerClass;


@RunWith(Parallelized.class)
@Category(SmokeTest.class)
public class DeleteEntryPersonScenario1_TestCaseID33051 {
	private WebDriver driver = null;
	private String browsertype = "";
	private Initialization Login_To_Application=null;
	Logger logger = Logger.getLogger(DeleteEntryPersonScenario1_TestCaseID33051.class);

	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}

	public DeleteEntryPersonScenario1_TestCaseID33051(String type) {
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

		/* Test Case for ID 35650(Scenario 1) - This test is to demonstrate that as a user who is a Care Professional I wish to be able to apply a set of date filters to reduce the number of entries shown in the 
		  * Case Note Record  to only those on the selected dates. */
		
		@Test
		@UseDataProvider(location = DeleteCaseNote_dataprovider.class, value = "DeleteCaseNote")
		public void DeleteEntryPersonScenario1_Test(String title, String forename,
				String middlename, String surname, String byear, String bmonth,
				String bday, String ethnicity) throws IOException,
				NoSuchMethodException, SecurityException, InterruptedException, BiffException, InvalidFormatException {

			Home_pageobjects homepageobject = PageFactory.initElements(driver,
					Home_pageobjects.class);
			SearchPerson_pageobjects searchpageobject = PageFactory.initElements(
					driver, SearchPerson_pageobjects.class);
			SourceFilter_pageobject srcfilterpageobject = PageFactory.initElements(
					driver, SourceFilter_pageobject.class);
			AddEntryPerson_pageobject addentrypageobject = PageFactory
					.initElements(driver, AddEntryPerson_pageobject.class);
			AddPerson_pageobject addpersonpageobject = PageFactory.initElements(
					driver, AddPerson_pageobject.class);
			EditCaseNotes_pageobjects editcasenotepageobject = PageFactory.initElements(driver, EditCaseNotes_pageobjects.class);
			EclipseLogin_pageobject login = PageFactory.initElements(driver, EclipseLogin_pageobject.class);

			GenericActions elements = new GenericActions(driver);
			SoftAssertions soft = new SoftAssertions();
			
			login.LoginAgainBySwitchingRole("manager");
			
			addpersonpageobject.AddNewPerson("client", title, forename, middlename,
					surname, byear, bmonth, bday, "Male", ethnicity);
			String personid = addpersonpageobject.getPersonID();

			logger.info("Step 2 - Select a client from either the 'Your recently accessed records' list or the 'Your case load' list or search for a client from the quick person search at the top of the screen");
			searchpageobject.enterSearchText(personid);
			String personID = homepageobject.getPersonIDfromAutoSuggestion();
			homepageobject.clickonAutoSuggestioninSearch();
			soft.assertThat(personid)
					.as("Page Opened for Person is same as the Person Selected from AutoSuggestion")
					.isEqualTo(personID);

			logger.info("Step 2 - Click on Case Notes Menu item  - Case Note screen is displayed"
					+ " showing Case Note records for subject. The tabular display beneath the Person Id is laid out as:"
					+ "- ENTRY DATE"
					+ "- ENTRY"
					+ "- ENTRY TYPE"
					+ "- IMPACT"
					+ " - SOURCE- PRACTITIONER- STATUS- ACTIONS");
			homepageobject.clickonCasenoteLink();

			soft.assertThat(
					srcfilterpageobject.isColumnHeaderDisplayed("Entry Date"))
					.as("Entry Date Column Table header should be Displayed")
					.isTrue();
			soft.assertThat(srcfilterpageobject.isColumnHeaderDisplayed("Entry"))
					.as("Entry Column Table header should be Displayed").isTrue();
			soft.assertThat(
					srcfilterpageobject.isColumnHeaderDisplayed("Entry Type"))
					.as("Entry Type Column Table header should be Displayed")
					.isTrue();
			soft.assertThat(srcfilterpageobject.isColumnHeaderDisplayed("Impact"))
					.as("Impact Column Table header should be Displayed").isTrue();
			soft.assertThat(srcfilterpageobject.isColumnHeaderDisplayed("Source"))
					.as("Source Column Table header should be Displayed").isTrue();
			soft.assertThat(
					srcfilterpageobject.isColumnHeaderDisplayed("Practitioner"))
					.as("Practitioner Column Table header should be Displayed")
					.isTrue();
			soft.assertThat(srcfilterpageobject.isColumnHeaderDisplayed("Status"))
					.as("Status Column Table header should be Displayed").isTrue();
			soft.assertThat(srcfilterpageobject.isColumnHeaderDisplayed("Actions"))
					.as("Actions Column Table header should be Displayed").isTrue();

			logger.info("Step 4 - Click on the +add button.");
			addentrypageobject.clickonAddCaseNoteButton();
			soft.assertThat(addentrypageobject.isAddCaseNoteOverlayDisplayed())
					.as("Add Case Note Overlay should be Displayed").isTrue();
		
			
			logger.info("Step 5 - Complete Entry and Entry type and click on Save");
			addentrypageobject.selectEntryType("Day Care");
			
			addentrypageobject.enterEntry("Test Case Note");
			addentrypageobject.clickonCaseNoteSaveButton();
			soft.assertThat(addentrypageobject.isCaseNoteEntryAdded())
					.as("Case Note Added Entry should get added").isTrue();
		
			
			logger.info("Step 3 -A dropdown is displayed with three options:- view this entry - edit this entry - complete this entry - delete this entry - remove this entry");
			
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("ViewEntry")).as("view this entry is displayed").isTrue();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("EditEntry")).as("edit this entry is displayed").isTrue();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("CompleteEntry")).as("complete this entry is displayed").isTrue();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("DeleteEntry")).as("delete this entry is displayed").isTrue();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("RemoveEntry")).as("remove this entry is displayed").isTrue();
			
			
			logger.info("Step 4 -The Remove Case Note entry popup is displayed Removing a Case Note entry may result in gaps in the case note for this person."
					 +" Are you sure you want to remove this case note entry?  message is shownDetails of the selected Case Note record are shown" );
			
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("RemoveEntry");
			
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("RemoveCaseNoteEntryPopup")).as("Remove CaseNote entry popup doesnt exist.");
			
			logger.info("Step 5 Click on No");
			editcasenotepageobject.Click("RemoveCaseNoteEntry_No_Button");
			
			logger.info("checking for no change in case note entry");
			soft.assertThat(editcasenotepageobject.checkNoChangeinCasenoteEntry("Day Care","Test Case Note")).as("Casenote entry changed even after pressing No while Editing note");
			
			
			logger.info("Step-6+10+14 Under Actions column click on select and select Remove this Entry");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("RemoveEntry");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("RemoveCaseNoteEntryPopup")).as("Remove CaseNote entry popup doesnt exist.");
			
			logger.info("Step 7+11+15 Click on Yes");
			editcasenotepageobject.Click("RemoveCaseNoteEntry_Yes_Button");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("RemoveCaseNoteEntryPopup")).isFalse().as("CaseNote entry not removed - Record still exists");
			
		
			logger.info("Step-8+12+18 Click on Select for a record that has a Source shown in the record and select Remove this entry");
			addentrypageobject.clickonAddCaseNoteButton();
			addentrypageobject.selectEntryType("Day Care");
			addentrypageobject.enterEntry("Test Case Note");
			editcasenotepageobject.Click("Sourcebutton");
			editcasenotepageobject.InputValue("SourceTextBox", "SomeSource");
			editcasenotepageobject.InputValue("SourceOrgTextBox", "SomeSourceOrg");
			editcasenotepageobject.Click("SaveCaseNote");
			editcasenotepageobject.waitFortheElement();
			
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("RemoveEntry");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("RemoveCaseNoteEntryPopup")).as("Remove CaseNote entry popup doesnt exist.");
			
			
			logger.info("Step-9+13+19 Click yes");
			editcasenotepageobject.Click("RemoveCaseNoteEntry_Yes_Button");	
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("RemoveCaseNoteEntryPopup")).isFalse().as("CaseNote entry not removed - Record still exists");
			
			logger.info("Step-16 Click on Select for a record that has an Event Date (not date and time) shown in the record and select Remove this entry");
			addentrypageobject.clickonAddCaseNoteButton();
			addentrypageobject.provideValueinDateField("Year", "1980");
			addentrypageobject.provideValueinDateField("Month", "Feb");
			addentrypageobject.provideValueinDateField("Day", "6");
			addentrypageobject.selectEntryType("Day Care");
			addentrypageobject.enterEntry("Test Case Note");
			editcasenotepageobject.Click("SaveCaseNote");
			editcasenotepageobject.waitFortheElement();
			
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("RemoveEntry");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("RemoveCaseNoteEntryPopup")).as("Remove CaseNote entry popup doesnt exist.");
			
			logger.info("Step-17 Click yes");
			editcasenotepageobject.Click("RemoveCaseNoteEntry_Yes_Button");	
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("RemoveCaseNoteEntryPopup")).isFalse().as("CaseNote entry not removed - Record still exists");
			
			logger.info("Step-20 Click on Select for a record that has an Event Date and time) shown in the record and select Remove this entry");
			addentrypageobject.clickonAddCaseNoteButton();
			addentrypageobject.provideValueinDateField("Year", "1980");
			addentrypageobject.provideValueinDateField("Month", "Feb");
			addentrypageobject.provideValueinDateField("Day", "6");
			addentrypageobject.provideValueinDateField("Hour", "11");
			addentrypageobject.provideValueinDateField("Minute", "14");
			addentrypageobject.selectEntryType("Day Care");
			addentrypageobject.enterEntry("Test Case Note");
			editcasenotepageobject.Click("SaveCaseNote");
			editcasenotepageobject.waitFortheElement();
			
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("RemoveEntry");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("RemoveCaseNoteEntryPopup")).as("Remove CaseNote entry popup doesnt exist.");
			
			logger.info("Step-21 Click yes");
			editcasenotepageobject.Click("RemoveCaseNoteEntry_Yes_Button");	
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("RemoveCaseNoteEntryPopup")).isFalse().as("CaseNote entry not removed - Record still exists");
			
			logger.info("Step 22 - Click on Home");
			editcasenotepageobject.Click("Home");
			
			logger.info("Step 23 - Click on Logout");
			login.EclipseLogout();

		}
	}

	@Test
	public void DeleteEntry_PersonScenario1_Test() throws Exception {
		logger.info("Starting inner class execution");
		InnerClass.driver = this.driver;
		InnerClass.logger = this.logger;
		Result runResult = JUnitCore.runClasses(InnerClass.class);
		Login_To_Application.CaptureResults(runResult);
	}
}


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
import com.uspeclipse.interfaces.SmokeTest;
import com.uspeclipse.pageobjects.casenotes.AddEntryPerson_pageobject;
import com.uspeclipse.pageobjects.casenotes.EditCaseNotes_pageobjects;
import com.uspeclipse.pageobjects.casenotes.SourceFilter_pageobject;
import com.uspeclipse.pageobjects.home.Home_pageobjects;
import com.uspeclipse.pageobjects.login.EclipseLogin_pageobject;
import com.uspeclipse.pageobjects.login.InviewLogin_pageobject;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;
import com.uspeclipse.pageobjects.person.EditPersonRecord_pageobject;
import com.uspeclipse.pageobjects.person.SearchPerson_pageobjects;
import com.uspeclipse.setup.Initialization;
import com.uspeclipse.setup.LoggerHelper;
import com.uspeclipse.helper.Parallelized;


@RunWith(Parallelized.class)
@Category(SmokeTest.class)
public class DeletedFilter_TestCaseID32976 {
	private WebDriver driver = null;
	private String browsertype = "";
	private Initialization Login_To_Application=null;
	Logger logger = Logger.getLogger(DeletedFilter_TestCaseID32976.class);

	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}

	public DeletedFilter_TestCaseID32976(String type) {
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
		public void DeletedFilterTest_32976(String title, String forename,
				String middlename, String surname, String byear, String bmonth,
				String bday, String ethnicity) throws IOException,
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
			AddEntryPerson_pageobject addentrypageobject = PageFactory
					.initElements(driver, AddEntryPerson_pageobject.class);
			AddPerson_pageobject addpersonpageobject = PageFactory.initElements(
					driver, AddPerson_pageobject.class);
			EditCaseNotes_pageobjects editcasenotepageobject = PageFactory.initElements(driver, EditCaseNotes_pageobjects.class);
			EclipseLogin_pageobject login = PageFactory.initElements(driver, EclipseLogin_pageobject.class);

			
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

			logger.info("Step 3 - Click on Case Notes Menu item  - Case Note screen is displayed"
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

			logger.info("Step 4 - User has a draft Case Note record User selects delete this entry from the Select menu User presses yes");
			
			addentrypageobject.clickonAddCaseNoteButton();
			 addentrypageobject.selectEntryType("Day Care");
			
			editcasenotepageobject.waitFortheElement();	
			elements.getElementWithIdentification(addentrypageobject.AddEntryTextbox).click();
			editcasenotepageobject.waitFortheElement();	
			
			addentrypageobject.enterEntry("Test Case Note");
			editcasenotepageobject.waitFortheElement();
			addentrypageobject.clickonCaseNoteSaveButton();
			soft.assertThat(addentrypageobject.isCaseNoteEntryAdded())
					.as("Case Note Added Entry should get added").isTrue();
		
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("DeleteEntry");
			editcasenotepageobject.Click("DeleteCaseNoteEntry_Yes_Button");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("DeleteEntryConfirmation")).as("Delete CaseNote confirmation message isnt present").isTrue();

			logger.info("Adding few casenotes to validate Step- 5");
			
			addentrypageobject.clickonAddCaseNoteButton();
			addentrypageobject.selectEntryType("Finance");
			addentrypageobject.enterEntry("Test");
			addentrypageobject.clickonCaseNoteSaveButton();
			
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("CompleteEntry");
			editcasenotepageobject.Click("CompleteCaseNoteEntry_Yes_Button");
			
			editcasenotepageobject.waitFortheElement();
			addentrypageobject.clickonAddCaseNoteButton();
			addentrypageobject.selectEntryType("Duty Contact");
			addentrypageobject.enterEntry("Test");
			addentrypageobject.clickonCaseNoteSaveButton();
			
			
			
			logger.info("Step 5 User checks the Include Deleted checkbox");
			
			editcasenotepageobject.Click("IncludeDeletedCasenotes_Checkbox");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("CompletedCaseNoteRecord")).as("Completed Casenote dint show up.").isTrue();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("DraftedCaseNoteRecord")).as("Drafted Casenote dint show up.").isTrue();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("DeletedCaseNoteRecord")).as("Deleted CaseNote dint show up.").isTrue();
			
			
			logger.info("Step 6 User clicks on the Select menu for the record that was deleted in step SC-1 3");
			
			editcasenotepageobject.Click("SelectDeletedEntry");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("ViewEntryForDeletedRecord")).as("edit this entry is displayed").isTrue();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("EditEntryForDeletedRecord")).as("edit this entry is displayed").isFalse();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("CompleteEntryForDeletedRecord")).as("complete this entry is displayed").isFalse();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("DeleteEntryForDeletedRecord")).as("delete this entry is displayed").isFalse();
			editcasenotepageobject.Click("SelectDeletedEntry");
			
			logger.info("Step 7 User unchecks the Include Deleted checkbox");
			logger.info("Open and completed records should be shown Record deleted in step SC-1 3 should not be shown");
			
			editcasenotepageobject.Click("IncludeDeletedCasenotes_Checkbox");
			editcasenotepageobject.waitFortheElement();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("CompletedCaseNoteRecord")).as("Completed Casenote dint show up.").isTrue();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("DraftedCaseNoteRecord")).as("Drafted Casenote dint show up.").isTrue();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("DeletedCaseNoteRecord")).as("Deleted CaseNote showed up.").isFalse();
			
			logger.info("Step 8 User has an completed Case Note record User selects delete this entry from the Select menu User presses 'yes'");
			logger.info("Delete entry overlay opens User clicks on 'yes' button Entry is removed from the results list and success message is displayed as, 'Case note entry successfully deleted'");
			
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("DeleteEntry");
			editcasenotepageobject.Click("DeleteCaseNoteEntry_Yes_Button");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("DeleteEntryConfirmation")).as("Delete CaseNote confirmation message isnt present").isTrue();


			logger.info("Step 9 User checks the Include Deleted checkbox");
			editcasenotepageobject.Click("IncludeDeletedCasenotes_Checkbox");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("DraftedCaseNoteRecord")).as("Drafted Casenote dint show up.").isTrue();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("DeletedCaseNoteRecord")).as("Deleted CaseNote dint show up.").isTrue();

			logger.info("Step 10 User clicks on the Select menu for the record that was deleted in step SC-1 7");
			editcasenotepageobject.Click("SelectDeletedEntry");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("ViewEntryForDeletedRecord")).as("edit this entry is displayed").isTrue();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("EditEntryForDeletedRecord")).as("edit this entry is displayed").isFalse();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("CompleteEntryForDeletedRecord")).as("complete this entry is displayed").isFalse();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("DeleteEntryForDeletedRecord")).as("delete this entry is displayed").isFalse();
			
			
			logger.info("Step 11 User unchecks the Include Deleted checkbox");
			editcasenotepageobject.Click("IncludeDeletedCasenotes_Checkbox");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("DraftedCaseNoteRecord")).as("Drafted Casenote dint show up.").isTrue();
			
			logger.info("Step 12 -Log into USP Application as a Manager");
			login.EclipseLogout();
			login.LoginByRole("manager");
			
			
			logger.info("Step 13 User unchecks the Include Deleted checkbox");
					
			searchpageobject.enterSearchText(personid);
			homepageobject.clickonAutoSuggestioninSearch();
			homepageobject.clickonCasenoteLink();
			editcasenotepageobject.Click("IncludeDeletedCasenotes_Checkbox");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("DraftedCaseNoteRecord")).as("Drafted Casenote dint show up.").isTrue();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("DeletedCaseNoteRecord")).as("Deleted CaseNote dint show up.").isTrue();

			logger.info("Step 14 User unchecks the Include Deleted checkbox");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("DraftedCaseNoteRecord")).as("Drafted Casenote dint show up.").isTrue();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("DeletedCaseNoteRecord")).as("Deleted CaseNote dint show up.").isFalse();

			logger.info("Step 15 User checks the Include Deleted checkbox");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("DraftedCaseNoteRecord")).as("Drafted Casenote dint show up.").isTrue();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("DeletedCaseNoteRecord")).as("Deleted CaseNote dint show up.").isTrue();
			
			logger.info("Step 16 - Click on Logout");
			login.EclipseLogout();
		}

	}

	@Test
	public void Deleted_Filter_Test() throws Exception {
		logger.info("Starting inner class execution");
		InnerClass.driver = this.driver;
		InnerClass.logger = this.logger;
		Result runResult = JUnitCore.runClasses(InnerClass.class);
		Login_To_Application.CaptureResults(runResult);
	}
}























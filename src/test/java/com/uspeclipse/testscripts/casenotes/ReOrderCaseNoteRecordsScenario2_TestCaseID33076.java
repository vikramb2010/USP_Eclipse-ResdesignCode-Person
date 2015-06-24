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
import com.uspeclipse.pageobjects.casenotes.EditCaseNotes_pageobjects;
import com.uspeclipse.pageobjects.home.Home_pageobjects;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;
import com.uspeclipse.pageobjects.person.SearchPerson_pageobjects;
import com.uspeclipse.setup.Initialization;

@RunWith(Parallelized.class)
@Category(SmokeTest.class)
public class ReOrderCaseNoteRecordsScenario2_TestCaseID33076 {
	private WebDriver driver = null;
	private String browsertype = "";
	private Initialization Login_To_Application=null;
	Logger logger = Logger.getLogger(ReOrderCaseNoteRecordsScenario2_TestCaseID33076.class);

	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}

	public ReOrderCaseNoteRecordsScenario2_TestCaseID33076(String type) {
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
		public void EditCase(String title, String forename,String middlename, String surname, String byear, String bmonth, String bday, String ethnicity,
				String caseyear, String casemonth, String caseday, String entrytype, String event, String entrytypeupdate1, String entrytypeupdate2, String entries, String source, String sourceorg) throws InterruptedException
		{
			SoftAssertions soft = new SoftAssertions();
			GenericActions elements = new GenericActions(driver);
			Home_pageobjects homepageobject = PageFactory.initElements(driver,Home_pageobjects.class);
			AddPerson_pageobject addpersonpageobject = PageFactory.initElements(driver, AddPerson_pageobject.class);
			SearchPerson_pageobjects searchpersonpageobject = PageFactory.initElements(driver, 	SearchPerson_pageobjects.class);
			EditCaseNotes_pageobjects editcasenotepageobject = PageFactory.initElements(driver, EditCaseNotes_pageobjects.class);

			logger.info("Step 1-2 - Select a client from either the Your recently accessed records list or the Your case load list or search for a client from the quick person search at the top of the screen User selects Case Notes from the Menu.");
			addpersonpageobject.AddNewPerson("client", title, forename, middlename, surname, byear, bmonth, bday, "Male", ethnicity);
			String personid = addpersonpageobject.getPersonID();
			elements.waitForPageLoaded();
			searchpersonpageobject.enterSearchText(personid);
		

			logger.info("Click on Case Notes Menu item");
			homepageobject.clickonCasenoteLink();
			
			elements.waitForPageLoaded();
			logger.info("Step 1-3 - Click on the +add button");
			editcasenotepageobject.Click("AddCaseNote");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("EntryDateRow")).as("Entry Date Row is present").isTrue();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("CurrentDate")).as("Current Date Link is present").isTrue();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("CurrentDateTime")).as("Current Date Time Link is present").isTrue();
			
			logger.info("Step 1-4 - Complete the mandatory fields leaving the date fields completely blank and click 'save'.");
			editcasenotepageobject.SelectDropDown("EntryType", entrytype);
			editcasenotepageobject.InputValue("Event", event);
			editcasenotepageobject.waitFortheElement();
			editcasenotepageobject.Click("SaveCaseNote");
			elements.waitForPageLoaded();
			soft.assertThat(editcasenotepageobject.checkNoChangeinCasenoteEntry(entrytype, event)).as("Added Row Verified").isTrue();
			
			elements.waitForPageLoaded();
			logger.info("Step 1-9 - Select delete this entry");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("DeleteEntry");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("DeleteEntryOverlay")).as("Delete Entry Overlay is displayed").isTrue();
			soft.assertThat(editcasenotepageobject.getWarnings("DeleteWarning").equals("Deleting a Case Note entry may result in gaps in the Case Note for this person. Are you sure you want to delete this entry?")).as("Delete Entry warning is displayed").isTrue();
			
			logger.info("Step 1-10 - Click on yes");
			editcasenotepageobject.Click("DeleteCaseNoteEntry_Yes_Button");
			elements.waitForPageLoaded();
			soft.assertThat(editcasenotepageobject.checkNoChangeinCasenoteEntry(entrytype, event)).as("Deleted Row Verified").isFalse();
			
			logger.info("Step 1-5 - Click on re-order button at the top right corner of the page");
			editcasenotepageobject.Click("ReOrderbutton");
			String Warning = editcasenotepageobject.getWarnings("FilterWarning");
			soft.assertThat(Warning.contains("Filters are disabled while re-ordering. Group Case Note entries are not included")).as("Warning Message : Fiter is not Avaliable").isTrue();
			
			logger.info("Step 1-7 Click on Finish");
			editcasenotepageobject.Click("Btn_Finish");
			soft.assertThat(editcasenotepageobject.getStatus("FilterButton").equalsIgnoreCase("false")).as("Filter Button is Enabled").isTrue();
			
			editcasenotepageobject.Click("AddCaseNote");
			editcasenotepageobject.SelectDropDown("EntryType", entrytypeupdate1);
			editcasenotepageobject.InputValue("Event", entrytypeupdate2);
			editcasenotepageobject.Click("SaveCaseNote");
			elements.waitForPageLoaded();
			
			logger.info("Step 1-8 - To the right of the new entry click on Select");
			editcasenotepageobject.Click("Select");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("ViewEntry")).as("view this entry is displayed").isTrue();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("EditEntry")).as("edit this entry is displayed").isTrue();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("CompleteEntry")).as("complete this entry is displayed").isTrue();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("DeleteEntry")).as("delete this entry is displayed").isTrue();
			//soft.assertThat(editcasenotepageobject.CheckForElementExistence("RemoveEntry")).as("remove this entry is displayed").isTrue();
			
			logger.info("Step 1-39 - Complete the mandatory fields adding a date in the future  and click save.");
			editcasenotepageobject.Click("EditEntry");
			editcasenotepageobject.InputValue("EditYearTextbox", elements.getDateParameters("Year"));
			editcasenotepageobject.SelectDropDown("EditMonthDropdown", elements.getDateParameters("Month"));
			editcasenotepageobject.SelectDropDown("EditDayDropdown", elements.getDateParameters("NextDay").replaceFirst("0", ""));
			editcasenotepageobject.Click("SaveCaseNote");
			elements.waitForPageLoaded();
			String ErrorMsg2 = editcasenotepageobject.getErrorMessage();
			soft.assertThat(ErrorMsg2.contains("Sorry, there was a problem with the form")).as("Sorry, there was a problem with the form").isTrue();
			soft.assertThat(ErrorMsg2.contains("Entry date must be today or earlier")).as("Entry date must be today or earlier").isTrue();
			editcasenotepageobject.waitFortheElement();
			
			logger.info("Step 1-40 - Complete the mandatory fields adding a date in the future  and click save.");
			editcasenotepageobject.Click("Cancel");
			elements.waitForPageLoaded();
			
			soft.assertAll();
		}

	}

	@Test
	public void ReOrderCaseNoteRecordsScenario2_Test() throws Exception {
		logger.info("Starting inner class execution");
		InnerClass.driver = this.driver;
		InnerClass.logger = this.logger;
		Result runResult = JUnitCore.runClasses(InnerClass.class);
		Login_To_Application.CaptureResults(runResult);
	}
}


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
import com.uspeclipse.commonservices.MultipleBrowser;
import com.uspeclipse.dataprovider.person.AddNewPerson_dataprovider;
import com.uspeclipse.helper.Parallelized;
import com.uspeclipse.interfaces.SmokeTest;
import com.uspeclipse.pageobjects.casenotes.AddEntryPerson_pageobject;
import com.uspeclipse.pageobjects.casenotes.SourceFilter_pageobject;
import com.uspeclipse.pageobjects.home.Home_pageobjects;
import com.uspeclipse.pageobjects.login.EclipseLogin_pageobject;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;
import com.uspeclipse.pageobjects.person.SearchPerson_pageobjects;
import com.uspeclipse.setup.Initialization;

@RunWith(Parallelized.class)
@Category(SmokeTest.class)
public class AddEntryPersonScenario6_TestCaseID35635 {
	private WebDriver driver = null;
	private String browsertype = "";
	private Initialization Login_To_Application = null;
	Logger logger = Logger
			.getLogger(AddEntryPersonScenario6_TestCaseID35635.class);

	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}

	public AddEntryPersonScenario6_TestCaseID35635(String type) {
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

		// Test Case for ID 35635 - To add an Entry to the Case Note Record of a
		// Person
		@Test
		@UseDataProvider(location = AddNewPerson_dataprovider.class, value = "PersonDetails")
		public void AddEntryPersonScenario6_Test(String title, String forename,
				String middlename, String surname, String byear, String bmonth,
				String bday, String ethnicity) throws Exception {
			SoftAssertions soft = new SoftAssertions();

			Home_pageobjects homepageobject = PageFactory.initElements(driver,
					Home_pageobjects.class);
			SearchPerson_pageobjects searchpageobject = PageFactory
					.initElements(driver, SearchPerson_pageobjects.class);
			SourceFilter_pageobject srcfilterpageobject = PageFactory
					.initElements(driver, SourceFilter_pageobject.class);
			AddEntryPerson_pageobject addentrypageobject = PageFactory
					.initElements(driver, AddEntryPerson_pageobject.class);
			AddPerson_pageobject addpersonpageobject = PageFactory
					.initElements(driver, AddPerson_pageobject.class);
			EclipseLogin_pageobject eclipse_pageobject = PageFactory
					.initElements(driver, EclipseLogin_pageobject.class);

			String entryValue = "Case Note";

			logger.info("Step 1 - Log into USP Application");
			eclipse_pageobject.LoginAgainBySwitchingRole("lance");

			soft.assertThat(homepageobject.getHomePageTitle()).isEqualTo(
					"Eclipse:Home");

			String practitioner = homepageobject.getPersonNamefromHeader();
			addpersonpageobject
					.AddNewPerson("client", title, forename, middlename,
							surname, byear, bmonth, bday, "Male", ethnicity);
			String personid = addpersonpageobject.getPersonID();
			homepageobject.clickonHomeLink();

			logger.info("Step 2 - Select a client from either the 'Your recently accessed records' list or the 'Your case load' list or search for a client from the quick person search at the top of the screen");
			searchpageobject.enterSearchText(personid);
			String personID = homepageobject.getPersonIDfromAutoSuggestion();
			homepageobject.clickonAutoSuggestioninSearch();
			soft.assertThat(personid)
					.as("Page Opened for Person is same as the Person Selected from AutoSuggestion")
					.isEqualTo(personID);

			logger.info("Step 3 - Click on Case Notes Menu item");
			homepageobject.clickonCasenoteLink();

			if (Initialization.browserName.equals("ios-ipad")) {
				addentrypageobject.waitForNoCaseNotePage();
			} else {
				soft.assertThat(
						srcfilterpageobject
								.isColumnHeaderDisplayed("Entry Date"))
						.as("Entry Date Column Table header should be Displayed")
						.isTrue();
				soft.assertThat(
						srcfilterpageobject.isColumnHeaderDisplayed("Entry"))
						.as("Entry Column Table header should be Displayed")
						.isTrue();
				soft.assertThat(
						srcfilterpageobject
								.isColumnHeaderDisplayed("Entry Type"))
						.as("Entry Type Column Table header should be Displayed")
						.isTrue();
				soft.assertThat(
						srcfilterpageobject.isColumnHeaderDisplayed("Impact"))
						.as("Impact Column Table header should be Displayed")
						.isTrue();
				soft.assertThat(
						srcfilterpageobject.isColumnHeaderDisplayed("Source"))
						.as("Source Column Table header should be Displayed")
						.isTrue();
				soft.assertThat(
						srcfilterpageobject
								.isColumnHeaderDisplayed("Practitioner"))
						.as("Practitioner Column Table header should be Displayed")
						.isTrue();
				soft.assertThat(
						srcfilterpageobject.isColumnHeaderDisplayed("Status"))
						.as("Status Column Table header should be Displayed")
						.isTrue();
				soft.assertThat(
						srcfilterpageobject.isColumnHeaderDisplayed("Actions"))
						.as("Actions Column Table header should be Displayed")
						.isTrue();
			}

			logger.info("Step 4 - Click on the +add button.");
			addentrypageobject.clickonAddCaseNoteButton();
			soft.assertThat(addentrypageobject.isAddCaseNoteOverlayDisplayed())
					.as("Add Case Note Overlay should be Displayed").isTrue();
			addentrypageobject.clickonPersonIcon();
			soft.assertThat(addentrypageobject.getPractitionerName())
					.as("Practitioner name should match")
					.isEqualTo(practitioner);
			soft.assertThat(addentrypageobject.getPractitionerOrg())
					.as("Practitioner Organisation name should match")
					.isEqualTo("Social Services");

			logger.info("Step 5 - User enters Date details");
			addentrypageobject.provideValueinDateField("Year", "1980");
			addentrypageobject.provideValueinDateField("Month", "Feb");
			addentrypageobject.provideValueinDateField("Day", "6");
			addentrypageobject.provideValueinDateField("Hour", "11");
			addentrypageobject.provideValueinDateField("Minute", "30");

			logger.info("Step 7 - User enters more than 20 lines of text in the Event field");
			addentrypageobject.enterValueinEntryTextBox(entryValue);

			logger.info("Step 8 - User selects an Impact by clicking on '?' icon");
			addentrypageobject.clickonImpactIcon();
			addentrypageobject.clickonAddImpactLevelRadioButton("Positive");

			logger.info("Step 9 - User selects a Source/Source Organisation. User selects a value from the Entry Type dropdown list. User presses save");
			addentrypageobject.clickonPersonIcon();
			addentrypageobject.enterSource("TestSource");
			addentrypageobject.enterSourceOrganisation("TestSourceOrg");
			addentrypageobject.selectEntryType("Day Care");
			addentrypageobject.clickonCaseNoteSaveButton();
			soft.assertThat(addentrypageobject.isConfirmationMessageDisplayed())
					.as("Confirmation Message should be Displayed").isTrue();
			soft.assertThat(addentrypageobject.verifyConfirmationMessage())
					.isEqualTo("Case Note entry successfully added");
			soft.assertThat(addentrypageobject.isCaseNoteEntryAdded())
					.as("Case Note Added Entry should get added").isTrue();
			soft.assertThat(
					addentrypageobject
							.isAddedCaseNoteCorrectforMultipleLines(entryValue))
					.as("Case Note Added Entry should get correct").isTrue();
			soft.assertThat(
					addentrypageobject.getCaseNoteEntryAddedPractitioner())
					.as("Practitioner name should match")
					.isEqualTo(practitioner);

			logger.info("Step 10 - Click on Logout");
			eclipse_pageobject.EclipseLogout();
			soft.assertAll();
		}

	}

	@Test
	public void AddEntryPersonScenario6_Test() throws Exception {
		logger.info("Starting inner class execution");
		InnerClass.driver = this.driver;
		InnerClass.logger = this.logger;
		Result runResult = JUnitCore.runClasses(InnerClass.class);
		Login_To_Application.CaptureResults(runResult);
	}
}

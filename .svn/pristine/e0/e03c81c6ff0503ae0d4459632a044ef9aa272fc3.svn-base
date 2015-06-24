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
public class AddEntryPersonScenario3_TestCaseID35635 {
	private WebDriver driver = null;
	private String browsertype = "";
	private Initialization Login_To_Application = null;
	Logger logger = Logger
			.getLogger(AddEntryPersonScenario3_TestCaseID35635.class);

	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}

	public AddEntryPersonScenario3_TestCaseID35635(String type) {
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
		public void SourceFilterScenario3Test(String title, String forename,
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

			logger.info("Step - 1 Log into USP as User A");
			eclipse_pageobject.LoginAgainBySwitchingRole("evan");

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

			logger.info("Step 5 - Complete Entry and Entry type and click on Save");
			addentrypageobject.selectEntryType("Day Care");
			addentrypageobject.enterEntry("Test Case Note");
			addentrypageobject.clickonCaseNoteSaveButton();
			soft.assertThat(
					addpersonpageobject.isConfirmationMessageDisplayed())
					.isTrue();
			soft.assertThat(addpersonpageobject.verifyConfirmationMessage())
					.isEqualTo("Case Note entry successfully added");
			soft.assertThat(addentrypageobject.isCaseNoteEntryAdded())
					.as("Case Note Added Entry should get added").isTrue();
			soft.assertThat(
					addentrypageobject.isAddedCaseNoteCorrect("Test Case Note"))
					.as("Case Note Added Entry should get correct").isTrue();
			soft.assertThat(
					addentrypageobject.getCaseNoteEntryAddedPractitioner())
					.as("Practitioner name should match")
					.isEqualTo(practitioner);

			logger.info("Step 6 - Logout of USP Application");
			logger.info("Step 7 - Login to USP Application as User B");
			eclipse_pageobject.LoginAgainBySwitchingRole("george");

			soft.assertThat(homepageobject.getHomePageTitle()).isEqualTo(
					"Eclipse:Home");
			String newPractitioner = homepageobject.getPersonNamefromHeader();

			logger.info("Step 8 - Select same subject as used in previous steps");
			searchpageobject.enterSearchText(personid);
			homepageobject.clickonAutoSuggestioninSearch();
			soft.assertThat(personid)
					.as("Page Opened for Person is same as the Person Selected from AutoSuggestion")
					.isEqualTo(personID);

			logger.info("Step 9 - Click on Case Notes in the Menu.");
			homepageobject.clickonCasenoteLink();

			logger.info("Step 10 - User selects View this entry for the Case Note created in this test case");
			addentrypageobject.clickonSelectButton();
			addentrypageobject.clickonViewCaseNoteButton();
			soft.assertThat(addentrypageobject.isViewCaseNoteOverlayDisplayed())
					.as("View Case Note Overlay should be Displayed").isTrue();
			addentrypageobject.clickonPersonIcon();
			soft.assertThat(addentrypageobject.getPractitionerName())
					.as("Practitioner name should match 10")
					.isEqualTo(practitioner);

			logger.info("Step 11 - User presses Cancel");
			addentrypageobject.clickonViewCaseNoteCancelButton();
			soft.assertThat(addentrypageobject.isAddCaseNoteButtonDisplayed())
					.as("Case Notes Screen should be Displayed").isTrue();

			logger.info("Step 12 - User selects Edit this entry for the case note created in this test case");
			addentrypageobject.clickonSelectButton();
			addentrypageobject.clickonEditCaseNoteButton();
			soft.assertThat(addentrypageobject.isEditCaseNoteOverlayDisplayed())
					.as("Edit Case Note Overlay should be Displayed").isTrue();
			addentrypageobject.clickonPersonIcon();
			soft.assertThat(addentrypageobject.getPractitionerName())
					.as("Practitioner name should match 12")
					.isEqualTo(newPractitioner);

			logger.info("Step 13 - User B edits the Case Note record and presses Save");
			addentrypageobject.selectEditEntryType("Finance");
			addentrypageobject.enterEditEntry("Change of Case Note");
			addentrypageobject.clickonCaseNoteSaveButton();
			soft.assertThat(addpersonpageobject.verifyConfirmationMessage())
					.as("Confirmation Mesage should be Displayed")
					.isEqualTo("Case Note entry successfully updated");

			logger.info("Step 14 - User selects View this entry for the Case Note created in this test case");
			addentrypageobject.clickonSelectButton();
			addentrypageobject.clickonViewCaseNoteButton();
			soft.assertThat(addentrypageobject.isViewCaseNoteOverlayDisplayed())
					.as("View Case Note Overlay should be Displayed").isTrue();
			addentrypageobject.clickonPersonIcon();
			soft.assertThat(addentrypageobject.getPractitionerName())
					.as("Practitioner name should match 14")
					.isEqualTo(newPractitioner);

			logger.info("Step 15 - Press Cancel");
			addentrypageobject.clickonViewCaseNoteCancelButton();
			soft.assertThat(addentrypageobject.isAddCaseNoteButtonDisplayed())
					.as("Case Notes Screen should be Displayed").isTrue();

			logger.info("Step 16 - Click on filter button and select Person tab");
			srcfilterpageobject.clickonSourceFilterButton();
			srcfilterpageobject.clickonPeopleTabinFilterBy();
			soft.assertThat(
					addentrypageobject
							.isPractitionerDisplayedinPractitionerFilter())
					.as("Practitioner should be Displayed").isTrue();
			soft.assertThat(
					addentrypageobject.isPractitionerDisplayedCorrect(
							practitioner, newPractitioner))
					.as("Practitioner name should match in the Filter")
					.isTrue();

			logger.info("Step 17 - Click on the Home link");
			homepageobject.clickonHomeLink();
			soft.assertThat(homepageobject.getHomePageTitle()).isEqualTo(
					"Eclipse:Home");

			logger.info("Step 18 - Click on Logout");
			eclipse_pageobject.EclipseLogout();
			soft.assertAll();
		}
	}

	@Test
	public void AddEntryPersonScenario3_Test() throws Exception {
		logger.info("Starting inner class execution");
		InnerClass.driver = this.driver;
		InnerClass.logger = this.logger;
		Result runResult = JUnitCore.runClasses(InnerClass.class);
		Login_To_Application.CaptureResults(runResult);
	}
}

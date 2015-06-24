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
import com.uspeclipse.pageobjects.person.EditPersonRecord_pageobject;
import com.uspeclipse.pageobjects.person.SearchPerson_pageobjects;
import com.uspeclipse.setup.Initialization;

@RunWith(Parallelized.class)
@Category(SmokeTest.class)
public class AddEntryPersonScenario2_TestCaseID35635 {
	private WebDriver driver = null;
	private String browsertype = "";
	// private String browsertype = null;
	private Initialization Login_To_Application = null;
	Logger logger = Logger
			.getLogger(AddEntryPersonScenario2_TestCaseID35635.class);

	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}

	public AddEntryPersonScenario2_TestCaseID35635(String type) {
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
		String browserName = Thread.currentThread().getName();

		// Test Case for ID 35635 - To add an Entry to the Case Note Record of a
		// Person
		@Test
		@UseDataProvider(location = AddNewPerson_dataprovider.class, value = "PersonDetails")
		public void AddEntryPersonScenario2_Test(String title, String forename,
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
			EditPersonRecord_pageobject editpersonpageobject = PageFactory
					.initElements(driver, EditPersonRecord_pageobject.class);
			EclipseLogin_pageobject eclipse_pageobject = PageFactory
					.initElements(driver, EclipseLogin_pageobject.class);

			if (browserName.equals("firefox")) {
				eclipse_pageobject.LoginAgainBySwitchingRole("lance");
			} else if (browserName.equals("chrome")) {
				eclipse_pageobject.LoginAgainBySwitchingRole("shane");
			} else if (browserName.equals("ie10")) {
				eclipse_pageobject.LoginAgainBySwitchingRole("david");
			} else if (browserName.equals("ie11")) {
				eclipse_pageobject.LoginAgainBySwitchingRole("brian");
			} else if (browserName.equals("ios-ipad")) {
				eclipse_pageobject.LoginAgainBySwitchingRole("kelly");
			}

			String practitioner = homepageobject.getPersonNamefromHeader();
			addpersonpageobject
					.AddNewPerson("client", title, forename, middlename,
							surname, byear, bmonth, bday, "Male", ethnicity);
			String personid = addpersonpageobject.getPersonID();

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
			// Thread.sleep(2000);
			addentrypageobject.enterEntry("Test Case Note");
			addentrypageobject.clickonCaseNoteSaveButton();
			soft.assertThat(addentrypageobject.isConfirmationMessageDisplayed())
					.isTrue();
			soft.assertThat(addentrypageobject.verifyConfirmationMessage())
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

			// Changing the name of the Practitioner
			String practName = "Test" + addentrypageobject.randomNumber();
			searchpageobject.enterSearchText(practitioner);
			homepageobject.clickonAutoSuggestionLinkinSearch();
			homepageobject.clickonPersonLink();
			editpersonpageobject.clickonEditPersonDetailsButton();
			addpersonpageobject.enterSurname(practName);
			editpersonpageobject.clickonSaveButton();
			Thread.sleep(3000);
			String updatedPractitioner = addpersonpageobject
					.getPersonNamefromHeader();

			searchpageobject.enterSearchText(personid);
			homepageobject.clickonAutoSuggestioninSearch();
			homepageobject.clickonCasenoteLink();

			logger.info("Step 6 - Click on the +add button.");
			addentrypageobject.clickonAddCaseNoteButton();
			soft.assertThat(addentrypageobject.isAddCaseNoteOverlayDisplayed())
					.as("Add Case Note Overlay should be Displayed").isTrue();
			addentrypageobject.clickonPersonIcon();
			soft.assertThat(addentrypageobject.getPractitionerName())
					.as("Practitioner name should match")
					.isEqualTo(updatedPractitioner);

			logger.info("Step 7 - Complete Entry and Entry type and click on Save");
			addentrypageobject.selectEntryType("Day Care");
			addentrypageobject.enterEntry("Test Case Note");
			addentrypageobject.clickonCaseNoteSaveButton();
			soft.assertThat(addentrypageobject.isConfirmationMessageDisplayed())
					.isTrue();
			soft.assertThat(addentrypageobject.verifyConfirmationMessage())
					.isEqualTo("Case Note entry successfully added");
			soft.assertThat(addentrypageobject.isCaseNoteEntryAdded())
					.as("Case Note Added Entry should get added").isTrue();
			soft.assertThat(
					addentrypageobject.isAddedCaseNoteCorrect("Test Case Note"))
					.as("Case Note Added Entry should get correct").isTrue();
			soft.assertThat(
					addentrypageobject.getCaseNoteEntryAddedPractitioner())
					.as("Practitioner name should match")
					.isEqualTo(updatedPractitioner);

			logger.info("Step 8 - User clicks on the view this entry");
			addentrypageobject.clickonSelectButton();
			addentrypageobject.clickonViewCaseNoteButton();
			soft.assertThat(addentrypageobject.isViewCaseNoteOverlayDisplayed())
					.as("View Case Note Overlay should be Displayed").isTrue();
			soft.assertThat(addentrypageobject.isViewCaseNoteFieldsDisabled())
					.as("View Case Note Fields should be Disabled").isTrue();
			addentrypageobject.clickonPersonIcon();
			soft.assertThat(addentrypageobject.getPractitionerName())
					.as("Practitioner name should match")
					.isEqualTo(updatedPractitioner);
			soft.assertThat(
					addentrypageobject.isPersonPopupFieldsDisplayed("Source"))
					.as("Source Textbox should be Displayed").isTrue();
			soft.assertThat(
					addentrypageobject
							.isPersonPopupFieldsDisplayed("Source Org"))
					.as("Source Organisation Textbox should be Displayed")
					.isTrue();
			addentrypageobject.clickonImpactIcon();
			soft.assertThat(
					addentrypageobject.getSelectedImpactLevelonViewForm())
					.isEqualTo("Unknown");
			addentrypageobject.clickonDateIcon();
			soft.assertThat(
					addentrypageobject.isViewDateFieldsDisplayed("Recorded"))
					.as("Recorded Date should be Displayed").isTrue();
			soft.assertThat(
					addentrypageobject.isViewDateFieldsDisplayed("Last Edited"))
					.as("Last Edited Date should be Displayed").isTrue();
			addentrypageobject.clickonViewCaseNoteCancelButton();

			logger.info("Step 9 - User clicks on the edit button");
			addentrypageobject.clickonSelectButton();
			addentrypageobject.clickonEditCaseNoteButton();
			soft.assertThat(addentrypageobject.isEditCaseNoteOverlayDisplayed())
					.as("Edit Case Note Overlay should be Displayed").isTrue();
			soft.assertThat(
					addentrypageobject
							.isEditCaseNoteFieldsEnabled("Entry Date"))
					.as("Entry Date Textbox should be Enabled").isTrue();
			soft.assertThat(
					addentrypageobject
							.isEditCaseNoteFieldsEnabled("Entry Type"))
					.as("Entry Type Dropdown should be Enabled").isTrue();
			soft.assertThat(
					addentrypageobject.isEditCaseNoteFieldsEnabled("Entry"))
					.as("Entry Textbox should be Enabled").isTrue();
			addentrypageobject.clickonPersonIcon();
			soft.assertThat(addentrypageobject.getPractitionerName())
					.as("Practitioner name should match")
					.isEqualTo(updatedPractitioner);
			soft.assertThat(
					addentrypageobject.isEditCaseNoteFieldsEnabled("Source"))
					.as("Source Textbox should be Enabled").isTrue();
			soft.assertThat(
					addentrypageobject
							.isEditCaseNoteFieldsEnabled("Source Org"))
					.as("Source Organisation Textbox should be Enabled")
					.isTrue();
			addentrypageobject.clickonImpactIcon();
			soft.assertThat(
					addentrypageobject.getSelectedImpactLevelonEditForm())
					.isEqualTo("Unknown");

			logger.info("Step 10 - User modifies the Impact value by clicking on 'Impact' icon next to 'person' icon at the bottom of the overlay and presses 'save'");
			addentrypageobject.clickonEditImpactLevelRadioButton("Positive");
			addentrypageobject.clickonCaseNoteSaveButton();
			soft.assertThat(addpersonpageobject.verifyConfirmationMessage())
					.as("Confirmation Mesage should be Displayed")
					.isEqualTo("Case Note entry successfully updated");
			soft.assertThat(
					addentrypageobject.getCaseNoteEntryAddedPractitioner())
					.as("Practitioner name should match")
					.isEqualTo(updatedPractitioner);

			logger.info("Step 11 - Click on filter button and select Person tab");
			srcfilterpageobject.clickonSourceFilterButton();
			srcfilterpageobject.clickonPeopleTabinFilterBy();
			soft.assertThat(
					addentrypageobject
							.isPractitionerDisplayedinPractitionerFilter())
					.as("Practitioner should be Displayed").isTrue();
			soft.assertThat(
					addentrypageobject.isPractitionerDisplayedCorrect(
							practitioner, updatedPractitioner))
					.as("Practitioner name should match in the Filter")
					.isTrue();

			logger.info("Step 12 - Click on the Home link");
			homepageobject.clickonHomeLink();
			soft.assertThat(homepageobject.getHomePageTitle()).isEqualTo(
					"Eclipse:Home");

			/*
			 * // Changing the name of the Practitioner to original one
			 * searchpageobject.enterSearchText(updatedPractitioner);
			 * homepageobject.clickonAutoSuggestionLinkinSearch();
			 * homepageobject.clickonPersonLink(); // Thread.sleep(3000);
			 * editpersonpageobject.clickonEditPersonDetailsButton();
			 * addpersonpageobject.enterSurname("Smith");
			 * editpersonpageobject.clickonSaveButton();
			 */

			logger.info("Step 13 - Click on Logout");
			eclipse_pageobject.EclipseLogout();
			soft.assertAll();

		}
	}

	@Test
	public void AddEntryPersonScenario2_Test() throws Exception {
		logger.info("Starting inner class execution");
		InnerClass.driver = this.driver;
		InnerClass.logger = this.logger;
		Result runResult = JUnitCore.runClasses(InnerClass.class);
		Login_To_Application.CaptureResults(runResult);
	}
}

package com.uspeclipse.testscripts.casenotes;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

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
public class AddEntryPersonScenario1_TestCaseID35635 {
	private WebDriver driver = null;
	private String browsertype = "";
	private Initialization Login_To_Application = null;
	Logger logger = Logger
			.getLogger(AddEntryPersonScenario1_TestCaseID35635.class);

	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}

	public AddEntryPersonScenario1_TestCaseID35635(String type) {
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
		public void AddEntryPersonScenario1_Test(String title, String forename,
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

			logger.info("Step 4 - The name of the Practitioner the user is logged in as should not be shown in the Practtitioner filter");
			srcfilterpageobject.clickonSourceFilterButton();
			srcfilterpageobject.clickonPeopleTabinFilterBy();
			soft.assertThat(
					addentrypageobject
							.isPractitionerDisplayedinPractitionerFilter())
					.as("Practitioner should not be Displayed").isFalse();

			logger.info("Step 5 - Click on the filter button.");
			srcfilterpageobject.clickonSourceFilterButton();

			logger.info("Step 6 - Click on the '+add' button.");
			addentrypageobject.clickonAddCaseNoteButton();
			soft.assertThat(addentrypageobject.isAddCaseNoteOverlayDisplayed())
					.as("Add Case Note Overlay should be Displayed").isTrue();
			addentrypageobject.clickonPersonIcon();
			soft.assertThat(addentrypageobject.getPractitionerName())
					.as("Practitioner name should match 6")
					.isEqualTo(practitioner);

			logger.info("Step 8A - Click on 'Person' icon");
			soft.assertThat(
					addentrypageobject.isPersonPopupFieldsDisplayed("Source"))
					.as("Source Textbox should be Displayed").isTrue();
			soft.assertThat(
					addentrypageobject
							.isPersonPopupFieldsDisplayed("Source Org"))
					.as("Source Organisation Textbox should be Displayed")
					.isTrue();
			soft.assertThat(
					addentrypageobject
							.isPersonPopupFieldsDisplayed("Practitioner"))
					.as("Practitioner Textbox should be Displayed").isTrue();
			soft.assertThat(
					addentrypageobject
							.isPersonPopupFieldsDisplayed("Practitioner Org"))
					.as("Practitioner Organisation Textbox should be Displayed")
					.isTrue();

			logger.info("Step 8B - Click on '?' icon which is a 'Impact level");
			addentrypageobject.clickonImpactIcon();
			soft.assertThat(
					addentrypageobject.isImpactPopupFieldsDisplayed("Positive"))
					.as("Positive Impact Radio Button should be Displayed")
					.isTrue();
			soft.assertThat(
					addentrypageobject.isImpactPopupFieldsDisplayed("Negative"))
					.as("Negative Impact Radio Button should be Displayed")
					.isTrue();
			soft.assertThat(
					addentrypageobject.isImpactPopupFieldsDisplayed("Neutral"))
					.as("Neutral Impact Radio Button should be Displayed")
					.isTrue();
			soft.assertThat(
					addentrypageobject.isImpactPopupFieldsDisplayed("Unknown"))
					.as("Unknown Impact Radio Button should be Displayed")
					.isTrue();

			logger.info("Step 7 - Click on save");
			addentrypageobject.clickonCaseNoteSaveButton();
			soft.assertThat(
					addentrypageobject
							.isMandatoryErrorMessageDisplayed("Entry Type"))
					.as("Entry type is mandatory should be Displayed").isTrue();
			soft.assertThat(
					addentrypageobject
							.isMandatoryErrorMessageDisplayed("Entry"))
					.as("Entry is mandatory should be Displayed").isTrue();
			soft.assertThat(
					addentrypageobject
							.getMandatoryErrorMessageText("Entry Type"))
					.as("Entry type is mandatory should be Displayed")
					.isEqualTo("Entry type is mandatory.");
			soft.assertThat(
					addentrypageobject.getMandatoryErrorMessageText("Entry"))
					.as("Entry is mandatory should be Displayed")
					.isEqualTo("Entry is mandatory.");

			logger.info("Step 8 - Complete Entry and Entry type and click on Save");
			addentrypageobject.selectEntryType("Day Care");
			addentrypageobject.enterEntry("Test Case Note");
			addentrypageobject.clickonCaseNoteSaveButton();
			soft.assertThat(addentrypageobject.isConfirmationMessageDisplayed())
					.as("Confirmation Message Should be Displayed").isTrue();
			soft.assertThat(addentrypageobject.isCaseNoteEntryAdded())
					.as("Case Note Added Entry should get added").isTrue();
			soft.assertThat(
					addentrypageobject.isAddedCaseNoteCorrect("Test Case Note"))
					.as("Case Note Added Entry should get correct").isTrue();
			soft.assertThat(
					addentrypageobject.getCaseNoteEntryAddedPractitioner())
					.as("Practitioner name should match")
					.isEqualTo(practitioner);

			logger.info("Step 9 - User clicks on the view this entry");
			addentrypageobject.clickonSelectButton();
			addentrypageobject.clickonViewCaseNoteButton();
			soft.assertThat(addentrypageobject.isViewCaseNoteOverlayDisplayed())
					.as("View Case Note Overlay should be Displayed").isTrue();
			soft.assertThat(addentrypageobject.isViewCaseNoteFieldsDisabled())
					.as("View Case Note Fields should be Disabled").isTrue();
			addentrypageobject.clickonPersonIcon();
			soft.assertThat(addentrypageobject.getPractitionerName())
					.as("Practitioner name should match")
					.isEqualTo(practitioner);
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

			logger.info("Step 10 - User clicks on the edit button");
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
					.isEqualTo(practitioner);
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

			logger.info("Step 11 - User modifies the Impact value by clicking on 'Impact' icon next to 'person' icon at the bottom of the overlay and presses 'save'");
			addentrypageobject.clickonEditImpactLevelRadioButton("Positive");
			addentrypageobject.clickonCaseNoteSaveButton();
			// addentrypageobject.waitForConfirmationMessage();
			soft.assertThat(addentrypageobject.verifyConfirmationMessage())
					.as("Confirmation Mesage should be Dispalyed")
					.isEqualTo("Case Note entry successfully updated");
			soft.assertThat(
					addentrypageobject.getCaseNoteEntryAddedPractitioner())
					.as("Practitioner name should match")
					.isEqualTo(practitioner);

			logger.info("Step 12 - Click on the +add button.");
			logger.info("Step 13 - Attempt to enter a date with no year.");
			addentrypageobject.AddCaseNoteEntry("", "Jan", "5", "", "",
					"Day Care", "Test Case Note");
			soft.assertThat(
					addentrypageobject.getEntryDatefromCaseNoteResultTable())
					.as("Date Column should be empty for the record").isEmpty();

			logger.info("Step 14 - Enter a year and attempt to enter a day with no month.");
			addentrypageobject.clickonAddCaseNoteButton();
			addentrypageobject.provideValueinDateField("Year", "1980");
			addentrypageobject.clearEntryDateYearField();
			addentrypageobject.provideValueinDateField("Year", "1980");
			soft.assertThat(addentrypageobject.isEntryDateFieldsEnabled("Day"))
					.as("Day Field should be Disabled").isFalse();

			logger.info("Step 15 - Enter a year and month and attempt to enter an hour with no day.");
			addentrypageobject.provideValueinDateField("Year", "1980");
			addentrypageobject.provideValueinDateField("Month", "Feb");
			soft.assertThat(addentrypageobject.isEntryDateFieldsEnabled("Hour"))
					.as("Hour Field should be Disabled").isFalse();

			logger.info("Step 16 - Enter a year, month and day and attempt to enter a minute with no hour.");
			addentrypageobject.provideValueinDateField("Year", "1980");
			addentrypageobject.provideValueinDateField("Month", "Feb");
			addentrypageobject.provideValueinDateField("Day", "6");
			soft.assertThat(
					addentrypageobject.isEntryDateFieldsEnabled("Minute"))
					.as("Minute Field should be Disabled").isFalse();

			logger.info("Step 17 - Complete all the date and time fields in sequential order.");
			Thread.sleep(2000);
			addentrypageobject.provideValueinDateField("Year", "1980");
			soft.assertThat(
					addentrypageobject.isEntryDateFieldsEnabled("Month"))
					.as("Month Field should be Enabled").isTrue();
			addentrypageobject.provideValueinDateField("Month", "Feb");
			soft.assertThat(addentrypageobject.isEntryDateFieldsEnabled("Day"))
					.as("Day Field should be Enabled").isTrue();
			addentrypageobject.provideValueinDateField("Day", "6");
			soft.assertThat(addentrypageobject.isEntryDateFieldsEnabled("Hour"))
					.as("Hour Field should be Enabled").isTrue();
			addentrypageobject.provideValueinDateField("Hour", "11");
			soft.assertThat(
					addentrypageobject.isEntryDateFieldsEnabled("Minute"))
					.as("Minute Field should be Enabled").isTrue();

			logger.info("Step 18 - Click on Select current date.");
			addentrypageobject.clickonSelectCurrentDateLink();
			String currentDate = new SimpleDateFormat("dd-MMM-yyyy")
					.format(new Date());
			Thread.sleep(2000);
			addentrypageobject.selectEntryType("Day Care");
			addentrypageobject.enterEntry("Test Case Note");
			addentrypageobject.clickonCaseNoteSaveButton();
			soft.assertThat(addentrypageobject.getDateofRecentlyAddedCaseNote())
					.isEqualTo(currentDate);

			logger.info("Step 19 - Click on Select current date and time.");
			addentrypageobject.clickonAddCaseNoteButton();
			addentrypageobject.clickonSelectCurrentDateTimeLink();
			String hour = addentrypageobject.getUKTime("Hour");
			String minute = addentrypageobject.getUKTime("Minute");
			String currentDateTime = addentrypageobject.getCurrentUKDateTime();
			addentrypageobject.provideValueinDateField("Hour", hour);
			addentrypageobject.provideValueinDateField("Minute", minute);
			addentrypageobject.selectEntryType("Day Care");
			addentrypageobject.enterEntry("Test Case Note");
			addentrypageobject.clickonCaseNoteSaveButton();
			soft.assertThat(
					addentrypageobject.getDateTimeofRecentlyAddedCaseNote())
					.isEqualTo(currentDateTime);

			logger.info("Step 20 - Complete all of the fields and click on save");
			addentrypageobject.clickonAddCaseNoteButton();
			addentrypageobject.selectEntryType("Day Care");
			addentrypageobject.enterEntry("Test Case Note");
			addentrypageobject.clickonCaseNoteSaveButton();
			addentrypageobject.waitForConfirmationMessage();
			soft.assertThat(addentrypageobject.isCaseNoteEntryAdded())
					.as("Case Note Added Entry should get added").isTrue();
			soft.assertThat(
					addentrypageobject.getCaseNoteEntryAddedPractitioner())
					.as("Practitioner name should match")
					.isEqualTo(practitioner);

			driver.navigate().refresh();
			logger.info("Step 21 - Click on filter button and select Person tab");
			srcfilterpageobject.clickonSourceFilterButton();
			srcfilterpageobject.clickonPeopleTabinFilterBy();
			soft.assertThat(
					addentrypageobject
							.isPractitionerDisplayedinPractitionerFilter())
					.as("Practitioner should be Displayed").isTrue();
			soft.assertThat(
					addentrypageobject
							.getPractitionerNameinPractitionerFilter())
					.as("Practitioner name should match")
					.isEqualTo(practitioner);

			logger.info("Step 22 - Press +add");
			logger.info("Step 23 - Enter data in all the mandatory fields, Enter a date in the future, Press save");
			addentrypageobject.AddCaseNoteEntry("2020", "", "", "", "",
					"Day Care", "Test");
			soft.assertThat(
					addentrypageobject.isFutureDateErrorMessageDisplayed())
					.as("Future Date Error Message should be displayed")
					.isTrue();
			soft.assertThat(addentrypageobject.getFutureDateErrorMessage())
					.as("Future Date Error Message should match")
					.isEqualTo("Entry date must be valid - today or earlier");

			logger.info("Step 24 - Press cancel");
			addentrypageobject.clickonCaseNoteCancelButton();
			soft.assertThat(addentrypageobject.isAddCaseNoteButtonDisplayed())
					.as("Case NOtes Screen should be Displayed").isTrue();

			logger.info("Step 29 - Click on filter button and select Person tab");
			srcfilterpageobject.clickonPeopleTabinFilterBy();
			soft.assertThat(
					addentrypageobject
							.isPractitionerDisplayedinPractitionerFilter())
					.as("Practitioner should be Displayed").isTrue();
			soft.assertThat(
					addentrypageobject
							.getPractitionerNameinPractitionerFilter())
					.as("Practitioner name should match")
					.isEqualTo(practitioner);

			logger.info("Step 31 - Click on the Home link");
			homepageobject.clickonHomeLink();
			soft.assertThat(homepageobject.getHomePageTitle()).isEqualTo(
					"Eclipse:Home");

			logger.info("Step 32 - Click on Logout");
			eclipse_pageobject.EclipseLogout();
			soft.assertAll();

		}

	}

	@Test
	public void AddEntryPersonScenario1_Test() throws Exception {
		logger.info("Starting inner class execution");
		InnerClass.driver = this.driver;
		InnerClass.logger = this.logger;
		Result runResult = JUnitCore.runClasses(InnerClass.class);
		Login_To_Application.CaptureResults(runResult);
	}
}

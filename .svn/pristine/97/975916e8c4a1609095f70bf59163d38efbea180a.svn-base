package com.uspeclipse.testscripts.person;

import java.io.IOException;
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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import com.uspeclipse.commonservices.Constants;
import com.uspeclipse.commonservices.GenericActions;
import com.uspeclipse.commonservices.MultipleBrowser;
import com.uspeclipse.dataprovider.person.AddNewPerson_dataprovider;
import com.uspeclipse.helper.Parallelized;
import com.uspeclipse.interfaces.SmokeTest;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;
import com.uspeclipse.pageobjects.person.AddRemoveRefForPerson_pageobject;
import com.uspeclipse.pageobjects.person.SearchPerson_pageobjects;
import com.uspeclipse.setup.Initialization;

@RunWith(Parallelized.class)
@Category(SmokeTest.class)
public class AddPersonReference_TestCaseID2981 {
	private WebDriver driver = null;
	private String browsertype = "";
	private Initialization Login_To_Application = null;
	Logger logger = Logger.getLogger(AddPersonReference_TestCaseID2981.class);

	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}

	public AddPersonReference_TestCaseID2981(String type) {
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
		//driver.close();
		driver.quit();
	}

	@RunWith(DataProviderRunner.class)
	public static class InnerClass {
		static WebDriver driver = null;
		static Logger logger = null;

		@Test
		@UseDataProvider(location = AddNewPerson_dataprovider.class, value = "PersonDetails")
		public void AddRemoveReferenceNumberOfPerson(String title,
				String forename, String middlename, String surname,
				String byear, String bmonth, String bday, String ethnicity)
				throws IOException, NoSuchMethodException, SecurityException,
				InterruptedException {

			SoftAssertions soft = new SoftAssertions();
			GenericActions elements = new GenericActions(driver);

			logger.debug("Test case started");
			AddPerson_pageobject addpersonpageobject = PageFactory
					.initElements(driver, AddPerson_pageobject.class);
			// Home_pageobjects homepageobject =
			// PageFactory.initElements(driver,Home_pageobjects.class);
			SearchPerson_pageobjects searchpersonpageobject = PageFactory
					.initElements(driver, SearchPerson_pageobjects.class);
			AddRemoveRefForPerson_pageobject addReferenceForPerson = PageFactory
					.initElements(driver,
							AddRemoveRefForPerson_pageobject.class);

			// addpersonpageobject.clickonAddNewPersonButton();

			addpersonpageobject
					.AddNewPerson("client", title, forename, middlename,
							surname, byear, bmonth, bday, "Male", ethnicity);
			logger.debug("New person added with PersonID - "
					+ addpersonpageobject.getPersonID());

			searchpersonpageobject.enterSearchText(addpersonpageobject
					.getPersonID());
			elements.waitForElementFluently(searchpersonpageobject.SearchAutocompleteFirstline, 30);
			elements.getElementWithIdentification(searchpersonpageobject.SearchAutocompleteFirstline).isDisplayed();
			
			logger.info("Executed pre-conditions");
			logger.info("The user must have logged in to the application as 'worker'");
			logger.info("The user must have access to 'Person' main page");
			logger.info("The user must have privelage to add a new person record.");
			logger.info("The user must have privelage to conduct a keyword search");

			logger.info("Search person with Id - "
					+ addpersonpageobject.getPersonID());
			logger.info("Confirm that on entering 'Name' or 'id' in the keyword search box the appropriate search record is displayed to the user");
			String[] idName = searchpersonpageobject.getPersonIdName();
			soft.assertThat(addpersonpageobject.getPersonID()).isEqualTo(
					idName[0]);
			elements.getElementWithIdentification(searchpersonpageobject.SearchAutocompleteFirstline).click();

			String idAndName = addReferenceForPerson.getPersonNameAndId();

			logger.info("Confirm that on selection of the required person search from the auto-suggest result set the 'Core identification details' of the relevant person is presented to the user.");
			soft.assertThat(idAndName).contains(
					addpersonpageobject.getPersonID());
			soft.assertThat(
					addReferenceForPerson.getIdentificationPanelFields("Name"))
					.contains(forename);
			soft.assertThat(
					addReferenceForPerson
							.getIdentificationPanelFields("Forenames"))
					.isEqualToIgnoringCase(middlename);
			soft.assertThat(
					addReferenceForPerson
							.getIdentificationPanelFields("Gender"))
					.isEqualToIgnoringCase("Male");
			soft.assertThat(
					addReferenceForPerson
							.getIdentificationPanelFields("Ethinicity"))
					.isEqualToIgnoringCase(ethnicity);

			logger.info("Confirm that by default 'Reference number' panel is in open state on the 'Core Identification details' page");
			soft.assertThat(addReferenceForPerson.isReferenceNumbersPanelOpen())
					.isEqualToIgnoringCase("Click to collapse section");
			
			elements.buttonClick(addReferenceForPerson.IdentificationLink);

			logger.info("Confirm '+' add button is visible on reference numbers panel");
			soft.assertThat(
					addReferenceForPerson
							.isElementVisible("AddReferenceButton")).isTrue();

			logger.info("Click add button on Reference Numbers panel");
			addReferenceForPerson.addReferenceNumberClick();

			logger.info("Confirm that on clicking the 'add' button in the Reference numbers panel, the 'Add reference number' overlay is presented to the user");
			logger.info("Confirm that the 'Add reference overlay' displays following details");
			logger.info("1. Add reference number - Heading\n2. Youre adding a reference number for Person name (PER ID) - As a narrative text");
			logger.info("3. Type (mandatory)\n4. Number (mandatory)\n5. save button\n6. cancel button");
			logger.info("7. (X) at the top right corner of the overlay");

			soft.assertThat(
					addReferenceForPerson
							.isElementVisible("ReferenceNumbersPanel"))
					.isTrue();
			soft.assertThat(
					addReferenceForPerson
							.getAddReferenceNumberOverlayFiels("NarrativeSummary"))
					.isEqualToIgnoringCase(
							"You're adding a reference number for");
			soft.assertThat(
					addReferenceForPerson
							.getAddReferenceNumberOverlayFiels("NarrativeDescription"))
					.contains(addpersonpageobject.getPersonID());
			soft.assertThat(
					addReferenceForPerson
							.getAddReferenceNumberOverlayFiels("Type"))
					.isEqualToIgnoringCase("Type *");
			soft.assertThat(
					addReferenceForPerson
							.getAddReferenceNumberOverlayFiels("Number"))
					.isEqualToIgnoringCase("Number *");
			soft.assertThat(
					addReferenceForPerson
							.getAddReferenceNumberOverlayFiels("Save"))
					.contains("save");
			soft.assertThat(
					addReferenceForPerson
							.getAddReferenceNumberOverlayFiels("Cancel"))
					.contains("cancel");
			soft.assertThat(
					addReferenceForPerson
							.getAddReferenceNumberOverlayFiels("Close"))
					.contains("close");

			logger.info("Confirm that 'Type' is a drop down of single select list and 'Please choose' should be available and it is not empty");
			soft.assertThat(
					addReferenceForPerson.getFirstElementOfTypeDropdown())
					.isEqualToIgnoringCase("Please choose");

			logger.info("Confirm that the 'Type' shows different types: Blind registration No., Connexions, etc");
			soft.assertThat(addReferenceForPerson.getListOfTypes()).contains(
					"Blind registration No.", "Driving Licence",
					"Home office registration No.");

			logger.info("Confirm that the maximum length of the reference numbers should not exceed 30 characters");
			soft.assertThat(
					addReferenceForPerson.getMaxLengthOfRefernceNumberInput())
					.isEqualTo("30");

			logger.info("Confirm that the user can enter freetext reference number e.g. letters, numbers and special characters are accepted in that field");
			addReferenceForPerson.addReferenceType("Blind registration No.",
					"BRN@1111");

			logger.info("Confirm that on clicking 'save' button the new reference number is added successfully and success message is displayed as 'Reference number successfully added'");
			soft.assertThat(addReferenceForPerson.getHeaderMessage())
					.isEqualToIgnoringCase(
							"Reference number successfully added");

			logger.info("Confirm that an 'edit' button appears when a 'Reference number' is added in the reference number panel of the core identification details page.");
			soft.assertThat(
					addReferenceForPerson
							.isElementVisible("EditReferenceButton")).isTrue();

			addReferenceForPerson.addReferenceNumberClick();

			logger.info("Confirm that there can only be 1 active reference number for any given 'Type'");
			logger.info("Confirm that when the user add a reference number of a particular type, the 'Type' drop down list should not allow to select that reference number that is already added.");
			soft.assertThat(addReferenceForPerson.getListOfTypes())
					.doesNotContain("Blind registration No.");

			// addReferenceForPerson.addReferenceType("Please choose", "");

			// soft.assertThat(addReferenceForPerson.getReferenceNumberPopupErrorMessage()).contains("Type is mandatory","Number is mandatory");
			logger.info("Do not select TYPE, only enter REFERENCE NO. and click SAVE");
			addReferenceForPerson.addReferenceType("Please choose", "DL@1111");

			logger.info("Confirm that an appropriate validation error message is displayed if Type is not entered and is incorrect");
			soft.assertThat(
					addReferenceForPerson.getReferenceNumberPopupErrorMessage())
					.contains("Type is mandatory");

			logger.info("Select TYPE, do not enter REFERENCE NO. and click SAVE");
			addReferenceForPerson.addReferenceType("Driving Licence", "");

			logger.info("Confirm that an appropriate validation error message is displayed if Reference Number is not entered and is incorrect");
			soft.assertThat(addReferenceForPerson.getReferenceNumberPopupErrorMessage()).contains("Number is mandatory");

			logger.info("Add all types reference number");
			addReferenceForPerson.addReferenceType("Driving Licence", "DL@1111");
			addReferenceForPerson.waitExplicity(2);
			addReferenceForPerson.addReferenceNumberClick();
			addReferenceForPerson.addReferenceType("Home office registration No.", "HORN@1111");
			addReferenceForPerson.waitExplicity(2);
			addReferenceForPerson.addReferenceNumberClick();
			addReferenceForPerson.addReferenceType("Hospital Number", "HN@1111");
			addReferenceForPerson.waitExplicity(2);
			addReferenceForPerson.addReferenceNumberClick();
			addReferenceForPerson.addReferenceType("National Insurance","NI@1111");
			addReferenceForPerson.waitExplicity(2);
			addReferenceForPerson.addReferenceNumberClick();
			addReferenceForPerson.addReferenceType("Passport", "P@1111");
			addReferenceForPerson.waitExplicity(2);
			addReferenceForPerson.addReferenceNumberClick();
			addReferenceForPerson.addReferenceType("UPN (pupil number)","UPN@1111");
			addReferenceForPerson.waitExplicity(1);

			logger.info("Confirm that the reference numbers when added are displayed 'Alphabetically' as per the 'Type' in the 'Reference number' panel.");
			soft.assertThat(addReferenceForPerson.getAddedReferenceTypeAndData(1)).contains("Blind registration No.", "BRN@1111");
			soft.assertThat(
					addReferenceForPerson.getAddedReferenceTypeAndData(2))
					.contains("Driving Licence", "DL@1111");
			soft.assertThat(
					addReferenceForPerson.getAddedReferenceTypeAndData(3))
					.contains("Home office registration No.", "HORN@1111");
			soft.assertThat(
					addReferenceForPerson.getAddedReferenceTypeAndData(4))
					.contains("Hospital Number", "HN@1111");
			soft.assertThat(
					addReferenceForPerson.getAddedReferenceTypeAndData(5))
					.contains("National Insurance", "NI@1111");
			soft.assertThat(
					addReferenceForPerson.getAddedReferenceTypeAndData(6))
					.contains("Passport", "P@1111");
			soft.assertThat(
					addReferenceForPerson.getAddedReferenceTypeAndData(7))
					.contains("UPN (pupil number)", "UPN@1111");

			logger.info("Confirm that when all the given 'Reference numbers' are added the 'add' button no longer exist on the 'Reference numbers' panel");
			// soft.assertThat(addReferenceForPerson.isElementVisible("AddReferenceButton")).isFalse();

			soft.assertAll();
		}

	}

	@Test
	public void AddPersonReference_Test() throws Exception {
		logger.info("Starting inner class execution");
		InnerClass.driver = this.driver;
		InnerClass.logger = this.logger;
		Result runResult = JUnitCore.runClasses(InnerClass.class);
		Login_To_Application.CaptureResults(runResult);
	}

}

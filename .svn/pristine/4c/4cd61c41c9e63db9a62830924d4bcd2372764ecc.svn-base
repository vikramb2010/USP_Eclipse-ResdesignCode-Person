package com.uspeclipse.testscripts.person;

import java.io.IOException;
import java.util.Arrays;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import com.uspeclipse.commonservices.Constants;
import com.uspeclipse.commonservices.GenericActions;
import com.uspeclipse.commonservices.MultipleBrowser;
import com.uspeclipse.dataprovider.person.AddReferenceNumber_dataprovider;
import com.uspeclipse.helper.Parallelized;
import com.uspeclipse.interfaces.SmokeTest;
import com.uspeclipse.pageobjects.home.Home_pageobjects;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;
import com.uspeclipse.pageobjects.person.AddReferenceNumber_pageobject;
import com.uspeclipse.pageobjects.person.SearchPerson_pageobjects;
import com.uspeclipse.setup.Initialization;

@RunWith(Parallelized.class)
@Category(SmokeTest.class)
public class AddReferenceNumber_TestCaseID2808 {
	private WebDriver driver = null;
	private String browsertype="";
	private Initialization Login_To_Application=null;
	Logger logger = Logger.getLogger(AddReferenceNumber_TestCaseID2808.class);

	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}

	public AddReferenceNumber_TestCaseID2808(String type) {
		Thread.currentThread().setName(type);
		driver = (new MultipleBrowser()).getBrowserDriver(type, this.getClass().getSimpleName());
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
		
		// Test Case for ID 2808 - To add reference number for a person
		@Test
		@UseDataProvider(location = AddReferenceNumber_dataprovider.class, value = "ReferenceNumber")
		public void AddReferenceNumberTest(String type, String title,
				String forename, String middlename, String surname, String byear,
				String bmonth, String bday, String gender, String ethnicity,
				String referencenum) throws IOException, NoSuchMethodException,
				SecurityException, InterruptedException {
			
			SoftAssertions soft = new SoftAssertions();
			GenericActions elements = new GenericActions(driver);
			Home_pageobjects homepageobject = PageFactory.initElements(driver,
					Home_pageobjects.class);
			AddPerson_pageobject addpersonpageobject = PageFactory.initElements(
					driver, AddPerson_pageobject.class);
			AddReferenceNumber_pageobject addreferencenumberpageobject = PageFactory
					.initElements(driver, AddReferenceNumber_pageobject.class);
			SearchPerson_pageobjects searchpersonpageobject = PageFactory
					.initElements(driver, SearchPerson_pageobjects.class);

			addpersonpageobject.AddNewPerson(type, title, forename, middlename,
					surname, byear, bmonth, bday, gender, ethnicity);

			String personnamewithID = addpersonpageobject.getPersonName();
			String personID = addpersonpageobject.getPersonID();
			homepageobject.clickonHomeLink();

			logger.info("Step 2 - Confirm that on entering 'Name' or 'id' in the keyword search box the appropriate search record is displayed to the user");
			searchpersonpageobject.enterSearchText(personID);

			logger.info("Step 3 - Confirm that on selection of the required person search from the autosuggest result set the 'Core identification details' of the relevant person is presented to the user.");
			homepageobject.clickonAutoSuggestioninSearch();
			String personnamewithid = addpersonpageobject.getPersonName();
			soft.assertThat(addpersonpageobject.getPersonName()).isEqualTo(
					personnamewithID);

			
			logger.info("Step 4 - Confirm that by default 'Reference number' panel is in open state on the 'Core Identification details' page");
			soft.assertThat(
					addreferencenumberpageobject
							.verifyReferenceNumberPanel("title")).isEqualTo(
					"Click to collapse section");

			elements.buttonClick(addreferencenumberpageobject.IdentificationLink);
			
			logger.info("Step 5 - Confirm that '(+) add button' and '(up arrow) on the top right corner of the panel' are displayed on the Reference numbers panel if any reference number is not added to that record yet");
			soft.assertThat(
					addreferencenumberpageobject.isReferenceNumberLinkDisplayed())
					.isTrue();
			soft.assertThat(
					addreferencenumberpageobject
							.isAddReferenceNumberbuttonDisplayed()).isTrue();

			logger.info("Step 6 - Confirm that on clicking the 'add' button in the Reference numbers panel, the 'Add reference number' overlay is presented to the user");
			addreferencenumberpageobject.clickonAddReferenceNumberButton();
			soft.assertThat(
					addreferencenumberpageobject.isAddReferenceOverlayDisplayed())
					.isTrue();

			logger.info("Step 7 - Confirm that the 'Add reference overlay' displays 'Add reference number - Heading', 'You're adding a reference number for Person name (PER ID) - As a narrative text', 'Type (mandatory)', 'Number (mandatory)', 'save button', 'cancel button', '(X) at the top right corner of the overlay'");
			soft.assertThat(
					addreferencenumberpageobject
							.isAddReferenceFormFieldDisplayed("Title")).isTrue();
			soft.assertThat(
					addreferencenumberpageobject
							.isAddReferenceFormFieldDisplayed("Narrative"))
					.isTrue();
			soft.assertThat(
					addreferencenumberpageobject
							.isAddReferenceFormFieldDisplayed("Type")).isTrue();
			soft.assertThat(
					addreferencenumberpageobject
							.isAddReferenceFormFieldDisplayed("Number")).isTrue();
			soft.assertThat(
					addreferencenumberpageobject
							.isAddReferenceFormFieldDisplayed("Save")).isTrue();
			soft.assertThat(
					addreferencenumberpageobject
							.isAddReferenceFormFieldDisplayed("Cancel")).isTrue();
			soft.assertThat(
					addreferencenumberpageobject
							.isAddReferenceFormFieldDisplayed("Close")).isTrue();
			soft.assertThat(
					addreferencenumberpageobject.getAddReferenceOverlayTitle())
					.isEqualTo("Add reference number");
			soft.assertThat(
					addreferencenumberpageobject.getAddReferenceNarrativeText())
					.isEqualTo(
							"You're adding a reference number for\n"
									+ personnamewithid);

			logger.info("Step 8 - Confirm that 'Type' is a drop down of single select list and 'Please choose' should be available and it is not empty");
			soft.assertThat(
					addreferencenumberpageobject
							.getReferenceNumberTypeDefaultDropdown()).isEqualTo(
					"Please choose");

			logger.info("Step 9 - Confirm that the 'Type' shows 'Blind registration No.', 'Connexions', 'Driving Licence', 'Home office registration No.', 'Hospital Number', 'National Insurance', 'Passport', 'Police', 'Probation', 'UPN (pupil number)', 'YOT'");
			soft.assertThat(
					addreferencenumberpageobject.checkTypeOptions(Arrays.asList("",
							"Blind registration No.", "Driving Licence",
							"Home office registration No.", "Hospital Number",
							"National Insurance", "Passport", "UPN (pupil number)")))
					.isTrue();

			logger.info("Step 24 - Confirm that on entering the Type and Number and clicking 'cancel' button or the 'X' at the top right corner, the new reference number does not get added and is not displayed in the 'Reference numbers' panel. The existing Reference number panel is displayed to the user.");
			addreferencenumberpageobject
					.selectOptionfromReferenceTypeDropdown(addreferencenumberpageobject
							.selectLastOption());
			addreferencenumberpageobject.enterReferenceNumber(referencenum);
			addreferencenumberpageobject.clickonClosebutton();
			soft.assertThat(
					addreferencenumberpageobject.isReferenceNumberDisplayed())
					.isFalse();

			logger.info("Step 23 - Confirm that on entering the Type and Number and clicking 'cancel' button the new reference number does not get added and is not displayed in the 'Reference numbers' panel. The Reference number panel is displayed to the user.");
			addreferencenumberpageobject.clickonAddReferenceNumberButton();
			addreferencenumberpageobject
					.selectOptionfromReferenceTypeDropdown(addreferencenumberpageobject
							.selectLastOption());
			addreferencenumberpageobject.enterReferenceNumber(referencenum);
			String refnumtype = addreferencenumberpageobject.selectLastOption();
			addreferencenumberpageobject.clickonCancelbutton();
			soft.assertThat(
					addreferencenumberpageobject.isReferenceNumberDisplayed())
					.isFalse();


			
			logger.info("Step 22 - Confirm that on clicking 'save' button the new reference number is added successfully and is displayed in the 'Reference numbers'panel and success message is displayed as 'Reference number successfully added'");
			//addreferencenumberpageobject.clickonAddReferenceNumberButton();
			addreferencenumberpageobject.AddReferenceNumber(referencenum);
			soft.assertThat(addpersonpageobject.verifyConfirmationMessage())
					.isEqualTo("Reference number successfully added");
			soft.assertThat(
					addreferencenumberpageobject
							.verifyRecentlyAddedReferenceNumberType()).isEqualTo(
					refnumtype);
			soft.assertThat(
					addreferencenumberpageobject
							.verifyRecentlyAddedReferenceNumberText()).isEqualTo(
					referencenum);

			logger.info("Step 14 - Confirm that an 'edit' button appears when a 'Reference number' is added in the reference number panel of the core identification details page.");
			soft.assertThat(addreferencenumberpageobject.isEditButtonDisplayed())
					.isTrue();

			logger.info("Step 20 - Confirm that when the user add a reference number of a particular type e.g. 'Driving license' , the 'Type' drop down list should not allow to select that reference number that is already added. i.e. as 'Driving license' is already added, that 'Type' should no more exist on the 'Type' drop down so that user is not allowed to choose the same 'Type' again.");
			addreferencenumberpageobject.clickonAddReferenceNumberButton();
			addreferencenumberpageobject
					.verifyTypeisnotListedinDropdown(refnumtype);
			int size = addreferencenumberpageobject.getSizeofTypeDropDown() - 1;
			addreferencenumberpageobject.clickonSaveButton();

			logger.info("Step 18 - Confirm that an appropriate validation error message is displayed if either of the Type and/or the reference number is not entered and is incorrect");
			soft.assertThat(
					addreferencenumberpageobject.isTypeMandatoryMessageDisplayed())
					.isTrue();
			soft.assertThat(addreferencenumberpageobject.getTypeMandatoryMessage())
					.isEqualTo("Type is mandatory.");
			soft.assertThat(
					addreferencenumberpageobject
							.isNumberMandatoryMessageDisplayed()).isTrue();
			soft.assertThat(
					addreferencenumberpageobject.getNumberMandatoryMessage())
					.isEqualTo("Number is mandatory.");
			addreferencenumberpageobject.clickonCancelbutton();

			logger.info("Step 16 - Confirm that when all the given 'Reference numbers' are added the 'add' button no longer exist on the 'Reference numbers' panel in the core identification details page of a person.");
			for (int i = 0; i < size; i++) {
				//addreferencenumberpageobject.clickonAddReferenceNumberButton();
				addreferencenumberpageobject.AddReferenceNumber(referencenum + i);
				Thread.sleep(2000);
			}
			soft.assertThat(
					addreferencenumberpageobject
							.isAddReferenceNumberbuttonPresent()).isFalse();

			logger.info("Step 13 - Confirm that the reference numbers when added are displayed 'Alphabetically' as per the 'Type' in the 'Reference number' panel.");
			soft.assertThat(
					addreferencenumberpageobject.verifyReferenceNumberListSorting())
					.isTrue();

			soft.assertAll();

		}
		
	}

	@Test
	public void AddReferenceNumber_Test() throws Exception {
		logger.info("Starting inner class execution");
		InnerClass.driver = this.driver;
		InnerClass.logger = this.logger;
		Result runResult = JUnitCore.runClasses(InnerClass.class);
		Login_To_Application.CaptureResults(runResult);
	}

}

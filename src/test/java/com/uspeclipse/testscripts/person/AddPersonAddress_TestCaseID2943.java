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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import com.uspeclipse.commonservices.Constants;
import com.uspeclipse.commonservices.MultipleBrowser;
import com.uspeclipse.dataprovider.person.AddPersonAddress_dataprovider;
import com.uspeclipse.helper.Parallelized;
import com.uspeclipse.interfaces.SmokeTest;
import com.uspeclipse.pageobjects.person.AddPersonAddress_pageobjects;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;
import com.uspeclipse.setup.Initialization;

@RunWith(Parallelized.class)
@Category(SmokeTest.class)
public class AddPersonAddress_TestCaseID2943 {
	private WebDriver driver = null;
	private String browsertype="";
	private Initialization Login_To_Application=null;
	Logger logger = Logger.getLogger(AddPersonAddress_TestCaseID2943.class);

	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}

	public AddPersonAddress_TestCaseID2943(String type) {
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
		@UseDataProvider(location = AddPersonAddress_dataprovider.class, value = "PersonAddressdetails")
		public void AddPersonAddressWhenlocationExists(String title,
				String forename, String middlename, String surname,
				String byear, String bmonth, String bday, String ethnicity,
				String postcode, String housename, String type, String usage,
				String year, String Month, String Day, String type2,
				String usage2, String partialpostcode, String validhouseName,
				String validhousenumber) throws IOException,
				NoSuchMethodException, SecurityException, InterruptedException {

			// Page objects are initialized .
			
			SoftAssertions soft = new SoftAssertions();
			AddPerson_pageobject addpersonpageobject = PageFactory
					.initElements(driver, AddPerson_pageobject.class);
			AddPersonAddress_pageobjects addpersonaddresspageobject = PageFactory
					.initElements(driver, AddPersonAddress_pageobjects.class);

			// Adding a New Person
			logger.info("Adding a New Person ");
			addpersonpageobject
					.AddNewPerson("client", title, forename, middlename,
							surname, byear, bmonth, bday, "Male", ethnicity);

			// Clicking on Add address Button
			logger.info("Clicking on Add Address button");
			addpersonaddresspageobject.clickOnAddAddressButton();

			// Confirming whether Add person address overlay is displayed .
			logger.info("Confirming whether Add person address overlay is displayedmessage");
			soft.assertThat(
					addpersonaddresspageobject
							.isAddPersonAddressOverlaydisplayed()).as("Address Overlay is Displayed").isTrue();

			// Confirming whether Housename textbox is disabled.
			logger.info("Confirming whether Housename textbox is disabled");
			soft.assertThat(addpersonaddresspageobject.isHouseNameorNumberTextboxEnabled()).as("HouseName or number textbox enabled").isFalse();
			addpersonaddresspageobject.enterPostcodeText(postcode);

			// Confirming House Name Textbox is enabled after Valid post code is
			// entered in postcode textbox.
			logger.info("Confirming House Name Textbox is enabled after Valid post code is entered in postcode textbox");
			soft.assertThat(addpersonaddresspageobject.isHouseNameorNumberTextboxEnabled()).as("HouseName or number textbox enabled").isTrue();
			String expectedaddress = addpersonaddresspageobject
					.getExpectedAddressFromAutocomplete();
			addpersonaddresspageobject.selectaLocationFromAutocompleteList();

			// Confirming that postcode textbox is no longer displayed
			logger.info("Confirming that postcode textbox is no longer displayed");
			soft.assertThat(
					addpersonaddresspageobject.isPostCodeTextboxdisplayed()) .as("Confirming that postcode textbox is no longer displayed")
					
					.isFalse();

			// Confirming that House Name textbox is no longer displayed
			logger.info("Confirming that House Name textbox is no longer displayed");
			soft.assertThat(
					addpersonaddresspageobject.isHouseNameTextboxdisplayed()).as("Confirming that House Name textbox is no longer displayed")
					.isFalse();

			// Confirming that change link is displayed
			logger.info("Confirming that change link is displayed");
			soft.assertThat(addpersonaddresspageobject.isChangeLinkdisplayed())
					.as("Confirming that change link is displayed").isTrue();
			addpersonaddresspageobject
					.selectValuefromlocationtypeDropwndownbox(type);
			addpersonaddresspageobject
					.selectValuefromlocationUsageDropdownbox(usage);
			addpersonaddresspageobject.enteryear(year);
			addpersonaddresspageobject.selectValuefromMonthDropdownbox(Month);
			addpersonaddresspageobject.selectValuefromDayDropdownbox(Day);
			addpersonaddresspageobject.clickOnSaveAddressButton();

			// Verifying whether Proper confirmation messages are displayed
			logger.info("Verifying whether Proper confirmation messages are displayed");
			soft.assertThat(
					addpersonaddresspageobject
							.ConfirmationMessageonSavingAddress()).as("Verifying whether Proper confirmation messages are displayed").isEqualTo(
					"Address successfully added");

			// Confirming that proper address are displayed after save.
			logger.info("Confirming that proper address are  displayed after save");
			soft.assertThat(
					addpersonaddresspageobject
							.getActualAddressFromAddressTable()
							+ ""
							+ addpersonaddresspageobject
									.getActualStartDateFromAddressgrid())
					.as("Confirming that proper address are  displayed after save").isEqualTo(
							expectedaddress + "" + Day + "-" + Month + "-"
									+ year);
			addpersonaddresspageobject.clickOnAddAddressButton();
			addpersonaddresspageobject.ClickOnAddLocationLink();

			// Confirming whether add location Overlay is displayed
			logger.info("Confirming whether add location Overlay is displayed");
			soft.assertThat(
					addpersonaddresspageobject.isAddLocationOverlayDisplayed())
					.as("Confirming whether add location Overlay is displayed")
					.isTrue();

			addpersonaddresspageobject
					.ClickOnCancelButtonUnderLocationOverlay();

			// Confirming whether add person address overlay is displayed
			logger.info("Confirming whether add person address overlay is displayed");
			soft.assertThat(
					addpersonaddresspageobject
							.isAddPersonAddressOverlaydisplayed())
							.as("Confirming whether add person address overlay is displayed")
							.isTrue();
			addpersonaddresspageobject
					.selectValuefromlocationtypeDropwndownbox(type2);
			addpersonaddresspageobject
					.selectValuefromlocationUsageDropdownbox(usage2);
			addpersonaddresspageobject.enteryear(year);
			addpersonaddresspageobject.selectValuefromMonthDropdownbox(Month);
			addpersonaddresspageobject.selectValuefromDayDropdownbox(Day);
			addpersonaddresspageobject.enterPostcodeText(partialpostcode);
			addpersonaddresspageobject
					.enterHouseNameorNumberText(validhouseName);

			// Confirming whether Location are displayed in the autocomplete
			logger.info("Confirming whether Location are displayed in the autocomplete");
			soft.assertThat(
					addpersonaddresspageobject
							.isLocationAutocompletedisplayed()).isTrue();
			addpersonaddresspageobject
					.enterHouseNameorNumberText(validhousenumber);

			// Confirming whether Location are displayed in the autocomplete on
			// entering valid house Number
			logger.info("Confirming whether Location are displayed in the autocomplete on entering valid house Number");
			soft.assertThat(
					addpersonaddresspageobject
							.isLocationAutocompletedisplayed())
							.as("Confirming whether Location are displayed in the autocomplete on entering valid house Number")
							.isTrue();
			addpersonaddresspageobject.selectaLocationFromAutocompleteList();

			// Confirm that the pre-selected 'Type', 'Usage' and start date are
			// still displayed and have not been removed when the location is
			// selected
			logger.info("Confirming that the pre-selected 'Type', 'Usage' and start date are still displayed and have not been removed when the location is selected");
			String description = "Confirming that the pre-selected 'Type', 'Usage' and start date are still displayed and have not been removed when the location is selected";
			soft.assertThat(type2).as(description).isEqualTo(
					addpersonaddresspageobject.getTextFromTypeDropdownbox());
			soft.assertThat(usage2).as(description).isEqualTo(
					addpersonaddresspageobject.getTextFromUsageDropdownbox());
			soft.assertThat(Month).as(description).isEqualTo(
					addpersonaddresspageobject.getTextFromMonthDropdownbox());
			soft.assertThat(Day).as(description).isEqualTo(
					addpersonaddresspageobject.getTextFromDayDropdownbox());
			addpersonaddresspageobject.clickOnSaveAddressButton();

			// Verifying proper confirmation messages are displayed after saving
			// address
			logger.info("Verifying proper confirmation messages are displayed after saving address");
			soft.assertThat(
					addpersonaddresspageobject
							.ConfirmationMessageonSavingAddress()).as("Verifying proper confirmation messages are displayed after saving address").isEqualTo(
					"Address successfully added");
			soft.assertAll();

		}

	}

	@Test
	public void AddPersonAddress_Test() throws Exception {
		logger.info("Starting inner class execution");
		InnerClass.driver = this.driver;
		InnerClass.logger = this.logger;
		Result runResult = JUnitCore.runClasses(InnerClass.class);
		Login_To_Application.CaptureResults(runResult);
	}

}

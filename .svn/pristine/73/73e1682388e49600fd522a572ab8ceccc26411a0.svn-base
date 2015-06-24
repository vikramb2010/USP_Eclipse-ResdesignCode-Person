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
import com.uspeclipse.interfaces.SmokeTest;
import com.uspeclipse.pageobjects.person.AddPersonAddress_pageobjects;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;
import com.uspeclipse.setup.Initialization;
import com.uspeclipse.helper.Parallelized;

@RunWith(Parallelized.class)
@Category(SmokeTest.class)
public class AddPersonAddress_TestcaseID2944 {
	private WebDriver driver = null;
	private String browsertype = "";
	private Initialization Login_To_Application=null;
	Logger logger = Logger.getLogger(AddPersonAddress_TestcaseID2944.class);

	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}

	public AddPersonAddress_TestcaseID2944(String type) {
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
	//	driver.close();
		driver.quit();
	}

	@RunWith(DataProviderRunner.class)
	public static class InnerClass {
		static WebDriver driver = null;
		static Logger logger = null;

		// Test Case for ID 2944 -> Person - add address when the location does
		// not exists

		@Test
		@UseDataProvider(location = AddPersonAddress_dataprovider.class, value = "AddPersonAddressDetailsWhenLocationIsNotPresent")
		public void AddPersonAddressWhenlocationDoesnotExists(String title,
				String forename, String middlename, String surname,
				String byear, String bmonth, String bday, String ethnicity,
				String partialPostcode, String invalidHouseNameorNumber,
				String postcode, String buildingNameorNumber1,
				String streetName1, String localityName1, String townorCity1,
				String county1, String type1, String usage1, String type2,
				String usage2, String year, String Month, String Day,
				String buildingNameorNumber2, String streetName2,
				String localityName2, String townorCity2, String county2)
				throws IOException, NoSuchMethodException, SecurityException,
				InterruptedException {

			SoftAssertions soft = new SoftAssertions();
			// Page objects are initialized.

			AddPerson_pageobject addpersonpageobject = PageFactory
					.initElements(driver, AddPerson_pageobject.class);
			AddPersonAddress_pageobjects addpersonaddresspageobject = PageFactory
					.initElements(driver, AddPersonAddress_pageobjects.class);
			addpersonpageobject
					.AddNewPerson("client", title, forename, middlename,
							surname, byear, bmonth, bday, "Male", ethnicity);

			String personnamewithid = addpersonpageobject.getPersonName();

			// Clicking on Add Addressbutton
			addpersonaddresspageobject.clickOnAddAddressButton();

			// Confirming whether Add person Address overlay is displayed.
			logger.info("Confirming whether Add person Address overlay is displayed");
			soft.assertThat(
					addpersonaddresspageobject
							.isAddPersonAddressOverlaydisplayed()).isTrue();

			// Confirming whether HouseName or Number textbox is disabled.
			logger.info("Confirming whether HouseName or Number textbox is disabled.");
			soft.assertThat(
					addpersonaddresspageobject.isHouseNameorNumberTextboxEnabled()).isFalse();

			// Confirming whether add location link is displayed
			logger.info("Confirming whether add location link is displayed");
			soft.assertThat(
					addpersonaddresspageobject.isAddLocationLinkDisplayed())
					.isTrue();

			addpersonaddresspageobject.enterPostcodeText(partialPostcode);
			addpersonaddresspageobject
					.enterHouseNameorNumberText(invalidHouseNameorNumber);

			// Confirming that a information text appears below with
			// "We have results for you - do you want to add a location?"
			logger.info("Confirming that a information text appears below with We have results for you - do you want to add a location?");
			soft.assertThat(
					addpersonaddresspageobject.getTextFromInformationText())
					.isEqualTo(
							"We have no results for you - do you want to add a location?");
			addpersonaddresspageobject
					.ClearTextFromHouseNameorHouseNumberTextbox();
			addpersonaddresspageobject.enterPostcodeText(postcode);
			addpersonaddresspageobject.isLocationAutocompletedisplayed();
			addpersonaddresspageobject.ClickOnAddLocationLink();

			// Confirming that the narrative below the header of the overlay now
			// reads "You're adding a new location and an address for Nominated
			// person name and ID
			logger.info("Confirming that the narrative below the header of the overlay now reads You're adding a new location and an address for Nominated person name and ID");
			soft.assertThat(
					addpersonaddresspageobject
							.getNarrativeTextFromLocationOverlay()).isEqualTo(
					"You're adding a new location and an address for\n"
							+ personnamewithid);
			addpersonaddresspageobject
					.enterBuildingNameorNumber(buildingNameorNumber1);
			addpersonaddresspageobject.enterStreetName(streetName1);
			addpersonaddresspageobject.enterLocalityName(localityName1);
			addpersonaddresspageobject.enterTownorCity(townorCity1);
			addpersonaddresspageobject
					.SelectValueFromCountyDropdownbox(county1);
			addpersonaddresspageobject
					.enterPostCodeUnderLocationOverlay(postcode);
			addpersonaddresspageobject
					.ClickOnSaveandContinueUnderLocationOverlay();

			// Verifying whether proper confirmation messages are displayed on
			// saving location.
			logger.info("Verifying whether proper confirmation messages are displayed on saving location");
			soft.assertThat(
					addpersonaddresspageobject
							.ConfirmationMessageonSavingLocation()).isEqualTo(
					"Location successfully added");

			// Confirming that the narrative under the overlay header now reads
			// "You're adding an address for Nominated person and ID"
			logger.info("Confirming that the narrative under the overlay header now reads You're adding an address for Nominated person and ID");
			
			soft.assertThat(
					addpersonaddresspageobject
							.getNarrativeTextAfterAddingLocationUnderAddAddressOverlayHeader())
					.isEqualTo(
							"You're adding an address for\n" + personnamewithid);

			// Confirming whether location label now has the location added
			if(addpersonaddresspageobject.isElementPresent("Location Details"))
			soft.assertThat(
					addpersonaddresspageobject
							.getActualLocationFromLocationLabel()).isEqualTo(
					buildingNameorNumber1 + " " + streetName1 + "," + " "
							+ localityName1 + "," + " " + townorCity1 + ","
							+ " " + county1 + "," + " " + postcode);
			else
				soft.assertThat(true).as("Address not displayed after successfully Saving it").isFalse();
			
			
			// Confirming that change link is displayed
			logger.info("Confirming that change link is displayed");
			soft.assertThat(addpersonaddresspageobject.isChangeLinkdisplayed())
					.isTrue();

			addpersonaddresspageobject
					.selectValuefromlocationtypeDropwndownbox(type1);
			addpersonaddresspageobject
					.selectValuefromlocationUsageDropdownbox(usage1);
			addpersonaddresspageobject.enteryear(year);
			addpersonaddresspageobject.selectValuefromMonthDropdownbox(Month);
			addpersonaddresspageobject.selectValuefromDayDropdownbox(Day);
			addpersonaddresspageobject.clickOnSaveAddressButton();

			// Verifying Whether proper confirmation messages are displayed on
			// saving address
			logger.info("Verifying Whether proper confirmation messages are displayed on saving address");
			soft.assertThat(
					addpersonaddresspageobject
							.ConfirmationMessageonSavingAddress()).isEqualTo(
					"Address successfully added");

			// Verifying whether address saved is being displayed under the
			// Address section
			logger.info("Verifying whether address saved is being displayed under the Address section");
			soft.assertThat(
					addpersonaddresspageobject
							.getActualAddressFromAddressTable()).isEqualTo(
					buildingNameorNumber1 + " " + streetName1 + "," + " "
							+ localityName1 + "," + " " + townorCity1 + ","
							+ " " + county1 + "," + " " + postcode);
			addpersonaddresspageobject.clickOnAddAddressButton();
			addpersonaddresspageobject.ClickOnAddLocationLink();
			addpersonaddresspageobject
					.enterBuildingNameorNumber(buildingNameorNumber2);
			addpersonaddresspageobject.enterStreetName(streetName2);
			addpersonaddresspageobject.enterLocalityName(localityName2);
			addpersonaddresspageobject.enterTownorCity(townorCity2);
			addpersonaddresspageobject
					.SelectValueFromCountyDropdownbox(county2);
			addpersonaddresspageobject
					.enterPostCodeUnderLocationOverlay(postcode);
			addpersonaddresspageobject
					.ClickOnSaveandContinueUnderLocationOverlay();
			addpersonaddresspageobject
					.selectValuefromlocationtypeDropwndownbox(type2);
			addpersonaddresspageobject
					.selectValuefromlocationUsageDropdownbox(usage2);
			addpersonaddresspageobject.enteryear(year);
			addpersonaddresspageobject.selectValuefromMonthDropdownbox(Month);
			addpersonaddresspageobject.selectValuefromDayDropdownbox(Day);
			addpersonaddresspageobject.clickOnSaveAddressButton();

			// Verifying whether proper confirmation message are being displayed
			// on saving address
			logger.info("Verifying whether proper confirmation message are being displayed on saving address");
			soft.assertThat(
					addpersonaddresspageobject
							.ConfirmationMessageonSavingAddress()).isEqualTo(
					"Address successfully added");

			// Verifying that the address which is saved are being displayed in
			// the Address table
			logger.info("Verifying  that the address which is saved are being displayed in the Address table");
			soft.assertThat(
					addpersonaddresspageobject
							.getAnotherActualAddressFromAddressTable())
					.isEqualTo(
							buildingNameorNumber2 + " " + streetName2 + ","
									+ " " + localityName2 + "," + " "
									+ townorCity2 + "," + " " + county2 + ","
								+ " " + postcode);
			
			
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

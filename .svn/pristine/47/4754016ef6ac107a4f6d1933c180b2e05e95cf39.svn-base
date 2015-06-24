package com.uspeclipse.testscripts.person;

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
import com.uspeclipse.commonservices.MultipleBrowser;
import com.uspeclipse.dataprovider.person.AddReferenceNumber_dataprovider;
import com.uspeclipse.helper.Parallelized;
import com.uspeclipse.interfaces.SmokeTest;
import com.uspeclipse.pageobjects.home.Home_pageobjects;
import com.uspeclipse.pageobjects.login.EclipseLogin_pageobject;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;
import com.uspeclipse.pageobjects.person.AddReferenceNumber_pageobject;
import com.uspeclipse.pageobjects.person.RemoveReferenceNumber_pageobject;
import com.uspeclipse.pageobjects.person.SearchPerson_pageobjects;
import com.uspeclipse.setup.Initialization;

@RunWith(Parallelized.class)
@Category(SmokeTest.class)
public class RemoveReferenceNumber_TestCaseID2888 {
	private WebDriver driver = null;
	private Initialization Login_To_Application=null;
	private String browsertype="";
	Logger logger = Logger
			.getLogger(RemoveReferenceNumber_TestCaseID2888.class);

	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}

	public RemoveReferenceNumber_TestCaseID2888(String type) {
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

		// Test Case for ID 2888 - To remove reference number for a person
		@Test
		@UseDataProvider(location = AddReferenceNumber_dataprovider.class, value = "ReferenceNumber")
		public void RemoveReferenceNumberTest(String type, String title,
				String forename, String middlename, String surname, String byear,
				String bmonth, String bday, String gender, String ethnicity,
				String referencenum) throws IOException, NoSuchMethodException,
				SecurityException, InterruptedException, BiffException, InvalidFormatException {
			
			SoftAssertions soft = new SoftAssertions();
			
			Home_pageobjects homepageobject = PageFactory.initElements(driver,
					Home_pageobjects.class);
			AddPerson_pageobject addpersonpageobject = PageFactory.initElements(
					driver, AddPerson_pageobject.class);
			AddReferenceNumber_pageobject addreferencenumberpageobject = PageFactory
					.initElements(driver, AddReferenceNumber_pageobject.class);
			SearchPerson_pageobjects searchpersonpageobject = PageFactory
					.initElements(driver, SearchPerson_pageobjects.class);
			RemoveReferenceNumber_pageobject removereferencenumberpageobject = PageFactory
					.initElements(driver, RemoveReferenceNumber_pageobject.class);

			EclipseLogin_pageobject eclipsepageobject  = PageFactory.initElements(driver, EclipseLogin_pageobject.class);
			eclipsepageobject.LoginAgainBySwitchingRole("manager");
			
			
			addpersonpageobject.AddNewPerson(type, title, forename, middlename,
					surname, byear, bmonth, bday, gender, ethnicity);

			String personnamewithID = addpersonpageobject.getPersonName();
			String personID = addpersonpageobject.getPersonID();
			homepageobject.clickonHomeLink();

			logger.info("Step 2 - Confirm that when the user do a keyword search and selects a person from the autosuggest drop down he is presented with the core identification details page of that person");
			searchpersonpageobject.enterSearchText(personID);
			homepageobject.clickonAutoSuggestioninSearch();
			String personnamewithid = addpersonpageobject.getPersonName();
			soft.assertThat(addpersonpageobject.getPersonName()).isEqualTo(
					personnamewithID);

			logger.info("Step 4 - Confirm that, by default the 'Reference number' panel is in the open state in the core identification page");
			soft.assertThat(
					addreferencenumberpageobject
							.verifyReferenceNumberPanel("title")).isEqualTo(
					"Click to collapse section");

			logger.info("Step 5 - Confirm that the 'Reference number' panel can be closed by the user by clicking on the (up arrow) at the top right corner of the Reference number panel(if needed)");
			addreferencenumberpageobject.clickonReferenceNumberLink();
			soft.assertThat(
					addreferencenumberpageobject
							.verifyReferenceNumberPanel("title")).isEqualTo(
					"Click to expand section");
			addreferencenumberpageobject.clickonReferenceNumberLink();
			soft.assertThat(
					addreferencenumberpageobject.isReferenceNumberLinkDisplayed())
					.isTrue();

			logger.info("Step 6 - Confirm that in the 'Reference number' panel following fields(Type) and buttons are displayed: 'Blind registration no.- Greyed out', 'Connexions - Greyed out', 'National Insurance - Greyed out', 'Driving License - Greyed out', 'edit button', 'add button', '(x) at the top right corner of the panel'");
			for (int i = 0; i < 3; i++) {
				addreferencenumberpageobject.AddReferenceNumber(referencenum + i);
				Thread.sleep(3000);
			}
			soft.assertThat(
					removereferencenumberpageobject.verifyReferenceNumbers())
					.isTrue();
			soft.assertThat(
					addreferencenumberpageobject
							.isAddReferenceNumberbuttonDisplayed()).isTrue();
			soft.assertThat(addreferencenumberpageobject.isEditButtonDisplayed())
					.isTrue();

			logger.info("Step 8 - Confirm that if the user clicks on the 'edit' button, the'Edit reference numbers' overlay is presented to the user and the user can edit any of the reference number entered.");
			addreferencenumberpageobject.clickonEditReferenceNumberButton();
			soft.assertThat(
					removereferencenumberpageobject
							.isEditReferenceNumberOverlayDisplayed()).isTrue();

			logger.info("Step 10 - Confirm that the 'Edit reference numbers' overlay displays : 'Edit reference numbers (Heading)', 'You're editing the reference numbers for Person name(Person id)- As Narrative text', 'Blind registration no- with an appropriate value', 'Connexions - with an appropriate value', 'National Insurance - with an appropriate value', 'Driving Licence - with an appropriate value', 'save button', 'cancel button', '(x) at the top right corner of the panel', ''Remove' link against each of the displayed reference numbers.', Note:  The Type depends upon the entries which user can choose to enter, so for all those 'Types' which are listed as per the user, the value should be present in the 'Edit reference numbers' overlay.");
			soft.assertThat(
					removereferencenumberpageobject
							.isEditReferenceFormFieldDisplayed("Title")).isTrue();
			soft.assertThat(
					removereferencenumberpageobject
							.isEditReferenceFormFieldDisplayed("Narrative"))
					.isTrue();
			soft.assertThat(
					removereferencenumberpageobject
							.isEditReferenceFormFieldDisplayed("Remove")).isTrue();
			soft.assertThat(
					removereferencenumberpageobject
							.isEditReferenceFormFieldDisplayed("Save")).isTrue();
			soft.assertThat(
					removereferencenumberpageobject
							.isEditReferenceFormFieldDisplayed("Cancel")).isTrue();
			soft.assertThat(
					removereferencenumberpageobject
							.isEditReferenceFormFieldDisplayed("Close")).isTrue();
			soft.assertThat(
					removereferencenumberpageobject.getEditReferenceOverlayTitle())
					.isEqualTo("Edit reference numbers");
			soft.assertThat(
					removereferencenumberpageobject.getEditReferenceNarrativeText())
					.isEqualTo(
							"You're editing the reference numbers for\n"
									+ personnamewithid);

			logger.info("Step 9 - Confirm that on clicking the 'edit' button, the 'Types' and the corresponding entered 'Reference number' should be enabled for user to edit (if any)");
			soft.assertThat(
					removereferencenumberpageobject
							.isReferenceNumberEnabledforEditing()).isTrue();

			logger.info("Step 12 - Confirm that on removing the reference number and clicking the 'save' button, the empty reference number for that particular 'Type' is updated for that person record");
			removereferencenumberpageobject.clickonEditReferenceRemoveLink();
			soft.assertThat(
					removereferencenumberpageobject
							.isReferenceNumberTextBoxEnabled()).isFalse();
			removereferencenumberpageobject.clickonEditReferenceNumberSaveButton();

			logger.info("Step 14 - Confirm that on clicking the 'save' button, the user is notified by a success message, 'Reference numbers successfully removed'.");
			soft.assertThat(addpersonpageobject.verifyConfirmationMessage())
					.isEqualTo("Reference number successfully removed");

			logger.info("Step 13 - Confirm that the removed reference number will be permanently removed from the application by the user on clicking the 'Remove' link and clicking the 'save' button.");
			soft.assertThat(
					removereferencenumberpageobject.verifyReferenceNumbers())
					.isTrue();

			logger.info("Step 16 - Confirm that on removing the reference number and clicking the 'cancel' button, the empty reference number for that particular 'Type' is not updated and the existing reference number is displayed for that person record");
			addreferencenumberpageobject.clickonEditReferenceNumberButton();
			removereferencenumberpageobject.clickonEditReferenceRemoveLink();
			removereferencenumberpageobject
					.clickonEditReferenceNumberCancelButton();
			soft.assertThat(
					removereferencenumberpageobject.verifyReferenceNumbers())
					.isTrue();

			logger.info("Step 17 - Confirm that when the user clicks on the 'cancel' button or the 'X', the 'Reference numbers' panel is visible to the user in the core identification details page");
			addreferencenumberpageobject.clickonEditReferenceNumberButton();
			removereferencenumberpageobject.clickonEditReferenceRemoveLink();
			removereferencenumberpageobject.clickonEditReferenceNumberCloseButton();
			soft.assertThat(
					removereferencenumberpageobject.verifyReferenceNumbers())
					.isTrue();
			soft.assertAll();

		}
		
	}

	@Test
	public void RemoveReferenceNumber_Test() throws Exception {
		logger.info("Starting inner class execution");
		InnerClass.driver = this.driver;
		InnerClass.logger = this.logger;
		Result runResult = JUnitCore.runClasses(InnerClass.class);
		Login_To_Application.CaptureResults(runResult);
	}

}




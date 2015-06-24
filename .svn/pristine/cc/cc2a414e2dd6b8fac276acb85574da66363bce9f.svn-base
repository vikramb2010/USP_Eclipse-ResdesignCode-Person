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
import com.uspeclipse.dataprovider.person.AddNewPerson_dataprovider;
import com.uspeclipse.interfaces.SmokeTest;
import com.uspeclipse.pageobjects.home.Home_pageobjects;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;
import com.uspeclipse.pageobjects.person.AddWarning_pageobject;
import com.uspeclipse.setup.Initialization;
import com.uspeclipse.helper.*;


@RunWith(Parallelized.class)
@Category(SmokeTest.class)
public class AddNewPerson_TestCaseID2583  {
	private WebDriver driver = null;
	private String browsertype="";
	private Initialization Login_To_Application=null;
	Logger logger = Logger.getLogger(AddNewPerson_TestCaseID2583.class);

	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}

	public AddNewPerson_TestCaseID2583(String type) {
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

		@Test
		@UseDataProvider(location = AddNewPerson_dataprovider.class, value = "PersonDetails")
		public void AddNewPersonTest(String title, String forename,
				String middlename, String surname, String byear, String bmonth,
				String bday, String ethnicity) throws IOException,
				NoSuchMethodException, SecurityException, InterruptedException {

			SoftAssertions soft = new SoftAssertions();
			AddPerson_pageobject Person = PageFactory.initElements(driver,
					AddPerson_pageobject.class);
			Home_pageobjects Home = PageFactory.initElements(driver,
					Home_pageobjects.class);
			AddWarning_pageobject AddWarning_pageobject = PageFactory.initElements(
					driver, AddWarning_pageobject.class);

			logger.info("Step 2 - Navigate to Person screen");
			Home.clickonRecentlyAccessedRecordLinkinHomepage();

			logger.info("Step 3 - Confirm that an '+ADD'and 'WARNINGS' buttons are available at the  top right corner to the user when the person is in the context");
			soft.assertThat(Person.isAddNewPersonButtonDisplayed()).isTrue();
			soft.assertThat(AddWarning_pageobject.isAddWarningButtonDisplayed())
					.isTrue();
			Person.clickonAddNewPersonButton();

			logger.info("Step 4 - Confirm that on clicking the'+ADD'button as in above step, a 'Add Person' overlay is opened to the user");
			soft.assertThat(Person.isAddNewPersonOverlayDisplayed()).isTrue();

			logger.info("Step 5 - Confirm that the narrative on the overlay is 'What type do you want to add?'");
			soft.assertThat(Person.getNarrativeText()).isEqualTo(
					"What type do you want to add?");

			logger.info("Step 6 - Confirm that three checkboxes are displayed: Client, Other, Professional");
			soft.assertThat(Person.isPersonTypeCheckboxDisplayed("client"))
					.isTrue();
			soft.assertThat(Person.isPersonTypeCheckboxDisplayed("other")).isTrue();
			soft.assertThat(Person.isPersonTypeCheckboxDisplayed("professional"))
					.isTrue();

			logger.info("Step 7 - Confirm that the none of the checkboxes are pre-selected");
			soft.assertThat(Person.isPersonTypeCheckboxSelected("client"))
					.isFalse();
			soft.assertThat(Person.isPersonTypeCheckboxSelected("other")).isFalse();
			soft.assertThat(Person.isPersonTypeCheckboxSelected("professional"))
					.isFalse();

			logger.info("Step 8 - Confirm that 'proceed' and 'cancel' buttons are displayed below the checkboxes on the right-hand side of the overlay");
			soft.assertThat(Person.isProceedButtonDisplayed()).isTrue();
			soft.assertThat(Person.isCancelButtonDisplayed()).isTrue();

			logger.info("Step 9 - Select the checkbox for Client, carer or family/household member");
			Person.clickonPersonTypeCheckbox("client");

			logger.info("Step 10 - Click on 'proceed' button ");
			Person.clickonProceedButton();

			logger.info(" Step 11 - Confirm that the narrative has now changed to 'You're adding a new person'");
			soft.assertThat(Person.getNarrativeTextonForm()).isEqualTo(
					"You're adding a new person");

			logger.info("Step 22 - Confirm that the'Title' shows a drop-down menu and should not be empty. 'Please choose' should be displayed if no selection is made from the drop-down.");
			soft.assertThat(Person.getDefaultTitleinDropdown()).isEqualTo(
					"Please choose");
			soft.assertThat(Person.isOptionsofTitleDropdownnotEmpty()).isTrue();

			// Person.clickonCalenderIcon(); //
			// soft.assertThat(Person.isCalendarDisplayed()).isTrue();

			logger.info("Step 29 - Confirm that alternatively the user can also manually enter the year in the year field in 'YYYY' format");
			Person.enterDOBYear(byear);

			logger.info("Step 33 - Confirm that when the year is entered in the 'Year' field, the 'Month' field is enabled and the 'Day' field is disabled.");
			soft.assertThat(Person.isDOBDropdownEnabled("DOBMonth")).isTrue();
			soft.assertThat(Person.isDOBDropdownEnabled("DOBDay")).isFalse();

			logger.info("Step 31 - Confirm that on-clicking the down arrow in the month field of calender, months from January, February, March, April, May. June. July, August, September, October, November,December are displayed in the default order");
			soft.assertThat(Person.checkDOBMonthOptions()).isTrue();
			// Person.verifyEstimatedAge(byear);

			logger.info("Step 43 - Confirm that the'Ethnicity'should not be empty instead 'Please choose' should reflect in the field.");
			soft.assertThat(Person.getDefaultEthnicityinDropdown()).isEqualTo(
					"Please choose");

			logger.info("Step 45 - Confirm that Gender show following options in the form of radio buttons[**b**][**b**] 1. Male[**b**] 2. Female[**b**] 3. Indeterminate[**b**] 4. Unknown[**b**]");
			soft.assertThat(Person.isnGenderRadioButtonDisplayed("Male")).isTrue();
			soft.assertThat(Person.isnGenderRadioButtonDisplayed("Female"))
					.isTrue();
			soft.assertThat(Person.isnGenderRadioButtonDisplayed("Indeterminate"))
					.isTrue();
			soft.assertThat(Person.isnGenderRadioButtonDisplayed("Unknown"))
					.isTrue();

			if (!Initialization.browserName.equals("android")) {
				logger.info("Step 54 - Confirm that on clicking the 'X' the user is taken out of the'Add person'overlay and the person is not added, the existing page is presented to the user");
				Person.clickonCancelButtononForm();
				soft.assertThat(Person.isAddNewPersonButtonDisplayed()).isTrue();

				Person.clickonAddNewPersonButton();
				Person.clickonPersonTypeCheckbox("client");
				Person.clickonProceedButton();
			}

			logger.info("Step 53 - Confirm that on clicking the 'cancel'button the user is taken out of the'Add person'overlay and the person is not added, the existing page is presented to the user");
			Person.clickonCancelButtononForm();
			soft.assertThat(Person.isAddNewPersonButtonDisplayed()).isTrue();

			logger.info("Step 14 - Fill in the mandatory fields and any non mandatory fields and click on 'save' button");
			Person.AddNewPerson("client", title, forename, middlename, surname,
					byear, bmonth, bday, "Male", ethnicity);

			logger.info("Step 15 - Confirm that a message is displayed as 'Person successfully saved'");
			soft.assertThat(Person.verifyConfirmationMessage()).isEqualTo(
					"Person successfully added");

			logger.info("Step 16 - Confirm that the details entered in Step 14 are correctly displayed in the 'Identification' accordion ");
			soft.assertThat(Person.verifyPersonDetails()).isEqualTo(
					forename + " " + surname);

			logger.info("Step 17 - Confirm that the Person type on the Identification accordion displays type as 'Client, carer or family/household member'");
			soft.assertThat(Person.verifyPersonType()).isEqualTo(
					"Client, carer or family/household member");

			logger.info("Step 18 - Confirm that 'Add' link is displayed to add new person types to a this person ");
			soft.assertThat(Person.isPersonRoleLinkDisplayed("Add")).isTrue();

			logger.info("Step 50 - Confirm that the added person is available in the person's result set");
			String personID = Person.getPersonID();
			Home.clickonHomeLink();
			Home.searchPerson(personID);
			soft.assertThat(Home.getAddedPersonNamefromSearchResult()).isEqualTo(
					forename + " " + surname);

			logger.info("Step 52 - Confirm that on clicking to the 'view person' link, the view person dialog is presented to the user");
			Home.clickonPersonNameLink();
			soft.assertThat(Home.isViewPersonOverlayDisplayed()).isTrue();

			logger.info("Step 37 - Confirm that if the user does not enter the exact date in the 'Day' field, last date of the month entered is considered and displayed by default and Dob is marked as 'estimated' Dob");
			Home.clickonViewPersonCancelButton();
			Person.AddNewPerson("client", title, forename, middlename, surname,
					byear, "", "", "Male", ethnicity);
			soft.assertThat(Person.isEstimatedDOBIconDisplayed()).isTrue();
			
			soft.assertAll();

		}
		
	}

	@Test
	public void AddNewPerson_Test() throws Exception {
		logger.info("Starting inner class execution");
		InnerClass.driver = this.driver;
		InnerClass.logger = this.logger;
		Result runResult = JUnitCore.runClasses(InnerClass.class);
		Login_To_Application.CaptureResults(runResult);
	}

}


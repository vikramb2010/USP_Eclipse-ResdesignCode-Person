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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import com.uspeclipse.commonservices.Constants;
import com.uspeclipse.commonservices.GenericActions;
import com.uspeclipse.commonservices.MultipleBrowser;
import com.uspeclipse.dataprovider.person.AddPersonContact_dataprovider;
import com.uspeclipse.helper.Parallelized;
import com.uspeclipse.interfaces.SmokeTest;
import com.uspeclipse.pageobjects.home.Home_pageobjects;
import com.uspeclipse.pageobjects.person.AddPersonContact_pageobject;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;
import com.uspeclipse.pageobjects.person.SearchPerson_pageobjects;
import com.uspeclipse.setup.Initialization;

@RunWith(Parallelized.class)
@Category(SmokeTest.class)
public class AddPersonContact_TestCaseID2889 {
	private WebDriver driver = null;
	private Initialization Login_To_Application = null;
	private String browsertype = "";
	Logger logger = Logger.getLogger(AddPersonContact_TestCaseID2889.class);

	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}

	public AddPersonContact_TestCaseID2889(String type) {
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

		// Test Case for ID 2889 - To add contact for a person from the person
		// main
		// page
		@Test
		@UseDataProvider(location = AddPersonContact_dataprovider.class, value = "Contacts")
		public void AddPersonContactTest(String type, String title,
				String forename, String middlename, String surname,
				String byear, String bmonth, String bday, String gender,
				String ethnicity, String email, String number)
				throws IOException, NoSuchMethodException, SecurityException,
				InterruptedException {

			SoftAssertions soft = new SoftAssertions();
			GenericActions elements = new GenericActions(driver);
			AddPerson_pageobject addpersonpageobject = PageFactory
					.initElements(driver, AddPerson_pageobject.class);
			Home_pageobjects homepageobject = PageFactory.initElements(driver,
					Home_pageobjects.class);
			SearchPerson_pageobjects searchpersonpageobject = PageFactory
					.initElements(driver, SearchPerson_pageobjects.class);
			AddPersonContact_pageobject addcontactpageobject = PageFactory
					.initElements(driver, AddPersonContact_pageobject.class);

			addpersonpageobject.AddNewPerson(type, title, forename, middlename,
					surname, byear, bmonth, bday, gender, ethnicity);
			String personnamewithID = addpersonpageobject.getPersonName();
			String personID = addpersonpageobject.getPersonID();
			homepageobject.clickonHomeLink();

			logger.info(" Step 2 - Confirm that when the user does a keyword search and selects a person from the auto-suggest drop down he is presented with the core identification details page of that person");
			searchpersonpageobject.enterSearchText(personID);
			homepageobject.clickonAutoSuggestioninSearch();
			String personnamewithid = addpersonpageobject.getPersonName();
			soft.assertThat(addpersonpageobject.getPersonName()).isEqualTo(
					personnamewithID);
			elements.scrollPagetoSpecificPoint("0", "450");
			Thread.sleep(3000);

			logger.info("Step 4 - Confirm that, by default the 'Contacts' panel is in the open state in the core identification page");
			soft.assertThat(addcontactpageobject.verifyContactsPanel("title"))
					.isEqualTo("Click to collapse section");

			logger.info("Step 5 - Confirm that the 'Contact' panel can be closed by the user by clicking on the (^) control at the top right corner of the Contact panel(if needed)");
			addcontactpageobject.clickonContactsLink();
			soft.assertThat(addcontactpageobject.verifyContactsPanel("title"))
					.isEqualTo("Click to expand section");
			addcontactpageobject.clickonContactsLink();

			logger.info("Step 6 - Confirm that a '+add' button exists at the down right corner of the 'Contacts' panel.");
			soft.assertThat(addcontactpageobject.isAddContactsButtonDisplayed())
					.isTrue();

			logger.info("Step 7 - Confirm that on clicking the '+add' button, an 'Add contact' overlay is presented to the user");
			addcontactpageobject.clickonAddContactsButton();
			soft.assertThat(
					addcontactpageobject.isAddContactsOverlayDisplayed())
					.isTrue();

			logger.info("Step 8 - Confirm that following details are displayed in the 'Add contact' overlay: '1. Add contact ( Heading)', '2. You're adding contact for Person name (PER ID)- (As a Narrative text)', '3. Contact (Mandatory) (Drop-down)', '4. Type (Mandatory) (Drop-down)', '5. Usage (Mandatory) (Drop-down)', '6. Detail (Mandatory)', '7. save button (disabled)', '8. cancel button', '9. (x) at top right corner'");
			soft.assertThat(
					addcontactpageobject
							.isAddContactsFormFieldDisplayed("Title")).isTrue();
			soft.assertThat(
					addcontactpageobject
							.isAddContactsFormFieldDisplayed("Narrative"))
					.isTrue();
			soft.assertThat(
					addcontactpageobject
							.isAddContactsFormFieldDisplayed("Contact"))
					.isTrue();
			soft.assertThat(
					addcontactpageobject
							.isAddContactsFormFieldDisplayed("Type")).isTrue();
			soft.assertThat(
					addcontactpageobject
							.isAddContactsFormFieldDisplayed("Cancel"))
					.isTrue();
			soft.assertThat(
					addcontactpageobject
							.isAddContactsFormFieldDisplayed("Close")).isTrue();
			soft.assertThat(
					addcontactpageobject.isAddContactsSaveButtonEnabled())
					.isFalse();
			soft.assertThat(addcontactpageobject.getAddContactsOverlayTitle())
					.isEqualTo("Add contact");
			soft.assertThat(addcontactpageobject.getAddContactsNarrativeText())
					.isEqualTo(
							"You're adding a contact for\n" + personnamewithid);

			logger.info("Step 9 - Confirm that following options are displayed in the 'Contact' drop down: '1. Email', '2. Social Media', '3. Telephone.', '4. Website'");
			soft.assertThat(
					addcontactpageobject.checkDropdownOptions("Contact", Arrays
							.asList("", "Email", "Social Media", "Telephone",
									"Website"))).isTrue();

			logger.info("Step 17 - Confirm that 'Type' is a single select drop down list .e.g.: '1. Emergency', '2. Home', '3. Work'");
			soft.assertThat(
					addcontactpageobject.checkDropdownOptions("Type",
							Arrays.asList("", "Emergency", "Home", "Work")))
					.isTrue();

			logger.info("Step 10 - Confirm that the 'Please choose' option is displayed on the 'Contact;, 'Type', 'Usage' fields when 'add' button is clicked and is not empty");
			soft.assertThat(
					addcontactpageobject.getDefaultDropdownValue("Contact"))
					.isEqualTo("Please choose");
			soft.assertThat(
					addcontactpageobject.getDefaultDropdownValue("Contact"))
					.isNotEmpty();
			soft.assertThat(
					addcontactpageobject.getDefaultDropdownValue("Type"))
					.isEqualTo("Please choose");
			soft.assertThat(
					addcontactpageobject.getDefaultDropdownValue("Type"))
					.isNotEmpty();

			logger.info("Step 11 - Confirm that on selecting the 'Contact' from the drop down, the save button is enabled ");
			logger.info("Step 12 - Confirm that if the 'Contact' is selected as 'Social media' or 'Telephone' another field is displayed on the overlay as 'Social media type' or 'Telephone type' respectively.");
			logger.info("Step 13 - Confirm that the 'Please choose' option is displayed on the 'Social media type' or 'Telephone type' fields when those fields are displayed and is not empty");
			addcontactpageobject.selectOptionfromDropdown("Contact",
					"Social Media");
			soft.assertThat(
					addcontactpageobject
							.isAddContactsFormFieldDisplayed("Social"))
					.isTrue();
			soft.assertThat(
					addcontactpageobject.getDefaultDropdownValue("Social"))
					.isEqualTo("Please choose");
			soft.assertThat(
					addcontactpageobject.getDefaultDropdownValue("Social"))
					.isNotEmpty();
			logger.info("Step 15 - Confirm that the 'Social media type' have following options: '1. Facebook', '2. Other', '3. Twitter");
			soft.assertThat(
					addcontactpageobject.checkDropdownOptions("Social",
							Arrays.asList("", "Facebook", "Other", "Twitter")))
					.isTrue();
			addcontactpageobject.clickonSaveButton();
			soft.assertThat(
					addcontactpageobject
							.isMandatoryErrorMessageDisplayed("Type")).isTrue();
			soft.assertThat(
					addcontactpageobject
							.isMandatoryErrorMessageDisplayed("URL")).isTrue();
			soft.assertThat(
					addcontactpageobject
							.isMandatoryErrorMessageDisplayed("Usage"))
					.isTrue();
			soft.assertThat(
					addcontactpageobject
							.isMandatoryErrorMessageDisplayed("Social"))
					.isTrue();

			soft.assertThat(
					addcontactpageobject.getMandatoryErrorMessage("Type"))
					.isEqualTo("Type is mandatory.");
			soft.assertThat(
					addcontactpageobject.getMandatoryErrorMessage("URL"))
					.isEqualTo("URL is mandatory.");
			soft.assertThat(
					addcontactpageobject.getMandatoryErrorMessage("Usage"))
					.isEqualTo("Usage is mandatory.");
			soft.assertThat(
					addcontactpageobject.getMandatoryErrorMessage("Social"))
					.isEqualTo("Social media type is mandatory.");

			addcontactpageobject.clickonCancelbutton();

			addcontactpageobject.clickonAddContactsButton();
			addcontactpageobject.selectOptionfromDropdown("Contact",
					"Telephone");
			soft.assertThat(
					addcontactpageobject
							.isAddContactsFormFieldDisplayed("Telephone"))
					.isTrue();
			soft.assertThat(
					addcontactpageobject.getDefaultDropdownValue("Telephone"))
					.isEqualTo("Please choose");
			soft.assertThat(
					addcontactpageobject.getDefaultDropdownValue("Telephone"))
					.isNotEmpty();

			logger.info("Confirm that the 'Telephone type' have following options: '1. Fax', '2. Landline', '3. Mobile', '4. Pager', '5. Text phone'");
			soft.assertThat(
					addcontactpageobject.checkDropdownOptions("Telephone",
							Arrays.asList("", "Fax", "Landline", "Mobile",
									"Text phone"))).isTrue();
			addcontactpageobject.clickonSaveButton();
			soft.assertThat(
					addcontactpageobject
							.isMandatoryErrorMessageDisplayed("Type")).isTrue();
			soft.assertThat(
					addcontactpageobject
							.isMandatoryErrorMessageDisplayed("Number"))
					.isTrue();
			soft.assertThat(
					addcontactpageobject
							.isMandatoryErrorMessageDisplayed("Usage"))
					.isTrue();
			soft.assertThat(
					addcontactpageobject
							.isMandatoryErrorMessageDisplayed("Telephone"))
					.isTrue();

			soft.assertThat(
					addcontactpageobject.getMandatoryErrorMessage("Type"))
					.isEqualTo("Type is mandatory.");
			soft.assertThat(
					addcontactpageobject.getMandatoryErrorMessage("Number"))
					.isEqualTo("Number is mandatory.");
			soft.assertThat(
					addcontactpageobject.getMandatoryErrorMessage("Usage"))
					.isEqualTo("Usage is mandatory.");
			soft.assertThat(
					addcontactpageobject.getMandatoryErrorMessage("Telephone"))
					.isEqualTo("Telephone type is mandatory.");

			addcontactpageobject.clickonCancelbutton();

			addcontactpageobject.clickonAddContactsButton();
			addcontactpageobject.selectOptionfromDropdown("Contact", "Email");
			soft.assertThat(
					addcontactpageobject.isAddContactsSaveButtonEnabled())
					.isTrue();
			soft.assertThat(
					addcontactpageobject
							.isAddContactsFormFieldDisplayed("Usage")).isTrue();
			soft.assertThat(
					addcontactpageobject.getDefaultDropdownValue("Usage"))
					.isEqualTo("Please choose");
			soft.assertThat(
					addcontactpageobject.getDefaultDropdownValue("Usage"))
					.isNotEmpty();

			logger.info("Step 18 - Confirm that the'Usage' is a single select drop down list.e.g.: '1. Permanent', '2. Temporary'");
			soft.assertThat(
					addcontactpageobject.checkDropdownOptions("Usage",
							Arrays.asList("", "Permanent", "Temporary")))
					.isTrue();
			addcontactpageobject.clickonSaveButton();
			/*
			 * soft.assertThat(
			 * addcontactpageobject.isMandatoryErrorMessageDisplayed("Type"))
			 * .isTrue();
			 */
			soft.assertThat(
					addcontactpageobject
							.isMandatoryErrorMessageDisplayed("Email"))
					.isTrue();
			/*
			 * soft.assertThat(
			 * addcontactpageobject.isMandatoryErrorMessageDisplayed("Usage"))
			 * .isTrue();
			 */

			/*
			 * soft.assertThat(addcontactpageobject.getMandatoryErrorMessage("Type"
			 * )) .isEqualTo("Type is mandatory.");
			 */
			soft.assertThat(
					addcontactpageobject.getMandatoryErrorMessage("Email"))
					.isEqualTo("Email address is mandatory");
			/*
			 * soft.assertThat(addcontactpageobject.getMandatoryErrorMessage("Usage"
			 * ) ) .isEqualTo("Usage is mandatory.");
			 */

			logger.info("Step 20 - Confirm that if an invalid email address is entered and 'save' is clicked, a validation error message is displayed as, ' Please enter a valid Email address'.");
			addcontactpageobject.enterEmailAddress("test");
			addcontactpageobject.clickonSaveButton();
			soft.assertThat(
					addcontactpageobject.getInvalidEmailAddressMessage())
					.isEqualTo("Please enter a valid Email address");

			addcontactpageobject.clickonCancelbutton();

			addcontactpageobject.clickonAddContactsButton();
			addcontactpageobject.selectOptionfromDropdown("Contact", "Website");
			soft.assertThat(
					addcontactpageobject.isAddContactsFormFieldDisplayed("Web"))
					.isTrue();
			addcontactpageobject.clickonSaveButton();
			/*
			 * soft.assertThat(
			 * addcontactpageobject.isMandatoryErrorMessageDisplayed("Type"))
			 * .isTrue();
			 */
			soft.assertThat(
					addcontactpageobject
							.isMandatoryErrorMessageDisplayed("Web")).isTrue();
			/*
			 * soft.assertThat(
			 * addcontactpageobject.isMandatoryErrorMessageDisplayed("Usage"))
			 * .isTrue();
			 */

			/*
			 * soft.assertThat(addcontactpageobject.getMandatoryErrorMessage("Type"
			 * )) .isEqualTo("Type is mandatory.");
			 */
			soft.assertThat(
					addcontactpageobject.getMandatoryErrorMessage("Web"))
					.isEqualTo("Web address is mandatory");
			/*
			 * soft.assertThat(addcontactpageobject.getMandatoryErrorMessage("Usage"
			 * ) ) .isEqualTo("Usage is mandatory.");
			 */

			addcontactpageobject.clickonCancelbutton();

			logger.info("Step 24 - Confirm that on entering the values in the mandatory fields on the 'Add overlay' and clicking on the 'cancel' button or at the (x) at the top right corner, the contact is not added and the 'core identification page' of that person is displayed to the user");
			addcontactpageobject.AddContacts("Email", "Home", email,
					"Temporary", "", "", "", "", "");
			addcontactpageobject.clickonCancelbutton();
			soft.assertThat(addcontactpageobject.verifyisContactAdded("Email"))
					.isFalse();

			addcontactpageobject.AddContacts("Email", "Home", email,
					"Temporary", "", "", "", "", "");
			addcontactpageobject.clickonClosebutton();
			soft.assertThat(addcontactpageobject.verifyisContactAdded("Email"))
					.isFalse();

			logger.info("Step 22 - Confirm that on entering the values in the mandatory fields on the 'Add overlay' and clicking on the 'save' button, the user should be notified by a success message as, 'Contact successfully added'");
			addcontactpageobject.AddContacts("Email", "Home", email,
					"Temporary", "", "", "", "", "");
			addcontactpageobject.clickonSaveButton();
			soft.assertThat(addpersonpageobject.verifyConfirmationMessage())
					.isEqualTo("Contact successfully added");

			logger.info("Step 23 - Confirm that on entering the values in the mandatory fields on the 'Add overlay' and clicking on the 'save' button,the newly added contact should be displayed on the 'Contact' section of the 'core identification details' page of that person");
			soft.assertThat(addcontactpageobject.verifyisContactAdded("Email"))
					.isTrue();

			addcontactpageobject.AddContacts("Telephone", "Work", "",
					"Temporary", "", "Mobile", "", number, "");
			addcontactpageobject.clickonSaveButton();
			soft.assertThat(addpersonpageobject.verifyConfirmationMessage())
					.isEqualTo("Contact successfully added");
			soft.assertThat(addcontactpageobject.verifyisContactAdded("Email"))
					.isTrue();
			soft.assertAll();
		}

	}

	@Test
	public void AddPersonContact_Test() throws Exception {
		logger.info("Starting inner class execution");
		InnerClass.driver = this.driver;
		InnerClass.logger = this.logger;

		Result runResult = JUnitCore.runClasses(InnerClass.class);
		Login_To_Application.CaptureResults(runResult);
	}

}

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
import com.uspeclipse.dataprovider.person.EditPersonRecord_dataprovider;
import com.uspeclipse.helper.Parallelized;
import com.uspeclipse.interfaces.SmokeTest;
import com.uspeclipse.pageobjects.home.Home_pageobjects;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;
import com.uspeclipse.pageobjects.person.EditPersonRecord_pageobject;
import com.uspeclipse.setup.Initialization;

@RunWith(Parallelized.class)
@Category(SmokeTest.class)
public class EditPersonRecord_TestCaseID2785 {
	private WebDriver driver = null;
	private Initialization Login_To_Application=null;
	private String browsertype="";
	Logger logger = Logger.getLogger(EditPersonRecord_TestCaseID2785.class);

	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}

	public EditPersonRecord_TestCaseID2785(String type) {
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

		// Test Case for ID 2785 - To edit person record
		@Test
		@UseDataProvider(location = EditPersonRecord_dataprovider.class, value = "EditPersondetails")
		public void EditPersonRecordTest(String title, String forename,
				String middlename, String surname, String byear, String bmonth,
				String bday, String ethnicity) throws IOException,
				NoSuchMethodException, SecurityException, InterruptedException {

			SoftAssertions soft = new SoftAssertions();
			
			// Declaration of Page Objects
			Home_pageobjects Home = PageFactory.initElements(driver,
					Home_pageobjects.class);
			EditPersonRecord_pageobject EditPerson = PageFactory.initElements(
					driver, EditPersonRecord_pageobject.class);
			AddPerson_pageobject Person = PageFactory.initElements(driver,
					AddPerson_pageobject.class);

			// Adding a new person with 'Other' as Person Type - Satisfying the
			// prerequisite
			Person.AddNewPerson("other", title, forename, middlename, surname,
					byear, bmonth, bday, "Male", ethnicity);
			String personId = Person.getPersonID();

			// Navigating to Home page for start of the Test Case and searching for
			// the above added person
			Home.clickonHomeLink();
			logger.info("Step 2 - Confirm that when the user selects the desired search result after performing a keyword search either 'By Name or id' or if the user 'switch focus to' desired person from the results set, the core identification details of that person should be presented to the user.'");
			Home.searchPerson(personId);

			// Navigating to Person Detail page
			logger.info("Step 3 - Find a person record with Type 'Other' and switch focus to this person");
			EditPerson.clickonPersonSelectLink();
			EditPerson.clickonSwitchFocustoLink();
			String personnamewithid = Person.getPersonName();

			logger.info("Step 4 - Confirm that the 'Edit' button is displayed on the identification accordion");
			soft.assertThat(EditPerson.isEditPersonDetailsButtonDisplayed())
					.isTrue();

			logger.info("Step 5 - Confirm that 'Change' link is displayed on the Identification accordion as the person type is Other");
			soft.assertThat(Person.isPersonRoleLinkDisplayed("Change")).isTrue();

			logger.info("Step 6 - Confirm that 'Add' link is displayed on the Identification accordion as the person has only type recorded.");
			soft.assertThat(Person.isPersonRoleLinkDisplayed("Add")).isTrue();

			logger.info("Step 7 - Click on 'Change' link to change the type of the person");
			Person.clickonPersonRoleLink("Change");

			logger.info("Step 8 - Confirm that the title of the overlay is 'Edit person'");
			soft.assertThat(EditPerson.getOverlayTitle()).isEqualTo("Edit person");

			logger.info("Step 9 - Confirm that the narrative is 'Which type do you want to change to?''");
			soft.assertThat(EditPerson.getNarrativeTextonChangeRole()).isEqualTo(
					"Which type do you want to change to?");

			logger.info("Step 10 - Confirm that two radio buttons are displayed : 'Client, carer or family/household member (Already checked)', 'Professional'");
			soft.assertThat(EditPerson.isPersonRoleRadioButtonDisplayed("client"))
					.isTrue();
			soft.assertThat(
					EditPerson.isPersonRoleRadioButtonDisplayed("professional"))
					.isTrue();
			soft.assertThat(EditPerson.isPersonRoleClientRadioButtonSelected())
					.isTrue();

			logger.info("Step 11 - Confirm that 'proceed' and 'cancel' buttons are displayed");
			soft.assertThat(EditPerson.isProceedButtonDisplayed()).isTrue();
			soft.assertThat(EditPerson.isCancelButtonDisplayed()).isTrue();

			logger.info("Step 12 - Check the radio button for 'Professional' and click on 'proceed' button");
			EditPerson.clickonPersonRoleRadioButton("professional");
			EditPerson.clickonProceedButton();

			logger.info("Step 13 - Confirm that the title of the overlay 'Edit person'");
			soft.assertThat(EditPerson.getOverlayTitle()).isEqualTo("Edit person");

			logger.info("Step 14 - Confirm that the narrative is 'You're editing the identification details of Name of the person with Person ID'");
			soft.assertThat(EditPerson.getNarrativeTextonEditForm()).isEqualTo(
					"You're editing the identification details of\n"
							+ personnamewithid);

			logger.info("Step 15 - Enter the mandatory fields and any non-mandatory fields and click on 'save' button ");
			EditPerson.editPersonDetails("Mr", forename + "test", middlename
					+ "test", surname + "test", "Carer", "OLM");

			logger.info("Step 16 - Confirm that a message is displayed as 'Person successfully updated'");
			soft.assertThat(Person.verifyConfirmationMessage()).isEqualTo(
					"Person successfully updated");

			logger.info("Step 17 - Confirm that all the person details are now updated on the Person identification accordion");
			String updatedname = Person.verifyPersonDetails();
			soft.assertThat(updatedname).isEqualTo(
					forename + "test" + " " + surname + "test");

			logger.info("Step 18 - Confirm that the Person type is now 'Professional' and not 'Other'");
			soft.assertThat(Person.verifyPersonType()).isEqualTo("Professional");
			String updatedpersonnamewithid = Person.getPersonName();

			logger.info("Step 19 - Click on 'edit' button");
			EditPerson.clickonEditPersonDetailsButton();

			logger.info("Step 20 - Confirm that on clicking on the 'edit' button, the 'Edit Person' overlay is presented to the user.");
			soft.assertThat(EditPerson.isEditPersonOverlayDisplayed()).isTrue();

			logger.info("Step 21 - Confirm that 'Edit Person' is shown as the heading on the overlay.");
			soft.assertThat(EditPerson.getOverlayTitle()).isEqualTo("Edit person");

			logger.info("Step 22 - Confirm that a narrative text is displayed at the top of the overlay as, 'You're editing the Identification details of Person name (PER ID)'.");
			soft.assertThat(EditPerson.getNarrativeTextonEditForm()).isEqualTo(
					"You're editing the identification details of\n"
							+ updatedpersonnamewithid);

			logger.info("Step 23 - Confirm that following fields are available for the user:  1. Title (if provided then populated), 2. Forename (populated), 3. Other forenames (If provided then populated), 4. Surname (populated), 5. Professional title (populated), 6. Organisation (populated), 7. Save button, 8. Cancel button");
			soft.assertThat(EditPerson.isEditPersonFormFieldDisplayed("title"))
					.isTrue();
			soft.assertThat(EditPerson.isEditPersonFormFieldDisplayed("forename"))
					.isTrue();
			soft.assertThat(EditPerson.isEditPersonFormFieldDisplayed("middlename"))
					.isTrue();
			soft.assertThat(EditPerson.isEditPersonFormFieldDisplayed("surname"))
					.isTrue();
			soft.assertThat(EditPerson.isEditPersonFormFieldDisplayed("proftitle"))
					.isTrue();
			soft.assertThat(
					EditPerson.isEditPersonFormFieldDisplayed("organisation"))
					.isTrue();
			soft.assertThat(EditPerson.isEditPersonFormFieldDisplayed("save"))
					.isTrue();
			soft.assertThat(EditPerson.isEditPersonFormFieldDisplayed("cancel"))
					.isTrue();

			logger.info("Step 24 - Change the title of the person");
			logger.info("Step 25 - Change the surname to a different name");
			logger.info("Step 26 - Change the 'Professional title'");
			logger.info("Step 27 - Change the name of the organisation");
			logger.info("Stpe 28 - Click on 'save' button");
			EditPerson.editPersonDetails("Dr", "", "", surname, "GP", "OLMtest");

			logger.info("Step 29 - Confirm that a message is displayed as 'Person successfully updated'");
			soft.assertThat(Person.verifyConfirmationMessage()).isEqualTo(
					"Person successfully updated");

			logger.info("Step 30 - Confirm that all the changes made in Steps 24, 25, 26 and 27 are correctly reflected on Person identification accordion");
			soft.assertThat(Person.verifyPersonDetails()).isEqualTo(
					forename + "test" + " " + surname);
			soft.assertAll();
		}
		
	}

	@Test
	public void EditPersonRecord_Test() throws Exception {
		logger.info("Starting inner class execution");
		InnerClass.driver = this.driver;
		InnerClass.logger = this.logger;
		Result runResult = JUnitCore.runClasses(InnerClass.class);
		Login_To_Application.CaptureResults(runResult);
		
	}

}


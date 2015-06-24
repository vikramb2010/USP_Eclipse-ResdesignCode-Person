package com.uspeclipse.testscripts.person;

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
import com.uspeclipse.dataprovider.person.EditWarning_dataprovider;
import com.uspeclipse.helper.Parallelized;
import com.uspeclipse.interfaces.SmokeTest;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;
import com.uspeclipse.pageobjects.person.EditWarning_pageobjects;
import com.uspeclipse.pageobjects.person.SearchPerson_pageobjects;
import com.uspeclipse.setup.Initialization;

@RunWith(Parallelized.class)
@Category(SmokeTest.class)
public class EditWarningPerson_TestCaseID2940 {
	private WebDriver driver = null;
	private String browsertype = "";
	private Initialization Login_To_Application=null;
	Logger logger = Logger.getLogger(EditWarningPerson_TestCaseID2940.class);

	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}

	public EditWarningPerson_TestCaseID2940(String type) {
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
		@UseDataProvider(location = EditWarning_dataprovider.class, value = "EditWarning")
		public void EditWarning(String title, String forename,
				String middlename, String surname, String byear, String bmonth,
				String bday, String ethnicity, String Warnings, String WarningDetails) throws Exception	{
			
			SoftAssertions soft = new SoftAssertions();
			GenericActions elements = new GenericActions(driver);
			EditWarning_pageobjects EditWarning = PageFactory.initElements(driver, EditWarning_pageobjects.class);
			AddPerson_pageobject Person = PageFactory.initElements(driver, AddPerson_pageobject.class);
			SearchPerson_pageobjects SearchPersonPageObjects = PageFactory.initElements(driver, SearchPerson_pageobjects.class);
			AddPerson_pageobject addpersonpageobject = PageFactory.initElements(driver, AddPerson_pageobject.class);

			addpersonpageobject.AddNewPerson("client", title, forename, middlename,surname, byear, bmonth, bday, "Male", ethnicity);
			logger.debug("New person added with PersonID - " + addpersonpageobject.getPersonID());

			elements.waitForPageLoaded();
			logger.info("Searching for the PersonID from Home Page: "
					+ addpersonpageobject.getPersonID());
			SearchPersonPageObjects.enterSearchText(addpersonpageobject.getPersonID());
			elements.waitForElementFluently(SearchPersonPageObjects.SearchAutocompleteFirstline, 30);
			//SearchPersonPageObjects.SearchAutocompleteFirstline.isDisplayed();
			elements.getElementWithIdentification(SearchPersonPageObjects.SearchAutocompleteFirstline).click();

			logger.info("Navigating to Person Page...");

			// Launching Warning Frame
			Person.clickonAddWarning();
			EditWarning.clearWarning();

			logger.info("Passing Warnings : " + Warnings);
			EditWarning.selectWarnings(Warnings);

			logger.info("Passing Warning Details: " + WarningDetails);
			EditWarning.inputWarningMessage(WarningDetails);
			EditWarning.clickSave();

			logger.info("Verifying the Warnings are updated in person Page...");
			soft.assertThat(Person.verifyConfirmationMessage()).isEqualTo(
					"Warnings successfully updated");

			// Launching Warning Frame from Person page To verify the Warnings
			Person.clickWarningIcon();
			soft.assertThat(
					EditWarning.verifyWarnings(Warnings, WarningDetails))
					.isTrue();

			EditWarning.clickCancel();
			soft.assertAll();
		}

	}

	@Test
	public void EditWarningPerson_Test() throws Exception {
		logger.info("Starting inner class execution");
		InnerClass.driver = this.driver;
		InnerClass.logger = this.logger;
		Result runResult = JUnitCore.runClasses(InnerClass.class);
		Login_To_Application.CaptureResults(runResult);
	}
}

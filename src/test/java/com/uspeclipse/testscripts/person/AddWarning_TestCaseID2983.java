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
import com.uspeclipse.dataprovider.person.AddWarning_dataprovider;
import com.uspeclipse.helper.Parallelized;
import com.uspeclipse.interfaces.SmokeTest;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;
import com.uspeclipse.pageobjects.person.AddWarning_pageobject;
import com.uspeclipse.setup.Initialization;

@RunWith(Parallelized.class)
@Category(SmokeTest.class)
public class AddWarning_TestCaseID2983 {
	private WebDriver driver = null;
	private String browsertype="";
	private Initialization Login_To_Application=null;
	Logger logger = Logger.getLogger(AddWarning_TestCaseID2983.class);

	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}

	public AddWarning_TestCaseID2983(String type) {
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

		// Test Case for ID 2983 - To add a warning for a person
		@Test
		@UseDataProvider(location = AddWarning_dataprovider.class, value = "Warning")
		public void AddWarningTest(String type, String title, String forename,
				String middlename, String surname, String byear, String bmonth,
				String bday, String gender, String ethnicity, String warning)
				throws IOException, NoSuchMethodException, SecurityException,
				InterruptedException {
			SoftAssertions soft = new SoftAssertions();
			AddPerson_pageobject addpersonpageobject = PageFactory.initElements(
					driver, AddPerson_pageobject.class);
			AddWarning_pageobject addwarningpageobject = PageFactory.initElements(
					driver, AddWarning_pageobject.class);

			logger.info("Step 4 - Select [ADD] and add a new person to the system (any name, age, gender and ethnicity) - the user will be transferred to that new person's main page");
			addpersonpageobject.AddNewPerson(type, title, forename, middlename,
					surname, byear, bmonth, bday, gender, ethnicity);
			soft.assertThat(addpersonpageobject.isConfirmationMessageDisplayed())
					.isTrue();

			logger.info("Step 5 - Select [WARNINGS] and add any warning, after [save] confirm that a warnings icon appears by the Person's name in the header part of the Person page");
			addwarningpageobject.clickonAddWarningButton();
			addwarningpageobject.clickonWarningTypeCheckbox();
			addwarningpageobject.enterWarningDetails(warning);
			addwarningpageobject.clickonAddWarningSaveButton();

			soft.assertThat(addwarningpageobject.isWarningIconDisplayed()).isTrue();
			soft.assertAll();
		}
		
	}

	@Test
	public void AddWarning_Test() throws Exception {
		logger.info("Starting inner class execution");
		InnerClass.driver = this.driver;
		InnerClass.logger = this.logger;
		Result runResult = JUnitCore.runClasses(InnerClass.class);
		Login_To_Application.CaptureResults(runResult);
	}

}
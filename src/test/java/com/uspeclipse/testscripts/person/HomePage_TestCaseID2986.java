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
import com.uspeclipse.dataprovider.person.HomePage_dataprovider;
import com.uspeclipse.helper.Parallelized;
import com.uspeclipse.interfaces.SmokeTest;
import com.uspeclipse.pageobjects.groups.Groups_pageobjects;
import com.uspeclipse.pageobjects.home.Home_pageobjects;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;
import com.uspeclipse.pageobjects.person.SearchPerson_pageobjects;
import com.uspeclipse.setup.Initialization;

@RunWith(Parallelized.class)
@Category(SmokeTest.class)
public class HomePage_TestCaseID2986 {
	private WebDriver driver = null;
	private Initialization Login_To_Application=null;
	private String browsertype="";
	Logger logger = Logger
			.getLogger(HomePage_TestCaseID2986.class);

	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}

	public HomePage_TestCaseID2986(String type) {
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

		// Test Case for ID 2986 - Home page - To search for and ADD persons
		@Test
		@UseDataProvider(location = HomePage_dataprovider.class, value = "Home")
		public void HomePageTest(String type, String title, String forename,
				String middlename, String surname, String byear, String bmonth,
				String bday, String gender, String ethnicity, String groupname,
				String groupdesc) throws IOException, NoSuchMethodException,
				SecurityException, InterruptedException {

			SoftAssertions soft = new SoftAssertions();
			
			AddPerson_pageobject addpersonpageobject = PageFactory.initElements(
					driver, AddPerson_pageobject.class);
			Home_pageobjects homepageobject = PageFactory.initElements(driver,
					Home_pageobjects.class);
			SearchPerson_pageobjects searchpersonpageobject = PageFactory
					.initElements(driver, SearchPerson_pageobjects.class);
			Groups_pageobjects grouppageobject = PageFactory.initElements(driver,
					Groups_pageobjects.class);

			logger.info("Step 2 - Log on to USP as a user that meets its precondition and confirm that the 'Home' page is correctly presented and that there is a person search box at the top of the page and the standard [ADD] button (for adding a person to the system) at the top r-h corner");
			soft.assertThat(homepageobject.isHomeLinkDisplayed()).isTrue();
			soft.assertThat(homepageobject.isPersonSearchTextBoxDisplayed())
					.isTrue();
			soft.assertThat(addpersonpageobject.isAddNewPersonButtonDisplayed())
					.isTrue();

			logger.info("Step 3 - Confirm that the [ADD] button, when hovered over, displays 'Add person'");
			soft.assertThat(addpersonpageobject.getAddPersonToolTipText("title"))
					.isEqualTo("Add person");

			logger.info("Step 4 - Select [ADD] and confirm that the 'Add person' overlay is presented - then select [cancel] to exit from the overlay");
			addpersonpageobject.clickonAddNewPersonButton();
			soft.assertThat(addpersonpageobject.isAddNewPersonOverlayDisplayed())
					.isTrue();
			addpersonpageobject.clickCancelOnFirstAddOverlay();

			logger.info("Step 5 - In the person search box, enter a criterion that will return results (e.g. either 'per' to return everyone or 'smi' to return 'smith' and variants) and confirm");
			searchpersonpageobject.enterSearchText("PER");
			soft.assertThat(homepageobject.verifyAutoSuggestionList()).isTrue();

			addpersonpageobject.AddNewPerson(type, title, forename, middlename,
					surname, byear, bmonth, bday, gender, ethnicity);
			homepageobject.clickonGroupLink();
			grouppageobject.clickonAddgroupButton();
			grouppageobject.enterGroupname(groupname);
			grouppageobject.enterGroupDescription(groupdesc);
			grouppageobject.SelectValueFromGroupTypeDropdownbox("Family");
			grouppageobject.clickonSaveGroupButton();
			homepageobject.clickonHomeLink();
			searchpersonpageobject.enterSearchText(forename);
			soft.assertThat(homepageobject.verifyAutoSuggestionList1(forename))
					.isTrue();
			String personID = homepageobject.getPersonIDfromAutoSuggestion();
			homepageobject.clickonAutoSuggestioninSearch();
			soft.assertThat(addpersonpageobject.getPersonID()).contains(personID);
			homepageobject.clickonHomeLink();
			searchpersonpageobject.enterSearchText(forename);
			homepageobject.clickonSearchPersonGlobalButton();
			soft.assertThat(homepageobject.getSearchResultPageTitle()).contains(
					"Search results");
			soft.assertThat(homepageobject.isBackToHomeLinkDisplayed()).isTrue();

			logger.info("Step 6 - In the person search box, search for any existing, active group and confirm that no results are returned");
			searchpersonpageobject.enterSearchText(groupname);
			soft.assertThat(homepageobject.isAutoSuggestionDisplayed()).isFalse();
			homepageobject.clickonSearchPersonGlobalButton();
			soft.assertThat(homepageobject.isSearchResultPageHeaderDisplayed())
					.isTrue();
			soft.assertThat(homepageobject.getSearchResultTextinHeader())
					.isEqualTo(
							"Your search for '" + groupname
									+ "' returned 0 record(s)");
			soft.assertAll();
		}
		
	}

	@Test
	public void HomePage_Test() throws Exception {
		logger.info("Starting inner class execution");
		InnerClass.driver = this.driver;
		InnerClass.logger = this.logger;
		Result runResult = JUnitCore.runClasses(InnerClass.class);
		Login_To_Application.CaptureResults(runResult);
	}

}


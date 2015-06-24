package com.uspeclipse.testscripts.casenotes;

import java.awt.AWTException;
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

import com.uspeclipse.commonservices.Constants;
import com.uspeclipse.commonservices.MultipleBrowser;
import com.uspeclipse.helper.Parallelized;
import com.uspeclipse.interfaces.SmokeTest;
import com.uspeclipse.pageobjects.casenotes.SourceFilter_pageobject;
import com.uspeclipse.pageobjects.home.Home_pageobjects;
import com.uspeclipse.pageobjects.login.EclipseLogin_pageobject;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;
import com.uspeclipse.pageobjects.person.SearchPerson_pageobjects;
import com.uspeclipse.setup.Initialization;

@RunWith(Parallelized.class)
@Category(SmokeTest.class)
public class SourceFilterScenario1_TestCaseID32973 {
	private WebDriver driver = null;
	private String browsertype = "";
	private Initialization Login_To_Application = null;
	Logger logger = Logger
			.getLogger(SourceFilterScenario1_TestCaseID32973.class);

	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}

	public SourceFilterScenario1_TestCaseID32973(String type) {
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
		driver.close();
		driver.quit();
	}

	// @RunWith(DataProviderRunner.class)
	public static class InnerClass {
		static WebDriver driver = null;
		static Logger logger = null;

		// Test Case for ID 32973 - to apply a set of Source filters to reduce
		// the
		// number of entries shown in the Case Notes Record to only those of the
		// selected Source
		@Test
		// @UseDataProvider(location = AddNewPerson_dataprovider.class, value =
		// "PersonDetails")
		public void SourceFilterScenario1Test() throws IOException,
				NoSuchMethodException, SecurityException, InterruptedException,
				AWTException {

			SoftAssertions soft = new SoftAssertions();
			Home_pageobjects homepageobject = PageFactory.initElements(driver,
					Home_pageobjects.class);
			SearchPerson_pageobjects searchpageobject = PageFactory
					.initElements(driver, SearchPerson_pageobjects.class);
			AddPerson_pageobject addpersonpageobject = PageFactory
					.initElements(driver, AddPerson_pageobject.class);
			SourceFilter_pageobject srcfilterpageobject = PageFactory
					.initElements(driver, SourceFilter_pageobject.class);
			EclipseLogin_pageobject eclipse_pageobject = PageFactory
					.initElements(driver, EclipseLogin_pageobject.class);

			logger.info("Step 2 - Select a client from either the 'Your recently accessed records' list or the 'Your case load' list or search for a client from the quick person search at the top of the screen");
			searchpageobject.enterSearchText("James Bean");
			String personID = homepageobject.getPersonIDfromAutoSuggestion();
			homepageobject.clickonAutoSuggestioninSearch();
			String personid = addpersonpageobject.getPersonID();
			soft.assertThat(personid)
					.as("Page Opened for Person is same as the Person Selected from AutoSuggestion")
					.isEqualTo(personID);

			logger.info("Step 3 - Click on Case Notes Menu item");
			homepageobject.clickonCasenoteLink();

			soft.assertThat(
					srcfilterpageobject.isColumnHeaderDisplayed("Entry Date"))
					.as("Entry Date Column Table header should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject.isColumnHeaderDisplayed("Entry"))
					.as("Entry Column Table header should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject.isColumnHeaderDisplayed("Entry Type"))
					.as("Entry Type Column Table header should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject.isColumnHeaderDisplayed("Impact"))
					.as("Impact Column Table header should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject.isColumnHeaderDisplayed("Source"))
					.as("Source Column Table header should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject.isColumnHeaderDisplayed("Practitioner"))
					.as("Practitioner Column Table header should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject.isColumnHeaderDisplayed("Status"))
					.as("Status Column Table header should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject.isColumnHeaderDisplayed("Actions"))
					.as("Actions Column Table header should be Displayed")
					.isTrue();

			logger.info("Step 4 - Click on the Filter button.");
			srcfilterpageobject.clickonSourceFilterButton();
			soft.assertThat(srcfilterpageobject.isFilterByTabDisplayed("Date"))
					.as("Date Filter Tab should be Displayed").isTrue();
			soft.assertThat(
					srcfilterpageobject.isFilterByTabDisplayed("People"))
					.as("People Filter Tab should be Displayed").isTrue();
			soft.assertThat(srcfilterpageobject.isFilterByTabDisplayed("Type"))
					.as("Type annd other Filter Tab should be Displayed")
					.isTrue();
			soft.assertThat(srcfilterpageobject.isFilterByTabDisplayed("Group"))
					.as("Group Filter Tab should be Displayed").isTrue();

			int records = srcfilterpageobject
					.getNumberofRecordsforSourceFilterSelection();
			System.out.println(records);

			logger.info("Step 5 - Click on People Tab");
			srcfilterpageobject.clickonPeopleTabinFilterBy();
			srcfilterpageobject.clickonFilterResetLink();
			Thread.sleep(5000);
			String[] Option = srcfilterpageobject
					.storeTextofOptionsfromSourceFilterMultiSelectBox();
			String numberofoptions = srcfilterpageobject
					.getNumberofOptionsfromSourceFilterMultiSelectBox();
			int lastoption = Integer.parseInt(numberofoptions);

			logger.info("Step 6 - Select Not specified from the Source filter");
			srcfilterpageobject
					.selectOptionsbyTextFromSourceFilterMultiSelectBox("Not specified");
			soft.assertThat(
					srcfilterpageobject.isFilterIconinPeopleTabDisplayed())
					.as("Filter Icon in People Tab should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject
							.isSourceFilterSelectedIndicatorDisplayed())
					.as("Source Filter Selection Indicator in Active Filter should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject.isResetAllFiltersLinkDisplayed())
					.as("Reset All Link in Active Filter should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject
							.isResultforSingleSourceSelectionCorrect(""))
					.as("Only Source with Not Specified Option should be displayed")
					.isTrue();

			logger.info("Step 7 - Remove the filter selection using any of the available methods.");
			srcfilterpageobject.clickonSourceFilterRemoveButton();
			soft.assertThat(
					srcfilterpageobject
							.isSourceFilterSelectedIndicatorDisplayed())
					.as("Source Filter Selection Indicator in Active Filter should not be Displayed")
					.isFalse();
			soft.assertThat(
					srcfilterpageobject
							.getNumberofRecordsforSourceFilterSelection())
					.as("Numbers of Records should match 7").isEqualTo(records);

			logger.info("Step 9 - Click the first named Source in the Source Filter");
			srcfilterpageobject
					.selectOptionsbyNumberFromSourceFilterMultiSelectBox("1");

			soft.assertThat(
					srcfilterpageobject
							.isSourceFilterSelectedIndicatorDisplayed())
					.as("Source Filter Selection Indicator in Active Filter should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject.isResetAllFiltersLinkDisplayed())
					.as("Reset All Link in Active Filter should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject
							.isResultforSingleSourceSelectionCorrect(Option[1]))
					.as("Only Source with 1" + Option[1]
							+ " Option should be displayed").isTrue();

			logger.info("Step 10 - Remove the filter selection using any of the available methods.");
			srcfilterpageobject.clickonSourceFilterRemoveButton();
			soft.assertThat(
					srcfilterpageobject
							.isSourceFilterSelectedIndicatorDisplayed())
					.as("Source Filter Selection Indicator in Active Filter should not be Displayed")
					.isFalse();
			soft.assertThat(
					srcfilterpageobject
							.getNumberofRecordsforSourceFilterSelection())
					.as("Numbers of Records should match 10")
					.isEqualTo(records);

			logger.info("Step 11 - Click the last named Source in the Source Filter");
			srcfilterpageobject
					.selectOptionsbyNumberFromSourceFilterMultiSelectBox(numberofoptions);
			soft.assertThat(
					srcfilterpageobject
							.isSourceFilterSelectedIndicatorDisplayed())
					.as("Source Filter Selection Indicator in Active Filter should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject.isResetAllFiltersLinkDisplayed())
					.as("Reset All Link in Active Filter should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject
							.isResultforSingleSourceSelectionCorrect(Option[lastoption]))
					.as("Only Source with Last" + lastoption
							+ " Option should be displayed").isTrue();

			logger.info("Step 12 - Remove the filter selection using any of the available methods.");
			srcfilterpageobject.clickonSourceFilterRemoveButton();
			soft.assertThat(
					srcfilterpageobject
							.isSourceFilterSelectedIndicatorDisplayed())
					.as("Source Filter Selection Indicator in Active Filter should not be Displayed")
					.isFalse();
			soft.assertThat(
					srcfilterpageobject
							.getNumberofRecordsforSourceFilterSelection())
					.as("Numbers of Records should match 12")
					.isEqualTo(records);

			logger.info("Step 13 - Click any named Source (not the first or last) in the Source Filter");
			srcfilterpageobject
					.selectOptionsbyNumberFromSourceFilterMultiSelectBox("2");
			soft.assertThat(
					srcfilterpageobject
							.isSourceFilterSelectedIndicatorDisplayed())
					.as("Source Filter Selection Indicator in Active Filter should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject.isResetAllFiltersLinkDisplayed())
					.as("Reset All Link in Active Filter should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject
							.isResultforSingleSourceSelectionCorrect(Option[2]))
					.as("Only Source with 2" + Option[2]
							+ " Option should be displayed").isTrue();

			logger.info("Step 14 - Remove the filter selection using any of the available methods.");
			srcfilterpageobject.clickonSourceFilterRemoveButton();
			soft.assertThat(
					srcfilterpageobject
							.isSourceFilterSelectedIndicatorDisplayed())
					.as("Source Filter Selection Indicator in Active Filter should not be Displayed")
					.isFalse();
			soft.assertThat(
					srcfilterpageobject
							.getNumberofRecordsforSourceFilterSelection())
					.as("Numbers of Records should match 14")
					.isEqualTo(records);

			logger.info("Step 15 - Select all Sources from the Source Filter (Hold down the <ctrl> while selecting Sources)");
			srcfilterpageobject
					.selectAllOptionsFromSourceFilterMultiSelectBox();
			soft.assertThat(
					srcfilterpageobject
							.isSourceFilterSelectedIndicatorDisplayed())
					.as("Source Filter Selection Indicator in Active Filter should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject.isResetAllFiltersLinkDisplayed())
					.as("Reset All Link in Active Filter should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject
							.getNumberofRecordsforSourceFilterSelection())
					.as("Numbers of Records should match 15")
					.isEqualTo(records);

			logger.info("Step 16 - Remove the filter selection using any of the available methods.");
			srcfilterpageobject.clickonSourceFilterRemoveButton();
			soft.assertThat(
					srcfilterpageobject
							.isSourceFilterSelectedIndicatorDisplayed())
					.as("Source Filter Selection Indicator in Active Filter should not be Displayed")
					.isFalse();
			soft.assertThat(
					srcfilterpageobject
							.getNumberofRecordsforSourceFilterSelection())
					.as("Numbers of Records should match 16")
					.isEqualTo(records);

			logger.info("Step 17 - Select the first & last named Source from the Source Filter (Hold down the <ctrl> while selecting Sources)");
			srcfilterpageobject
					.selectOptionsbyNumberFromSourceFilterMultiSelectBox("1,"
							+ numberofoptions);
			soft.assertThat(
					srcfilterpageobject
							.isSourceFilterSelectedIndicatorDisplayed())
					.as("Source Filter Selection Indicator in Active Filter should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject.isResetAllFiltersLinkDisplayed())
					.as("Reset All Link in Active Filter should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject
							.isResultforDoubleSourceSelectionCorrect(Option[1],
									Option[lastoption]))
					.as("Only Source with " + Option[1] + " and " + lastoption
							+ " Option should be displayed").isTrue();

			logger.info("Step 18 - Remove the filter selection using any of the available methods.");
			srcfilterpageobject.clickonSourceFilterRemoveButton();
			soft.assertThat(
					srcfilterpageobject
							.isSourceFilterSelectedIndicatorDisplayed())
					.as("Source Filter Selection Indicator in Active Filter should not be Displayed")
					.isFalse();
			soft.assertThat(
					srcfilterpageobject
							.getNumberofRecordsforSourceFilterSelection())
					.as("Numbers of Records should match 18")
					.isEqualTo(records);

			logger.info("Step 19 - Select Not specified & first named Source from the Source Filter (Hold down the <ctrl> while selecting Sources)");
			srcfilterpageobject
					.selectOptionsbyNumberFromSourceFilterMultiSelectBox("0,1");
			soft.assertThat(
					srcfilterpageobject
							.isSourceFilterSelectedIndicatorDisplayed())
					.as("Source Filter Selection Indicator in Active Filter should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject.isResetAllFiltersLinkDisplayed())
					.as("Reset All Link in Active Filter should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject
							.isResultforDoubleSourceSelectionCorrect("",
									Option[1]))
					.as("Only Source with Not Specified and " + Option[1]
							+ " Option should be displayed").isTrue();

			logger.info("Step 20 - Remove the filter selection using any of the available methods.");
			srcfilterpageobject.clickonSourceFilterRemoveButton();
			soft.assertThat(
					srcfilterpageobject
							.isSourceFilterSelectedIndicatorDisplayed())
					.as("Source Filter Selection Indicator in Active Filter should not be Displayed")
					.isFalse();
			soft.assertThat(
					srcfilterpageobject
							.getNumberofRecordsforSourceFilterSelection())
					.as("Numbers of Records should match 20")
					.isEqualTo(records);

			logger.info("Step 21 - Select Not specified & last named Source from the Source Filter (Hold down the <ctrl> while selecting Sources)");
			srcfilterpageobject
					.selectOptionsbyNumberFromSourceFilterMultiSelectBox("0,"
							+ numberofoptions);
			soft.assertThat(
					srcfilterpageobject
							.isSourceFilterSelectedIndicatorDisplayed())
					.as("Source Filter Selection Indicator in Active Filter should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject.isResetAllFiltersLinkDisplayed())
					.as("Reset All Link in Active Filter should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject
							.isResultforDoubleSourceSelectionCorrect("",
									Option[lastoption]))
					.as("Only Source with Not Specified and "
							+ Option[lastoption]
							+ " Option should be displayed").isTrue();

			logger.info("Step 22 - Remove the filter selection using any of the available methods.");
			srcfilterpageobject.clickonSourceFilterRemoveButton();
			soft.assertThat(
					srcfilterpageobject
							.isSourceFilterSelectedIndicatorDisplayed())
					.as("Source Filter Selection Indicator in Active Filter should not be Displayed")
					.isFalse();
			soft.assertThat(
					srcfilterpageobject
							.getNumberofRecordsforSourceFilterSelection())
					.as("Numbers of Records should match 22")
					.isEqualTo(records);

			logger.info("Step 23 - For the above 'Double Source Selection' tests replace the first/last named Source for any from within the displayed list. (Hold down the <ctrl> while selecting Sources)");
			srcfilterpageobject
					.selectOptionsbyNumberFromSourceFilterMultiSelectBox("2,3");
			soft.assertThat(
					srcfilterpageobject
							.isSourceFilterSelectedIndicatorDisplayed())
					.as("Source Filter Selection Indicator in Active Filter should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject.isResetAllFiltersLinkDisplayed())
					.as("Reset All Link in Active Filter should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject
							.isResultforDoubleSourceSelectionCorrect(Option[2],
									Option[3]))
					.as("Only Source with " + Option[2] + " and " + Option[3]
							+ " Option should be displayed").isTrue();

			logger.info("Step 24 - Remove the filter selection using any of the available methods.");
			srcfilterpageobject.clickonSourceFilterRemoveButton();
			soft.assertThat(
					srcfilterpageobject
							.isSourceFilterSelectedIndicatorDisplayed())
					.as("Source Filter Selection Indicator in Active Filter should not be Displayed")
					.isFalse();
			soft.assertThat(
					srcfilterpageobject
							.getNumberofRecordsforSourceFilterSelection())
					.as("Numbers of Records should match 24")
					.isEqualTo(records);

			logger.info("Step 25 - Select  'Not specified', the first named Source and the last named Source from the Source filter (Hold down the <ctrl> while selecting Sources)");
			srcfilterpageobject
					.selectOptionsbyNumberFromSourceFilterMultiSelectBox("0,1,"
							+ numberofoptions);
			soft.assertThat(
					srcfilterpageobject
							.isSourceFilterSelectedIndicatorDisplayed())
					.as("Source Filter Selection Indicator in Active Filter should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject.isResetAllFiltersLinkDisplayed())
					.as("Reset All Link in Active Filter should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject
							.isResultforTripleSourceSelectionCorrect("",
									Option[1], Option[lastoption]))
					.as("Only Source with Not Specified, " + Option[1]
							+ " and " + Option[lastoption]
							+ " Option should be displayed").isTrue();

			logger.info("Step 26 - Remove the filter selection using any of the available methods.");
			srcfilterpageobject.clickonSourceFilterRemoveButton();
			soft.assertThat(
					srcfilterpageobject
							.isSourceFilterSelectedIndicatorDisplayed())
					.as("Source Filter Selection Indicator in Active Filter should not be Displayed")
					.isFalse();
			soft.assertThat(
					srcfilterpageobject
							.getNumberofRecordsforSourceFilterSelection())
					.as("Numbers of Records should match 26")
					.isEqualTo(records);

			logger.info("Step 27 - For the above 'Multiple Source Selection' tests replace the first and/or last named Source with any from within the displayed list. (Hold down the <ctrl> while selecting Sources)");
			srcfilterpageobject
					.selectOptionsbyNumberFromSourceFilterMultiSelectBox("0,2,3");
			soft.assertThat(
					srcfilterpageobject
							.isSourceFilterSelectedIndicatorDisplayed())
					.as("Source Filter Selection Indicator in Active Filter should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject.isResetAllFiltersLinkDisplayed())
					.as("Reset All Link in Active Filter should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject
							.isResultforTripleSourceSelectionCorrect("",
									Option[2], Option[3]))
					.as("Only Source with Not Specified, " + Option[2]
							+ " and " + Option[3]
							+ " Option should be displayed").isTrue();

			logger.info("Step 28 - Remove the filter selection using any of the available methods.");
			srcfilterpageobject.clickonSourceFilterRemoveButton();
			soft.assertThat(
					srcfilterpageobject
							.isSourceFilterSelectedIndicatorDisplayed())
					.as("Source Filter Selection Indicator in Active Filter should not be Displayed")
					.isFalse();
			soft.assertThat(
					srcfilterpageobject
							.getNumberofRecordsforSourceFilterSelection())
					.as("Numbers of Records should match 28")
					.isEqualTo(records);

			logger.info("Step 29 - Select the first named source, the last named source and two other source names from the Source Filter (Hold down the <ctrl> while selecting Sources)");
			srcfilterpageobject
					.selectOptionsbyNumberFromSourceFilterMultiSelectBox("1,2,3,"
							+ numberofoptions);
			soft.assertThat(
					srcfilterpageobject
							.isSourceFilterSelectedIndicatorDisplayed())
					.as("Source Filter Selection Indicator in Active Filter should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject.isResetAllFiltersLinkDisplayed())
					.as("Reset All Link in Active Filter should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject
							.isResultforMultipleSourceSelectionCorrect(
									Option[1], Option[2], Option[3],
									Option[lastoption]))
					.as("Only Source with " + Option[1] + ", " + Option[2]
							+ ", " + Option[3] + " and " + Option[lastoption]
							+ " Option should be displayed").isTrue();

			logger.info("Step 30 - Remove the filter selection using any of the available methods.");
			srcfilterpageobject.clickonSourceFilterRemoveButton();
			soft.assertThat(
					srcfilterpageobject
							.isSourceFilterSelectedIndicatorDisplayed())
					.as("Source Filter Selection Indicator in Active Filter should not be Displayed")
					.isFalse();
			soft.assertThat(
					srcfilterpageobject
							.getNumberofRecordsforSourceFilterSelection())
					.as("Numbers of Records should match 30")
					.isEqualTo(records);

			logger.info("Step 31 - Select four named sources (not the first or last named sources ) from the Source Filter (Hold down the <ctrl> while selecting Sources)");
			srcfilterpageobject
					.selectOptionsbyNumberFromSourceFilterMultiSelectBox("2,3,4,5");
			soft.assertThat(
					srcfilterpageobject
							.isSourceFilterSelectedIndicatorDisplayed())
					.as("Source Filter Selection Indicator in Active Filter should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject.isResetAllFiltersLinkDisplayed())
					.as("Reset All Link in Active Filter should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject
							.isResultforMultipleSourceSelectionCorrect(
									Option[2], Option[3], Option[4], Option[5]))
					.as("Only Source with " + Option[2] + ", " + Option[3]
							+ ", " + Option[4] + " and " + Option[5]
							+ " Option should be displayed").isTrue();

			logger.info("Step 32 - Remove the filter selection using any of the available methods.");
			srcfilterpageobject.clickonSourceFilterRemoveButton();
			soft.assertThat(
					srcfilterpageobject
							.isSourceFilterSelectedIndicatorDisplayed())
					.as("Source Filter Selection Indicator in Active Filter should not be Displayed")
					.isFalse();
			soft.assertThat(
					srcfilterpageobject
							.getNumberofRecordsforSourceFilterSelection())
					.as("Numbers of Records should match 32")
					.isEqualTo(records);

			logger.info("Step 35 - Select every Source from the Source Filter except the 'Not Specified' Source (Hold down the <ctrl> while selecting Sources)");
			srcfilterpageobject
					.selectAllOptionsFromSourceFilterMultiSelectBox1();
			soft.assertThat(
					srcfilterpageobject
							.isSourceFilterSelectedIndicatorDisplayed())
					.as("Source Filter Selection Indicator in Active Filter should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject.isResetAllFiltersLinkDisplayed())
					.as("Reset All Link in Active Filter should be Displayed")
					.isTrue();
			soft.assertThat(
					srcfilterpageobject.isResultforAllSourceSelectionCorrect())
					.as("Source with Not Specified should not be Displayed")
					.isTrue();

			logger.info("Step 36 - Remove the filter selection using any of the available methods.");
			srcfilterpageobject.clickonSourceFilterRemoveButton();
			soft.assertThat(
					srcfilterpageobject
							.isSourceFilterSelectedIndicatorDisplayed())
					.as("Source Filter Selection Indicator in Active Filter should not be Displayed")
					.isFalse();
			soft.assertThat(
					srcfilterpageobject
							.getNumberofRecordsforSourceFilterSelection())
					.as("Numbers of Records should match 36")
					.isEqualTo(records);

			logger.info("Step 37 - Click on Logout");
			eclipse_pageobject.EclipseLogout();

			soft.assertAll();
		}
	}

	@Test
	public void SourceFilterScenario1_Test() throws Exception {
		logger.info("Starting inner class execution");
		InnerClass.driver = this.driver;
		InnerClass.logger = this.logger;
		Result runResult = JUnitCore.runClasses(InnerClass.class);
		Login_To_Application.CaptureResults(runResult);
	}
}

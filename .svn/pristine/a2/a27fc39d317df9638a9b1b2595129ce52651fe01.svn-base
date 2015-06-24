package com.uspeclipse.testscripts.casenotes;
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
import com.uspeclipse.dataprovider.person.AddNewPerson_dataprovider;
import com.uspeclipse.helper.Parallelized;
import com.uspeclipse.interfaces.SmokeTest;
import com.uspeclipse.pageobjects.casenotes.DateFilter_pageobject;
import com.uspeclipse.pageobjects.casenotes.SourceFilter_pageobject;
import com.uspeclipse.pageobjects.home.Home_pageobjects;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;
import com.uspeclipse.pageobjects.person.SearchPerson_pageobjects;
import com.uspeclipse.setup.Initialization;

@RunWith(Parallelized.class)
@Category(SmokeTest.class)
public class DateFilterScenario2_TestCaseID35650 {
	private WebDriver driver = null;
	private String browsertype = "";
	private Initialization Login_To_Application=null;
	Logger logger = Logger.getLogger(DateFilterScenario2_TestCaseID35650.class);

	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}

	public DateFilterScenario2_TestCaseID35650(String type) {
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

	@RunWith(DataProviderRunner.class)
	public static class InnerClass {
		static WebDriver driver = null;
		static Logger logger = null;

		
		//Test Case for ID 35650 Scenario 2 -  date filter
		
			@Test
			@UseDataProvider(location = AddNewPerson_dataprovider.class, value = "PersonDetails")
			public void SourceFilterScenario2Test(String title, String forename,
					String middlename, String surname, String byear, String bmonth,
					String bday, String ethnicity) throws Exception {
				GenericActions elements = new GenericActions(driver);
				SoftAssertions soft = new SoftAssertions();
				Home_pageobjects homepageobject = PageFactory.initElements(driver,
						Home_pageobjects.class);
				SearchPerson_pageobjects searchpageobject = PageFactory.initElements(
						driver, SearchPerson_pageobjects.class);
				AddPerson_pageobject addpersonpageobject = PageFactory.initElements(
						driver, AddPerson_pageobject.class);
				DateFilter_pageobject datefilter_pageobject = PageFactory.initElements(driver, DateFilter_pageobject.class);
				SourceFilter_pageobject sourcefilter_pageobject = PageFactory.initElements(driver, SourceFilter_pageobject.class);
			

				//login.eclipseLogout(MultipleBrowser.driver);
				//login.eclipseLogin(MultipleBrowser.driver, "lance", "PASS#123");

				addpersonpageobject.AddNewPerson("client", title, forename, middlename,	surname, byear, bmonth, bday, "Male", ethnicity);
				String personid = addpersonpageobject.getPersonID();

				logger.info("Select a client from either the 'Your recently accessed records' list or the 'Your case load' list or search for a client from the quick person search at the top of the screen");
				searchpageobject.enterSearchText(personid);
				String personID = homepageobject.getPersonIDfromAutoSuggestion();
				homepageobject.clickonAutoSuggestioninSearch();
				soft.assertThat(personid).as("Page Opened for Person is same as the Person Selected from AutoSuggestion").isEqualTo(personID);

				logger.info("Click on Case Notes Menu item");
				homepageobject.clickonCasenoteLink();

				logger.info("Case Note screen opens showing Case Notes for the selected subject");
				soft.assertThat(datefilter_pageobject.isCaseNotesPageLoaded()).as("Verify if case notes page loaded").isTrue();
				
				logger.info("User clicks on Filter button");
				elements.getElementWithIdentification(sourcefilter_pageobject.FilterButton).click();
				
				logger.info("Filter dialogue opens");
				soft.assertThat(sourcefilter_pageobject.isFilterByFormDisplayed()).as("Verify if filter by form is open").isTrue();
				
				logger.info("User clicks on the Date tab");
				elements.getElementWithIdentification(sourcefilter_pageobject.FilterByDateTab).click();
				
				logger.info("Date filters are shown");
				soft.assertThat(datefilter_pageobject.isDateFilterPanelVisible()).as("verify if date filter panel is visible").isTrue();
				
				
				logger.info("In the Date from field enter 10-may-2014 and press tab");
				logger.info("10-may-2014 should be accepted as a valid date");	
				logger.info("Clear the date in the Date from field");
				logger.info("Date is removed");
				datefilter_pageobject.enterDateFromWithTab("10-may-2014");
				soft.assertThat(datefilter_pageobject.isDateFromValid()).as("verify 10-may-2014 should be accepted as a valid date").isTrue();
				datefilter_pageobject.clearDateFromField();
				soft.assertThat(elements.getElementWithIdentification(datefilter_pageobject.DateFromFilter).getText()).as("verify date is removed").isEqualTo("");
				
				
				logger.info("In the Date to field enter 10-may-2014 and press tab");
				logger.info("10-may-2014 should be accepted as a valid date");	
				logger.info("Clear the date in the Date to field");
				logger.info("Date is removed");
				datefilter_pageobject.enterDateToWithTab("10-may-2014");
				soft.assertThat(datefilter_pageobject.isDateToValid()).as("verify 10-may-2014 should be accepted as a valid date").isTrue();
				datefilter_pageobject.clearDateToField();
				soft.assertThat(elements.getElementWithIdentification(datefilter_pageobject.DateToFilter).getText()).as("verify date is removed").isEqualTo("");
				
				
				logger.info("In the Date from field enter -1-may-2014 and press tab");
				logger.info("Date should be rejected as Invalid date");	
				logger.info("Clear the date in the Date from field");
				logger.info("Date is removed");
				datefilter_pageobject.enterDateFromWithTab("-1-may-2014");
				soft.assertThat(datefilter_pageobject.isDateInvalid()).as("verify -1-may-2014 should be rejected as invalid date").isTrue();
				datefilter_pageobject.clearDateFromField();
				soft.assertThat(elements.getElementWithIdentification(datefilter_pageobject.DateFromFilter).getText()).as("verify date is removed").isEqualTo("");
				
				
				logger.info("In the Date to field enter -1-may-2014 and press tab");
				logger.info("Date should be rejected as Invalid date");	
				logger.info("Clear the date in the Date to field");
				logger.info("Date is removed");
				datefilter_pageobject.enterDateToWithTab("-1-may-2014");
				soft.assertThat(datefilter_pageobject.isDateInvalid()).as("verify -1-may-2014 should be rejected as invalid date").isTrue();
				datefilter_pageobject.clearDateToField();
				soft.assertThat(elements.getElementWithIdentification(datefilter_pageobject.DateToFilter).getText()).as("verify date is removed").isEqualTo("");
				
				
				
				logger.info("In the Date from field enter 1o-may-2014 and press tab");
				logger.info("Date should be rejected as Invalid date");	
				logger.info("Clear the date in the Date from field");
				logger.info("Date is removed");
				datefilter_pageobject.enterDateFromWithTab("1o--may-2014");
				soft.assertThat(datefilter_pageobject.isDateInvalid()).as("verify 1o-may-2014 should be rejected as invalid date").isTrue();
				datefilter_pageobject.clearDateFromField();
				soft.assertThat(elements.getElementWithIdentification(datefilter_pageobject.DateFromFilter).getText()).as("verify date is removed").isEqualTo("");
				
				
				logger.info("In the Date to field enter 1o-may-2014 and press tab");
				logger.info("Date should be rejected as Invalid date");	
				logger.info("Clear the date in the Date to field");
				logger.info("Date is removed");
				datefilter_pageobject.enterDateToWithTab("1o-may-2014");
				soft.assertThat(datefilter_pageobject.isDateInvalid()).as("verify 1o-may-2014 should be rejected as invalid date").isTrue();
				datefilter_pageobject.clearDateToField();
				soft.assertThat(elements.getElementWithIdentification(datefilter_pageobject.DateToFilter).getText()).as("verify date is removed").isEqualTo("");
				
				
			
				logger.info("In the Date from field enter 03/02/1976 and press tab");
				logger.info("03/02/1976 should be accepted as a valid date");	
				logger.info("Clear the date in the Date from field");
				logger.info("Date is removed");
				datefilter_pageobject.enterDateFromWithTab("03/02/1976");
				soft.assertThat(datefilter_pageobject.isDateFromValid()).as("verify 03/02/1976 should be accepted as a valid date").isTrue();
				datefilter_pageobject.clearDateFromField();
				soft.assertThat(elements.getElementWithIdentification(datefilter_pageobject.DateFromFilter).getText()).as("verify date is removed").isEqualTo("");
				
				
				logger.info("In the Date to field enter 03/02/1976 and press tab");
				logger.info("03/02/1976 should be accepted as a valid date");	
				logger.info("Clear the date in the Date to field");
				logger.info("Date is removed");
				datefilter_pageobject.enterDateToWithTab("03/02/1976");
				soft.assertThat(datefilter_pageobject.isDateToValid()).as("verify 03/02/1976 should be accepted as a valid date").isTrue();
				datefilter_pageobject.clearDateToField();
				soft.assertThat(elements.getElementWithIdentification(datefilter_pageobject.DateToFilter).getText()).as("verify date is removed").isEqualTo("");
				
				
				logger.info("In the Date from field enter 1/1/1976 and press tab");
				logger.info("1/1/1976 should be accepted as a valid date");	
				logger.info("Clear the date in the Date from field");
				logger.info("Date is removed");
				datefilter_pageobject.enterDateFromWithTab("1/1/1976");
				soft.assertThat(datefilter_pageobject.isDateFromValid()).as("verify 1/1/1976 should be accepted as a valid date").isTrue();
				datefilter_pageobject.clearDateFromField();
				soft.assertThat(elements.getElementWithIdentification(datefilter_pageobject.DateFromFilter).getText()).as("verify date is removed").isEqualTo("");
				
				
				logger.info("In the Date to field enter 1/1/1976 and press tab");
				logger.info("1/1/1976 should be accepted as a valid date");	
				logger.info("Clear the date in the Date to field");
				logger.info("Date is removed");
				datefilter_pageobject.enterDateToWithTab("1/1/1976");
				soft.assertThat(datefilter_pageobject.isDateToValid()).as("verify 1/1/1976 should be accepted as a valid date").isTrue();
				datefilter_pageobject.clearDateToField();
				soft.assertThat(elements.getElementWithIdentification(datefilter_pageobject.DateToFilter).getText()).as("verify date is removed").isEqualTo("");
				
				
				logger.info("In the Date from field enter 03-abc-2013 and press tab");
				logger.info("Date should be rejected as Invalid date");	
				logger.info("Clear the date in the Date from field");
				logger.info("Date is removed");
				datefilter_pageobject.enterDateFromWithTab("03-abc-2013");
				soft.assertThat(datefilter_pageobject.isDateInvalid()).as("verify 03-abc-2013 should be rejected as invalid date").isTrue();
				datefilter_pageobject.clearDateFromField();
				soft.assertThat(elements.getElementWithIdentification(datefilter_pageobject.DateFromFilter).getText()).as("verify date is removed").isEqualTo("");
				
				
				logger.info("In the Date to field enter 03-abc-2013 and press tab");
				logger.info("Date should be rejected as Invalid date");	
				logger.info("Clear the date in the Date to field");
				logger.info("Date is removed");
				datefilter_pageobject.enterDateToWithTab("03-abc-2013");
				soft.assertThat(datefilter_pageobject.isDateInvalid()).as("verify 03-abc-2013 should be rejected as invalid date").isTrue();
				datefilter_pageobject.clearDateToField();
				soft.assertThat(elements.getElementWithIdentification(datefilter_pageobject.DateToFilter).getText()).as("verify date is removed").isEqualTo("");
				
				
				
				logger.info("In the Date from field enter 33-jan-2013 and press tab");
				logger.info("Date should be rejected as Invalid date");	
				logger.info("Clear the date in the Date from field");
				logger.info("Date is removed");
				datefilter_pageobject.enterDateFromWithTab("33-jan-2013");
				soft.assertThat(datefilter_pageobject.isDateInvalid()).as("verify 33-jan-2013 should be rejected as invalid date").isTrue();
				datefilter_pageobject.clearDateFromField();
				soft.assertThat(elements.getElementWithIdentification(datefilter_pageobject.DateFromFilter).getText()).as("verify date is removed").isEqualTo("");
				
				
				logger.info("In the Date to field enter 33-jan-2013 and press tab");
				logger.info("Date should be rejected as Invalid date");	
				logger.info("Clear the date in the Date to field");
				logger.info("Date is removed");
				datefilter_pageobject.enterDateToWithTab("33-jan-2013");
				soft.assertThat(datefilter_pageobject.isDateInvalid()).as("verify 33-jan-2013 should be rejected as invalid date").isTrue();
				datefilter_pageobject.clearDateToField();
				soft.assertThat(elements.getElementWithIdentification(datefilter_pageobject.DateToFilter).getText()).as("verify date is removed").isEqualTo("");
				
				
				logger.info("In the Date from field enter 29-feb-2014 and press tab");
				logger.info("Date should be rejected as Invalid date");	
				logger.info("Clear the date in the Date from field");
				logger.info("Date is removed");
				datefilter_pageobject.enterDateFromWithTab("29-feb-2014");
				soft.assertThat(datefilter_pageobject.isDateInvalid()).as("verify 29-feb-2014 should be rejected as invalid date").isTrue();
				datefilter_pageobject.clearDateFromField();
				soft.assertThat(elements.getElementWithIdentification(datefilter_pageobject.DateFromFilter).getText()).as("verify date is removed").isEqualTo("");
				
				
				logger.info("In the Date to field enter 29-feb-2014 and press tab");
				logger.info("Date should be rejected as Invalid date");	
				logger.info("Clear the date in the Date to field");
				logger.info("Date is removed");
				datefilter_pageobject.enterDateToWithTab("29-feb-2014");
				soft.assertThat(datefilter_pageobject.isDateInvalid()).as("verify 29-feb-2014 should be rejected as invalid date").isTrue();
				datefilter_pageobject.clearDateToField();
				soft.assertThat(elements.getElementWithIdentification(datefilter_pageobject.DateToFilter).getText()).as("verify date is removed").isEqualTo("");
				
				
				
				logger.info("In the Date from field enter millwall and press tab");
				logger.info("Date should be rejected as Invalid date");	
				logger.info("Clear the date in the Date from field");
				logger.info("Date is removed");
				datefilter_pageobject.enterDateFromWithTab("millwall");
				soft.assertThat(datefilter_pageobject.isDateInvalid()).as("verify millwall should be rejected as invalid date").isTrue();
				datefilter_pageobject.clearDateFromField();
				soft.assertThat(elements.getElementWithIdentification(datefilter_pageobject.DateFromFilter).getText()).as("verify date is removed").isEqualTo("");
				
				
				logger.info("In the Date to field enter millwall and press tab");
				logger.info("Date should be rejected as Invalid date");	
				logger.info("Clear the date in the Date to field");
				logger.info("Date is removed");
				datefilter_pageobject.enterDateToWithTab("millwall");
				soft.assertThat(datefilter_pageobject.isDateInvalid()).as("verify millwall should be rejected as invalid date").isTrue();
				datefilter_pageobject.clearDateToField();
				soft.assertThat(elements.getElementWithIdentification(datefilter_pageobject.DateToFilter).getText()).as("verify date is removed").isEqualTo("");
				
				
				logger.info("In the Date from field enter 29-feb-2012 and press tab");
				logger.info("29-feb-2012 should be accepted as a valid date");	
				logger.info("Clear the date in the Date from field");
				logger.info("Date is removed");
				datefilter_pageobject.enterDateFromWithTab("29-feb-2012");
				soft.assertThat(datefilter_pageobject.isDateFromValid()).as("verify 29-feb-2012 should be accepted as a valid date").isTrue();
				datefilter_pageobject.clearDateFromField();
				soft.assertThat(elements.getElementWithIdentification(datefilter_pageobject.DateFromFilter).getText()).as("verify date is removed").isEqualTo("");
				
				
				logger.info("In the Date to field enter 29-feb-2012 and press tab");
				logger.info("29-feb-2012 should be accepted as a valid date");	
				logger.info("Clear the date in the Date to field");
				logger.info("Date is removed");
				datefilter_pageobject.enterDateToWithTab("29-feb-2012");
				soft.assertThat(datefilter_pageobject.isDateToValid()).as("verify 29-feb-2012 should be accepted as a valid date").isTrue();
				datefilter_pageobject.clearDateToField();
				soft.assertThat(elements.getElementWithIdentification(datefilter_pageobject.DateToFilter).getText()).as("verify date is removed").isEqualTo("");
				
				
				
				logger.info("In the Date from field enter 20/11/1969 and press tab");
				logger.info("20/11/1969 should be accepted as a valid date");	
				logger.info("Clear the date in the Date from field");
				logger.info("Date is removed");
				datefilter_pageobject.enterDateFromWithTab("20/11/1969");
				soft.assertThat(datefilter_pageobject.isDateFromValid()).as("verify 20/11/1969 should be accepted as a valid date").isTrue();
				datefilter_pageobject.clearDateFromField();
				soft.assertThat(elements.getElementWithIdentification(datefilter_pageobject.DateFromFilter).getText()).as("verify date is removed").isEqualTo("");
				
				
				logger.info("In the Date to field enter 20/11/1969 and press tab");
				logger.info("20/11/1969 should be accepted as a valid date");	
				logger.info("Clear the date in the Date to field");
				logger.info("Date is removed");
				datefilter_pageobject.enterDateToWithTab("20/11/1969");
				soft.assertThat(datefilter_pageobject.isDateToValid()).as("verify 20/11/1969 should be accepted as a valid date").isTrue();
				datefilter_pageobject.clearDateToField();
				soft.assertThat(elements.getElementWithIdentification(datefilter_pageobject.DateToFilter).getText()).as("verify date is removed").isEqualTo("");
				
				
				
				logger.info("In the Date from field enter 20/12/1969 and press tab");
				logger.info("20/12/1969 should be accepted as a valid date");	
				logger.info("Clear the date in the Date from field");
				logger.info("Date is removed");
				datefilter_pageobject.enterDateFromWithTab("20/12/1969");
				soft.assertThat(datefilter_pageobject.isDateFromValid()).as("verify 20/12/1969 should be accepted as a valid date").isTrue();
				datefilter_pageobject.clearDateFromField();
				soft.assertThat(elements.getElementWithIdentification(datefilter_pageobject.DateFromFilter).getText()).as("verify date is removed").isEqualTo("");
				
				
				logger.info("In the Date to field enter 20/12/1969 and press tab");
				logger.info("20/12/1969 should be accepted as a valid date");	
				logger.info("Clear the date in the Date to field");
				logger.info("Date is removed");
				datefilter_pageobject.enterDateToWithTab("20/12/1969");
				soft.assertThat(datefilter_pageobject.isDateToValid()).as("verify 20/12/1969 should be accepted as a valid date").isTrue();
				datefilter_pageobject.clearDateToField();
				soft.assertThat(elements.getElementWithIdentification(datefilter_pageobject.DateToFilter).getText()).as("verify date is removed").isEqualTo("");
				
				
				logger.info("In the Date from field enter 29/12/1969 and press tab");
				logger.info("29/12/1969 should be accepted as a valid date");	
				logger.info("Clear the date in the Date from field");
				logger.info("Date is removed");
				datefilter_pageobject.enterDateFromWithTab("29/12/1969");
				soft.assertThat(datefilter_pageobject.isDateFromValid()).as("verify 29/12/1969 should be accepted as a valid date").isTrue();
				datefilter_pageobject.clearDateFromField();
				soft.assertThat(elements.getElementWithIdentification(datefilter_pageobject.DateFromFilter).getText()).as("verify date is removed").isEqualTo("");
				
				
				logger.info("In the Date to field enter 29/12/1969 and press tab");
				logger.info("29/12/1969 should be accepted as a valid date");	
				logger.info("Clear the date in the Date to field");
				logger.info("Date is removed");
				datefilter_pageobject.enterDateToWithTab("29/12/1969");
				soft.assertThat(datefilter_pageobject.isDateToValid()).as("verify 29/12/1969 should be accepted as a valid date").isTrue();
				datefilter_pageobject.clearDateToField();
				soft.assertThat(elements.getElementWithIdentification(datefilter_pageobject.DateToFilter).getText()).as("verify date is removed").isEqualTo("");
				
				
				
				logger.info("In the Date from field enter 30/12/1969 and press tab");
				logger.info("30/12/1969 should be accepted as a valid date");	
				logger.info("Clear the date in the Date from field");
				logger.info("Date is removed");
				datefilter_pageobject.enterDateFromWithTab("30/12/1969");
				soft.assertThat(datefilter_pageobject.isDateFromValid()).as("verify 30/12/1969 should be accepted as a valid date").isTrue();
				datefilter_pageobject.clearDateFromField();
				soft.assertThat(elements.getElementWithIdentification(datefilter_pageobject.DateFromFilter).getText()).as("verify date is removed").isEqualTo("");
				
				
				logger.info("In the Date to field enter 30/12/1969 and press tab");
				logger.info("30/12/1969 should be accepted as a valid date");	
				logger.info("Clear the date in the Date to field");
				logger.info("Date is removed");
				datefilter_pageobject.enterDateToWithTab("30/12/1969");
				soft.assertThat(datefilter_pageobject.isDateToValid()).as("verify 30/12/1969 should be accepted as a valid date").isTrue();
				datefilter_pageobject.clearDateToField();
				soft.assertThat(elements.getElementWithIdentification(datefilter_pageobject.DateToFilter).getText()).as("verify date is removed").isEqualTo("");
				
				
				
				logger.info("In the Date from field enter 31/12/1969 and press tab");
				logger.info("31/12/1969 should be accepted as a valid date");	
				logger.info("Clear the date in the Date from field");
				logger.info("Date is removed");
				datefilter_pageobject.enterDateFromWithTab("31/12/1969");
				soft.assertThat(datefilter_pageobject.isDateFromValid()).as("verify 31/12/1969 should be accepted as a valid date").isTrue();
				datefilter_pageobject.clearDateFromField();
				soft.assertThat(elements.getElementWithIdentification(datefilter_pageobject.DateFromFilter).getText()).as("verify date is removed").isEqualTo("");
				
				
				logger.info("In the Date to field enter 31/12/1969 and press tab");
				logger.info("31/12/1969 should be accepted as a valid date");	
				logger.info("Clear the date in the Date to field");
				logger.info("Date is removed");
				datefilter_pageobject.enterDateToWithTab("31/12/1969");
				soft.assertThat(datefilter_pageobject.isDateToValid()).as("verify 31/12/1969 should be accepted as a valid date").isTrue();
				datefilter_pageobject.clearDateToField();
				soft.assertThat(elements.getElementWithIdentification(datefilter_pageobject.DateToFilter).getText()).as("verify date is removed").isEqualTo("");
				
				logger.info("End Test");
				soft.assertAll();
			}
		
	}

	@Test
	public void DateFilterScenario2_Test() throws Exception {
		logger.info("Starting inner class execution");
		InnerClass.driver = this.driver;
		InnerClass.logger = this.logger;
		Result runResult = JUnitCore.runClasses(InnerClass.class);
		Login_To_Application.CaptureResults(runResult);
	}
}




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
import com.uspeclipse.dataprovider.casenotes.EditCaseNote_dataprovider;
import com.uspeclipse.helper.Parallelized;
import com.uspeclipse.interfaces.SmokeTest;
import com.uspeclipse.pageobjects.casenotes.AddEntryPerson_pageobject;
import com.uspeclipse.pageobjects.casenotes.EditCaseNotes_pageobjects;
import com.uspeclipse.pageobjects.home.Home_pageobjects;
import com.uspeclipse.pageobjects.login.EclipseLogin_pageobject;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;
import com.uspeclipse.pageobjects.person.SearchPerson_pageobjects;
import com.uspeclipse.setup.Initialization;


@RunWith(Parallelized.class)
@Category(SmokeTest.class)
public class EditCompleteCaseNoteRecord_TestCaseID37897 {

	private WebDriver driver = null;
	private String browsertype = "";
	private Initialization Login_To_Application=null;
	Logger logger = Logger.getLogger(EditCompleteCaseNoteRecord_TestCaseID37897.class);

	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}

	public EditCompleteCaseNoteRecord_TestCaseID37897(String type) {
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

		@Test
		@UseDataProvider(location = EditCaseNote_dataprovider.class, value = "EditCompleteCase")
		public void EditCompleteCaseNoteRecord(String title, String forename,String middlename, String surname, String byear, String bmonth, String bday, String ethnicity,
				String caseyear, String casemonth, String caseday, String entrytype, String event, String entrytypeupdate1, String entrytypeupdate2, String entries, String source, String sourceorg,
				String caseyear1, String casemonth1, String caseday1, String casehour, String casemin) throws InterruptedException
		{
			SoftAssertions soft = new SoftAssertions();
			GenericActions elements = new GenericActions(driver);
			Home_pageobjects homepageobject = PageFactory.initElements(driver,Home_pageobjects.class);
			AddPerson_pageobject addpersonpageobject = PageFactory.initElements(driver, AddPerson_pageobject.class);
			SearchPerson_pageobjects searchpersonpageobject = PageFactory.initElements(driver, 	SearchPerson_pageobjects.class);
			EditCaseNotes_pageobjects editcasenotepageobject = PageFactory.initElements(driver, EditCaseNotes_pageobjects.class);
			//AddEntryPerson_pageobject addentrypageobject = PageFactory.initElements(driver, AddEntryPerson_pageobject.class);
			EclipseLogin_pageobject eclipse_pageobject = PageFactory.initElements(driver, EclipseLogin_pageobject.class);
			
			logger.info("Step 1-2 - Select a client from either the Your recently accessed records list or the Your case load list or search for a client from the quick person search at the top of the screen User selects Case Notes from the Menu.");
			addpersonpageobject.AddNewPerson("client", title, forename, middlename, surname, byear, bmonth, bday, "Male", ethnicity);
			String personid = addpersonpageobject.getPersonID();
			elements.waitForPageLoaded();
			searchpersonpageobject.enterSearchText(personid);
		
			logger.info("Step 1-3 - Click on Case Notes Menu item");
			homepageobject.clickonCasenoteLink();
			
			elements.waitForPageLoaded();
			logger.info("Adding a Case Note");
			editcasenotepageobject.Click("AddCaseNote");
			editcasenotepageobject.InputValue("CaseYear", caseyear);
			editcasenotepageobject.SelectDropDown("CaseMonth", casemonth);
			editcasenotepageobject.SelectDropDown("CaseDay", caseday);
			editcasenotepageobject.SelectDropDown("EntryType", entrytype);
			editcasenotepageobject.InputValue("Event", event);
			editcasenotepageobject.waitFortheElement();
			editcasenotepageobject.Click("SaveCaseNote");
			elements.waitForPageLoaded();
			
			logger.info("Step 1-4 -Subject has a completed Case Note User clicks on edit this entry");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("EditEntry");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("EditCaseNoteEntryPopup")).as("Edit Overlay is Present").isTrue();
			
			logger.info("Step 1-5 - User edits the Entry date");
			editcasenotepageobject.InputValue("EditYearTextbox", caseyear1);
			editcasenotepageobject.SelectDropDown("EditMonthDropdown", casemonth1);
			editcasenotepageobject.SelectDropDown("EditDayDropdown", caseday1);
			
			logger.info("Step 1-6 -User presses cancel");
			editcasenotepageobject.Click("Cancel");
			elements.waitForPageLoaded();
			String date = caseday1+"-"+casemonth1+"-"+caseyear1;
			String EntryDate = editcasenotepageobject.getDatafromCaseNoteList("Link_EntryDate");
			soft.assertThat(EntryDate.contains(date)).as("Validating Entry Date in Case Note List").isFalse();
			
			logger.info("Step 1-7 - User clicks on edit this entry on the same entry again");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("EditEntry");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("EditCaseNoteEntryPopup")).as("Edit Overlay is Present").isTrue();
			
			logger.info("Step 1-8- User edits the Entry date/Time");
			editcasenotepageobject.SelectDropDown("EditHourDropdown", casehour);
			editcasenotepageobject.SelectDropDown("EditMinuteDropdown", casemin);
			
			logger.info("Step 1-9 -User presses cancel");
			editcasenotepageobject.Click("Cancel");
			elements.waitForPageLoaded();
			String date1 = caseday1+"-"+casemonth1+"-"+caseyear1+ " "+casehour+":"+casemin;
			String EntryDate1 = editcasenotepageobject.getDatafromCaseNoteList("Link_EntryDate");
			soft.assertThat(EntryDate1.contains(date1)).as("Validating Entry Date in Case Note List").isFalse();
	
			logger.info("Step 1-10 - User clicks on edit this entry on the same entry again");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("EditEntry");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("EditCaseNoteEntryPopup")).as("Edit Overlay is Present").isTrue();
	
			logger.info("Step 1-11 - User selects a different Impact level by clicking on the recorded Impact icon");
			editcasenotepageobject.Click("Impact");
			editcasenotepageobject.Click("PositiveImpact");
			
			logger.info("Step 1-12 - User presses cancel");
			editcasenotepageobject.Click("Cancel");
			elements.waitForPageLoaded();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("PositiveImpact")).as("Positive Impact Icon is Present").isFalse();
			
			logger.info("Step 1-13 - Subject has a completed Case Note User clicks on edit this entry");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("EditEntry");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("EditCaseNoteEntryPopup")).as("Edit Overlay is Present").isTrue();
			
			logger.info("Step 1-14 - User edits the Entry date");
			editcasenotepageobject.InputValue("EditYearTextbox", caseyear);
			editcasenotepageobject.SelectDropDown("EditMonthDropdown", casemonth);
			editcasenotepageobject.SelectDropDown("EditDayDropdown", caseday);
			editcasenotepageobject.SelectDropDown("EditHourDropdown", casehour);
			editcasenotepageobject.SelectDropDown("EditMinuteDropdown", casemin);
			String date2 = caseday+"-"+casemonth+"-"+caseyear+ " "+casehour+":"+casemin;
			
			logger.info("Step 1-15 - User presses save");
			editcasenotepageobject.Click("CompleteButton");
			editcasenotepageobject.Click("CompleteCaseNoteEntry_Yes_Button");
			
			logger.info("Actual Confirmation Message: "+addpersonpageobject.verifyConfirmationMessage());
			soft.assertThat(addpersonpageobject.verifyConfirmationMessage().equals("Case Note entry successfully completed")).as("Confirmation Message should be Dispalyed-1").isTrue();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("CompletedCaseNoteRecord")).as("Completed Icon is Present").isTrue();
			String EntryDate2 = editcasenotepageobject.getDatafromCaseNoteList("Link_EntryDate");
			soft.assertThat(EntryDate2.contains(date2)).as("Validating Entry Date in Case Note List").isTrue();
			
			logger.info("Step 1-16 -User selects view this entry from the Select menu");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("ViewEntry");
			editcasenotepageobject.Click("LastEdited");
			
			String LastEditedDate = editcasenotepageobject.getLastEditedDate();
			String CompleteCaseNoteTimestamp = editcasenotepageobject.CompleteCaseNoteTimeStamp();
			logger.info("LastEditedDate: " + LastEditedDate);
			logger.info("CompleteCaseNoteTimestamp: "+ CompleteCaseNoteTimestamp);
			soft.assertThat(LastEditedDate.contains(CompleteCaseNoteTimestamp)).as("Last Edited Date should be Equal to Complete Case Note TimeStamp").isTrue();
			editcasenotepageobject.Click("Cancel");
			
			logger.info("Step 1-17 - User clicks on edit this entry");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("EditEntry");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("EditCaseNoteEntryPopup")).as("Edit Overlay is Present").isTrue();
	
			logger.info("Step 1-18 - User edits the EntryDate/Time");
			editcasenotepageobject.InputValue("EditYearTextbox", caseyear1);
			editcasenotepageobject.SelectDropDown("EditMonthDropdown", casemonth1);
			editcasenotepageobject.SelectDropDown("EditDayDropdown", caseday1);
			editcasenotepageobject.SelectDropDown("EditHourDropdown", casehour);
			editcasenotepageobject.SelectDropDown("EditMinuteDropdown", casemin);
			
			logger.info("Step 1-19 - User presses save");
			editcasenotepageobject.waitFortheElement();
			editcasenotepageobject.Click("SaveCase");
			//elements.waitForPageLoaded();
			logger.info("Actual Confirmation Message: "+addpersonpageobject.verifyConfirmationMessage());
			soft.assertThat(addpersonpageobject.verifyConfirmationMessage().equals("Case Note entry successfully updated")).as("Confirmation Message should be Dispalyed-2").isTrue();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("CompletedCaseNoteRecord")).as("Completed Icon is Present").isTrue();
			String date3 = caseday1+"-"+casemonth1+"-"+caseyear1+ " "+casehour+":"+casemin;
			String EntryDate3 = editcasenotepageobject.getDatafromCaseNoteList("Link_EntryDate");
			soft.assertThat(EntryDate3.contains(date3)).as("Validating Entry Date in Case Note List").isTrue();
			
			logger.info("Step 1-20 - User selects view this entry from the Select menu");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("ViewEntry");
			editcasenotepageobject.Click("LastEdited");
			
			String LastEditedDate1 = editcasenotepageobject.getLastEditedDate();
			String SaveCaseNoteTimestamp = editcasenotepageobject.CompleteCaseNoteTimeStamp();
			logger.info("LastEditedDate: " + LastEditedDate1);
			logger.info("SaveCaseNoteTimestamp: "+ SaveCaseNoteTimestamp);
			soft.assertThat(LastEditedDate1.contains(SaveCaseNoteTimestamp)).as("Last Edited Date should be Equal to Save Case Note TimeStamp").isTrue();
			editcasenotepageobject.Click("Cancel");
			
			logger.info("Step 1-21 - User clicks on edit this entry");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("EditEntry");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("EditCaseNoteEntryPopup")).as("Edit Overlay is Present").isTrue();
			
			logger.info("Step 1-22 - User selects a different Impact");
			editcasenotepageobject.Click("Impact");
			editcasenotepageobject.Click("PositiveImpact");
			
			logger.info("Step 1-23 - User presses save");
			editcasenotepageobject.Click("SaveCase");
			elements.waitForPageLoaded();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("PositiveImpact")).as("Positive Impact Icon is Present").isTrue();
		
			logger.info("Step 1-24 - User selects view this entry from the Select menu");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("ViewEntry");
			editcasenotepageobject.Click("LastEdited");
			
			String LastEditedDate2 = editcasenotepageobject.getLastEditedDate();
			String SaveCaseNoteTimestamp2 = editcasenotepageobject.CompleteCaseNoteTimeStamp();
			logger.info("LastEditedDate: " + LastEditedDate2);
			logger.info("SaveCaseNoteTimestamp: "+ SaveCaseNoteTimestamp2);
			soft.assertThat(LastEditedDate2.contains(SaveCaseNoteTimestamp2)).as("Last Edited Date should be Equal to Save Case Note TimeStamp").isTrue();
			editcasenotepageobject.Click("Cancel");
			
			logger.info("Step 1-25 - Click on Logout");
			editcasenotepageobject.Click("Home");
			eclipse_pageobject.EclipseLogout();
			
			soft.assertAll();

		}
	}

	@Test
	public void EditCompleteCaseNoteRecord_Test() throws Exception {
		logger.info("Starting inner class execution");
		InnerClass.driver = this.driver;
		InnerClass.logger = this.logger;
		Result runResult = JUnitCore.runClasses(InnerClass.class);
		Login_To_Application.CaptureResults(runResult);
	}


}

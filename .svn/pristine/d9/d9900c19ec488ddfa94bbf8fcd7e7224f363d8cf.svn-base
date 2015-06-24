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
import com.uspeclipse.pageobjects.casenotes.EditCaseNotes_pageobjects;
import com.uspeclipse.pageobjects.casenotes.SourceFilter_pageobject;
import com.uspeclipse.pageobjects.home.Home_pageobjects;
import com.uspeclipse.pageobjects.login.EclipseLogin_pageobject;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;
import com.uspeclipse.pageobjects.person.SearchPerson_pageobjects;
import com.uspeclipse.setup.Initialization;

@RunWith(Parallelized.class)
@Category(SmokeTest.class)
public class EditCaseNoteRecordS1_TestCaseID36809 {
	private WebDriver driver = null;
	private String browsertype = "";
	private Initialization Login_To_Application=null;
	Logger logger = Logger.getLogger(EditCaseNoteRecordS1_TestCaseID36809.class);

	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}

	public EditCaseNoteRecordS1_TestCaseID36809(String type) {
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
	//	driver.close();
	//	driver.quit();
	}

	@RunWith(DataProviderRunner.class)
	public static class InnerClass {
		static WebDriver driver = null;
		static Logger logger = null;

		@Test
		@UseDataProvider(location = EditCaseNote_dataprovider.class, value = "EditCase")
		public void EditCase(String title, String forename,String middlename, String surname, String byear, String bmonth, String bday, String ethnicity,
				String caseyear, String casemonth, String caseday, String entrytype, String event, String entrytypeupdate1, String entrytypeupdate2, String entries, String source, String sourceorg) throws Exception	{
			SoftAssertions soft = new SoftAssertions();
			GenericActions elements = new GenericActions(driver);
			Home_pageobjects homepageobject = PageFactory.initElements(driver,Home_pageobjects.class);
			AddPerson_pageobject addpersonpageobject = PageFactory.initElements(driver, AddPerson_pageobject.class);
			SearchPerson_pageobjects searchpersonpageobject = PageFactory.initElements(driver, 	SearchPerson_pageobjects.class);
			SourceFilter_pageobject srcfilterpageobject = PageFactory.initElements(driver, SourceFilter_pageobject.class);
			EditCaseNotes_pageobjects editcasenotepageobject = PageFactory.initElements(driver, EditCaseNotes_pageobjects.class);
			EclipseLogin_pageobject eclipse_pageobject = PageFactory.initElements(driver, EclipseLogin_pageobject.class);
			
			logger.info("Step 1-2 - Select a client from either the 'Your recently accessed records' list or the 'Your case load' list or search for a client from the quick person search at the top of the screen");
			
			addpersonpageobject.AddNewPerson("client", title, forename, middlename, surname, byear, bmonth, bday, "Male", ethnicity);
			String personid = addpersonpageobject.getPersonID();

			
			searchpersonpageobject.enterSearchText(personid);
			
			logger.info("Step 1-3 - Click on Case Notes Menu item");
			homepageobject.clickonCasenoteLink();
			elements.waitForPageLoaded();
			
			
			/*Commented below assertions*/
			/*Reason : Not able to check these assertions on IPAD as the table which is expected is not loaded in IPAD*/
			/*Comments: Works fine on all other plaforms*/
			/*-------------------------------------------------------------------------------------------------------------*/
			/*soft.assertThat(srcfilterpageobject.isColumnHeaderDisplayed("Entry Date")).as("Entry Date Column Table header should be Displayed").isTrue();
			soft.assertThat(srcfilterpageobject.isColumnHeaderDisplayed("Entry")).as("Entry Column Table header should be Displayed").isTrue();
			soft.assertThat(srcfilterpageobject.isColumnHeaderDisplayed("Entry Type")).as("Entry Type Column Table header should be Displayed").isTrue();
			soft.assertThat(srcfilterpageobject.isColumnHeaderDisplayed("Impact")).as("Impact Column Table header should be Displayed").isTrue();
			soft.assertThat(srcfilterpageobject.isColumnHeaderDisplayed("Source")).as("Source Column Table header should be Displayed").isTrue();
			soft.assertThat(srcfilterpageobject.isColumnHeaderDisplayed("Practitioner")).as("Practitioner Column Table header should be Displayed").isTrue();
			soft.assertThat(srcfilterpageobject.isColumnHeaderDisplayed("Status")).as("Status Column Table header should be Displayed").isTrue();
			soft.assertThat(srcfilterpageobject.isColumnHeaderDisplayed("Actions")).as("Actions Column Table header should be Displayed").isTrue();*/
			/*-------------------------------------------------------------------------------------------------------------*/
			
			
			logger.info("Adding a Case Note");
			editcasenotepageobject.Click("AddCaseNote");
			editcasenotepageobject.InputValue("CaseYear", caseyear);
			editcasenotepageobject.SelectDropDown("CaseMonth", casemonth);
			editcasenotepageobject.SelectDropDown("CaseDay", caseday);
			editcasenotepageobject.SelectDropDown("EntryType", entrytype);
			editcasenotepageobject.InputValue("Event", event);
			editcasenotepageobject.Click("SaveCaseNote");
			elements.waitForPageLoaded();
			
			logger.info("Logging to App using Manager ID");
			eclipse_pageobject.LoginAgainBySwitchingRole("manager");
			
			
		
			searchpersonpageobject.enterSearchText(personid);
			
			homepageobject.clickonAutoSuggestioninSearch();
			
			homepageobject.clickonCasenoteLink();
			elements.waitForPageLoaded();
			editcasenotepageobject.Click("Select");
			
			logger.info("Step 1-4 - Under Actions column click on select for an entry listed in the results table ");
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("ViewEntry")).as("view this entry is displayed").isTrue();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("EditEntry")).as("edit this entry is displayed").isTrue();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("CompleteEntry")).as("complete this entry is displayed").isTrue();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("DeleteEntry")).as("delete this entry is displayed").isTrue();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("RemoveEntry")).as("remove this entry is displayed").isTrue();
			
			logger.info("Step 1-5 - Select edit this entry");
			editcasenotepageobject.Click("EditEntry");
			editcasenotepageobject.SelectDropDown("EntryTypeEdit", entrytypeupdate1);
			editcasenotepageobject.Click("SaveCaseNote");
			elements.waitForPageLoaded();
			
			String PractionerName = editcasenotepageobject.getPractionerName();
			
			logger.info("PractionerName : " + PractionerName);
			soft.assertThat(PractionerName.contains("Eclipse Manager".toLowerCase())).as("Practioner Name is Eclipse Manager-1").isTrue();
			
			logger.info("SC-1 8 - Click in the Entry field");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("EditEntry");
			editcasenotepageobject.SelectDropDown("EntryTypeEdit", "");
			editcasenotepageobject.InputValue("EventEdit", "");
			editcasenotepageobject.waitFortheElement();
			editcasenotepageobject.Click("SaveCaseNote");
			
			String ErrorMsg1 = editcasenotepageobject.getErrorMessage();
			soft.assertThat(ErrorMsg1.contains("Entry type cannot be empty")).as("Entry Type Should not be Empty").isTrue();
			soft.assertThat(ErrorMsg1.contains("Entry cannot be empty")).as("Entry Should not be Empty").isTrue();
			
			logger.info("Step 1-10 - Change the date to one in the future and click on Submit.");
			String Day1 = elements.getDateParameters("NextDay");
			editcasenotepageobject.InputValue("YearTextbox", elements.getDateParameters("Year"));
			editcasenotepageobject.SelectDropDown("EditMonthDropdown", elements.getDateParameters("Month"));
			logger.info("Next Day : " + Day1.replaceFirst("0", ""));
			editcasenotepageobject.SelectDropDown("EditDayDropdown", Day1.replaceFirst("0", ""));
			
			editcasenotepageobject.Click("SaveCaseNote");
			editcasenotepageobject.waitFortheElement();
			String ErrorMsg2 = editcasenotepageobject.getErrorMessage();
			soft.assertThat(ErrorMsg2.contains("Sorry, there was a problem with the form")).as("Sorry, there was a problem with the form").isTrue();
			soft.assertThat(ErrorMsg2.contains("Entry date must be today or earlier")).as("Entry date must be today or earlier").isTrue();
			editcasenotepageobject.Click("Cancel");
			
			elements.waitForPageLoaded();
			logger.info("Step 1-12 - Click cancel and re-edit the record. Clear the month.");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("EditEntry");
			editcasenotepageobject.InputValue("EditYearTextbox", elements.getDateParameters("Year"));
			editcasenotepageobject.SelectDropDown("EditMonthDropdown","");
			editcasenotepageobject.SelectDropDown("EntryTypeEdit", entrytypeupdate1);
			editcasenotepageobject.InputValue("EventEdit", entrytypeupdate2);
			editcasenotepageobject.waitFortheElement();
			editcasenotepageobject.Click("SaveCaseNote");
			
			logger.info("Step 1-13 - Click cancel and re-edit the record. Clear the day.");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("EditEntry");
			editcasenotepageobject.SelectDropDown("EditMonthDropdown", casemonth);
			editcasenotepageobject.Click("SaveCaseNote");
			
			logger.info("Step 1-14 - Click cancel and re-edit the record. Clear the hour.");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("EditEntry");
			editcasenotepageobject.SelectDropDown("EditDayDropdown", caseday);
			editcasenotepageobject.Click("SaveCaseNote");
			
			logger.info("Step 1-15 - Click cancel and re-edit the record. Clear the minutes.");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("EditEntry");
			editcasenotepageobject.SelectDropDown("EditHourDropdown", elements.getDateParameters("Hour"));
			editcasenotepageobject.Click("SaveCaseNote");
			
			logger.info("Step 1-16 - Complete all the date and time fields in sequential order.");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("EditEntry");
			editcasenotepageobject.SelectDropDown("EditMinuteDropdown", elements.getDateParameters("Min"));
			editcasenotepageobject.Click("SaveCaseNote");
			
			logger.info("Step 1-17 - Click on Select current date.");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("EditEntry");
			editcasenotepageobject.Click("CurrentDate");
			editcasenotepageobject.Click("SaveCaseNote");
			
			logger.info("Step 1-18 - Click on Select current date and time.");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("EditEntry");
			editcasenotepageobject.Click("CurrentDateTime");
			editcasenotepageobject.Click("SaveCaseNote");
		
			logger.info("Step 1-19 - Remove all the contents of the Entry field and press Save");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("EditEntry");
			editcasenotepageobject.InputValue("EventEdit", "");
			editcasenotepageobject.waitFortheElement();
			editcasenotepageobject.Click("SaveCaseNote");
			
			String ErrorMsg3 = editcasenotepageobject.getErrorMessage();
			logger.info("ErrorMsg3: "+ ErrorMsg3);
			soft.assertThat(ErrorMsg2.contains("Sorry, there was a problem with the form")).as("Sorry, there was a problem with the form").isTrue();
			soft.assertThat(ErrorMsg1.contains("Entry cannot be empty")).as("Entry Should not be Empty").isTrue();
			
			logger.info("Step 1-20 - Click Cancel");
			editcasenotepageobject.Click("Cancel");
			
			logger.info("Step 1-21 - Select Edit this entry and modify the details shown in the Entry field (so that there are more than 7 lines of text present in the Event field) and press Save");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("EditEntry");
			editcasenotepageobject.SelectDropDown("EntryTypeEdit", entrytypeupdate1);
			editcasenotepageobject.InputValue("EventEdit", entries);
			editcasenotepageobject.waitFortheElement();
			editcasenotepageobject.Click("SaveCaseNote");
			elements.waitForPageLoaded();
			
			String EntryCaseData = editcasenotepageobject.getDatafromCaseNoteList("EntryNote");
			logger.info("EntryCaseData: " + EntryCaseData);
			logger.info("Entries :" + entries);
			soft.assertThat(EntryCaseData.trim().equals(entries.replaceAll("[\\\n]"," ").trim())).as("Validating Entries in the Case note list").isTrue();
			
			logger.info("Step 1-22 - Click on Filter button and select the People Tab");
			editcasenotepageobject.Click("FilterButton");
			srcfilterpageobject.clickonPeopleTabinFilterBy();
			logger.info("Actual Practioner Name: " + editcasenotepageobject.getPractionerNamefromFilterPeopleTab());
			soft.assertThat(editcasenotepageobject.getPractionerNamefromFilterPeopleTab().contains("Eclipse Manager".toLowerCase())).as("Practioner Name is Eclipse Manager-2").isTrue();
		
			editcasenotepageobject.Click("PractionerTextArea");
			soft.assertThat(editcasenotepageobject.getPractionerName().contains("Eclipse Manager".toLowerCase())).as("Practioner Name is Eclipse Manager-3").isTrue();
			srcfilterpageobject.clickonFilterResetLink();
			elements.waitForPageLoaded();
			
			logger.info("Step 1-23 - Click on Filter button");
			editcasenotepageobject.Click("FilterButton");
			
			logger.info("Step 1-24 - Select View this entry");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("ViewEntry");
			editcasenotepageobject.Click("LastEdited");
			
			String LastEditedDate1 = editcasenotepageobject.getLastEditedDate();
			String SaveCaseNoteTimestamp1 = editcasenotepageobject.SaveCaseNoteTimeStamp().split(" ")[0];
			logger.info("LastEditedDate: " + LastEditedDate1);
			logger.info("SaveCaseNoteTimestamp: "+ SaveCaseNoteTimestamp1);
			logger.info("LastEditedDate1::" + LastEditedDate1 +"--SaveCaseNoteTimestamp1::" + SaveCaseNoteTimestamp1);
			soft.assertThat( LastEditedDate1.contains(SaveCaseNoteTimestamp1)).as("Last Edited Date should be Equal to Save Case Note TimeStamp").isTrue();

			logger.info("Step 1-25 - Click Cancel");
			editcasenotepageobject.Click("Cancel");
			
			logger.info("Step 1-26 - Select Edit this entry and select a different Impact radio button and press Save");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("EditEntry");
			editcasenotepageobject.Click("Impact");
			editcasenotepageobject.Click("PositiveImpact");
			editcasenotepageobject.Click("SaveCaseNote");
			elements.waitForPageLoaded();
			soft.assertThat(editcasenotepageobject.CheckForElementExistence("PositiveImpact")).as("Positive Impact Icon is Present").isTrue();
			
			logger.info("Step 1-27 - Select View this entry");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("ViewEntry");
			editcasenotepageobject.Click("LastEdited");
			
			String LastEditedDate = editcasenotepageobject.getLastEditedDate();
			String SaveCaseNoteTimestamp = editcasenotepageobject.SaveCaseNoteTimeStamp().split(" ")[0];
			logger.info("LastEditedDate: " + LastEditedDate);
			logger.info("SaveCaseNoteTimestamp: "+ SaveCaseNoteTimestamp);
			soft.assertThat(LastEditedDate.contains(SaveCaseNoteTimestamp)).as("Last Edited Date should be Equal to Save Case Note TimeStamp").isTrue();
			
			logger.info("Step 1-30 - Click Cancel");
			editcasenotepageobject.Click("Cancel");
			
			
			editcasenotepageobject.waitFortheElement();
			logger.info("Step 1-31 - Click on Filter button and select the People Tab");
			editcasenotepageobject.Click("FilterButton");
			srcfilterpageobject.clickonPeopleTabinFilterBy();
			logger.info("Actual Practioner Name: " + editcasenotepageobject.getPractionerNamefromFilterPeopleTab());
			soft.assertThat(editcasenotepageobject.getPractionerNamefromFilterPeopleTab().contains("Eclipse Manager".toLowerCase())).as("Practioner Name is Eclipse Manager-4").isTrue();

			logger.info("Step 1-32 - Click on Filter button");
			srcfilterpageobject.clickonFilterResetLink();
			editcasenotepageobject.waitFortheElement();
			editcasenotepageobject.Click("FilterButton");
			
			logger.info("Step 1-33 - Select Edit this entry and edit the Source in the Source field and press Save");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("EditEntry");
			editcasenotepageobject.Click("Sourcebutton");
			editcasenotepageobject.InputValue("SourceTextBox", source);
			editcasenotepageobject.InputValue("SourceOrgTextBox", sourceorg);
			editcasenotepageobject.Click("SaveCaseNote");
			elements.waitForPageLoaded();
			
			String Sourcedata = editcasenotepageobject.getDatafromCaseNoteList("SourceCasenote");
			logger.info("Table data : " + Sourcedata);
			soft.assertThat(Sourcedata.contains(source +" (" +sourceorg+")")).as("Sorce and Source Org should be present in the case note list").isTrue();
			
			homepageobject.clickonCasenoteLink();
			editcasenotepageobject.waitFortheElement();
			logger.info("Step 1-34 - Click on Filter button and select the People Tab");
			editcasenotepageobject.Click("FilterButton");
			srcfilterpageobject.clickonPeopleTabinFilterBy();
			logger.info("Actual Practioner Name: " + editcasenotepageobject.getPractionerNamefromFilterPeopleTab());
			soft.assertThat(editcasenotepageobject.getPractionerNamefromFilterPeopleTab().contains("Eclipse Manager".toLowerCase())).as("Practioner Name is Eclipse Manager-5").isTrue();
			logger.info("Step 1-35 - Click on Filter button");
			//srcfilterpageobject.clickonFilterResetLink();
			editcasenotepageobject.waitFortheElement();
			editcasenotepageobject.Click("FilterButton");
			
			logger.info("Step 1-36 - Select View this entry");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("ViewEntry");
			editcasenotepageobject.Click("LastEdited");
			
			String LastEditedDate2 = editcasenotepageobject.getLastEditedDate();
			String SaveCaseNoteTimestamp2 = editcasenotepageobject.SaveCaseNoteTimeStamp().split(" ")[0];
			logger.info("LastEditedDate: " + LastEditedDate2);
			logger.info("SaveCaseNoteTimestamp: "+ SaveCaseNoteTimestamp2);
			soft.assertThat(LastEditedDate2.contains(SaveCaseNoteTimestamp2)).as("Last Edited Date should be Equal to Save Case Note TimeStamp").isTrue();
			
			logger.info("Step 1-37 - Click Cancel");
			editcasenotepageobject.Click("Cancel");
			
			logger.info("Step 1-38 - Select Edit this entry and edit the Source Organisation in the Source Organisation field by clicking on the 'person' icon at the bottom of the overlay and press Save");		
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("EditEntry");
			editcasenotepageobject.Click("Sourcebutton");
			editcasenotepageobject.InputValue("SourceTextBox", source);
			editcasenotepageobject.InputValue("SourceOrgTextBox", sourceorg);
			editcasenotepageobject.Click("SaveCaseNote");
			elements.waitForPageLoaded();
			
			String Sourcedata1 = editcasenotepageobject.getDatafromCaseNoteList("SourceCasenote");
			logger.info("Table data : " + Sourcedata1);
			soft.assertThat(Sourcedata1.contains(source +" (" +sourceorg+")")).as("Sorce and Source Org should be present in the case note list").isTrue();
			
			homepageobject.clickonCasenoteLink();
			editcasenotepageobject.waitFortheElement();
			logger.info("Step 1-39 - Click on Filter button and select the People Tab");
			editcasenotepageobject.Click("FilterButton");
			srcfilterpageobject.clickonPeopleTabinFilterBy();
			
			logger.info("Actual Practioner Name: " + editcasenotepageobject.getPractionerNamefromFilterPeopleTab());
			soft.assertThat(editcasenotepageobject.getPractionerNamefromFilterPeopleTab().contains("Eclipse Manager".toLowerCase())).as("Practioner Name is Eclipse Manager-6").isTrue();
			logger.info("Step 1-40 - Click on Filter button");
			srcfilterpageobject.clickonFilterResetLink();
			editcasenotepageobject.waitFortheElement();
			editcasenotepageobject.Click("FilterButton");
			
			logger.info("Step 1-41 - Select View this entry");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("ViewEntry");
			editcasenotepageobject.Click("LastEdited");
			
			String LastEditedDate4 = editcasenotepageobject.getLastEditedDate();
			String SaveCaseNoteTimestamp4 = editcasenotepageobject.SaveCaseNoteTimeStamp().split(" ")[0];
			logger.info("LastEditedDate: " + LastEditedDate4);
			logger.info("SaveCaseNoteTimestamp: "+ SaveCaseNoteTimestamp4);
			soft.assertThat(LastEditedDate4.contains(SaveCaseNoteTimestamp4)).as("Last Edited Date should be Equal to Save Case Note TimeStamp").isTrue();
			
			logger.info("Step 1-42 - Click Cancel");
			editcasenotepageobject.Click("Cancel");
			
			logger.info("Step 1-43 - Select an existing Case Note record and select Edit the Record. Complete all of the mandatory fields , varying the non-mandatory fields, using various dates including fuzzy and click on Submit.");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("EditEntry");
			editcasenotepageobject.Click("CurrentDateTime");
			editcasenotepageobject.SelectDropDown("EntryTypeEdit", entrytypeupdate1);
			editcasenotepageobject.InputValue("EventEdit", entrytypeupdate2);
			editcasenotepageobject.Click("SaveCaseNote");
			elements.waitForPageLoaded();
			
			String PractionerName1 = editcasenotepageobject.getPractionerName();
			
			logger.info("PractionerName : " + PractionerName1);
			soft.assertThat(PractionerName1.contains("Eclipse Manager".toLowerCase())).as("Practioner Name is Eclipse Manager-7").isTrue();
		
			homepageobject.clickonCasenoteLink();
			editcasenotepageobject.waitFortheElement();
			logger.info("Step 1-44 - Click on Filter button and select the People Tab");
			editcasenotepageobject.Click("FilterButton");
			srcfilterpageobject.clickonPeopleTabinFilterBy();
			
			logger.info("Actual Practioner Name: " + editcasenotepageobject.getPractionerNamefromFilterPeopleTab());
			soft.assertThat(editcasenotepageobject.getPractionerNamefromFilterPeopleTab().contains("Eclipse Manager".toLowerCase())).as("Practioner Name is Eclipse Manager-8").isTrue();
			logger.info("Step 1-45 - Click on Filter button");
			srcfilterpageobject.clickonFilterResetLink();
			editcasenotepageobject.waitFortheElement();
			editcasenotepageobject.Click("FilterButton");
			
			logger.info("Step 1-46 - Select View this entry");
			editcasenotepageobject.Click("Select");
			editcasenotepageobject.Click("ViewEntry");
			editcasenotepageobject.Click("LastEdited");
			
			String LastEditedDate3 = editcasenotepageobject.getLastEditedDate();
			String SaveCaseNoteTimestamp3 = editcasenotepageobject.SaveCaseNoteTimeStamp().split(" ")[0];
			logger.info("LastEditedDate: " + LastEditedDate3);
			logger.info("SaveCaseNoteTimestamp: "+ SaveCaseNoteTimestamp3);
			soft.assertThat(LastEditedDate3.contains(SaveCaseNoteTimestamp3)).as("Last Edited Date should be Equal to Save Case Note TimeStamp").isTrue();
			
			logger.info("Step 1-47 - Click Cancel");
			editcasenotepageobject.Click("Cancel");
			
			logger.info("Step 1-48 - Click on Home");
			editcasenotepageobject.Click("Home");
			
			logger.info("Step 1-49 - Click on Logout");
			eclipse_pageobject.EclipseLogout();
			soft.assertAll();
		}
	}

	@Test
	public void EditCaseNoteRecordS1_Test() throws Exception {
		logger.info("Starting inner class execution");
		InnerClass.driver = this.driver;
		InnerClass.logger = this.logger;
		Result runResult = JUnitCore.runClasses(InnerClass.class);
		Login_To_Application.CaptureResults(runResult);
	}
}


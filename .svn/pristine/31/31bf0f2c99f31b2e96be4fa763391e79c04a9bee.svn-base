package com.uspeclipse.testscripts.person;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import jxl.read.biff.BiffException;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import com.uspeclipse.commonservices.Constants;
import com.uspeclipse.commonservices.GenericActions;
import com.uspeclipse.commonservices.MultipleBrowser;
import com.uspeclipse.dataprovider.person.AddReferenceNumber_dataprovider;
import com.uspeclipse.helper.Parallelized;
import com.uspeclipse.interfaces.SmokeTest;
import com.uspeclipse.pageobjects.home.Home_pageobjects;
import com.uspeclipse.pageobjects.login.EclipseLogin_pageobject;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;
import com.uspeclipse.pageobjects.person.AddReferenceNumber_pageobject;
import com.uspeclipse.pageobjects.person.EditReferenceNumber_pageobject;
import com.uspeclipse.pageobjects.person.SearchPerson_pageobjects;
import com.uspeclipse.setup.Initialization;

@RunWith(Parallelized.class)
@Category(SmokeTest.class)
public class EditReferenceNumbers_TestCaseID2972 {
	private WebDriver driver = null;
	private String browsertype="";
	private Initialization Login_To_Application=null;
	Logger logger = Logger.getLogger(EditReferenceNumbers_TestCaseID2972.class);

	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}

	public EditReferenceNumbers_TestCaseID2972(String type) {
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
		@UseDataProvider(location = AddReferenceNumber_dataprovider.class, value = "ReferenceNumber")
		public void EditReferenceNumberTest(String type, String title,
				String forename, String middlename, String surname, String byear,
				String bmonth, String bday, String gender, String ethnicity,
				String referencenum) throws IOException, NoSuchMethodException,
				SecurityException, InterruptedException, BiffException, InvalidFormatException {
			
			
			EclipseLogin_pageobject eclipsepageobject = PageFactory.initElements(driver, EclipseLogin_pageobject.class);
			
			eclipsepageobject.LoginAgainBySwitchingRole("manager");
			
			SoftAssertions soft = new SoftAssertions();
			GenericActions elements = new GenericActions(driver);
			
			Home_pageobjects homepageobject = PageFactory.initElements(driver,Home_pageobjects.class);
			AddPerson_pageobject addpersonpageobject = PageFactory.initElements(driver, AddPerson_pageobject.class);
			AddReferenceNumber_pageobject addreferencenumberpageobject = PageFactory.initElements(driver, AddReferenceNumber_pageobject.class);
			SearchPerson_pageobjects searchpersonpageobject = PageFactory.initElements(driver, SearchPerson_pageobjects.class);
			EditReferenceNumber_pageobject editreferencenumberpageobject = PageFactory.initElements(driver, EditReferenceNumber_pageobject.class);

			Map<String,String> listOfReferenceNumbers = this.storeReferenceNumbers(referencenum);
			
		
			logger.info("Adding new user");
			addpersonpageobject.AddNewPerson(type, title, forename, middlename,surname, byear, bmonth, bday, gender, ethnicity);

			logger.info("PreCondition: The user must have logged into the application as 'worker'");
			logger.info("PreCondition: The user must have access to 'Persons' from the Menu");
			logger.info("PreCondition: The user must have privilege to 'Add' a new person.");
			logger.info("PreCondition: The user must have privilege to 'Edit' an existing person.");
			logger.info("PreCondition: The user must have privilege to add and edit a reference number");
			
			
			//String personnamewithID = addpersonpageobject.getPersonName();
			String personID = addpersonpageobject.getPersonID();
			homepageobject.clickonHomeLink();
			searchpersonpageobject.enterSearchText(personID);
			homepageobject.clickonAutoSuggestioninSearch();
			
			String idAndName = addreferencenumberpageobject.getPersonNameAndId();
			
			logger.info(" Confirm that when the user does a keyword search and selects a person from the auto-suggest drop down he is presented with the core identification details page of that person");
			soft.assertThat(idAndName).contains(addpersonpageobject.getPersonID());
			soft.assertThat(addreferencenumberpageobject.getIdentificationPanelFields("Name")).contains(forename);
			soft.assertThat(addreferencenumberpageobject.getIdentificationPanelFields("Forenames")).isEqualToIgnoringCase(middlename);
			soft.assertThat(addreferencenumberpageobject.getIdentificationPanelFields("Gender")).isEqualToIgnoringCase("Male");
			soft.assertThat(addreferencenumberpageobject.getIdentificationPanelFields("Ethinicity")).isEqualToIgnoringCase(ethnicity);
			
			
			logger.info("Confirm that, by default the 'Reference number' panel is in the open state in the core identification page");		
			soft.assertThat(addreferencenumberpageobject.verifyReferenceNumberPanel("title")).isEqualTo("Click to collapse section");
		
			elements.buttonClick(addreferencenumberpageobject.IdentificationLink);
			
			addreferencenumberpageobject.clickonReferenceNumberLink();
			
			logger.info("Confirm that the 'Reference number' panel can be closed by the user (if needed) by clicking on the (up arrow) at the top right corner");
			soft.assertThat(addreferencenumberpageobject.verifyReferenceNumberPanel("title")).isEqualTo("Click to expand section");
			

			logger.info("Confirm that on clicking the 'down arrow' the 'Reference numbers' is opened and is replaced by an 'up arrow' and  the panel name 'Reference numbers' is displayed.");		
			addreferencenumberpageobject.clickonReferenceNumberLink();
			soft.assertThat(editreferencenumberpageobject.isUpArrowKeyDisplayed()).as("isUpArrowKeyDisplayed").isTrue();
			
			logger.info("PreCondition: The person to be tested should have entries for  Driving Licence/ Hospital Number/ National Insurance/ Passport");
			addreferencenumberpageobject.clickonAddReferenceNumberButton();
			addreferencenumberpageobject.addReferenceType("Driving Licence", listOfReferenceNumbers.get("Driving Licence"));
			addreferencenumberpageobject.waitExplicity(1);
			addreferencenumberpageobject.clickonAddReferenceNumberButton();
			addreferencenumberpageobject.addReferenceType("Hospital Number", listOfReferenceNumbers.get("Hospital Number"));
			addreferencenumberpageobject.waitExplicity(1);
			addreferencenumberpageobject.clickonAddReferenceNumberButton();
			addreferencenumberpageobject.addReferenceType("National Insurance", listOfReferenceNumbers.get("National Insurance"));
			addreferencenumberpageobject.waitExplicity(1);
			addreferencenumberpageobject.clickonAddReferenceNumberButton();
			addreferencenumberpageobject.addReferenceType("Passport", listOfReferenceNumbers.get("Passport"));
			addreferencenumberpageobject.waitExplicity(1);
			logger.info("Confirm that in the 'Reference number' panel following fields(Type) and buttons are displayed");
			logger.info("1. Driving Licence.- Greyed out,  2. Hospital Number - Greyed out,  3. National Insurance - Greyed out");
			logger.info("4. Passport - Greyed out,  5. edit button,  6. add button,  7. (up arrow) at the top right corner of the panel");
			logger.info("Confirm that the 'Reference numbers' are ordered alphabetically by 'Type'");
			soft.assertThat(addreferencenumberpageobject.getAddedReferenceTypeAndData(1)).contains("Driving Licence");
			soft.assertThat(addreferencenumberpageobject.getAddedReferenceTypeAndData(2)).contains("Hospital Number");
			soft.assertThat(addreferencenumberpageobject.getAddedReferenceTypeAndData(3)).contains("National Insurance");
			soft.assertThat(addreferencenumberpageobject.getAddedReferenceTypeAndData(4)).contains("Passport");
			soft.assertThat(addreferencenumberpageobject.isEditButtonDisplayed()).as("isEditButtonDisplayed").isTrue();
			soft.assertThat(addreferencenumberpageobject.isAddReferenceNumberbuttonDisplayed()).as("isAddReferenceNumberbuttonDisplayed").isTrue();

			elements.getElementWithIdentification(addreferencenumberpageobject.EditReferenceNumberbutton).click();

			logger.info("Confirm that if the user clicks on the'edit' button, the'Edit reference numbers' overlay is presented to the user and the user can edit any of the reference number entered.");
			soft.assertThat(editreferencenumberpageobject.isEditReferenceNumberOverlayDisplayed()).as("isEditReferenceNumberOverlayDisplayed").isTrue();
			
			List<WebElement> listOfValuesRefernceDataInput = elements.getElementListWithIdentification(editreferencenumberpageobject.valuesOfReferenceDataInput);
			soft.assertThat(listOfValuesRefernceDataInput.size()).isEqualTo(4);
			
			logger.info("Confirm that in the 'Edit reference numbers' overlay displays following fields(Type)");
			logger.info("1. Edit reference numbers (Heading), 2. You're editing the reference numbers for Person name(Person id)- As Narrative text");
			logger.info("3. Driving Licence.- with an appropriate value, 4. Hospital Number - with an appropriate value, 5. National Insurance - with an appropriate value");
			logger.info("6. Passport - with an appropriate value, 7. save button, 8. cancel button, 9. (x) at the top right corner of the panel");
			logger.info("10. 'Remove' link against each of the displayed reference numbers");
			soft.assertThat(editreferencenumberpageobject.getEditReferenceNumberOverlayHeaderText()).isEqualToIgnoringCase("Edit reference numbers");
			soft.assertThat(editreferencenumberpageobject.getEditReferenceNumberOverlayNarrativeSummaryText()).isEqualToIgnoringCase("You're editing the reference numbers for");
			soft.assertThat(editreferencenumberpageobject.getEditReferenceNumberOverlayNarrativeDescriptionText()).contains(forename);
			addreferencenumberpageobject.waitExplicity(2);
			
			soft.assertThat(editreferencenumberpageobject.getEditReferenceNumberOverlayTypeAndData(1)).contains("Driving Licence",listOfReferenceNumbers.get("Driving Licence"));
			soft.assertThat(editreferencenumberpageobject.isRemoveLinkPresent(1)).as("isRemoveLinkPresent(1)").isTrue();		
			soft.assertThat(editreferencenumberpageobject.getEditReferenceNumberOverlayTypeAndData(2)).contains("Hospital Number",listOfReferenceNumbers.get("Hospital Number"));
			soft.assertThat(editreferencenumberpageobject.isRemoveLinkPresent(2)).as("isRemoveLinkPresent(2)").isTrue();
			soft.assertThat(editreferencenumberpageobject.getEditReferenceNumberOverlayTypeAndData(3)).contains("National Insurance",listOfReferenceNumbers.get("National Insurance"));
			soft.assertThat(editreferencenumberpageobject.isRemoveLinkPresent(3)).as("isRemoveLinkPresent(3)").isTrue();
			soft.assertThat(editreferencenumberpageobject.getEditReferenceNumberOverlayTypeAndData(4)).contains("Passport",listOfReferenceNumbers.get("Passport"));
			soft.assertThat(editreferencenumberpageobject.isRemoveLinkPresent(4)).as("isRemoveLinkPresent(4)").isTrue();
			soft.assertThat(editreferencenumberpageobject.isDisplayed("EDIT-REFERENCE-OVERLAY-SAVEBUTTON")).as("EDIT-REFERNCE-OVERLAY-SAVEBUTTON").isTrue();
			soft.assertThat(editreferencenumberpageobject.isDisplayed("EDIT-REFERENCE-OVERLAY-CLOSEBUTTON")).as("EDIT-REFERNCE-OVERLAY-CLOSEBUTTON").isTrue();
			soft.assertThat(editreferencenumberpageobject.isDisplayed("EDIT-REFERENCE-OVERLAY-CANCELBUTTON")).as("EDIT-REFERNCE-OVERLAY-CANCELBUTTON").isTrue();
			
			listOfReferenceNumbers = updateReferenceNumbers(listOfReferenceNumbers, "Driving Licence", referencenum);
			
			editreferencenumberpageobject.updateReferenceNumberValue("Driving Licence", listOfReferenceNumbers.get("Driving Licence"));
			editreferencenumberpageobject.clickonSaveButton();
			
			logger.info("Confirm that on clicking the 'save' button, if one reference number is edited the user is notified by a success message");
			soft.assertThat(addreferencenumberpageobject.getHeaderMessage()).isEqualTo("Reference number successfully updated");
			
			logger.info("Update reference number and clicking the 'save' button, the newly entered reference number(s) for that particular 'Type' is updated for that person record");
			soft.assertThat(addreferencenumberpageobject.getAddedReferenceTypeAndData(1)).contains("Driving Licence",listOfReferenceNumbers.get("Driving Licence"));
			
			logger.info("Confirm that on clicking the 'save' button, the Reference numbers panel on the 'Person' tab on the code identification page' is presented to the user with the updated reference number.");
			soft.assertThat(addreferencenumberpageobject.getPersonNameAndId()).contains(idAndName);
			
			logger.info(" Confirm that on editing the reference number and clicking the 'cancel' button or the 'X' at the right top corner, the newly entered reference number(s) for that particular 'Type' is not updated and the existing reference number(s) is/are displayed for that person record");
			addreferencenumberpageobject.clickonEditReferenceNumberButton();
			editreferencenumberpageobject.updateReferenceNumberValue("Driving Licence", "New Value");
			elements.getElementWithIdentification(editreferencenumberpageobject.editReferenceNumberPopup_CancelButton).click();
			soft.assertThat(addreferencenumberpageobject.getAddedReferenceTypeAndData(1)).contains("Driving Licence",listOfReferenceNumbers.get("Driving Licence"));
			
			logger.info("Confirm that when the user clicks on the 'cancel' button the 'X' at the top right corner, the 'Reference numbers' panel is visible to the user in the core identification details page");
			elements.getElementWithIdentification(addreferencenumberpageobject.EditReferenceNumberbutton).click();		
			elements.getElementWithIdentification(editreferencenumberpageobject.editReferenceNumberPopup_CloseButton).click();	
			
			soft.assertThat(addreferencenumberpageobject.isReferenceNumberLinkVisible()).as("ReferenceNumberLink.isDisplayed").isTrue();
			
			logger.info("End Of Test");
			soft.assertAll();
		}
		
		
		private Map<String,String> storeReferenceNumbers(String referenceNumber)
		{
			Random rand = new Random();
			Map<String,String> refNums = new HashMap<>();
			refNums.put("Blind registration No.",referenceNumber + rand.nextInt(100));
			refNums.put("Driving Licence",referenceNumber + rand.nextInt(100));
			refNums.put("Home office registration No.",referenceNumber + rand.nextInt(100));
			refNums.put("Hospital Number",referenceNumber + rand.nextInt(100));
			refNums.put("National Insurance",referenceNumber + rand.nextInt(100));
			refNums.put("Passport",referenceNumber + rand.nextInt(100));
			refNums.put("UPN (pupil number)",referenceNumber + rand.nextInt(100));
			return refNums;		
		}
		
		private Map<String,String> updateReferenceNumbers(Map<String, String> listOfReferenceNumbers, String key, String referencenum)	{
			Random rand = new Random();
			listOfReferenceNumbers.remove(key);
			listOfReferenceNumbers.put(key, referencenum+ rand.nextInt(50));
			return listOfReferenceNumbers;
		}
		
	}

	@Test
	public void EditReferenceNumbers_Test() throws Exception {
		logger.info("Starting inner class execution");
		InnerClass.driver = this.driver;
		InnerClass.logger = this.logger;
		Result runResult = JUnitCore.runClasses(InnerClass.class);
		Login_To_Application.CaptureResults(runResult);
	}

}







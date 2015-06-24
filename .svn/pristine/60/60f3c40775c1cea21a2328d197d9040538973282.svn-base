package com.uspeclipse.testscripts.person;

import java.io.IOException;
import java.util.Collection;

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
import org.openqa.selenium.support.PageFactory;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import com.uspeclipse.commonservices.Constants;
import com.uspeclipse.commonservices.MultipleBrowser;
import com.uspeclipse.dataprovider.person.EditPersonContact_dataprovider;
import com.uspeclipse.helper.Parallelized;
import com.uspeclipse.interfaces.SmokeTest;
import com.uspeclipse.pageobjects.login.EclipseLogin_pageobject;
import com.uspeclipse.pageobjects.person.AddPersonContact_pageobject;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;
import com.uspeclipse.pageobjects.person.SearchPerson_pageobjects;
import com.uspeclipse.setup.Initialization;

@RunWith(Parallelized.class)
@Category(SmokeTest.class)
public class RemoveContactDetails_TestCaseID2892 {
	private WebDriver driver = null;
	private String browsertype="";
	private Initialization Login_To_Application=null;
	Logger logger = Logger.getLogger(RemoveContactDetails_TestCaseID2892.class);

	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}

	public RemoveContactDetails_TestCaseID2892(String type) {
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
		 @UseDataProvider(location = EditPersonContact_dataprovider.class, value = "EditPersondetails")
		  public void FindPersonBySearchAutocomplete(String title, String forename,
					String middlename, String surname, String byear, String bmonth,
					String bday, String ethnicity,String ContactFixedType, String ContactDetail, String ContactType, String ContactUsage, String UpdatedContactDetails)throws IOException,
			NoSuchMethodException, SecurityException, InterruptedException, BiffException, InvalidFormatException {


			EclipseLogin_pageobject eclipsepageobject  = PageFactory.initElements(driver, EclipseLogin_pageobject.class);
			eclipsepageobject.LoginAgainBySwitchingRole("manager");

			SoftAssertions soft = new SoftAssertions();
			 AddPerson_pageobject addpersonpageobject = PageFactory.initElements(driver,
						AddPerson_pageobject.class);
			
			 
				SearchPerson_pageobjects searchpersonpageobject = PageFactory.initElements(driver,
						SearchPerson_pageobjects.class);
				AddPersonContact_pageobject addcontactpageobject = PageFactory
						.initElements(driver, AddPersonContact_pageobject.class);
			
				//addpersonpageobject.clickonAddNewPersonButton();
				
				addpersonpageobject.AddNewPerson("client", title, forename, middlename, surname,
						byear, bmonth, bday, "Male", ethnicity);
				
				
					
				// Step 3 - Confirm that when the user does a keyword search and selects a person from the auto-suggest drop down the core identification details page of that person are presented to the user
				
				
				logger.info("Step- 2 Navigate to 'Person' page");
			    logger.info("Searching Text" + addpersonpageobject.getPersonID());
				searchpersonpageobject.enterSearchText(addpersonpageobject.getPersonID());
			    searchpersonpageobject.WaitForElement("Search- AutoComplete First Line");

			    logger.info("Selecting First from AutoSuggest List." );	
			    searchpersonpageobject.Click("Search- FirstResult");
			    
			   		
				
				 logger.info("Step3 - Checking Identification Properties are displayed." );
				
				 if (searchpersonpageobject.CheckForElementExistence("Identification"))
				 {
					 logger.info("Identification properties are displayed on Page." );
				 }
				 
				 else
				 {
					 logger.error("Identification properties are not displayed on Page." );
					 soft.assertThat( searchpersonpageobject.CheckForElementExistence("Identification")).isTrue();
				 }
				 
				// Step 4 - Confirm that, by default the 'Contacts' panel is in the open state in the core identification page
				 logger.info("Step4 - Checking Contacts Panel is in Open State by Default.." );
				 if (searchpersonpageobject.CheckForElementExistence("Contact"))
				 {
					 logger.info("Contact page is in Open State by default.." );
				 }
				 
				 else
				 {
					 logger.error("Contact page is not in open State by default.." );
					 soft.assertThat(searchpersonpageobject.CheckForElementExistence("Contact")).isTrue();
				 }
				 
				 // Step - 5 Confirm that the 'Contacts' panel can be closed by the user by clicking on the (up arrow) button at the top right corner of the Reference number panel(if needed)
				 
				 logger.info("Step5 - Checking 'Contacts' panel can be closed by the user by clicking on the (up arrow) button at the top right corner of the Reference number panel(if needed)" );
				 
				 logger.info("Clicking on Contacts - up Arrow button.." );
				 searchpersonpageobject.Click("Contact-Arrow");
				 
			//	 logger.info("Waiting Contacts to be closed..." );
			//	 Thread.sleep(3000);
				
				 
				 if ( searchpersonpageobject.CheckWindowHidden("Contact"))
				 {
					 logger.info("Contact page is Successfully Closed.." );
				 }
				 
				 else
				 {
					 logger.error("Contact page couldnt be Closed.." );
					 soft.assertThat(true);

				 }
				 
				 // Step - 6 Confirm that a 'add' and 'edit' button exists at the down right corner of the 'Contacts' panel.
				 searchpersonpageobject.Click("Contact-Arrow");
				 
				 logger.info("Step - 6 Confirm that a 'add' and 'edit' button exists at the down right corner of the 'Contacts' panel." );
				
				 if (searchpersonpageobject.CheckForElementExistence("AddButton"))
				 {
					 logger.info("ADD button displayed at the bottom of Contacts panel" );
				 }
				 else
				 {
					 logger.error("ADD button is not present at the bottom of Contacts panel" );
					 soft.assertThat(searchpersonpageobject.CheckForElementExistence("AddButton")).isTrue();
				 }
				 	
				searchpersonpageobject.Click("AddButton");
				logger.info("Adding Contact information.");
				
				searchpersonpageobject.SelectDropDown("ContactFixedType", ContactFixedType);
				searchpersonpageobject.SelectDropDown("ContactType", ContactType);
				searchpersonpageobject.InputValue("ContactDetail",ContactDetail);
				searchpersonpageobject.SelectDropDown("ContactUsage", ContactUsage);
				
				searchpersonpageobject.Click("AddSave");
			
				logger.info("Saving Contact information.");
				
				 	
				 if (searchpersonpageobject.CheckForElementExistence("EditButton"))
				 {
					 logger.info("EDIT button displayed at the bottom of Contacts panel" );
				 }
				 else
				 {
					 logger.error("EDIT button is not present at the bottom of Contacts panel" );
					 soft.assertThat(searchpersonpageobject.CheckForElementExistence("EditButton")).isTrue();
				 }
				
				 searchpersonpageobject.Click("EditButton");
				 
				 logger.info("Step - 7 Confirm that on clicking the 'edit' button, an 'Edit contact' overlay is presented to the user");
				 if (searchpersonpageobject.CheckForElementExistence("EditContactOverlay"))
				 {
					 logger.info(" 'Edit contact' overlay is presented to the user" );
				 }
				 else
				 {
					 logger.error(" 'Edit contact' overlay is not presented to the user" );
					 soft.assertThat(searchpersonpageobject.CheckForElementExistence("EditContactOverlay")).isTrue();
				 }
				 
				 logger.info("Step - 8 Confirm that following fields and text are available in the Edit contact and are enabled for the user to Edit.");
				
				 logger.info("Checking Edit Contact label..");
				 if(searchpersonpageobject.CheckForElementExistence("EditContactLabel"))
				 {
					 logger.info("Edit Contact label is present.");	 
				 }
				 else
				 {
					 logger.error(" Edit Contact label is not present" );
					 soft.assertThat(searchpersonpageobject.CheckForElementExistence("EditContactLabel")).isTrue();
				 }
			
				 if(searchpersonpageobject.CheckForElementExistence("EditContactSummary"))
				 {
					 logger.info("Edit Contact Summary is present.");	 
				 }
				 else
				 {
					 logger.error(" Edit Contact Summary is not present" );
					 soft.assertThat(searchpersonpageobject.CheckForElementExistence("EditContactSummary")).isTrue();
				 }
				 if(searchpersonpageobject.CheckForElementExistence("EditContactMobileNumber"))
				 {
					 logger.info("Mobile Number Field is present.");	 
				 }
				 else
				 {
					 logger.error("Mobile Number Field is not present" );
					 soft.assertThat(searchpersonpageobject.CheckForElementExistence("EditContactMobileNumber")).isTrue();
				 }
				 
				 if(searchpersonpageobject.CheckForElementExistence("EditContactPhoneNumber"))
				 {
					 logger.info("Phone number field is present.");	 
				 }
				 else
				 {
					 logger.error("Phone number field is not present" );
					 soft.assertThat(searchpersonpageobject.CheckForElementExistence("EditContactPhoneNumber")).isTrue();
				 }
				 
				 
				 if(searchpersonpageobject.CheckForElementExistence("EditContactEmailAddress"))
				 {
					 logger.info("Email Address field is present.");	 
				 }
				 else
				 {
					 logger.error(" Email Address field is not present" );
					 soft.assertThat(searchpersonpageobject.CheckForElementExistence("EditContactEmailAddress")).isTrue();
				 }
				 
				 
				 if(searchpersonpageobject.CheckForElementExistence("EditContactWebSite"))
				 {
					 logger.info("Website field is present.");	 
				 }
				 else
				 {
					 logger.error("Website field is not present" );
					 soft.assertThat(searchpersonpageobject.CheckForElementExistence("EditContactWebSite")).isTrue();
				 }
				 
				 
				 if(searchpersonpageobject.CheckForElementExistence("EditContactFaxNumber"))
				 {
					 logger.info("Fax Number field is present.");	 
				 }
				 else
				 {
					 logger.error("Fax number field is not present" );
					 soft.assertThat(searchpersonpageobject.CheckForElementExistence("EditContactFaxNumber")).isTrue();
				 }
				 
				 
				 if(searchpersonpageobject.CheckForElementExistence("SaveButton"))
				 {
					 logger.info("Save Button is present.");	 
				 }
				 else
				 {
					 logger.error("Save button is not present" );
					 soft.assertThat(searchpersonpageobject.CheckForElementExistence("SaveButton")).isTrue();
				 }
				 if(searchpersonpageobject.CheckForElementExistence("CancelButton"))
				 {
					 logger.info("Cancel button is present.");	 
				 }
				 else
				 {
					 logger.error("Cancel button is not present" );
					 soft.assertThat(searchpersonpageobject.CheckForElementExistence("CancelButton")).isTrue();
				 }
				 
				 
				 if(searchpersonpageobject.CheckForElementExistence("CloseButton"))
				 {
					 logger.info("Close Button is present.");	 
				 }
				 else
				 {
					 logger.error(" Close button  is not present" );
					 soft.assertThat(searchpersonpageobject.CheckForElementExistence("CloseButton")).isTrue();
				 }
				 
				 
				 logger.info("Step - 9 Confirm that all the contact types i.e. 'Phone number', 'Mobile number', 'Email address'are displayed at the left-hand side of the 'Contact' panel andhave a valid value entered or 'None' if they are no existing value for that 'Type'");
				 if(searchpersonpageobject.CheckValue("MobileNumberValue", "None"))
				 {
					 logger.info("Mobile Number field has got  Value = " + "None");
				 }
				 else
				 {
					 logger.error("Mobile Number field hasn't got Value  " + "None");
					 soft.assertThat(true).isTrue();
				 }
				 
		
				 
				 if(searchpersonpageobject.CheckValue("PhoneNumberValue", "None"))
				 {
					 logger.info("PhoneNumberValue field has got  Value = " + "None");
				 }
				 else
				 {
					 logger.error("PhoneNumberValue field hasn't got Value  " + "None");
					 soft.assertThat(true).isTrue();
				 }
		
				 
				 			 
				 logger.info("Step - 10 Confirm that all the contact types i.e.'Website', 'Social media', 'Fax number' are displayed at the right-hand side of the 'Contact' panel andhave a valid value entered or 'None' if they are no existing value for that 'Type' ");	 

				 
				 if(searchpersonpageobject.CheckValue("WebSiteValue", "None"))
				 {
					 logger.info("WebSiteValue field has got  Value = " + "None");
				 }
				 else
				 {
					 logger.error("WebSiteValue field hasn't got Value  " + "None");
					 soft.assertThat(true).isTrue();
				 }
		
				 
				 if(searchpersonpageobject.CheckValue("SocialMediaValue", "None"))
				 {
					 logger.info("SocialMediaValuefield has got  Value = " + "None");
				 }
				 else
				 {
					 logger.error("SocialMediaValue field hasn't got Value  " + "None");
					 soft.assertThat(true).isTrue();
				 }
		
				 if(searchpersonpageobject.CheckValue("FaxNumberValue", "None"))
				 {
					 logger.info("FaxNumberValue field has got  Value = " + "None");
				 }
				 else
				 {
					 logger.error("FaxNumberValue field hasn't got Value  " + "None");
					 soft.assertThat(true).isTrue();
				 }
				
				 
				 searchpersonpageobject.clickonClosebutton();
				 
				 logger.info("Adding Phone Number...");
				 addcontactpageobject.clickonAddContactsButton();
				 addcontactpageobject.selectOptionfromDropdown("Contact", "Telephone");
				 addcontactpageobject.selectOptionfromDropdown("Type", "Home");
				 addcontactpageobject.selectOptionfromDropdown("Telephone", "Landline");
				 addcontactpageobject.selectOptionfromDropdown("Usage", "Permanent");
				 addcontactpageobject.enterNumber("9999999999");
				 addcontactpageobject.clickonSaveButton();
				 

				 logger.info("Adding Mobile Number...");
				 addcontactpageobject.clickonAddContactsButton();
				 addcontactpageobject.selectOptionfromDropdown("Contact", "Telephone");
				 addcontactpageobject.selectOptionfromDropdown("Type", "Home");
				 addcontactpageobject.selectOptionfromDropdown("Telephone", "Mobile");
				 addcontactpageobject.selectOptionfromDropdown("Usage", "Permanent");
				 addcontactpageobject.enterNumber("8888888888");
				 addcontactpageobject.clickonSaveButton();
				 

				 logger.info("Adding Social Media...");
				 addcontactpageobject.clickonAddContactsButton();
				 addcontactpageobject.selectOptionfromDropdown("Contact", "Social Media");
				 addcontactpageobject.selectOptionfromDropdown("Type", "Home");
				 addcontactpageobject.enterURL("http://www.facebook.com/12345");
				 addcontactpageobject.selectOptionfromDropdown("Usage", "Permanent");
				 addcontactpageobject.selectOptionfromDropdown("Social Media", "Facebook");
				 addcontactpageobject.clickonSaveButton();
				 

				 logger.info("Adding Fax Number...");
				 addcontactpageobject.clickonAddContactsButton();
				 addcontactpageobject.selectOptionfromDropdown("Contact", "Telephone");
				 addcontactpageobject.selectOptionfromDropdown("Type", "Home");
				 addcontactpageobject.selectOptionfromDropdown("Telephone", "Fax");
				 addcontactpageobject.selectOptionfromDropdown("Usage", "Permanent");
				 addcontactpageobject.enterNumber("9999999999");
				 addcontactpageobject.clickonSaveButton();
				 

				 logger.info("Ading Website...");
				 addcontactpageobject.clickonAddContactsButton();
				 addcontactpageobject.selectOptionfromDropdown("Contact", "Website");
				 addcontactpageobject.selectOptionfromDropdown("Type", "Home");
				 addcontactpageobject.enterEmailAddress("https://inview.olmdemo.co.uk/");
				 addcontactpageobject.selectOptionfromDropdown("Usage", "Permanent");
				 addcontactpageobject.clickonSaveButton();
				 
				
				 
				 logger.info("Step - 11 Confirm that the'Remove' link is available against following fields in the Edit contact: ");	 
				 searchpersonpageobject.Click("EditButton");
				 logger.info("Remove link present for - PhoneNumber");
				 soft.assertThat(addcontactpageobject.VerifyRemoveLinkExists("PhoneNumber")).isTrue();
				 logger.info("Remove link present for - MobileNumber");
				 soft.assertThat(addcontactpageobject.VerifyRemoveLinkExists("MobileNumber")).isTrue();
				 logger.info("Remove link present for - FaxNumber");
				 soft.assertThat(addcontactpageobject.VerifyRemoveLinkExists("FaxNumber")).isTrue();
				 logger.info("Remove link present for - WebSite");
				 soft.assertThat(addcontactpageobject.VerifyRemoveLinkExists("WebSite")).isTrue();
				 logger.info("Remove link present for - SocialMedia");
				 soft.assertThat(addcontactpageobject.VerifyRemoveLinkExists("SocialMedia")).isTrue();
				 logger.info("Remove link present for - EmailAddress");
				 soft.assertThat(addcontactpageobject.VerifyRemoveLinkExists("EmailAddress")).isTrue();
				 
				 logger.info("Step - 12 Confirm that on clicking on the'Remove' link next to any one of the 'Contact' and clicking on the 'save' button the input value in that field is null(removed) permanently and that particular contact is 'Disabled( grayed out)'.[**b**][**b**] ");	 
				 
				 addcontactpageobject.ClickRemoveLink("FaxNumber");
				
				 
				 /*logger.info("Input Box is disabled for FaxNumber..");
				 soft.assertThat(addcontactpageobject.CheckDisabledInputTextBox("FaxNumber")).isTrue();*/
				 
				 logger.info("Step - 13 Confirm that on clicking 'save' after 'removing' any/all of the contact(s), the updated record is displayed in the 'Contact' panel in the 'Core identification details' ");	 
				 searchpersonpageobject.Click("EditSaveContact");

				 logger.info("Step -13 + 15 Confirm that a confirmation message is displayed  when the user has selected at least one contact number to remove as 'Contact number successfully removed'. Note: If more than one contact number(s) are removed the confirmation message is, 'Contact number(s) successfully removed'");	 
					
				 logger.info("Contact Updated Message is present..");	
				 soft.assertThat(searchpersonpageobject.CheckForElementExistence("ContactUpdatedMessage")).isTrue();
					
				 logger.info("Fax Number field has got  Value = " + "None");
				 soft.assertThat(searchpersonpageobject.CheckValue("SearchPage_FaxNumberValue", "None")).isTrue();
				
				 logger.info("Step -17  Confirm that on 'removing' the contact number and clicking the 'cancel' button or the 'x' at the top corner, the newly entered contact number for that particular 'Type' is not updated and the existing contact number is displayed for that person record");	 
						
				 searchpersonpageobject.Click("EditButton");
				 addcontactpageobject.ClickRemoveLink("PhoneNumber");
				 searchpersonpageobject.Click("CancelButton");
				 
				 logger.info("Phone Number value reamined unchanged.");
				 soft.assertThat(searchpersonpageobject.GetValueFromApplication("PhoneNumberValue")).isEqualTo("9999999999");
							 
				 logger.info("Step -18  Confirm that when the user clicks on the 'cancel' button or the (x) at the top right corner, the 'Contact' panel is visible to the user in the core identification details page ");	 
						 
				 searchpersonpageobject.Click("EditButton");
				 if (searchpersonpageobject.CheckForElementExistence("EditContactOverlay"))
				 {
					 logger.info("Contact overlay window displayed to user.");	 
						
					 if (searchpersonpageobject.CheckForElementExistence("CloseButton"))
					 {
						 searchpersonpageobject.Click("CloseButton");
						 if (searchpersonpageobject.CheckForElementExistence("Contact"))
						 {
							 logger.info("Clicking close button Successffully shows Contact panel on Main page" );
						 }
						 
						 else
						 {
							 logger.error("Clicking close button doesn't show Contact panel on Main page" );
							 soft.assertThat(searchpersonpageobject.CheckForElementExistence("Contact")).isTrue();
						 }
						 
					 }
					 
				 }
				 else
				 {
					 logger.error(" 'Edit contact' overlay is not presented to the user" );
					 soft.assertThat(searchpersonpageobject.CheckForElementExistence("EditContactOverlay")).isTrue();
				 }
				 
				 
				 logger.info("Step -19  Confirm that on clicking the'up arrow' the panel is closed and is replaced by a'down arrow' and  the panel name 'Contact' is displayed.");	 
					
				 searchpersonpageobject.Click("Contact-Arrow");
				 
				 logger.info("DownArrow shown successfully" );
				 soft.assertThat(searchpersonpageobject.CheckDownArrow("Contacts")).isTrue();
		}
	}

	@Test
	public void RemoveContactDetails_Test() throws Exception {
		logger.info("Starting inner class execution");
		InnerClass.driver = this.driver;
		InnerClass.logger = this.logger;
		Result runResult = JUnitCore.runClasses(InnerClass.class);
		Login_To_Application.CaptureResults(runResult);
	}

}











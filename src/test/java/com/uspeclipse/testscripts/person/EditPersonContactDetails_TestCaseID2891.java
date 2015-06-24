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
import com.uspeclipse.dataprovider.person.EditPersonContact_dataprovider;
import com.uspeclipse.helper.Parallelized;
import com.uspeclipse.interfaces.SmokeTest;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;
import com.uspeclipse.pageobjects.person.SearchPerson_pageobjects;
import com.uspeclipse.setup.Initialization;

@RunWith(Parallelized.class)
@Category(SmokeTest.class)
public class EditPersonContactDetails_TestCaseID2891 {
	private WebDriver driver = null;
	private String browsertype="";
	private Initialization Login_To_Application=null;
	Logger logger = Logger.getLogger(EditPersonContactDetails_TestCaseID2891.class);

	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}

	public EditPersonContactDetails_TestCaseID2891(String type) {
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
		 @UseDataProvider(location = EditPersonContact_dataprovider.class, value = "EditPersondetails")
		  public void FindPersonBySearchAutocomplete(String title, String forename,
					String middlename, String surname, String byear, String bmonth,
					String bday, String ethnicity,String ContactFixedType, String ContactDetail, String ContactType, String ContactUsage, String UpdatedContactDetails)throws IOException,
			NoSuchMethodException, SecurityException, InterruptedException {

			
			SoftAssertions soft = new SoftAssertions();
			 AddPerson_pageobject addpersonpageobject = PageFactory.initElements(driver,
						AddPerson_pageobject.class);
				/*Home_pageobjects homepageobject = PageFactory.initElements(driver,Home_pageobjects.class);*/
				SearchPerson_pageobjects searchpersonpageobject = PageFactory.initElements(driver,
						SearchPerson_pageobjects.class);
				
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
				 
				// Step 5 - Confirm that, by default the 'Contacts' panel is in the open state in the core identification page
				 logger.info("Step5 - Checking Contacts Panel is in Open State by Default.." );
				 if (searchpersonpageobject.CheckForElementExistence("Contact"))
				 {
					 logger.info("Contact page is in Open State by default.." );
				 }
				 
				 else
				 {
					 logger.error("Contact page is not in open State by default.." );
					 soft.assertThat(searchpersonpageobject.CheckForElementExistence("Contact")).isTrue();
				 }
				 
				 // Step - 6 Confirm that the 'Contacts' panel can be closed by the user by clicking on the (up arrow) button at the top right corner of the Reference number panel(if needed)
				 
				 logger.info("Step6 - Checking 'Contacts' panel can be closed by the user by clicking on the (up arrow) button at the top right corner of the Reference number panel(if needed)" );
				 
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
				 
				 // Step - 7 Confirm that a 'add' and 'edit' button exists at the down right corner of the 'Contacts' panel.
				 searchpersonpageobject.Click("Contact-Arrow");
				 
				 logger.info("Step - 7 Confirm that a 'add' and 'edit' button exists at the down right corner of the 'Contacts' panel." );
				
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
				
				 logger.info("Step - 8 Confirm that 'edit' button appears only when at least one contact is added" );
					
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
				 
				 logger.info("Step - 9 Confirm that on clicking the 'edit' button, an 'Edit contact' overlay is presented to the user");
				 if (searchpersonpageobject.CheckForElementExistence("EditContactOverlay"))
				 {
					 logger.info(" 'Edit contact' overlay is presented to the user" );
				 }
				 else
				 {
					 logger.error(" 'Edit contact' overlay is not presented to the user" );
					 soft.assertThat(searchpersonpageobject.CheckForElementExistence("EditContactOverlay")).isTrue();
				 }
				 
				 logger.info("Step - 10 Confirm that following fields and text are available in the Edit contact and are enabled for the user to Edit.");
				
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
				 
				 
				 logger.info("Step - 11 Confirm that all the contact types i.e. 'Phone number', 'Mobile number', 'Email address'are displayed at the left-hand side of the 'Contact' panel andhave a valid value entered or 'None' if they are no existing value for that 'Type'");
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
		
				 
				 logger.info("Step - 12 Confirm that the email address entered is the valid email format ");	 
				 
				 boolean EmailValidated = searchpersonpageobject.CheckRegularExpression("EMAIL"); 
				 
				 if(EmailValidated)
				 {
					 logger.info("Email Validated...");	 
				 }
				 else
				 {
					 logger.error("Email Couldnt be validated" );
					 soft.assertThat(true).isTrue();
				 }
				 
				 
				 
				 
				 logger.info("Step - 13 Confirm that an valid error message is displayed if the user enters an invalid email id and is not per the format ");	 
				 searchpersonpageobject.InputValue("Email", "SomeRandomValue");
				 searchpersonpageobject.Click("AddSave");
				 
				if(searchpersonpageobject.CheckForElementExistence("Error_EmailMessage"))
				 {
					 logger.info("Error message displayed for Email Validation..");	
				 }
				 else
				 {
					 logger.error("Error message not displayed for Email Validation..");
					 soft.assertThat(searchpersonpageobject.CheckForElementExistence("Email")).isTrue();
				 }
				 
				 logger.info("Step - 14 Confirm that all the contact types i.e.'Website', 'Social media', 'Fax number' are displayed at the right-hand side of the 'Contact' panel andhave a valid value entered or 'None' if they are no existing value for that 'Type' ");	 

				 
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
				 
				 logger.info("Step - 15 Confirm that when user clicks in one the field he is allowed to edit the contact and on clicking the 'save' a successful message is displayed as'Contact successfully updated'[**b**][**b**] ");	 
					
				 searchpersonpageobject.InputValue("Email", UpdatedContactDetails );
				 searchpersonpageobject.Click("AddSave");
				 
				 if(searchpersonpageobject.CheckForElementExistence("ContactUpdatedMessage"))
				 {
					 logger.info("Contact Updated Message is present..");	
				 }
				 else
				 {
					 logger.error("Contact updated message is not present...");
					 soft.assertThat(searchpersonpageobject.CheckForElementExistence("ContactUpdatedMessage")).isTrue();
				 }
				 
				 logger.info("Step - 16 Confirm that on clicking 'save' after editing any/all of the contact(s), the updated record is displayed in the 'Contact' panel in the 'Core identification details' ");	 
				
				 if(searchpersonpageobject.GetValueFromApplication("EmailAddressValue").trim().equals(UpdatedContactDetails))
				 {
					 logger.info("Updated contact details is displayed in 'Contact' panel");
				 }
				 else
				 {
					 logger.error("Updated contact details is not displayed in 'Contact' panel  Actual: " + searchpersonpageobject.GetValueFromApplication("EmailAddressValue") + "  Expected: " + UpdatedContactDetails );
					 soft.assertThat(true).isTrue();
				 
				 }
				
				 logger.info("Step - 17 Confirm that on editing the contact number and clicking the 'cancel' button or the (x) at the top right corner, the newly entered contact number for that particular 'Type' is not updated and the existing contact number is displayed for that person record ");	 
					
				 searchpersonpageobject.Click("EditButton");
				 searchpersonpageobject.InputValue("Email", ContactDetail);
				 searchpersonpageobject.Click("CancelButton");
				 
				 if(searchpersonpageobject.GetValueFromApplication("EmailAddressValue").trim().equals(UpdatedContactDetails))
				 {
					 logger.info(" Contact details not updated clicking 'cancel' button");
				 }
				 else
				 {
					 logger.error(" Contact details are updated even after clicking 'cancel' button");
					 soft.assertThat(true).isTrue();
				 
				 }
				 
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
				 
				 
				 logger.info("Step -20  Confirm that on clicking the'up arrow' the panel is closed and is replaced by a'down arrow' and  the panel name 'Contact' is displayed.");	 
					
				 searchpersonpageobject.Click("Contact-Arrow");
				 Boolean b = searchpersonpageobject.CheckDownArrow("Contacts");
				 if (b)
				 {
					 logger.info("DownArrow shown successfully" );
				 }
				 
				 else
				 {
					 
					 soft.assertThat(searchpersonpageobject.CheckForElementExistence("Contact")).isTrue();
				 }
					 
				
				 
		}
		
	}

	@Test
	public void EditPersonContactDetails_Test() throws Exception {
		logger.info("Starting inner class execution");
		InnerClass.driver = this.driver;
		InnerClass.logger = this.logger;
		Result runResult = JUnitCore.runClasses(InnerClass.class);
		Login_To_Application.CaptureResults(runResult);
	}

}
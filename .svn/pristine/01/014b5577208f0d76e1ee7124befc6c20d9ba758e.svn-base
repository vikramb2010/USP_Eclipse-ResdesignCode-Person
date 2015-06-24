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
import com.uspeclipse.dataprovider.person.AddPersonAddress_dataprovider;
import com.uspeclipse.helper.Parallelized;
import com.uspeclipse.interfaces.SmokeTest;
import com.uspeclipse.pageobjects.person.AddPersonAddress_pageobjects;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;
import com.uspeclipse.pageobjects.person.EndPersonAddress_pageobject;
import com.uspeclipse.pageobjects.person.SearchPerson_pageobjects;
import com.uspeclipse.setup.Initialization;

@RunWith(Parallelized.class)
@Category(SmokeTest.class)
public class PersonAddressDisplay_TestCaseID3083 {
	private WebDriver driver = null;
	private String browsertype="";
	private Initialization Login_To_Application=null;
	Logger logger = Logger.getLogger(PersonAddressDisplay_TestCaseID3083.class);

	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}

	public PersonAddressDisplay_TestCaseID3083(String type) {
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
		@UseDataProvider(location = AddPersonAddress_dataprovider.class, value = "AddAddress")
		public void AddressDisplay(String title, String forename,String middlename, String surname, String byear, String bmonth, String bday, String ethnicity,
				String postcode1, String buildingNameorNumber1,String streetName1,String localityName1,String townorCity1,String county1, String type1,String usage1,String year1,String Month1,String Day1,
				String postcode2,String buildingNameorNumber2,String streetName2,String localityName2, String townorCity2,String county2, String type2,String usage2,String year2,String Month2,String Day2,
				String postcode3,String buildingNameorNumber3,String streetName3,String localityName3, String townorCity3,String county3, String type3,String usage3,String year3,String Month3,String Day3,
				String postcode4,String buildingNameorNumber4,String streetName4,String localityName4, String townorCity4,String county4, String type4,String usage4,String year4,String Month4,String Day4,
				String EndReason) throws InterruptedException{
			
			SoftAssertions soft = new SoftAssertions();		
			GenericActions elements = new GenericActions(driver);
			
			AddPerson_pageobject addpersonpageobject = PageFactory.initElements(driver, AddPerson_pageobject.class);
			AddPersonAddress_pageobjects addpersonaddresspageobject = PageFactory.initElements(driver, AddPersonAddress_pageobjects.class);
			SearchPerson_pageobjects searchpersonpageobject = PageFactory.initElements(driver, 	SearchPerson_pageobjects.class);
			EndPersonAddress_pageobject endpersonaddresspageobject =  PageFactory.initElements(driver,	EndPersonAddress_pageobject.class);
			 
			addpersonpageobject.AddNewPerson("client", title, forename, middlename, surname, byear, bmonth, bday, "Male", ethnicity);
			
			String personid = addpersonpageobject.getPersonID();
			
			logger.info("Step 3 : Add an address of type 'Home' and usage 'Temporary'");
			
			addpersonaddresspageobject.AddPersonAddressLocation(buildingNameorNumber1,streetName1,localityName1,townorCity1,county1,postcode1,type1,usage1,year1,Month1,Day1);
			 
			logger.info("Step 4 - Enter the name of the same person in the person search box whose address is been added: "+ personid);
			searchpersonpageobject.enterSearchText(addpersonpageobject.getPersonID());
			logger.info("Selecting Third Line from AutoSuggest List." );

		    String HomeAddress = addpersonaddresspageobject.getAddressFromAddressTable("Home");
		    logger.info("Address From Table " + HomeAddress);
			logger.info("Step 5 - In the auto suggest, confirm that the address displayed is the Home address recorded for the person");
			soft.assertThat(searchpersonpageobject.getPersonAddressLocationFromAutoSuggest()).isEqualTo(HomeAddress); 
			

			logger.info("Step 6 : Add an address of type ' Placement'  and usage 'Permanent'");
			
			addpersonaddresspageobject.AddPersonAddressLocation(buildingNameorNumber2,streetName2,localityName2,townorCity2,county2,postcode2,type2,usage2,year2,Month2,Day2);
			 
			logger.info("Step 7 - Enter the name of the same person in the person search box whose address is been added: "+ personid);
			searchpersonpageobject.enterSearchText(addpersonpageobject.getPersonID());
			
			logger.info("Selecting Third Line from AutoSuggest List." );
		
		    String placementAddress = addpersonaddresspageobject.getAddressFromAddressTable("Placement");
		    logger.info("Address From Table " + placementAddress);
			logger.info("Step 8 - In the auto suggest, confirm that the address displayed is the Home address recorded for the person");
			soft.assertThat(searchpersonpageobject.getPersonAddressLocationFromAutoSuggest()).isEqualTo(HomeAddress); 
			
			
			logger.info("Step 9 : Add an address of type 'work' and usage 'Temporary'");
			
			addpersonaddresspageobject.AddPersonAddressLocation(buildingNameorNumber3,streetName3,localityName3,townorCity3,county3,postcode3,type3,usage3,year3,Month3,Day3);
			 
			searchpersonpageobject.enterSearchText(personid);
			logger.info("Selecting Third Line from AutoSuggest List." );
		
		    String WorkAddress = addpersonaddresspageobject.getAddressFromAddressTable("Work");
		    logger.info("Address From Table " + WorkAddress);
			logger.info("Step 10 - In the auto suggest, confirm that the address displayed is the Home address recorded for the person");
			soft.assertThat(searchpersonpageobject.getPersonAddressLocationFromAutoSuggest()).isEqualTo(HomeAddress); 
			
			logger.info("Step 11 : Add an address of type 'emergency' and usage 'Permanent'");
			
			addpersonaddresspageobject.AddPersonAddressLocation(buildingNameorNumber4,streetName4,localityName4,townorCity4,county4,postcode4,type4,usage4,year4,Month4,Day4);
			 
			searchpersonpageobject.enterSearchText(personid);
			logger.info("Selecting Third Line from AutoSuggest List." );
		
		    String EmergencyAddress = addpersonaddresspageobject.getAddressFromAddressTable("Emergency");
		    logger.info("Address From Table " + EmergencyAddress);
			logger.info("Step 12 - In the auto suggest, confirm that the address displayed is the Home address recorded for the person");
			soft.assertThat(searchpersonpageobject.getPersonAddressLocationFromAutoSuggest()).isEqualTo(HomeAddress); 
			
			logger.info("Step 13 - End the home address recorded for the person");
			
			addpersonaddresspageobject.Click("SelectHome");
			addpersonaddresspageobject.Click("EndHome");
			endpersonaddresspageobject.endAddress(year1, Month1, Day1, EndReason);
			
			logger.info("Step 14 - Selecting Third Line from AutoSuggest List." );
			searchpersonpageobject.enterSearchText(personid);
			
			logger.info("Step - 15 On the person search results, confirm that the address for the person whose home address was ended now displays the Placement address");
			soft.assertThat(searchpersonpageobject.getPersonAddressLocationFromAutoSuggest()).isEqualTo(placementAddress);
			
		
			logger.info("Step 16 - End the Placement address recorded for the person");
			
			addpersonaddresspageobject.Click("SelectPlacement");
			addpersonaddresspageobject.Click("EndPlacement");
			endpersonaddresspageobject.endAddress(year2, Month2, Day2, EndReason);
			
			logger.info("Step 17 - Selecting Third Line from AutoSuggest List." );
			searchpersonpageobject.enterSearchText(personid);
			
			logger.info("Step - 18 Confirm that the auto-suggest results are now updated to display work address and not the emergency address");
			soft.assertThat(searchpersonpageobject.getPersonAddressLocationFromAutoSuggest()).isEqualTo(WorkAddress);
			
			
			logger.info("Step 19 - End the Work recorded for that person");
			
			addpersonaddresspageobject.Click("SelectWork");
			addpersonaddresspageobject.Click("EndWork");
			endpersonaddresspageobject.endAddress(year3, Month3, Day3, EndReason);
			
			logger.info("Step 20 - Selecting Third Line from AutoSuggest List." );
			searchpersonpageobject.enterSearchText(personid);
			
			logger.info("Step 21 -  Confirm that the auto-suggest results are now updated to display Emergency address and not the Work address");
			soft.assertThat(searchpersonpageobject.getPersonAddressLocationFromAutoSuggest()).isEqualTo(EmergencyAddress);
			
			logger.info("End the Emergency recorded for that person");
			
			addpersonaddresspageobject.Click("SelectEmergency");
			addpersonaddresspageobject.Click("EndEmergency");
			endpersonaddresspageobject.endAddress(year4, Month4, Day4, EndReason);
			
			searchpersonpageobject.enterSearchText(personid);
			logger.info("Selecting Third Line from AutoSuggest List." );
			
			if(!(searchpersonpageobject.CheckForElementExistence("SearchAutocompleteThirdline")))
			{
				logger.info("SearchAutocompleteThirdline : Element not present");
			}
			
			logger.info("Step 22 - Choose another person record who has doesn't have any address recorded.");
			
			addpersonpageobject.AddNewPerson("client", title, forename, middlename, surname, byear, bmonth, bday, "Male", ethnicity);
			elements.waitForPageLoaded();
			String personid1 = addpersonpageobject.getPersonID();
			
			logger.info("Step 23 : Add an address of type 'Emergency' and usage 'temporary' to the nominated person");
			
			addpersonaddresspageobject.AddPersonAddressLocation(buildingNameorNumber1,streetName1,localityName1,townorCity1,county1,postcode1,type4,usage3,year1,Month1,Day1);
			
			logger.info("Step 24 - Enter the name of the same person in the person search box whose address is been added: "+ personid1);
			searchpersonpageobject.enterSearchText(personid1);
			logger.info("Selecting Third Line from AutoSuggest List." );
		
			logger.info("Step 25 - Confirm that the auto-suggest results are now updated to display the emergency address");
			soft.assertThat(searchpersonpageobject.getPersonAddressLocationFromAutoSuggest()).isEqualTo(addpersonaddresspageobject.getAddressFromAddressTable("Emergency")); 
		
			logger.info("Step 26 : Add an address of type 'Placement' and usage 'Permanent' to the nominated person");
			
			addpersonaddresspageobject.AddPersonAddressLocation(buildingNameorNumber2,streetName2,localityName2,townorCity2,county2,postcode2,type2,usage2,year2,Month2,Day2);
			
			logger.info("Step 27 - Enter the name of the same person in the person search box whose address is been added: "+ personid1);
			searchpersonpageobject.enterSearchText(personid1);
			logger.info("Selecting Third Line from AutoSuggest List." );
		
			logger.info("Step 28 - Confirm that the auto-suggest results are now updated to display the placement address");
			soft.assertThat(searchpersonpageobject.getPersonAddressLocationFromAutoSuggest()).isEqualTo(addpersonaddresspageobject.getAddressFromAddressTable("Placement")); 

			logger.info("Step 29 : Add an address of type - 'home' and usage - 'temporary'");
			
			addpersonaddresspageobject.AddPersonAddressLocation(buildingNameorNumber1,streetName1,localityName1,townorCity1,county1,postcode1,type1,usage1,year1,Month1,Day1);
			
			logger.info("Step 30 - Enter the name of the same person in the person search box whose address is been added: "+ personid1);
			searchpersonpageobject.enterSearchText(personid1);
			logger.info("Selecting Third Line from AutoSuggest List." );
		
			logger.info("Step 31 - Confirm that the auto-suggest results are now updated to display the home address");
			soft.assertThat(searchpersonpageobject.getPersonAddressLocationFromAutoSuggest()).isEqualTo(addpersonaddresspageobject.getAddressFromAddressTable("Home")); 
			
			soft.assertAll();
			
		}
		
	}

	@Test
	public void PersonAddressDisplay_Test() throws Exception {
		logger.info("Starting inner class execution");
		InnerClass.driver = this.driver;
		InnerClass.logger = this.logger;
		Result runResult = JUnitCore.runClasses(InnerClass.class);
		Login_To_Application.CaptureResults(runResult);
	}

}



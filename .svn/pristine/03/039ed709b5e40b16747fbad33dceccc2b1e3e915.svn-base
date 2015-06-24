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
import com.uspeclipse.commonservices.GenericActions;
import com.uspeclipse.commonservices.MultipleBrowser;
import com.uspeclipse.dataprovider.person.AddPersonAddress_dataprovider;
import com.uspeclipse.helper.Parallelized;
import com.uspeclipse.interfaces.SmokeTest;
import com.uspeclipse.pageobjects.home.Home_pageobjects;
import com.uspeclipse.pageobjects.person.AddPersonAddress_pageobjects;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;
import com.uspeclipse.pageobjects.person.SearchPerson_pageobjects;
import com.uspeclipse.setup.Initialization;

@RunWith(Parallelized.class)
@Category(SmokeTest.class)
public class FindPerson_TestCaseID2650 {
	private WebDriver driver = null;
	private String browsertype="";
	private Initialization Login_To_Application=null;
	Logger logger = Logger.getLogger(FindPerson_TestCaseID2650.class);

	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}

	public FindPerson_TestCaseID2650(String type) {
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

		// Test Case for ID 2650 - Person - Find person by name or id from a keyword search facility from the person page
		
		 @Test
		 @UseDataProvider(location = AddPersonAddress_dataprovider.class, value = "PersonAddressdetails") 
		  public void FindPersonBySearchAutocomplete(String title, String forename,
					String middlename, String surname, String byear, String bmonth,
					String bday, String ethnicity,String postcode,String housename,String type,String usage, String year,String Month,String Day,String type2,
					String usage2,String partialpostcode,String validhouseName,String validhousenumber) throws IOException,
					NoSuchMethodException, SecurityException, InterruptedException {

			 	GenericActions elements = new GenericActions(driver);
				SoftAssertions soft = new SoftAssertions();
			    //Page objects are initialized here.
			    AddPerson_pageobject addpersonpageobject = PageFactory.initElements(driver,
						AddPerson_pageobject.class);
				Home_pageobjects homepageobject = PageFactory.initElements(driver,
						Home_pageobjects.class);
				SearchPerson_pageobjects searchpersonpageobject = PageFactory.initElements(driver,
						SearchPerson_pageobjects.class);
				AddPersonAddress_pageobjects addpersonaddresspageobject = PageFactory.initElements(driver,
					AddPersonAddress_pageobjects.class);
			
				
				//Adding a New person
				addpersonpageobject.AddNewPerson("client", title, forename, middlename, surname,
						byear, bmonth, bday, "Male", ethnicity);
			
			    //Confirming that the 'Search' box has a magnifier glass on the right hand corner of the box.
		        logger.info("Confirming that the 'Search' box has a magnifier glass on the right hand corner of the box");
				soft.assertThat(searchpersonpageobject.magnifierGlassonSearchBoxPresent()).isTrue();
				
				//Confirming that the 'Search' box has default text that is "Enter person name or ID"
				logger.info("Confirming that the 'Search' box has default text that is 'Enter person name or ID'");
				soft.assertThat(searchpersonpageobject.getSearchboxDefaultText("placeholder")).isEqualTo("Enter person name or ID");
				String personId = addpersonpageobject.getPersonID();	
				searchpersonpageobject.enterSearchText(personId);
			    elements.waitForElementFluently(searchpersonpageobject.SearchAutocompleteFirstline ,30);
				
			    //Confirming that for each result the id, name (forename, surname) should be displayed on line 1.
			    logger.info("Confirming that for each result the id, name (forename, surname) are being displayed on line 1");
			    elements.getElementWithIdentification(searchpersonpageobject.SearchAutocompleteFirstline).isDisplayed();
				String[] idName = searchpersonpageobject.getPersonIdName();
				soft.assertThat(addpersonpageobject.getPersonID()).isEqualTo(idName[0]);
				soft.assertThat(forename+" "+surname).isEqualTo(idName[1]);	
				elements.waitForElementFluently(searchpersonpageobject.SearchAutocompleteSecondline,30);
				
				//Confirming that for each result the DoB, age and gender should be displayed on line 2
				logger.info("Confirming that for each result the DoB, age and gender are being displayed on line 2");
				elements.getElementWithIdentification(searchpersonpageobject.SearchAutocompleteSecondline).isDisplayed();
				String[] DOBAgeGender = searchpersonpageobject.getPersonDOBAgeGender();	
				soft.assertThat(searchpersonpageobject.getGender()).isEqualTo(DOBAgeGender[0]);
				soft.assertThat("DoB " +searchpersonpageobject.getexpectedPersonDOBAgeGender()).isEqualTo(DOBAgeGender[1]);	
				soft.assertThat(searchpersonpageobject.getGender() +"," + "DoB" + " " + searchpersonpageobject.getexpectedPersonDOBAgeGender()).isEqualTo(DOBAgeGender[0] + "," + DOBAgeGender[1]);		
			 
				//Confirming that  the third line and fourth line are not displayed when the address for that particular person is not recorded.
				logger.info("Confirming that  the third line and fourth line are not displayed when the address for that particular person is not recorded");
				soft.assertThat(searchpersonpageobject.isLine3and4inSearchAutocompleteDisplayed()).isFalse();
				
			    //Adding Person address
			    addpersonaddresspageobject.AddingPersonAddress(postcode,housename,type,usage,year,Month,Day);		
				elements.clearValue(homepageobject.HomeSearchPersonGlobalTextbox);
				elements.waitForPageLoaded();
				elements.waitForElementFluently(addpersonpageobject.AddPersonButton, 30);
				driver.navigate().refresh();	
				searchpersonpageobject.enterSearchText(personId);
		    	elements.waitForElementFluently(searchpersonpageobject.SearchAutocompleteThirdline ,30);
		    	
		    	//Confirming that Address saved is displayed in 3 & 4 line in Search Autocomplete .
		    	soft.assertThat(searchpersonpageobject.isLine3and4inSearchAutocompleteDisplayed()).isTrue();
				soft.assertThat(searchpersonpageobject.getActualAddressFromSearchAutocompleteThirdLine()).isEqualTo(searchpersonpageobject.getExpectedAddressFromAddressTable());		
				soft.assertAll();
			

		}
		
	}

	@Test
	public void FindPerson_Test() throws Exception {
		logger.info("Starting inner class execution");
		InnerClass.driver = this.driver;
		InnerClass.logger = this.logger;
		Result runResult = JUnitCore.runClasses(InnerClass.class);
		Login_To_Application.CaptureResults(runResult);
	}

}
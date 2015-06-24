package com.uspeclipse.testscripts.casenotes;

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
import com.uspeclipse.helper.Parallelized;
import com.uspeclipse.interfaces.SmokeTest;
import com.uspeclipse.pageobjects.casenotes.PractitionerOrganisationFilter_pageobject;
import com.uspeclipse.pageobjects.casenotes.SourceFilter_pageobject;
import com.uspeclipse.pageobjects.home.Home_pageobjects;
import com.uspeclipse.pageobjects.login.EclipseLogin_pageobject;
import com.uspeclipse.pageobjects.person.SearchPerson_pageobjects;
import com.uspeclipse.setup.Initialization;
import com.uspeclipse.setup.LoggerHelper;
import com.uspeclipse.testscripts.casenotes.AddEntryPersonScenario1_TestCaseID35635.InnerClass;


@RunWith(Parallelized.class)
@Category(SmokeTest.class)
public class PractitionerOrganisationFilterScenario2_TestCaseID32974 extends Initialization {
	
	private WebDriver driver = null;
	private String browsertype = "";
	private Initialization Login_To_Application=null;
	Logger logger = Logger.getLogger(PractitionerOrganisationFilterScenario2_TestCaseID32974.class);
	
	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}

	public PractitionerOrganisationFilterScenario2_TestCaseID32974(String type) {
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
	
	
	
     /* Test Case for ID 32974(Scenario 2) - This test is to demonstrate that as a user who has the right to view Case Notes I wish to be able to apply a set of Practitioner filters to reduce the number of entries shown in the
	  Case Note record to only those made by the selected Practitioners*/
	
	    @Test
	//	@UseDataProvider(location = AddNewPerson_dataprovider.class, value = "PersonDetails")
		public void PractitionerOrganisationFilterScenario2Test()  throws IOException,
				NoSuchMethodException, SecurityException, InterruptedException  {
	
	     SoftAssertions soft = new SoftAssertions();	
	    	
         //Page objects are Initialized here 	    	
	    	
	    	Home_pageobjects homepageobject = PageFactory.initElements(driver,
					Home_pageobjects.class);
			SearchPerson_pageobjects searchpageobject = PageFactory.initElements(
					driver, SearchPerson_pageobjects.class);
			SourceFilter_pageobject srcfilterpageobject = PageFactory.initElements(
					driver, SourceFilter_pageobject.class);
			PractitionerOrganisationFilter_pageobject practitionerorganisationfilterpageobject = PageFactory.initElements(
					driver,PractitionerOrganisationFilter_pageobject.class );
			EclipseLogin_pageobject eclipse_pageobject = PageFactory.initElements(
					driver, EclipseLogin_pageobject.class);
	      
			
			//	Select a client from either the 'Your recently accessed records' list or the 'Your case load' list or search for a client from the quick person search at the top of the screen
			logger.info("Step 2 - Select a client from either the 'Your recently accessed records' list or the 'Your case load' list or search for a client from the quick person search at the top of the screen");
			searchpageobject.enterSearchText("Mark Thomas");
			homepageobject.clickonAutoSuggestioninSearch();
	
			
			
			//Click on CasenoteLink
			logger.info("Step 3 - Click on Case Notes Menu item");
			homepageobject.clickonCasenoteLink();
			soft.assertThat(
					srcfilterpageobject.isColumnHeaderDisplayed("Entry Date"))
					.as("Entry Date Column Table header should be Displayed")
					.isTrue();
			soft.assertThat(srcfilterpageobject.isColumnHeaderDisplayed("Entry"))
					.as("Entry Column Table header should be Displayed").isTrue();
			soft.assertThat(
					srcfilterpageobject.isColumnHeaderDisplayed("Entry Type"))
					.as("Entry Type Column Table header should be Displayed")
					.isTrue();
			soft.assertThat(srcfilterpageobject.isColumnHeaderDisplayed("Impact"))
					.as("Impact Column Table header should be Displayed").isTrue();
			soft.assertThat(srcfilterpageobject.isColumnHeaderDisplayed("Source"))
					.as("Source Column Table header should be Displayed").isTrue();
			soft.assertThat(
					srcfilterpageobject.isColumnHeaderDisplayed("Practitioner"))
					.as("Practitioner Column Table header should be Displayed")
					.isTrue();
			soft.assertThat(srcfilterpageobject.isColumnHeaderDisplayed("Status"))
					.as("Status Column Table header should be Displayed").isTrue();
			soft.assertThat(srcfilterpageobject.isColumnHeaderDisplayed("Actions"))
					.as("Actions Column Table header should be Displayed").isTrue();
			
			
			//Step -4 - Click on Filter Button
			logger.info("Step 4 - Click on the Filter button.");
			srcfilterpageobject.clickonSourceFilterButton();
			soft.assertThat(srcfilterpageobject.isFilterByTabDisplayed("Date"))
					.as("Date Filter Tab should be Displayed").isTrue();
			soft.assertThat(srcfilterpageobject.isFilterByTabDisplayed("People"))
					.as("People Filter Tab should be Displayed").isTrue();
			soft.assertThat(srcfilterpageobject.isFilterByTabDisplayed("Type"))
					.as("Type annd other Filter Tab should be Displayed").isTrue();
			soft.assertThat(srcfilterpageobject.isFilterByTabDisplayed("Group"))
					.as("Group Filter Tab should be Displayed").isTrue();
			
			
			int records = practitionerorganisationfilterpageobject.getNumberofRecordsforPractitionerOrganisationFilterSelection();
					
			
			
			//Step -5 Click on Peoples Tab 
			
			  logger.info("Step 5 - Click on the Peoplestab");
			  srcfilterpageobject.clickonPeopleTabinFilterBy();
			  srcfilterpageobject.clickonFilterResetLink();
			  Thread.sleep(5000);
			
			  //Verify whether all filters and buttons shown under People tab
			
			  logger.info("Step 5(Expected output) - Verify all Filters and buttons are shown");
			  soft.assertThat(
			  practitionerorganisationfilterpageobject.isFiltersAndButtonsUnderPeoplesTabDisplayed("PractitionerFilter"))
			  .as("PractitionerFilter is displayed")
			   .isTrue();
			  
			  soft.assertThat(
			  practitionerorganisationfilterpageobject.isFiltersAndButtonsUnderPeoplesTabDisplayed("PractitionerOrganisationFilter"))
			  .as("PractitionerOrganisationFilter is displayed")
			  .isTrue();
			
			  soft.assertThat(
			  practitionerorganisationfilterpageobject.isFiltersAndButtonsUnderPeoplesTabDisplayed("SourceFilter"))
			  .as("SourceFilter is displayed")
			  .isTrue();
			  
			  soft.assertThat(
			  practitionerorganisationfilterpageobject.isFiltersAndButtonsUnderPeoplesTabDisplayed("SourceOrganisation"))
			  .as("SourceOrganisation is displayed")
			  .isTrue();
			  
			  soft.assertThat(
			  practitionerorganisationfilterpageobject.isFiltersAndButtonsUnderPeoplesTabDisplayed("ResetButton"))
			  .as("ResetButton is displayed")
			  .isTrue();
			  
	          //Storing the Text of option		 
			  String[] Option = practitionerorganisationfilterpageobject.storeTextofOptionsfromPractitionerOrganisationFilterMultiSelectBox();				
			  String numberofoptions = practitionerorganisationfilterpageobject.getNumberofOptionsfromPractitionerOrganisationFilterMultiSelectBox();	  
			  int lastoption = Integer.parseInt(numberofoptions);
			  System.out.println(Option[lastoption]);
					  
	         //step 6 - Click on the first name listed in the Practitioner Organisation Filter	
			  
			  logger.info("Step 6 - Click on the first name listed in the Practioner Organisation Filter");
			  practitionerorganisationfilterpageobject.selectOptionbyNumberFromPractitionerOrganisationFilterMultiSelectBox("0");
			
			  soft.assertThat(
						practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
						.as("Practitioner Organisation Filter is displayed  Active Filter")
						.isTrue();		
			  soft.assertThat(srcfilterpageobject.isResetAllFiltersLinkDisplayed())
				.as("Reset All Link in Active Filter should be Displayed")
				.isTrue();
			 
			  soft.assertThat(
						practitionerorganisationfilterpageobject.isResultforSinglePractitionerOrganisationSelectionCorrect(Option[0]))
						.as("Only PractitionerOrganisation with 0" + Option[0]
								+ " Option should be displayed").isTrue();
			  
			  
			  //step 7 - Remove the filter selection using any of the available methods.
			 
			  logger.info("Step 7 - Remove the filter selection using any of the available methods");
			 practitionerorganisationfilterpageobject.clickonPractitionerOrganisationFilterRemoveButton();
			 
			  soft.assertThat(						
	     	  practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
			 .as("Practitioner Organisation Filter Selection Indicator in Active Filter should not be Displayed")
			 .isFalse();
			  			  
			  soft.assertThat(
			  practitionerorganisationfilterpageobject.getNumberofRecordsforPractitionerOrganisationFilterSelection())
			  .as("Numbers of Records should match at step 7").isEqualTo(records);	  
					  
						
	         //Step 8 - Click on the last name listed in the Practitioner Organisation Filter		
			
			 logger.info("Step 8 - Click on the last name listed in the Practitioner Organisation Filter");
			 practitionerorganisationfilterpageobject.selectOptionbyNumberFromPractitionerOrganisationFilterMultiSelectBox(numberofoptions);
			 soft.assertThat(
						practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
						.as("Practitioner Organisation Filter is displayed  Active Filter")
						.isTrue();	
			 soft.assertThat(srcfilterpageobject.isResetAllFiltersLinkDisplayed())
				.as("Reset All Link in Active Filter should be Displayed")
				.isTrue();
			 
			 soft.assertThat(					
					 practitionerorganisationfilterpageobject
					 .isResultforSinglePractitionerOrganisationSelectionCorrect(Option[lastoption]))
						.as("Only Practitioner Organisation with Last" + lastoption
								+ " Option should be displayed").isTrue();
			  
			

			 //Step 9 - Remove the filter selection using any of the available methods	
			
			 logger.info("Step 9 - Remove the filter selection using any of the available methods");
			 practitionerorganisationfilterpageobject.clickonPractitionerOrganisationFilterRemoveButton();
			  soft.assertThat(						
	     	  practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
			 .as("Practitioner Organisation Filter Selection Indicator in Active Filter should not be Displayed")
			 .isFalse();
			  			  
			  soft.assertThat(
			  practitionerorganisationfilterpageobject.getNumberofRecordsforPractitionerOrganisationFilterSelection())
			  .as("Numbers of Records should match at step 9").isEqualTo(records);  
				
			
			  //Step 10 - Click on a Practitioner Organisation listed in the Practitioner Organisation Filter (not the first or the last)
			
			  logger.info("Step 10 - Click on a Practitioner Organisation listed in the Practtiioner Organisation Filter (not the first or the last)");
			  practitionerorganisationfilterpageobject
			  .selectOptionbyNumberFromPractitionerOrganisationFilterMultiSelectBox("1");
			  soft.assertThat(
						 practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
						.as("Practitioner Organisation Filter should be displayed in Active Filter")
						.isTrue();
			  soft.assertThat(srcfilterpageobject.isResetAllFiltersLinkDisplayed())
				       .as("Reset All Link in Active Filter should be Displayed")
				       .isTrue();
			  
			  soft.assertThat(					
						 practitionerorganisationfilterpageobject
						 .isResultforSinglePractitionerOrganisationSelectionCorrect(Option[1]))
						 .as("Only Practitioner Organisation with 1" + Option[1]
									+ " Option should be displayed").isTrue();
				  
				
			  
			  //Step 11 - Remove the filter selection using any of the available methods	
				
				  logger.info("Step 11 - Remove the filter selection using any of the available methods");
				  practitionerorganisationfilterpageobject.clickonPractitionerOrganisationFilterRemoveButton();
				  soft.assertThat(						
		     	  practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
				 .as("Practitioner Organisation Filter Selection Indicator in Active Filter should not be Displayed")
				 .isFalse();
				  			  
				  soft.assertThat(
				  practitionerorganisationfilterpageobject.getNumberofRecordsforPractitionerOrganisationFilterSelection())
				  .as("Numbers of Records should match at step 11").isEqualTo(records);  
				
			/* Step 12 - Click on the first name and the last name listed in the Practioner Organisation Filter 
			  (Hold down the <ctrl> while selecting Practitioner Organisation Names)	*/
			
		   logger.info("Step 12 - Click on the first name and the last name listed in the Practioner Organisation Filter"); 
		   practitionerorganisationfilterpageobject
			  .selectOptionbyNumberFromPractitionerOrganisationFilterMultiSelectBox("0,"
						+ numberofoptions);
		   soft.assertThat(
					 practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
					.as("Practitioner Organisation Filter should be displayed in Active Filter")
					.isTrue();
		  soft.assertThat(srcfilterpageobject.isResetAllFiltersLinkDisplayed())
			       .as("Reset All Link in Active Filter should be Displayed")
			       .isTrue();
		   
		  soft.assertThat(					
					 practitionerorganisationfilterpageobject
					 .isResultforDoublePractitionerOrganisationSelectionCorrect(Option[0],Option[lastoption]))
					 .as("Only Practitioner Organisation with"  + Option[1] + " and " + lastoption
								+ " Option should be displayed").isTrue();
		   
		   
		   
		  //Step 13 - Remove the filter selection using any of the available methods	
			
		  logger.info("Step 13 - Remove the filter selection using any of the available methods");
		  practitionerorganisationfilterpageobject.clickonPractitionerOrganisationFilterRemoveButton();
		  soft.assertThat(						
     	  practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
		 .as("Practitioner Organisation Filter Selection Indicator in Active Filter should not be Displayed")
		 .isFalse();
		  			  
		  soft.assertThat(
		  practitionerorganisationfilterpageobject.getNumberofRecordsforPractitionerOrganisationFilterSelection())
		  .as("Numbers of Records should match at step 13").isEqualTo(records);  
	
			
		//Step 14 -Select any other two Practitioner Organisation  Names from the Practitioner Organisation Filter
		  
		practitionerorganisationfilterpageobject
		  .selectOptionbyNumberFromPractitionerOrganisationFilterMultiSelectBox("1,2");
					
		  soft.assertThat(
					 practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
					.as("Practitioner Organisation Filter should be displayed in Active Filter")
					.isTrue();
		  soft.assertThat(srcfilterpageobject.isResetAllFiltersLinkDisplayed())
			       .as("Reset All Link in Active Filter should be Displayed")
			       .isTrue();
		  
		  soft.assertThat(					
					 practitionerorganisationfilterpageobject
					 .isResultforDoublePractitionerOrganisationSelectionCorrect(Option[1],Option[2]))
					 .as("Only Practitioner Organisation with"  + Option[1] + " and " + Option[2]
								+ " Option should be displayed").isTrue();
		  
		  
		  //Step 15 - Remove the filter selection using any of the available methods	
			
		  logger.info("Step 15 - Remove the filter selection using any of the available methods");
		  practitionerorganisationfilterpageobject.clickonPractitionerOrganisationFilterRemoveButton();
		  soft.assertThat(						
     	  practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
		 .as("Practitioner Organisation Filter Selection Indicator in Active Filter should not be Displayed")
		 .isFalse();
		  			  
		  soft.assertThat(
		  practitionerorganisationfilterpageobject.getNumberofRecordsforPractitionerOrganisationFilterSelection())
		  .as("Numbers of Records should match at step 15").isEqualTo(records);  
	
		  
		  
		  
		 //Step16 -  Click on the first name, the last name and another name listed in the Practioner Organisation Filter

		  practitionerorganisationfilterpageobject
		  .selectOptionbyNumberFromPractitionerOrganisationFilterMultiSelectBox("0,1," + numberofoptions);
					
		  soft.assertThat(
					 practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
					.as("Practitioner Organisation Filter should be displayed in Active Filter")
					.isTrue();
		  soft.assertThat(srcfilterpageobject.isResetAllFiltersLinkDisplayed())
			       .as("Reset All Link in Active Filter should be Displayed")
			       .isTrue();
		
		  soft.assertThat(practitionerorganisationfilterpageobject.isResultforTriplePractitionerOrganisationSelectionCorrect(Option[0],
				          Option[1], Option[lastoption]))
		                .as("Only PractitionerOrganisation Filter  with"  + Option[0] + " and " + Option[1]
		                +  " and " + Option[lastoption] + " Option should be displayed") .isTrue(); 
					
		
		  //Step 17 - Remove the filter selection using any of the available methods	
			
		  logger.info("Step 17 - Remove the filter selection using any of the available methods");
		  practitionerorganisationfilterpageobject.clickonPractitionerOrganisationFilterRemoveButton();
		  soft.assertThat(						
     	  practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
		 .as("Practitioner Organisation Filter Selection Indicator in Active Filter should not be Displayed")
		 .isFalse();		  			  
		  soft.assertThat(
		  practitionerorganisationfilterpageobject.getNumberofRecordsforPractitionerOrganisationFilterSelection())
		  .as("Numbers of Records should match at step 17").isEqualTo(records);
		  
       
		  //Step 18 - Click on the first name, and two other names listed in the Practitioner Organisation Filter	  
		
		  logger.info("Step 18 - Click on the first name, and two other names listed in the Practitioner Organisation Filter"); 
		  
		  practitionerorganisationfilterpageobject
		  .selectOptionbyNumberFromPractitionerOrganisationFilterMultiSelectBox("0,1,2");
					
		  soft.assertThat(
					 practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
					.as("Practitioner Organisation Filter should be displayed in Active Filter")
					.isTrue();
		  soft.assertThat(srcfilterpageobject.isResetAllFiltersLinkDisplayed())
			       .as("Reset All Link in Active Filter should be Displayed")
			       .isTrue();
		
		  soft.assertThat(practitionerorganisationfilterpageobject.isResultforTriplePractitionerOrganisationSelectionCorrect(Option[0],
				          Option[1], Option[2]))
		                .as("Only PractitionerOrganisation Filter  with"  + Option[0] + " and " + Option[1]
		                +  " and " + Option[2] + " Option should be displayed") .isTrue(); 
		  
	
		//Step 19 - Remove the filter selection using any of the available methods	
			
		  logger.info("Step 19 - Remove the filter selection using any of the available methods");
		  practitionerorganisationfilterpageobject.clickonPractitionerOrganisationFilterRemoveButton();
		  soft.assertThat(						
     	  practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
		 .as("Practitioner Organisation Filter Selection Indicator in Active Filter should not be Displayed")
		 .isFalse();		  			  
		  soft.assertThat(
		  practitionerorganisationfilterpageobject.getNumberofRecordsforPractitionerOrganisationFilterSelection())
		  .as("Numbers of Records should match at step 19").isEqualTo(records);
			
	    	
	    	
	     // Step 20 - Click on the last name, and two other names listed in the Practitioner Organisation Filter
	
        logger.info("Step 20 - Click on the last name, and two other names listed in the Practitioner Organisation Filter"); 
		  
		  practitionerorganisationfilterpageobject
		  .selectOptionbyNumberFromPractitionerOrganisationFilterMultiSelectBox(numberofoptions + ",1,2");
					
		  soft.assertThat(
					 practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
					.as("Practitioner Organisation Filter should be displayed in Active Filter")
					.isTrue();
		  soft.assertThat(srcfilterpageobject.isResetAllFiltersLinkDisplayed())
			       .as("Reset All Link in Active Filter should be Displayed")
			       .isTrue();
		
		  soft.assertThat(practitionerorganisationfilterpageobject.isResultforTriplePractitionerOrganisationSelectionCorrect(Option[lastoption],
				          Option[1], Option[2]))
		                .as("Only PractitionerOrganisation Filter  with"  + numberofoptions +" and " + Option[1] + " and " + Option[2]
		                + " Option should be displayed") .isTrue(); 
		  

		  
		//Step 21 - Remove the filter selection using any of the available methods	
			
		  logger.info("Step 21 - Remove the filter selection using any of the available methods");
		  practitionerorganisationfilterpageobject.clickonPractitionerOrganisationFilterRemoveButton();
		  soft.assertThat(						
     	  practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
		 .as("Practitioner Organisation Filter Selection Indicator in Active Filter should not be Displayed")
		 .isFalse();		  			  
		  soft.assertThat(
		  practitionerorganisationfilterpageobject.getNumberofRecordsforPractitionerOrganisationFilterSelection())
		  .as("Numbers of Records should match at step 21").isEqualTo(records);
		  
		 
		  //Step 22 - Click on the any three names listed in the Practitioner Organisation Filter (Do not select the first and last names in the list)
		  
		  logger.info("Step 22 - Click on the any three names listed in the Practitioner Organisation Filter (Do not select the first and last names in the list)"); 
		  practitionerorganisationfilterpageobject
		  .selectOptionbyNumberFromPractitionerOrganisationFilterMultiSelectBox("1,2,3");
					
		  soft.assertThat(
					 practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
					.as("Practitioner Organisation Filter should be displayed in Active Filter")
					.isTrue();
		  soft.assertThat(srcfilterpageobject.isResetAllFiltersLinkDisplayed())
			       .as("Reset All Link in Active Filter should be Displayed")
			       .isTrue();
		
		  soft.assertThat(practitionerorganisationfilterpageobject.isResultforTriplePractitionerOrganisationSelectionCorrect(Option[1],
				          Option[2], Option[3]))
		                .as("Only PractitionerOrganisation Filter  with"  + Option[1]  +" and " + Option[2] + " and " + Option[3]
		                + " Option should be displayed") .isTrue(); 
		  
		  
		//Step 23 - Remove the filter selection using any of the available methods	
			
		  logger.info("Step 22 - Remove the filter selection using any of the available methods");
		  practitionerorganisationfilterpageobject.clickonPractitionerOrganisationFilterRemoveButton();
		  soft.assertThat(						
     	  practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
		 .as("Practitioner Organisation Filter Selection Indicator in Active Filter should not be Displayed")
		 .isFalse();		  			  
		  soft.assertThat(
		  practitionerorganisationfilterpageobject.getNumberofRecordsforPractitionerOrganisationFilterSelection())
		  .as("Numbers of Records should match at step 23").isEqualTo(records);
		  
	                           	//Multiple Practitioner Selections 
		  
		//Step 24 -  Select all Practitioner Organisations
		  
		  logger.info("Step 24 - Select all Practitioner Organisations");
		  practitionerorganisationfilterpageobject.selectAllOptionsFromPractitionerOrganisationFilterMultiSelectBox(); 
		  soft.assertThat(
					 practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
					.as("Practitioner Organisation Filter should be displayed in Active Filter")
					.isTrue();
		  soft.assertThat(srcfilterpageobject.isResetAllFiltersLinkDisplayed())
			       .as("Reset All Link in Active Filter should be Displayed")
			       .isTrue();
		  soft.assertThat(practitionerorganisationfilterpageobject.getNumberofRecordsforPractitionerOrganisationFilterSelection())
				  .as("Numbers of Records should match after selecting all practitioner organisations").isEqualTo(records);
		  
		 
		//Step 25 -	Remove the filter selection using any of the available methods
			
		  logger.info("Step 25 - Remove the filter selection using any of the available methods");
		  practitionerorganisationfilterpageobject.clickonPractitionerOrganisationFilterRemoveButton();
		  soft.assertThat(						
     	  practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
		 .as("Practitioner Organisation Filter Selection Indicator in Active Filter should not be Displayed")
		 .isFalse();		  			  
		  soft.assertThat(
		  practitionerorganisationfilterpageobject.getNumberofRecordsforPractitionerOrganisationFilterSelection())
		  .as("Numbers of Records should match at step 25").isEqualTo(records);
		  
		  
		//Step 26 -	Click on the first name, the last name and any other two names listed in the Practitioner Organisation Filter 
		  logger.info("Step 26 - Click on the first name, the last name and any other two names listed in the Practioner Organisation Filter");
		  practitionerorganisationfilterpageobject.selectOptionbyNumberFromPractitionerOrganisationFilterMultiSelectBox("0,1,2,"
						+ numberofoptions);
		  soft.assertThat(
					 practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
					.as("Practitioner Organisation Filter should be displayed in Active Filter")
					.isTrue();
		  soft.assertThat(srcfilterpageobject.isResetAllFiltersLinkDisplayed())
			       .as("Reset All Link in Active Filter should be Displayed")
			       .isTrue();
		  soft.assertThat(practitionerorganisationfilterpageobject.isResultforMultiplePractitionerOrganisationSelectionCorrect
				         (Option[0], Option[1], Option[2], Option[lastoption]))
	                     .as("Only PractitionerOrganisation with " + Option[0] + ", " + Option[1] + ", "
							+ Option[2] + " and " + Option[lastoption]
							+ " Option should be displayed").isTrue();
		  
		  
		  
		  //Step 27 -	Remove the filter selection using any of the available methods
			
		  logger.info("Step 27 - Remove the filter selection using any of the available methods");
		  practitionerorganisationfilterpageobject.clickonPractitionerOrganisationFilterRemoveButton();
		  soft.assertThat(						
     	  practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
		 .as("Practitioner Organisation Filter Selection Indicator in Active Filter should not be Displayed")
		 .isFalse();		  			  
		  soft.assertThat(
		  practitionerorganisationfilterpageobject.getNumberofRecordsforPractitionerOrganisationFilterSelection())
		  .as("Numbers of Records should match at step 27").isEqualTo(records);
		  
		  //Step 28 -	Click on the names of four names listed in the Practitioner Organisation Filter
		  logger.info("Step 28 - Click on the names of four names listed in the Practitioner Organisation Filter");
		  practitionerorganisationfilterpageobject.selectOptionbyNumberFromPractitionerOrganisationFilterMultiSelectBox("0,1,2,3");
		  soft.assertThat(
					 practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
					.as("Practitioner Organisation Filter should be displayed in Active Filter")
					.isTrue();
		  soft.assertThat(srcfilterpageobject.isResetAllFiltersLinkDisplayed())
			       .as("Reset All Link in Active Filter should be Displayed")
			       .isTrue();	
		  soft.assertThat(practitionerorganisationfilterpageobject.isResultforMultiplePractitionerOrganisationSelectionCorrect
			         (Option[0], Option[1], Option[2], Option[3]))
                  .as("Only PractitionerOrganisation with " + Option[0] + ", " + Option[1] + ", "
						+ Option[2] + " and " + Option[3]
						+ " Option should be displayed").isTrue();
		  
		  //Step 29 -	Remove the filter selection using any of the available methods
			
		  logger.info("Step 29 - Remove the filter selection using any of the available methods");
		  practitionerorganisationfilterpageobject.clickonPractitionerOrganisationFilterRemoveButton();
		  soft.assertThat(						
     	  practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
		 .as("Practitioner Organisation Filter Selection Indicator in Active Filter should not be Displayed")
		 .isFalse();		  			  
		  soft.assertThat(
		  practitionerorganisationfilterpageobject.getNumberofRecordsforPractitionerOrganisationFilterSelection())
		  .as("Numbers of Records should match at step 29").isEqualTo(records);
	    
		  
		//Step 30 -	Click on the first name, the last name and any other three names listed in the Practioner Organisation Filter
		  
		 practitionerorganisationfilterpageobject.selectOptionbyNumberFromPractitionerOrganisationFilterMultiSelectBox("0,1,2,3,"
					+ numberofoptions);
	  soft.assertThat(
				 practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
				.as("Practitioner Organisation Filter should be displayed in Active Filter")
				.isTrue();
	  soft.assertThat(srcfilterpageobject.isResetAllFiltersLinkDisplayed())
		       .as("Reset All Link in Active Filter should be Displayed")
		       .isTrue();
	  soft.assertThat(practitionerorganisationfilterpageobject.isResultforMultiplePractitionerOrganisationSelectionForFiveOptionsCorrect
			         (Option[0], Option[1], Option[2],  Option[3], Option[lastoption]))
                   .as("Only PractitionerOrganisation with " + Option[0] + ", " + Option[1] + ", "
						+ Option[2] + " ," +  Option[3] +  Option[lastoption]
						+ " Option should be displayed").isTrue();
	  
		  
	  //Step 31 -	Remove the filter selection using any of the available methods
		
	  logger.info("Step 31 - Remove the filter selection using any of the available methods");
	  practitionerorganisationfilterpageobject.clickonPractitionerOrganisationFilterRemoveButton();
	  soft.assertThat(						
 	  practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
	 .as("Practitioner Organisation Filter Selection Indicator in Active Filter should not be Displayed")
	 .isFalse();		  			  
	  soft.assertThat(
	  practitionerorganisationfilterpageobject.getNumberofRecordsforPractitionerOrganisationFilterSelection())
	  .as("Numbers of Records should match at step 31").isEqualTo(records);	
	  
	  
	  //Step 32 - Click on Log out
	  
	  logger.info("Step 32 - Click on Log out");
	  eclipse_pageobject.EclipseLogout();
		  
	  soft.assertAll();
	  
	  
	    
	    }
}

	@Test
	public void PractitionerOrganisationFilterScenario2Test() throws Exception {
		logger.info("Starting inner class execution");
		InnerClass.driver = this.driver;
		InnerClass.logger = this.logger;
		Result runResult = JUnitCore.runClasses(InnerClass.class);
		Login_To_Application.CaptureResults(runResult);
	}
}


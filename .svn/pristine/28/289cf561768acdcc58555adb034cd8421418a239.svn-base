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
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.*;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import com.uspeclipse.commonservices.Constants;
import com.uspeclipse.commonservices.GenericActions;
import com.uspeclipse.commonservices.MultipleBrowser;
import com.uspeclipse.dataprovider.casenotes.DateFilter_dataprovider;
import com.uspeclipse.helper.Parallelized;
import com.uspeclipse.interfaces.SmokeTest;
import com.uspeclipse.pageobjects.casenotes.*;
import com.uspeclipse.pageobjects.home.Home_pageobjects;
import com.uspeclipse.pageobjects.person.SearchPerson_pageobjects;
import com.uspeclipse.setup.Initialization;

@RunWith(Parallelized.class)
@Category(SmokeTest.class)
public class DateFilterScenario1_TestcaseID35650 {
	private WebDriver driver = null;
	private String browsertype = "";
	private Initialization Login_To_Application=null;
	Logger logger = Logger.getLogger(DateFilterScenario1_TestcaseID35650.class);

	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}

	public DateFilterScenario1_TestcaseID35650(String type) {
		Thread.currentThread().setName(type);
		driver = (new MultipleBrowser()).getBrowserDriver(type, this.getClass()
				.getSimpleName());
		browsertype = type.toLowerCase();

	}

	@Before
	public void setUp() throws Throwable {
		Login_To_Application = new Initialization();
		Login_To_Application.Start(browsertype,driver);
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

		/* Test Case for ID 35650(Scenario 1) - This test is to demonstrate that as a user who is a Care Professional I wish to be able to apply a set of date filters to reduce the number of entries shown in the 
		  * Case Note Record  to only those on the selected dates. */
		
		@Test
		@UseDataProvider(location = DateFilter_dataprovider.class, value = "DateFilter")
		public void DateFilterScenario1Test(String InvalidDateFrom, String invaliddateTo,String dateFrom,String dateTo,String validdateFrom, String validdateTo)
				throws Exception {
		
			GenericActions elements = new GenericActions(driver);
			SoftAssertions soft = new SoftAssertions();
			//Page objects are Initialized here 	    	
	    	
	    	Home_pageobjects homepageobject = PageFactory.initElements(
					driver,Home_pageobjects.class);
			SearchPerson_pageobjects searchpageobject = PageFactory.initElements(
					driver,			SearchPerson_pageobjects.class);
			SourceFilter_pageobject srcfilterpageobject = PageFactory.initElements(
					driver,SourceFilter_pageobject.class);
			/*PractitionerOrganisationFilter_pageobject practitionerorganisationfilterpageobject = PageFactory.initElements(
					PractitionerOrganisationFilter_pageobject.class );*/

	        PractitionerFilter_pageobject practitionerfilterpageobject = PageFactory.initElements(
	    			driver,PractitionerFilter_pageobject.class);
		   
	        DateFilter_pageobject datefilterpageobject = PageFactory.initElements(
	    			driver,		DateFilter_pageobject.class);
	        
            EditCaseNotes_pageobjects editcasenotepageobject = PageFactory.initElements(
        			driver,EditCaseNotes_pageobjects.class);
	    
	         
			//Step 2:	Select a client from either the 'Your recently accessed records' list or the 'Your case load' list or search for a client from the quick person search at the top of the screen
			logger.info("Step 2 - Select a client from either the 'Your recently accessed records' list or the 'Your case load' list or search for a client from the quick person search at the top of the screen");
			 if ((Initialization.browserName.equals("ios-ipad"))){
				 elements.waitForElementFluently(homepageobject.PersonLink, 30);
				// elements.waitForPageLoaded();
				    }
			searchpageobject.enterSearchText("Ravindra jadeja");
			homepageobject.clickonAutoSuggestioninSearch();
	        
	        
			
			
			//Step 6 :Click on CasenoteLink
			logger.info("Step 4 - Click on Case Notes Menu item");
			homepageobject.clickonCasenoteLink();
			 if ((Initialization.browserName.equals("ios-ipad"))){
				 elements.waitForElementFluently(homepageobject.PersonLink, 30);
				 elements.waitForPageLoaded();
				    }
			
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
			
			
		   // Step -4 - Click on Filter Button
			logger.info("Step 4 - Click on the Filter button");
			
			datefilterpageobject.clickonFilterButton();
			
			soft.assertThat(datefilterpageobject.isFieldUnderDateTabDisplayed("Date from"))
			.as("Date from field should be Displayed").isTrue();
		
			soft.assertThat(datefilterpageobject.isFieldUnderDateTabDisplayed("Date To"))
			.as("Date To field should be Displayed").isTrue();
			
			soft.assertThat(datefilterpageobject.isFieldUnderDateTabDisplayed("Last7daysLink"))
			.as("Last7daysLink should be Displayed").isTrue();
			
			soft.assertThat(datefilterpageobject.isFieldUnderDateTabDisplayed("Last30DaysLink"))
			.as("Last30DaysLink should be Displayed").isTrue();
			
			soft.assertThat(datefilterpageobject.isFieldUnderDateTabDisplayed("LastYearLink"))
			.as("LastYearLink should be Displayed").isTrue();
			
			soft.assertThat(datefilterpageobject.isFieldUnderDateTabDisplayed("ResetAllButton"))
			.as("LastYearLink should be Displayed").isTrue();
			
			int records = practitionerfilterpageobject.getTotalNumberofRecordsInTheResultTable();
			
	        // Filtering using Pre-defined Periods
			
			
		    // Step 9:	Click the  "Last 7 days" link
		
			logger.info("Step 9 - Click on the Last 7 days Link");
			datefilterpageobject.clickOnLast7daysLink();
			
			elements.waitForPageLoaded();
			
			soft.assertThat(datefilterpageobject.isFilterIconinDateTabDisplayed())
			.as("Filter Icon in People Tab should be Displayed").isTrue();
			
			
			
			soft.assertThat(datefilterpageobject.verifyRecordsDisplayedOnClickingOnLast7daysLink())
			.as("Last 7 days Records are being displayed in the table").isTrue();
		
			
			
			//Step 10 : Remove the filter selection using any of the available methods.
			
			logger.info("Step 10 - Remove the filter selection using any of the available methods");
			datefilterpageobject.clickOnResetButton();
			
			  soft.assertThat(						
			     	  datefilterpageobject.isDateFilterInActiveFilterListDisplayed())
					 .as("Date Filter Selection Indicator in Active Filter should not be Displayed")
					 .isFalse();
			  
			  soft.assertThat(
					  practitionerfilterpageobject.getTotalNumberofRecordsInTheResultTable())
					  .as("Numbers of Records should match").isEqualTo(records);
			  
			  // Step 11 : Click on last 30 days link 
			  
			  logger.info("Step 11 : Click on last 30 days links");
			  datefilterpageobject.clickOnLast30daysLink();
			  
			  elements.waitForPageLoaded();
			  
			  soft.assertThat(datefilterpageobject.isFilterIconinDateTabDisplayed())
				.as("Filter Icon in People Tab should be Displayed").isTrue();
			  
			  soft.assertThat(datefilterpageobject.verifyRecordsDisplayedOnClickingOnLast30daysLink()).
			  as("Last 30 days records is being displayed in the result table").isTrue();
			  
			
			  //Step 12 : Remove the filter selection using any of the available methods.
			  logger.info("Step 12 - Remove the filter selection using any of the available methods");
			  datefilterpageobject.clickOnResetButton();
				
				  soft.assertThat(						
				     	  datefilterpageobject.isDateFilterInActiveFilterListDisplayed())
						 .as("Date Filter Selection Indicator in Active Filter should not be Displayed")
						 .isFalse();
				  
				  soft.assertThat(
						  practitionerfilterpageobject.getTotalNumberofRecordsInTheResultTable())
						  .as("Numbers of Records should match").isEqualTo(records);		  
			  
			  //Step 13 : Click on Last Year link
				  
				  logger.info("Step 13 : Click on last year links");  
			
		      datefilterpageobject.clickOnLastyearLink();
		      
		      elements.waitForPageLoaded();
		      
		      soft.assertThat(datefilterpageobject.verifyRecordsDisplayedOnClickingOnLastYearLink())
		      . as("Last year (365 days) records is being displayed in the result table").isTrue();
				  
				  
		      //Step 14 : Remove the filter selection using any of the available methods.
			  logger.info("Step 14 - Remove the filter selection using any of the available methods");
				datefilterpageobject.clickOnResetButton();
				
				  soft.assertThat(						
				     	  datefilterpageobject.isDateFilterInActiveFilterListDisplayed())
						 .as("Date Filter Selection Indicator at step 14 in Active Filter should not be Displayed")
						 .isFalse();
				  
				  soft.assertThat(
						  practitionerfilterpageobject.getTotalNumberofRecordsInTheResultTable())
						  .as("Numbers of Records should match at step 14").isEqualTo(records);
		      
		      
				  //Step 16 :Enter an invalid date in the "From" field.
				  logger.info("Step 16 - Enter an invalid date in the From field");
				  datefilterpageobject.enterValueinDateFromTextbox(InvalidDateFrom);
				  
				  elements.pressEnterKey();
				  
				  datefilterpageobject.clickOnDateToTextBox();
				  
				  soft.assertThat(datefilterpageobject.getTextfromValidationMessageonInvalidDateEntry()).isEqualTo("The date entered is invalid");
		      
				//Step 17 : Remove the filter selection using any of the available methods.
				  logger.info("Step 17 - Remove the filter selection using any of the available methods");
					datefilterpageobject.clickOnResetButton();
					
					  soft.assertThat(						
					     	  datefilterpageobject.isDateFilterInActiveFilterListDisplayed())
							 .as("Date Filter Selection Indicator in Active Filter at step 17 should not be Displayed")
							 .isFalse();
					  
					  soft.assertThat(
							  practitionerfilterpageobject.getTotalNumberofRecordsInTheResultTable())
							  .as("Numbers of Records should match at step 17").isEqualTo(records);
					  
				     //Step 18 : Enter an invalid date in the To field.
					  
					  logger.info("Step 18 - Enter an invalid date in the Date To  field");
					 
					  datefilterpageobject.enterValueinDateToTextbox(invaliddateTo);
				  
					  elements.pressEnterKey();
					 
					  datefilterpageobject.clickOnDateFromTextBox();
			
					  soft.assertThat(datefilterpageobject.getTextfromValidationMessageonInvalidDateEntry()).isEqualTo("The date entered is invalid");	  
					  
					  
					
					
					  
					//Step 19 : Remove the filter selection using any of the available methods.
					  logger.info("Step 19 - Remove the filter selection using any of the available methods");
					  datefilterpageobject.clickOnResetButton();
						
					    soft.assertThat(						
						     	  datefilterpageobject.isDateFilterInActiveFilterListDisplayed())
								 .as("Date Filter Selection Indicator in Active Filter at step 19 should not be Displayed")
								 .isFalse();
					  
					    soft.assertThat(
								  practitionerfilterpageobject.getTotalNumberofRecordsInTheResultTable())
								  .as("Numbers of Records should match at step 19").isEqualTo(records);
					  
					  
					 //Step 20 : Enter a date in the "To" field prior to the "From" field.
					  logger.info("Step 20 - Enter a date in the To field prior to the From field");	  
					 // driver.navigate().refresh();  
					  if ((Initialization.browserName.equals("ios-ipad"))){
						    elements.waitForElementFluently(homepageobject.PersonLink, 30);    	
						    elements.waitForElementFluently(homepageobject.CasenoteLink, 30); 
						    }
					 
					
					  datefilterpageobject.enterValueinDateFromTextbox(dateFrom);
					  datefilterpageobject.enterValueinDateToTextbox(dateTo);
					  elements.pressshiftandtab();
		     
					  editcasenotepageobject.Click("OrderBy");
		             
				
					soft.assertThat(datefilterpageobject.getTextfromValidationMessageWhenTodateisBeforeFromDate()).isEqualTo("Date to is before Date from");	  
					  
				
					//Step 21 : Remove the filter selection using any of the available methods.
					  logger.info("Step 21 - Remove the filter selection using any of the available methods");
					  datefilterpageobject.clickOnResetButton();
						
					  soft.assertThat(						
						     	  datefilterpageobject.isDateFilterInActiveFilterListDisplayed())
								 .as("Date Filter Selection Indicator in Active Filter at step 21 should not be Displayed")
								 .isFalse();
					  
					  soft.assertThat(
							  practitionerfilterpageobject.getTotalNumberofRecordsInTheResultTable())
							  .as("Numbers of Records should match at step 21").isEqualTo(records);
					  
					  
					 //Step 22: Enter a valid date in both the "From" & "To" fields.
					     logger.info("Step 22 - Enter a valid date in both the From & To fields.");	
					     if ((Initialization.browserName.equals("ios-ipad"))){
							    elements.waitForElementFluently(homepageobject.PersonLink, 30);    	
							    elements.waitForElementFluently(homepageobject.CasenoteLink, 30); 
							    }
					     			    
					     datefilterpageobject.enterValueinDateFromTextbox(validdateFrom);
					  
					     elements.getElementWithIdentification(datefilterpageobject.DateFromFilter).sendKeys(Keys.TAB);
						 datefilterpageobject.enterValueinDateToTextbox(validdateTo);
					
						 elements.getElementWithIdentification(datefilterpageobject.DateFromFilter).sendKeys(Keys.TAB);
					    
						 editcasenotepageobject.Click("OrderBy");
						 
						 soft.assertThat(datefilterpageobject.verifyRecordsDisplayedasPerDateSelectedInFromandToDateTextbox(validdateFrom, validdateTo))
					      . as("Records displayed as per Date range selected in  From and To date Textbox at step 22").isTrue(); 
					    
					    
					    
						//Step 23 : Remove the filter selection using any of the available methods.
						  logger.info("Step 23 - Remove the filter selection using any of the available methods");
						  datefilterpageobject.clickOnResetButton();
							
						  soft.assertThat(						
							     	  datefilterpageobject.isDateFilterInActiveFilterListDisplayed())
									 .as("Date Filter Selection Indicator at step 23 in Active Filter should not be Displayed")
									 .isFalse();
					    
						  soft.assertThat(
								  practitionerfilterpageobject.getTotalNumberofRecordsInTheResultTable())
								  .as("Numbers of Records should match at step 23").isEqualTo(records);
					  
		             //Step 24 :Double click in either date field.
				    logger.info("Step 24 - Double click in either date field");
				    if ((Initialization.browserName.equals("ios-ipad"))){
					    elements.waitForElementFluently(homepageobject.PersonLink, 30);    	
					    elements.waitForElementFluently(homepageobject.CasenoteLink, 30); 
					    }
					elements.waitForElementFluently(datefilterpageobject.DateFromFilter,40);
				    elements.waitForElementFluently(datefilterpageobject.DateToFilter,40);
				    elements.buttonClick(datefilterpageobject.DateFromFilter);
				    elements.doubleclick(); 
				    elements.buttonClick(datefilterpageobject.DateToFilter);
				    elements.doubleclick(); 
				    elements.buttonClick(datefilterpageobject.DateFromFilter);
				    elements.doubleclick();
				    elements.buttonClick(datefilterpageobject.DateToFilter);
				    elements.doubleclick();
				    elements.waitForPageLoaded();
					
					 soft.assertThat(datefilterpageobject.verifyRecordsDisplayedasperCurrentdate())
				      . as("Records displayed as per Date range selected in  From and To date Textbox at step 24").isTrue(); 			
						  
				
						  
					//Step 25: Remove the filter selection using any of the available methods.
						  
						  logger.info("Step 25 - Remove the filter selection using any of the available methods");
						  datefilterpageobject.clickOnResetButton();
							
						  soft.assertThat(						
							     	  datefilterpageobject.isDateFilterInActiveFilterListDisplayed())
									 .as("Date Filter Selection Indicator at step 25 in Active Filter should not be Displayed")
									 .isFalse();
					    
						  soft.assertThat(
								  practitionerfilterpageobject.getTotalNumberofRecordsInTheResultTable())
								  .as("Numbers of Records should match at step 25").isEqualTo(records);	  
						  
					
						  //Step 37 : Click on Logout
						  
						  soft.assertAll();
		}

	}

	@Test
	public void DateFilterScenario1_Test() throws Exception {
		logger.info("Starting inner class execution");
		InnerClass.driver = this.driver;
		InnerClass.logger = this.logger;
		Result runResult = JUnitCore.runClasses(InnerClass.class);
		Login_To_Application.CaptureResults(runResult);
	}
}

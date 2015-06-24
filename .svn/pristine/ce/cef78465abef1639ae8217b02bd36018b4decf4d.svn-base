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
import com.uspeclipse.commonservices.GenericActions;
import com.uspeclipse.commonservices.MultipleBrowser;
import com.uspeclipse.helper.Parallelized;
import com.uspeclipse.interfaces.SmokeTest;
import com.uspeclipse.pageobjects.casenotes.PractitionerFilter_pageobject;
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
public class PractitionerFilterScenario3_TestcaseID32974 extends Initialization{
	
	private WebDriver driver = null;
	private String browsertype = "";
	private Initialization Login_To_Application=null;
	Logger logger = Logger.getLogger(PractitionerFilterScenario3_TestcaseID32974.class);	
	
	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}
	
	
	public PractitionerFilterScenario3_TestcaseID32974(String type) {
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

	
	
	
	

		 /* Test Case for ID 32974(Scenario 3) - This test is to demonstrate that as a user who has the right to view Case Notes I wish to be able to apply multiple filters to reduce 
		  * the number of entries shown in the Case Note record*/

		 @Test
			//	@UseDataProvider(location = AddNewPerson_dataprovider.class, value = "PersonDetails")
				public void PractitionerFilterScenario3Test()  throws IOException,
						NoSuchMethodException, SecurityException, InterruptedException  {
				
			 GenericActions elements = new GenericActions(driver);
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

	         PractitionerFilter_pageobject practitionerfilterpageobject = PageFactory.initElements(driver,
						PractitionerFilter_pageobject.class);
	         EclipseLogin_pageobject eclipse_pageobject = PageFactory.initElements(
						driver, EclipseLogin_pageobject.class);
	        
	         
	         //	Select a client from either the 'Your recently accessed records' list or the 'Your case load' list or search for a client from the quick person search at the top of the screen
				logger.info("Step 2 - Select a client from either the 'Your recently accessed records' list or the 'Your case load' list or search for a client from the quick person search at the top of the screen");
				searchpageobject.enterSearchText("Sunil Gavaskar");
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
				
				
			
						
				int records = practitionerfilterpageobject.getTotalNumberofRecordsInTheResultTable();
				
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
				  String[] PracOrganisationOption = practitionerorganisationfilterpageobject.storeTextofOptionsfromPractitionerOrganisationFilterMultiSelectBox();		
				  String[] PractitionerOption = practitionerfilterpageobject.storeTextofOptionsfromPractitionerFilterMultiSelectBox();
				  String[] SourceOption = srcfilterpageobject
							.storeTextofOptionsfromSourceFilterMultiSelectBox();
				  String[] SourceOrgOption = srcfilterpageobject
							.storeTextofOptionsfromSourceOrganizationMultiSelectBox();
				 
				  
		       //Step -6 : User selects a name from the Practitioner filter and a name from the Source Organisation filter
		
				  logger.info("Select a name from the Practitioner filter and a name from the Source Organisation filter");
				  
				 practitionerfilterpageobject.selectOptionbyNumberFromPractitionerFilterMultiSelectBox("1");

				  srcfilterpageobject
					.selectOptionsbyNumberFromSourceOrganizationMultiSelectBox("1");
			 
				  soft.assertThat(
							practitionerfilterpageobject.isResultforSinglePractitionerSelectionCorrect(PractitionerOption[1]))
							.as("Only PractitionerOrganisation with 1" + PractitionerOption[1]
									+ " Option should be displayed").isTrue();
			 
				  soft.assertThat(
							srcfilterpageobject
									.isResultforSingleSourceOrganizationSelectionCorrect(SourceOrgOption[1]))
							.as("Only Source Organisation with 1" + SourceOrgOption[1]
									+ " Option should be displayed").isTrue();
			 
			       //Step 7 : Click on Reset All link
				  
				  logger.info("Click on Reset All link");
				  practitionerfilterpageobject.clickonResetAllLinkInActiveFilter();
				  
				  soft.assertThat(						
				     	  practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
						 .as("Practitioner Organisation Filter Selection Indicator in Active Filter should not be Displayed")
						 .isFalse();
				  
				  soft.assertThat(
							srcfilterpageobject
									.isSourceOrganizationSelectedIndicatorDisplayed())
							.as("Source Organisation Filter Selection Indicator in Active Filter should not be Displayed")
							.isFalse();
			 
			 
		
	             //Step 8: User selects a name from the Practitioner Organisation dialogue and a name from the Source dialogue
			 
				  logger.info("User selects a name from the Practitioner Organisation dialogue and a name from the Source dialogue"); 
				  
				  practitionerorganisationfilterpageobject.selectOptionbyNumberFromPractitionerOrganisationFilterMultiSelectBox("1");
			      srcfilterpageobject.selectOptionsbyNumberFromSourceFilterMultiSelectBox("1");
			      
			 
			      soft.assertThat(
							practitionerorganisationfilterpageobject.isResultforSinglePractitionerOrganisationSelectionCorrect(PracOrganisationOption[1]))
							.as("step 8 : Only PractitionerOrganisation with 1" + PracOrganisationOption[1]
									+ " Option should be displayed ").isTrue();
			 
			 
			      soft.assertThat(
							srcfilterpageobject
									.isResultforSingleSourceSelectionCorrect(SourceOption[1]))
							.as("Step 8 :Only Source with 1" + SourceOption[1]
									+ " Option should be displayed").isTrue();
		
		          //Step 9 : Click on Reset All link
				  
				  logger.info("Click on Reset All link");
				  practitionerfilterpageobject.clickonResetAllLinkInActiveFilter();
		
				  soft.assertThat(						
				     	  practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
						 .as("Practitioner Organisation Filter Selection Indicator in Active Filter should not be Displayed")
						 .isFalse();
			      
				  soft.assertThat(
							srcfilterpageobject.isSourceFilterSelectedIndicatorDisplayed())
							.as("Source Filter Selection Indicator in Active Filter should not be Displayed")
							.isFalse();
			     
	    	  //Step 10 : User selects a name from the Source dialogue and in the Type and Other tab the user checks the Positive Impact checkbox
			      
				  srcfilterpageobject.selectOptionsbyNumberFromSourceFilterMultiSelectBox("1");
				  practitionerfilterpageobject.clickonTypeAndotherTabinFilterBy();
				  String[] EntryTypeOption = practitionerfilterpageobject.storeTextofOptionsfromEntryTypeFilterMultiSelectBox();
				 
				  practitionerfilterpageobject.clickonImpactCheckbox("Positive");
				  soft.assertThat(
							practitionerfilterpageobject.isResultForSingleImpactCheckboxSelection("Impact-positive"))
							.as("Only records with positive checbox should be displayed").isTrue();
			      
				  soft.assertThat(
							srcfilterpageobject
									.isResultforSingleSourceSelectionCorrect(SourceOption[1]))
							.as("Only Source with 1" + SourceOption[1]
									+ " Option should be displayed").isTrue();
			      
	             //Step 11 : Click on Reset All link
				  
				  logger.info("Click on Reset All link");
				  practitionerfilterpageobject.clickonResetAllLinkInActiveFilter();
		
				  soft.assertThat(						
				     	  practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
						 .as("Practitioner Organisation Filter Selection Indicator in Active Filter should not be Displayed")
						 .isFalse();
			      
				  soft.assertThat(
							practitionerfilterpageobject.isImpactFilterSelectedIndicatorDisplayed())
							.as("Source Filter Selection Indicator in Active Filter should not be Displayed")
							.isFalse();
			     
				  
				 /* Step 12 : Selects a name from the Practitioner dialogue in the People Tab and selects a value from the Type Filter in the
				            Type and Other tab*/
				  
				  srcfilterpageobject.clickonPeopleTabinFilterBy();
				  
				  practitionerfilterpageobject.selectOptionbyNumberFromPractitionerFilterMultiSelectBox("1");
				  
				  practitionerfilterpageobject.clickonTypeAndotherTabinFilterBy();
				 
				  practitionerfilterpageobject.selectOptionbyNumberFromEntryTypeList("1");
				  
				  soft.assertThat(
							practitionerfilterpageobject.isResultforSinglePractitionerSelectionCorrect(PractitionerOption[1]))
							.as("Only PractitionerOrganisation with 1" + PractitionerOption[1]
									+ " Option should be displayed").isTrue();
				  
				  soft.assertThat(
							practitionerfilterpageobject.isResultForSingleEntryTypeSelectionCorrect(EntryTypeOption[1]))
							.as("Only Entry Type option" + EntryTypeOption[1]
									+ " Option should be displayed").isTrue();
				  
				  
	            //Step 13 : Click on Reset All link
				  
				  logger.info("Click on Reset All link");
				  practitionerfilterpageobject.clickonResetAllLinkInActiveFilter();
		
				  soft.assertThat(						
				     	  practitionerfilterpageobject.isPractitionerFilterInActiveFilterListDisplayed())
						 .as("Practitioner Filter Selection Indicator in Active Filter should not be Displayed")
						 .isFalse();
			      
				  soft.assertThat(
							practitionerfilterpageobject.isEntryTypeFilterSelectedIndicatorDisplayed())
							.as("Entry type  Filter Selection Indicator in Active Filter should not be Displayed")
							.isFalse();
			     	  
				  
				//Step 14 : User selects a name from the Source dialogue in the People Tab and checks the Include Deleted checkbox	  
				  
				  srcfilterpageobject.clickonPeopleTabinFilterBy();
				  
				  srcfilterpageobject.selectOptionsbyNumberFromSourceFilterMultiSelectBox("1");
				
				  practitionerfilterpageobject.clickonTypeAndotherTabinFilterBy();
				  
				  practitionerfilterpageobject.clickonIncludeDeletedCheckbox();
				  
				  soft.assertThat(
							srcfilterpageobject
									.isResultforSingleSourceSelectionCorrect(SourceOption[1]))
							.as("Only Source with 1" + SourceOption[1]
									+ " Option should be displayed").isTrue();
				  
				  
				  
	             //Step 15 : Click on Reset All link
				  
				  logger.info("Click on Reset All link");
				  practitionerfilterpageobject.clickonResetAllLinkInActiveFilter();
		
				  soft.assertThat(						
				     	  srcfilterpageobject.isSourceFilterSelectedIndicatorDisplayed())
						 .as("Source Filter Selection Indicator in Active Filter should not be Displayed")
						 .isFalse();
			      
				 
				  
				//Step 16 : Selects a name from the Practitioner dialogue and a name from the Source dialogue in the People tab and in the Type and Other tab checks the negative Impact checkbox
				  logger.info("Selects a name from the Practitioner dialogue and a name from the Source dialogue in the People tab and in the Type "
				  		+ "   and Other tab checks the negative Impact checkbox");
				 
				  srcfilterpageobject.clickonPeopleTabinFilterBy();
				  
				  practitionerfilterpageobject.selectOptionbyNumberFromPractitionerFilterMultiSelectBox("1");
				  srcfilterpageobject.selectOptionsbyNumberFromSourceFilterMultiSelectBox("1");
				  
				  practitionerfilterpageobject.clickonTypeAndotherTabinFilterBy();
				  practitionerfilterpageobject.clickonImpactCheckbox("Negative");
				  
				
				  soft.assertThat(
							practitionerfilterpageobject.isResultforSinglePractitionerSelectionCorrect(PractitionerOption[1]))
							.as("Only PractitionerOrganisation with 1" + PractitionerOption[1]
									+ " Option should be displayed").isTrue();
				  
				  soft.assertThat(
							srcfilterpageobject
									.isResultforSingleSourceSelectionCorrect(SourceOption[1]))
							.as("Only Source with 1" + SourceOption[1]
									+ " Option should be displayed").isTrue();
				  
				  
				  soft.assertThat(
							practitionerfilterpageobject.isResultForSingleImpactCheckboxSelection("Impact-negative"))
							.as("Only records with positive checbox should be displayed").isTrue();
				  
	           
				  
				  //Step 17 : Click on Reset All link
				  
				  logger.info("Click on Reset All link");
				  practitionerfilterpageobject.clickonResetAllLinkInActiveFilter();
		
				  soft.assertThat(						
				     	  srcfilterpageobject.isSourceFilterSelectedIndicatorDisplayed())
						 .as("Source Filter Selection Indicator in Active Filter should not be Displayed")
						 .isFalse();
			      
				  soft.assertThat(						
				     	  practitionerfilterpageobject.isPractitionerFilterInActiveFilterListDisplayed())
						 .as("Practitioner Filter Selection Indicator in Active Filter should not be Displayed")
						 .isFalse();
			      
				  
				  //Step 18 : select a name from the Source Organisation dialogue, a name from the Source dialogue and a name from the Practitioner Organisation dialogue in the People tab
				 
				  logger.info("select a name from the Source Organisation dialogue, a name from the Source dialogue and a name from the Practitioner"
				  		+ " Organisation dialogue in the People tab");
				  
				  srcfilterpageobject.clickonPeopleTabinFilterBy();

				 
				  srcfilterpageobject
					.selectOptionsbyNumberFromSourceOrganizationMultiSelectBox("1");
				  
				  srcfilterpageobject.selectOptionsbyNumberFromSourceFilterMultiSelectBox("1");
				  
				  practitionerorganisationfilterpageobject.selectOptionbyNumberFromPractitionerOrganisationFilterMultiSelectBox("1");
				  
				  
				  soft.assertThat(
							srcfilterpageobject
									.isResultforSingleSourceSelectionCorrect(SourceOption[1]))
							.as("Only Source with 1" + SourceOption[1]
									+ " Option should be displayed").isTrue();
				  
				 
				  soft.assertThat(
							srcfilterpageobject
									.isResultforSingleSourceOrganizationSelectionCorrect(SourceOrgOption[1]))
							.as("Only Source Organisation with 1" + SourceOrgOption[1]
									+ " Option should be displayed").isTrue();
			 	  
				  soft.assertThat(
							practitionerorganisationfilterpageobject.isResultforSinglePractitionerOrganisationSelectionCorrect(PracOrganisationOption[1]))
							.as("Only PractitionerOrganisation with 1" + PracOrganisationOption[1]
									+ " Option should be displayed").isTrue();
			 
				  
	           //Step 19 : Click on Reset All link
				  
				  logger.info("Click on Reset All link");
				  practitionerfilterpageobject.clickonResetAllLinkInActiveFilter();
		
				  soft.assertThat(						
				     	  srcfilterpageobject.isSourceFilterSelectedIndicatorDisplayed())
						 .as("Source Filter Selection Indicator in Active Filter should not be Displayed")
						 .isFalse();
			      
				  soft.assertThat(
							srcfilterpageobject
									.isSourceOrganizationSelectedIndicatorDisplayed())
							.as("Source Organisation Filter Selection Indicator in Active Filter should not be Displayed")
							.isFalse();
				  
				  soft.assertThat(						
				     	  practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
						 .as("Practitioner Organisation Filter Selection Indicator in Active Filter should not be Displayed")
						 .isFalse();
			      
				  
				  //Step 20: selects a name from the Source Organisation dialogue and a name from the Practitioner Organisation dialogue in the People tab and select a name from the Type dialogue in the Type and Other dialogue
				
				  logger.info("selects a name from the Source Organisation dialogue and a name from the Practitioner Organisation dialogue in the People tab and select a name from the"
				  		+ " Type dialogue in the Type and Other dialogue");
				  
				  srcfilterpageobject
					.selectOptionsbyNumberFromSourceOrganizationMultiSelectBox("1");
				
				  practitionerorganisationfilterpageobject.selectOptionbyNumberFromPractitionerOrganisationFilterMultiSelectBox("1");
				  
				  practitionerfilterpageobject.clickonTypeAndotherTabinFilterBy();
				 
				  practitionerfilterpageobject.selectOptionbyNumberFromEntryTypeList("1");
				  
				  
				  
				  soft.assertThat(
							srcfilterpageobject
									.isResultforSingleSourceOrganizationSelectionCorrect(SourceOrgOption[1]))
							.as("Only Source Organisation with 1" + SourceOrgOption[1]
									+ " Option should be displayed").isTrue();
				  
				  soft.assertThat(
							practitionerorganisationfilterpageobject.isResultforSinglePractitionerOrganisationSelectionCorrect(PracOrganisationOption[1]))
							.as("Only PractitionerOrganisation with 1" + PracOrganisationOption[1]
									+ " Option should be displayed").isTrue();
				  soft.assertThat(
							practitionerfilterpageobject.isResultForSingleEntryTypeSelectionCorrect(EntryTypeOption[1]))
							.as("Only Entry Type option" + EntryTypeOption[1]
									+ " Option should be displayed").isTrue();
				  
				  
				  
	             //Step 21 : Click on Reset All link
				  
				  logger.info("Click on Reset All link");
				 
				  practitionerfilterpageobject.clickonResetAllLinkInActiveFilter();
		
				  soft.assertThat(						
				     	  srcfilterpageobject.isSourceFilterSelectedIndicatorDisplayed())
						 .as("Source Filter Selection Indicator in Active Filter should not be Displayed")
						 .isFalse();
			      
				  soft.assertThat(						
				     	  practitionerfilterpageobject.isPractitionerFilterInActiveFilterListDisplayed())
						 .as("Practitioner Filter Selection Indicator in Active Filter should not be Displayed")
						 .isFalse();
				  
				  soft.assertThat(						
				     	  practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
						 .as("Practitioner Organisation Filter Selection Indicator in Active Filter should not be Displayed")
						 .isFalse();
				  
				  
				  soft.assertThat(
							srcfilterpageobject
									.isSourceOrganizationSelectedIndicatorDisplayed())
							.as("Source Organisation Filter Selection Indicator in Active Filter should not be Displayed")
							.isFalse();
				  
				  
				//Step 22 : selects a name from the Source Organisation dialogue and a name from the Practitioner dialogue in the People tab and  checks the Include Deleted check box  
				  
				  logger.info("selects a name from the Source Organisation dialogue and a name from the Practitioner dialogue in the People tab and  checks the Include Deleted check box");
				  
				  
				  srcfilterpageobject.clickonPeopleTabinFilterBy();

				 
				  srcfilterpageobject
					.selectOptionsbyNumberFromSourceOrganizationMultiSelectBox("1");

				  practitionerfilterpageobject.selectOptionbyNumberFromPractitionerFilterMultiSelectBox("1");
				 
				  practitionerfilterpageobject.clickonTypeAndotherTabinFilterBy();
				  practitionerfilterpageobject.clickonIncludeDeletedCheckbox();
			
				  
				  soft.assertThat(
							practitionerfilterpageobject.isResultforSinglePractitionerSelectionCorrect(PractitionerOption[1]))
							.as("Only PractitionerOrganisation with 1" + PractitionerOption[1]
									+ " Option should be displayed").isTrue();
				  
				  soft.assertThat(
							srcfilterpageobject
									.isResultforSingleSourceOrganizationSelectionCorrect(SourceOrgOption[1]))
							.as("Only Source Organisation with 1" + SourceOrgOption[1]
									+ " Option should be displayed").isTrue();
				  
				  
		             //Step 23 : Click on Reset All link
					  
					  logger.info("Click on Reset All link");
					 
					  practitionerfilterpageobject.clickonResetAllLinkInActiveFilter();
			
					  soft.assertThat(						
					     	  srcfilterpageobject.isSourceFilterSelectedIndicatorDisplayed())
							 .as("Source Filter Selection Indicator in Active Filter should not be Displayed")
							 .isFalse();
				      
					  soft.assertThat(						
					     	  practitionerfilterpageobject.isPractitionerFilterInActiveFilterListDisplayed())
							 .as("Practitioner Filter Selection Indicator in Active Filter should not be Displayed")
							 .isFalse();
					  
					  soft.assertThat(						
					     	  practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
							 .as("Practitioner Organisation Filter Selection Indicator in Active Filter should not be Displayed")
							 .isFalse();
					  
					  
					  soft.assertThat(
								srcfilterpageobject
										.isSourceOrganizationSelectedIndicatorDisplayed())
								.as("Source Organisation Filter Selection Indicator in Active Filter should not be Displayed")
								.isFalse();
				  
				  
				//Step 24 : selects a name from the Practitioner dialogue, a name from the Source dialogue, a name from the Practitioner Organisation dialogue and a name from the Source Organisation dialogue in the People tab  
				  
				  
					  logger.info("selects a name from the Practitioner dialogue, a name from the Source dialogue, a name from the Practitioner Organisation dialogue and a name from the Source Organisation dialogue in the People tab");
					  
					  srcfilterpageobject.clickonPeopleTabinFilterBy();
					  practitionerfilterpageobject.selectOptionbyNumberFromPractitionerFilterMultiSelectBox("1");
					  srcfilterpageobject.selectOptionsbyNumberFromSourceFilterMultiSelectBox("1");
					
					  practitionerorganisationfilterpageobject.selectOptionbyNumberFromPractitionerOrganisationFilterMultiSelectBox("1");
					  
					  srcfilterpageobject
						.selectOptionsbyNumberFromSourceOrganizationMultiSelectBox("1");
					  
					  soft.assertThat(
								practitionerfilterpageobject.isResultforSinglePractitionerSelectionCorrect(PractitionerOption[1]))
								.as("Only PractitionerOrganisation with 1" + PractitionerOption[1]
										+ " Option should be displayed").isTrue();
					 
					  soft.assertThat(
								srcfilterpageobject
										.isResultforSingleSourceSelectionCorrect(SourceOption[1]))
								.as("Only Source with 1" + SourceOption[1]
										+ " Option should be displayed").isTrue();
					  
					 
					  soft.assertThat(
								practitionerorganisationfilterpageobject.isResultforSinglePractitionerOrganisationSelectionCorrect(PracOrganisationOption[1]))
								.as("Only PractitionerOrganisation with 1" + PracOrganisationOption[1]
										+ " Option should be displayed").isTrue();
				 
					  soft.assertThat(
								srcfilterpageobject
										.isResultforSingleSourceOrganizationSelectionCorrect(SourceOrgOption[1]))
								.as("Only Source Organisation with 1" + SourceOrgOption[1]
										+ " Option should be displayed").isTrue();
					  
					  
	               //Step 25 : Click on Reset All link
					  
					  logger.info("Click on Reset All link");
					 
					  practitionerfilterpageobject.clickonResetAllLinkInActiveFilter();
			
					  soft.assertThat(						
					     	  srcfilterpageobject.isSourceFilterSelectedIndicatorDisplayed())
							 .as("Source Filter Selection Indicator in Active Filter should not be Displayed")
							 .isFalse();
				      
					  soft.assertThat(						
					     	  practitionerfilterpageobject.isPractitionerFilterInActiveFilterListDisplayed())
							 .as("Practitioner Filter Selection Indicator in Active Filter should not be Displayed")
							 .isFalse();
					  
					  soft.assertThat(						
					     	  practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
							 .as("Practitioner Organisation Filter Selection Indicator in Active Filter should not be Displayed")
							 .isFalse();
					  
					  
					  soft.assertThat(
								srcfilterpageobject
										.isSourceOrganizationSelectedIndicatorDisplayed())
								.as("Source Organisation Filter Selection Indicator in Active Filter should not be Displayed")
								.isFalse();
				  
				 //Step 26 : selects a Practitioner from the Practitioner dialogue, a name from the Source dialogue, a name from the Practitioner Organisation dialogue, a name from the Source Organisation dialogue in the People tab and selects the Neutral Impact checkbox in the Type and Other tab		  
				
				 logger.info("selects a Practitioner from the Practitioner dialogue, a name from the Source dialogue, a name from the Practitioner Organisation dialogue, a name from the Source Organisation dialogue in the People tab and selects the Neutral Impact checkbox in the Type and Other tab");
				 
				 practitionerfilterpageobject.selectOptionbyNumberFromPractitionerFilterMultiSelectBox("1");
				  srcfilterpageobject.selectOptionsbyNumberFromSourceFilterMultiSelectBox("1");
				  
				  srcfilterpageobject
					.selectOptionsbyNumberFromSourceOrganizationMultiSelectBox("1");
				  
				  practitionerorganisationfilterpageobject.selectOptionbyNumberFromPractitionerOrganisationFilterMultiSelectBox("1");  
				 
				  practitionerfilterpageobject.clickonTypeAndotherTabinFilterBy();
				  practitionerfilterpageobject.clickonImpactCheckbox("Neutral");
				  
				  
				  soft.assertThat(
							practitionerfilterpageobject.isResultforSinglePractitionerSelectionCorrect(PractitionerOption[1]))
							.as("Only PractitionerOrganisation with 1" + PractitionerOption[1]
									+ " Option should be displayed").isTrue();
				 
				  soft.assertThat(
							srcfilterpageobject
									.isResultforSingleSourceSelectionCorrect(SourceOption[1]))
							.as("Only Source with 1" + SourceOption[1]
									+ " Option should be displayed").isTrue();
				  
				 
				  soft.assertThat(
							practitionerorganisationfilterpageobject.isResultforSinglePractitionerOrganisationSelectionCorrect(PracOrganisationOption[1]))
							.as("Only PractitionerOrganisation with 1" + PracOrganisationOption[1]
									+ " Option should be displayed").isTrue();
			 
				  soft.assertThat(
							srcfilterpageobject
									.isResultforSingleSourceOrganizationSelectionCorrect(SourceOrgOption[1]))
							.as("Only Source Organisation with 1" + SourceOrgOption[1]
									+ " Option should be displayed").isTrue();
				  
				  soft.assertThat(
							practitionerfilterpageobject.isResultForSingleImpactCheckboxSelection("Impact-neutral"))
							.as("Only records with Negative impact should be displayed").isTrue();
				  
				
				//Step 27 : Click on Reset All link
				  
				  logger.info("Click on Reset All link");
				 
				  practitionerfilterpageobject.clickonResetAllLinkInActiveFilter();
		
				  soft.assertThat(						
				     	  srcfilterpageobject.isSourceFilterSelectedIndicatorDisplayed())
						 .as("Source Filter Selection Indicator in Active Filter should not be Displayed")
						 .isFalse();
			      
				  soft.assertThat(						
				     	  practitionerfilterpageobject.isPractitionerFilterInActiveFilterListDisplayed())
						 .as("Practitioner Filter Selection Indicator in Active Filter should not be Displayed")
						 .isFalse();
				  
				  soft.assertThat(						
				     	  practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
						 .as("Practitioner Organisation Filter Selection Indicator in Active Filter should not be Displayed")
						 .isFalse();
				  
				  
				  soft.assertThat(
							srcfilterpageobject
									.isSourceOrganizationSelectedIndicatorDisplayed())
							.as("Source Organisation Filter Selection Indicator in Active Filter should not be Displayed")
							.isFalse();  
				
				//Step 28 : selects a Practitioner from the Practitioner dialogue, a name from the Source dialogue, a name from the Practitioner Organisation dialogue, a name from the Source Organisation dialogue in the People tab and selects a value from the Type dialogue and checks the Neutral Impact checkbox in the Type and Other tab
				  
				  logger.info("selects a Practitioner from the Practitioner dialogue, a name from the Source dialogue, a name from the Practitioner Organisation dialogue, a name from the Source Organisation dialogue in the People tab and selects a value from the Type dialogue and checks the "
				  		+ "   Neutral Impact checkbox in the Type and Other tab"); 
				  
				  srcfilterpageobject.clickonPeopleTabinFilterBy();

				 
				  practitionerfilterpageobject.selectOptionbyNumberFromPractitionerFilterMultiSelectBox("1");
				  srcfilterpageobject.selectOptionsbyNumberFromSourceFilterMultiSelectBox("1");
				  
				  practitionerorganisationfilterpageobject.selectOptionbyNumberFromPractitionerOrganisationFilterMultiSelectBox("1");  
				  srcfilterpageobject
					.selectOptionsbyNumberFromSourceOrganizationMultiSelectBox("1");
				  
				  practitionerfilterpageobject.clickonTypeAndotherTabinFilterBy();
				
				  practitionerfilterpageobject.selectOptionbyNumberFromEntryTypeList("1");
				 
				  practitionerfilterpageobject.clickonImpactCheckbox("Neutral");
				  
				  
				  soft.assertThat(
							practitionerfilterpageobject.isResultforSinglePractitionerSelectionCorrect(PractitionerOption[1]))
							.as("Only PractitionerOrganisation with 1" + PractitionerOption[1]
									+ " Option should be displayed").isTrue();
				 
				  soft.assertThat(
							srcfilterpageobject
									.isResultforSingleSourceSelectionCorrect(SourceOption[1]))
							.as("Only Source with 1" + SourceOption[1]
									+ " Option should be displayed").isTrue();
				  
				 
				  soft.assertThat(
							practitionerorganisationfilterpageobject.isResultforSinglePractitionerOrganisationSelectionCorrect(PracOrganisationOption[1]))
							.as("Only PractitionerOrganisation with 1" + PracOrganisationOption[1]
									+ " Option should be displayed").isTrue();
			 
				  soft.assertThat(
							srcfilterpageobject
									.isResultforSingleSourceOrganizationSelectionCorrect(SourceOrgOption[1]))
							.as("Only Source Organisation with 1" + SourceOrgOption[1]
									+ " Option should be displayed").isTrue();
				  
				  soft.assertThat(
							practitionerfilterpageobject.isResultForSingleImpactCheckboxSelection("Impact-neutral"))
							.as("Only records with Negative impact should be displayed").isTrue();
				  
				  soft.assertThat(
							practitionerfilterpageobject.isResultForSingleEntryTypeSelectionCorrect(EntryTypeOption[1]))
							.as("Only Entry Type option" + EntryTypeOption[1]
									+ " Option should be displayed").isTrue();
				  
				  
				  //Step 29 : Click on Reset All link
				  
				  logger.info("Click on Reset All link");
					 
				  practitionerfilterpageobject.clickonResetAllLinkInActiveFilter();
		
				  soft.assertThat(						
				     	  srcfilterpageobject.isSourceFilterSelectedIndicatorDisplayed())
						 .as("Source Filter Selection Indicator in Active Filter should not be Displayed")
						 .isFalse();
			      
				  soft.assertThat(						
				     	  practitionerfilterpageobject.isPractitionerFilterInActiveFilterListDisplayed())
						 .as("Practitioner Filter Selection Indicator in Active Filter should not be Displayed")
						 .isFalse();
				  
				  soft.assertThat(						
				     	  practitionerorganisationfilterpageobject.isPractitionerOrganisationFilterInActiveFilterListDisplayed())
						 .as("Practitioner Organisation Filter Selection Indicator in Active Filter should not be Displayed")
						 .isFalse();
				  
				  
				  soft.assertThat(
							srcfilterpageobject
									.isSourceOrganizationSelectedIndicatorDisplayed())
							.as("Source Organisation Filter Selection Indicator in Active Filter should not be Displayed")
							.isFalse(); 
				  
				//Step 30 : selects a Practitioner from the Practitioner dialogue, a name from the Source dialogue, a name from the Practitioner Organisation dialogue and a name from the Source Organisation dialogue box in the Person tab and selects a value from the Type dialogue and checks the Neutral Impact checkbox in the Type and Other tab and checks the Include Deleted checkbox  
			
			  logger.info("selects a Practitioner from the Practitioner dialogue, a name from the Source dialogue, a name from the Practitioner Organisation dialogue and a name from the Source Organisation dialogue box in the Person tab and selects a value from the Type dialogue and checks the Neutral Impact checkbox in the Type and Other tab and checks the Include Deleted checkbox");
			  
			  
			  srcfilterpageobject.clickonPeopleTabinFilterBy();
			  
			  practitionerfilterpageobject.selectOptionbyNumberFromPractitionerFilterMultiSelectBox("1");
			  srcfilterpageobject.selectOptionsbyNumberFromSourceFilterMultiSelectBox("1");
			  
			  practitionerorganisationfilterpageobject.selectOptionbyNumberFromPractitionerOrganisationFilterMultiSelectBox("1");  
			  srcfilterpageobject
				.selectOptionsbyNumberFromSourceOrganizationMultiSelectBox("1");
			 
			  practitionerfilterpageobject.clickonTypeAndotherTabinFilterBy();
			  
			  practitionerfilterpageobject.selectOptionbyNumberFromEntryTypeList("1");
				 
			  practitionerfilterpageobject.clickonImpactCheckbox("Neutral"); 
			
			  practitionerfilterpageobject.clickonIncludeDeletedCheckbox();
			 
			  
			  soft.assertThat(
						practitionerfilterpageobject.isResultforSinglePractitionerSelectionCorrect(PractitionerOption[1]))
						.as("Only PractitionerOrganisation with 1" + PractitionerOption[1]
								+ " Option should be displayed").isTrue();
			 
			  soft.assertThat(
						srcfilterpageobject
								.isResultforSingleSourceSelectionCorrect(SourceOption[1]))
						.as("Only Source with 1" + SourceOption[1]
								+ " Option should be displayed").isTrue();
			  
			 
			  soft.assertThat(
						practitionerorganisationfilterpageobject.isResultforSinglePractitionerOrganisationSelectionCorrect(PracOrganisationOption[1]))
						.as("Only PractitionerOrganisation with 1" + PracOrganisationOption[1]
								+ " Option should be displayed").isTrue();
		 
			  soft.assertThat(
						srcfilterpageobject
								.isResultforSingleSourceOrganizationSelectionCorrect(SourceOrgOption[1]))
						.as("Only Source Organisation with 1" + SourceOrgOption[1]
								+ " Option should be displayed").isTrue();
			  
			  soft.assertThat(
						practitionerfilterpageobject.isResultForSingleImpactCheckboxSelection("Impact-neutral"))
						.as("Only records with Negative impact should be displayed").isTrue();
			  
			  soft.assertThat(
						practitionerfilterpageobject.isResultForSingleEntryTypeSelectionCorrect(EntryTypeOption[1]))
						.as("Only Entry Type option" + EntryTypeOption[1]
								+ " Option should be displayed").isTrue();
			  
			    
				//Step 31 : Clicks on Filter button  
				  
			    srcfilterpageobject.clickonSourceFilterButton(); 
			    
			    /*soft.assertThat(
						practitionerfilterpageobject
								.isFilterPanelDisplayed())
						.as("Filter Panel should be closed and should not  be Displayed")
						.isFalse();
				  */
		      //Step 32 - Click on Log out
			  
			  logger.info("Step 30 - Click on Log out");
			  eclipse_pageobject.EclipseLogout();

			  soft.assertAll();    
		
		 }

	}


	@Test
	public void PractitionerFilterScenario3Test() throws Exception {
		logger.info("Starting inner class execution");
		InnerClass.driver = this.driver;
		InnerClass.logger = this.logger;
		Result runResult = JUnitCore.runClasses(InnerClass.class);
		Login_To_Application.CaptureResults(runResult);
	}
}
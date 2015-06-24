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
import com.uspeclipse.dataprovider.person.EndPersonAddress_dataprovider;
import com.uspeclipse.helper.Parallelized;
import com.uspeclipse.interfaces.SmokeTest;
import com.uspeclipse.pageobjects.login.EclipseLogin_pageobject;
import com.uspeclipse.pageobjects.person.AddPersonAddress_pageobjects;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;
import com.uspeclipse.pageobjects.person.EndPersonAddress_pageobject;
import com.uspeclipse.pageobjects.person.RemovePersonAddress_pageobject;
import com.uspeclipse.setup.Initialization;

@RunWith(Parallelized.class)
@Category(SmokeTest.class)
public class RemovePersonAddress_TestCaseID2965 {
	private WebDriver driver = null;
	private String browsertype="";
	private Initialization Login_To_Application=null;
	Logger logger = Logger
			.getLogger(RemovePersonAddress_TestCaseID2965.class);

	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		return Constants.getAllBrowsers();
	}

	public RemovePersonAddress_TestCaseID2965(String type) {
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


		// Test Case for ID 2965 -> Remove address on person
		
		@Test
		@UseDataProvider(location = EndPersonAddress_dataprovider.class, value = "EndPersonAddressDetails") 
		public void RemovePersonAddress(String title, String forename,
			String middlename, String surname, String byear, String bmonth,
			String bday, String ethnicity, String postcode, String housename,String type,String usage, String year,String Month,String Day,String EndYear,String EndMonth, String EndDay,String EndReason) throws IOException,
			NoSuchMethodException, SecurityException, InterruptedException, BiffException, InvalidFormatException {
			
		    SoftAssertions soft = new SoftAssertions();
			
		    EclipseLogin_pageobject eclipsepageobject  = PageFactory.initElements(driver, EclipseLogin_pageobject.class);
			eclipsepageobject.LoginAgainBySwitchingRole("manager");
		    
			//Page objects are initialized
			AddPerson_pageobject addpersonpageobject = PageFactory.initElements(driver,
					AddPerson_pageobject.class);
		    AddPersonAddress_pageobjects addpersonaddresspageobject = PageFactory.initElements(driver,
					AddPersonAddress_pageobjects.class);
		    EndPersonAddress_pageobject endpersonaddresspageobject =  PageFactory.initElements(driver,
					EndPersonAddress_pageobject.class);
		    RemovePersonAddress_pageobject removepersonpageobject = PageFactory.initElements(driver,
					RemovePersonAddress_pageobject.class);
		    
		    
			
			
			//Adding new person
			addpersonpageobject.AddNewPerson("client", title, forename, middlename, surname, byear, bmonth, bday, "Male", ethnicity);
			
			//Adding Person Address
			addpersonaddresspageobject.AddingPersonAddress(postcode, housename, type, usage, EndYear, EndMonth, EndDay);	
			 
			 endpersonaddresspageobject.clickOnSelectButton(); 
			 driver.navigate().refresh();
			 endpersonaddresspageobject.clickOnSelectButton();
			 removepersonpageobject.clickOnRemoveButton();	 
			 removepersonpageobject.clickOnYesButton();	
			 
			 //Verifying whether proper confirmation messages is being displayed after Removing Address.
			 logger.info("Verifying whether proper confirmation messages is being displayed after Removing Address");
			 soft.assertThat(removepersonpageobject.confirmationMessageonDeletingAddress()).isEqualTo("Address successfully removed");
			 driver.navigate().refresh();
			 
			 //Confirming that Address has been removed even after refreshing the page
			 logger.info("Confirming that Address has been removed even after refreshing the page");
			 soft.assertThat(removepersonpageobject.addressDisplayedInAddressTable()).isFalse();
			 soft.assertAll();		
		}
		
	}

	@Test
	public void RemovePersonAddress_Test() throws Exception {
		logger.info("Starting inner class execution");
		InnerClass.driver = this.driver;
		InnerClass.logger = this.logger;
		Result runResult = JUnitCore.runClasses(InnerClass.class);
		Login_To_Application.CaptureResults(runResult);
	}

}
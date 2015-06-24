package com.uspeclipse.pageobjects.casenotes;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;
import com.uspeclipse.commonservices.GenericActions;
import com.uspeclipse.commonservices.MultipleBrowser;
import com.uspeclipse.pageobjects.home.Home_pageobjects;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;
import com.uspeclipse.setup.LoggerHelper;

public class DateFilter_pageobject {
	    //Page objects are initialized here
		private WebDriver driver;
		Home_pageobjects homepageobject = null;
		AddPerson_pageobject addpersonpageobject =null;
		SourceFilter_pageobject sourcefilterpageobject = null;
		EditCaseNotes_pageobjects editcasenotepageobject = null;
		PractitionerOrganisationFilter_pageobject practitionerorganisationfilterpageobject = null;
		private static  Logger logger = Logger.getLogger(DateFilter_pageobject.class);
		GenericActions elements = null;
		
		public DateFilter_pageobject(WebDriver driver){
			this.driver = driver;
			this.homepageobject = PageFactory.initElements(
					driver, Home_pageobjects.class);
			this.addpersonpageobject = PageFactory.initElements(
					driver,	 AddPerson_pageobject.class);
			this.sourcefilterpageobject = PageFactory.initElements(
					driver,SourceFilter_pageobject.class);
			this.practitionerorganisationfilterpageobject = PageFactory.initElements(
					driver,PractitionerOrganisationFilter_pageobject.class);
			this.editcasenotepageobject = PageFactory.initElements(
					driver,EditCaseNotes_pageobjects.class);
			elements = new GenericActions(driver);
		}
		
		
	    //Page Objects For Date Filter are defined here.
		
		
		public final By DateFromFilter=By.id("caseNoteEntryFilter_entryDateRangeStart");
		public final By DateToFilter=
		By.id("caseNoteEntryFilter_entryDateRangeEnd");
		
		public final By caseNotesResultsTable=By.id ("generalCaseNoteEntryResults");
		public final By closeMainMenu=By.xpath("//div[@id='menu']//a[contains(text(),'Close menu')]");
		public final By ResetButton=By.id ("caseNoteEntryFilter_clearDate" );
		public final By Last7DaysLink=By.linkText("Last 7 days");
		public final By Last30daysLink=By.linkText("Last 30 days");
		public final By LastYearLink=By.linkText("Last year");
		public final By DateFilterSelectedIndicator=By.xpath ("//div[@id='caseNoteFilterContext']//span[contains(text(),'Date')]");
		public final By dateFilterPanel=By.id("dateFilters");
		public final By FilterByOverlay=By.xpath ("//*[@id = 'generalCaseNoteEntryResultsFilter']/form//*[@class = 'panel bordered']");
		public final By DateFilterIcon=By.xpath ("//a[contains(text(),'Date')]//*[@class='icon-filter']");
		public final By OrderByButton=By.xpath ("//*[@id='orderby_button']//*[contains(text(),'Order by')]");
		public final By OrderByRecordedDate=By.xpath ("//*[@id='orderby_button']//*[@class='sort-by-recorded-date']");
		public final By OrderByLastEditedDate=By.xpath ("//*[@id='orderby_button']//*[@class='sort-by-lastedited-date']");
		public final By InvalidDateValidationMessage=By.xpath ("//*[@id = 'caseNoteValidationError']//*[contains(text() ,'The date entered is invalid')]");
		public final By ValidationMessageWhenTodateisBeforeFromDate=By.xpath ("//*[@class='close']/following-sibling::h4");
		public final By CloseiconInInvalidDateValidationMessage=By.linkText("Close");
		public final By ValidationMessageOverlayWhenToDateisBeforeFromDate=By.id ("caseNoteValidationError");
		public final By ResetAllLink=By.linkText ("Reset all");
		
		public final By OrderBybutton=By.xpath ("//li[@id='orderby_button']/ul/li/a");
		
		
		
		
		
		
		
	     //Methods for Date Filter
		
		public boolean isFieldUnderDateTabDisplayed(String value) {
			logger.info("Checking if " + value
					+ " Field is Displayed");
			boolean result = false;
			elements.waitForElementFluently(
					homepageobject.HomeLink, 10);
			if ((value).equals("Date from")) {
				result = elements.isDisplayed(DateFromFilter);
			} else if ((value).equals("Date To")) {
				result = elements.isDisplayed(DateToFilter);
			} else if ((value).equals("Last7daysLink")) {
				result = elements.isDisplayed(Last7DaysLink);
			} else if ((value).equals("Last30DaysLink")) {
				result = elements.isDisplayed(Last30daysLink);
			} else if ((value).equals("LastYearLink")) {
				result = elements.isDisplayed(LastYearLink);
			} else if ((value).equals("ResetAllButton")) {
				result = elements.isDisplayed(ResetButton);
			}
				return result;
		}
	

		public void enterValueinDateFromTextbox(String value) {
			logger.info("Enter Date in From Textbox");
			elements.waitForElementFluently(DateFromFilter,70);
			//elements.waitForElementToBeClickable(DateFromFilter,40);
			elements.waitForElementFluently(DateToFilter,70);
			//elements.waitForElementToBeClickable(DateFromFilter,40);
			//elements.waitForPageLoaded();
			elements.inputValue(DateFromFilter, value);
		
		}
		
	
		public void enterValueinDateToTextbox(String value) {
			logger.info("Enter Date in From Textbox");
			elements.waitForElementFluently(DateToFilter,30);
			elements.inputValue(DateToFilter, value);
		
		}
		
		public void clickOnDateToTextBox(){
			logger.info("Click on Date To textbox");
			elements.waitForElementFluently(DateToFilter,30);
			elements.buttonClick(DateToFilter);
	
		}
	
		public void clickOnDateFromTextBox(){
			logger.info("Click on Date From textbox");
			elements.waitForElementFluently(DateFromFilter,30);
			elements.buttonClick(DateFromFilter);
	
		}
		
		public void clickOnResetButton() {
			logger.info("clickOnResetButton");
			elements.waitForElementFluently(ResetButton,70);
			elements.waitForElementToBeClickable( ResetButton, 70);
		    elements.buttonClick(ResetButton);
			
			elements.waitForPageLoaded();
		
		}
		
		
		public String getTextfromValidationMessageWhenTodateisBeforeFromDate() {
			logger.info("Fetching the Text of Validation  message on Invalid Date Entry");
			elements.waitForElementFluently(ValidationMessageOverlayWhenToDateisBeforeFromDate,30);
			elements.waitForElementFluently(ValidationMessageWhenTodateisBeforeFromDate,70);
	 		elements.waitForElementFluently(
	 				CloseiconInInvalidDateValidationMessage,70);
	 	 		return elements.getText(ValidationMessageWhenTodateisBeforeFromDate);
	 	}
		
		public String getTextfromValidationMessageonInvalidDateEntry() {
			logger.info("Fetching the Text of Validation  message on Invalid Date Entry");
			//elements.waitForPageLoaded();
			elements.waitForElementFluently(InvalidDateValidationMessage,40);
	 		elements.waitForElementFluently(
	 				CloseiconInInvalidDateValidationMessage,40);
	 	 		return elements.getText(InvalidDateValidationMessage);
	 	}
		
			
		
public void clickOnLast7daysLink() {
	logger.info("Click On Last7days link");
	elements.waitForElementFluently(
			homepageobject.HomeLink, 40);
	elements.waitForElementFluently(
			Last7DaysLink, 50);
	elements.buttonClick(Last7DaysLink);
}



  public void clickOnLast30daysLink() {
	logger.info("Click On Last30days link");
	elements.waitForElementFluently(
			homepageobject.HomeLink, 40);
	elements.waitForElementFluently(
			Last30daysLink, 50);
	elements.buttonClick(Last30daysLink);
}

  public void clickOnLastyearLink() {
		logger.info("Click On Lastyear link");
		elements.waitForElementFluently(
				LastYearLink, 50);
		elements.buttonClick(LastYearLink);
	}

  
  public void clickonFilterButton() throws InterruptedException {
		logger.info("Clicking on Filter Button on Case Notes page");
		elements.waitForElementFluently(
				homepageobject.HomeLink, 40);
		elements.waitForElementFluently( sourcefilterpageobject.FilterButton,
				40);
		elements.buttonClick(sourcefilterpageobject.FilterButton);
		//elements.waitForPageLoaded();
	}
  
  
  public boolean isFilterIconinDateTabDisplayed() {
		logger.info("Checking if Filter Icon in Date Tab is Displayed");
		elements.waitForElementFluently( DateFilterIcon,
				40);
		return elements.isDisplayed(DateFilterIcon);
	}
  
  
  
  
  
  
  public boolean verifyRecordsDisplayedOnClickingOnLast7daysLink() throws ParseException {
		logger.info("Verifying whether proper records are being displayed in the result table  "
				+ "on clicking on Last 7 days link");
		elements.waitForPageLoaded();
		elements.waitForElementFluently(
				sourcefilterpageobject.CaseNotesEntryResultTable, 30);
		
		String currentDateTime = new SimpleDateFormat("d-MMM-yyyy")
        .format(new Date().getTime());
		
		logger.info("current Date is " 
				+ currentDateTime);
		
		Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -6);
        String fromdate = (new SimpleDateFormat("d-MMM-yyyy")).format(cal.getTime());
        
        logger.info("Last 7 days Date is " 
				+ fromdate );
        
		boolean result = false;
		SimpleDateFormat sdf = new SimpleDateFormat("d-MMM-yyyy");
		Date startDate = sdf.parse(fromdate);
		logger.info("Last 7 days Start parse Date is " 
				+ startDate );
		Date endDate = sdf.parse(currentDateTime);
		logger.info("Last 7 days parse Date is " 
				+ currentDateTime);
		if(elements.getElementListWithIdentification(sourcefilterpageobject.CaseNotesEntryResults).size()==0){
			result = true;
		}
		else{
			for (WebElement options : elements.getElementListWithIdentification(sourcefilterpageobject.CaseNotesEntryResults)) {
				String text = options.findElement(By.xpath("./td[4]")).getText();
				if (!text.equals("")) {
					
					String[] text1 = text.split(" ");
					logger.info("date after split" 
							+ text1[0]);
					Date dateToCompare = sdf.parse(text1[0]);
					logger.info("Date to compare" 
							+ dateToCompare);
					if((startDate.compareTo(dateToCompare)<=0)&&(endDate.compareTo(dateToCompare)>=0))
						result = true;
					else
						result = false;
				} else {
						result = false;
				}
				
			}
		}
		

		return result;
	}
  
  public Boolean isDateFilterPanelVisible(){
	  elements.waitForElementFluently( dateFilterPanel, 10);
	  return elements.isDisplayed(dateFilterPanel);
  }
  

  public boolean verifyRecordsDisplayedOnClickingOnLast30daysLink() throws ParseException {
		logger.info("Verifying whether proper records are being displayed in the result table  "
				+ "on clicking on Last 30 days link " );
		elements.waitForPageLoaded();		
		elements.waitForElementFluently(
				sourcefilterpageobject.CaseNotesEntryResultTable, 30);
		
		String currentDateTime = new SimpleDateFormat("d-MMM-yyyy")
        .format(new Date().getTime());
		
		logger.info("current Date is " 
				+ currentDateTime);
		
		Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -29);
        String fromdate = (new SimpleDateFormat("d-MMM-yyyy")).format(cal.getTime());
        
        logger.info("Last 30 days Date is " 
				+ fromdate );
        
		boolean result = false;
		SimpleDateFormat sdf = new SimpleDateFormat("d-MMM-yyyy");
		Date startDate = sdf.parse(fromdate);
		logger.info("Last 30 days Start parse Date is " 
				+ startDate );
		Date endDate = sdf.parse(currentDateTime);
		logger.info("Last 30 days parse Date is " 
				+ currentDateTime);
		if(elements.getElementListWithIdentification(sourcefilterpageobject.CaseNotesEntryResults).size()==0){
			result = true;
		}
		else{
			for (WebElement options : elements.getElementListWithIdentification(sourcefilterpageobject.CaseNotesEntryResults)) {
				String text = options.findElement(By.xpath("./td[4]")).getText();
				if (!text.equals("")) {
					
					String[] text1 = text.split(" ");
					logger.info("date after split" 
							+ text1[0]);
					Date dateToCompare = sdf.parse(text1[0]);
					logger.info("Date to compare" 
							+ dateToCompare);
					if((startDate.compareTo(dateToCompare)<=0)&&(endDate.compareTo(dateToCompare)>=0))
						result = true;
					else
						result = false;
				} else {
						result = false;
				}
				
			}
		}
		

		return result;
	}
  
  public boolean verifyRecordsDisplayedOnClickingOnLastYearLink() throws ParseException {
		logger.info("Verifying whether proper records are being displayed in the result table"
				+ "on clicking on Last year link ");
		elements.waitForPageLoaded();
		elements.waitForElementFluently(
				sourcefilterpageobject.CaseNotesEntryResultTable, 30);
		
		String currentDateTime = new SimpleDateFormat("d-MMM-yyyy")
      .format(new Date().getTime());
		
		logger.info("current Date is " 
				+ currentDateTime);
		
		Calendar cal = Calendar.getInstance();
      cal.add(Calendar.DATE, -364);
      String fromdate = (new SimpleDateFormat("d-MMM-yyyy")).format(cal.getTime());
      
      logger.info("Last year  Date is " 
				+ fromdate );
      
		boolean result = false;
		SimpleDateFormat sdf = new SimpleDateFormat("d-MMM-yyyy");
		Date startDate = sdf.parse(fromdate);
		logger.info("Last year day Start parse Date is " 
				+ startDate );
		Date endDate = sdf.parse(currentDateTime);
		logger.info("Last year  parse Date is " 
				+ currentDateTime);
		if(elements.getElementListWithIdentification(sourcefilterpageobject.CaseNotesEntryResults).size()==0){
			result = true;
		}
		else{
			for (WebElement options : elements.getElementListWithIdentification(sourcefilterpageobject.CaseNotesEntryResults)) {
				String text = options.findElement(By.xpath("./td[4]")).getText();
				if (!text.equals("")) {
					
					String[] text1 = text.split(" ");
					logger.info("date after split" 
							+ text1[0]);
					Date dateToCompare = sdf.parse(text1[0]);
					logger.info("Date to compare" 
							+ dateToCompare);
					if((startDate.compareTo(dateToCompare)<=0)&&(endDate.compareTo(dateToCompare)>=0))
						result = true;
					else
						result = false;
				} else {
						result = false;
				}
				
			}
		}
		

		return result;
	}
  
  
  public boolean verifyRecordsDisplayedasPerDateSelectedInFromandToDateTextbox(String Fromdate,String Todate) throws ParseException {
		logger.info("Verifying whether proper records are being displayed in the result table  "
				+ "as per the range of dates entered in From and to textbox");
		elements.waitForPageLoaded();
		elements.waitForElementFluently(
				sourcefilterpageobject.CaseNotesEntryResultTable, 30);
		
	/* String currentDateTime = new SimpleDateFormat("d-MMM-yyyy")
    .format(new Date().getTime());*/
		
		/*logger.info("current Date is " 
				+ currentDateTime);*/
		
	/*Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, -364);
    String fromdate = (new SimpleDateFormat("d-MMM-yyyy")).format(cal.getTime());
    
    logger.info("Last year  Date is " 
				+ fromdate );*/
    
		boolean result = false;
		SimpleDateFormat sdf = new SimpleDateFormat("d-MMM-yyyy");
		Date startDate = sdf.parse(Fromdate);
		logger.info("Last year day Start parse Date is " 
				+ startDate );
		Date endDate = sdf.parse(Todate);
		logger.info("Last year  parse Date is " 
				+ endDate);
		if(elements.getElementListWithIdentification(sourcefilterpageobject.CaseNotesEntryResults).size()==0){
			result = true;
		}
		else{
			for (WebElement options : elements.getElementListWithIdentification(sourcefilterpageobject.CaseNotesEntryResults)) {
				String text = options.findElement(By.xpath("./td[4]")).getText();
				if (!text.equals("")) {
					
					String[] text1 = text.split(" ");
					logger.info("date after split" 
							+ text1[0]);
					Date dateToCompare = sdf.parse(text1[0]);
					logger.info("Date to compare" 
							+ dateToCompare);
					if((startDate.compareTo(dateToCompare)<=0)&&(endDate.compareTo(dateToCompare)>=0))
						result = true;
					else
						result = false;
				} else {
						result = false;
				}
				
			}
		}
		

		return result;
	}

  public boolean verifyRecordsDisplayedasperCurrentdate() throws ParseException {
		logger.info("Verifying whether proper records are being displayed in the result table  "
				+ "as per the Current Date");
		//elements.waitForPageLoaded();
		elements.waitForElementFluently(
				sourcefilterpageobject.CaseNotesEntryResultTable, 40);
		
	String currentDate = new SimpleDateFormat("d-MMM-yyyy").format(new Date().getTime());
		
		logger.info("current Date is " 
				+ currentDate);
		
	/*Calendar cal = Calendar.getInstance();
  cal.add(Calendar.DATE, -364);
  String fromdate = (new SimpleDateFormat("d-MMM-yyyy")).format(cal.getTime());
  
  logger.info("Last year  Date is " 
				+ fromdate );*/
  
		boolean result = false;
		SimpleDateFormat sdf = new SimpleDateFormat("d-MMM-yyyy");
		Date startDate = sdf.parse(currentDate);
		logger.info("Current date after parsing Date is " 
				+ startDate );
		
		if(elements.getElementListWithIdentification(sourcefilterpageobject.CaseNotesEntryResults).size()==0){
			result = true;
		}
		else{
			for (WebElement options : elements.getElementListWithIdentification(sourcefilterpageobject.CaseNotesEntryResults)) {
				String text = options.findElement(By.xpath("./td[4]")).getText();
				if (!text.equals("")) {
					
					String[] text1 = text.split(" ");
					logger.info("date after split" 
							+ text1[0]);
					Date dateToCompare = sdf.parse(text1[0]);
					logger.info("Date to compare" 
							+ dateToCompare);
					if((startDate.equals(dateToCompare)))
						result = true;
					else
						result = false;
				} else {
						result = false;
				}
				
			}
		}
		

		return result;
	}

  
  public Boolean isDateFromValid(){
	  elements.waitForElementFluently( DateFilterSelectedIndicator, 5);
	  return elements.isDisplayed(DateFilterSelectedIndicator);
  }
  
  
  public void clearDateFromField(){
	  elements.getElementWithIdentification(DateFromFilter).clear();
	  //DateToFilter.click();
	  elements.getElementWithIdentification(DateFromFilter).sendKeys(Keys.RETURN);
	  elements.getElementWithIdentification(DateFromFilter).sendKeys(Keys.TAB);
  }
  
  public void enterDateFromWithTab(String value){
	  enterValueinDateFromTextbox(value);
	  elements.getElementWithIdentification(DateFromFilter).sendKeys(Keys.RETURN);
	  elements.getElementWithIdentification(DateFromFilter).sendKeys(Keys.TAB);
  }
  
  public Boolean isDateToValid(){
	  elements.waitForElementFluently( DateFilterSelectedIndicator, 5);
	  return elements.isDisplayed(DateFilterSelectedIndicator);
  }

  public void clearDateToField(){
	  elements.getElementWithIdentification(DateToFilter).clear();
	  //DateFromFilter.click();
	  elements.getElementWithIdentification(DateToFilter).sendKeys(Keys.RETURN);
	  elements.getElementWithIdentification(DateToFilter).sendKeys(Keys.TAB);
  }
  
  public Boolean isDateInvalid(){
	  return elements.isDisplayed(InvalidDateValidationMessage);
  }
  
  public void enterDateToWithTab(String value){
	  enterValueinDateToTextbox(value);
	  //DateFromFilter.click();
	  elements.getElementWithIdentification(DateToFilter).sendKeys(Keys.RETURN);
	  elements.getElementWithIdentification( DateToFilter).sendKeys(Keys.TAB);
  }
  
  
  public Boolean isCaseNotesPageLoaded(){
	  elements.waitForElementFluently(caseNotesResultsTable, 15);
	  return elements.isDisplayed(caseNotesResultsTable);
  }
  
  
  public boolean isDateFilterInActiveFilterListDisplayed() {
		logger.info("Checking if 'Date Filter' is Displayed in Active Filter section");
		elements.waitForElementFluently( sourcefilterpageobject.FilterByForm,
				30);
		return elements.isElementPresent(
				DateFilterSelectedIndicator);
	}
  
  public void clickOnOrderBybutton() {
		logger.info("Click On orderbybutton link");
		elements.waitForElementFluently( editcasenotepageobject.OrderBybutton, 50);
		elements.buttonClick( editcasenotepageobject.OrderBybutton);
	}
  
  
 
	}


  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


	
	
	
	
	
	
	
	
	
		
	
	
	



package com.uspeclipse.pageobjects.casenotes;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.uspeclipse.commonservices.GenericActions;
import com.uspeclipse.commonservices.MultipleBrowser;
import com.uspeclipse.pageobjects.home.Home_pageobjects;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;
import com.uspeclipse.setup.LoggerHelper;

public class PractitionerFilter_pageobject {
	
	private WebDriver driver;
	GenericActions elements = null;

	//Page objects are initialized here
	Home_pageobjects homepageobject =null;
	AddPerson_pageobject addpersonpageobject = null;
	SourceFilter_pageobject sourcefilterpageobject =null;
	PractitionerOrganisationFilter_pageobject practitionerorganisationfilterpageobject = null;
	
	private static  Logger logger = Logger.getLogger(PractitionerFilter_pageobject.class);
	
	
	public PractitionerFilter_pageobject(WebDriver driver){
		this.driver = driver;
		this.homepageobject = PageFactory.initElements(
				driver, Home_pageobjects.class);
		this.addpersonpageobject = PageFactory.initElements(
				 driver,AddPerson_pageobject.class);
		this.sourcefilterpageobject = PageFactory.initElements(
				 driver,SourceFilter_pageobject.class);
		this.practitionerorganisationfilterpageobject = PageFactory.initElements(
				 driver,PractitionerOrganisationFilter_pageobject.class);
		elements = new GenericActions(driver);
	}
	public final By PractitionerFilterSelectedIndicator=By.xpath ("//div[@id='caseNoteFilterContext']//span[contains(text(),'Practitioner')]//a[@class='removePractitioner']");
	public final By  PractitionerFilterList=By.xpath ("//select[@id='caseNoteEntryFilter_practitioner']/option"); 
	public final By  EntryTypeList=By.xpath ("//select[@id='caseNoteEntryFilter_entryType']/option");
	public final By EntryTypeFilter=By.id ("caseNoteEntryFilter_entryType");
	public final By PositiveCheckbox=By.id ("caseNoteEntryFilter_impactPositive");
	public final By NegativeCheckbox=By.id ("caseNoteEntryFilter_impactNegative");
	public final By NeutralCheckbox=By.id ("caseNoteEntryFilter_impactNeutral");	
	public final By UnknownCheckbox=By.id ("caseNoteEntryFilter_impactUnknown");
	public final By FilterPanel=By.xpath ("//*[@id ='caseNoteEntryResultsFilterForm']/div");	
	public final By FilterByTypeAndOther=By.xpath ("//a[contains(text(),'Type and other')]");
	public final By ImpactFilterSelectedIndicator=By.xpath ("//*[@id='caseNoteFilterContext']//span[contains(text(),'Impact')]");		
	public final By EntryTypeFilterSelectedIndicator=By.xpath ("//*[@id='caseNoteFilterContext']//span[contains(text(),'Entry type')]");
	public final By IncludeDeletedCheckbox=By.id ("caseNoteEntryFilter_statusDeleted");
	
	
	                                // Methods
	
	
	public void clickonTypeAndotherTabinFilterBy() throws InterruptedException {
		logger.info("Clicking on People Tab in Filter By on Case Notes page");
		elements.waitForElementFluently(
				FilterByTypeAndOther, 30);
		elements.buttonClick(FilterByTypeAndOther);
	}
	
	public void clickonPractitionerFilterRemoveButton() throws InterruptedException {
		logger.info("Clicking on PractitionerFilter button");
		elements.waitForElementFluently(
				PractitionerFilterSelectedIndicator, 30);
		elements.buttonClick(PractitionerFilterSelectedIndicator);
		elements.waitForPageLoaded();
	}
	
	public void clickonResetAllLinkInActiveFilter() {
		logger.info("Clicking on Filter Reset Link");
		elements.waitForElementFluently(
				sourcefilterpageobject.ResetAllFiltersLink, 40);
		elements.buttonClick(sourcefilterpageobject.ResetAllFiltersLink);
		elements.waitForPageLoaded();
	}
	
	public boolean isEntryTypeFilterSelectedIndicatorDisplayed() {
		logger.info("Checking if 'Source' is Displayed in Active Filter section");
		elements.waitForElementFluently( sourcefilterpageobject.FilterByForm,
				40);
		return elements.isElementPresent(
				EntryTypeFilterSelectedIndicator);
	}
	
	
	
	
	
	public boolean isImpactFilterSelectedIndicatorDisplayed() {
		logger.info("Checking if 'Source' is Displayed in Active Filter section");
		elements.waitForElementFluently( sourcefilterpageobject.FilterByForm,
				40);
		return elements.isElementPresent(
				ImpactFilterSelectedIndicator);
	}
	
	public boolean isFilterPanelDisplayed() {
		logger.info("Checking if Filter Panel is Displayed ");
		elements.waitForElementFluently( sourcefilterpageobject.FilterByForm,
				40);
		elements.waitForElementFluently( FilterPanel,
				40);
		return elements.isElementPresent(
				FilterPanel);
	}
	
	public void selectAllOptionsFromPractitionerFilterMultiSelectBox() {
		logger.info("Selecting All Options from PractitionerOrganisation Filter Multi-Select Box");
		elements.waitForPageLoaded();
		elements.waitForElementFluently(
				practitionerorganisationfilterpageobject.PractitionerFilter, 40);
		Actions act = new Actions(driver);
		for (WebElement options : elements.getElementListWithIdentification(PractitionerFilterList)) {
			act.keyDown(Keys.CONTROL).build().perform();
			elements.buttonClick(options);
			elements.waitForPageLoaded();
		}
		act.keyUp(Keys.CONTROL);
	}
	
	public int getTotalNumberofRecordsInTheResultTable() {
		logger.info("Getting the Number of Records in the Result Table");
	    elements.waitForPageLoaded();
		elements.waitForElementFluently(
				sourcefilterpageobject.CaseNotesEntryResultTable, 50);
		int records =  elements.getElementListWithIdentification(sourcefilterpageobject.CaseNotesEntryResults).size();
		return records;
	}
	
	public void selectOptionbyNumberFromEntryTypeList(
			String numbers) {
		logger.info("Selecting Option " + numbers
				+ " from Source Filter Multi-Select Box");
		elements.waitForElementFluently(
			EntryTypeFilter, 30);
		int i = 0;
		int j = 0;
		String[] optionToSelect = numbers.split(",");
		int selectCount = optionToSelect.length;
		Actions act = new Actions(driver);
		for (WebElement options :  elements.getElementListWithIdentification(EntryTypeList)) {
			if (j == Integer.parseInt(optionToSelect[i].trim())) {
				act.keyDown(Keys.CONTROL).build().perform();
				elements.buttonClick(options);
				i++;
				if (selectCount == i)
					break;
			}
			j++;
		}
		act.keyUp(Keys.CONTROL);
	}
	
	
	
	
	public void selectOptionbyNumberFromPractitionerFilterMultiSelectBox(
			String numbers) {
		logger.info("Selecting Option " + numbers
				+ " from Source Filter Multi-Select Box");
		elements.waitForPageLoaded();
		elements.waitForElementFluently(
				practitionerorganisationfilterpageobject.PractitionerFilter	, 30);
		int i = 0;
		int j = 0;
		String[] optionToSelect = numbers.split(",");
		int selectCount = optionToSelect.length;
		Actions act = new Actions(driver);
		for (WebElement options :  elements.getElementListWithIdentification(PractitionerFilterList)) {
			if (j == Integer.parseInt(optionToSelect[i].trim())) {
				act.keyDown(Keys.CONTROL).build().perform();
		 elements.buttonClick(options);
		 elements.waitForPageLoaded();
				i++;  
				if (selectCount == i)
					break;
			}
			j++;
		}
		act.keyUp(Keys.CONTROL);
	}
	
	
	public boolean isPractitionerFilterInActiveFilterListDisplayed() {
		logger.info("Checking if 'Practioner' is Displayed in Active Filter section");
		elements.waitForElementFluently( sourcefilterpageobject.FilterByForm,
				40);
		return elements.isElementPresent(
				PractitionerFilterSelectedIndicator);
	}
	
	public boolean isResultforSinglePractitionerSelectionCorrect(String value) {
		logger.info("Checking if the result after selecting " + value
				+ " from Practitioner Filter is correct");
		elements.waitForPageLoaded();
		elements.waitForElementFluently(
				sourcefilterpageobject.CaseNotesEntryResultTable, 30);
		boolean result = false;
		for (WebElement options :  elements.getElementListWithIdentification(sourcefilterpageobject.CaseNotesEntryResults)) {
			String text = options.findElement(By.xpath("./td[9]")).getText();
			if (!text.equals("")) {
				String text1 = text.substring(0, text.indexOf("(")).trim();
				logger.info("Single Value is " + text1);
				if (text1.equals(value))
					result = true;
				else
					result = false;
			} else {
				if (text.equals(value))
					result = true;
				else
					result = false;
			}
		}
		return result;
	}
	
	public boolean isResultForSingleImpactCheckboxSelection(String value) {
		logger.info("Checking if the result after selecting " + value
				+ " from Practitioner Filter is correct");
		elements.waitForPageLoaded();
		elements.waitForElementFluently(
				sourcefilterpageobject.CaseNotesEntryResultTable, 30);
		boolean result = false;
		for (WebElement options :  elements.getElementListWithIdentification(sourcefilterpageobject.CaseNotesEntryResults)) {
			String text = options.findElement(By.xpath("//td[7]/i")).getAttribute("title");
		logger.info("Text is " + text );
			if (!text.equals("")) {			
				logger.info("Single Value is " + text);
				if (text.equals(value))
					result = true;
				else
					result = false;
			} else {
				if (text.equals(value))
					result = true;
				else
					result = false;
			}
		}
		return result;
	}
	
	
	public boolean isResultForSingleEntryTypeSelectionCorrect(String value) {
		logger.info("Checking if the result after selecting " + value
				+ " from Practitioner Filter is correct");
		elements.waitForPageLoaded();
		elements.waitForElementFluently(
				sourcefilterpageobject.CaseNotesEntryResultTable, 30);
		
		boolean result = false;
		for (WebElement options :  elements.getElementListWithIdentification(sourcefilterpageobject.CaseNotesEntryResults)) {
			String text = options.findElement(By.xpath("./td[6]")).getText();
		logger.info("Text is " + text );
			if (!text.equals("")) {			
				logger.info("Single Value is " + text);
				if (text.equals(value))
					result = true;
				else
					result = false;
			} else {
				if (text.equals(value))
					result = true;
				else
					result = false;
			}
		}
		return result;
	}
	
	
	
	
	
	public boolean isResultforDoublePractitionerSelectionCorrect(String value,
			String value1) {
		logger.info("Checking if the result after selecting " + value + " and "
				+ value1 + " from Practitioner Filter is correct");
		elements.waitForPageLoaded();
		elements.waitForElementFluently(
				sourcefilterpageobject.CaseNotesEntryResultTable, 30);
		boolean result = false;
		for (WebElement options :  elements.getElementListWithIdentification(sourcefilterpageobject.CaseNotesEntryResults)) {
			String text = options.findElement(By.xpath("./td[9]")).getText();
			if (!text.equals("")) {
				String text1 = text.substring(0, text.indexOf("(")).trim();
				logger.info("Double Value is " + text1);
				if (text1.equals(value) || text1.equals(value1))
					result = true;
				else
					result = false;
			} else {
				if (text.equals(value) || text.equals(value1))
					result = true;
				else
					result = false;
			}
		}
		return result;
	}
	
	
	public boolean isResultforTriplePractitionerSelectionCorrect(String value,
			String value1, String value2) {
		logger.info("Checking if the result after selecting " + value + ", "
				+ value1 + " and " + value2 + " from Practitioner Filter is correct");
		elements.waitForPageLoaded();
		elements.waitForElementFluently(
				sourcefilterpageobject.CaseNotesEntryResultTable, 30);
		boolean result = false;
		for (WebElement options :  elements.getElementListWithIdentification(sourcefilterpageobject.CaseNotesEntryResults)) {
			String text = options.findElement(By.xpath("./td[9]")).getText();
			if (!text.equals("")) {
				String text1 = text.substring(0, text.indexOf("(")).trim();
				logger.info("Triple Value is " + text1);
				if (text1.equals(value) || text1.equals(value1)
						|| text1.equals(value2))
					result = true;
				else
					result = false;
			} else {
				if (text.equals(value) || text.equals(value1)
						|| text.equals(value2))
					result = true;
				else
					result = false;
			}
		}
		return result;
	}

	
	public boolean isResultforMultiplePractitionerSelectionCorrect(String value,
			String value1, String value2, String value3) {
		logger.info("Checking if the result after selecting " + value + ", "
				+ value1 + ", " + value2 + " and " + value3
				+ " from Source Filter is correct");
		elements.waitForPageLoaded();
		elements.waitForElementFluently(
				sourcefilterpageobject.CaseNotesEntryResultTable, 30);
		boolean result = false;
		for (WebElement options :  elements.getElementListWithIdentification(sourcefilterpageobject.CaseNotesEntryResults)) {
			String text = options.findElement(By.xpath("./td[9]")).getText();
			if (!text.equals("")) {
				String text1 = text.substring(0, text.indexOf("(")).trim();
				logger.info("Multiple Value is " + text1);
				if (text1.equals(value) || text1.equals(value1)
						|| text1.equals(value2) || text1.equals(value3))
					result = true;
				else
					result = false;
			} else {
				if (text.equals(value) || text.equals(value1)
						|| text.equals(value2) || text.equals(value3))
					result = true;
				else
					result = false;
			}
		}
		return result;
	}
	
	public boolean isResultforMultiplePractitionerSelectionForFiveOptionsCorrect(String value,
			String value1, String value2, String value3 , String value4) {
		logger.info("Checking if the result after selecting " + value + ", "
				+ value1 + ", " + value2 + " , " + value3 + " and " + value4 
				+ " from Practitioner Filter is correct");
		elements.waitForPageLoaded();
		elements.waitForElementFluently(
				sourcefilterpageobject.CaseNotesEntryResultTable, 30);
		boolean result = false;
		for (WebElement options :  elements.getElementListWithIdentification(sourcefilterpageobject.CaseNotesEntryResults)) {
			String text = options.findElement(By.xpath("./td[9]")).getText();
			if (!text.equals("")) {
				String text1 = text.substring(0, text.indexOf("(")).trim();
				logger.info("Multiple Value for 5  is " + text1);
				if (text1.equals(value) || text1.equals(value1)
						|| text1.equals(value2) || text1.equals(value3)||text1.equals(value4))
					result = true;
				else
					result = false;
			} else {
				if (text.equals(value) || text.equals(value1)
						|| text.equals(value2) || text.equals(value3)||text.equals(value4))
					result = true;
				else
					result = false;
			}
		}
		return result;
	}
	
	
	public String[] storeTextofOptionsfromPractitionerFilterMultiSelectBox() {
		logger.info("Storing the Text of all the Options in String Array");
		elements.waitForPageLoaded();
		elements.waitForElementFluently(
				practitionerorganisationfilterpageobject.PractitionerFilter, 30);
		String[] result = new String[ elements.getElementListWithIdentification(PractitionerFilterList).size()];
		for (int i = 0; i <  elements.getElementListWithIdentification(PractitionerFilterList).size(); i++) {
			result[i] = elements.getElementListWithIdentification(PractitionerFilterList).get(i).getText();
		}
		return result;
	}
	
	
	public String[] storeTextofOptionsfromEntryTypeFilterMultiSelectBox() {
		logger.info("Storing the Text of all the Options in String Array");
		elements.waitForPageLoaded();
		elements.waitForElementFluently(
				EntryTypeFilter, 30);
		String[] result = new String[ elements.getElementListWithIdentification(EntryTypeList).size()];
		for (int i = 0; i < elements.getElementListWithIdentification(EntryTypeList).size(); i++) {
			result[i] =  elements.getElementListWithIdentification(EntryTypeList).get(i).getText();
		}
		return result;
	}
	
	
	
	
	
	
	
	public String getNumberofOptionsfromPractitionerFilterMultiSelectBox() {
		logger.info("Getting the number of options in the Source Filter");
		elements.waitForElementFluently(
				practitionerorganisationfilterpageobject.PractitionerFilter, 10);
		int number =  elements.getElementListWithIdentification(PractitionerFilterList).size() - 1;
		return String.valueOf(number);
	}
	
	public void clickonImpactCheckbox(String value) {
		logger.info("Clicking on " + value + " Checkbox on Impact Frame");
		if (value.equals("Positive"))
			elements.buttonClick(PositiveCheckbox);
		else if (value.equals("Negative"))
			elements.buttonClick(NegativeCheckbox);
		else if (value.equals("Neutral"))
			elements.buttonClick(NeutralCheckbox);
		else if (value.equals("Unknown"))
			elements.buttonClick(UnknownCheckbox);
	}
	
	
	public void clickonIncludeDeletedCheckbox() {
		elements.waitForElementFluently(IncludeDeletedCheckbox , 30);
		elements.buttonClick(IncludeDeletedCheckbox);
		
		
	}
	}
	
	
	
	
	


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

public class PractitionerOrganisationFilter_pageobject {
	
	private WebDriver driver;
	//Page objects are initialized here
	Home_pageobjects homepageobject = null;
	AddPerson_pageobject addpersonpageobject = null;
	SourceFilter_pageobject sourcefilterpageobject =null;
	
	private static  Logger logger = Logger.getLogger(PractitionerOrganisationFilter_pageobject.class);
	GenericActions elements =null;
	
	
	public PractitionerOrganisationFilter_pageobject(WebDriver driver){
		this.driver = driver;
		this.homepageobject = PageFactory.initElements(
				driver, Home_pageobjects.class);
		this.addpersonpageobject = PageFactory.initElements(
				 driver,AddPerson_pageobject.class);
		this.sourcefilterpageobject = PageFactory.initElements(
				 driver,SourceFilter_pageobject.class);
		elements =  new GenericActions(driver);
	}
	public final By PractitionerFilter=By.id ("caseNoteEntryFilter_practitioner");
	public final By PractitionerOrganisationFilterMultiSelectBox=By.id ("caseNoteEntryFilter_practitionerOrganisation");
	public final By SourceFilter=By.id ("caseNoteEntryFilter_source");
	public final By SourceOrganisation=By.id("caseNoteEntryFilter_sourceOrganisation");
	public final By ResetButton=By.id("caseNoteEntryFilter_clearPeople");	 
	public final By PractitionerOrganisationFilterList=By.xpath ("//select[@id='caseNoteEntryFilter_practitionerOrganisation']/option");
	public final By PractitionerOrganisationFilterSelectedIndicator=	By.xpath ("//div[@id='caseNoteFilterContext']//span[contains(text(),'Practitioner organisation')]//a[@class='removePractitionerOrganisation']");


	
	
	
	
	public void clickonPractitionerOrganisationFilterRemoveButton() throws InterruptedException {
		logger.info("Clicking on PractitionerOrganisationFilter button");
		elements.waitForElementFluently(
				PractitionerOrganisationFilterSelectedIndicator, 30);
		elements.buttonClick(PractitionerOrganisationFilterSelectedIndicator);
	}
	
	public void selectAllOptionsFromPractitionerOrganisationFilterMultiSelectBox() {
		logger.info("Selecting All Options from PractitionerOrganisation Filter Multi-Select Box");
		elements.waitForPageLoaded();
		elements.waitForElementFluently(
				PractitionerOrganisationFilterMultiSelectBox, 10);
		Actions act = new Actions(driver);
		for (WebElement options : elements.getElementListWithIdentification(PractitionerOrganisationFilterList)) {
			act.keyDown(Keys.CONTROL).build().perform();
			elements.buttonClick(options);
			elements.waitForPageLoaded();
		}
		act.keyUp(Keys.CONTROL);
	}
	
	
	public int getNumberofRecordsforPractitionerOrganisationFilterSelection() {
		logger.info("Getting the Number of Records in the Result Table");
		elements.waitForElementFluently(
				sourcefilterpageobject.CaseNotesEntryResultTable, 10);
		int records = elements.getElementListWithIdentification(sourcefilterpageobject.CaseNotesEntryResults).size();
		return records;
	}
	
	
	
	
	
	
	
	public boolean isFiltersAndButtonsUnderPeoplesTabDisplayed(String value) {
		logger.info("Checking if " + value
				+ " Filters and Reset Button are displayed in Peoples tab");
		boolean result = false;
		elements.waitForElementFluently(
				homepageobject.HomeLink, 10);
		if ((value).equals("PractitionerFilter")) {
			result = elements.isDisplayed(PractitionerFilter);
		} else if ((value).equals("PractitionerOrganisationFilter")) {
			result = elements.isDisplayed(PractitionerOrganisationFilterMultiSelectBox);
		} else if ((value).equals("SourceFilter")) {
			result = elements.isDisplayed(SourceFilter);
		} else if ((value).equals("SourceOrganisation")) {
		  result = elements.isDisplayed(SourceOrganisation);
		}else if ((value).equals("ResetButton")){
			result = elements.isDisplayed(ResetButton);			
		}
		return result;
	}
	
	public void selectOptionbyNumberFromPractitionerOrganisationFilterMultiSelectBox(
			String numbers) {
		logger.info("Selecting Option " + numbers
				+ " from Source Filter Multi-Select Box");
		elements.waitForElementFluently(
				PractitionerOrganisationFilterMultiSelectBox, 10);
		int i = 0;
		int j = 0;
		String[] optionToSelect = numbers.split(",");
		int selectCount = optionToSelect.length;
		Actions act = new Actions(driver);
		for (WebElement options : elements.getElementListWithIdentification(PractitionerOrganisationFilterList)) {
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
	
	
	public boolean isPractitionerOrganisationFilterInActiveFilterListDisplayed() {
		logger.info("Checking if 'Practioner' is Displayed in Active Filter section");
		elements.waitForElementFluently( sourcefilterpageobject.FilterByForm,
				10);
		return elements.isElementPresent(
				PractitionerOrganisationFilterSelectedIndicator);
	}
	
	
	public boolean isResultforSinglePractitionerOrganisationSelectionCorrect(String value) {
		logger.info("Checking if the result after selecting " + value
				+ " from Practitioner Organisation Filter is correct");
		elements.waitForPageLoaded();
		elements.waitForElementFluently(
				sourcefilterpageobject.CaseNotesEntryResultTable, 30);
		boolean result = false;
		for (WebElement options : elements.getElementListWithIdentification(sourcefilterpageobject.CaseNotesEntryResults)) {
			String text = options.findElement(By.xpath("./td[9]")).getText();
			if (!text.equals("")) {
				String text1 = text.substring(text.indexOf("(") + 1, text.indexOf(")")) ;
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

	public boolean isResultforDoublePractitionerOrganisationSelectionCorrect(String value,
			String value1) {
		logger.info("Checking if the result after selecting " + value + " and "
				+ value1 + " from Practitioner Organisation Filter is correct");
		elements.waitForPageLoaded();
		elements.waitForElementFluently(
				sourcefilterpageobject.CaseNotesEntryResultTable, 30);
		boolean result = false;
		for (WebElement options : elements.getElementListWithIdentification(sourcefilterpageobject.CaseNotesEntryResults)) {
			String text = options.findElement(By.xpath("./td[9]")).getText();
			if (!text.equals("")) {
				String text1 = text.substring(text.indexOf("(") + 1, text.indexOf(")")) ;
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

	
	public boolean isResultforTriplePractitionerOrganisationSelectionCorrect(String value,
			String value1, String value2) {
		logger.info("Checking if the result after selecting " + value + ", "
				+ value1 + " and " + value2 + " from Practitioner Organisation Filter is correct");
		elements.waitForPageLoaded();
		elements.waitForElementFluently(
				sourcefilterpageobject.CaseNotesEntryResultTable, 30);
		boolean result = false;
		for (WebElement options : elements.getElementListWithIdentification(sourcefilterpageobject.CaseNotesEntryResults)) {
			String text = options.findElement(By.xpath("./td[9]")).getText();
			if (!text.equals("")) {
				String text1 = text.substring(text.indexOf("(") + 1, text.indexOf(")")) ;
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

	
	public boolean isResultforMultiplePractitionerOrganisationSelectionCorrect(String value,
			String value1, String value2, String value3) {
		logger.info("Checking if the result after selecting " + value + ", "
				+ value1 + ", " + value2 + " and " + value3
				+ " from Source Filter is correct");
		elements.waitForPageLoaded();
		elements.waitForElementFluently(
				sourcefilterpageobject.CaseNotesEntryResultTable, 30);
		boolean result = false;
		for (WebElement options : elements.getElementListWithIdentification(sourcefilterpageobject.CaseNotesEntryResults)) {
			String text = options.findElement(By.xpath("./td[9]")).getText();
			if (!text.equals("")) {
				String text1 = text.substring(text.indexOf("(") + 1, text.indexOf(")")) ;
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
	
	public boolean isResultforMultiplePractitionerOrganisationSelectionForFiveOptionsCorrect(String value,
			String value1, String value2, String value3 , String value4) {
		logger.info("Checking if the result after selecting " + value + ", "
				+ value1 + ", " + value2 + " , " + value3 + " and " + value4 
				+ " from Source Filter is correct");
		elements.waitForPageLoaded();
		elements.waitForElementFluently(
				sourcefilterpageobject.CaseNotesEntryResultTable, 30);
		boolean result = false;
		for (WebElement options : elements.getElementListWithIdentification(sourcefilterpageobject.CaseNotesEntryResults)) {
			String text = options.findElement(By.xpath("./td[9]")).getText();
			if (!text.equals("")) {
				String text1 = text.substring(text.indexOf("(") + 1, text.indexOf(")")) ;
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
	

	
	public String[] storeTextofOptionsfromPractitionerOrganisationFilterMultiSelectBox() {
		logger.info("Storing the Text of all the Options in String Array");
		elements.waitForPageLoaded();
		elements.waitForElementFluently(
				PractitionerOrganisationFilterMultiSelectBox, 30);
		String[] result = new String[elements.getElementListWithIdentification(PractitionerOrganisationFilterList).size()];
		for (int i = 0; i < elements.getElementListWithIdentification(PractitionerOrganisationFilterList).size(); i++) {
			result[i] =elements.getElementListWithIdentification( PractitionerOrganisationFilterList).get(i).getText();
		}
		return result;
	}
	
	
	public String getNumberofOptionsfromPractitionerOrganisationFilterMultiSelectBox() {
		logger.info("Getting the number of options in the Source Filter");
		elements.waitForPageLoaded();
		elements.waitForElementFluently(
				PractitionerOrganisationFilterMultiSelectBox, 30);
		int number =elements.getElementListWithIdentification(PractitionerOrganisationFilterList).size() - 1;
		return String.valueOf(number);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public void selectOptionbyPositionFromPractionerOrganisationFilterMultiSelectBox(int value) {
		logger.info("Selecting Option " + value
				+ " from Practitioner Organisation Filter Multi-Select Box");
		elements.waitForElementFluently(
			PractitionerOrganisationFilter, 30);
		if (value == 0)
			PractitionerOrganisationFilterList.get(0).click();
		else if (value == 1)
			PractitionerOrganisationFilterList.get(1).click();
		else if (value ==2)
			PractitionerOrganisationFilterList.get(2).click();
		else if (value==3)
			PractitionerOrganisationFilterList.get(3).click();
		else if (value ==4)
			PractitionerOrganisationFilterList.get(4).click();
		else if (value==PractitionerOrganisationFilterList.size())
		 PractitionerOrganisationFilterList.get(PractitionerOrganisationFilterList.size()-1).click();	
	}
	
	public String getTextofOptionbyPositionFromPractictitionerFilterMultiSelectBox(int value) {
		logger.info("Getting Text for Option " + value
				+ " from Source Filter Multi-Select Box");
		String result = null;
		elements.waitForElementFluently(
				PractitionerFilter, 10);
		if (value == 1)
			result = PractitionerOrganisationFilterList.get(0).getText();
		else if (value == 2)
			result = PractitionerOrganisationFilterList.get(1).getText();
		else if (value ==3)
			result = PractitionerOrganisationFilterList.get(3).getText();
		else if (value ==3)
			result = PractitionerOrganisationFilterList.get(4).getText();		
		else if (value == PractitionerOrganisationFilterList.size())
			result = PractitionerOrganisationFilterList.get(PractitionerOrganisationFilterList.size() - 1)
					.getText();
		return result;
	}*/
	
	

	
	

}

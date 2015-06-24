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
import com.uspeclipse.pageobjects.home.Home_pageobjects;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;
import com.uspeclipse.setup.Initialization;

public class SourceFilter_pageobject {

	private WebDriver driver;
	Home_pageobjects homepageobject = null;
	AddPerson_pageobject addpersonpageobject = null;
	GenericActions elements = null;
	private static Logger logger = Logger
			.getLogger(SourceFilter_pageobject.class);

	public SourceFilter_pageobject(WebDriver driver) {
		this.driver = driver;
		this.homepageobject = PageFactory.initElements(
				driver,Home_pageobjects.class);
		this.addpersonpageobject = PageFactory.initElements(
				driver,AddPerson_pageobject.class);
		elements = new GenericActions(driver);

	}
	public final By  EntryDateColTableHeader=	By.xpath( "//th[@title='Sort by Entry date']");
	public final By  EntryColTableHeader=	By.xpath( "//th[contains(text(),'Entry')]");
	public final By  EntryTypeColTableHeader=	By.xpath( "//th[contains(text(),'Entry type')]");
	public final By  ImpactColTableHeader=	By.xpath( "//th[contains(text(),'Impact')]");
	public final By  SourceColTableHeader=	By.xpath( "//th[contains(text(),'Source')]");
	public final By  PractitionerColTableHeader=	By.xpath( "//th[contains(text(),'Practitioner')]");
	public final By  StatusColTableHeader=	By.xpath( "//th[contains(text(),'Status')]");
	public final By  ActionsColTableHeader=	By.xpath( "//th[contains(text(),'Actions')]");
	public final By  FilterButton=	By.xpath( "//span[contains(text(),'Filter')]");
	public final By  FilterByForm=	By.id ("caseNoteEntryResultsFilterForm");
	public final By  FilterByDateTab=	By.xpath( "//a[contains(text(),'Date')]");
	public final By  FilterByPeopleTab=	By.xpath( "//a[contains(text(),'People')]");
	public final By  FilterByTypeAndOtherTab=	By.xpath( "//a[contains(text(),'Type and other')]");
	public final By  FilterByGroupTab=	By.xpath( "//a[contains(text(),'Group')]");
	public final By  SourceFilterMultiSelectBox=	By.xpath( "//select[@id='caseNoteEntryFilter_source']");
	// select[@id='caseNoteEntryFilter_source']/option");
	public final By  NotSpecifiedSourceFilter=	By.cssSelector( "select#caseNoteEntryFilter_source>option");
	public final By  ASourceFilter=	By.xpath( "//select[@id='caseNoteEntryFilter_source']/option[2]");
	// select[@id='caseNoteEntryFilter_source']/option"); })
	public final By SourceFilterList= By.cssSelector("select#caseNoteEntryFilter_source>option"); 
	public final By  FilterIconPeopelTab=	By.xpath( "//a[contains(text(),'People')]//*[@class='icon-filter']");
	public final By  ActiveFilters=	By.xpath( "//span[contains(text(),'Active filters')]");
	public final By  SourceFilterSelectedIndicator=	By.xpath( "//div[@id='caseNoteFilterContext']//span[contains(text(),'Source')]");
	public final By  ResetAllFiltersLink=	By.xpath( "//div[@id='caseNoteFilterContext']//a[contains(text(),'Reset all')]");
	public final By  SourceFilterRemoveButton=	By.xpath( "//div[@id='caseNoteFilterContext']//span[contains(text(),'Source')]//a[@class='removeSource']");
	public final By  CaseNotesEntryResults= By.xpath( "//div[@id='generalCaseNoteEntryResults']/div/div/table/tbody[2]/tr");
	public final By  caseNotesResultsTable=	By.id ( "generalCaseNoteEntryResults");
	public final By  CaseNotesEntryResultTable=	By.xpath( "//table[@class='pure-table-table']");
	public final By  FilterResetLink=	By.id ( "caseNoteEntryFilter_clearPeople");
	public final By  SourceOrganizationMultiSelectBox=	By.xpath( "//select[@id='caseNoteEntryFilter_sourceOrganisation']");
	public final By  NotSpecifiedSourceOrganization=	By.xpath( "//select[@id='caseNoteEntryFilter_sourceOrganisation']/option");
	public final By SourceOrganizationList=	 By.xpath( "//select[@id='caseNoteEntryFilter_sourceOrganisation']/option");
	public final By  SourceOrganizationSelectedIndicator=	By.xpath( "//div[@id='caseNoteFilterContext']//span[contains(text(),'Source organisation')]");
	public final By  SourceOrganizationRemoveButton=	By.xpath( "//div[@id='caseNoteFilterContext']//span[contains(text(),'Source organisation')]//a[@class='removeSourceOrganisation']");

	public void clickonSourceFilterButton() throws InterruptedException {
		logger.info("Clicking on Filter Button on Case Notes page");
		elements.waitForElementFluently( homepageobject.HomeLink, 30);
		elements.waitForElementFluently( FilterButton, 30);
		elements.buttonClick(FilterButton);
	}

	public boolean isColumnHeaderDisplayed(String value) {
		logger.info("Checking if " + value
				+ " Column Table Header is Displayed");
		boolean result = false;
		elements.waitForElementFluently( homepageobject.HomeLink, 10);
		if ((value).equals("Entry Date")) {
			result = elements.isDisplayed(EntryDateColTableHeader);
		} else if ((value).equals("Entry")) {
			result = elements.isDisplayed(EntryColTableHeader);
		} else if ((value).equals("Entry Type")) {
			result = elements.isDisplayed(EntryTypeColTableHeader);
		} else if ((value).equals("Impact")) {
			result = elements.isDisplayed(ImpactColTableHeader);
		} else if ((value).equals("Source")) {
			result = elements.isDisplayed(SourceColTableHeader);
		} else if ((value).equals("Practitioner")) {
			result = elements.isDisplayed(PractitionerColTableHeader);
		} else if ((value).equals("Status")) {
			result = elements.isDisplayed(StatusColTableHeader);
		} else if ((value).equals("Actions")) {
			result = elements.isDisplayed(ActionsColTableHeader);
		}
		return result;
	}

	public boolean isFilterByTabDisplayed(String value) {
		logger.info("Checking if " + value + " Filter By Tab is Displayed");
		boolean result = false;
		elements.waitForElementFluently( FilterByForm, 10);
		if ((value).equals("Date")) {
			result = elements.isDisplayed(FilterByDateTab);
		} else if ((value).equals("People")) {
			result = elements.isDisplayed(FilterByPeopleTab);
		} else if ((value).equals("Type")) {
			result = elements.isDisplayed(FilterByTypeAndOtherTab);
		} else if ((value).equals("Group")) {
			result = elements.isDisplayed(FilterByGroupTab);
		}
		return result;
	}

	public boolean isFilterByFormDisplayed() {
		return elements.isElementPresent( FilterByForm);
	}

	public void clickonPeopleTabinFilterBy() throws InterruptedException {
		logger.info("Clicking on People Tab in Filter By on Case Notes page");
		elements.waitForElementFluently( FilterByPeopleTab, 30);
		elements.buttonClick(FilterByPeopleTab);
	}

	public boolean isFilterIconinPeopleTabDisplayed() {
		logger.info("Checking if Filter Icon in Filter Tab is Displayed");
		elements.waitForElementFluently( FilterByForm, 10);
		return elements.isDisplayed(FilterIconPeopelTab);
	}

	public boolean isSourceFilterSelectedIndicatorDisplayed() {
		logger.info("Checking if 'Source' is Displayed in Active Filter section");
		elements.waitForElementFluently( FilterByForm, 10);
		return elements.isElementPresent( SourceFilterSelectedIndicator);
	}

	public boolean isResetAllFiltersLinkDisplayed() {
		logger.info("Checking if Reset All Link is Displayed in Active Filter section");
		elements.waitForElementFluently( ActiveFilters, 10);
		return elements.isDisplayed(ResetAllFiltersLink);
	}

	public void clickonFilterResetLink() {
		logger.info("Clicking on Filter Reset Link");
		elements.waitForElementFluently( FilterResetLink, 10);
		elements.buttonClick(FilterResetLink);
	}

	public int getNumberofRecordsforSourceFilterSelection() {
		logger.info("Getting the Number of Records in the Result Table");
		elements.waitForElementFluently( CaseNotesEntryResultTable, 10);
		int records = elements.getElementListWithIdentification(CaseNotesEntryResults).size();
		return records;
	}

	public void clickonSourceFilterRemoveButton() throws InterruptedException {
		logger.info("Clicking on Remove Source Filter button");
		elements.waitForElementFluently( SourceFilterRemoveButton, 30);
		elements.buttonClick(SourceFilterRemoveButton);
	}

	public String getNumberofOptionsfromSourceFilterMultiSelectBox() {
		logger.info("Getting the number of options in the Source Filter");
		elements.waitForElementFluently( SourceFilterMultiSelectBox, 10);
		int number = elements.getElementListWithIdentification(SourceFilterList).size() - 1;
		return String.valueOf(number);
	}

	public String[] storeTextofOptionsfromSourceFilterMultiSelectBox() {
		logger.info("Storing the Text of all the Options in String Array");
		elements.waitForElementFluently( SourceFilterMultiSelectBox, 10);
		String[] result = new String[elements.getElementListWithIdentification(SourceFilterList).size()];
		for (int i = 0; i < elements.getElementListWithIdentification(SourceFilterList).size(); i++) {
			result[i] = elements.getElementListWithIdentification(SourceFilterList).get(i).getText();
		}
		return result;
	}

	public void selectOptionsbyTextFromSourceFilterMultiSelectBox(String value) {
		logger.info("Selecting " + value
				+ " Option from Source Filter Multi-Select Box");
		elements.waitForElementFluently( SourceFilterMultiSelectBox, 10);
		int i = 0;
		String[] textToSelect = value.split(",");
		int selectCount = textToSelect.length;
		Actions act = new Actions(driver);
		for (WebElement options : elements.getElementListWithIdentification(SourceFilterList)) {
			if (options.getText().equalsIgnoreCase(textToSelect[i].trim())) {
				act.keyDown(Keys.CONTROL).build().perform();
				elements.buttonClick(options);
				i++;
				if (selectCount == i)
					break;
			}
		}
		act.keyUp(Keys.CONTROL);
	}

	public void selectOptionsbyNumberFromSourceFilterMultiSelectBox(
			String numbers) {
		logger.info("Selecting Option " + numbers
				+ " from Source Filter Multi-Select Box");
		elements.waitForElementFluently( SourceFilterMultiSelectBox, 10);
		int i = 0;
		int j = 0;
		String[] optionToSelect = numbers.split(",");
		int selectCount = optionToSelect.length;
		Actions act = new Actions(driver);
		for (WebElement options : elements.getElementListWithIdentification(SourceFilterList)) {
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

	public void selectAllOptionsFromSourceFilterMultiSelectBox() {
		logger.info("Selecting All Options from Source Filter Multi-Select Box");
		elements.waitForPageLoaded();
		elements.waitForElementFluently( SourceFilterMultiSelectBox, 30);
		Actions act = new Actions(driver);
		for (WebElement options : elements.getElementListWithIdentification(SourceFilterList)) {
			act.keyDown(Keys.CONTROL).build().perform();
			elements.buttonClick(options);
			elements.waitForPageLoaded();
		}
		act.keyUp(Keys.CONTROL);
	}

	public void selectAllOptionsFromSourceFilterMultiSelectBox1() {
		logger.info("Selecting All Options from Source Filter Multi-Select Box");
		elements.waitForElementFluently( SourceFilterMultiSelectBox, 10);
		Actions act = new Actions(driver);
		for (int i = 1; i < elements.getElementListWithIdentification(SourceFilterList).size(); i++) {
			act.keyDown(Keys.CONTROL).build().perform();
			elements.buttonClick(elements.getElementListWithIdentification(SourceFilterList).get(i));
		}
		act.keyUp(Keys.CONTROL);
	}

	/*
	 * public String getOptionsbyNumberFromSourceFilterMultiSelectBox( String
	 * numbers) { logger.info("Getting Text of Option " + numbers +
	 * " from Source Filter Multi-Select Box");
	 * elements.waitForElementFluently( SourceFilterMultiSelectBox, 10);
	 * int i = 0; int j = 0; String result = null; String[] optionToSelect =
	 * numbers.split(","); int selectCount = optionToSelect.length; for
	 * (WebElement options : SourceFilterList) { if (j ==
	 * Integer.parseInt(optionToSelect[i].trim())) { result = options.getText();
	 * i++; if (selectCount == i) break; } j++; } return result; }
	 */

	public boolean isResultforSingleSourceSelectionCorrect(String value) {
		logger.info("Checking if the result after selecting " + value
				+ " from Source Filter is correct");
		elements.waitForPageLoaded();
		elements.waitForElementFluently( CaseNotesEntryResultTable, 30);
		boolean result = false;
		for (WebElement options : elements.getElementListWithIdentification(CaseNotesEntryResults)) {
			String text = options.findElement(By.xpath("./td[8]")).getText();
			if (!text.equals("")) {
				String text1 = text.substring(0, text.indexOf("(")).trim();
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

	public boolean isResultforDoubleSourceSelectionCorrect(String value,
			String value1) {
		logger.info("Checking if the result after selecting " + value + " and "
				+ value1 + " from Source Filter is correct");
		elements.waitForPageLoaded();
		elements.waitForElementFluently( CaseNotesEntryResultTable, 30);
		boolean result = false;
		for (WebElement options : elements.getElementListWithIdentification(CaseNotesEntryResults)) {
			String text = options.findElement(By.xpath("./td[8]")).getText();
			if (!text.equals("")) {
				String text1 = text.substring(0, text.indexOf("(")).trim();
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

	public boolean isResultforTripleSourceSelectionCorrect(String value,
			String value1, String value2) {
		logger.info("Checking if the result after selecting " + value + ", "
				+ value1 + " and " + value2 + " from Source Filter is correct");
		elements.waitForPageLoaded();
		elements.waitForElementFluently( CaseNotesEntryResultTable, 30);
		boolean result = false;
		for (WebElement options : elements.getElementListWithIdentification(CaseNotesEntryResults)) {
			String text = options.findElement(By.xpath("./td[8]")).getText();
			if (!text.equals("")) {
				String text1 = text.substring(0, text.indexOf("(")).trim();
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

	public boolean isResultforMultipleSourceSelectionCorrect(String value,
			String value1, String value2, String value3) {
		logger.info("Checking if the result after selecting " + value + ", "
				+ value1 + ", " + value1 + " and " + value1
				+ " from Source Filter is correct");
		elements.waitForPageLoaded();
		elements.waitForElementFluently( CaseNotesEntryResultTable, 30);
		boolean result = false;
		for (WebElement options : elements.getElementListWithIdentification(CaseNotesEntryResults)) {
			String text = options.findElement(By.xpath("./td[8]")).getText();
			if (!text.equals("")) {
				String text1 = text.substring(0, text.indexOf("(")).trim();
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

	public boolean isResultforAllSourceSelectionCorrect() {
		logger.info("Checking if the result after selecting all options from Source Filter is correct");
		elements.waitForPageLoaded();
		elements.waitForElementFluently( CaseNotesEntryResultTable, 30);
		boolean result = false;
		for (WebElement options : elements.getElementListWithIdentification(CaseNotesEntryResults)) {
			String text = options.findElement(By.xpath("./td[8]")).getText();
			if (!text.equals(""))
				result = true;
			else
				result = false;
		}
		return result;
	}

	public boolean isSourceOrganizationSelectedIndicatorDisplayed() {
		logger.info("Checking if 'Source Organization' is Displayed in Active Filter section");
		elements.waitForElementFluently( FilterByForm, 10);
		return elements.isElementPresent(
				SourceOrganizationSelectedIndicator);
	}

	public int getNumberofRecordsforSourceOrganizationSelection() {
		logger.info("Getting the Number of Records in the Result Table");
		elements.waitForElementFluently( CaseNotesEntryResultTable, 10);
		int records = elements.getElementListWithIdentification(CaseNotesEntryResults).size();
		return records;
	}

	public void clickonSourceOrganizationRemoveButton()
			throws InterruptedException {
		logger.info("Clicking on Remove Source Organisation Filter button");
		elements.waitForElementFluently( SourceOrganizationRemoveButton,
				30);
		elements.buttonClick(SourceOrganizationRemoveButton);
	}

	public String getNumberofOptionsfromSourceOrganizationMultiSelectBox() {
		logger.info("Getting the number of options in the Source Organization Multi-Select Box");
		elements.waitForElementFluently(
				SourceOrganizationMultiSelectBox, 10);
		int number = elements.getElementListWithIdentification(SourceOrganizationList).size() - 1;
		return String.valueOf(number);
	}

	public String[] storeTextofOptionsfromSourceOrganizationMultiSelectBox() {
		logger.info("Storing the Text of all the Options from Source Organization Multi-Select Box in String Array");
		elements.waitForPageLoaded();
		elements.waitForElementFluently(
				SourceOrganizationMultiSelectBox, 30);
		String[] result = new String[elements.getElementListWithIdentification(SourceOrganizationList).size()];
		for (int i = 0; i < elements.getElementListWithIdentification(SourceOrganizationList).size(); i++) {
			result[i] = elements.getElementListWithIdentification(SourceOrganizationList).get(i).getText();
		}
		return result;
	}

	public void selectOptionsbyTextFromSourceOrganizationMultiSelectBox(
			String value) {
		logger.info("Selecting " + value
				+ " Option from Source Organization Filter Multi-Select Box");
		elements.waitForElementFluently(
				SourceOrganizationMultiSelectBox, 30);
		int i = 0;
		String[] textToSelect = value.split(",");
		int selectCount = textToSelect.length;
		Actions act = new Actions(driver);
		for (WebElement options : elements.getElementListWithIdentification(SourceOrganizationList)) {
			if (options.getText().equalsIgnoreCase(textToSelect[i].trim())) {
				if (Initialization.browserName.equals("ios-ipad")) {
					elements.buttonClick(options);
				} else {
					act.keyDown(Keys.CONTROL).build().perform();
					elements.buttonClick(options);
				}
				i++;
				if (selectCount == i)
					break;
			}
		}
		act.keyUp(Keys.CONTROL);
	}

	public void selectOptionsbyNumberFromSourceOrganizationMultiSelectBox(
			String numbers) {
		logger.info("Selecting Option " + numbers
				+ " from Source Organization Filter Multi-Select Box");
		elements.waitForElementFluently(
				SourceOrganizationMultiSelectBox, 10);
		int i = 0;
		int j = 0;
		String[] optionToSelect = numbers.split(",");
		int selectCount = optionToSelect.length;
		Actions act = new Actions(driver);
		for (WebElement options : elements.getElementListWithIdentification(SourceOrganizationList)) {
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

	public void selectAllOptionsFromSourceOrganizationMultiSelectBox() {
		logger.info("Selecting All Options from Source Organization Filter Multi-Select Box");
		elements.waitForElementFluently(
				SourceOrganizationMultiSelectBox, 10);
		Actions act = new Actions(driver);
		for (WebElement options : elements.getElementListWithIdentification(SourceOrganizationList)) {
			act.keyDown(Keys.CONTROL).build().perform();
			elements.buttonClick(options);
			elements.waitForPageLoaded();
		}
		act.keyUp(Keys.CONTROL);
	}

	public void selectAllOptionsFromSourceOrganizationMultiSelectBox1() {
		logger.info("Selecting All Options from Source Organization Filter Multi-Select Box");
		elements.waitForElementFluently(
				SourceOrganizationMultiSelectBox, 10);
		Actions act = new Actions(driver);
		for (int i = 1; i < elements.getElementListWithIdentification(SourceOrganizationList).size(); i++) {
			act.keyDown(Keys.CONTROL).build().perform();
			elements.buttonClick(elements.getElementListWithIdentification(SourceOrganizationList).get(i));
		}
		act.keyUp(Keys.CONTROL);
	}

	/*
	 * public String getOptionsbyNumberFromSourceFilterMultiSelectBox( String
	 * numbers) { logger.info("Getting Text of Option " + numbers +
	 * " from Source Filter Multi-Select Box");
	 * elements.waitForElementFluently( SourceFilterMultiSelectBox, 10);
	 * int i = 0; int j = 0; String result = null; String[] optionToSelect =
	 * numbers.split(","); int selectCount = optionToSelect.length; for
	 * (WebElement options : SourceFilterList) { if (j ==
	 * Integer.parseInt(optionToSelect[i].trim())) { result = options.getText();
	 * i++; if (selectCount == i) break; } j++; } return result; }
	 */

	public boolean isResultforSingleSourceOrganizationSelectionCorrect(
			String value) {
		logger.info("Checking if the result after selecting " + value
				+ " from Source Organization Filter is correct");
		elements.waitForPageLoaded();
		elements.waitForElementFluently( CaseNotesEntryResultTable, 30);
		boolean result = false;
		for (WebElement options : elements.getElementListWithIdentification(CaseNotesEntryResults)) {
			String text = options.findElement(By.xpath("./td[8]")).getText();
			if (!text.equals("")) {
				String text1 = text.substring(text.indexOf("(") + 1,
						text.indexOf(")")).trim();
				System.out.println(text1);
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

	public boolean isResultforDoubleSourceOrganizationSelectionCorrect(
			String value, String value1) {
		logger.info("Checking if the result after selecting " + value + " and "
				+ value1 + " from Source Organization Filter is correct");
		elements.waitForPageLoaded();
		elements.waitForElementFluently( CaseNotesEntryResultTable, 30);
		boolean result = false;
		for (WebElement options : elements.getElementListWithIdentification(CaseNotesEntryResults)) {
			String text = options.findElement(By.xpath("./td[8]")).getText();
			if (!text.equals("")) {
				String text1 = text.substring(text.indexOf("(") + 1,
						text.indexOf(")")).trim();
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

	public boolean isResultforTripleSourceOrganizationSelectionCorrect(
			String value, String value1, String value2) {
		logger.info("Checking if the result after selecting " + value + ", "
				+ value1 + " and " + value2 + " from Source Filter is correct");
		elements.waitForPageLoaded();
		elements.waitForElementFluently( CaseNotesEntryResultTable, 30);
		boolean result = false;
		for (WebElement options : elements.getElementListWithIdentification(CaseNotesEntryResults)) {
			String text = options.findElement(By.xpath("./td[8]")).getText();
			if (!text.equals("")) {
				String text1 = text.substring(text.indexOf("(") + 1,
						text.indexOf(")")).trim();
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

	public boolean isResultforMultipleSourceOrganizationSelectionCorrect(
			String value, String value1, String value2, String value3) {
		logger.info("Checking if the result after selecting " + value + ", "
				+ value1 + ", " + value1 + " and " + value1
				+ " from Source Filter is correct");
		elements.waitForPageLoaded();
		elements.waitForElementFluently( CaseNotesEntryResultTable, 30);
		boolean result = false;
		for (WebElement options : elements.getElementListWithIdentification(CaseNotesEntryResults)) {
			String text = options.findElement(By.xpath("./td[8]")).getText();
			if (!text.equals("")) {
				String text1 = text.substring(text.indexOf("(") + 1,
						text.indexOf(")")).trim();
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

	public boolean isResultforAllSourceOrganizationSelectionCorrect() {
		logger.info("Checking if the result after selecting all options from Source Filter is correct");
		elements.waitForPageLoaded();
		elements.waitForElementFluently( CaseNotesEntryResultTable, 30);
		boolean result = false;
		for (WebElement options : elements.getElementListWithIdentification(CaseNotesEntryResults)) {
			String text = options.findElement(By.xpath("./td[8]")).getText();
			if (!text.equals(""))
				result = true;
			else
				result = false;
		}
		return result;
	}

	public Boolean isCaseNotesPageLoaded() {
		elements.waitForElementFluently( caseNotesResultsTable, 15);
		return elements.isDisplayed(caseNotesResultsTable);
	}
}

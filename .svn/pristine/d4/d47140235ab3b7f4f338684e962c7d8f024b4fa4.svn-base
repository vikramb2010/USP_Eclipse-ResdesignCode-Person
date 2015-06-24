package com.uspeclipse.pageobjects.casenotes;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.remote.server.handler.FindElements;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.uspeclipse.commonservices.GenericActions;
import com.uspeclipse.commonservices.MultipleBrowser;
import com.uspeclipse.pageobjects.home.Home_pageobjects;
import com.uspeclipse.pageobjects.person.AddPerson_pageobject;
import com.uspeclipse.setup.LoggerHelper;

public class AddCaseNote_pageobject {


	private WebDriver driver;
	Home_pageobjects homepageobject = null;
	AddPerson_pageobject addpersonpageobject = null;
	private static Logger logger = Logger
			.getLogger(AddEntryPerson_pageobject.class);
	GenericActions elements = null;

	public AddCaseNote_pageobject(WebDriver driver) {
		this.driver = driver;
		this.homepageobject = PageFactory.initElements(
				driver,Home_pageobjects.class);
		this.addpersonpageobject = PageFactory.initElements(
				driver,AddPerson_pageobject.class);
	elements = new GenericActions(driver);

	}

	public final By EntryDateColTableHeader = By.xpath("//th[@title='Sort by Entry date']");	
	public final By AddButton=By.xpath ("//span[contains(text(),'Add')]");
	//By.xpath ("//a[contains(text(),'Select current date')]");
	public final By SelectCurrentDateTime=By.xpath ("//a[@class='currentDate small']");
	//By.xpath ("//a[contains(text(),'Select current date and time')]");
	public final By SelectCurrentDate=By.xpath ("//a[@class='currentDateTime small']");
	public final By SelectYear=By.xpath ("//input[@id='fuzzyEventDateYEAR']");
	public final By SelectMonth=By.xpath ("//select[@id='fuzzyEventDateMONTH']");
	public final By SelectDay=By.xpath ("//select[@id='fuzzyEventDateDAY']");
	public final By SelectHour=By.xpath ("//select[@id='fuzzyEventDateHOUR']");
	public final By SelectMinute=By.xpath ("//select[@id='fuzzyEventDateMINUTE']");
	public final By AddSelectYear=	By.xpath ("//form[@id='caseNoteEntryEditForm']//input[@id='fuzzyEventDateYEAR']");
	public final By AddSelectMonth=By.xpath ("//form[@id='caseNoteEntryEditForm']//select[@id='fuzzyEventDateMONTH']");
	public final By AddSelectDay=		By.xpath ("//form[@id='caseNoteEntryEditForm']//select[@id='fuzzyEventDateDAY']");
	public final By AddSelectHour=	By.xpath ("//form[@id='caseNoteEntryEditForm']//select[@id='fuzzyEventDateHOUR']");
	public final By AddSelectMinute=	By.xpath ("//form[@id='caseNoteEntryEditForm']//select[@id='fuzzyEventDateMINUTE']");
	public final By EntryText=	By.xpath ("//div[starts-with(@id,'caseNoteEntry') and @role='textbox']");
	public final By DisabledEntryText=	By.xpath("//div[@class='value richTextInput']");
	public final By DisabledEntryDate=	By.xpath("//div[@class='value eventDateValue']");
	public final By EntryTextImage=	By.xpath ("//a[@title='Upload an image']");
	public final By EntryTextChooseFile=	By.xpath ("//input[@id='upload_image']");
	public final By EntryType=		By.xpath ("//select[@id='caseNoteEntryAddForm_entryType']");
	public final By EditPageEntryType=	By.xpath ("//select[@id='caseNoteEntryEditForm_entryType']");
	public final By DisabledEntryType=	By.xpath ("//div[@class='value']");
	public final By PersonIcon=	By.xpath ("//ul[@id='popup-menu']//li[1]");
	public final By QuestionIcon=		By.xpath ("//a[@data-content='Impact: Unknown']");
	public final By ImpactIcon=	By.xpath ("//ul[@id='popup-menu']//li//a[@data-content='Impact: Unknown']");
	public final By EditdateIcon=	By.xpath ("//a[@class='dates pop-over']");
	public final By EditedDate=	By.xpath ("//input[@name='editedDate']");
	public final By ImpactIconNegative=	By.xpath ("//ul[@id='popup-menu']//li[@data-content='Impact: Negative']");
	public final By ImpactNegative=	By.xpath ("//input[@id='caseNoteEntryEditForm_impactNegative']");
	//By.xpath ("//button//i[@class='icon-ok-sign']");
	public final By CompleteButton=	By.xpath ("//button[@class='yui3-button pure-button-active']");
	public final By SaveButton=	By.xpath ("//button[contains(text(),'Save')]//i[@class='icon-ok']");
	public final By CompleteEntryNo=	By.xpath ("//button[contains(text(),'No')]//i[@class='icon-remove']");
	public final By CompleteEntryYes=	By.xpath ("//button[contains(text(),'Yes')]//i[@class='icon-ok']");
	public final By CompleteEntryMessage=	By.xpath ("//h3[contains(text(),'Complete entry')]//..//..//div//div//div//div//div//h4[contains(text(),'Completing a Case Note entry will stop any further edits to the Case Note entry field. Are you sure you want to complete this entry?')]");
	public final By CompleteCancel=	By.xpath ("//h3[contains(text(),'Add entry')]//..//..//button[contains(text(),'Cancel')]");
	public final By EditEntryCancel=	By.xpath ("//h3[contains(text(),'Edit entry')]//..//..//button[contains(text(),'Cancel')]");
	public final By ViewEntryCancel=	By.xpath ("//h3[contains(text(),'View entry')]//..//..//button[contains(text(),'Cancel')]");
	public final By EditEntrySave=	By.xpath ("//h3[contains(text(),'Edit entry')]//..//..//button[contains(text(),'Save')]");
	public final By ViewEntryEdit=	By.xpath ("//h3[contains(text(),'View entry')]//..//..//button[contains(text(),'Edit')]");
	public final By CompleteStatus=	By.xpath ("//td[@data-title='Status']//i[@class='icon-state icon-state-complete']");
	public final By DraftStatus=	By.xpath ("//td[@data-title='Status']//i[@class='icon-state icon-state-draft']");
	public final By DraftSelect=	By.xpath ("//td[@data-title='Status']//i[@class='icon-state icon-state-draft']//..//..//td//span//ul//li//a[contains(text(),'select')]");
	public final By DraftCaseNoteName=	By.xpath ("//td[@data-title='Status']//i[@class='icon-state icon-state-draft']//..//..//td[@data-title='Entry']");
	public final By DraftEditThisEntry=	By.xpath ("//td[@data-title='Status']//i[@class='icon-state icon-state-draft']//..//..//td//span//ul//li//ul//li//a[@title='Edit case note entry']");	
	public final By DraftViewThisEntry=	By.xpath ("//td[@data-title='Status']//i[@class='icon-state icon-state-draft']//..//..//td//span//ul//li//ul//li//a[@title='View case note entry']");
	public final By DraftCompleteThisEntry=	By.xpath ("//td[@data-title='Status']//i[@class='icon-state icon-state-draft']//..//..//td//span//ul//li//ul//li//a[@title='Complete case note entry']");	
	public final By CompleteSelect=	By.xpath ("//td[@data-title='Status']//i[@class='icon-state icon-state-complete']//..//..//td//span//ul//li//a[contains(text(),'select')]");
	public final By CompleteCaseNoteName=	By.xpath ("//td[@data-title='Status']//i[@class='icon-state icon-state-complete']//..//..//td[@data-title='Entry']");
	public final By CompleteCaseNoteDate=	By.xpath ("//td[@data-title='Status']//i[@class='icon-state icon-state-complete']//..//..//td[@data-title='Entry date']");
	public final By CompleteCaseNoteImpactnegative=	By.xpath ("//td[@data-title='Status']//i[@class='icon-state icon-state-complete']//..//..//td[@data-title='Impact']//i[@class='icon-minus impact-negative']");
	public final By CompleteEditThisEntry=	By.xpath ("//td[@data-title='Status']//i[@class='icon-state icon-state-complete']//..//..//td//span//ul//li//ul//li//a[@title='Edit case note entry']");	
	public final By CompleteDeleteThisEntry=	By.xpath ("//td[@data-title='Status']//i[@class='icon-state icon-state-complete']//..//..//td//span//ul//li//ul//li//a[@title='Delete case note entry']");	
	public final By CompleteViewThisEntry=	By.xpath ("//td[@data-title='Status']//i[@class='icon-state icon-state-complete']//..//..//td//span//ul//li//ul//li//a[@title='View case note entry']");
	public final By CompleteCompleteThisEntry=	By.xpath ("//td[@data-title='Status']//i[@class='icon-state icon-state-complete']//..//..//td//span//ul//li//ul//li//a[@title='Complete case note entry']");	
	public final By EditEntryHeading=	By.xpath ("//h3[contains(text(),'Edit entry')]");
	public final By CompleteEntryHeading=	By.xpath ("//h3[contains(text(),'Complete entry')]");
	public final By ViewEntryHeading=	By.xpath ("//h3[contains(text(),'View entry')]");
	//By.xpath ("//h3[contains(text(),'Complete entry')]//..//..//button[contains(text(),'Yes')]");
	//By.xpath ("//h3[contains(text(),'Complete entry')]//..//..//button[contains(text(),'Yes')]");
	public final By CompleteEntryPageYes=	By.xpath ("//h3[contains(text(),'Complete entry')]//..//..//button[contains(text(),'Yes')]");
	//By.xpath="//button[@class='yui3-button pure-button-primary'][contains(text(),'Yes')]");
	public final By DeleteYes=	By.xpath ("//h3[contains(text(),'Delete entry')]//..//..//button[contains(text(),'Yes')]");
	public final By DeleteThisEntry=	By.xpath ("//td[@data-title='Status']//i[@class='icon-state icon-state-complete']//..//..//td//span//ul//li//ul//li//a[@title='Delete case note entry']");
	public final By ActiveFilters=	By.xpath ("//span[contains(text(),'Active filters')]");
	public final By SourceFilterSelectedIndicator=	By.xpath ("//div[@id='caseNoteFilterContext']//span[contains(text(),'Source')]");
	public final By ResetAllFiltersLink=	By.xpath ("//div[@id='caseNoteFilterContext']//a[contains(text(),'Reset all')]");
	public final By SourceFilterRemoveButton=	By.xpath ("//div[@id='caseNoteFilterContext']//span[contains(text(),'Source')]//a[@class='removeSource']");
	public final By CaseNotesEntryResults=	 By.xpath ("//div[@id='generalCaseNoteEntryResults']/div/div/table/tbody[2]/tr"); 
	public final By CaseNotesEntryResultTable=	By.xpath ("//table[@class='pure-table-table']");
	public final By FilterResetLink= By.id ("caseNoteEntryFilter_clearPeople");
	public final By ImpactUnknown=  By.id ("caseNoteEntryEditForm_impactUnknown");
	public final By PersonSource=By.id ("entryForm_source");
	public final By logout=By.xpath("//button[contains(text(),'Log out')]");
	
	
	//input[@id='caseNoteEntryEditForm_impactUnknown']
	public void clickonAddCaseNoteButton() throws InterruptedException {
		logger.info("Clicking on Add Case Note Button");
		elements.waitForElementFluently(
				homepageobject.HomeLink, 15);
		elements.buttonClick(AddButton);
	}
	
	public void clickonAddCaseNoteButton2() throws InterruptedException {
		//logger.info("Clicking on Add Case Note Button");
		elements.waitForElementFluently(
				logout, 15);
		elements.buttonClick(AddButton);
	}
	
	public void clickonCasenoteLink() {
		logger.info("Clicking on Case Note Link from Menu");
		elements.waitForElementFluently( logout,
				10);
		elements.buttonClick(homepageobject.CasenoteLink);
	}
	
	public void clickonSelectCurrentDateTime(String year,String month,String day) throws InterruptedException {
		//logger.info("Clicking on Select current date and time link");
		elements.waitForElementFluently(	SelectYear, 15);
		//elements.buttonClick(SelectCurrentDateTime);
		
//logger.info("Selecting date in Case Note Form");
		
		elements.inputValue(SelectYear, year);
		//logger.info("Year filled");
		
		elements.selectDropdown(SelectMonth, month);
		//logger.info("Month filled");
		
		elements.selectDropdown(SelectDay, day);
		//logger.info("Day filled");
		
	}

	public void enterEntryText(String value) {
		//logger.info("Enter " + value + " in Entry Text");
	
		
		//if ((!Initialization.browserName.equals("ios-ipad")) && (!Initialization.browserName.equals("androidE")) )
		//{
			//elements.waitForElementFluently(	homepageobject.HomeLink, 30);
		//}
		elements.waitForElementFluently( homepageobject.HomeSearchPersonGlobalTextbox, 5);
		//elements.inputValue(EntryText," ");
		//elements.buttonClick(EntryTextImage);
		
		elements.inputValue(EntryText, value);

	}
	public void selectEntryType(String value) {
		//logger.info("Selecting " + value+ " from Entry Type on Case Note Form");
		elements.waitForElementFluently( EntryType,
				10);
		elements.selectDropdown(EntryType, value);
	}
	
	public String selectDate(String year,String month,String day,String hour,String minute) {
		//logger.info("Selecting date in Case Note Form");
		
		elements.inputValue(SelectYear, year);
		//logger.info("Year filled");
		
		elements.selectDropdown(SelectMonth, month);
		//logger.info("Month filled");
		
		elements.selectDropdown(SelectDay, day);
		//logger.info("Day filled");
		
		if(hour!="")
			elements.selectDropdown(SelectHour, hour);
		
		if(minute!="")
			elements.selectDropdown(SelectMinute, minute);
		
		return "Date Updated";
		
	}
	
	public void selectImpact(String impact)
	{
		//logger.info("Selecting Impact Case Note Form");
		
		elements.buttonClick(ImpactIcon);
		
		if(impact.contains("Negative"))
		{
			elements.buttonClick(ImpactIcon);
			logger.info("Impact Negative selected");
			elements.buttonClick(ImpactNegative);
		}
		
	}

	public void clickonPersonIcon() throws InterruptedException {
		//logger.info("Clicking on Person Icon");
		elements.waitForElementFluently(
				homepageobject.HomeLink, 15);
		elements.buttonClick(PersonIcon);
	}
	public void clickonQuestionIcon() throws InterruptedException {
		//logger.info("Clicking on Question Icon");
		elements.waitForElementFluently(
				homepageobject.HomeLink, 15);
		elements.buttonClick(QuestionIcon);
	}
	
	public void clickonCompleteButton() throws InterruptedException {
		//logger.info("Clicking on Complete Button");
		
		elements.buttonClick(CompleteButton);
	}
	public void clickonSaveButton() throws InterruptedException {
		//logger.info("Clicking on Complete Button");
		elements.waitForElementFluently(
				homepageobject.HomeLink, 15);
		elements.buttonClick(SaveButton);
	}
	public void clickonCompleteEntryNoButton() throws InterruptedException {
		logger.info("Clicking on No in Completing Entry");
		elements.waitForElementFluently(
				homepageobject.HomeLink, 15);
		if(elements.isDisplayed(CompleteEntryMessage)==true)
			logger.info("Complete message displayed");
		else	
			logger.info("Complete message not displayed");
		elements.buttonClick(CompleteEntryNo);
	}
	public boolean clickonCompleteEntryYesButton() throws InterruptedException {
		//logger.info("Clicking on Yes in Completing Entry");
		boolean result;
		elements.waitForElementFluently(
				homepageobject.HomeLink, 15);
		if(elements.isDisplayed(CompleteEntryMessage)==true)
			result=true;
		else	
			result=false;
			//logger.info("Complete message not displayed");
		//elements.buttonClick(CompleteEntryNo);
		
		elements.buttonClick(CompleteEntryYes);
		return result;
	}
	
	public void clickonCompleteCancelButton() throws InterruptedException {
		logger.info("Clicking on Cancel button");
		elements.waitForElementFluently(
				homepageobject.HomeLink, 15);
		elements.buttonClick(CompleteCancel);		
	}
	
	public void clickonEditEntryCancelButton() throws InterruptedException {
		logger.info("Clicking on Cancel button");
		elements.waitForElementFluently(homepageobject.HomeLink, 15);
		elements.buttonClick(EditEntryCancel);		
	}
	
	public void clickonViewEntryCancelButton() throws InterruptedException {
		logger.info("Clicking on Cancel button");
		elements.waitForElementFluently(homepageobject.HomeLink, 15);
		elements.buttonClick(ViewEntryCancel);		
	}
	
	public void clickonEditEntrySaveButton() throws InterruptedException {
		//logger.info("Clicking on Save button");
		elements.waitForElementFluently(homepageobject.HomeLink, 15);
		elements.buttonClick(EditEntrySave);
		
	}
	
	public void isDisplayedCompleteStatus() throws InterruptedException {
			//logger.info("Result table shows complete icon");
			elements.waitForElementFluently(logout, 30);	
			elements.isDisplayed(CompleteStatus);	
	}
		
	public void clickonEditThisEntry() throws InterruptedException {
			logger.info("Clicking on Edit this entry from select Menu");
			
			elements.buttonClick(DraftSelect);
			Thread.sleep(2000);
			elements.buttonClick(DraftEditThisEntry);
	}	
	
	public void clickonCompleteEditThisEntry() throws InterruptedException {
		//logger.info("Clicking on Edit this entry from select Menu");
		elements.waitForElementFluently(CompleteSelect, 15);
		elements.buttonClick(CompleteSelect);
		elements.waitForElementFluently(CompleteEditThisEntry, 15);
		
		elements.buttonClick(CompleteEditThisEntry);
}	
	public void clickonCompleteDeleteThisEntry() throws InterruptedException {
		logger.info("Clicking on Delete this entry from select Menu");
		elements.waitForElementFluently(CompleteSelect, 15);
		elements.buttonClick(CompleteSelect);
		
		elements.buttonClick(CompleteDeleteThisEntry);
		
		elements.buttonClick(DeleteYes);
		elements.waitForElementFluently(logout, 15);
		
		
		
}	

	
	public void clickonCompleteViewThisEntry() throws InterruptedException {
		//logger.info("Clicking on View this entry from select Menu");
		elements.waitForElementFluently(CompleteSelect, 15);
		elements.buttonClick(CompleteSelect);
		Thread.sleep(2000);
		elements.buttonClick(CompleteViewThisEntry);
}	
	
	public void clickonCompleteThisEntry() throws InterruptedException {
		logger.info("Clicking on Complete this entry from select Menu");
		elements.waitForElementFluently(DraftSelect, 15);
		elements.buttonClick(DraftSelect);
		Thread.sleep(2000);
		elements.buttonClick(DraftCompleteThisEntry);
}
	
	public void isDisplayedCompleteEntryScreen() throws InterruptedException {
		logger.info("Complete Entry Screen Opens");		
		
		if(elements.isDisplayed(CompleteEntryHeading)==true)
			logger.info("Compelte entry Heading is displayed");
	}
	
	
	public boolean isDisplayedEditEntryScreen() throws InterruptedException {
		//logger.info("Edit Entry Screen Opens");		
		elements.waitForElementFluently(EditEntryHeading, 15);
		boolean result=false;
		if(elements.isDisplayed(EditEntryHeading)==true)
			result =true;
			
		//check if date field is active		
		return result;
	}
	
	public boolean isActiveEditEntryScreen(String objectname) throws InterruptedException {
		
		boolean result=false;
		if(objectname=="SelectCurrentDateTime")
		{
		if(elements.isEnabled(SelectCurrentDateTime)==true)
			result=true;
					

		}
		if(objectname=="Impact")
		{
			elements.buttonClick(QuestionIcon);
		
			
			if(elements.isEnabled(ImpactUnknown)==true)
			result=true;
		
			//logger.info("Impact Field is active");
				//entry field is inactive
		}
		if(objectname=="EntryText")
		{
			if(elements.isElementPresent(DisabledEntryText)==true)
			{
				result=true;
			//logger.info("Entry field is inactive");
			}
		}
		if(objectname=="EntryType")
		{
			if(elements.isElementPresent(DisabledEntryType)==true)
				result=true;
		}
	
		if(objectname=="PersonIcon")
		{
		if(elements.isEnabled(PersonIcon)==true)
		{
			elements.buttonClick(PersonIcon);
		
			if(elements.isEnabled(PersonSource)==false)
				result=true;
			//logger.info("Person field is inactive");
		}
		}
		
		return result;
}
	
	public boolean isDisplayedViewEntryScreen() throws InterruptedException {
		//logger.info("View Entry Screen Opens");
		elements.waitForElementFluently(
				homepageobject.HomeLink, 15);
		elements.isDisplayed(ViewEntryHeading);
		return true;
}

	public void clickonCompleteEntryPageYesButton() throws InterruptedException {
		logger.info("Clicking on Yes button");
		elements.waitForElementFluently(
				homepageobject.HomeLink, 30);
		elements.buttonClick(CompleteEntryPageYes);		
	}

	public void clickonViewEntryPageEditButton() throws InterruptedException {
		logger.info("Clicking on Edit button");
		elements.waitForElementFluently(
				homepageobject.HomeLink, 15);
		elements.buttonClick(ViewEntryEdit);		
	}
	
	public void clickonEditThisEntryComplete() throws InterruptedException {
		logger.info("Clicking on Edit this entry from select Menu");
		
		elements.buttonClick(CompleteSelect);
		
		elements.buttonClick(CompleteEditThisEntry);
}	
	public void checkEntryUpdated(String CaseNoteName) throws InterruptedException {
		
		
		if(elements.getText(DraftCaseNoteName)==CaseNoteName)
			logger.info("Case Note Entry not changed");
		else	
			logger.info("Case Note Entry changed");
		
	}
public void checkCompleteEntryUpdated(String CaseNoteName) throws InterruptedException {
		
	logger.info("Case Note name updated");
		if(elements.getText(CompleteCaseNoteName).contains(CaseNoteName))
			logger.info("Case Note Entry not changed");
		else	
			logger.info("Case Note Entry changed to"+elements.getText(CompleteCaseNoteName));
		
	}

public boolean checkCompleteDateNotUpdated(String year,String month,String day) throws InterruptedException {
	
	boolean result=false;
	String[] displaydate=elements.getText(CompleteCaseNoteDate).split("-");
	if((displaydate[0].contains(day))&& (displaydate[1].contains(month))&&(displaydate[2].contains(year)))
	{		
	
		result=true;
		//logger.info("Case Note Date updated");
	}
	else
	{
		result=false;
		//logger.info("Case Note Date not updated.Year:"+displaydate[2]+",Month:"+displaydate[1]+",Day:"+displaydate[0]);
	}
	return result;
	
}
public boolean checkCompleteImpactNotUpdated() throws InterruptedException {
	
	boolean result=false;
	
	
	if(elements.isElementPresent(CompleteCaseNoteImpactnegative))
	{		
		result=true;
		//logger.info("Case Note Impact updated");
	}
	else
	{
		result=false;
		//logger.info("Case Note Impact not updated");
	}
	return result;
	
}

public boolean checkCompleteViewImpactNotUpdated() throws InterruptedException {
	
	
	boolean result=false;
	
	if(elements.isElementPresent(ImpactIconNegative))
	{		
	
		result= true;
		//logger.info("Case Note Impact updated");
	}
	else
	{
		result= false;
		//logger.info("Case Note Impact not updated");
	}
	
	
	//Check edit date
	elements.buttonClick(EditdateIcon);
	
	if(elements.isDisplayed(EditedDate))
	{
		result=true;
		//logger.info("Edited date displayed:"+elements.getText(EditedDate));
	}
	return result;
}

public boolean checkCompleteViewDateNotUpdated(String year,String month,String day) throws InterruptedException {
	
	boolean result=true;
	String[] displaydate=elements.getText(DisabledEntryDate).split("-");	
	if((displaydate[0].contains(day))&& (displaydate[1].contains(month))&&(displaydate[2].contains(year)))
	{		
	
		result=true;
		//logger.info("Case Note Date updated");
	}
	else
	{
		result=false;
		//logger.info("Case Note Date not updated.Year:"+displaydate[2]+",Month:"+displaydate[1]+",Day:"+displaydate[1]);
	}
	return result;
	
}
public boolean checkCompleteDateTimeNotUpdated(String year,String month,String day,String hour,String min) throws InterruptedException {
	
	boolean result=false;
	elements.waitForElementFluently(
			CompleteSelect, 30);
	
	String[] displaydate=elements.getText(CompleteCaseNoteDate).split("-");
	String displayhour=displaydate[2].substring(5,7);
	String displaymin=displaydate[2].substring(8,10);
	displaydate[2]=displaydate[2].substring(0,4);
	if((displaydate[0].contains(day))&& (displaydate[1].contains(month))&&(displaydate[2].contains(year))&&(displayhour.contains(hour))&&(displaymin.contains(min)))
	{		
	
		//logger.info("Case Note Date updated");
		return true;
	}
	else
	{
		return false;
		//logger.info("Case Note Date not updated.Year:"+displaydate[2]+",Month:"+displaydate[1]+",Day:"+displaydate[0]+",Hour:"+displayhour+",Min:"+displaymin);
	}
	
}
public boolean checkCompleteViewDateTimeNotUpdated(String year,String month,String day,String hour,String min) throws InterruptedException {
	
	String[] displaydate=elements.getText(DisabledEntryDate).split("-");
	String displayhour=displaydate[2].substring(5,7);
	String displaymin=displaydate[2].substring(8,10);
	displaydate[2]=displaydate[2].substring(0,4);
	if((displaydate[0].contains(day))&& (displaydate[1].contains(month))&&(displaydate[2].contains(year))&&(displayhour.contains(hour))&&(displaymin.contains(min)))
	{		
	
		return true;
		//logger.info("Case Note Date updated");
	}
	else
	{
		return false;
		//logger.info("Case Note Date not updated.Year:"+displaydate[2]+",Month:"+displaydate[1]+",Day:"+displaydate[0]+",Hour:"+displayhour+",Min:"+displaymin);
	}
	
}




public void checkCompleteEntryNotUpdated(String CaseNoteName) throws InterruptedException {
	
	
	if(elements.getText(CompleteCaseNoteName).contains(CaseNoteName))
		logger.info("Case Note Entry not changed");
	else	
		logger.info("Case Note Entry changed");
	
}

	
	
	
/*	public boolean isColumnHeaderDisplayed(String value) {
		logger.info("Checking if " + value
				+ " Column Table Header is Displayed");
		boolean result = false;
		elements.waitForElementFluently(
				homepageobject.HomeLink, 10);
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
		elements.waitForElementFluently( FilterByForm,
				10);
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

	public void clickonPeopleTabinFilterBy() throws InterruptedException {
		logger.info("Clicking on People Tab in Filter By on Case Notes page");
		elements.waitForElementFluently(
				FilterByPeopleTab, 30);
		elements.buttonClick(FilterByPeopleTab);
	}

	public boolean isFilterIconinPeopleTabDisplayed() {
		logger.info("Checking if Filter Icon in Filter Tab is Displayed");
		elements.waitForElementFluently( FilterByForm,
				10);
		return elements.isDisplayed(FilterIconPeopelTab);
	}

	public boolean isSourceFilterSelectedIndicatorDisplayed() {
		logger.info("Checking if 'Source' is Displayed in Active Filter section");
		elements.waitForElementFluently( FilterByForm,
				10);
		return elements.isElementPresent(
				SourceFilterSelectedIndicator);
	}

	public boolean isResetAllFiltersLinkDisplayed() {
		logger.info("Checking if Reset All Link is Displayed in Active Filter section");
		elements.waitForElementFluently( ActiveFilters,
				10);
		return elements.isDisplayed(ResetAllFiltersLink);
	}

	public boolean isResultforSingleSourceSelectionCorrect(String value) {
		logger.info("Checking if the result after selecting " + value
				+ " from Source Filter is correct");
		elements.waitForElementFluently(
				CaseNotesEntryResultTable, 10);
		boolean result = false;
		for (WebElement options : CaseNotesEntryResults) {
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

	public void clickonSourceFilterRemoveButton() throws InterruptedException {
		logger.info("Clicking on Remove Source Filter button");
		elements.waitForElementFluently(
				SourceFilterRemoveButton, 30);
		elements.buttonClick(SourceFilterRemoveButton);
	}

	public int getNumberofRecordsforSourceFilterSelection() {
		logger.info("Getting the Number of Records in the Result Table");
		elements.waitForElementFluently(
				CaseNotesEntryResultTable, 10);
		int records = CaseNotesEntryResults.size();
		return records;
	}

	public String getNumberofOptionsfromSourceFilterMultiSelectBox() {
		logger.info("Getting the number of options in the Source Filter");
		elements.waitForElementFluently(
				SourceFilterMultiSelectBox, 10);
		int number = SourceFilterList.size() - 1;
		return String.valueOf(number);
	}

	public void selectOptionsbyTextFromSourceFilterMultiSelectBox(String value) {
		logger.info("Selecting " + value
				+ " Option from Source Filter Multi-Select Box");
		elements.waitForElementFluently(
				SourceFilterMultiSelectBox, 10);
		int i = 0;
		String[] textToSelect = value.split(",");
		int selectCount = textToSelect.length;
		Actions act = new Actions(driver);
		for (WebElement options : SourceFilterList) {
			if (options.getText().equalsIgnoreCase(textToSelect[i].trim())) {
				act.keyDown(Keys.CONTROL).click(options).build().perform();
				i++;
				if (selectCount == i)
					break;
			}
		}
		act.release();
	}

	public void selectOptionsbyNumberFromSourceFilterMultiSelectBox(
			String numbers) {
		logger.info("Selecting Option " + numbers
				+ " from Source Filter Multi-Select Box");
		elements.waitForElementFluently(
				SourceFilterMultiSelectBox, 10);
		int i = 0;
		int j = 0;
		String[] optionToSelect = numbers.split(",");
		int selectCount = optionToSelect.length;
		Actions act = new Actions(driver);
		for (WebElement options : SourceFilterList) {
			if (j == Integer.parseInt(optionToSelect[i].trim())) {
				act.keyDown(Keys.CONTROL).click(options).build().perform();
				i++;
				if (selectCount == i)
					break;
			}
			j++;
		}
		act.release();
	}

	public void selectAllOptionsFromSourceFilterMultiSelectBox() {
		logger.info("Selecting All Options from Source Filter Multi-Select Box");
		elements.waitForElementFluently(
				SourceFilterMultiSelectBox, 10);
		Actions act = new Actions(driver);
		for (WebElement options : SourceFilterList) {
			act.keyDown(Keys.CONTROL).click(options).build().perform();
		}
		act.release();
	}

	public String getOptionsbyNumberFromSourceFilterMultiSelectBox(
			String numbers) {
		logger.info("Getting Text of Option " + numbers
				+ " from Source Filter Multi-Select Box");
		elements.waitForElementFluently(
				SourceFilterMultiSelectBox, 10);
		int i = 0;
		int j = 0;
		String result = null;
		String[] optionToSelect = numbers.split(",");
		int selectCount = optionToSelect.length;
		for (WebElement options : SourceFilterList) {
			if (j == Integer.parseInt(optionToSelect[i].trim())) {
				result = options.getText();
				i++;
				if (selectCount == i)
					break;
			}
			j++;
		}
		return result;
	}

	public String[] storeTextofOptionsfromSourceFilterMultiSelectBox() {
		logger.info("Storing the Text of all the Options in String Array");
		elements.waitForElementFluently(
				SourceFilterMultiSelectBox, 10);
		String[] result = new String[SourceFilterList.size()];
		for (int i = 0; i < SourceFilterList.size(); i++) {
			result[i] = SourceFilterList.get(i).getText();
		}
		return result;
	}

	public void clickonFilterResetLink() {
		logger.info("Clicking on Filter Reset Link");
		elements.waitForElementFluently(
				FilterResetLink, 10);
		elements.buttonClick(FilterResetLink);
	}

	public boolean isResultforDoubleSourceSelectionCorrect(String value,
			String value1) {
		logger.info("Checking if the result after selecting " + value + " and "
				+ value1 + " from Source Filter is correct");
		elements.waitForElementFluently(
				CaseNotesEntryResultTable, 10);
		boolean result = false;
		for (WebElement options : CaseNotesEntryResults) {
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
		elements.waitForElementFluently(
				CaseNotesEntryResultTable, 10);
		boolean result = false;
		for (WebElement options : CaseNotesEntryResults) {
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
		elements.waitForElementFluently(
				CaseNotesEntryResultTable, 10);
		boolean result = false;
		for (WebElement options : CaseNotesEntryResults) {
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

	public void selectAllOptionsFromSourceFilterMultiSelectBox1() {
		logger.info("Selecting All Options from Source Filter Multi-Select Box");
		elements.waitForElementFluently(
				SourceFilterMultiSelectBox, 10);
		Actions act = new Actions(driver);
		for (int i = 1; i < SourceFilterList.size(); i++) {
			act.keyDown(Keys.CONTROL).click(SourceFilterList.get(i)).build()
					.perform();
		}
		act.release();
	}

	public boolean isResultforAllSourceSelectionCorrect() {
		logger.info("Checking if the result after selecting all options from Source Filter is correct");
		elements.waitForElementFluently(
				CaseNotesEntryResultTable, 10);
		boolean result = false;
		for (WebElement options : CaseNotesEntryResults) {
			String text = options.findElement(By.xpath("./td[8]")).getText();
			if (!text.equals(""))
				result = true;
			else
				result = false;
		}
		return result;
	}*/
}

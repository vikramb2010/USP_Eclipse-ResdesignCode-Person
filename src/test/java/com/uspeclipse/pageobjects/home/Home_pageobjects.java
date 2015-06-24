package com.uspeclipse.pageobjects.home;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uspeclipse.commonservices.GenericActions;
import com.uspeclipse.setup.Initialization;

public class Home_pageobjects {

	private WebDriver driver;

	private static Logger logger = Logger.getLogger(Home_pageobjects.class);
	GenericActions elements = null;

	public Home_pageobjects(WebDriver driver) {
		this.driver = driver;
		elements = new GenericActions(driver);
	}

	// Add Home Page Objects
	public final By  HomeRecentlyAccessedRecordLink = By.xpath("//td[2]/a");
	public final By  HomeSearchPersonGlobalTextbox=By.xpath("//input[@id='personSearch']");
	public final By  HomeSearchPersonGlobalButton=By.xpath("//a[@id='personSearchButton']");
	public final By  HomeYourcaseloadLink=By.xpath("//div[2]/div/div/div[2]/div/div/div/div/table/tbody[2]/tr/td/a");
	public final By  HomeAddpersonButton=By.id("addPersonButton");
	public final By  HomeLink=By.xpath("//div[@id='menu']//a[text()='Home']");
	public final By  PersonLink=By.xpath("//div[@id='menu']//a[text()='Person']");
	public final By  RelationshipLink=By.xpath("//div[@id='menu']//a[text()='Relationships']");
	public final By  GroupLink=By.xpath("//div[@id='menu']//a[text()='Groups']");
	public final By  ChronologyLink=By.xpath("//div[@id='menu']//a[text()='Chronology']");
	public final By  CasenoteLink=By.xpath("//div[@id='menu']//a[text()='Case Notes']");
	public final By  ClassificationLink=By.xpath("//div[@id='menu']//a[text()='Classifications']");
	public final By  FormsLink=By.xpath("//div[@id='menu']//a[text()='Forms']");
	public final By  CasehistoryLink=By.xpath("//div[@id='menu']//a[text()='Case History']");
	public final By  ReviewLink=By.xpath("//div[@id='menu']//a[text()='Review']");
	public final By  MenuExpandButton=By.xpath("//div/a");
	public final By  SearchExpandButton=By.xpath("//div[2]/a/i");
	public final By  SearchResultPersonNameLink=By.xpath("//td[4]/a");
	public final By  ViewPersonOverlay=By.xpath("//div[3]/div");
	public final By  ViewPersonCancelButton=By.xpath("//div[3]/span/button");
	public final By  MenuCloseButton=By.xpath("//div[5]/div/a");
	public final By  AutoSuggestionLink=By.xpath("//*[@id='personSearchForm']/div/div/div/div/ul/li");
	public final By  AutoSuggestionFirstLineLink=By.xpath("//*[@id='personSearchForm']/div/div/div/div/ul/li/div/div");
	public final By  PersonIDinAutoSuggestionLink=By.xpath("//*[@id='personSearchForm']/div/div/div/div/ul/li/div/div/span");
	public final By  AutoSuggestionsList=By.xpath("//*[@id='personSearchForm']/div/div/div/div/ul/li");
	public final By  SearchResultList=By.xpath("//*[@id='personSearchResults']/div/div/table/tbody[2]/tr/td");
	public final By  SearchResultFirstOption=By.xpath("//*[@id='personSearchResults']/div/div/table/tbody[2]/tr/td");
	public final By  SearchResultPageTitle=By.xpath("//h1[@id='homeContext']/span[2]");
	public final By  SearchResultPageHeader=By.id("homeContext");
	public final By  BacktoHomeLink=By.id("previousContext");
	public final By  SearchResultText=By.xpath("//*[@id='homeContext']/small");
	public final By  NoResultFoundPage=By.xpath("//td");
	public final By  PersonName=By.xpath("//h1[@id='homeContext']/span[2]");

	
	
	public void clickonRecentlyAccessedRecordLinkinHomepage() {
		logger.info("Clicking on Recently Accessed Record Link on Home Page");
		elements.waitForElementFluently( HomeRecentlyAccessedRecordLink,
				10);
		elements.buttonClick(HomeRecentlyAccessedRecordLink );
	}

	public void clickonHomeLink() {
		logger.info("Clicking on Home Link from Menu");
		if (Initialization.browserName.equals("android")) {
			elements.waitForElementFluently( MenuExpandButton, 30);
			elements.buttonClick(MenuExpandButton );
			elements.waitForElementFluently( HomeLink, 30);
			elements.buttonClick(HomeLink );
			elements.buttonClick(MenuExpandButton );
			elements.waitForElementFluently( HomeLink, 30);
			elements.waitForElementFluently( MenuCloseButton, 30);
		} else {
			elements.waitForElementFluently( HomeLink, 30);
			elements.buttonClick(HomeLink );
			elements.waitForElementFluently( HomeLink, 30);
		}
	}

	public void clickonSearchPersonGlobalTextbox() {
		logger.info("Clicking on Person Search Global Text box");
		elements.waitForElementFluently( HomeSearchPersonGlobalTextbox,
				10);
		elements.buttonClick(HomeSearchPersonGlobalTextbox );
	}

	public void clickonSearchPersonGlobalButton() {
		logger.info("Clicking on Person Search Global Button");
		elements.waitForElementFluently( HomeSearchPersonGlobalButton,
				10);
		elements.buttonClick(HomeSearchPersonGlobalButton );
	}

	public String getRecentlyAccessedRecordlinkText() {
		logger.info("Getting Text of Recently Accessed Record Link on Home Page");
		elements.waitForElementFluently( HomeLink, 10);
		elements.waitForElementFluently( HomeRecentlyAccessedRecordLink,
				10);
		return elements.getText(HomeRecentlyAccessedRecordLink);
	}

	public void clickonYourCaseLoadLink() {
		logger.info("Clickking on Your Case Load Link");
		elements.waitForElementFluently( HomeLink, 10);
		elements.buttonClick(HomeYourcaseloadLink );
	}

	public void clickonAddPersonButton() {
		logger.info("Clicking on Add Person Button");
		elements.waitForElementFluently( HomeAddpersonButton, 10);
		elements.buttonClick(HomeAddpersonButton );
	}

	public void clickonPersonLink() {
		logger.info("Clicking on Person Link from Menu");
		elements.waitForElementFluently( PersonLink, 10);
		elements.buttonClick(PersonLink );
		elements.waitForElementFluently( HomeLink, 10);
	}

	public void clickonRelationshipLink() {
		logger.info("Clicking on Relationship Link from Menu");
		elements.waitForElementFluently( RelationshipLink, 10);
		elements.buttonClick(RelationshipLink );
	}

	public void clickonGroupLink() {
		logger.info("Clicking on Group Link from Menu");
		elements.waitForElementFluently( GroupLink, 15);
		elements.buttonClick(GroupLink );

		/*if (Initialization.browserName.equals("ie10")) {
			driver.navigate().refresh();
		}*/

	}

	public void clickonChronologyLink() {
		logger.info("Clicking on Chronology Link from Menu");
		elements.waitForElementFluently( ChronologyLink, 10);
		elements.buttonClick(ChronologyLink );
	}

	public void clickonCasenoteLink() {
		logger.info("Clicking on Case Note Link from Menu");
		elements.waitForElementFluently( CasenoteLink, 10);
		elements.buttonClick(CasenoteLink );
	}

	public void clickonClassificationlink() {
		logger.info("Clicking on Classification Link from Menu");
		elements.waitForElementFluently( ClassificationLink, 10);
		elements.buttonClick(ClassificationLink);
	}

	public void clickonFormsLink() {
		logger.info("Clicking on Forms Link from Menu");
		elements.waitForElementFluently( FormsLink, 10);
		elements.buttonClick(FormsLink );
	}

	public void clickoncasehistoryLink() {
		logger.info("Clicking on Case History Link from Menu");
		elements.waitForElementFluently( CasehistoryLink, 10);
		elements.buttonClick(CasehistoryLink );
	}

	public void clickonReviewLink() {
		logger.info("Clicking on Review Link from Menu");
		elements.waitForElementFluently( ReviewLink, 10);
		elements.buttonClick(ReviewLink );
	}

	public void searchPerson(String value) {
		logger.info("Searching a Person");
		if (Initialization.browserName.equals("android")) {
			elements.waitForElementFluently( SearchExpandButton, 10);
			elements.buttonClick(SearchExpandButton );
		}
		elements.waitForElementFluently( HomeSearchPersonGlobalTextbox,
				10);
		elements.inputValue(HomeSearchPersonGlobalTextbox, value);
		elements.buttonClick(HomeSearchPersonGlobalButton );
		elements.waitForElementFluently( SearchResultPersonNameLink, 10);
	}

	public void clickonPersonNameLink() {
		logger.info("Clicking on Person Name Link");
		elements.waitForElementFluently( SearchResultPersonNameLink, 10);
		elements.buttonClick(SearchResultPersonNameLink );
	}

	public boolean isViewPersonOverlayDisplayed() {
		logger.info("Checking if View Person Overlay is Displayed");
		elements.waitForElementFluently( ViewPersonOverlay, 10);
		return elements.isDisplayed(ViewPersonOverlay);
	}

	public String getAddedPersonNamefromSearchResult() {
		logger.info("Getting recently added PersonName from Search Result");
		elements.waitForElementFluently( SearchResultPersonNameLink, 10);
		return elements.getText(SearchResultPersonNameLink);
	}

	public void clickonViewPersonCancelButton() {
		logger.info("Clicking on Cancel Button on View Person Overlay");
		elements.waitForElementFluently( ViewPersonCancelButton, 10);
		elements.buttonClick(ViewPersonCancelButton );
	}

	public void clickonAutoSuggestioninSearch() {
		logger.info("Clicking on AutoSuggestion link in the Search");
		elements.waitForElementFluently( AutoSuggestionLink, 10);
		if (isAutoSuggestionDisplayed() == false) {
			elements.pressBackSpaceKey();
		}
		elements.buttonClick(AutoSuggestionLink );
		elements.waitForElementFluently( HomeLink, 10);
	}

	public void clickonAutoSuggestionLinkinSearch() {
		logger.info("Clicking on AutoSuggestion link in the Search");
		elements.waitForElementFluently( AutoSuggestionFirstLineLink, 10);
		elements.buttonClick(AutoSuggestionFirstLineLink );
		elements.waitForElementFluently( HomeLink, 10);
	}

	public boolean isHomeLinkDisplayed() {
		logger.info("Checking if Home Link is Displayed");
		elements.waitForElementFluently( HomeLink, 10);
		return elements.isDisplayed(HomeLink);
	}

	public boolean isPersonSearchTextBoxDisplayed() {
		logger.info("Checking if Person Search Text Box is Displayed");
		elements.waitForElementFluently( HomeLink, 10);
		return elements.isDisplayed(HomeSearchPersonGlobalTextbox);
	}

	public boolean verifyAutoSuggestionList() {
		logger.info("Verifying Auto Suggestion Result in Search fro keyword 'PER'");
		elements.waitForElementFluently( AutoSuggestionLink, 10);
		List<WebElement> suggestionlist = elements.getElementListWithIdentification(AutoSuggestionsList);
		List<String> searchlist = new ArrayList<String>();
		for (int i = 0; i < (suggestionlist.size() - 1); ++i) {
			WebElement list = suggestionlist.get(i).findElement(
					By.xpath("./div/div/span"));
			searchlist.add(i, list.getText().substring(0, 3));
		}

		for (int i = 0; i < searchlist.size(); i++)
			if ((searchlist.get(i)).equals("PER"))
				return true;
		return false;
	}

	public boolean verifyAutoSuggestionList1(String value) {
		logger.info("Verifying Auto Suggestion Result in Search for keyword "
				+ value);
		elements.waitForElementFluently( AutoSuggestionLink, 10);
		List<WebElement> suggestionlist = elements.getElementListWithIdentification(AutoSuggestionsList);
		List<String> searchlist = new ArrayList<String>();
		for (int i = 0; i < (suggestionlist.size() - 1); ++i) {
			WebElement list = suggestionlist.get(i).findElement(
					By.xpath("./div/div/span"));
			String[] name = list.getText().split("-");
			searchlist.add(i, name[1].trim());
		}

		for (int i = 0; i < searchlist.size(); i++)
			if ((searchlist.get(i)).contains(value))
				return true;
		return false;
	}

	public String getSearchResultPageTitle() throws InterruptedException {
		logger.info("Getting Title of the Search Result page header");
		elements.waitForElementFluently( SearchResultPageTitle, 10);
		// Thread.sleep(3000);
		return elements.getText(SearchResultPageTitle);
	}

	public boolean isBackToHomeLinkDisplayed() {
		logger.info("Checking if Back to Home Link is Displayed");
		elements.waitForElementFluently( SearchResultPageHeader, 10);
		return elements.isDisplayed(BacktoHomeLink);
	}

	public boolean isSearchResultPageHeaderDisplayed() {
		logger.info("Checking if Page Header on Search Result is Displayed");
		elements.waitForElementFluently( SearchResultPageHeader, 10);
		return elements.isDisplayed(SearchResultPageHeader);
	}

	public boolean isAutoSuggestionDisplayed() {
		logger.info("Checking if Auto Suggesstion is Displayed");
		return elements.isElementPresent( AutoSuggestionLink);
	}

	public String getSearchResultTextinHeader() {
		logger.info("Getting Text from Page Header on Search Result");
		elements.waitForElementFluently( NoResultFoundPage, 10);
		return elements.getText(SearchResultText);
	}

	public String getPersonIDfromAutoSuggestion() {
		logger.info("Getting Person ID from Auto Suggestion");
		elements.waitForElementFluently( PersonIDinAutoSuggestionLink,
				10);
		String[] personID = elements.getText(PersonIDinAutoSuggestionLink)
				.split("-");
		return personID[0].trim();
	}

	public String getHomePageTitle() {
		elements.waitForElementFluently( HomeLink, 10);
		return elements.getTitle();
	}

	public String getPersonNamefromHeader() {
		logger.info("Getting Person Name from Header on Home page");
		elements.waitForElementFluently( PersonName, 10);
		String person = elements.getText(PersonName);
		return person.substring(0, person.indexOf("(")).trim();
	}
}

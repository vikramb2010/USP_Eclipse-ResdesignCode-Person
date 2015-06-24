package com.uspeclipse.pageobjects.person;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uspeclipse.commonservices.GenericActions;
import com.uspeclipse.pageobjects.home.Home_pageobjects;
import com.uspeclipse.setup.Initialization;

public class AddPersonAddress_pageobjects {

	private WebDriver driver;
	private static Logger logger = Logger
			.getLogger(AddPersonAddress_pageobjects.class);
	GenericActions elements = null;
	Home_pageobjects homepageobject = null;
	AddPerson_pageobject addpersonpageobject = null;

	public AddPersonAddress_pageobjects(WebDriver driver) {
		this.driver = driver;
		homepageobject = PageFactory.initElements(driver,Home_pageobjects.class);
		addpersonpageobject = PageFactory.initElements(driver,AddPerson_pageobject.class);
		elements = new GenericActions(driver);
	}

	// Pageobjects for Add person Address page objects

	// Button to add a new person
	public final By PersonAddressAddbutton = By
			.xpath("//*[@id = 'personDetailsAddressView']/div/div/div[2]/div/button");
	// Change link
	public final By ChangeLink = By.linkText("Change");
	// Textbox to enter postcode
	public final By PostCodeTextbox = By.id("postcodeSearch-input");//postcodeSearch-wrapper
	// Textbox to enter HouseNameorNumberTextBox
	public final By HouseNameorNumberTextbox = By.id("houseSearch-input");
	// location Type dropdown box
	public final By LocationTypeDropdown = By.id("type-input");
	// location usage dropdown box
	public final By LocationUsageDropdown = By.id("usage-input");
	// year text box
	public final By YearTextbox = By.id("fuzzyStartYEAR");
	// month drop down box
	public final By MonthDropdown = By.id("fuzzyStartMONTH");
	// year text box
	public final By DayDropdown = By.id("fuzzyStartDAY");
	// Add Address save button
	public final By SaveAddressButton = By.xpath("//*[@id = 'person']/div[6]/div[1]/div[3]/span/button[1]");
	// Add Address cancel button
	public final By CancelAddressButton = By.xpath("//*[@id = 'person']/div[6]/div[1]/div[3]/span/button[2]");
	// cancel button under location overlay
	public final By CancelButton = By.id("cancelAddLocation");
	// Add address overlay
	public final By AddAddressOverlay = By.xpath("//*[@id = 'person']/div[6]/div[1]");
	// Location autocomplete list
	public final By Locationautocomplete = By.xpath("//*[@id = 'postcodeSearch-wrapper']//*[@class = 'yui3-aclist-item']/div/div/span");
	// Confirmation message on saving address
	public final By ConfirmationMessageOnSaving = By.xpath("//*[@id='headerMessage']/div[1]/h4");
	// Grid Start Date
	public final By GridStartDate = By.xpath("//*[@id ='personDetailsAddressViewResults']/div[1]/div/table/tbody[2]/tr[1]/td[2]");
	// First Address in Table
	public final By TableFirstAddress = By.xpath("//*[@id ='personDetailsAddressViewResults']/div[1]/div/table/tbody[2]/tr[1]/td[1]");
	// Second Address in Table
	public final By TableSecondAddress = By.xpath("//*[@id ='personDetailsAddressViewResults']/div[1]/div/table/tbody[2]/tr[2]/td[1]");
	// cancel button under add location overlay
	public final By CancelButtonUnderLocationOverlay = By.id("cancelAddLocation");
	// Page object of location after selecting a particular location from autocomplete
	public final By LocationSelected = By.xpath("//*[@id ='location{locationId}']/span");
	// Page object of information text appears below with
	// "We have no suggestions - do you want to add a location?"
	public final By InformationText = By.xpath("//*[@id= 'addPersonAddressForm']/div[4]/div[5]/div/p");
	// Add Location page objects
	// Add Location overlay
	public final By AddLocationOverlay = By.xpath("//*[@id = 'person']/div[6]/div[1]");
	// link to open location
	public final By AddLocationlink = By.xpath("//*[@id = 'addPersonAddressForm']/div[4]/div[1]/label/a");
	// Narrative Text in AddLocation Overlay -You're adding a new location and
	// an address for and an address for Nominated person name and ID
	public final By NarrativeTextBelowTheLocationHeader = By.xpath("//*[@id='addPersonAddressForm']/div[2]/div/div");
	// Building name or Number textbox under location overlay
	public final By BuildingNameorNumberTextbox = By.id("address_primaryNameOrNumber");
	// Street Name textbox under location overlay
	public final By StreetNameTextbox = By.id("address_street");
	// Locality textbox under location overlay
	public final By LocalityTextbox = By.id("address_locality");
	// Town or city textbox under location overlay
	public final By TownorcityTextbox = By.id("address_town");
	// county dropdown under location overlay
	public final By countyDropdownbox = By.id("county-input");
	// post code textbox under location overlay
	public final By postcodeTextboxUnderLocationOverlay = By.id("address_postcode");
	// save and continue button under location overlay
	public final By SaveandContinueButton = By.id("confirmAddLocation");
	// Confirmation Message on saving Location
	public final By ConfirmationMessageOnSavingLocation = By.xpath("//*[@id = 'addPersonAddressForm']/div[1]/div/h4");
	// Narrative Text in AddLocation Overlay - You're adding an address for
	// Nominated person and ID"
	public final By NarrativeTextAfterAddingLocation = By.xpath(" //*[@id = 'addPersonAddressForm']/div[2]/div/div");
	// Home Address
	public final By HomeAddress = By.xpath("//tbody[@class='pure-table-data']//td[contains(text(),'Home')]//..//td[@class='pure-table-col-location!location  pure-table-cell ']");
	// Placement Address
	public final By PlacementAddress = By.xpath("//tbody[@class='pure-table-data']//td[contains(text(),'Placement')]//..//td[@class='pure-table-col-location!location  pure-table-cell ']");
	// Emergency Address
	public final By EmergencyAddress = By.xpath("//tbody[@class='pure-table-data']//td[contains(text(),'Emergency')]//..//td[@class='pure-table-col-location!location  pure-table-cell ']");
	// Work Address
	public final By WorkAddress = By.xpath("//tbody[@class='pure-table-data']//td[contains(text(),'Work')]//..//td[@class='pure-table-col-location!location  pure-table-cell ']");
	// Home Address Select Button
	public final By HomeAddressSelect = By.xpath("//tbody[@class='pure-table-data']//td[contains(text(),'Home')]//..//a[@class='pure-menu-label']");
	// Placement Address Select Button
	public final By PlacementAddressSelect = By.xpath("//tbody[@class ='pure-table-data']//td[contains(text(),'Placement')]//..//a[@class = 'pure-menu-label']");
	// Emergency Address Select Button
	public final By EmergencyAddressSelect = By.xpath("//tbody[@class='pure-table-data']//td[contains(text(),'Emergency')]//..//a[@class='pure-menu-label']");
	// Work Address Select Button
	public final By WorkAddressSelect = By.xpath("//tbody[@class='pure-table-data']//td[contains(text(),'Work')]//..//a[@class='pure-menu-label']");
	// End Home Address Button
	public final By EndHomeAddressSelect = By.xpath("//tbody[@class='pure-table-data']//td[contains(text(),'Home')]//..//ul[@class='pure-menu-children']//a[@class='closeAddress']");
	// End Placement Address Button
	public final By EndPlacementAddressSelect = By.xpath("//tbody[@class='pure-table-data']//td[contains(text(),'Placement')]//..//ul[@class='pure-menu-children']//a[@class='closeAddress']");
	// End Emergency Address Button
	public final By EndEmergencyAddressSelect = By.xpath("//tbody[@class='pure-table-data']//td[contains(text(),'Emergency')]//..//ul[@class='pure-menu-children']//a[@class='closeAddress']");
	// End Work Address Button
	public final By EndWorkAddressSelect = By.xpath("//tbody[@class='pure-table-data']//td[contains(text(),'Work')]//..//ul[@class='pure-menu-children']//a[@class='closeAddress']");


	// Add person Address Methods
	// Method to verify whether AddPersonAddress overlay is displayed
	public boolean isAddPersonAddressOverlaydisplayed() {
		elements.waitForElementFluently( AddAddressOverlay, 30);
		return elements.isElementPresent( AddAddressOverlay);
	}

	// Method to verify whether PostCode textbox is displayed
	public boolean isPostCodeTextboxdisplayed() {
		elements.waitForElementFluently( LocationSelected, 30);
		//return elements.isElementPresent(PostCodeTextbox);
		return elements.getElementWithIdentification(PostCodeTextbox).isDisplayed();
	}

	// Method to verify whether Location Autocomplete is displayed
	public boolean isLocationAutocompletedisplayed() {
		elements.waitForElementFluently( Locationautocomplete, 30);
		return elements.isElementPresent( Locationautocomplete);
	}

	// Method to verify whether HouseNameTextbox is displayed
	public boolean isHouseNameTextboxdisplayed() {
		elements.waitForElementFluently( AddAddressOverlay, 30);
		//elements.waitForElementFluently( LocationSelected, 30);
		return elements.getElementWithIdentification(HouseNameorNumberTextbox).isDisplayed();
	}

	// Method to verify whether ChangeLink is displayed
	public boolean isChangeLinkdisplayed() {
		return elements.isElementPresent( ChangeLink);
	}

	// Providing PostCode details in PostCode Text box.
	public void enterPostcodeText(String value) {
		logger.info("Providing " + value + " in Postcodetextbox");
		elements.waitForElementFluently( AddAddressOverlay, 30);
		elements.inputValue(PostCodeTextbox, value);

	}

	// Providing HouseName or Number in House Name or Number textbox
	public void enterHouseNameorNumberText(String value) {
		logger.info("Providing " + value + " in HouseNameorNumberTextbox");
		elements.waitForElementFluently( AddAddressOverlay, 10);
		elements.waitForElementFluently( HouseNameorNumberTextbox, 10);
		elements.inputValue(HouseNameorNumberTextbox, value);

	}

	// Selecting a Value from Location type dropdownbox.
	public void selectValuefromlocationtypeDropwndownbox(String value) {
		logger.info("Selecting " + value + " from Location type dropdown box");
		elements.waitForElementFluently( LocationTypeDropdown, 30);
		elements.selectDropdown(LocationTypeDropdown, value);

	}

	// Selecting a value from location usage drop down box
	public void selectValuefromlocationUsageDropdownbox(String value) {
		logger.info("Selecting " + value + " from Location usage dropdown box");
		elements.waitForElementFluently( LocationUsageDropdown, 30);
		elements.selectDropdown(LocationUsageDropdown, value);

	}

	// Providing Year in Year combobox.
	public void enteryear(String value) {
		logger.info("Providing " + value + " in yearTEXTBOX");
		elements.waitForElementFluently( YearTextbox, 30);
		elements.inputValue(YearTextbox, value);

	}

	// Selecting a value from Month drop down box
	public void selectValuefromMonthDropdownbox(String value) {
		logger.info("Selecting " + value + " from Month dropdown box");
		elements.waitForElementFluently( MonthDropdown, 30);
		elements.selectDropdown(MonthDropdown, value);

	}

	// Selecting a value from Day drop down box
	public void selectValuefromDayDropdownbox(String value) {
		logger.info("Selecting " + value + " from Day dropdown box");
		elements.waitForElementFluently( DayDropdown, 30);
		elements.selectDropdown(DayDropdown, value);

	}

	// Selecting a location from AutocompleteList
	public void selectaLocationFromAutocompleteList() {
		logger.info("Selecting a location from AutocompleteList");
		elements.waitForElementFluently( Locationautocomplete, 30);
		elements.buttonClick(Locationautocomplete);

	}

	// Clicking on AddAddress Button
	public void clickOnAddAddressButton() {
		logger.info("Clicking on AddAddress Button");
/*		if (Initialization.browserName.equals("chrome")) {
			elements.waitForElementFluently(
					homepageobject.HomeSearchPersonGlobalTextbox, 30);

		} else*/

			elements.waitForElementFluently( PersonAddressAddbutton, 30);
		elements.buttonClick(PersonAddressAddbutton);
	}

	// Clicking on SaveAddress Button
	public void clickOnSaveAddressButton() {
		logger.info("Clicking on SaveAddress Button");
		elements.waitForElementFluently( SaveAddressButton, 30);
		elements.buttonClick(SaveAddressButton);

	}

	// Clicking on Add location Link
	public void ClickOnAddLocationLink() {
		logger.info("Clicking on AddLocation link");
		elements.waitForElementFluently( AddLocationlink, 30);
		elements.buttonClick(AddLocationlink);

	}

	// Clicking on CancelButton under Location Overlay
	public void ClickOnCancelButtonUnderLocationOverlay() {
		logger.info("Clicking on CancelButton under Location Overlay");
		elements.waitForElementFluently( AddLocationOverlay, 30);
		elements.waitForElementFluently(
				CancelButtonUnderLocationOverlay, 30);
		elements.buttonClick(CancelButtonUnderLocationOverlay);

	}

	// Fetching the Text from Confirmation Message after saving Address
	public String ConfirmationMessageonSavingAddress() {
		logger.info("Fetching the Text from Confirmation Message after saving Address");
		if (Initialization.browserName.equals("ios-ipad")) {
			elements.waitForElementFluently( homepageobject.PersonLink,
					30);
		}
		elements.waitForElementFluently( ConfirmationMessageOnSaving, 10);
		return elements.getText(ConfirmationMessageOnSaving);
	}

	// Fetching the Text from Confirmation Message after saving Address
	public String getExpectedAddressFromAutocomplete() {
		logger.info("Fetching the Text from Confirmation Message after saving Address");
		elements.waitForElementFluently( Locationautocomplete, 30);
		return elements.getText(Locationautocomplete);
	}

	// Fetching the value of Address from location label
	public String getActualLocationFromLocationLabel() {
		logger.info("Fetching the Text from Confirmation Message after saving Address");
		elements.waitForElementFluently( LocationSelected, 30);
		return elements.getText(LocationSelected);
	}

	// Fetching the address from Address table
	public String getActualAddressFromAddressTable() {
		logger.info("Fetching the address from Address table");
		elements.waitForElementFluently( TableFirstAddress, 30);
		return elements.getText(TableFirstAddress);
	}

	// Fetching the Another address from Address table
	public String getAnotherActualAddressFromAddressTable() {
		logger.info("Fetching the another address from Address table");
		elements.waitForElementFluently( TableSecondAddress, 30);
		return elements.getText(TableSecondAddress);
	}

	// Fetching the actual start date from address table
	public String getActualStartDateFromAddressgrid() {
		logger.info("Fetching the actual start date from address table");
		elements.waitForElementFluently( GridStartDate, 30);
		return elements.getText(GridStartDate);
	}

	// Fetching the value from type drop down box
	public String getTextFromTypeDropdownbox() {
		logger.info("Fetching the value from type drop down box");
		elements.waitForElementFluently( LocationTypeDropdown, 30);
		WebElement loctionTypeDropdown = elements.getElementWithIdentification(LocationTypeDropdown);
		Select comboBox = new Select(loctionTypeDropdown);
		return comboBox.getFirstSelectedOption().getText();
	}

	// Fetching the value from type drop down box
	public String getTextFromUsageDropdownbox() {
		logger.info("Fetching the value from usage drop down box");
		elements.waitForElementFluently( LocationUsageDropdown, 30);
		WebElement loctionUsageeDropdown = elements.getElementWithIdentification(LocationUsageDropdown);
		Select comboBox = new Select(loctionUsageeDropdown);
		return comboBox.getFirstSelectedOption().getText();
		// return elements.getText(LocationUsageDropdown);
	}

	// Fetching the value from Month drop down box
	public String getTextFromMonthDropdownbox() {
		logger.info("Fetching the value from Month drop down box");
		elements.waitForElementFluently( MonthDropdown, 30);
		WebElement monthDropdown = elements.getElementWithIdentification(MonthDropdown);
		Select comboBox = new Select(monthDropdown);
		return comboBox.getFirstSelectedOption().getText();

	}

	// Fetching the value from Day drop down box
	public String getTextFromDayDropdownbox() {
		logger.info("Fetching the value from Day drop down box");
		elements.waitForElementFluently( DayDropdown, 30);
		WebElement dayDropdown = elements.getElementWithIdentification(DayDropdown);
		Select comboBox = new Select(dayDropdown);
		return comboBox.getFirstSelectedOption().getText();

	}

	// Fetching the Text from Information text
	public String getTextFromInformationText() {
		logger.info("Fetching the Information Text");
		elements.waitForElementFluently( InformationText, 30);
		return elements.getText(InformationText);
	}

	// Clearing the Value from House Name or House Number Textbox
	public void ClearTextFromHouseNameorHouseNumberTextbox() {
		logger.info("Clearing the Value from House Name or House Number Textbox");
		elements.waitForElementFluently( HouseNameorNumberTextbox, 30);
		elements.buttonClick(HouseNameorNumberTextbox);

	}

	// Method to add new person address
	public void AddingPersonAddress(String postcode, String housename,
			String type, String usage, String year, String Month, String Day) {
		logger.info("Adding new person address");
		clickOnAddAddressButton();
		enterPostcodeText(postcode);
		selectaLocationFromAutocompleteList();
		selectValuefromlocationtypeDropwndownbox(type);
		selectValuefromlocationUsageDropdownbox(usage);
		enteryear(year);
		selectValuefromMonthDropdownbox(Month);
		selectValuefromDayDropdownbox(Day);
		clickOnSaveAddressButton();

	}

	// Add Location Methods

	// Method to verify whether Add Location overlay is displayed
	public boolean isAddLocationOverlayDisplayed() {
		elements.waitForElementFluently( AddLocationOverlay, 30);
		return elements.isElementPresent( AddLocationOverlay);
	}

	// Method to verify whether Add Location Link is displayed
	public boolean isAddLocationLinkDisplayed() {
		elements.waitForElementFluently( AddLocationlink, 30);
		return elements.isElementPresent( AddLocationlink);
	}

	// Fetching the Narrative Text from Location Overlay
	public String getNarrativeTextFromLocationOverlay() {
		logger.info("Fetching the Narrative Text from Location Overlay");
		elements.waitForElementFluently( AddLocationOverlay, 30);
		elements.waitForElementFluently(
				NarrativeTextBelowTheLocationHeader, 30);
		return elements.getText(NarrativeTextBelowTheLocationHeader);
	}

	// Providing Building Name or Number in Building Name or Number textbox
	public void enterBuildingNameorNumber(String value) {
		logger.info("Providing " + value
				+ " in Building Name or Number Textbox");
		elements.waitForElementFluently( BuildingNameorNumberTextbox, 30);
		elements.inputValue(BuildingNameorNumberTextbox, value);

	}
	
	public Boolean isHouseNameorNumberTextboxEnabled(){
		return elements.getElementWithIdentification(HouseNameorNumberTextbox).isEnabled();
	}

	// Providing Street Name in street Name textbox
	public void enterStreetName(String value) {
		logger.info("Providing " + value + " in StreetName Textbox");
		elements.waitForElementFluently( StreetNameTextbox, 30);
		elements.inputValue(StreetNameTextbox, value);

	}

	// Providing Locality Name in Locality Name textbox
	public void enterLocalityName(String value) {
		logger.info("Providing " + value + " in Locality Name Textbox");
		elements.waitForElementFluently( LocalityTextbox, 30);
		elements.inputValue(LocalityTextbox, value);

	}

	// Providing TownorCity in Townorcity textbox
	public void enterTownorCity(String value) {
		logger.info("Providing " + value + " in Townorcity  Textbox");
		elements.waitForElementFluently( TownorcityTextbox, 30);
		elements.inputValue(TownorcityTextbox, value);

	}

	// Providing the Post Code in postcode text box under location overlay
	public void enterPostCodeUnderLocationOverlay(String value) {
		logger.info("Providing " + value
				+ " in Postcode  Textbox under location overlay");
		elements.waitForElementFluently(
				postcodeTextboxUnderLocationOverlay, 30);
		elements.inputValue(postcodeTextboxUnderLocationOverlay, value);

	}

	// Selecting a Value from County Dropdownbox
	public void SelectValueFromCountyDropdownbox(String value) {
		logger.info("Providing " + value
				+ " in county dropdown box under location overlay");
		elements.waitForElementFluently( countyDropdownbox, 30);
		elements.selectDropdown(countyDropdownbox, value);

	}

	// Clicking on Save and Continue Under Location Overlay
	public void ClickOnSaveandContinueUnderLocationOverlay() {
		logger.info("Clicking on Save and Continue button under Location Overlay");
		elements.waitForElementFluently( SaveandContinueButton, 30);
		elements.buttonClick(SaveandContinueButton);

	}

	// Fetching the text from Confirmation Message on saving location
	public String ConfirmationMessageonSavingLocation() {
		logger.info("Fetching the Text from Confirmation message after saving location");
		elements.waitForElementFluently(
				ConfirmationMessageOnSavingLocation, 10);
		return elements.getText(ConfirmationMessageOnSavingLocation);
	}

	// Fetching the Narrative Text after Adding Location under Add address
	// overlay Header
	public String getNarrativeTextAfterAddingLocationUnderAddAddressOverlayHeader() {
		logger.info("Fetching the Narrative Text after Adding Location under Add address overlay Header");
		elements.waitForElementFluently(
				NarrativeTextAfterAddingLocation, 30);
		return elements.getText(NarrativeTextAfterAddingLocation);
	}

	// Adding Person Address Location
	public void AddPersonAddressLocation(String buildingNameorNumber1,
			String streetName1, String localityName1, String townorCity1,
			String county1, String postcode, String type1, String usage1,
			String year, String Month, String Day) {
		logger.info("Adding person Address Location");
		clickOnAddAddressButton();
		ClickOnAddLocationLink();
		enterBuildingNameorNumber(buildingNameorNumber1);
		enterStreetName(streetName1);
		enterLocalityName(localityName1);
		enterTownorCity(townorCity1);
		SelectValueFromCountyDropdownbox(county1);
		enterPostCodeUnderLocationOverlay(postcode);
		ClickOnSaveandContinueUnderLocationOverlay();

		selectValuefromlocationtypeDropwndownbox(type1);
		selectValuefromlocationUsageDropdownbox(usage1);
		enteryear(year);
		selectValuefromMonthDropdownbox(Month);
		selectValuefromDayDropdownbox(Day);
		clickOnSaveAddressButton();
	}

	public String getAddressFromAddressTable(String ElementName) {
		if (ElementName.equals("Home")) {
			(new WebDriverWait(driver, 20)).until(ExpectedConditions
					.elementToBeClickable(HomeAddress));
			return elements.getElementWithIdentification(HomeAddress).getText().trim();
		} else if (ElementName.equals("Placement")) {
			(new WebDriverWait(driver, 20)).until(ExpectedConditions
					.elementToBeClickable(PlacementAddress));
			return elements.getElementWithIdentification(PlacementAddress).getText().trim();
		} else if (ElementName.equals("Emergency")) {
			(new WebDriverWait(driver, 20)).until(ExpectedConditions
					.elementToBeClickable(EmergencyAddress));
			return elements.getElementWithIdentification(EmergencyAddress).getText().trim();
		} else if (ElementName.equals("Work")) {
			(new WebDriverWait(driver, 20)).until(ExpectedConditions
					.elementToBeClickable(WorkAddress));
			return elements.getElementWithIdentification(WorkAddress).getText().trim();
		}

		System.out.println("Incorrect Element ");
		return null;
	}

	public void Click(String ElementName) {
		if (ElementName.equals("SelectHome"))
			elements.buttonClick(HomeAddressSelect);
		else if (ElementName.equals("SelectPlacement"))
			elements.buttonClick(PlacementAddressSelect);
		else if (ElementName.equals("SelectEmergency"))
			elements.buttonClick(EmergencyAddressSelect);
		else if (ElementName.equals("SelectWork"))
			elements.buttonClick(WorkAddressSelect);
		else if (ElementName.equals("EndHome"))
			elements.buttonClick(EndHomeAddressSelect);
		else if (ElementName.equals("EndPlacement"))
			elements.buttonClick(EndPlacementAddressSelect);
		else if (ElementName.equals("EndEmergency"))
			elements.buttonClick(EndEmergencyAddressSelect);
		else if (ElementName.equals("EndWork"))
			elements.buttonClick(EndWorkAddressSelect);
	}

	public boolean isElementPresent(String string) {
		logger.info("Checking Address after saving it");
		elements.waitForElementFluently( LocationSelected, 30);
		 return elements.isElementPresent(LocationSelected);
		
	}
}
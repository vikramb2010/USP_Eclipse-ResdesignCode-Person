package com.uspeclipse.pageobjects.person;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

import com.uspeclipse.commonservices.GenericActions;
import com.uspeclipse.commonservices.MultipleBrowser;
import com.uspeclipse.setup.LoggerHelper;

public class AddReferenceNumber_pageobject {
	private WebDriver driver=null;
	private static final Logger logger = Logger.getLogger(AddReferenceNumber_pageobject.class);
	GenericActions elements = null;

	public AddReferenceNumber_pageobject(WebDriver driver){
		this.driver=driver;
		elements = new GenericActions(driver);
	}

	public final By  ReferenceNumberLink=By.linkText("Reference numbers");
	public final By  AddReferenceNumberbutton=By.xpath("//button[contains(@class,'add-referenceNumber')]");
	public final By  EditReferenceNumberbutton=By.xpath("//button[contains(@class,'editRemove-referenceNumber')]");
	public final By  AddReferenceNumberOverlay=By.xpath("//div[contains(@class,'NewPersonReferenceNumberView')]");		// old xpath  //div[4]/div
	public final By  AddReferenceNumberTitle=By.xpath("//div[contains(@class,'NewPersonReferenceNumberView')]//h3");
	public final By  AddReferenceNumberNarrativeText=By.xpath("//form[@id='personReferenceNumberAddForm']//div[contains(@class,'pure-narrative')]");		//old xpath  -  //fieldset/div/div/div
	public final By  ReferenceNumberTypeDropdown=By.id("type-input");
	public final By  ReferenceNumberTypeDefaultDropdown=By.xpath("//select[@id='type-input']/option");
	public final By  ReferenceNumberTypeList=By.xpath("//select[@id='type-input']/option");
	public final By  ReferenceNumberTextbox=By.id("referenceNumber-input");
	public final By  AddReferenceNumberSaveButton=By.xpath("//div[contains(@class,'NewPersonReferenceNumberView')]//button[contains(.,'Save')]");
	public final By  AddReferenceNumberCancelButton=By.xpath("//div[contains(@class,'NewPersonReferenceNumberView')]//button[contains(.,'cancel')]");
	public final By  AddReferenceNumberCloseButton=By.xpath("//div[contains(@class,'NewPersonReferenceNumberView')]//button[contains(.,'Close')]");
	public final By  AddedReferenceNumbersList=By.xpath("//div[2]/div[2]/div/div/div");
	public final By  ReferenceNumbers=By.xpath("//div[@id='referenceNumberPersonIdentificationAccordion']//div[@class='pure-u-1-2 l-box']");
	public final By  AddedReferenceNumberText=By.xpath("//div[2]/div[2]/div/div/div/div[2]");
	public final By  AddedReferenceNumberType=By.xpath("//div[2]/div[2]/div/div/div/div[1]");
	public final By  TypeMandatoryMessage=By.xpath("//a[contains(text(),'Type is mandatory.')]");
	public final By  NumberMandatoryMessage=By.xpath("//a[contains(text(),'Number is mandatory.')]");
	public final By  ErrorMessage=By.xpath("//div[@class='message message-block message-error']");
	// Header - person name and id
	public final By  NameAndIdOfPerson=By.id("personContext");
	// Identification panel - Name
	public final By  identificationName=By.xpath("//*[@id='personDetailsIdentificationAccordion']//div[contains(@class,'pure-u-1-2 l-box')][1]//div[contains(@class,'value')]");
	// Identification panel - Other Forenames
	public final By  identificationForenames=By.xpath("//*[@id='personDetailsIdentificationAccordion']//div[contains(@class,'pure-u-1-2 l-box')][2]//div[contains(@class,'value')]");
	// Identification panel - Gender
	public final By  identificationGender=By.xpath("//*[@id='personDetailsIdentificationAccordion']//div[contains(@class,'pure-u-1-2 l-box')][4]//div[contains(@class,'value')]");
	// Identification panel - Person Type
	public final By  identificationPersonType=By.xpath("//*[@id='personDetailsIdentificationAccordion']//div[contains(@class,'pure-u-1-2 l-box')][5]//div[contains(@class,'value')]");
	// Identification panel - Other Ethinicity
	public final By  identificationEthinicity=By.xpath("//*[@id='personDetailsIdentificationAccordion']//div[contains(@class,'pure-u-1-2 l-box')][6]//div[contains(@class,'value')]");
	// Identification link
	public final By  IdentificationLink=By.linkText("Identification");
	// Reference numbers link
	public final By  ReferenceNumbersLink=By.linkText("Reference numbers");
	// '+' add refernce button
	public final By  addReferenceButton=By.xpath("//button[contains(@class,'add-referenceNumber')]");
	// edit reference button
	public final By  editReferenceButton=By.xpath("//button[contains(@class,'editRemove-referenceNumber')]");
	// header message for - add success, edit success
	public final By  headerMessage=By.id("headerMessage");
	// Reference panel - data elements
	private final By referencePanelData=By.xpath("//div[@id='referenceNumberPersonIdentificationAccordion']//div[contains(@class,'pure-u-1-2 l-box')]");
	// Add reference number - popup - title
	public final By  addReferenceNumberPopup_Title=By.xpath("//h3[text()='Add reference number']");
	// Add reference number - popup - narrative summary
	public final By  addReferenceNumberPopup_NarrativeSummary=By.xpath("//div[contains(@class,'NewPersonReferenceNumberView')]//span[contains(@class,'narrative-summary')]");
	// Add reference number - popup - narrative description
	public final By  addReferenceNumberPopup_NarrativeDescription=By.xpath("//div[contains(@class,'NewPersonReferenceNumberView')]//span[contains(@class,'narrative-description')]");
	// Add reference number - popup - Type label
	public final By  addReferenceNumberPopup_TypeLabel=By.xpath("//div[contains(@class,'NewPersonReferenceNumberView')]//label[contains(@for,'referenceNumberType-input')]");
	// Add reference number - popup - Number label
	public final By  addReferenceNumberPopup_NumberLabel=By.xpath("//div[contains(@class,'NewPersonReferenceNumberView')]//label[contains(@for,'number-input')]");
	// Add reference number - popup - Save Button
	public final By  addReferenceNumberPopup_SaveButton	=By.xpath("//div[contains(@class,'NewPersonReferenceNumberView')]//button[contains(@class,'pure-button-primary')]");
	// Add reference number - popup - Cancel Button
	public final By  addReferenceNumberPopup_CancelButton=By.xpath("//div[contains(@class,'NewPersonReferenceNumberView')]//button[contains(@class,'pure-button-secondary')]");
	// Add reference number - popup - Close Button
	public final By  addReferenceNumberPopup_CloseButton=By.xpath("//div[contains(@class,'NewPersonReferenceNumberView')]//button[contains(@class,'yui3-button-close')]");
	// Add reference number - popup - Type Dropdown
	public final By  addReferenceNumberPopup_TypeDropdown=By.xpath("//div[contains(@class,'NewPersonReferenceNumberView')]//select[@id='type-input']");
	// Add reference number - popup - Type Dropdown
	public final By  addReferenceNumberPopup_NumberInput=By.id("referenceNumber-input");
	// Add reference number - popup - Error details
	public final By  addReferenceNumberPopup_Error=By.xpath("//div[contains(@class,'NewPersonReferenceNumberView')]//div[contains(@class,'message-error')]");

	
	public void clickonReferenceNumberLink() {
		logger.info("Clicking on Reference Number Link");
		elements.waitForElementFluently(
				ReferenceNumberLink, 10);
		elements.buttonClick(ReferenceNumberLink);
	}

	
	public String verifyReferenceNumberPanel(String value) {
		logger.info("Verifying whether Reference Number Panel is open or closed");
		elements.waitForElementFluently(
				ReferenceNumberLink, 10);
		return elements.getAttribute(ReferenceNumberLink, value);
	}

	public boolean isReferenceNumberLinkDisplayed() {
		logger.info("Checking if Reference Number link is displayed");
		elements.waitForElementFluently(
				ReferenceNumberLink, 10);
		return elements.isDisplayed(ReferenceNumberLink);
	}

	public boolean isAddReferenceNumberbuttonDisplayed() {
		logger.info("Checking if Add Reference Number Button is displayed");
		elements.waitForElementFluently(AddReferenceNumberbutton, 10);
		return elements.isDisplayed(AddReferenceNumberbutton);
	}

	public void clickonAddReferenceNumberButton() {
		logger.info("Clicking on Add Reference button");
		elements.waitForElementFluently(AddReferenceNumberbutton, 10);
		elements.buttonClick(AddReferenceNumberbutton);
	}

	public boolean isAddReferenceOverlayDisplayed() {
		logger.info("Checking if Add Reference Overlay is displayed");
		return elements.isDisplayed(AddReferenceNumberOverlay);
	}

	public boolean isAddReferenceFormFieldDisplayed(String value) {
		logger.info("Checking if " + value
				+ " is displayed on Add Reference Overlay ");
		boolean result = false;
		if (value.equals("Title"))
			result = elements.isDisplayed(AddReferenceNumberTitle);
		else if (value.equals("Narrative"))
			result = elements.isDisplayed(AddReferenceNumberNarrativeText);
		else if (value.equals("Type"))
			result = elements.isDisplayed(ReferenceNumberTypeDropdown);
		else if (value.equals("Number"))
			result = elements.isDisplayed(ReferenceNumberTextbox);
		else if (value.equals("Save"))
			result = elements.isDisplayed(AddReferenceNumberSaveButton);
		else if (value.equals("Cancel"))
			result = elements.isDisplayed(AddReferenceNumberCancelButton);
		else if (value.equals("Close"))
			result = elements.isDisplayed(AddReferenceNumberCloseButton);
		return result;
	}

	public String getAddReferenceOverlayTitle() {
		logger.info("Getting Add Reference Number Overlay Title");
		elements.waitForElementFluently(
				AddReferenceNumberTitle, 10);
		return elements.getText(AddReferenceNumberTitle);
	}

	public String getAddReferenceNarrativeText() {
		logger.info("Getting Narrative Text on Add Reference Overlay");
		elements.waitForElementFluently(
				AddReferenceNumberNarrativeText, 10);
		return elements.getText(AddReferenceNumberNarrativeText);
	}

	public String getReferenceNumberTypeDefaultDropdown() {
		logger.info("Getting Default value from Reference Number Type Dropdown");
		elements.waitForElementFluently(
				ReferenceNumberTypeDefaultDropdown, 10);
		return elements.getText(ReferenceNumberTypeDefaultDropdown);
	}

	public boolean checkTypeOptions(List<String> stringlist) {
		logger.info("Verifying the Options in the Type Dropdowm");
		elements.waitForElementFluently(
				ReferenceNumberTypeDropdown, 10);
		return elements.checkDropDownOptions(ReferenceNumberTypeList,
				stringlist);
	}

	public void selectOptionfromReferenceTypeDropdown(String value) {
		logger.info("Selecting " + value
				+ " option from Reference Type Dropdown");
		elements.waitForElementFluently(
				ReferenceNumberTypeDropdown, 10);
		elements.selectDropdown(ReferenceNumberTypeDropdown, value);
	}

	public void enterReferenceNumber(String value) {
		logger.info("Providing " + value + " Reference Number in the Textbox");
		elements.waitForElementFluently(
				ReferenceNumberTextbox, 10);
		elements.inputValue(ReferenceNumberTextbox, value);
	}

	public String selectLastOption() {
		elements.waitForElementFluently(ReferenceNumberTypeDropdown, 10);
		List<WebElement> typeoptions = elements.getElementListWithIdentification(ReferenceNumberTypeList);
		String type = null;
		for (WebElement options : typeoptions) {
			type = options.getText();
		}
		return type;
	}

	public String selectFirstOption() {
		elements.waitForElementFluently(
				ReferenceNumberTypeDropdown, 10);
		List<WebElement> typeoptions = elements.getElementListWithIdentification(ReferenceNumberTypeList);
		WebElement option = typeoptions.get(0);
		String type = option.getText();
		return type;
	}

	public void clickonSaveButton() {
		logger.info("Clicking on Add Reference Number Save Button");
		elements.waitForElementFluently(
				AddReferenceNumberSaveButton, 10);
		elements.buttonClick(AddReferenceNumberSaveButton);
	}

	public void AddReferenceNumber(String number) {
		logger.info("Adding a Reference Number: " + number);
		clickonAddReferenceNumberButton();
		elements.waitForElementFluently(AddReferenceNumberOverlay, 10);
		selectOptionfromReferenceTypeDropdown(selectLastOption());
		enterReferenceNumber(number);
		clickonSaveButton();
	/*	elements.waitForElementFluently(
				EditReferenceNumberbutton, 10);*/
	}

	public String verifyRecentlyAddedReferenceNumberType() {
		logger.info("Verifying recently added Reference Number Type");
		elements.waitForElementFluently(
				AddedReferenceNumberType, 10);
		return elements.getText(AddedReferenceNumberType);
	}

	public String verifyRecentlyAddedReferenceNumberText() {
		logger.info("Verifying recently added Reference Number Text");
		elements.waitForElementFluently(
				AddedReferenceNumberText, 10);
		return elements.getText(AddedReferenceNumberText);
	}

	public boolean verifyReferenceNumberListSorting() {
		logger.info("Verifying all the added Reference Numbers");
		elements.waitForElementFluently(
				EditReferenceNumberbutton, 10);
		List<WebElement> numberlist = elements.getElementListWithIdentification(AddedReferenceNumbersList);
		List<String> referencenumberlist = new ArrayList<String>();

		for (int i = 0; i < (numberlist.size() - 1); ++i) {
			WebElement list = numberlist.get(i).findElement(By.xpath("./div"));
			referencenumberlist.add(i, list.getText().substring(0, 3));
		}

		for (int i = 1; i < referencenumberlist.size(); i++)
			if (referencenumberlist.get(i).compareTo(
					referencenumberlist.get(i - 1)) >= 1)
				return true;
		return false;
	}

	public boolean isEditButtonDisplayed() {
		logger.info("Checking if Edit Reference Number Button is Displayed");
		return elements.isDisplayed(EditReferenceNumberbutton);
	}

	public void clickonClosebutton() {
		logger.info("Clicking on Close button on Add Reference Number Overlay");
		elements.waitForElementFluently(
				AddReferenceNumberCloseButton, 10);
		elements.buttonClick(AddReferenceNumberCloseButton);
	}

	public void clickonCancelbutton() {
		logger.info("Clicking on Cancel button on Add Reference Number Overlay");
		elements.waitForElementFluently(
				AddReferenceNumberCancelButton, 10);
		elements.buttonClick(AddReferenceNumberCancelButton);
	}

	public boolean isReferenceNumberDisplayed() {
		logger.info("Checking if Reference Number is Displayed");
		elements.waitForElementFluently(
				ReferenceNumberLink, 10);
		return elements.isElementPresent(
				ReferenceNumbers);
	}

	public int getSizeofTypeDropDown() {
		logger.info("Getting the number of options in the Reference Number Type Dropdown");
		List<WebElement> typeoptions = elements.getElementListWithIdentification( ReferenceNumberTypeList);
		int size = typeoptions.size();
		return size;
	}

	public boolean isAddReferenceNumberbuttonPresent() {
		logger.info("Checking if Add Reference Number Button is Present");
		elements.waitForElementFluently(
				EditReferenceNumberbutton, 10);
		return elements.isElementPresent(
				AddReferenceNumberbutton);
	}

	public boolean verifyTypeisnotListedinDropdown(String value) {
		logger.info("Verifying whether " + value
				+ " is not Listed in the Reference Type Dropdown");
		List<WebElement> typeoptions = elements.getElementListWithIdentification( ReferenceNumberTypeList);
		boolean typeopt = false;
		for (WebElement options : typeoptions) {
			if ((options.getText()).equals(value)) {
				typeopt = true;
			}
		}
		return typeopt;
	}

	public boolean isTypeMandatoryMessageDisplayed() {
		logger.info("Checking if Type is Mandatory Error Message Displayed on Add Reference Overlay");
		elements.waitForElementFluently( ErrorMessage,
				10);
		return elements.isDisplayed(TypeMandatoryMessage);
	}

	public boolean isNumberMandatoryMessageDisplayed() {
		logger.info("Checking if Number is Mandatory Error Message Displayed on Add Reference Overlay");
		elements.waitForElementFluently( ErrorMessage,
				10);
		return elements.isDisplayed(NumberMandatoryMessage);
	}

	public String getTypeMandatoryMessage() {
		logger.info("Getting the Type is Mandatory Error Message Text on Add PReference Number Overlay");
		elements.waitForElementFluently(
				TypeMandatoryMessage, 10);
		return elements.getText(TypeMandatoryMessage);
	}

	public String getNumberMandatoryMessage() {
		logger.info("Getting the Number is Mandatory Error Message Text on Add PReference Number Overlay");
		elements.waitForElementFluently(
				NumberMandatoryMessage, 10);
		return elements.getText(NumberMandatoryMessage);
	}

	public void clickonEditReferenceNumberButton() {
		logger.info("Clicking on Edit Reference Number Button");
		//elements.waitForElementToBeClickable( EditReferenceNumberbutton, 10);
		elements.waitForElementFluently(EditReferenceNumberbutton, 10);
		elements.buttonClick(EditReferenceNumberbutton);
	}
	
	
	
	////////////////////////////////////////-------------Code Transferred------------------///////////////////////////////
	public String getPersonNameAndId() {
		elements.waitForElementFluently(
				NameAndIdOfPerson, 10);
		return elements.getText(NameAndIdOfPerson);
	}

	public String getIdentificationPanelFields(String fieldName) {
		switch (fieldName) {
		case "Name":
			elements.waitForElementFluently( identificationName, 10);
			return elements.getText(identificationName);
		case "Forenames":
			return elements.getText(identificationForenames);
		case "Gender":
			return elements.getText(identificationGender);
		case "PersonType":
			return elements.getText(identificationPersonType);
		case "Ethinicity":
			return elements.getText(identificationEthinicity);
		default:
			break;
		}
		return "";
	}

	public String getHeaderMessage() {
		elements.waitForElementFluently( headerMessage, 10);
		return elements.getText(headerMessage);
	}

	public String isReferenceNumbersPanelOpen() {
		String title = elements.getAttribute(ReferenceNumbersLink, "title");
		return title;
	}

	
	public void waitExplicity(int seconds) throws InterruptedException
	{
		Thread.sleep(seconds * 1000);
	}
	
	public void addReferenceNumberClick() {
		elements.waitForElementFluently(addReferenceButton, 10);
		//Actions actions = new Actions(driver);
		//actions.moveToElement(addReferenceButton).build().perform();
		elements.buttonClick(addReferenceButton);
		elements.scrollPageDown();
	}

	public String getAddReferenceNumberOverlayFields(String fieldName) {
		switch (fieldName) {
		case "NarrativeSummary":
			return elements.getText(addReferenceNumberPopup_NarrativeSummary);
		case "NarrativeDescription":
			return elements
					.getText(addReferenceNumberPopup_NarrativeDescription);
		case "Type":
			return elements.getText(addReferenceNumberPopup_TypeLabel);
		case "Number":
			return elements.getText(addReferenceNumberPopup_NumberLabel);
		case "Save":
			return elements.getText(addReferenceNumberPopup_SaveButton);
		case "Cancel":
			return elements.getText(addReferenceNumberPopup_CancelButton);
		case "Close":
			return elements.getText(addReferenceNumberPopup_CloseButton);
		default:
			break;
		}
		return "";
	}

	public Boolean isElementVisible(String elemName) {
		//Actions actions = new Actions(driver);
		//actions.moveToElement(ReferenceNumbersLink).build().perform();
		switch (elemName) {
		case "EditReferenceButton":	elements.waitForElementFluently(editReferenceButton, 10);
									return elements.isDisplayed(editReferenceButton);
		case "AddReferenceButton" : elements.waitForElementFluently( addReferenceButton, 10);
									return elements.isElementPresent( addReferenceButton);
		case "ReferenceNumbersPanel":	elements.waitForElementFluently(addReferenceNumberPopup_Title, 10);
										return elements.isElementPresent(addReferenceNumberPopup_Title);
		default:
			break;
		}
		return false;
	}
	
	public String getFirstElementOfTypeDropdown() {
		WebElement elem = elements.getElementWithIdentification(addReferenceNumberPopup_TypeDropdown);
		Select type = new Select(elem);
		return type.getFirstSelectedOption().getText();
	}

	public List<String> getListOfTypes() {
		List<String> values = new ArrayList<>();
		WebElement elem = elements.getElementWithIdentification(addReferenceNumberPopup_TypeDropdown);
		Select type = new Select(elem);
		int count = type.getOptions().size();
		for (int i = 0; i < count; i++) {
			values.add(type.getOptions().get(i).getText());
		}
		return values;
	}
	
	public Boolean isReferenceNumberLinkVisible(){
		return elements.getElementWithIdentification(ReferenceNumberLink).isDisplayed();
	}

	public String getReferenceNumberPopupErrorMessage() {
		elements.waitForElementFluently(
				addReferenceNumberPopup_Error, 10);
		return elements.getText(addReferenceNumberPopup_Error);
	}

	public void addReferenceType(String typeName, String value) {
		elements.waitForElementFluently(addReferenceNumberPopup_Title, 10);
		//Actions actions = new Actions(driver);
		//actions.moveToElement(addReferenceNumberPopup_Title).build().perform();
		WebElement elem = elements.getElementWithIdentification(addReferenceNumberPopup_TypeDropdown);
		Select type = new Select(elem);
		type.selectByVisibleText(typeName);
		//elements.selectDropdown(addReferenceNumberPopup_TypeDropdown, typeName);
		elements.inputValue(addReferenceNumberPopup_NumberInput, value);
		elements.buttonClick(addReferenceNumberPopup_SaveButton);
	}

	public String getMaxLengthOfRefernceNumberInput() {
		return elements.getAttribute(addReferenceNumberPopup_NumberInput,
				"maxlength");
	}
	
	public String getAddedReferenceTypeAndData(int position)
	{
		elements.waitForElementFluently( ReferenceNumberLink, 10);
		//Actions actions = new Actions(driver);
		//actions.moveToElement(referencePanelData.get(position-1)).build().perform();
		List<WebElement> elem = elements.getElementListWithIdentification(referencePanelData);
		return elem.get(position-1).getText();
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}

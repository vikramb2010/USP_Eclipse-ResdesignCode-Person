package com.uspeclipse.pageobjects.person;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.uspeclipse.commonservices.GenericActions;
import com.uspeclipse.pageobjects.home.Home_pageobjects;

public class AddRemoveRefForPerson_pageobject {
	private WebDriver driver=null;
	private static  Logger logger=Logger.getLogger(AddRemoveRefForPerson_pageobject.class);
	GenericActions elements =null;
	Home_pageobjects Home=null;
	
	public AddRemoveRefForPerson_pageobject(WebDriver driver){
		this.driver=driver;
		 Home=PageFactory.initElements(driver,Home_pageobjects.class);
		 elements=new GenericActions(driver);
	}

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
	public final By referencePanelData=By.xpath("//div[@id='referenceNumberPersonIdentificationAccordion']//div[contains(@class,'pure-u-1-2 l-box')]");
	//Add reference number popup - window
	public final By  addReferenceNumberPopup=By.xpath("//div[contains(@class,'NewPersonReferenceNumberView')]");
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
	public final By  addReferenceNumberPopup_SaveButton=By.xpath("//div[contains(@class,'NewPersonReferenceNumberView')]//button[contains(@class,'pure-button-primary')]");
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
		return "NA";
	}

	public String getHeaderMessage() {
		elements.waitForElementFluently( headerMessage, 10);
		return elements.getText(headerMessage);
	}

	public String isReferenceNumbersPanelOpen() {
		String title=elements.getAttribute(ReferenceNumbersLink, "title");
		return title;
	}

	
	public void waitExplicity(int seconds) throws InterruptedException
	{
		Thread.sleep(seconds * 1000);
	}
	
	public void addReferenceNumberClick() {
		//elements.waitForElementFluently(addReferenceButton, 10);
		elements.waitForElementFluently( addReferenceButton, 10);
		//Actions actions=new Actions(driver);
		//actions.moveToElement(addReferenceButton).click().build().perform();
		
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].scrollIntoView(true);", addReferenceButton);
//		elements.scrollIntoViewUsingJSExecutor(ReferenceNumbersLink);
//		Integer x=ReferenceNumbersLink.getLocation().getX();
//		Integer y=ReferenceNumbersLink.getLocation().getY();
//		elements.scrollPagetoSpecificPoint( x.toString(), y.toString());

		
		elements.buttonClick(addReferenceButton);
		
		//elements.scrollPageDown(driver);
	}

	public String getAddReferenceNumberOverlayFiels(String fieldName) {
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
		//Actions actions=new Actions(driver);
		//actions.moveToElement(ReferenceNumbersLink).build().perform();
		switch (elemName) {
		case "EditReferenceButton":	elements.waitForElementFluently(editReferenceButton, 10);
									return elements.isDisplayed(editReferenceButton);
		case "AddReferenceButton" : elements.waitForElementFluently( addReferenceButton, 10);
									return elements.isElementPresent( addReferenceButton);
		case "ReferenceNumbersPanel":	elements.waitForElementFluently(addReferenceNumberPopup, 10);
										return elements.isDisplayed(addReferenceNumberPopup);
		default:
			break;
		}
		return false;
	}
	
	public String getFirstElementOfTypeDropdown() {
		WebElement elem=elements.getElementWithIdentification(addReferenceNumberPopup_TypeDropdown);
		Select type=new Select(elem);
		return type.getFirstSelectedOption().getText();
	}

	public List<String> getListOfTypes() {
		List<String> values=new ArrayList<>();
		WebElement elem=elements.getElementWithIdentification(addReferenceNumberPopup_TypeDropdown);
		Select type=new Select(elem);
		int count=type.getOptions().size();
		for (int i=0; i < count; i++) {
			values.add(type.getOptions().get(i).getText());
		}
		return values;
	}

	public String getReferenceNumberPopupErrorMessage() {
		elements.waitForElementFluently(addReferenceNumberPopup_Error, 10);
		elements.Waitformilliseconds(2000);
		return elements.getText(addReferenceNumberPopup_Error);
	}

	public void addReferenceType(String typeName, String value) {
		elements.waitForElementFluently(addReferenceNumberPopup_TypeDropdown, 20);
		//Actions actions=new Actions(driver);
		//actions.moveToElement(addReferenceNumberPopup_TypeDropdown).build().perform();
		WebElement elem=elements.getElementWithIdentification(addReferenceNumberPopup_TypeDropdown);
		Select type=new Select(elem);
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
		//Actions actions=new Actions(driver);
		//actions.moveToElement(ReferenceNumbersLink).build().perform();
		List<WebElement> elem=elements.getElementListWithIdentification(referencePanelData);
		return elem.get(position-1).getText();
	}
}

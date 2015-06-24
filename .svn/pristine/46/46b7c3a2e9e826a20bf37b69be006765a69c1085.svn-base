package com.uspeclipse.pageobjects.person;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uspeclipse.commonservices.GenericActions;

public class EditReferenceNumber_pageobject {
	private WebDriver driver=null;
	private static  Logger logger = Logger.getLogger(EditReferenceNumber_pageobject.class);
	GenericActions elements = null;
	
	public EditReferenceNumber_pageobject(WebDriver driver){
		this.driver=driver;
		elements = new GenericActions(driver);
	}
	
	// Reference panel - arrow button
	public final By  referenceNumbersLink=By.linkText("Reference numbers");
	// Edit items success message
	public final By  headerMessage=By.xpath("//div[@id='headerMessage']");
	// Edit reference number - popup - Overlay present
	public final By  editReferencePanelOverlay=By.xpath("//div[contains(@class,'EditRemovePersonReferenceNumberView')]");
	// Edit reference number - labels of reference data
	public  final By typeOfReferenceDataLabel=By.xpath("//div[contains(@class,'EditRemovePersonReferenceNumberView')]//label[starts-with(@id,'referenceNumberLabel')]");	
	// Edit reference number - values of reference data
	public final By valuesOfReferenceDataInput=By.xpath("//div[contains(@class,'EditRemovePersonReferenceNumberView')]//input[starts-with(@name,'referenceNumber')]");
	// Edit reference number - popup - title
	public final By  editReferenceNumberPopup_Title=By.xpath("//h3[text()='Edit reference numbers']");
	// Edit reference number - popup - narrative text - summary
	public final By  editReferenceNumberPopup_NarrativeSummaryText=By.xpath("//div[contains(@class,'EditRemovePersonReferenceNumberView')]//span[contains(@class,'narrative-summary')]");
	// Edit reference number - popup - narrative text - description
	public final By  editReferenceNumberPopup_NarrativeDescriptionText=By.xpath("//div[contains(@class,'EditRemovePersonReferenceNumberView')]//span[contains(@class,'narrative-description')]");
	// Edit reference number - popup - Reference panel - data elements
	public final By referencePanelData=By.xpath("//div[contains(@class,'EditRemovePersonReferenceNumberView')]//div[contains(@class,'pure-u-1-2 l-box')]");
	// Edit reference number - popup - Save Button
	public final By  editReferenceNumberPopup_SaveButton=By.xpath("//div[contains(@class,'EditRemovePersonReferenceNumberView')]//button[contains(@class,'pure-button-primary')]");
	// Edit reference number - popup - Cancel Button
	public final By  editReferenceNumberPopup_CancelButton=By.xpath("//div[contains(@class,'EditRemovePersonReferenceNumberView')]//button[contains(@class,'pure-button-secondary')]");
	// Edit reference number - popup - Close Button
	public final By  editReferenceNumberPopup_CloseButton=By.xpath("//div[contains(@class,'EditRemovePersonReferenceNumberView')]//button[contains(@class,'yui3-button-close')]");
	
	public Boolean isEditReferenceNumberOverlayDisplayed()	{
		elements.waitForElementFluently( editReferencePanelOverlay, 10);
		return elements.isDisplayed(editReferencePanelOverlay);
	}
	
	public Boolean updateReferenceNumberValue(String type, String value)	{
		elements.waitForElementFluently(editReferencePanelOverlay, 10);
		List<WebElement> listTypeDataLabel = elements.getElementListWithIdentification(typeOfReferenceDataLabel);
		List<WebElement> listDataInput = elements.getElementListWithIdentification(valuesOfReferenceDataInput);
		for(int i=0;i<listTypeDataLabel.size();i++){
				if(listTypeDataLabel.get(i).getText().equals(type)){
					//elements.clearValue(listDataInput.get(i));
					listDataInput.get(i).clear();
					listDataInput.get(i).sendKeys(value);
					return true;
			}
		}
		return false;
	}
	
	
	public void clickonSaveButton(){
		elements.waitForElementFluently(editReferenceNumberPopup_SaveButton, 15);
		elements.buttonClick(editReferenceNumberPopup_SaveButton);
	}
	
	public Boolean isDisplayed(String elem){
		switch (elem.toUpperCase()) {
		case "EDIT-REFERENCE-OVERLAY-TITLE":
			return elements.isDisplayed(editReferenceNumberPopup_Title);
		case "EDIT-REFERENCE-OVERLAY-SAVEBUTTON":
			return elements.isDisplayed(editReferenceNumberPopup_SaveButton);
		case "EDIT-REFERENCE-OVERLAY-CLOSEBUTTON":
			return elements.isDisplayed(editReferenceNumberPopup_CloseButton);
		case "EDIT-REFERENCE-OVERLAY-CANCELBUTTON":
			return elements.isDisplayed(editReferenceNumberPopup_CancelButton);
		}
		return false;
	}
	
	public String getEditReferenceNumberOverlayHeaderText(){
		elements.waitForElementFluently( editReferenceNumberPopup_Title, 10);
		return elements.getText(editReferenceNumberPopup_Title);
	}
	
	public String getEditReferenceNumberOverlayNarrativeSummaryText()	{
		return elements.getText(editReferenceNumberPopup_NarrativeSummaryText);
	}
	
	public String getEditReferenceNumberOverlayNarrativeDescriptionText(){
		return elements.getText(editReferenceNumberPopup_NarrativeDescriptionText);
	}
	
	public String getEditReferenceNumberOverlayTypeAndData(int position)	{
		elements.waitForElementFluently( editReferenceNumberPopup_Title, 10);
		//Actions actions = new Actions(driver);
		//actions.moveToElement(referencePanelData.get(position-1)).build().perform();
		List<WebElement> listDataPanel = elements.getElementListWithIdentification(referencePanelData);
		String type = listDataPanel.get(position-1).findElement(By.xpath("label")).getText() ;
		String data = listDataPanel.get(position-1).findElement(By.xpath("input")).getAttribute("value");
		return (type+ "," + data);
	}
	
	
	public Boolean isRemoveLinkPresent(int position){
		//Actions actions = new Actions(driver);
		//actions.moveToElement(referencePanelData.get(position-1)).build().perform();
		List<WebElement> listDataPanel = elements.getElementListWithIdentification(referencePanelData);
		return elements.isElementPresent( listDataPanel.get(position-1).findElement(By.xpath("a")));
	}
	
	
	public Boolean isUpArrowKeyDisplayed(){
		logger.info("Check if Up Arrow key displayed");
		elements.waitForElementFluently( referenceNumbersLink, 10);
		if(elements.getAttribute(referenceNumbersLink, "class").contains("open"))
			return true;
		return false;
	}
}

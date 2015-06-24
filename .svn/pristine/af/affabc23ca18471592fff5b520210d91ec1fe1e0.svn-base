package com.uspeclipse.pageobjects.person;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.uspeclipse.commonservices.GenericActions;

public class RemoveReferenceNumber_pageobject {
	private WebDriver driver=null;
	private static final Logger logger = Logger.getLogger(RemoveReferenceNumber_pageobject.class);
	GenericActions elements = null;
	AddReferenceNumber_pageobject addreferencenumberpageobject = null;
	
	public RemoveReferenceNumber_pageobject(WebDriver driver){
		this.driver=driver;
		addreferencenumberpageobject = PageFactory.initElements(driver, AddReferenceNumber_pageobject.class);
		elements = new GenericActions(driver);
	}

	public final By  EditReferenceNumberOverlay=By.xpath("//div[4]/div");
	public final By  EditReferenceNumberTitle=By.xpath("//h3");
	public final By  EditReferenceNumberNarrativeText=By.xpath("//form/div/div/div");
	public final By  EditReferenceNumberSaveButton=By.xpath("//div[3]/span/button");
	public final By  EditReferenceNumberCancelButton=By.xpath("//button[2]");
	public final By  EditReferenceNumberCloseButton=By.xpath("//div[4]/div/div/span/button");
	public final By  EditReferenceNumberRemoveLink=By.xpath("//a[contains(text(),'Remove')]");
	public final By  EditReferenceNumberTextBox=By.xpath("//input");
	public final By  AddedReferenceNumberListonEditOverlay=By.xpath("//div[@id='removeRefNumLinks']/div");

	public boolean isEditReferenceNumberOverlayDisplayed() {
		logger.info("Checking if Edit Reference Number Overlay is Diaplayed");
		elements.waitForElementFluently(
				EditReferenceNumberOverlay, 10);
		return elements.isDisplayed(EditReferenceNumberOverlay);
	}

	public boolean isEditReferenceFormFieldDisplayed(String value) {
		logger.info("Checking if " + value
				+ " is Displayed on Edit Reference Number Overlay");
		elements.waitForElementFluently(
				EditReferenceNumberOverlay, 10);
		boolean result = false;
		if (value.equals("Title"))
			result = elements.isDisplayed(EditReferenceNumberTitle);
		else if (value.equals("Narrative"))
			result = elements.isDisplayed(EditReferenceNumberNarrativeText);
		else if (value.equals("Save"))
			result = elements.isDisplayed(EditReferenceNumberSaveButton);
		else if (value.equals("Cancel"))
			result = elements.isDisplayed(EditReferenceNumberCancelButton);
		else if (value.equals("Close"))
			result = elements.isDisplayed(EditReferenceNumberCloseButton);
		else if (value.equals("Remove"))
			result = elements.isDisplayed(EditReferenceNumberRemoveLink);
		return result;
	}

	public String getEditReferenceOverlayTitle() {
		logger.info("Getting Edit Reference Number Overlay Title");
		elements.waitForElementFluently(
				EditReferenceNumberOverlay, 10);
		return elements.getText(EditReferenceNumberTitle);
	}

	public String getEditReferenceNarrativeText() {
		logger.info("Getting Edit Reference Number Narrative Text");
		elements.waitForElementFluently(
				EditReferenceNumberNarrativeText, 10);
		return elements.getText(EditReferenceNumberNarrativeText);
	}

	public List<String> getAddedReferenceNumberList() {
		logger.info("Getting all the Added Reference Numbers on Person Details Page");
		elements.waitForElementFluently(
				addreferencenumberpageobject.EditReferenceNumberbutton, 10);
		List<WebElement> numberlist = elements.getElementListWithIdentification(addreferencenumberpageobject.AddedReferenceNumbersList);
		List<String> referencenumberlist = new ArrayList<String>();
		for (int i = 0; i < (numberlist.size() - 1); ++i) {
			WebElement list = numberlist.get(i).findElement(By.xpath("./div"));
			referencenumberlist.add(i, list.getText().substring(0, 3));
		}
		return referencenumberlist;
	}

	public List<String> getAddedReferenceNumberListonEditOverlay() {
		logger.info("Getting all the Added Reference Numbers on Edit Reference Number Overlay");
		elements.waitForElementFluently(
				EditReferenceNumberOverlay, 10);
		List<WebElement> numberlist = elements.getElementListWithIdentification(AddedReferenceNumberListonEditOverlay);
		List<String> referencenumberlist = new ArrayList<String>();
		for (int i = 0; i < (numberlist.size() - 1); ++i) {
			WebElement list = numberlist.get(i)
					.findElement(By.xpath("./label"));
			referencenumberlist.add(i, list.getText().substring(0, 3));
		}
		return referencenumberlist;
	}

	public boolean isReferenceNumberEnabledforEditing() {
		logger.info("Checking if Reference Numbers can be Edited");
		elements.waitForElementFluently(
				EditReferenceNumberOverlay, 10);
		boolean result = false;
		List<WebElement> numberlist = elements.getElementListWithIdentification(AddedReferenceNumberListonEditOverlay);
		for (int i = 0; i < (numberlist.size() - 1); ++i) {
			WebElement element = numberlist.get(i).findElement(
					By.xpath("./input"));
			if (element.isEnabled())
				result = true;
			else
				result = false;
		}
		return result;
	}

	public boolean verifyReferenceNumbers() {
		logger.info("Verifying the Comparison of Reference Numbers on Person Details Page and Edit Overlay");
		boolean result = false;
		elements.waitForElementFluently(
				addreferencenumberpageobject.EditReferenceNumberbutton, 10);
		List<String> AList = getAddedReferenceNumberList();
		addreferencenumberpageobject.clickonEditReferenceNumberButton();
		elements.waitForElementFluently(
				EditReferenceNumberOverlay, 10);
		List<String> BList = getAddedReferenceNumberListonEditOverlay();
		clickonEditReferenceNumberCancelButton();
		int sizeOfTheShortestList = Math.min(AList.size(), BList.size());
		for (int i = 0; i < sizeOfTheShortestList; i++) {
			if (AList.get(i).equals(BList.get(i)))
				result = true;
			else
				result = false;
		}
		return result;
	}

	public void clickonEditReferenceRemoveLink() {
		logger.info("Clicking on Remove Link on Edit Reference Overlay");
		elements.waitForElementFluently(
				EditReferenceNumberRemoveLink, 10);
		elements.buttonClick(EditReferenceNumberRemoveLink);
	}

	public boolean isReferenceNumberTextBoxEnabled() {
		logger.info("Checking if Reference Number Text box is Enabled");
		elements.waitForElementFluently(
				EditReferenceNumberOverlay, 10);
		return elements.isEnabled(EditReferenceNumberTextBox);
	}

	public void clickonEditReferenceNumberSaveButton() {
		logger.info("Clicking on Save Button on Edit Reference Overlay");
		elements.waitForElementFluently(
				EditReferenceNumberSaveButton, 10);
		elements.buttonClick(EditReferenceNumberSaveButton);
	}

	public void clickonEditReferenceNumberCancelButton() {
		logger.info("Clicking on Cancel Button on Edit Reference Overlay");
		elements.waitForElementFluently(
				EditReferenceNumberCancelButton, 10);
		elements.buttonClick(EditReferenceNumberCancelButton);
	}

	public void clickonEditReferenceNumberCloseButton() {
		logger.info("Clicking on Close Button on Edit Reference Overlay");
		elements.waitForElementFluently(
				EditReferenceNumberCloseButton, 10);
		elements.buttonClick(EditReferenceNumberCloseButton);
	}
}

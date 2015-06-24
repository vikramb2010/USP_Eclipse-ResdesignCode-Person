package com.uspeclipse.pageobjects.groups;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.uspeclipse.commonservices.GenericActions;
import com.uspeclipse.pageobjects.home.Home_pageobjects;

public class Groups_pageobjects {
	private WebDriver driver=null;
	private Logger logger = Logger.getLogger(Groups_pageobjects.class);
	GenericActions elements = null;
	Home_pageobjects Home = null;
	
	public Groups_pageobjects(WebDriver driver){
		this.driver=driver;
		Home = PageFactory.initElements(driver, Home_pageobjects.class);
		elements = new GenericActions(driver);
	}

	// *********************** Add Group Page Objects*********//
	// Page object for add group button
	private final By AddGroupButton=By.xpath("//li[@id='groupButtonList']/a");
	// Page object for Add group name textbox
	private final By GroupNameTextbox=By.xpath("//div[contains(@class,'NewGroupTodayView')]//input[@id='name-input']");
	// Page object for Description textbox
	private final By GroupDescriptionTextbox=By.xpath("//div[contains(@class,'NewGroupTodayView')]//textarea[@id='description-input']");
	// Page object for group type dropdowntextbox.
	private final By GroupTypeDropdownbox=By.xpath("//div[contains(@class,'NewGroupTodayView')]//select[@id='groupType-input']");
	// Page object for save button in add group page.
	private final By GroupSaveButton=By.xpath("//div[contains(@class,'NewGroupTodayView')]//button[contains(.,'Save')]");
	// Add person overlay
	private final By AddGroupOverlay=By.xpath("//div[contains(@class,'NewGroupTodayView')]");
	// Page object for cancel button in add group page
	private final By GroupCancelButton=By.xpath("//div[contains(@class,'NewGroupTodayView')]//button[contains(.,'cancel')]");
	// Page object for confirmation message on saving group
	private final By GroupConfirmationMessageOnSave=By.xpath("//div[@id='headerMessage']/div[1]/h4");
	// Page object for closebuttonicon
	private final By AddGroupOverlayCloseIcon=By.xpath("//div[contains(@class,'NewGroupTodayView')]//button[contains(.,'cancel')]");
	private final By GroupTypeList=By.xpath("//*[@id='groupType-input']/option");
	private final By NarrativeTextonAddGroupOverlay=By.xpath("//fieldset/div/div/div/span");

	public void clickonAddgroupButton() {
		elements.waitForPageLoaded();
		elements.waitForElementFluently( AddGroupButton,40);
		elements.buttonClick(AddGroupButton);
		elements.waitForElementFluently(AddGroupOverlay, 10);
	}

	public void clickonSaveGroupButton() {
		elements.waitForElementFluently(GroupSaveButton, 10);
		elements.buttonClick(GroupSaveButton);
		elements.waitForElementFluently(GroupConfirmationMessageOnSave, 10);
	}

	public void clickonCancelgroupButton() {
		elements.waitForElementFluently(GroupCancelButton, 10);
		elements.buttonClick(GroupCancelButton);
	}

	public void enterGroupname(String value) {
		elements.inputValue(GroupNameTextbox, value);
	}

	public void enterGroupDescription(String value) {
		elements.inputValue(GroupDescriptionTextbox, value);
	}

	public void SelectValueFromGroupTypeDropdownbox(String value) {
		elements.selectDropdown(GroupTypeDropdownbox, value);
	}

	public String getConfirmationMessageTextOnSavingGroup() {
		elements.waitForElementFluently(GroupConfirmationMessageOnSave, 10);
		return elements.getText(GroupConfirmationMessageOnSave);
	}

	public void clickonCloseIcon() {
		elements.waitForElementFluently(AddGroupOverlay, 10);
		elements.buttonClick(AddGroupOverlayCloseIcon);
	}

	public String getNarrativeTextFromAddGroupOverlay() {
		elements.waitForElementFluently(NarrativeTextonAddGroupOverlay, 10);
		return elements.getText(NarrativeTextonAddGroupOverlay);
	}

	public String ConfirmationMessageonSaving() {
		elements.waitForElementFluently(GroupConfirmationMessageOnSave, 10);
		return elements.getText(GroupConfirmationMessageOnSave);
	}

}

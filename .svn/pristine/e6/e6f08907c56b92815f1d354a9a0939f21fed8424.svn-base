package com.uspeclipse.pageobjects.person;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.uspeclipse.commonservices.GenericActions;
import com.uspeclipse.pageobjects.home.Home_pageobjects;

public class AddPersonContact_pageobject {
	private WebDriver driver=null;
	private static  Logger logger = Logger.getLogger(AddPersonAddress_pageobjects.class);
	GenericActions elements = null;
	Home_pageobjects Home=null;
	
	public AddPersonContact_pageobject(WebDriver driver){
		this.driver=driver;
		Home = PageFactory.initElements(driver,Home_pageobjects.class);
		elements = new GenericActions(driver);
	}

	public final By  ContactsLink=By.xpath("//div[4]/div/div/h3/a");
	public final By  AddContactsButton=By.id("addContactDetailsButton");
	public final By  AddContactsOverlay=By.xpath("//div[4]");
	public final By  AddContactsTitle=	By.xpath("//h3");
	public final By  AddContactsNarrativeText=By.xpath("//*[@id='personContactAddForm']/fieldset/div/div/div");
	public final By  AddContactsContactDropdown=By.xpath("//select[@id='contactFixedType-input']");
	public final By  AddContactsContactDefaultDropdown=By.xpath("//select[@id='contactFixedType-input']/option");
	public final By AddContactsContactList=By.xpath("//select[@id='contactFixedType-input']/option");
	public final By  AddContactsTypeDropdown=By.id("contactType-input");
	public final By  AddContactsTypeDefaultDropdown=By.xpath("//select[@id='contactType-input']/option");
	public final By AddContactsTypeList=By.xpath("//select[@id='contactType-input']/option");
	public final By  AddContactsEmailAddressTextbox=By.id("contactDetail-input");
	public final By  AddContactsUsageDropdown=By.id("contactUsage-input");
	public final By  AddContactsUsageDefaultDropdown=By.xpath("//select[@id='contactUsage-input']/option");
	public final By AddContactsUsageList=By.xpath("//select[@id='contactUsage-input']/option");
	public final By  AddContactsSaveButton=By.xpath("//div[contains(@class,'NewPersonContactView')]//button[contains(.,'Save')]");		//old xpath -- //div[3]/span/button
	public final By  AddContactsCancelButton=By.xpath("//div[contains(@class,'NewPersonContactView')]//button[contains(.,'cancel')]"); 	//old xpath -- //button[2]
	public final By  AddContactsCloseButton=By.xpath("//div[contains(@class,'NewPersonContactView')]//button[contains(.,'Close')]");		// old xpath --  //div[4]/div/div/span/button
	public final By  AddContactsTelephoneTypeDropdown=By.id("telephoneType-input");
	public final By  AddContactsTelephoneTypeDefaultDropdown=By.xpath("//select[@id='telephoneType-input']/option");
	public final By AddContactsTelephoneTypeList=By.xpath("//select[@id='telephoneType-input']/option");
	public final By  AddContactsNumberTextbox=By.id("number-input");
	public final By  AddContactsURLTextbox=By.id("identifier-input");
	public final By  AddContactsSocialMediaTypeDropdown=By.id("socialMediaType-input");
	public final By  AddContactsSocialMediaTypeDefaultDropdown=By.xpath("//select[@id='socialMediaType-input']/option");
	public final By AddContactsSocialMediaTypeList=By.xpath("//select[@id='socialMediaType-input']/option");
	public final By  AddContactsWebAddressTextbox=By.id("contactDetail-input");
	public final By  InvalidEmailAddressMessage=By.xpath("//a[contains(text(),'Please enter a valid Email address')]");
	public final By  ErrorMessage=By.xpath("//h4");
	public final By  ErrorMessageAlertBox=By.xpath("//*[@class='message message-block message-error']");
	public final By  TypeMandatoryMessage=By.xpath("//a[contains(text(),'Type is mandatory')]");
	public final By  UsageMandatoryMessage=By.xpath("//a[contains(text(),'Usage is mandatory.')]");
	public final By  EmailAddressMandatoryMessage=By.xpath("//a[contains(text(),'Email address is mandatory')]");
	public final By  WebAddressMandatoryMessage=By.xpath("//a[contains(text(),'Web address is mandatory')]");
	public final By  SocialMediaTypeMandatoryMessage=By.xpath("//a[contains(text(),'Social media type is mandatory')]");
	public final By  URLMandatoryMessage=By.xpath("//a[contains(text(),'URL is mandatory')]");
	public final By  NumberMandatoryMessage=By.xpath("//a[contains(text(),'Number is mandatory')]");
	public final By  TelephoneTypeMandatoryMessage=By.xpath("//a[contains(text(),'Telephone type is mandatory')]");
	public final By  AddedContactEmail=By.xpath("//div[2]/div/div/div/div[3]/div[2]");
	public final By  AddedContactMobile=By.xpath("//div[2]/div/div/div/div[2]/div[2]");
	public final By  RemoveLink_PhoneNumber=By.xpath("//form[@id = 'updateRemoveContactForm']//h4[contains(text(),'Phone number')]//..//a[@class = 'removeLink small']");
	public final By  RemoveLink_MobileNumber=By.xpath("//form[@id = 'updateRemoveContactForm']//h4[contains(text(),'Mobile number')]//..//a[@class = 'removeLink small']");
	public final By  RemoveLink_EmailAddress=By.xpath("//form[@id = 'updateRemoveContactForm']//h4[contains(text(),'Email address')]//..//a[@class = 'removeLink small']");
	public final By  RemoveLink_WebSite=By.xpath("//form[@id = 'updateRemoveContactForm']//h4[contains(text(),'Website')]//..//a[@class = 'removeLink small']");
	public final By  RemoveLink_SocialMedia=By.xpath("//form[@id = 'updateRemoveContactForm']//h4[contains(text(),'Social media')]//..//a[@class = 'removeLink small']");
	public final By  RemoveLink_FaxNumber=By.xpath("//form[@id = 'updateRemoveContactForm']//h4[contains(text(),'Fax number')]//..//a[@class = 'removeLink small']");
	public final By  TextBox_FaxNumber=By.xpath("//form[@id = 'updateRemoveContactForm']//h4[contains(text(),'Fax number')]//..//input");

	
	public void clickonContactsLink() {
		logger.info("Clicking on Contact Link on Person Detail page");
		elements.waitForElementFluently( ContactsLink,
				10);
		elements.buttonClick(ContactsLink);
	}

	public String verifyContactsPanel(String value) {
		logger.info("Checking if Contacts Panel is open or closed");
		elements.waitForElementFluently( ContactsLink,
				10);
		return elements.getAttribute(ContactsLink, value);
	}

	public boolean isContactsLinkDisplayed() {
		logger.info("Checking if Contacts Link is Displayed");
		elements.waitForElementFluently( ContactsLink,
				10);
		return elements.isDisplayed(ContactsLink);
	}

	public boolean isAddContactsButtonDisplayed() {
		logger.info("Checking if Add Contacts Button is Displayed");
		elements.waitForElementFluently(
				AddContactsButton, 10);
		return elements.isDisplayed(AddContactsButton);
	}

	public void clickonAddContactsButton() {
		logger.info("Clicking on Add Contacts Button");
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();} //had to add this - Since WebDriveWait isn't working
	//	(new WebDriverWait( 100)).until(ExpectedConditions.elementToBeClickable(AddContactsButton));
		elements.waitForElementFluently(
				AddContactsButton, 20);
		elements.buttonClick(AddContactsButton);
	}

	public boolean isAddContactsOverlayDisplayed() {
		logger.info("Checking if Add Contacts Overlay is Displayed");
		return elements.isDisplayed(AddContactsOverlay);
	}

	public boolean isAddContactsFormFieldDisplayed(String value) {
		logger.info("Checking if " + value
				+ " is Displayed on the Add Contacts Form");
		boolean result = false;
		if (value.equals("Title"))
			result = elements.isDisplayed(AddContactsTitle);
		else if (value.equals("Narrative"))
			result = elements.isDisplayed(AddContactsNarrativeText);
		else if (value.equals("Contact"))
			result = elements.isDisplayed(AddContactsContactDropdown);
		else if (value.equals("Type"))
			result = elements.isDisplayed(AddContactsTypeDropdown);
		else if (value.equals("Usage"))
			result = elements.isDisplayed(AddContactsUsageDropdown);
		else if (value.equals("Email"))
			result = elements.isDisplayed(AddContactsEmailAddressTextbox);
		else if (value.equals("URL"))
			result = elements.isDisplayed(AddContactsURLTextbox);
		else if (value.equals("Social"))
			result = elements.isDisplayed(AddContactsSocialMediaTypeDropdown);
		else if (value.equals("Telephone"))
			result = elements.isDisplayed(AddContactsTelephoneTypeDropdown);
		else if (value.equals("Number"))
			result = elements.isDisplayed(AddContactsNumberTextbox);
		else if (value.equals("Web"))
			result = elements.isDisplayed(AddContactsWebAddressTextbox);
		else if (value.equals("Save"))
			result = elements.isDisplayed(AddContactsSaveButton);
		else if (value.equals("Cancel"))
			result = elements.isDisplayed(AddContactsCancelButton);
		else if (value.equals("Close"))
			result = elements.isDisplayed(AddContactsCloseButton);
		return result;
	}

	public String getAddContactsOverlayTitle() {
		logger.info("Getting Title of the Add Contacts Overlay");
		elements.waitForElementFluently(
				AddContactsTitle, 10);
		return elements.getText(AddContactsTitle);
	}

	public String getAddContactsNarrativeText() {
		logger.info("Getting Narrative Text on the Add Contacts Overlay");
		elements.waitForElementFluently(
				AddContactsNarrativeText, 10);
		return elements.getText(AddContactsNarrativeText);
	}

	public String getDefaultDropdownValue(String type) {
		logger.info("Getting Default Value from " + type + " Dropdown");
		String value = null;
		if ((type).equals("Contact")) {
			elements.waitForElementFluently(
					AddContactsContactDropdown, 10);
			value = elements.getText(AddContactsContactDefaultDropdown);
		} else if ((type).equals("Type")) {
			elements.waitForElementFluently(
					AddContactsTypeDropdown, 10);
			value = elements.getText(AddContactsTypeDefaultDropdown);
		} else if ((type).equals("Usage")) {
			elements.waitForElementFluently(
					AddContactsUsageDropdown, 10);
			value = elements.getText(AddContactsUsageDefaultDropdown);
		} else if ((type).equals("Social")) {
			elements.waitForElementFluently(
					AddContactsSocialMediaTypeDropdown, 10);
			value = elements.getText(AddContactsSocialMediaTypeDefaultDropdown);
		} else if ((type).equals("Telephone")) {
			elements.waitForElementFluently(
					AddContactsTelephoneTypeDropdown, 10);
			return elements.getText(AddContactsTelephoneTypeDefaultDropdown);
		}
		return value;
	}

	public boolean isDropdownDefaultValuenotEmpty(String type) {
		logger.info("Checking if Default value in the " + type
				+ " Dropdown is not Empty");
		boolean result = false;
		if ((type).equals("Contact")) {
			elements.waitForElementFluently(
					AddContactsContactDropdown, 10);
			result = elements.isEmpty(AddContactsContactDefaultDropdown);
		} else if ((type).equals("Type")) {
			elements.waitForElementFluently(
					AddContactsTypeDropdown, 10);
			result = elements.isEmpty(AddContactsTypeDefaultDropdown);
		} else if ((type).equals("Usage")) {
			elements.waitForElementFluently(
					AddContactsUsageDropdown, 10);
			result = elements.isEmpty(AddContactsUsageDefaultDropdown);
		} else if ((type).equals("Social")) {
			elements.waitForElementFluently(
					AddContactsSocialMediaTypeDropdown, 10);
			result = elements
					.isEmpty(AddContactsSocialMediaTypeDefaultDropdown);
		} else if ((type).equals("Telephone")) {
			elements.waitForElementFluently(
					AddContactsTelephoneTypeDropdown, 10);
			result = elements.isEmpty(AddContactsTelephoneTypeDefaultDropdown);
		}
		return result;
	}

	public boolean checkDropdownOptions(String type, List<String> stringlist) {
		logger.info("Verifying the Options in the " + type + " Dropdown");
		boolean result = false;
		if ((type).equals("Contact")) {
			elements.waitForElementFluently(
					AddContactsContactDropdown, 10);
			result = elements.checkDropDownOptions(AddContactsContactList,stringlist);
		} else if ((type).equals("Type")) {
			elements.waitForElementFluently(
					AddContactsTypeDropdown, 10);
			result = elements.checkDropDownOptions(AddContactsTypeList,stringlist);
		} else if ((type).equals("Usage")) {
			elements.waitForElementFluently(
					AddContactsUsageDropdown, 10);
			result = elements.checkDropDownOptions(AddContactsUsageList,stringlist);
		} else if ((type).equals("Telephone")) {
			elements.waitForElementFluently(
					AddContactsTelephoneTypeDropdown, 10);
			result = elements.checkDropDownOptions(AddContactsTelephoneTypeList, stringlist);
		} else if ((type).equals("Social")) {
			elements.waitForElementFluently(
					AddContactsSocialMediaTypeDropdown, 10);
			result = elements.checkDropDownOptions(AddContactsSocialMediaTypeList, stringlist);
		}
		return result;
	}

	public boolean selectOptionfromDropdown(String type, String value) {
		logger.info("Selecting " + value + " from " + type + " Dropdown");
		boolean result = false;
		if ((type).equals("Contact")) {
			elements.waitForElementFluently(
					AddContactsContactDropdown, 10);
			elements.selectDropdown(AddContactsContactDropdown, value);
		} else if ((type).equals("Type")) {
			elements.waitForElementFluently(
					AddContactsTypeDropdown, 10);
			elements.selectDropdown(AddContactsTypeDropdown, value);
		} else if ((type).equals("Usage")) {
			elements.waitForElementFluently(
					AddContactsUsageDropdown, 10);
			elements.selectDropdown(AddContactsUsageDropdown, value);
		} else if ((type).equals("Telephone")) {
			elements.waitForElementFluently(
					AddContactsTelephoneTypeDropdown, 10);
			elements.selectDropdown(AddContactsTelephoneTypeDropdown, value);
		} else if ((type).equals("Social Media")) {
			elements.waitForElementFluently(
					AddContactsSocialMediaTypeDropdown, 10);
			elements.selectDropdown(AddContactsSocialMediaTypeDropdown, value);
		}
		return result;
	}

	public boolean isAddContactsSaveButtonEnabled() {
		logger.info("Checking if Save Button is Enabled on Add Contacts Overlay");
		elements.waitForElementFluently(
				AddContactsOverlay, 10);
		return elements.isEnabled(AddContactsSaveButton);
	}

	public void clickonSaveButton() {
		logger.info("Clicking on Save Button on Add Contacts Overlay");
		elements.waitForElementFluently(
				AddContactsSaveButton, 10);
		elements.buttonClick(AddContactsSaveButton);
	}

	public void clickonClosebutton() {
		logger.info("Clicking on Close Button on Add Contacts Overlay");
		elements.waitForElementFluently(
				AddContactsCloseButton, 10);
		elements.buttonClick(AddContactsCloseButton);
	}

	public void clickonCancelbutton() {
		logger.info("Clicking on Cancel Button on Add Contacts Overlay");
		elements.waitForElementFluently(
				AddContactsCancelButton, 10);
		elements.buttonClick(AddContactsCancelButton);
	}

	public void enterEmailAddress(String value) {
		logger.info("Providing " + value
				+ " in the Email Address text box on Add Contacts Overlay");
		elements.waitForElementFluently(
				AddContactsEmailAddressTextbox, 10);
		elements.inputValue(AddContactsEmailAddressTextbox, value);
	}

	public void enterURL(String value) {
		logger.info("Providing " + value
				+ " in the URL text box on Add Contacts Overlay");
		elements.waitForElementFluently(
				AddContactsURLTextbox, 10);
		elements.inputValue(AddContactsURLTextbox, value);
	}

	public void enterNumber(String value) {
		logger.info("Providing " + value
				+ " in the Number text box on Add Contacts Overlay");
		elements.waitForElementFluently(
				AddContactsNumberTextbox, 10);
		elements.inputValue(AddContactsNumberTextbox, value);
	}

	public void enterWebAddress(String value) {
		logger.info("Providing " + value
				+ " in the Web Address text box on Add Contacts Overlay");
		elements.waitForElementFluently(
				AddContactsWebAddressTextbox, 10);
		elements.inputValue(AddContactsWebAddressTextbox, value);
	}

	public String getInvalidEmailAddressMessage() {
		logger.info("Getting Invalid Email Address error message on Add Contacts Overlay");
		elements.waitForElementFluently(
				InvalidEmailAddressMessage, 10);
		return elements.getText(InvalidEmailAddressMessage);
	}

	public String getMandatoryErrorMessage(String type) {
		logger.info("Getting Mandatory error message for " + type
				+ " field on Add Contacts Overlay");
		String value = null;
		if ((type).equals("Type")) {
			elements.waitForElementFluently(
					TypeMandatoryMessage, 10);
			value = elements.getText(TypeMandatoryMessage);
		} else if ((type).equals("Usage")) {
			elements.waitForElementFluently(
					UsageMandatoryMessage, 10);
			value = elements.getText(UsageMandatoryMessage);
		} else if ((type).equals("Social")) {
			elements.waitForElementFluently(
					SocialMediaTypeMandatoryMessage, 10);
			value = elements.getText(SocialMediaTypeMandatoryMessage);
		} else if ((type).equals("Telephone")) {
			elements.waitForElementFluently(
					TelephoneTypeMandatoryMessage, 10);
			value = elements.getText(TelephoneTypeMandatoryMessage);
		} else if ((type).equals("Email")) {
			elements.waitForElementFluently(
					EmailAddressMandatoryMessage, 10);
			value = elements.getText(EmailAddressMandatoryMessage);
		} else if ((type).equals("URL")) {
			elements.waitForElementFluently(
					URLMandatoryMessage, 10);
			value = elements.getText(URLMandatoryMessage);
		} else if ((type).equals("Number")) {
			elements.waitForElementFluently(
					NumberMandatoryMessage, 10);
			value = elements.getText(NumberMandatoryMessage);
		} else if ((type).equals("Web")) {
			elements.waitForElementFluently(
					WebAddressMandatoryMessage, 10);
			value = elements.getText(WebAddressMandatoryMessage);
		}
		return value;
	}

	public boolean isMandatoryErrorMessageDisplayed(String type) {
		logger.info("Checking if Mandatory error message for " + type
				+ " field on Add Contacts Overlay is Displayed");
		elements.waitForElementFluently(
				ErrorMessageAlertBox, 10);
		elements.waitForElementFluently( ErrorMessage,
				10);
		boolean result = false;
		if ((type).equals("Type")) {
			result = elements.isDisplayed(TypeMandatoryMessage);
		} else if ((type).equals("Usage")) {
			result = elements.isDisplayed(UsageMandatoryMessage);
		} else if ((type).equals("Social")) {
			result = elements.isDisplayed(SocialMediaTypeMandatoryMessage);
		} else if ((type).equals("Telephone")) {
			result = elements.isDisplayed(TelephoneTypeMandatoryMessage);
		} else if ((type).equals("Email")) {
			result = elements.isDisplayed(EmailAddressMandatoryMessage);
		} else if ((type).equals("URL")) {
			result = elements.isDisplayed(URLMandatoryMessage);
		} else if ((type).equals("Number")) {
			result = elements.isDisplayed(NumberMandatoryMessage);
		} else if ((type).equals("Web")) {
			result = elements.isDisplayed(WebAddressMandatoryMessage);
		}
		return result;
	}

	public void AddContacts(String contactvalue, String typevalue,
			String email, String usagevalue, String socialvalue,
			String telephonevalue, String url, String number, String webaddress) {
		logger.info("Adding a Contact for type " + contactvalue);
		clickonAddContactsButton();
		selectOptionfromDropdown("Contact", contactvalue);
		selectOptionfromDropdown("Type", typevalue);
		if ((contactvalue).equals("Email")) {
			enterEmailAddress(email);
		}
		if ((contactvalue).equals("Social Media")) {
			selectOptionfromDropdown("Social Media", socialvalue);
			enterURL(url);
		}
		if ((contactvalue).equals("Telephone")) {
			selectOptionfromDropdown("Telephone", telephonevalue);
			enterNumber(number);
		}
		if ((contactvalue).equals("Web Address")) {
			enterWebAddress(webaddress);
		}
		selectOptionfromDropdown("Usage", usagevalue);
	}

	public boolean verifyisContactAdded(String value) {
		logger.info("Verifying if " + value + " Contact is Added");
		boolean result = false;
		elements.waitForElementFluently(
				AddContactsButton, 10);
		if ((value).equals("Email"))
			result = elements.isElementPresent(
					AddedContactEmail);
		else if ((value).equals("Mobile"))
			result = elements.isElementPresent(
					AddedContactMobile);
		return result;
	}

	public boolean VerifyRemoveLinkExists(String value)
	{
		boolean result = false;
		elements.waitForElementFluently(
			AddContactsSaveButton, 10);
		if ((value).equals("PhoneNumber"))
			result = elements.isElementPresent(
					RemoveLink_PhoneNumber);
		else if ((value).equals("MobileNumber"))
			result = elements.isElementPresent(
					RemoveLink_MobileNumber);
		else if ((value).equals("EmailAddress"))
			result = elements.isElementPresent(
					RemoveLink_EmailAddress);
		else if ((value).equals("WebSite"))
			result = elements.isElementPresent(
					RemoveLink_WebSite);
		
		else if ((value).equals("SocialMedia"))
			result = elements.isElementPresent(
					RemoveLink_SocialMedia);
		
		else if ((value).equals("FaxNumber"))
			result = elements.isElementPresent(
					RemoveLink_FaxNumber);
		
		
		
		return result;
	}

	public void ClickRemoveLink(String value) {
		if ((value).equals("FaxNumber"))
		{
			elements.getElementWithIdentification(RemoveLink_FaxNumber).click();
		}
		
	}

	public boolean CheckDisabledInputTextBox(String value) {
		boolean result = false;
		if ((value).equals("FaxNumber"))
		{
			WebElement faxNumberTextBox = elements.getElementWithIdentification(TextBox_FaxNumber);
			if(faxNumberTextBox.getAttribute("disabled").equals("true") || faxNumberTextBox.getAttribute("disabled") == null)
				result = true;
		}
		
		return result;
	}

}

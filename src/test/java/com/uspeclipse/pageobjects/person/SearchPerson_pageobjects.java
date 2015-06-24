package com.uspeclipse.pageobjects.person;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uspeclipse.commonservices.GenericActions;
import com.uspeclipse.helper.RegularExpressionChecker;
import com.uspeclipse.pageobjects.home.Home_pageobjects;
import com.uspeclipse.setup.Initialization;

public class SearchPerson_pageobjects {
	private WebDriver driver=null;
	private static final Logger logger = Logger.getLogger(SearchPerson_pageobjects.class);
	GenericActions elements = null;

	AddPerson_pageobject addpersonpageobject = null;
	AddPersonAddress_pageobjects addpersonaddresspageobject = null;
	Home_pageobjects homepageobject = null;
	
	public SearchPerson_pageobjects(WebDriver driver){
		this.driver=driver;
		addpersonpageobject = PageFactory.initElements( driver, AddPerson_pageobject.class);
		addpersonaddresspageobject = PageFactory.initElements(driver, AddPersonAddress_pageobjects.class);
		homepageobject = PageFactory.initElements( driver, Home_pageobjects.class);
		elements = new GenericActions(driver);
	}

	// Page object for search Functionality in Persons
	public final By  SearchAutocompleteFirstline=By.xpath("//*[@id ='personSearchForm']/div/div/div[1]/div/ul/li/div/div[1]/span");
	public final By  SearchAutocompleteSecondline=By.xpath("//*[@id ='personSearchForm']/div/div/div[1]/div/ul/li/div/div[2]/span");
	public final By  SearchAutocompleteThirdline=By.xpath("//*[@id ='personSearchForm']/div/div/div[1]/div/ul/li/div/div[3]");
	public final By  DOBandAge=By.xpath("//div[2]/div/div/div[3]/div[2]");
	public final By  gender=By.xpath("//div/div[4]/div[2]");
	public final By  Lbl_Identification_SearchPersonPage=By.xpath("//a[contains(text(),'Identification')]");
	public final By  Lbl_Contacts_Phone_SearchPersonPage=By.xpath("//h4[contains(text(),'Phone number')]");
	public final By  Link_Contacts_SearchPersonPage=By.xpath("//a[contains(text(),'Contacts')]");
	public final By  Btn_ContactIdentifierArrowButton=By.id("personContactIdentificationAccordion");
	public final By  Btn_addContactDetailsButton=By.id("addContactDetailsButton");
	public final By  Btn_editContactDetailsButton=By.id("editContactDetailsButton");
	public final By  List_ContactFixedType=By.id("contactFixedType-input");
	public final By  TextBox_ContactDetail=By.id("contactDetail-input");
	public final By  List_ContactType=By.id("contactType-input");
	public final By  List_ContactUsage=By.id("contactUsage-input");
	public final By  Btn_ContactAddSave=By.xpath("//button[contains(text(),'Save')]");
	public final By  Panel_EditContactWindow=By.xpath("//h3[contains(.,'Edit contact')]");
	public final By  lbl_EditContact=By.className("iconic-title");
	public final By  lbl_EditContact_Summary=By.className("narrative-summary");;
	public final By  lbl_EditContact_MobileNumber=By.xpath("//h4[contains(text(),'Mobile number')]");
	public final By  lbl_EditContact_PhoneNumber=By.xpath("//h4[contains(text(),'Phone number')]");
	public final By  lbl_EditContact_EmailAddress=By.xpath("//h4[contains(text(),'Email address')]");
	public final By  lbl_EditContact_Website=By.xpath("//h4[contains(text(),'Website')]");
	public final By  lbl_EditContact_SocialMedia=By.xpath("//h4[contains(text(),'Social media')]");
	public final By  lbl_EditContact_FaxNumber=By.xpath("//h4[contains(text(),'Fax number')]");
	public final By  lbl_SocialMediaValue=By.xpath("//form[contains(@id,'updateRemoveContactForm')]//h4[contains(text(),'Social media')]//..//div");
	public final By  lbl_PhoneNumberValue=By.xpath("//form[contains(@id,'updateRemoveContactForm')]//h4[contains(text(),'Phone number')]//..//div");
	public final By  lbl_MobileNumberValue=By.xpath("//form[contains(@id,'updateRemoveContactForm')]//h4[contains(text(),'Mobile number')]//..//div");
	public final By  lbl_FaxNumberValue=By.xpath("//form[contains(@id,'updateRemoveContactForm')]//h4[contains(text(),'Fax number')]//..//div");
	public final By  lbl_WebSiteValue=By.xpath("//form[contains(@id,'updateRemoveContactForm')]//h4[contains(text(),'Website')]//..//div");
	public final By  Btn_EditContact_SaveButton=By.xpath("//div[contains(@class,'EditRemoveContactView')]//button[contains(.,'Save')]");
	public final By  Btn_EditContact_CancelButton=By.xpath("//div[contains(@class,'EditRemoveContactView')]//button[contains(.,'cancel')]");
	public final By  Btn_EditContact_CloseButton=By.xpath("//div[contains(@class,'EditRemoveContactView')]//button[contains(.,'Close')]");
	public final By  txt_EditContact_Email=By.xpath("//input[contains(@name,'contact')]");
	public final By  txt_EditContact_ErrorMessageEmail=By.xpath("//a[@class='error-key']");
	public final By  txt_EditContact_ContactUpdatedMessage=By.xpath("//div[@id = 'headerMessage']//h4");
	public final By  txt_EmailAddressValue=By.xpath("//a[contains(@href,'mailto')]");
	public final By  txt_PhoneNumberValue=By.xpath("//div[@id = 'personContactIdentificationAccordion']//h4[contains(text(),'Phone number')]//..//div[@class='value']");
	public final By  txt_FaxNumberValue=By.xpath("//div[@id = 'personContactIdentificationAccordion']//h4[contains(text(),'Fax number')]//..//div");

	public String[] getPersonIdName() {
		logger.info("Getting Person ID and Name");
		elements.waitForElementFluently(
				SearchAutocompleteFirstline, 30);
		String idName = elements.getElementWithIdentification(SearchAutocompleteFirstline).getText();
		System.out.println(idName);
		String idNames[] = idName.split("-");
		String id = idNames[0].trim();
		String name = idNames[1].trim();
		String[] idAndName = { id, name };
		return idAndName;
	}

	public String[] getPersonDOBAgeGender() {
		logger.info("Getting Person DOB and gender");
		elements.waitForElementFluently(
				SearchAutocompleteSecondline, 30);
		String genderDOBAge = elements.getElementWithIdentification(SearchAutocompleteSecondline).getText();
		System.out.println(genderDOBAge);
		String genderDOBAges[] = genderDOBAge.split(",");
		String gender = genderDOBAges[0].trim();
		String DOBAges = genderDOBAges[1].trim();
		String[] genderAndDOBAndAge = { gender, DOBAges };
		return genderAndDOBAndAge;
	}

	public String getGender() {
		logger.info("Getting Person Gender");
		elements.waitForElementFluently( gender, 30);
		return elements.getText(gender);
	}

	public String getexpectedPersonDOBAgeGender() {
		logger.info("Getting Expected Person DOB, Age and Gender");
		elements.waitForElementFluently( DOBandAge, 30);
		String expectedgenderDOBAge = elements.getElementWithIdentification(DOBandAge).getText();
		String expectedgenderDOBAges[] = expectedgenderDOBAge.split(",");
		String ExpectedDob = expectedgenderDOBAges[0].trim();
		String Expectedage = expectedgenderDOBAges[1].trim();
		String Expectedage1 = Expectedage.substring(
				Expectedage.indexOf("(") + 1, Expectedage.indexOf(")"));
		String expectedgenderAndDOBAndAge = ExpectedDob + " " + Expectedage1;
		return expectedgenderAndDOBAndAge;
	}

	public String getPersonAddressLocationFromAutoSuggest() {
		logger.info("Getting Person Address Location from Auto Suggestion");
		elements.waitForElementFluently(
				SearchAutocompleteThirdline, 30);
		String address = elements.getElementWithIdentification(SearchAutocompleteThirdline).getText();
		return address;
	}

	public void enterSearchText(String value) {
		logger.info("Providing " + value + " in Search Text box");
	
		
		if (!Initialization.browserName.equals("ios-ipad"))
		{
			elements.waitForElementFluently(	homepageobject.HomeLink, 30);
		}
		elements.waitForElementFluently( homepageobject.HomeSearchPersonGlobalTextbox, 30);
		elements.inputValue(homepageobject.HomeSearchPersonGlobalTextbox, value);

	}

	public boolean magnifierGlassonSearchBoxPresent() {
		logger.info("Checking if magnifier Glass on Search Box is Present");
		elements.waitForElementFluently(
				homepageobject.HomeSearchPersonGlobalButton, 20);
		return elements
				.isDisplayed(homepageobject.HomeSearchPersonGlobalButton);
	}

	public boolean isLine3and4inSearchAutocompleteDisplayed() {
		logger.info("Checking if Line 3rd and 4th in Search Auto Complete Displayed");
		elements.waitForElementFluently(
				homepageobject.HomeSearchPersonGlobalButton, 30);
		elements.waitForElementFluently(
				SearchAutocompleteSecondline, 30);
		return elements.isElementPresent(
				SearchAutocompleteThirdline);
	}

	public String getSearchboxDefaultText(String value) {
		logger.info("Getting Default Text from Search Text box");
		elements.waitForElementFluently(
				homepageobject.HomeSearchPersonGlobalTextbox, 30);
		return elements.getAttribute(
				homepageobject.HomeSearchPersonGlobalTextbox, value);

	}

	public String getExpectedAddressFromAddressTable() {
		logger.info("Getting Expected Address from Address Table");
		elements.waitForElementFluently(
				addpersonaddresspageobject.TableFirstAddress, 30);
		return elements.getText(addpersonaddresspageobject.TableFirstAddress);
	}

	public String getActualAddressFromSearchAutocompleteThirdLine() {
		logger.info("Getting Actual Address from Search Auto Complete");
		elements.waitForElementFluently(
				SearchAutocompleteThirdline, 30);
		return elements.getText(SearchAutocompleteThirdline);
	}

	public void WaitForElement(String ElementName) {
		if (ElementName.equals("Search- AutoComplete First Line"))
			elements.waitForElementFluently(
					SearchAutocompleteFirstline, 30);

	}

	public void Click(String ElementName) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (ElementName.equals("Search- FirstResult"))
			elements.buttonClick(SearchAutocompleteFirstline);
		else if (ElementName.equals("Contact-Arrow"))
			elements.buttonClick(Link_Contacts_SearchPersonPage);
		else if (ElementName.equals("AddButton"))
			elements.buttonClick(Btn_addContactDetailsButton);
		else if (ElementName.equals("AddSave"))
			elements.buttonClick(Btn_ContactAddSave);
		else if (ElementName.equals("EditButton"))
			elements.buttonClick(Btn_editContactDetailsButton);
		else if (ElementName.equals("CancelButton"))
			elements.buttonClick(Btn_EditContact_CancelButton);
		else if (ElementName.equals("EditSaveContact"))
			elements.buttonClick(Btn_EditContact_SaveButton);
		else if (ElementName.equals("CloseButton")) {
			(new WebDriverWait(driver, 60))
					.until(ExpectedConditions
							.elementToBeClickable(Btn_EditContact_CloseButton));
			elements.buttonClick(Btn_EditContact_CloseButton);
		}

	}

	public boolean CheckForElementExistence(String ElementName)
			throws InterruptedException {

		driver.manage().timeouts()
				.implicitlyWait(10, TimeUnit.SECONDS);

		if (ElementName.equals("Identification")) {
			elements.waitForElementFluently(
					Lbl_Identification_SearchPersonPage, 30);
			return elements.isElementPresent(
					Lbl_Identification_SearchPersonPage);
		}

		else if (ElementName.equals("Contact"))
			return elements.isElementPresent(
					Lbl_Contacts_Phone_SearchPersonPage);
		else if (ElementName.equals("AddButton"))
			return elements.isElementPresent(
					Btn_addContactDetailsButton);
		else if (ElementName.equals("EditButton"))
			return elements.isElementPresent(
					Btn_editContactDetailsButton);
		else if (ElementName.equals("EditContactOverlay"))
			return elements.isElementPresent(
					Panel_EditContactWindow);

		else if (ElementName.equals("EditContactLabel"))
			return elements.isElementPresent(
					lbl_EditContact);
		else if (ElementName.equals("EditContactSummary"))
			return elements.isElementPresent(
					lbl_EditContact_Summary);
		else if (ElementName.equals("EditContactMobileNumber"))
			return elements.isElementPresent(
					lbl_EditContact_MobileNumber);
		else if (ElementName.equals("EditContactPhoneNumber"))
			return elements.isElementPresent(
					lbl_EditContact_PhoneNumber);
		else if (ElementName.equals("EditContactEmailAddress"))
			return elements.isElementPresent(
					lbl_EditContact_EmailAddress);
		else if (ElementName.equals("EditContactWebSite"))
			return elements.isElementPresent(
					lbl_EditContact_Website);
		else if (ElementName.equals("EditContactFaxNumber"))
			return elements.isElementPresent(
					lbl_EditContact_FaxNumber);
		else if (ElementName.equals("SaveButton"))
			return elements.isElementPresent(
					Btn_EditContact_SaveButton);
		else if (ElementName.equals("CancelButton"))
			return elements.isElementPresent(
					Btn_EditContact_CancelButton);
		else if (ElementName.equals("CloseButton"))
			return elements.isElementPresent(
					Btn_EditContact_CloseButton);

		else if (ElementName.equals("Error_EmailMessage"))
			return elements.isElementPresent(
					txt_EditContact_ErrorMessageEmail);
		else if (ElementName.equals("ContactUpdatedMessage"))
			return elements.isElementPresent(
					txt_EditContact_ContactUpdatedMessage);
		else if (ElementName.equals("SearchAutocompleteThirdline"))
			return elements.isElementPresent(
					SearchAutocompleteThirdline);

		return false;
	}

	public boolean CheckForElementExistence1(String ElementName)
			throws InterruptedException {

		driver.manage().timeouts()
				.implicitlyWait(10, TimeUnit.SECONDS);
		if (ElementName.equals("Identification")) {
			// elements.waitForElementFluently(
			// Lbl_Identification_SearchPersonPage , 30);
			return elements.isElementPresent(
					Lbl_Identification_SearchPersonPage);
		}

		else if (ElementName.equals("Contact"))
			return elements.isElementPresent(
					Lbl_Contacts_Phone_SearchPersonPage);
		else if (ElementName.equals("AddButton"))
			return elements.isElementPresent(
					Btn_addContactDetailsButton);
		else if (ElementName.equals("EditButton"))
			return elements.isElementPresent(
					Btn_editContactDetailsButton);
		else if (ElementName.equals("EditContactOverlay"))
			return elements.isElementPresent(
					Panel_EditContactWindow);

		else if (ElementName.equals("EditContactLabel"))
			return elements.isElementPresent(
					lbl_EditContact);
		else if (ElementName.equals("EditContactSummary"))
			return elements.isElementPresent(
					lbl_EditContact_Summary);
		else if (ElementName.equals("EditContactMobileNumber"))
			return elements.isElementPresent(
					lbl_EditContact_MobileNumber);
		else if (ElementName.equals("EditContactPhoneNumber"))
			return elements.isElementPresent(
					lbl_EditContact_PhoneNumber);
		else if (ElementName.equals("EditContactEmailAddress"))
			return elements.isElementPresent(
					lbl_EditContact_EmailAddress);
		else if (ElementName.equals("EditContactWebSite"))
			return elements.isElementPresent(
					lbl_EditContact_Website);
		else if (ElementName.equals("EditContactFaxNumber"))
			return elements.isElementPresent(
					lbl_EditContact_FaxNumber);
		else if (ElementName.equals("SaveButton"))
			return elements.isElementPresent(
					Btn_EditContact_SaveButton);
		else if (ElementName.equals("CancelButton"))
			return elements.isElementPresent(
					Btn_EditContact_CancelButton);
		else if (ElementName.equals("CloseButton"))
			return elements.isElementPresent(
					Btn_EditContact_CloseButton);

		else if (ElementName.equals("Error_EmailMessage"))
			return elements.isElementPresent(
					txt_EditContact_ErrorMessageEmail);
		else if (ElementName.equals("ContactUpdatedMessage"))
			return elements.isElementPresent(
					txt_EditContact_ContactUpdatedMessage);
		else if (ElementName.equals("SearchAutocompleteThirdline"))
			return elements.isElementPresent(
					SearchAutocompleteThirdline);

		return false;
	}

	public boolean CheckWindowHidden(String WindowName) {
		if (WindowName.equals("Contact"))
			return elements.getElementWithIdentification(Link_Contacts_SearchPersonPage).getAttribute("title").equals(
					"Click to expand section");

		return false;
	}
	
	
	public void SelectDropDown(String ElementName, String Value) {
		if (ElementName.equals("ContactFixedType"))
			elements.selectDropdown(List_ContactFixedType, Value);
		else if (ElementName.equals("ContactType"))
			elements.selectDropdown(List_ContactType, Value);
		else if (ElementName.equals("ContactUsage"))
			elements.selectDropdown(List_ContactUsage, Value);
	}

	public void InputValue(String ElementName, String Value) {
		if (ElementName.equals("ContactDetail"))
			elements.inputValue(TextBox_ContactDetail, Value);
		else if (ElementName.equals("Email"))
			elements.inputValue(txt_EditContact_Email, Value);

	}

	public String GetValueFromApplication(String ElementName)
			throws InterruptedException {
		if (ElementName.equals("EmailAddressValue")) {
			Thread.sleep(2000);
			return elements.getElementWithIdentification(txt_EmailAddressValue).getText();

		}

		if (ElementName.equals("PhoneNumberValue")) {
			return elements.getElementWithIdentification(txt_PhoneNumberValue).getText();
		}

		return null;

	}
	
	public void clickonClosebutton() {
		logger.info("Clicking on Close Button on Edit Contacts Overlay");
		elements.waitForElementFluently(Btn_EditContact_CloseButton, 10);
		elements.buttonClick(Btn_EditContact_CloseButton);
	}

	public boolean CheckValue(String ElementName, String Value) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (ElementName.equals("PhoneNumberValue")) {
			if (elements.getElementWithIdentification(lbl_PhoneNumberValue).getText().toLowerCase().trim()
					.equals(Value.toLowerCase().trim())) {
				return true;
			} else {
				return false;
			}
		}

		else if (ElementName.equals("MobileNumberValue")) {
			if (elements.getElementWithIdentification(lbl_MobileNumberValue).getText().toLowerCase().trim()
					.equals(Value.toLowerCase().trim())) {
				return true;
			} else {
				return false;
			}
		}

		else if (ElementName.equals("SearchPage_FaxNumberValue")) {
			if (elements.getElementWithIdentification(txt_FaxNumberValue).getText().toLowerCase().trim()
					.equals(Value.toLowerCase().trim())) {
				return true;
			} else {
				return false;
			}
		}

		else if (ElementName.equals("FaxNumberValue")) {
			if (elements.getElementWithIdentification(lbl_FaxNumberValue).getText().toLowerCase().trim()
					.equals(Value.toLowerCase().trim())) {
				return true;
			} else {
				return false;
			}
		} else if (ElementName.equals("SocialMediaValue")) {
			if (elements.getElementWithIdentification(lbl_SocialMediaValue).getText().toLowerCase().trim()
					.equals(Value.toLowerCase().trim())) {
				return true;
			} else {
				return false;
			}
		} else if (ElementName.equals("WebSiteValue")) {
			if (elements.getElementWithIdentification(lbl_WebSiteValue).getText().toLowerCase().trim()
					.equals(Value.toLowerCase().trim())) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	public boolean CheckRegularExpression(String PatternName) {
		RegularExpressionChecker r = new RegularExpressionChecker("EMAIL");

		if (PatternName.equals("EMAIL")) {
			return r.validate(elements.getElementWithIdentification(txt_EditContact_Email).getAttribute("value"));
		}

		return false;
	}

	public Boolean CheckDownArrow(String string) {
		if (string.equals("Contacts")) {
			return elements.getElementWithIdentification(Link_Contacts_SearchPersonPage).getAttribute("class").equals("accordion-toggle");
		}
		return false;
	}

}

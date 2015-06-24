package com.uspeclipse.pageobjects.person;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uspeclipse.commonservices.GenericActions;

public class EditWarning_pageobjects 
{	
	private WebDriver driver=null;
	private static final Logger logger = Logger.getLogger(EditWarning_pageobjects.class);
	GenericActions elements = null;
	
	public EditWarning_pageobjects(WebDriver driver){
		this.driver=driver;
		elements = new GenericActions(driver);
	}
	
	// Warning Frame
	public final By  WarningPage=By.xpath("//*[starts-with(@id,'yui_')]");
	// Warning Checkboxes
	public final By Warnings=By.xpath("//*[starts-with(@id,'RISK_')]");
	// Warning Note
	public final By  WarningMessageTextArea=By.id("note");
	// Warning Save
	public final By  SaveButton=By.xpath("//*[contains(@class, 'pure-button-primary')]");
	// Warning Cancel
	public final By  CancelButton=By.xpath("//*[contains(@class,'pure-button-secondary')]");
	// Clear Warning
	public final By  ClearWarningButton=By.xpath("//*[contains(@class,'pure-button-text pull-left')]");

	
	// Selecting Warnings from Warning Page
	public void selectWarnings(String WarningsList)
	{	
		elements.waitForElementFluently( WarningPage, 10);
		String[] list = WarningsList.split(",");
		List<String> linklist = new ArrayList<String>();
		List<WebElement> warnings = elements.getElementListWithIdentification(Warnings);
		for(int i=0; i<list.length; i++)		{
			linklist.add(list[i].toString().trim());
		}
		for(WebElement warning : warnings){	
			String warn = warning.getAttribute("aria-label");
			if(linklist.contains(warn)){
				elements.buttonClick(warning);
			}
		}
	}
	
	// Validating Warnings in the Warning Page 
	public boolean verifyWarnings(String WarningsList, String WarningMessage)
	{	
		boolean flag = true;
		elements.waitForElementFluently( WarningMessageTextArea, 10);
		String Message = elements.getElementWithIdentification(WarningMessageTextArea).getAttribute("value");
		String[] list = WarningsList.split(",");
		
		List<String> linklist = new ArrayList<String>();	
		
		for(int i=0; i<list.length; i++)
		{
			linklist.add(list[i].toString().trim());
		}
		List<WebElement> warnings = elements.getElementListWithIdentification(Warnings);
		for(WebElement warning : warnings)
		{	String warn = warning.getAttribute("aria-label");
			if(linklist.contains(warn))
			{
				if(!warning.isSelected())
				{
					flag = false;
					break;
				}
			}
		}
		
		if(flag && Message.equalsIgnoreCase(WarningMessage) )
			return true;
		else
			return false;
	}

	public void inputWarningMessage(String message)
	{
		elements.inputValue(WarningMessageTextArea, message);
	}
	
	public void clickSave()
	{
		elements.buttonClick(SaveButton);
	}
	
	public void clickCancel()
	{
		elements.buttonClick(CancelButton);
	}
	
	public void clearWarning()
	{
		elements.waitForElementFluently( ClearWarningButton, 15);
		elements.buttonClick(ClearWarningButton);
	}
}


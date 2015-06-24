package com.uspeclipse.pageobjects.login;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.uspeclipse.commonservices.GenericActions;
import com.uspeclipse.commonservices.LoginDetails;
import com.uspeclipse.vo.LoginData;

public class InviewLogin_pageobject {
	private WebDriver driver=null;
	private   Logger logger = Logger.getLogger(InviewLogin_pageobject.class);
	GenericActions elements = null;

	public InviewLogin_pageobject(WebDriver driver){
		this.driver=driver;
		elements = new GenericActions(driver);
	}

	private final By InviewUsername=By.id("user_login");
	private final By InviewPassword=By.id("user_pass");
	private final By InviewSubmit=By.id("wp-submit");

	public void enterInviewUsername(String value) {
		elements.waitForElementFluently(InviewUsername,10);
		elements.inputValue(InviewUsername, value);
	}

	public void enterInviewPassword(String value) {
		elements.waitForElementFluently(InviewPassword,10);
		elements.inputValue(InviewPassword, value);
	}

	public void clickonSubmitButtton() {
		elements.waitForElementFluently(InviewSubmit,10);
		elements.buttonClick(InviewSubmit);
	}
	
	public void LoginByRole(String role) throws BiffException, InvalidFormatException, IOException, InterruptedException{
		logger.info("Logging into application with role : " + role);
		LoginData credentials = LoginDetails.getLoginCredentialsByRole(role);
		String username= credentials.getUsername();
		String password = credentials.getPassword();
		
		Thread.sleep(10000);
		
		enterInviewUsername(username);
		enterInviewPassword(password);
		clickonSubmitButtton();
	}
}

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

public class EclipseLogin_pageobject {
	private WebDriver driver=null;
	private   Logger logger = Logger.getLogger(EclipseLogin_pageobject.class);
	GenericActions elements = null;

	public EclipseLogin_pageobject(WebDriver driver){
		this.driver=driver;
		elements = new GenericActions(driver);
	}
	
	private final By EclipseUsername=By.id("username");
	private final By EclipsePassword=By.id("password");
	private final By EclipseSubmit=By.id("loginbutton");
	private final By EclipseLogout=By.xpath("//button[contains(text(),'Log out')]");

	private void enterEclipseUsername(String value) {
		elements.waitForElementFluently(EclipseUsername, 10);
		elements.inputValue(EclipseUsername, value);
	}

	private void enterEclipsePassword(String value) {
		elements.waitForElementFluently(EclipsePassword, 10);
		elements.inputValue(EclipsePassword, value);
	}

	private void clickonSubmitButtton() {
		elements.waitForElementFluently(EclipseSubmit,10);
		elements.buttonClick(EclipseSubmit);
	}

	/*private void EclipseLogin(String username, String password) throws InterruptedException {
		Thread.sleep(5000);		
		enterEclipseUsername(username);
		enterEclipsePassword(password);
		clickonSubmitButtton();
	}*/

	public void EclipseLogout() throws InterruptedException {
		Thread.sleep(5000);
		elements.waitForElementFluently(EclipseLogout,10);
		elements.buttonClick(EclipseLogout);
	}
	
	
	public void LoginByRole(String role) throws BiffException, InvalidFormatException, IOException, InterruptedException{
		logger.info("Logging into application with user role : " + role);
		LoginData credentials = LoginDetails.getLoginCredentialsByRole(role);
		String username= credentials.getUsername();
		String password = credentials.getPassword();
		
		Thread.sleep(5000);		
		
		enterEclipseUsername(username);
		enterEclipsePassword(password);
		clickonSubmitButtton();
	}
	
	public void LoginAgainBySwitchingRole(String role) throws BiffException, InvalidFormatException, IOException, InterruptedException{
		logger.info("Logging into application with user role : " + role);
		LoginData credentials = LoginDetails.getLoginCredentialsByRole(role);
		String username= credentials.getUsername();
		String password = credentials.getPassword();
		
		EclipseLogout();
		
		Thread.sleep(5000);		
		
		enterEclipseUsername(username);
		enterEclipsePassword(password);
		clickonSubmitButtton();
	}
}

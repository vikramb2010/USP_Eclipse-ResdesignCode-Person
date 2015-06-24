/*package com.uspeclipse.setup;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.uspeclipse.commonservices.GenericActions;
import com.uspeclipse.commonservices.LoginDetails;
import com.uspeclipse.commonservices.MultipleBrowser;
import com.uspeclipse.pageobjects.login.EclipseLogin_pageobject;
import com.uspeclipse.pageobjects.login.InviewLogin_pageobject;
import com.uspeclipse.vo.LoginData;

public class Login {
	GenericActions elements = new GenericActions();

	public void inviewLogin(WebDriver driver, String username, String password) {
		InviewLogin_pageobject Login = PageFactory.initElements(driver,
				InviewLogin_pageobject.class);
		// Login.InviewLogin(username, password);
		elements.inputValue(Login.InviewUsername, username);
		elements.inputValue(Login.InviewPassword, password);
		elements.buttonClick(Login.InviewSubmit, driver);
		elements.waitForPageLoaded(driver);
	}

	public void eclipseLogin(WebDriver driver, String username, String password) throws InterruptedException {
		EclipseLogin_pageobject Login = PageFactory.initElements(driver,
				EclipseLogin_pageobject.class);
		// Login.EclipseLogin(username, password);
		Thread.sleep(5000);		
		elements.inputValue(Login.EclipseUsername, username);
		elements.inputValue(Login.EclipsePassword, password);
		elements.buttonClick(Login.EclipseSubmit, driver);
		elements.waitForPageLoaded(driver);
	}

	public void eclipseLogout(WebDriver driver) throws InterruptedException {
		EclipseLogin_pageobject Login = PageFactory.initElements(driver,
				EclipseLogin_pageobject.class);
		// Login.EclipseLogout();
		
		Thread.sleep(5000);		
		elements.waitForElementFluently(MultipleBrowser.driver,
				Login.EclipseLogout, 10);
		elements.buttonClick(Login.EclipseLogout, driver);
	}
	
}



*/
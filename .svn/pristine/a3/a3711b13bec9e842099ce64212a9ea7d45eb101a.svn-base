package com.uspeclipse.setup;

import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertionError;
import org.junit.runner.Result;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.uspeclipse.commonservices.Constants;
import com.uspeclipse.pageobjects.login.EclipseLogin_pageobject;
import com.uspeclipse.pageobjects.login.InviewLogin_pageobject;

public class Initialization  {

	public static String browserName=null;
	static final Logger logger = Logger.getLogger(Initialization.class);

	public void Start(String Browser, WebDriver driver) throws Throwable {
		browserName=Browser;
		InviewLogin_pageobject inviewlogin = PageFactory.initElements(driver, InviewLogin_pageobject.class);
		EclipseLogin_pageobject eclipselogin = PageFactory.initElements(driver, EclipseLogin_pageobject.class);
		logger.info("Test Case Execution Started on: " + Browser);
		driver.get(Constants.getInview_URL());

		if ((!Browser.equalsIgnoreCase("androidE")) && ((!Browser.equalsIgnoreCase("ios-ipad"))) && ((!Browser.equalsIgnoreCase("ios"))) )
			driver.manage().window().maximize();
		else
			Thread.sleep(10000); // Wait 10 seconds to load Emulators for android/ios
	
		logger.info("About to login into Inview application");
		inviewlogin.LoginByRole("Inview");
		Thread.sleep(5000);
		driver.get(Constants.getEclipse_URL());
		logger.info("About to login into Eclipse application");
		eclipselogin.LoginByRole("worker");
	}
	
	
	public void CaptureResults(Result runResult) throws Exception{
		if (!runResult.wasSuccessful()) {
			logger.error("Exception in Test : " + runResult.getFailures().get(0).getDescription().getTestClass());
			if (runResult.getFailures().get(0).getException() instanceof Exception) {
				logger.error("RunTimeException Generated");
				logger.error("Exception Details : "+ runResult.getFailures().get(0).getException());
				throw (Exception) runResult.getFailures().get(0).getException();
			} else {
				logger.error("Assertions Generated");
				logger.error("Exception Details : " + runResult.getFailures());
				throw  (SoftAssertionError)runResult.getFailures().get(0).getException();
			}
		}
	}
}

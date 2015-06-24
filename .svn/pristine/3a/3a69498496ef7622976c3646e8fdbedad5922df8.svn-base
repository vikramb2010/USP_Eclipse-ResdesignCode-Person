package com.uspeclipse.listeners;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class Listeners extends RunListener {
	private static Logger logger = Logger
			.getLogger(Listeners.class);
	
	public void testRunStarted(Description description) throws Exception {
		File file = new File("./target/surefire-reports");

		if (file.exists()) {
			FileUtils.cleanDirectory(new File("./target/surefire-reports"));
		}
	}
	
	
	public void testRunFinished(Result result) throws Exception {
		logger.info("Syncing with saucelabs threads - Before second script starts..");
		Thread.sleep(20000);	
	}

	public void testStarted(Description description) throws Exception {

	}

	public void testFinished(Description description) throws Exception {

		// MultipleBrowser.driver.close();
		// MultipleBrowser.driver.quit();

	}

	public void testFailure(Failure failure) throws Exception {
		
		/*System.out.println("test case fail taking screenshot");
		try {

			String[] methodName = failure.getTestHeader().split("T");
			// String methodName = failure.getTestHeader();
			String browserName = Initialization.browserName;
			String reportTime = new SimpleDateFormat("yyyyMMddHHmmss")
					.format(new Date().getTime());
			String fileName = methodName[0] + "_" + browserName + "_"
					+ reportTime;

			File scrFile = ((TakesScreenshot) MultipleBrowser.driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(
					"ScreenshotCapture/FailedScreenshot/" + fileName + ".png"));
			System.out.println("image captured");
		} catch (Exception ex) {
			ex.printStackTrace();
		}*/

	}

	public void testAssumptionFailure(Failure failure) {

	}

	public void testIgnored(Description description) throws Exception {

	}

}
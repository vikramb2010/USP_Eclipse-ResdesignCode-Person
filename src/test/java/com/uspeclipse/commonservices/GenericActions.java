package com.uspeclipse.commonservices;

import java.awt.AWTException;
import java.awt.Robot;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uspeclipse.setup.Initialization;

public class GenericActions {

	private WebDriver driver=null;

	public GenericActions(WebDriver driver){
		this.driver=driver;
	}
	
	// Method to input value in a text box
	public void inputValue(By identifyBy, String value)
			throws NoSuchElementException {
		WebElement locator= getElementWithIdentification(identifyBy);
		locator.clear();
		locator.sendKeys(value);
	}

	// Method to clear value from a text box
	public void clearValue(By identifyBy) {
		//WebElement locator = getElementWithIdentification(identifyBy);
		driver.findElement(identifyBy).clear();
	}

	// Method to click on a button or a link
	public void buttonClick(By identifyBy ) {
		//WebElement locator = getElementWithIdentification(identifyBy);
		driver.findElement(identifyBy).click();
		//locator.click();
	}
	
	// Method to click on a button or a link
	public void buttonClick(WebElement locator) {
		locator.click();
	}

	// Method to mouse hover on any element on a web page
	public void mouseHover( By identifyBy) {
		WebElement locator = getElementWithIdentification(identifyBy);
		Actions action = new Actions(driver);
		action.moveToElement(locator).build().perform();
	}

	public void offsetClick( By identifyBy, int x, int y) {
		WebElement locator = getElementWithIdentification(identifyBy);
		Actions action = new Actions(driver);
		action.moveToElement(locator, x, y).click().build().perform();
	}

	// Method to select value from drop down based on visible text
	public void selectDropdown(By identifyBy, String value) {
		WebElement locator = getElementWithIdentification(identifyBy);
		Select dropdown = new Select(locator);
		dropdown.selectByVisibleText(value);
	}

	/*
	 * public String getTextFromFirstSelectedOptionInDropdownBox(WebElement
	 * locator){ Select comboBox = new Select(locator);
	 * comboBox.getFirstSelectedOption().getText(); return
	 * getTextFromFirstSelectedOptionInDropdownBox(null); }
	 */

	// Method to get text for any element on a web page
	public String getText(By identifyBy) {
		WebElement locator = getElementWithIdentification(identifyBy);
		return locator.getText();
	}

	public void scrollIntoViewUsingJSExecutor(By identifyBy) {
		// waitForElementToBeClickable
		// scrollPagetoSpecificPoint(driver, xvalue, yvalue);
		// locator.getLocation().x
		// ((JavascriptExecutor)MultipleBrowser.driver).executeScript("arguments[0].scrollIntoView(true);",locator);
	}

	// Method to get the Title of the web page
	public String getTitle() {
		return driver.getTitle();
	}

	public String getAttribute(By identifyBy, String value) {
		WebElement locator = getElementWithIdentification(identifyBy);
		return locator.getAttribute(value);
	}

	public boolean isSelected(By identifyBy) throws NoSuchElementException {
		WebElement locator = getElementWithIdentification(identifyBy);
		return locator.isSelected();
	}

	// webdriver wait
	// Tell webdriver to wait
	public void SeleniumWebdriverwait( long timeInMilliseconds) {
		new WebDriverWait(driver, 10);

	}

	// Method to wait for specific amount of time (forceful wait)
	public void Waitformilliseconds(long timeInMilliseconds) {
		try {
			Thread.sleep(timeInMilliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean isDisplayed(By identifyBy) {
		WebElement locator = getElementWithIdentification(identifyBy);
		return locator.isDisplayed();
	}

	public boolean isEnabled(By identifyBy) {
		WebElement locator = getElementWithIdentification(identifyBy);
		return locator.isEnabled();
	}

	public String getColor(By identifyBy) {
		WebElement locator = getElementWithIdentification(identifyBy);
		String color = locator.getCssValue("color");

		String[] numbers = color.replace("rgba(", "").replace(")", "")
				.split(",");
		int r = Integer.parseInt(numbers[0].trim());
		int g = Integer.parseInt(numbers[1].trim());
		int b = Integer.parseInt(numbers[2].trim());
		String color_locator = (r + "," + g + "," + b);
		return color_locator;
	}

	public Boolean isElementPresent( By identifyBy) {
		try {
			driver.findElement(identifyBy).isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	
	public Boolean isElementPresent(WebElement locator){
		try {
			locator.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public String closeAlertAndGetItsText(
			boolean acceptNextAlert) {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}

	public static void SendKeysXTimes(int keyCode, int XTimes) {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		for (int i = 1; i <= XTimes; i++) {
			robot.keyPress(keyCode);
		}
	}

	public void waitForPageLoaded() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript(
						"return document.readyState").equals("complete");
			}
		};

		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		try {
			wait.until(expectation);
		} catch (Throwable error) {

		}
	}

	public void waitForElementFluently( By identifyBy,int seconds) {
		int retry = 0;
		int retryCount = seconds < 25 ? 2 : 1;
		while (retry < retryCount) {
			try {
				Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
						.withTimeout(seconds, TimeUnit.SECONDS)
						.pollingEvery(200, TimeUnit.MILLISECONDS);
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(identifyBy)));
			} catch (Exception ex) {

			}
			retry++;
		}

		/*
		 * final long startTime = System.currentTimeMillis();
		 * 
		 * Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		 * .withTimeout(seconds, TimeUnit.SECONDS) .pollingEvery((seconds / 5),
		 * TimeUnit.SECONDS) .ignoring(StaleElementReferenceException.class);
		 * 
		 * int tries = 0; int retryCount = 5; boolean found = false; WebElement
		 * we = null;
		 * 
		 * while (tries < retryCount) { // logger.info( //
		 * "Wait for element "+locator.toString()+" Try number " + (tries++) //
		 * );
		 * 
		 * try { we = wait.until(ExpectedConditions.visibilityOf(locator)); we =
		 * wait.until(ExpectedConditions .elementToBeClickable(locator));
		 * 
		 * found = true; // attempt a find to check that staleException is not
		 * going to // be thrown break; } catch (Exception e) { // logger.info(
		 * "Exception in waitForElementFluently: \n" + // e.getMessage() +
		 * "\n"); } }
		 */
	}

	public void waitForData( By identifyBy, int seconds,String text) {
		WebElement locator = getElementWithIdentification(identifyBy);
		Wait<WebDriver> wait = (new WebDriverWait(driver, seconds));
		wait.until(ExpectedConditions.textToBePresentInElement(locator, text));
	}

	public void waitForElementToBeClickable(By identifyBy, int seconds) {
		WebElement locator = getElementWithIdentification(identifyBy);
		Wait<WebDriver> wait = (new WebDriverWait(driver, seconds));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void scrollPageUp() {
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollTo(0, 0);");
		Actions clicker = new Actions(driver);
		clicker.sendKeys(Keys.PAGE_UP);

	}

	public void scrollPageDown() {
		Actions clicker = new Actions(driver);
		clicker.sendKeys(Keys.PAGE_DOWN);
	}

	public void scrollPagetoSpecificPoint( String xvalue,
			String yvalue) {
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(" + xvalue + "," + yvalue + ")", "");
	}

	public boolean checkDropDownOptions(By identifyBy,
			List<String> stringlist) {
		List<WebElement> webelementlist = getElementListWithIdentification(identifyBy);
		List<WebElement> dropdownoptions = webelementlist;
		boolean result = false;
		List<String> type = stringlist;
		int i = 0;
		for (WebElement options : dropdownoptions) {
			if ((options.getText()).equals(type.get(i).toString())) {
				result = true;
			}
			i++;
		}
		return result;
	}

	public boolean isEmpty(By identifyBy) {
		WebElement locator = getElementWithIdentification(identifyBy);
		if ((locator.getText()).equals(""))
			return true;
		return false;
	}

	public void DragDrop( WebElement source, WebElement target) {
		Actions builder = new Actions(driver);
		builder.dragAndDrop(source, target).build().perform();
	}

	// Method to Press Enter Key
	public void pressEnterKey() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
	}

	// Method to double click
	public void doubleclick() {
		Actions action = new Actions(driver);
		action.doubleClick().build().perform();

	}

	public void pressTab() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
	}

	public void pressshiftandtab() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.chord(Keys.SHIFT), Keys.chord(Keys.TAB)).build()
				.perform();

	}

	public String getDateParameters(String ElementName) {
		Calendar cal = Calendar.getInstance();
		String Month = new SimpleDateFormat("MMM").format(cal.getTime());
		String Year = new SimpleDateFormat("yyyy").format(cal.getTime());
		String Day = new SimpleDateFormat("dd").format(cal.getTime());
		String Hour = new SimpleDateFormat("HH").format(cal.getTime());
		String Min = new SimpleDateFormat("mm").format(cal.getTime());
		cal.add(Calendar.DAY_OF_MONTH, 1);
		String Day1 = new SimpleDateFormat("dd").format(cal.getTime());

		if (ElementName.equals("Year"))
			return Year;
		if (ElementName.equals("Month"))
			return Month;
		if (ElementName.equals("Day"))
			return Day;
		if (ElementName.equals("NextDay"))
			return Day1;
		if (ElementName.equals("Hour"))
			return Hour;
		if (ElementName.equals("Min"))
			return Min;

		return null;
	}

	public void inputValueinRichTextbox( By identifyBy,String value) {
		WebElement locator = getElementWithIdentification(identifyBy);
		((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML='"
				+ value + "';", locator);
	}
	
	public void inputValueUsingInnerHTML(By identifyBy,String value) {
		WebElement locator = getElementWithIdentification(identifyBy);
		Waitformilliseconds(3000);
		if (Initialization.browserName.trim().equals("ios-ipad")) {
			value = value.replace("\n", "<br/>");
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].innerHTML='" + value + "';", locator);
			
		} else {
			inputValue(identifyBy, value);
		}
	}

	public void pressCtrlKey() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.CONTROL).build().perform();
	}

	public void pressBackSpaceKey() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.BACK_SPACE).build().perform();
	}
	
	public WebElement getElementWithIdentification( By identifyBy ){
		 //(new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(driver.findElement(identifyBy)));
		 return driver.findElement(identifyBy);
	}
	
	public List<WebElement> getElementListWithIdentification( By identifyBy ){
		 //(new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(driver.findElement(identifyBy)));
		 return driver.findElements(identifyBy);
	}
}

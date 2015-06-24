package com.uspeclipse.commonservices;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MultipleBrowser {
	private static final Logger logger = Logger
			.getLogger(MultipleBrowser.class);

	@SuppressWarnings("static-access")
	public WebDriver getBrowserDriver(String browser, String testName) {
		DesiredCapabilities capability = null;
		WebDriver driver = null;
		DesiredCapabilities cap;
		logger.info("About to create DRIVER object for browser : " + browser);

		try {
			if ((Constants.isGridRequired()).equals("local")) {
				logger.info("Executing scripts WITHOUT using grid");

				switch (browser.toLowerCase()) {
				case "firefox":
					driver = new FirefoxDriver();
					driver.manage().timeouts()
							.implicitlyWait(30, TimeUnit.SECONDS);
					break;
				case "ie10":
					System.setProperty("webdriver.ie.driver",
							"src/test/java/Library/IEDriverServer.exe");
					driver = new InternetExplorerDriver();
					driver.manage().timeouts()
							.implicitlyWait(30, TimeUnit.SECONDS);
					break;
				case "ie11":
					System.setProperty("webdriver.ie.driver",
							"src/test/java/Library/IEDriverServer.exe");
					//driver = new InternetExplorerDriver();
					DesiredCapabilities d = DesiredCapabilities.internetExplorer();
					d.setCapability("nativeEvents", false);
					driver = new InternetExplorerDriver(d);
					driver.manage().timeouts()
							.implicitlyWait(30, TimeUnit.SECONDS);
					break;
				case "chrome":
					System.setProperty("webdriver.chrome.driver",
							"src/test/java/Library/chromedriver.exe");
					driver = new ChromeDriver();
					driver.manage().timeouts()
							.implicitlyWait(30, TimeUnit.SECONDS);
					break;
				case "android":
					/*
					 * capability = new DesiredCapabilities();
					 * capability.setCapability("automationName", "Selendroid");
					 * capability.setCapability("platformName", "Android");
					 * capability.setCapability("platformVersion", "4.3");
					 * capability.setCapability("deviceName", "HM 1S"); driver =
					 * new RemoteWebDriver(new
					 * URL("http://127.0.0.1:4500/wd/hub"), capability);
					 * driver.manage().timeouts().implicitlyWait(10,
					 * TimeUnit.SECONDS);
					 */
					break;
				case "ios":
					capability = new DesiredCapabilities();
					capability.setCapability(CapabilityType.BROWSER_NAME,
							"safari");
					capability.setCapability(CapabilityType.PLATFORM,
							Platform.MAC);
					capability.setCapability("name", testName + "_IOS_MAC");
					driver = new RemoteWebDriver(new URL(Constants.node_URL),
							capability);
					driver.manage().timeouts()
							.implicitlyWait(30, TimeUnit.SECONDS);
					break;
				case "ios-ipad":
					capability = new DesiredCapabilities();
					capability.setCapability("platformName", "iOS");
					capability.setCapability("platformVersion", "8.0");
					capability.setCapability("deviceName", "iPad Simulator");
					capability.setCapability("browserName", "safari");
					driver = new RemoteWebDriver(new URL(
							"http://127.0.0.1:4723/wd/hub"), capability);
					driver.manage().timeouts()
							.implicitlyWait(40, TimeUnit.SECONDS);
					break;
				case "androide":
					capability = new DesiredCapabilities();
					capability.setCapability("platformName", "android");
					capability.setCapability("platformVersion", "5.1");
					capability.setCapability("browserName", "android");
					capability.setCapability("deviceName", "Nexus10");
					capability.setCapability("appiumVersion", "1.4.0");
					capability.setCapability("name", testName + "_ANDROID");
					driver = new RemoteWebDriver(new URL(
							"http://127.0.0.1:4723//wd/hub"), capability);
					driver.manage().timeouts()
							.implicitlyWait(60, TimeUnit.SECONDS);
					break;
				default:
					driver = null;
				}
			}

			else if ((Constants.isGridRequired()).equals("sauce")) {
				logger.info("Executing scripts WITH using grid on sauce");
				switch (browser.toLowerCase()) {
				case "firefox":
					capability = new DesiredCapabilities().firefox();
					capability.setCapability("platform", "Windows 7");
					capability.setCapability("version", "35.0");
					capability.setCapability("screen-resolution", "1280x800");
					capability.setCapability("name", testName + "_firefox");
					driver = new RemoteWebDriver(new URL(Constants.node_URL),
							capability);
					driver.manage().timeouts()
							.implicitlyWait(30, TimeUnit.SECONDS);
					break;
				case "ie10":
					capability = new DesiredCapabilities().internetExplorer();
					capability.setCapability("platform", "Windows 7");
					capability.setCapability("version", "10.0");
					capability.setCapability("screen-resolution", "1280x800");
					capability.setCapability("name", testName + "_ie10");
					driver = new RemoteWebDriver(new URL(Constants.node_URL),
							capability);
					driver.manage().timeouts()
							.implicitlyWait(30, TimeUnit.SECONDS);
					break;
				case "ie11":
					capability = new DesiredCapabilities().internetExplorer();
					capability.setCapability("platform", "Windows 7");
					capability.setCapability("version", "11.0");
					capability.setCapability("screen-resolution", "1280x800");
					capability.setCapability("name", testName + "_ie11");
					driver = new RemoteWebDriver(new URL(Constants.node_URL),
							capability);
					driver.manage().timeouts()
							.implicitlyWait(30, TimeUnit.SECONDS);
					break;
				case "chrome":
					capability = new DesiredCapabilities().chrome();
					capability.setCapability("platform", "Windows 7");
					capability.setCapability("version", "43.0");
					capability.setCapability("screen-resolution", "1280x800");
					capability.setCapability("name", testName + "_chrome");
					driver = new RemoteWebDriver(new URL(Constants.node_URL),
							capability);
					driver.manage().timeouts()
							.implicitlyWait(30, TimeUnit.SECONDS);
					break;
				case "android":
					capability = new DesiredCapabilities();
					capability.setCapability("automationName", "Selendroid");
					capability.setCapability("platformName", "Android");
					capability.setCapability("platformVersion", "4.3");
					capability.setCapability("deviceName", "HM 1S");
					driver = new RemoteWebDriver(new URL(
							"http://127.0.0.1:4500/wd/hub"), capability);
					driver.manage().timeouts()
							.implicitlyWait(10, TimeUnit.SECONDS);
					break;
				case "ios":
					capability = new DesiredCapabilities();
					capability.setCapability(CapabilityType.BROWSER_NAME,
							"safari");
					capability.setCapability(CapabilityType.PLATFORM,
							Platform.MAC);
					capability.setCapability("name", testName + "_IOS_MAC");
					driver = new RemoteWebDriver(new URL(Constants.node_URL),
							capability);
					driver.manage().timeouts()
							.implicitlyWait(10, TimeUnit.SECONDS);
					break;
				case "ios-ipad":
					capability = new DesiredCapabilities();
					capability.setCapability("platformName", "iOS");
					capability.setCapability("platformVersion", "8.1");
					capability.setCapability("browserName", "safari");
					capability.setCapability("deviceName", "iPad Simulator");
					capability.setCapability("name", testName + "_IPAD");
					capability.setCapability("appiumVersion", "1.3.6");
					driver = new RemoteWebDriver(new URL(Constants.node_URL),
							capability);
					driver.manage().timeouts()
							.implicitlyWait(40, TimeUnit.SECONDS);
					break;
				case "ios-ipad-mini":
					capability = DesiredCapabilities.iphone();
					capability.setCapability("platform", "OS X 10.10");
					capability.setCapability("version", "7.0");
					capability.setCapability("deviceName", "iPad Simulator");
					capability.setCapability("device-orientation", "portrait");
					capability.setCapability("name", testName + "_IPAD Mini");
					capability.setCapability("appiumVersion", "1.3.6");
					driver = new RemoteWebDriver(new URL(Constants.node_URL),
							capability);
					driver.manage().timeouts()
							.implicitlyWait(60, TimeUnit.SECONDS);
					break;
				case "androide":
					capability = new DesiredCapabilities();
					capability.setCapability("platformName", "android");
					capability.setCapability("platformVersion", "4.4");
					capability.setCapability("browserName", "browser");
					capability.setCapability("deviceName",
							"Google Nexus 7 HD Emulator");
					capability.setCapability("appiumVersion", "1.2.2");
					capability.setCapability("name", testName + "_ANDROID");
					driver = new RemoteWebDriver(new URL(Constants.node_URL),
							capability);
					driver.manage().timeouts()
							.implicitlyWait(60, TimeUnit.SECONDS);
					break;

				case "android-browserstack":
					final String USERNAME = "sankettalaviya1";
					final String AUTOMATE_KEY = "ceQmP1WyX8ysJ3pVbEJg";
					final String URL = "http://" + USERNAME + ":"
							+ AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
					capability = new DesiredCapabilities();
					capability = new DesiredCapabilities();
					capability.setCapability("platfrom", "ANDROID");
					capability.setCapability("browserName", "android");
					capability.setCapability("device",
							"Samsung Galaxy Tab 4 10.1");
					capability.setCapability("browser", "Android");
					capability.setCapability("os", "android");
					capability.setCapability("deviceOrientation", "landscape");
					capability.setCapability("browserstack.debug", "true");
					driver = new RemoteWebDriver(new URL(URL), capability);
					driver.manage().timeouts()
							.implicitlyWait(60, TimeUnit.SECONDS);
					break;
				default:
					driver = null;
				}
			} else if ((Constants.isGridRequired()).equals("grid")) {
				logger.info("Executing scripts WITH using grid");
				switch (browser.toLowerCase()) {
				case "firefox":
					capability = new DesiredCapabilities().firefox();
					capability.setBrowserName("firefox");
					capability.setPlatform(Platform.WINDOWS);
					capability.setVersion("37.0.1");
					driver = new RemoteWebDriver(new URL(Constants.hub_URL),
							capability);
					driver.manage().timeouts()
							.implicitlyWait(30, TimeUnit.SECONDS);
					break;
				case "ie10":
					capability = new DesiredCapabilities().internetExplorer();
					capability.setBrowserName("internet explorer");
					capability.setPlatform(Platform.WINDOWS);
					capability.setCapability("nativeEvents", false);
					capability.setVersion("10");
					driver = new RemoteWebDriver(new URL(Constants.hub_URL),
							capability);
					driver.manage().timeouts()
							.implicitlyWait(30, TimeUnit.SECONDS);
					break;
				case "ie11":
					capability = new DesiredCapabilities().internetExplorer();
					capability.setBrowserName("internet explorer");
					capability.setPlatform(Platform.WINDOWS);
					capability.setCapability("nativeEvents", false);
					capability.setVersion("11");
					driver = new RemoteWebDriver(new URL(Constants.hub_URL),
							capability);
					driver.manage().timeouts()
							.implicitlyWait(30, TimeUnit.SECONDS);
					break;
				case "chrome":
					capability = new DesiredCapabilities().chrome();
					capability.setBrowserName("chrome");
					capability.setPlatform(Platform.WINDOWS);
					capability.setVersion("43.0");
					driver = new RemoteWebDriver(new URL(Constants.hub_URL),
							capability);
					driver.manage().timeouts()
							.implicitlyWait(30, TimeUnit.SECONDS);
					break;
				case "ios-ipad":
					capability = new DesiredCapabilities();
					capability.setCapability("platformName", "iOS");
					capability.setCapability("platform", "MAC");
					capability.setCapability("platformVersion", "8.0");
					capability.setCapability("deviceName", "iPad Simulator");
					capability.setCapability("browserName", "iPad2");
					driver = new RemoteWebDriver(new URL(Constants.hub_URL),
							capability);
					driver.manage().timeouts()
							.implicitlyWait(40, TimeUnit.SECONDS);
					break;
				default:
					driver = null;
				}
			}
		} catch (Exception ex) {
			logger.error("Error occured while creating DRIVER object");
			logger.error(ex.getMessage());
			return null;
		}
		return driver;
	}
}

package com.uspeclipse.commonservices;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class Constants {
	private static final Logger logger = Logger.getLogger(Constants.class);
	private static String inview_URL;

	public static String getInview_URL() {
		inview_URL = System.getProperty("inviewURL",
				ReadPropertiesFile.getProperty("default.aut.url"));
		return inview_URL;
	}

	// Eclipse URL
	private static String eclipse_URL;

	public static String getEclipse_URL() {
		eclipse_URL = System.getProperty("eclipseURL",
				ReadPropertiesFile.getProperty("default.aut.url1"));
		return eclipse_URL;
	}

	// Switch to use Local Browser or Grid
	private static String useremotebrowser;

	public static String isGridRequired() {
		useremotebrowser = System.getProperty("UseGrid",
				ReadPropertiesFile.getProperty("selenium.remote.server"));
	//	logger.info("Grid Required : " + useremotebrowser);
		return useremotebrowser;
	}

	// Browsers to run test cases
	private static String browsers;
	private static String[] totalBrowsers;
	private static List<Object[]> browserList = new ArrayList<Object[]>();

	public static List<Object[]> getAllBrowsers() {
		browserList.clear();
		browsers = System.getProperty("Browser",
				ReadPropertiesFile.getProperty("Browsers"));
		totalBrowsers = browsers.split(",");
		for (String browser : totalBrowsers) {
			browserList.add(new String[] { browser });
		}
		return browserList;
	}

	// Grid configuration URL
	public static final String node_URL = ReadPropertiesFile
			.getProperty("default.grid.url");

	// Grid configuration URL
	public static final String hub_URL = ReadPropertiesFile
			.getProperty("default.hub.url");

	// Path for the Test Data
	public static final String TestDataPath = ReadPropertiesFile
			.getProperty("default.testdata.path");

	// Name of the Report file
	public static final String reportFileName = ReadPropertiesFile
			.getProperty("default.report.name");
}

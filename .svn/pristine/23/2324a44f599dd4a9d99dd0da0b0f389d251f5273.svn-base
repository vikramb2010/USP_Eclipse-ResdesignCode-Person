package com.uspeclipse.dataprovider.casenotes;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.uspeclipse.commonservices.Constants;
import com.uspeclipse.commonservices.ReturnDataObject;
import com.uspeclipse.setup.LoggerHelper;


public class DateFilter_dataprovider {

	
	
	@DataProvider
	public static Object[][] DateFilter() throws IOException {
		ReturnDataObject returnData1 = new ReturnDataObject();
		String path = Constants.TestDataPath + "casenotes";
		return returnData1.read(path + "/DateFilter.xls");
	}
	
	
	
	
	
}

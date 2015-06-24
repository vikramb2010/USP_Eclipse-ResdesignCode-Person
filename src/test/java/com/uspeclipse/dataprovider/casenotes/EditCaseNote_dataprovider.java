package com.uspeclipse.dataprovider.casenotes;

import java.io.IOException;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.uspeclipse.commonservices.Constants;
import com.uspeclipse.commonservices.ReturnDataObject;

public class EditCaseNote_dataprovider {
	@DataProvider
	public static Object[][] EditCase() throws IOException {
		ReturnDataObject returnData1 = new ReturnDataObject();
		String path = Constants.TestDataPath + "casenotes";
		return returnData1.read(path + "/EditCaseNote.xls");
	}
	
	@DataProvider
	public static Object[][] EditCompleteCase() throws IOException {
		ReturnDataObject returnData1 = new ReturnDataObject();
		String path = Constants.TestDataPath + "casenotes";
		return returnData1.read(path + "/EditCompleteCaseNote.xls");
	}
}

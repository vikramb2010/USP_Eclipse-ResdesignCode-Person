package com.uspeclipse.dataprovider.casenotes;

import java.io.IOException;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.uspeclipse.commonservices.Constants;
import com.uspeclipse.commonservices.ReturnDataObject;

public class CompleteCaseNote_dataprovider {
	@DataProvider
	public static Object[][] CompleteCaseNote() throws IOException {
		ReturnDataObject returnData1 = new ReturnDataObject();
		String path = Constants.TestDataPath + "casenotes";
		return returnData1.read(path + "/CompleteCaseNote.xls");
	}
}
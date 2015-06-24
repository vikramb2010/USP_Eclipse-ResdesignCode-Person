package com.uspeclipse.dataprovider.person;

import java.io.IOException;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.uspeclipse.commonservices.Constants;
import com.uspeclipse.commonservices.ReturnDataObject;

public class AddReferenceNumber_dataprovider {
	@DataProvider
	public static Object[][] ReferenceNumber() throws IOException {
		ReturnDataObject returnData1 = new ReturnDataObject();
		String path = Constants.TestDataPath + "person";
		return returnData1.read(path
				+ "/AddReferenceNumber.xls");
	}
}

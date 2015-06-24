package com.uspeclipse.dataprovider.login;

import java.io.IOException;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.uspeclipse.commonservices.Constants;
import com.uspeclipse.commonservices.ReturnDataObject;

public class InviewLogin_dataprovider {

	@DataProvider
	public static Object[][] User() throws IOException {
		ReturnDataObject returnData1 = new ReturnDataObject();
		String path = Constants.TestDataPath + "login";
		return returnData1.read(path + "/Login.xls");
	}

}
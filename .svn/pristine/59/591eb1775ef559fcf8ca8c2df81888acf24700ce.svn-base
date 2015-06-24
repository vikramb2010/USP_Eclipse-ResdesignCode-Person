package com.uspeclipse.dataprovider.person;

import java.io.IOException;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.uspeclipse.commonservices.Constants;
import com.uspeclipse.commonservices.ReturnDataObject;

public class AddPersonAddress_dataprovider {
	
	@DataProvider
	public static Object[][] PersonAddressdetails() throws IOException {
		ReturnDataObject returnData1 = new ReturnDataObject();
		String path = Constants.TestDataPath + "person";
		return returnData1.read(path + "/AddPersonAddresswhenlocationexists.xls");

}
	
	@DataProvider
	public static Object[][] AddPersonAddressDetailsWhenLocationIsNotPresent() throws IOException {
		ReturnDataObject returnData1 = new ReturnDataObject();
		String path = Constants.TestDataPath + "person";
		return returnData1.read(path + "/Addpersonaddresswhenlocationdoesnotexists.xls");

	}
		@DataProvider
		public static Object[][] AddAddress() throws IOException {
			ReturnDataObject returnData1 = new ReturnDataObject();
			String path = Constants.TestDataPath + "person";
			return returnData1.read(path + "/AddAddress.xls");	
}
	
	
	

}
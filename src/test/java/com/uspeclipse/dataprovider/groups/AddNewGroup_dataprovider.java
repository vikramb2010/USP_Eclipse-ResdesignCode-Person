package com.uspeclipse.dataprovider.groups;
import java.io.IOException;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.uspeclipse.commonservices.Constants;
import com.uspeclipse.commonservices.ReturnDataObject;

public class AddNewGroup_dataprovider {
	
	@DataProvider
	public static Object[][] Groupdetails() throws IOException {
		ReturnDataObject returnData1 = new ReturnDataObject();
		String path = Constants.TestDataPath + "groups";
		return returnData1.read(path + "/AddGroup.xls");
	}
	
	

}







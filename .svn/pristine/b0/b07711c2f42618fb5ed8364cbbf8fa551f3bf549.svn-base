package com.uspeclipse.commonservices;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jxl.read.biff.BiffException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.uspeclipse.vo.LoginData;

public class LoginDetails {

	private static final LoginDetails singleton = new LoginDetails();
	private static final List<LoginData> credentials = new ArrayList<LoginData>();
	private static final String absolutePath = Constants.TestDataPath + "login" + "/Login.xls";

	private LoginDetails() {
	}

	public static synchronized LoginData getLoginCredentialsByRole(
			String role) throws BiffException, InvalidFormatException, IOException {
		if (credentials.size() == 0) {
			singleton.getDatafromExcel();
		}
		for (LoginData elem : credentials) {
			if(elem.getUserrole().equals(role)){
				return elem;
			}
		}
		return null;
	}


	private void getDatafromExcel() throws IOException, BiffException, InvalidFormatException {
		org.apache.poi.ss.usermodel.Workbook workbook = WorkbookFactory.create(new File(absolutePath));
		org.apache.poi.ss.usermodel.Sheet firstSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = firstSheet.iterator();
		LoginData loginData = null;
		
		//skipping header row
		iterator.next();
		while (iterator.hasNext()) {
			Row row = iterator.next();
			loginData = new LoginData();
			Iterator<Cell> cellIterator = row.cellIterator();
			
			loginData.setUserrole(cellIterator.next().getStringCellValue().toString());
			loginData.setUsername(cellIterator.next().getStringCellValue().toString());
			loginData.setPassword(cellIterator.next().getStringCellValue().toString());
			
			credentials.add(loginData);
		}
		workbook.close();
	}
}


package com.uspeclipse.commonservices;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReturnDataObject {

	private String inputFile = "";
	String[][] data = null;
	Object[][] obj;

	public Object[][] read(String filePath) throws IOException {
		inputFile = filePath;
		File inputWorkbook = new File(inputFile);
		Workbook w;
		try {
			w = Workbook.getWorkbook(inputWorkbook);
			// Get the first sheet
			Sheet sheet = w.getSheet(0);
			data = new String[sheet.getRows() - 1][sheet.getColumns()];

			for (int i = 1; i < sheet.getRows(); i++) {
				for (int j = 0; j < sheet.getColumns(); j++) {
					Cell cell = sheet.getCell(j, i);
					// System.out.println(cell.getContents());
					data[i - 1][j] = cell.getContents();

				}

				obj = data;
			}

		} catch (BiffException e) {
			e.printStackTrace();
		}
		return obj;
	}

}
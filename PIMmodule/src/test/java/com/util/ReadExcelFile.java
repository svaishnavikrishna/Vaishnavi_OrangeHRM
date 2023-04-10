package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile extends ReadPropertiesFile {

	public HashMap<String, String> readTestDataExcel() throws Exception {

		String filePath = testDataInputPath();

		File file = new File(filePath);

		FileInputStream fis;
		fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet ws = wb.getSheet("Data");

		HashMap<String, String> map = new HashMap<String, String>();

		for (int r = 0; r <= ws.getLastRowNum(); r++) {
			String key = ws.getRow(r).getCell(0).getStringCellValue();
			String value = ws.getRow(r).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		
		return map;
	}

}

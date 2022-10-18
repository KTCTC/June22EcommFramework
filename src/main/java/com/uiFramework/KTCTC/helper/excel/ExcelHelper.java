package com.uiFramework.KTCTC.helper.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
	private XSSFSheet sh;

	public ExcelHelper(String fileName, String sheetName) {
		try {
			File f = new File(System.getProperty("user.dir") + "\\" + fileName);
			FileInputStream fis = new FileInputStream(f);

			XSSFWorkbook wb = new XSSFWorkbook(fis);

			sh = wb.getSheet(sheetName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<String> getKeysList() {
		ArrayList<String> keys = new ArrayList<>();

		for (int i = 1; i <= sh.getLastRowNum(); i++) {
			XSSFRow row = sh.getRow(i);
			XSSFCell cel = row.getCell(0);
			String keyy = getValueOfCellAccordingToCellType(cel);
			cel = row.getCell(1);
			keys.add(keyy);

		}

		return keys;
	}

	public ArrayList<String> getValuesList() {
		ArrayList<String> values = new ArrayList<>();

		for (int i = 1; i <= sh.getLastRowNum(); i++) {
			XSSFRow row = sh.getRow(i);
			XSSFCell cel = row.getCell(1);
			String val = getValueOfCellAccordingToCellType(cel);
			cel = row.getCell(1);
			values.add(val);

		}

		return values;
	}

	public ArrayList<String> getColumnList(int columnNumber) {
		ArrayList<String> values = new ArrayList<>();

		for (int i = 1; i <= sh.getLastRowNum(); i++) {
			XSSFRow row = sh.getRow(i);
			XSSFCell cel = row.getCell(columnNumber);
			String val = getValueOfCellAccordingToCellType(cel);
			cel = row.getCell(1);
			values.add(val);

		}

		return values;
	}

	public HashMap<String, String> getKeyValuePair() {
		HashMap<String, String> data = new HashMap<>();
		for (int i = 1; i <= sh.getLastRowNum(); i++) {
			XSSFRow row = sh.getRow(i);
			XSSFCell cel = row.getCell(0);
			String keyy = getValueOfCellAccordingToCellType(cel);
			cel = row.getCell(1);
			String val = getValueOfCellAccordingToCellType(cel);

			data.put(keyy, val);

		}

		return data;
	}

	@SuppressWarnings("deprecation")
	private  static String getValueOfCellAccordingToCellType(XSSFCell cel) {
		Object dd = null;
		switch (cel.getCellType()) {
		case STRING:
			dd = cel.getStringCellValue();

			break;
		case BOOLEAN:
			dd = cel.getBooleanCellValue();

			break;
		case NUMERIC:
			dd = cel.getNumericCellValue();

			break;
		case FORMULA:
			dd = cel.getCellFormula();

			break;
		case BLANK:
			System.out.println("Cell does not have anything");

			break;
		default:
			System.out.println("We do not have cell type case written");
			break;
		}

		return dd.toString();
	}

}

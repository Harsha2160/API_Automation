package com.qa.API.DataDriven;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations {
	public static Object[][] arr = null;

	private static FileInputStream file = null;
	private static XSSFWorkbook Workbook = null;
	private static XSSFSheet sheet = null;
	private static FileOutputStream fileout = null;

	public static Object[][] Read(String path, String Sheet_name) throws IOException

	    {
		file = new FileInputStream(path);
		Workbook = new XSSFWorkbook(file);
		sheet = Workbook.getSheet(Sheet_name);
		arr = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int j = 0; j < sheet.getLastRowNum(); j++) 
	    {
		Row r = sheet.getRow(j + 1);
		for (int k = 0; k < sheet.getRow(j).getLastCellNum(); k++) 
		{
		CellType ct = r.getCell(k).getCellTypeEnum();
		if (ct.equals(CellType.STRING))
		arr[j][k] = r.getCell(k).getStringCellValue();
		else 
		{
		Double d = r.getCell(k).getNumericCellValue();
		double da = (double) d;
		long number = (long) da;
		arr[j][k] = number;
				
		}
        }
		}
		return arr;
        }
	
	//Write operation is optional as per the design
	
	public static void Write(String S, String Sheet_name) throws IOException 
	    {
		XSSFSheet Sheet = Workbook.createSheet(Sheet_name);
		Row row = Sheet.createRow(0);
		row.createCell(0).setCellValue("String to be Written");
		Row r = Sheet.createRow(1);
		Cell c = r.createCell(0, CellType.STRING);
		c.setCellValue(S);
		fileout = new FileOutputStream(ObjectArray_Input.path);
		Workbook.write(fileout);
		fileout.close();

	    }
        }

package com.genericlib.demoblaze;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	// Code to read a Data from Excel File

	String ProPath = "TestData/TestData.properties";

	public String getDataFromproperties(String key) throws IOException {
		FileInputStream ip = new FileInputStream(ProPath);
		Properties prop = new Properties();
		prop.load(ip);
		return prop.getProperty(key);

	}

	public String[][] getDataFromExcel(String sheet) throws Throwable//String path,
	{
		FileInputStream ip = new FileInputStream("TestData/test.xlsx");
		Workbook wb = WorkbookFactory.create(ip);
		Sheet sh = wb.getSheet(sheet); // get ss model not sl to import
		int rows = sh.getLastRowNum();// total number of row available in sheet
		int cell = sh.getRow(0).getLastCellNum();
		System.out.println(rows+" "+cell);
		String arr[][] = new String[rows][cell];

		for (int i = 0; i < rows; i++) // for total number of rows
		{
			for (int j = 0; j < cell; j++) // for total number of column 
			{

				arr[i][j] = sh.getRow(i).getCell(j).toString();
		   }
	}
		return arr;

}
}

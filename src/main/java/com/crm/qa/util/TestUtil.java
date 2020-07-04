package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	//Static variable which can be used in any class//
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	public static Workbook book;
	public static Sheet sheet;
	public static String excelFilePath = "C:/Users/USER/workspace/FreeCRMTest/src/main/java/com/crm/qa/testdata/FreeCRMDataSheet.xlsx";
	
	//Switch to Iframe//
	
	public void switchToFrame(){
		driver.switchTo().frame("mainpanel");
	}
	
	//Data Provider Code//
	
	public static Object[][] dataProviderCode(String sheetName){
		
		FileInputStream file = null;
		
		try {
			file = new FileInputStream(excelFilePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book= WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		
		Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sheet.getLastRowNum(); i++){
			for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++){
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
	
	//Screen shot code for failed test cases//
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	
	
	
	
	

}

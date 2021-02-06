package com.qa.testdata;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class TestDatafromExcel {

	XSSFWorkbook wb;
	XSSFSheet sh;
	
	public TestDatafromExcel() {
		
		try {
		File file=new File("C:\\RK\\SeleniumFiles\\InputFile_Testdata.xlsx");
		FileInputStream fip = new FileInputStream(file);
		wb= new XSSFWorkbook(fip);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public String getData(int sheetNum, int row, int column){
		sh=wb.getSheetAt(sheetNum);
		String data= sh.getRow(row).getCell(column).getStringCellValue();
		return data;
	}	
	
}

package com.rakesh.selenium.selenium_with_java;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class _29_writing_excel_withsel {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file = new FileOutputStream("C:\\Users\\shubh\\Documents\\GitHub\\Selenium-with-Java\\selenium-with-java\\p excel files\\selenium excel p-2.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("Data");
		
		XSSFRow row1 = sheet.createRow(0);
			row1.createCell(0).setCellValue("1st cell");
			row1.createCell(1).setCellValue("2nd cell");
		
		XSSFRow row2 = sheet.createRow(1);
			row2.createCell(0).setCellValue("3rd cell");
			row2.createCell(1).setCellValue("4th cell");
			
		workbook.write(file);
		workbook.close();
		file.close();
		
		if(file != null) {
			System.out.println("excel file create.....");
		}

	}

}

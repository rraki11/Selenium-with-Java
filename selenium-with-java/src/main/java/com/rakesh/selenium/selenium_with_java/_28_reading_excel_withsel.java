package com.rakesh.selenium.selenium_with_java;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class _28_reading_excel_withsel {

	public static void main(String[] args) throws IOException {
		
//		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\p excel files\\selenium excel p-1.xlsx");
		
		FileInputStream file = new FileInputStream("C:\\Users\\shubh\\Documents\\selenium excel p-1.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int total_rows = sheet.getLastRowNum(); //counting of rows starts from 0
		int total_cells = sheet.getRow(0).getLastCellNum(); //counting of cells start from 1
		
		System.out.println("total_rows: "+ total_rows);
		System.out.println("total_cells: "+ total_cells);
		
		for(int r=0;r<=total_rows;r++) {
			XSSFRow row = sheet.getRow(r);
			
			for(int c=0;c<total_cells;c++) {
				XSSFCell cell = row.getCell(c); // row.getCell(c).toString();
				if (cell == null) {
					System.out.print("\t");
				}else {System.out.print(cell.toString()+"\t");}
			}
			System.out.println();
		}
		
		workbook.close();
		file.close();
	}
}

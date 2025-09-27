package com.rakesh.selenium.selenium_with_java;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class _30_dync_writing_excel_withsel {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		FileOutputStream file = new FileOutputStream("C:\\\\Users\\\\shubh\\\\Documents\\\\GitHub\\\\Selenium-with-Java\\\\selenium-with-java\\\\p excel files\\\\selenium excel p-3.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("Dynamic Data");
		
		System.out.println("enter how many rows you want (counts from 0): ");
		int rows = sc.nextInt();
		
		System.out.println("enter how many cols you want (counts from 1): ");
		int cols = sc.nextInt();
		
		for(int r=0;r<=rows;r++) {
			XSSFRow row = sheet.createRow(r);
			for(int c=0;c<cols;c++) {
				XSSFCell cell = row.createCell(c);
				System.out.println("enter cell " + c + " value: ");
				cell.setCellValue(sc.next());
			}
			System.out.println();
		}
		
		workbook.write(file);
		if(file != null) {
			System.out.println("ok,done....");
		}
		sc.close();
		workbook.close();
		file.close();
		
		}
}

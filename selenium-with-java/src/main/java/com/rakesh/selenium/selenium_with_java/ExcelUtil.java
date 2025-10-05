package com.rakesh.selenium.selenium_with_java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow ro;
	public static XSSFCell ce;
	
	//gets the number of rows
	public static int getRows(String xlfile, String sheetname) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(sheetname);
		int rownum = sheet.getLastRowNum();
		wb.close();
		fi.close();
		return rownum;
	}
	
	//gets the number of cells 
	public static int getCells(String xlfile, String sheetname, int rownum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(sheetname);
		ro = sheet.getRow(rownum);
		int cellnum = ro.getLastCellNum();
		wb.close();
		fi.close();
		return cellnum;
	}
	
	//reads data from a cell
	public static String getCellData(String xlfile, String sheetname, int rownum, int cellnum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(sheetname);
		ro = sheet.getRow(rownum);
		ce = ro.getCell(cellnum);
		String data = "";
	    try {
	        XSSFRow row = sheet.getRow(rownum);
	        if (row != null) {
	            XSSFCell cell = row.getCell(cellnum);
	            if (cell != null) {
	                DataFormatter formatter = new DataFormatter();
	                data = formatter.formatCellValue(cell);
	            }
	        }
	    } catch (Exception e) {
	        data = "";
	    }

	    wb.close();
	    fi.close();
	    return data;
	}
	
	//writies data into a cell
	public static void setCellData(String xlfile, String sheetname, int rownum, int cellnum, String data) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(sheetname);
		ro = sheet.getRow(rownum);
		if (ro == null) {
		    ro = sheet.createRow(rownum);
		}
		ce = ro.createCell(cellnum);
			
		ce.setCellValue(data);
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
	}
}

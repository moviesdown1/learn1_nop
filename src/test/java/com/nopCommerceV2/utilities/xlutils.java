package com.nopCommerceV2.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xlutils {

	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static void setexcelfile(String xlfile,String xlsheet) throws IOException {
		try {
			fi=new FileInputStream(xlfile);
			workbook=new XSSFWorkbook(fi);
			sheet=workbook.getSheet(xlsheet);
			}
		catch (Exception e){
			throw e;
		}
		
		

	}
	public static int getrowcount(String xlfile,String xlsheet) throws IOException {
		fi=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(xlsheet);
		int noofrows= sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return noofrows;
		

	}
	public static int getcellcount(String xlfile,String xlsheet,int rownum) throws IOException {
		fi=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(xlsheet);
		int noofcells= sheet.getRow(rownum).getLastCellNum();
		workbook.close();
		fi.close();
		return noofcells;
	}
	public static String getcelldata(String xlfile,String xlsheet,int rownum,int colmn) throws IOException{
		fi=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(xlsheet);
		String data;
		try {
			data= sheet.getRow(rownum).getCell(colmn).toString();
		}
		catch(Exception e){
			data="";
		}
		workbook.close();
		fi.close();
		return data;
			
		 
	}
	public static void setcelldata(String xlfile,String xlsheet,int rownum,int colmn,String data) throws IOException{
		fi=new FileInputStream(xlfile);
		
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(xlsheet);
		
		sheet.getRow(rownum).createCell(colmn).setCellValue(data);
		fo=new FileOutputStream(xlfile);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
		
			
		 
	}
	

	

		
		
}



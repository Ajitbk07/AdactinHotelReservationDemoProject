package com.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.Main;


public class ExcelReader
{    
	
	public List<Map<String,String>> getData(String file,int sheetindex) throws IOException
	{      
		Sheet sheet =  getSheetByIndex(file, sheetindex);
           return getCellValue(sheet);
	}
	public List<Map<String,String>> getData(String file,String sheetname) throws IOException
	{      
	    Sheet sheet =  getSheetByName(file, sheetname);
           return getCellValue(sheet);
	}
	private Sheet getSheetByIndex(String file,int sheetindex) throws IOException 
	{
		FileInputStream excelsheetpath =  new  FileInputStream(file);
		Workbook workbook= new XSSFWorkbook(excelsheetpath);
		Sheet sheet = workbook.getSheetAt(sheetindex);
		return sheet;
	}
	private Sheet getSheetByName(String file,String sheetname) throws IOException 
	{
		FileInputStream excelsheetpath =  new  FileInputStream(file);
		Workbook workbook= new XSSFWorkbook(excelsheetpath);
		Sheet sheet = workbook.getSheet(sheetname);
		return sheet;
	}
	
	private  List<Map<String, String>> getCellValue(Sheet sheet) 
	{          
		  Row row; Cell cell;
		 List<Map<String,String>> list = new ArrayList<>();
		 		int firstRowNum = sheet.getFirstRowNum();
		 		int rowCount = sheet.getPhysicalNumberOfRows();
             for(int i=firstRowNum+1;i<=rowCount;i++)
             { 
             	LinkedHashMap<String,String> columndata = new LinkedHashMap<String,String>();
                      		row = sheet.getRow(i);
                    short firstCellNum = row.getFirstCellNum();
                    short cellCount = row.getLastCellNum();
                    for(int j=firstCellNum;j<cellCount;j++)
                    	{
                    	
                   String key = sheet.getRow(firstRowNum).getCell(j).getStringCellValue();
                   String value = null;
                   cell = sheet.getRow(i).getCell(j);
                      if(cell.getCellType()==CellType.BLANK)
                      {
                    	    value ="";
                    	    System.out.println("cell is blank!!!");
                      }
                      else if(cell.getCellType()==CellType.STRING) 
                      {
                    	   value=cell.getStringCellValue();
                      }
                      else if(cell.getCellType()==CellType.NUMERIC)
                      {
                    	    int cellvalue = (int) cell.getNumericCellValue();
                    	    value= Integer.toString(cellvalue);
                      }
                      else if(cell.getCellType()==CellType.BOOLEAN) {
						boolean booleanCellValue = cell.getBooleanCellValue();
						     value = Boolean.toString(booleanCellValue);
					}
                   columndata.put(key, value);
                    	}
             	list.add(columndata);
             }
				return list;
	    }
	   public static void main(String[] args) throws IOException {
		List<Map<String,String>> data = new ExcelReader().getData("D:Adactin project/AdactinTestCases.xlsx","Test Data");
	   System.out.println(data.get(2).get("username"));
	   }
	
}


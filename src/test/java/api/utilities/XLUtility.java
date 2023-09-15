package api.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;



import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
	
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	
	public XLUtility(String path) {
		this.path = path;
	}

	public int getRowCount(String sheetName) throws IOException{
		
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowcount;
		
	}
	
	public int getCellCount(String sheetName, int rowNum) throws IOException{
		
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		int cellcount = row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellcount;
	}
	
	public String getCellData(String sheetName, int rowNum, int colNum) throws IOException{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data = formatter.formatCellValue(cell);
			// returns the formatted value of a cell as a String regardless 
		}catch(Exception e) {
			data="";
		}
		workbook.close();
		fi.close();
		return data;
	}
	
	public void setCellData(String sheetName, int rowNum, int colNum, String data) throws IOException{
		File xlFile = new File(path);
		if(!xlFile.exists())  //If file not exists then create new file
		{
			workbook = new XSSFWorkbook();
			fo=new FileOutputStream(path);
			workbook.write(fo);
		}
		
			fi=new FileInputStream(path);
			workbook = new XSSFWorkbook(fi);
			
			if(workbook.getSheetIndex(sheetName)==-1)  // If sheet not exists then create new Sheet
				workbook.createSheet(sheetName);
				sheet = workbook.getSheet(sheetName);
				
				if(sheet.getRow(rowNum)==null)	// If row not exists then create new Row
					sheet.createRow(rowNum);
				row=sheet.getRow(rowNum);
				
			cell = row.createCell(colNum);
			cell.setCellValue(data);
			fo=new FileOutputStream(path);
			workbook.write(fo);
			workbook.close();
			fi.close();
			
	}
}

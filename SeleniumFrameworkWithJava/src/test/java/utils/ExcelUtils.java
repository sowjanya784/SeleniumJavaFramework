package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils {

	private static XSSFSheet sheet;

	public ExcelUtils(String excelPath, String sheetName) {
		try {
			XSSFWorkbook workBook = new XSSFWorkbook(excelPath);
			sheet = workBook.getSheet(sheetName);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/*
	private static void getWorkSheet() {
		String projectPath = System.getProperty("user.dir");
		String excelPath = projectPath + "/Excel/data.xlsx"
		
		XSSFWorkbook workBook = new XSSFWorkbook(excelPath);
		
		//for older excel format with .xls extension, have to use inputstream for the path
		 InputStream file = new FileInputStream(excelPath);
		HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(file)); 
		sheet = workBook.getSheet("sheet1");
	}
*/

	public int getRowCount() {

		return sheet.getPhysicalNumberOfRows();
	}
	
	public int getColumnCount() {

		return sheet.getRow(0).getPhysicalNumberOfCells();
	}
	
	public String getCellDataString(int rowNum, int colNum) {

		return sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
	}
	
	public double getCellDataNumber(int rowNum, int colNum) {

		double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		return cellData;
	}
	
	//can also do generic object instead of string or numeric
	public Object getCellData(int rowNum, int colNum) {
		DataFormatter formatter = new DataFormatter();
		Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
		return value;
	}

}

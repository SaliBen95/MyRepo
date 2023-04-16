package Config;

import java.io.FileInputStream;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilities {

	public static FileInputStream fisExcel;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	
	
	public static Object[][] getTestDataFromExcel(String SheetName) throws Exception {
		
		 fisExcel = new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\java\\TestData\\TutorialsNinjaTestData.xlsx");
		 workbook = new XSSFWorkbook(fisExcel);
		 sheet= workbook.getSheetAt(0);
		
		int rows = sheet.getLastRowNum(); 
		int cols = sheet.getRow(0).getLastCellNum();
		
		Object [][] data = new Object[rows][cols];
		
		 for(int i=0 ; i<rows ; i++) {
			 XSSFRow row = sheet.getRow(i+1);
			 
			  for(int j=0 ; j<cols ; j++) {
				  XSSFCell cell = row.getCell(j);
				 CellType cellype = cell.getCellType();
				 
				 switch(cellype) {
				 
				 case STRING:
					 data[i][j] = cell.getStringCellValue();
					 break;
					 
				 case NUMERIC:
					 data[i][j] = Integer.toString((int)cell.getNumericCellValue());
					 break;
					 
				 case BOOLEAN:
					 data[i][j] = cell.getBooleanCellValue();
					 break;
				 }
			  }
		 }
		 
		 return data;
			
		}
	
	
	public static void main(String[] args) {
		generateNameforEmailWithTimeStamp();
	} 
	
	public static String generateEmailWithTimeStamp() {
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
		return "salima" + timeStamp + "@gmail.com";
	}
	
	public static String generateNameforEmailWithTimeStamp() {
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_").substring(8, 19).replace("_", "");
		return "salima" + timeStamp + "@gmail.com";
	
	}

		
	}


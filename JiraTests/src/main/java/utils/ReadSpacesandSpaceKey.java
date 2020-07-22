package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadSpacesandSpaceKey {
	
public static String[][] readSpacesandSpaceKey(String fileName) throws IOException {
		
		
	    XSSFWorkbook wb = new XSSFWorkbook(fileName); 
	    XSSFSheet ws = wb.getSheet("JiraIssues");
		int rowsCount = ws.getLastRowNum();
		int cellCount = ws.getRow(0).getLastCellNum();
		String[][] data = new String[rowsCount][cellCount];
		for (int i = 1; i <= rowsCount; i++) {
			for (int j = 0; j < cellCount; j++) {
		 		String cellValue = ws.getRow(i).getCell(j).getStringCellValue();
				data[i - 1][j] = cellValue;
			  }
		}
		wb.close();
		return data;
	}


}
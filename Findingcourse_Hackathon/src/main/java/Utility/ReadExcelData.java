package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	
	public static String[] formData = new String[10];
	public static String[] readData() throws IOException {
		
		      
			FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\forminput.xlsx");
			
			XSSFWorkbook workbook=new XSSFWorkbook(file);
			
			XSSFSheet sheet=workbook.getSheet("Sheet1");
			
			Row row=sheet.getRow(1);
			
			for(int i=0;i<formData.length;i++)
			{
				Cell cell = row.getCell(i);
				DataFormatter formatter = new DataFormatter();
				formData[i] = formatter.formatCellValue(cell);
			}
			workbook.close();
			return formData;
			
	}
	public static String[] writeData() throws IOException {
	FileOutputStream fos=new FileOutputStream(System.getProperty("user.dir")+"\\forminput.xlsx");
	XSSFWorkbook workbook=new XSSFWorkbook();
	XSSFSheet sheet=workbook.getSheet("Sheet1");
	workbook.write(fos);
	workbook.close();
	return formData;
	
	
		}
}
	



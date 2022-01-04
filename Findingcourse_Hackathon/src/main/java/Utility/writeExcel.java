package Utility;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writeExcel {
	
	public void setCellData(String sheetName,int rownum,int column,String data) throws IOException {
		FileOutputStream foos=new FileOutputStream(System.getProperty("user.dir") + "//Output.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet sheet=wb.getSheet("course");
		if(sheet.getRow(rownum)==null) {
			sheet.createRow(rownum);
		}
		XSSFRow row=sheet.getRow(rownum);
		XSSFCell col=row.createCell(column);
		col.setCellValue(data);
		wb.write(foos);
		foos.close();
		
	}

}

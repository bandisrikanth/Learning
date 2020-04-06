package excel;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write {

	public static void writeData(String str) throws IOException {

		FileInputStream inp = new FileInputStream("C:\\Users\\srikanth\\Desktop\\srikanthgitlearn\\Rest\\data.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(inp);
		XSSFSheet sheet = wb.getSheetAt(0);

		Row row = sheet.createRow(1);
		row.createCell(0).setCellValue(str);

		FileOutputStream fileOut = new FileOutputStream(
				"C:\\Users\\srikanth\\Desktop\\srikanthgitlearn\\Rest\\data.xlsx");
		wb.write(fileOut);
		fileOut.close();

	}

}

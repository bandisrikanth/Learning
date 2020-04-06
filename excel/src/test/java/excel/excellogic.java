package excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excellogic {

	public static ArrayList<String> getData(String Testcases) throws IOException {
		ArrayList<String> a = new ArrayList<String>();

		FileInputStream file = new FileInputStream("C:\\Users\\srikanth\\Desktop\\srikanthgitlearn\\Rest\\Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		int sheets = workbook.getNumberOfSheets();
		System.out.println(sheets);

		for (int i = 0; i < sheets; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase("task")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row firstrow = rows.next();
				Iterator<Cell> ce = firstrow.cellIterator();
				int k = 0;
				int column = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();
					if (value.getStringCellValue().equalsIgnoreCase("RestAddbook")) {
						column = k;
					}
					k++;
				}
				System.out.println(column);
				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(Testcases)) {
						Iterator<Cell> cv = r.cellIterator();

						while (cv.hasNext()) {
							Cell c = cv.next();
							if (c.getCellTypeEnum() == CellType.STRING) {
								a.add(c.getStringCellValue());
							} else {
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));

							}
						}

					}
				}
			}

		}
		return a;
	}

}

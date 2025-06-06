package RestAssured_Test;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtils {
	
	@DataProvider(name="ExcelData")
	public Object[][] returnExcelData() throws IOException {
		
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		workbook = new XSSFWorkbook("./data/inputData.xlsx");
		sheet = workbook.getSheet("Sheet1");
		Object[][] data;
		int i=0;		
		int rowCount = sheet.getPhysicalNumberOfRows();
		data = new Object[rowCount-1][5];//If excel data has a header
		DataFormatter formatter = new DataFormatter();
		
		Iterator<Row> rows = sheet.iterator();
		rows.next();//to skip header
		while (rows.hasNext()) {
			Row row = rows.next();
			data[i][0] = Integer.parseInt(formatter.formatCellValue(row.getCell(0)));
			data[i][1] = Float.parseFloat(formatter.formatCellValue(row.getCell(1)));
			data[i][2] = formatter.formatCellValue(row.getCell(2));
			data[i][3] = formatter.formatCellValue(row.getCell(3));
			data[i][4] = formatter.formatCellValue(row.getCell(4));
			i++;
		}
		workbook.close();
		return data;
	}
}


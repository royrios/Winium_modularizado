package configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass
{
	private static XSSFSheet sheet;
	private static XSSFWorkbook workbook;
	private static XSSFCell cell;
	private static XSSFRow firstRow;

	@DataProvider(name = "data-provider")
	public Object[][] SampleData() {
		
		int cellTypeId;
		int j = 0;
		Map<String, Object> rowdatamap = null;
		FileInputStream stream = null;
		Object[][] dataset = null;

		// Creating index map
		Map<String, Integer> index = new HashMap<String, Integer>();

		try {
			stream = new FileInputStream("./DataProvider/TestData3.xlsx");
			workbook = new XSSFWorkbook(stream);
			sheet = workbook.getSheetAt(0);
			workbook.close();

			// mapping column index with column name.
			firstRow = sheet.getRow(0);
			for (Cell cell : firstRow) {
				index.put(cell.getStringCellValue(), j);
				j++;
			}

			// get total rows count present in sheet
			int rowCount = sheet.getLastRowNum();
			// initialize the return object
			dataset = new Object[rowCount][1];

			// running for loop for each excel row and storing values in map
			for (int i = 0; i < rowCount; i++) {
				// initialize excel row map
				rowdatamap = new HashMap<String, Object>();
				Row rowData = sheet.getRow(i + 1);

				for (String key : index.keySet()) {
					int columnnum = (Integer) index.get(key);
					cellTypeId = rowData.getCell(columnnum).getCellType();

					if (cellTypeId == 0) {
						DecimalFormat df = new DecimalFormat("#");
						rowdatamap.put(key, df.format(rowData.getCell(columnnum).getNumericCellValue()));
					} else if (cellTypeId == 1) {
						rowdatamap.put(key, rowData.getCell(columnnum).toString());
					} else if (cellTypeId == 4) {
						rowdatamap.put(key, rowData.getCell(columnnum).getBooleanCellValue());
					}
				}

				dataset[i][0] = rowdatamap;

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataset;
	}
}
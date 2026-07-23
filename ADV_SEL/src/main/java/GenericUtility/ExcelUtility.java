package GenericUtility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String toReadDatafromExcel(String sheetname, int row, int cell) throws Throwable{
		FileInputStream fis1= new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb =WorkbookFactory.create(fis1);
		String data = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return data;

		
	}
	public int getLastRow(String sheetName) throws Throwable {

	    FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
	    int lastrow= wb.getSheet(sheetName).getLastRowNum();
	    return lastrow;
	}
}

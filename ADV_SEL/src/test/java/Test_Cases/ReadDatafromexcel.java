package Test_Cases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDatafromexcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis= new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb =WorkbookFactory.create(fis);
		wb.getSheet("Sheet1");
		Sheet sh= wb.getSheet("Sheet1");
		Row r = sh.getRow(1);
		String productname=r.getCell(2).getStringCellValue();
		System.out.println(productname);
		
	}

}

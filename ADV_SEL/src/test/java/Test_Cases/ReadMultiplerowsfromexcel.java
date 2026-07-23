package Test_Cases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultiplerowsfromexcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis= new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb =WorkbookFactory.create(fis);
	
		Sheet sh= wb.getSheet("Cart");
		int rowcount=sh.getLastRowNum();
		
		for(int i=1;i<=rowcount;i++)
		{
			String prodname = sh.getRow(i).getCell(0).getStringCellValue();
			String range = sh.getRow(i).getCell(1).getStringCellValue();
			
			System.out.println(prodname + "-------" + range);
		}

	}

}

package TestNG;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import GenericUtility.ExcelUtility;
import GenericUtility.PropertiesFiles;
import GenericUtility.WebDriverUtility;
import ObjectRepo.CartPage;
import ObjectRepo.LoginPage;
import ObjectRepo.ProductsPage;
import TestNG.BaseClass;

public class AddLowProdtoCartTest1 extends BaseClass {

	@Test(groups= "regression")
	public void toAddLowProdtoCartTest1() throws Throwable {
		
		ExcelUtility eutil= new ExcelUtility();
		
	
		String et= eutil.toReadDatafromExcel("Sheet1", 1, 2);
		
		ProductsPage pp= new ProductsPage(driver);
		CartPage cp = new CartPage(driver);
		pp.getProdname().click();
		pp.getAddtocartBtn().click();
		pp.getCartIcon().click();
		Thread.sleep(3000);
		
		
		String item=cp.getInventItem().getText();
		if(item.equals(et))
		{
			System.out.println("pass");
		}else
		{
			System.out.println("fail");
		}
		
	}
	
}


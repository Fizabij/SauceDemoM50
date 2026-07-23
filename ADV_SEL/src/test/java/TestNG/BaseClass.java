package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import GenericUtility.PropertiesFiles;
import GenericUtility.WebDriverUtility;
import ObjectRepo.CartPage;
import ObjectRepo.LoginPage;

public class BaseClass {

	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	public PropertiesFiles putil = new PropertiesFiles();
	public WebDriverUtility wutil =  new WebDriverUtility();
	
	
	@BeforeSuite(groups= {"smoke","regression"})
	public void beforeSuite() {
		Reporter.log("DB open", true);
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"smoke","regression"})
	public void beforeClass() throws Throwable {
	String BROWSER = System.getProperty("BROWSER");
		
		if(BROWSER.equals("Edge")) {
			driver = new EdgeDriver();
		}else if(BROWSER .equals("Chrome")) {
			driver = new ChromeDriver();
		}else if (BROWSER.equals("Firefox")) {
			driver = new FirefoxDriver();
		}
		sdriver = driver;
		Reporter.log("launch browser", true);
	}
	
	@BeforeMethod(groups= {"smoke","regression"})
	public void beforeMethod() throws Throwable {
		String URL = putil.toReadDatafromPropFile("Url");
		String USERNAME = putil.toReadDatafromPropFile("Username");
		String PASSWORD = putil.toReadDatafromPropFile("Password");
		
		driver.manage().window().maximize();
		wutil.waitforPagetoLoad(driver);
		driver.get(URL);
		
		LoginPage lp= new LoginPage(driver);
		lp.getUsername().sendKeys(USERNAME);
		lp.getPassword().sendKeys(PASSWORD);
		lp.getLoginBtn().click();
		Reporter.log("login", true);
		
	}
	
	@AfterMethod(groups= {"smoke","regression"})
	public void afterMethod() {
		CartPage cp = new CartPage(driver);
		cp.getBurgerIcon().click();
		cp.getLogout().click();
		Reporter.log("logout", true);
	}
	
	@AfterClass(groups= {"smoke","regression"})
	public void afterClass() throws InterruptedException {
		driver.quit();
		Reporter.log("close browser",true);
	}
	
	@AfterSuite(groups= {"smoke","regression"})
	public void afterSuite() {
		Reporter.log("DB close", true);
	}
}


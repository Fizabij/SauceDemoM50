package TestNG;

import org.testng.annotations.Test;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class ConfigAnnotation {
	
	@Test
	public void TC() {
		Reporter.log("tc executed", true);
	}
	
	@BeforeMethod	
	public void beforeMethod() {
		Reporter.log("open url", true);
	}
	
	@AfterMethod	
	public void afterMethod() {
		Reporter.log("close url", true);
	} 
	
	@BeforeClass
	public void beforeClass() {
		Reporter.log("open browser", true);
	}
	
	@AfterClass
	public void afterClass() {
		Reporter.log("close browser", true);
	}
	
	@BeforeTest
	public void beforeTest() {
		Reporter.log("precond", true);
	}
	
	@AfterTest
	public void afterTest() {
		Reporter.log("post cond", true);
	}
	
	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("DB open", true);
	}
	
	@AfterSuite
	public void afterSuite() {
		Reporter.log("close DB", true);
	}

}

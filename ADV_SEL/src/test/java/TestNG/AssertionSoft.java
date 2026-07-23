package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionSoft {


		@Test
		public void login() {
			String exp="Faceboo";
			
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.facebook.com/");
			String actTitle = driver.getTitle();
			
			SoftAssert soft=new SoftAssert();
			soft.assertEquals(exp, actTitle);
			System.out.println("Hi");
			
			soft.assertAll();
			driver.quit();
		
	}

}

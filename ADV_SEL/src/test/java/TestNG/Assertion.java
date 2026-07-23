package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertion {

	@Test
	public void login() {
		String exp="Facebook";
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		String actTitle = driver.getTitle();
		
		Assert.assertEquals(exp, actTitle);
		System.out.println("Hi");
		driver.quit();
	}
}

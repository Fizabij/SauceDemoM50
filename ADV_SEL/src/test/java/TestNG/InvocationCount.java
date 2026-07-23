package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class InvocationCount {
	
	@Test(invocationCount = 3)
	public void login() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test(invocationCount = 4, threadPoolSize = 2)//example for thread pool size
	public void logins() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.quit();
	}
}

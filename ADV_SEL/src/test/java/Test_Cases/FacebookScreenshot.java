package Test_Cases;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import TestNG.BaseClass;

public class FacebookScreenshot {

	public static void main(String[] args) throws IOException, Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		
		Date d = new Date();
		String newDate= d.toString().replace(" ","_").replace(":", "_");
		
		TakesScreenshot ts= (TakesScreenshot) BaseClass.sdriver;
		File temp= ts.getScreenshotAs(OutputType.FILE);
		File perm = new File("./src/test/resources/"+newDate+".png");
		
		FileHandler.copy(temp, perm);
		Thread.sleep(3000);
		driver.quit();
	}

}

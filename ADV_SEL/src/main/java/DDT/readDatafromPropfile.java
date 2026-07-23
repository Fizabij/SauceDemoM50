package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class readDatafromPropfile {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileInputStream fis= new FileInputStream("./src/test/resources/CommonData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String Browser = prop.getProperty("Browser");
		String Browser1 = prop.getProperty("Browser");
	
		String Url=prop.getProperty("Url");
		String username= prop.getProperty("Username");
		String password = prop.getProperty("Password");
		System.out.println(Browser);
		System.out.println(Url);
		System.out.println(username);
		System.out.println(password);
		
		WebDriver driver=null;
		if (Browser.equalsIgnoreCase("Chrome")) {
		    driver = new ChromeDriver();
		} else if (Browser1.equalsIgnoreCase("Edge")) {
		    driver = new EdgeDriver();
		} else if (Browser.equalsIgnoreCase("firefox")) {
		    driver = new FirefoxDriver();
		}
		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//login
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		driver.quit();
		
	}

}

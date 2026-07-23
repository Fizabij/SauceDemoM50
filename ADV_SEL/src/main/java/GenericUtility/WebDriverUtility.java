package GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void waitforPagetoLoad(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void  waitforVisibilityofElement(WebElement element, WebDriver driver) {
		WebDriverWait  wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchtoFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchtoFrame(WebDriver driver, String idorname) {
		driver.switchTo().frame(idorname);
	}
	
	public void switchtoFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void switchtoAlertandDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void switchtoAlertandAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public String switchtoAlertandText(WebDriver driver) {
		String text= driver.switchTo().alert().getText();
		return text;
	}
	
	public void switchtoAlertandSendKeys(WebDriver driver, String text1) {
		driver.switchTo().alert().sendKeys(text1);
	}
	
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	public void selectbyValue(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	public void selectbyText(String text, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void mousehiveronWebElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void clickonWebelement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
	}
	
	public void doubleclickonWebElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).click().perform();
	}
	
	public void reightclickonWebelement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).click().perform();
	}
	
	public void passInput(WebDriver driver, WebElement element, String text) {
		Actions act = new Actions(driver);
		act.click(element).sendKeys(text).perform();
	}
	
	public void switchtoWindows(WebDriver driver) {
		Set<String> allWindId= driver.getWindowHandles();
		for (String id : allWindId) {
			driver.switchTo().window(id);
			
		}
	}
	
	public void takeSreenshot(WebDriver driver, String filename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File perm = new File("./errorshots/" + filename + ".png");
		FileHandler.copy(temp, perm);
	}
	
	public void toscrollBy(WebDriver driver, int x, int y) {
		JavascriptExecutor jse =(JavascriptExecutor)driver;
		jse.executeScript("window.scrollby("+x+", "+y+")");
	}
}

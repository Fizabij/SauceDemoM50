package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
			
	@FindAll({@FindBy(id="user-name"), @FindBy(name="user-name")})
	private WebElement Username;
	

	@FindBy(id="password")
	private WebElement Password;
	
	@FindBy(id="login-button")
	private WebElement LoginBtn;
	

	public WebElement getUsername() {
		return Username;
	}


	public WebElement getPassword() {
		return Password;
	}


	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	public void login(String un, String pwd)
	{
		Username.sendKeys(un);
		Password.sendKeys(pwd);
		LoginBtn.click();
	}


	
	


	

}

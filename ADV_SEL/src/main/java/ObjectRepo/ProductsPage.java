package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//div[text()='Sauce Labs Fleece Jacket']")
	private WebElement prodname;

	@FindBy(xpath="//div[text()='Sauce Labs Onesie']")
	private WebElement prodname1;

	@FindBy(xpath = "//button[text()='Add to cart']")
	private WebElement AddtocartBtn;

	@FindBy(className = "shopping_cart_link")
	private WebElement cartIcon;

	public WebElement getProdname() {
		return prodname;
	}

	public WebElement getProdname1() {
		return prodname1;
	}

	public WebElement getAddtocartBtn() {
		return AddtocartBtn;
	}

	public WebElement getCartIcon() {
		return cartIcon;
	}
	
	


}

package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    WebDriver driver;
	
	//Objects
	@FindBy(css= "input.form-control.input-lg")
	private WebElement enterProduct;
	
	@FindBy(css = "button.btn.btn-default.btn-lg")
	private WebElement clickOnButton;
	
	@FindBy (linkText = "iPhone")
	private WebElement productName;
	
	@FindBy (xpath = "//p[contains (text() , 'There is no product that matches the search criteria.')]")
	private WebElement Warning;
	
	
	public SearchPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void enterProduct(String product) {
		enterProduct.sendKeys(product);
	}
	
	public void clickOnButton() {
		clickOnButton.click();
	}
	
	public boolean productName() {
		boolean product= productName.isDisplayed();
		return product;
	}
	
	public String Warning () {
		String msg = Warning.getText();
		return msg;
	}
	
	
	
}

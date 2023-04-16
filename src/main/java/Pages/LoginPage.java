package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	//Objects
	
	@FindBy(xpath = "//input[@id = 'input-email']")
	private WebElement emailAddressField;
	
	@FindBy(xpath = "//input[@id = 'input-password']")
	private WebElement passwordField;
	
	@FindBy(xpath = "//input[@class='btn btn-primary']")
	private WebElement loginButton;
	
	@FindBy (xpath = "//h2[contains ( text(), 'My Orders')]")
	private WebElement MyOrders;
	
	@FindBy (xpath = "//div[contains(text(), 'Warning: No match for E-Mail Address and/or Password.' )]")
	private WebElement WarningMessageInvCredentials;
	
	@FindBy (linkText = "Forgotten Password")
	private WebElement ForgotPassword;
	
	@FindBy (xpath = "//div[@id='content']/child::h1")
	private WebElement ValidationForgotPasswordLink;
	
	
	
	//Actions
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public void enterEmailAddress(String emailText) {
		emailAddressField.sendKeys(emailText);
	}
	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	} 
    public void clickOnLoginButton() {
    	loginButton.click();
    } 
    public boolean getDisplayMyOrders() {
    	boolean displayStatus = MyOrders.isDisplayed();
    	return displayStatus;
    }
    public String WarningMessage() {
    	String Warning= WarningMessageInvCredentials.getText();
    	System.out.println(Warning);
    	return Warning;
    }
    
    public void ForgotPasswordLink() {
    	ForgotPassword.click();
    }
    
    public String ValidationForgotPasswordLink() {
    	String e =ValidationForgotPasswordLink.getText();
    	return e;
    }
}

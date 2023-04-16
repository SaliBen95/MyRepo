package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;
	
	//Objects
	@FindBy (xpath = "//input[@id = 'input-firstname']")
	private WebElement FirstNameField;
	
	@FindBy (xpath = "//input[@id = 'input-lastname']")
	private WebElement LastNameField;
	
	@FindBy (xpath = "//input[@id = 'input-email']")
	private WebElement enterEmailAddress;
	
	@FindBy (xpath = "//input[@id = 'input-telephone']")
	private WebElement enterTelephone;
	
	@FindBy (xpath = "//input[@id = 'input-password']")
	private WebElement enterPassword;
	
	@FindBy (xpath = "//input[@id = 'input-confirm']")
	private WebElement enterConfirmPassword;
	
	@FindBy (xpath = "//input[@name = 'agree']")
	private WebElement agree;
	
	@FindBy (xpath = "//div[@class= 'pull-right']/descendant::input[2]")
	private WebElement ClickOnButton;
	
	@FindBy (xpath = "//h1[contains (text() , 'Your Account Has Been Created!')]")
	private WebElement AccountSuccessfullyCreated;
	
	@FindBy (xpath = "//div[contains (text() , 'Warning: E-Mail Address is already registered!')]")
	private WebElement WarningExistingEmail;
	
	@FindBy (xpath = "//div[contains (text() , 'First Name must be between 1 and 32 characters!')]")
	private WebElement WarningFirstName;
	
	@FindBy (xpath = "//div[contains (text() , 'Last Name must be between 1 and 32 characters!')]")
	private WebElement WarningLastName;
	
	@FindBy (xpath = "//div[contains (text() , 'E-Mail Address does not appear to be valid!')]")
	private WebElement WarningEmailAddress;
	
	@FindBy (xpath = "//div[contains (text() , 'Telephone must be between 3 and 32 characters!')]")
	private WebElement WarningTelephone;
	
	@FindBy (xpath = "//div[contains (text() , 'Password must be between 4 and 20 characters!')]")
	private WebElement WarningPassword;
	
	@FindBy (xpath = "//div[contains (text() , 'Warning: You must agree to the Privacy Policy!')]")
	private WebElement WarningPrivacyPolicy;
	
    @FindBy (xpath = "//div[contains (text() , 'Password confirmation does not match password!')]")
	private WebElement WarningPasswordConfirm;
	
	
    
	
	public RegisterPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	//Actions
	public void EnterFirstName(String firstName) {
		FirstNameField.sendKeys(firstName);
	}
	
	public void EnterLastName(String lastName) {
		LastNameField.sendKeys(lastName);
	}
	
	public void enterEmailAddress(String emailAddress) {
		enterEmailAddress.sendKeys(emailAddress);
	}
	
	public void enterTelephone(String tel) {
		enterTelephone.sendKeys(tel);
	}
	public void enterPassword(String password) {
		enterPassword.sendKeys(password);
	}
	public void enterConfirmPassword(String confirmPsswd) {
		enterConfirmPassword.sendKeys(confirmPsswd);
	}
	public void ClickAgree() {
		agree.click();
	}
	
	public void ClickOnButton() {
		ClickOnButton.click();
	}
	
	public boolean AccountSuccessfullyCreated() {
		boolean successMssg = AccountSuccessfullyCreated.isDisplayed();
		return successMssg;
	}
	
	public boolean WarningExistingEmail() {
		boolean warningMssg = WarningExistingEmail.isDisplayed();
		return warningMssg ;
	}
	
	public boolean WarningFirstName() {
		boolean warning =WarningFirstName.isDisplayed();
		return warning;
	}
	
	public boolean WarningLastName() {
		boolean warning =WarningLastName.isDisplayed();
		return warning ;
	}
	
	public boolean WarningEmailAddress() {
		boolean warning =WarningEmailAddress.isDisplayed();
		return warning ;
	}
	
	public boolean WarningTelephone() {
		boolean warning =WarningTelephone.isDisplayed();
		return warning ;
	}
	
	public boolean WarningPassword() {
		boolean warning =WarningPassword.isDisplayed();
		return warning ;
	}
	
	public boolean WarningPrivacyPolicy(){
		boolean warning = WarningPrivacyPolicy.isDisplayed();
		return warning ;
	}
	
	public boolean WarningPasswordConfirm(){
		boolean warning = WarningPasswordConfirm.isDisplayed();
		return warning ;
	}
	
}

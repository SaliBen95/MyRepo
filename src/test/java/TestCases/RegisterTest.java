package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Config.Utilities;
import Pages.HomePage;
import Pages.RegisterPage;
import testBase.Base;

public class RegisterTest extends Base {
	public RegisterTest() {
   	 super();
    }
	
	 public WebDriver driver;
     public ChromeOptions options;
    
     
     @BeforeMethod
 	public void setup() throws Exception {
    	driver= initializeBrowserChrome();
    	HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		homepage.selectRegisterOption();;
 	}
    
     
	@Test (priority =1)
	public void verifyRegisterWithValidField() throws InterruptedException {
	RegisterPage registerPage = new RegisterPage(driver);
	registerPage.EnterFirstName(dataProp.getProperty("FirstName"));
	registerPage.EnterLastName(dataProp.getProperty("LastName"));
	registerPage.enterEmailAddress(Utilities.generateNameforEmailWithTimeStamp());
	registerPage.enterTelephone(dataProp.getProperty("TelephoneNumber"));
	registerPage.enterPassword(prop.getProperty("ValidPassword"));
	registerPage.enterConfirmPassword(prop.getProperty("ValidPassword"));
	registerPage.ClickAgree();
	registerPage.ClickOnButton();

	Assert.assertTrue(registerPage.AccountSuccessfullyCreated());
	
	}
	
	
	@Test (priority =2)
	public void verifyRegisterWithExistingEmail() {
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.EnterFirstName(dataProp.getProperty("FirstName"));
		registerPage.EnterLastName(dataProp.getProperty("LastName"));
		registerPage.enterEmailAddress("sali@gmail.com");
		registerPage.enterTelephone(dataProp.getProperty("TelephoneNumber"));
		registerPage.enterPassword(prop.getProperty("ValidPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("ValidPassword"));
		registerPage.ClickAgree();
		registerPage.ClickOnButton();
	    Assert.assertTrue(registerPage.WarningExistingEmail());
	}
	
	
	@Test (priority =3)
	public void verifyRegisterWithoutProvidingAnyInformation() {
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.ClickAgree();
		registerPage.ClickOnButton();
	
	Assert.assertTrue(registerPage.WarningFirstName());
	Assert.assertTrue(registerPage.WarningLastName());
	Assert.assertTrue(registerPage.WarningEmailAddress());
	Assert.assertTrue(registerPage.WarningTelephone());
	Assert.assertTrue(registerPage.WarningPassword());
	}
	
	
	@Test(priority =4)
	public void verifyRegisterWithoutAgreePrivacyPolicy() {
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.EnterFirstName(dataProp.getProperty("FirstName"));
		registerPage.EnterLastName(dataProp.getProperty("LastName"));
		registerPage.enterEmailAddress(dataProp.getProperty("Email"));
		registerPage.enterTelephone(dataProp.getProperty("TelephoneNumber"));
		registerPage.enterPassword(prop.getProperty("ValidPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("ValidPassword"));
		registerPage.ClickOnButton();
		
	    Assert.assertTrue(registerPage.WarningPrivacyPolicy());
	}
	
	
	@Test (priority =5)
	public void verifyInvalidPasswordConfirm() {
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.EnterFirstName(dataProp.getProperty("FirstName"));
		registerPage.EnterLastName(dataProp.getProperty("LastName"));
		registerPage.enterEmailAddress(dataProp.getProperty("Email"));
		registerPage.enterTelephone(dataProp.getProperty("TelephoneNumber"));
		registerPage.enterPassword(prop.getProperty("ValidPassword"));
		registerPage.enterConfirmPassword(dataProp.getProperty("InvalidPassword"));
		registerPage.ClickAgree();
		registerPage.ClickOnButton();
		
	  Assert.assertTrue(registerPage.WarningPasswordConfirm());
	}
	
	
	@Test (priority =6)
	public void verifyInvalidPassword() {
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.EnterFirstName(dataProp.getProperty("FirstName"));
		registerPage.EnterLastName(dataProp.getProperty("LastName"));
		registerPage.enterEmailAddress(dataProp.getProperty("Email"));
		registerPage.enterTelephone(dataProp.getProperty("TelephoneNumber"));
		registerPage.enterPassword(dataProp.getProperty("InvPassword"));
		registerPage.enterConfirmPassword(dataProp.getProperty("InvPassword"));
		registerPage.ClickAgree();
		registerPage.ClickOnButton();;
	   Assert.assertTrue(registerPage.WarningPassword());
	   
	}
	
	
	@Test (priority =7)
	public void verifyInvalidTelephone() {
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.EnterFirstName(dataProp.getProperty("FirstName"));
		registerPage.EnterLastName(dataProp.getProperty("LastName"));
		registerPage.enterEmailAddress(dataProp.getProperty("Email"));
		registerPage.enterTelephone("7");
		registerPage.enterPassword(prop.getProperty("ValidPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("ValidPassword"));
		registerPage.ClickAgree();
		registerPage.ClickOnButton();
		
	  Assert.assertTrue(registerPage.WarningTelephone());
	}
	
	
	
	@AfterMethod
	public void ClosePage() {
		driver.quit();
	}
	
	
}

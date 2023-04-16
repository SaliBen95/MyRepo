package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Config.Utilities;
import Pages.HomePage;
import Pages.LoginPage;
import testBase.Base;

@Test
public class LoginTest extends Base{
     public LoginTest() {
    	 super();
     }
	
	 public WebDriver driver;
     public ChromeOptions options;
   
	
     @BeforeMethod
	public void setup() throws Exception {
		
		driver= initializeBrowserChrome();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		homepage.selectLoginOption();
	}

    @Test	(priority =1 , dataProvider ="validCredentialsSupplier")
	public void verifyLoginWithValidCredentials(String email, String password) {
    	LoginPage loginPage= new LoginPage(driver);
    	loginPage.enterEmailAddress(email);
		loginPage.enterPassword(password);
		loginPage.clickOnLoginButton();
		Assert.assertTrue(loginPage.getDisplayMyOrders());
	}
  
    @DataProvider (name="validCredentialsSupplier")
    public Object[][] supplyTestData() throws Exception {
	   Object[][] data = Utilities.getTestDataFromExcel("Login");
	   return data;
   }
    
  
    @Test (priority =6)
	public void verifyForgottenPasswordLink()  {
    	LoginPage loginPage= new LoginPage(driver);
    	loginPage.ForgotPasswordLink();
		String ExpectedvalidationForgotPasswd= loginPage.ValidationForgotPasswordLink();
		String ActualvalidationForgotPasswd = dataProp.getProperty("ActualvalidationForgotPasswd");
		Assert.assertEquals(ActualvalidationForgotPasswd, ExpectedvalidationForgotPasswd);	
	}

	
    @Test (priority =2)
	public void verifyLoginWithInvalidCredentials() {
    	LoginPage loginPage= new LoginPage(driver);
    	loginPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		loginPage.enterPassword(dataProp.getProperty("InvalidPassword"));
		loginPage.clickOnLoginButton();
		String ActualWarning = dataProp.getProperty("ActualWarning");
		String ExpectedWarning = loginPage.WarningMessage();
		Assert.assertEquals(ActualWarning, ExpectedWarning);
		
	}

    @Test (priority =3)
    public void verifyLoginWithValidEmailidInvalidPassword() {
    	LoginPage loginPage= new LoginPage(driver);
    	loginPage.enterEmailAddress(prop.getProperty("ValidEmail"));
		loginPage.enterPassword(dataProp.getProperty("InvalidPassword"));
		loginPage.clickOnLoginButton();
		String ActualWarning= dataProp.getProperty("ActualWarning");
		String ExpectedWarning = loginPage.WarningMessage();
		Assert.assertEquals(ActualWarning, ExpectedWarning);	
	}
    
    @Test (priority =4)
	public void verifyLoginWithInvalidEmailidValidPassword() {
    	LoginPage loginPage= new LoginPage(driver);
    	loginPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		loginPage.enterPassword(prop.getProperty("ValidPassword"));
		loginPage.clickOnLoginButton();
		String ActualWarning = dataProp.getProperty("ActualWarning");
		String ExpectedWarning = loginPage.WarningMessage();
		Assert.assertEquals(ActualWarning, ExpectedWarning);
		
    }
    
    
    @Test (priority =5)
	public void verifyLoginWithoutProvidingCredentials() {
    	LoginPage loginPage= new LoginPage(driver);
    	loginPage.clickOnLoginButton();
    	String ActualWarning = dataProp.getProperty("ActualWarning");
		String ExpectedWarning = loginPage.WarningMessage();
		Assert.assertEquals(ActualWarning, ExpectedWarning);
		
	}

	@AfterMethod
	public void ClosePage() {
		driver.quit();
	}
}

package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.SearchPage;
import testBase.Base;

public class SearchTest extends Base{
	public SearchTest() {
   	 super();
    }
	
	public WebDriver driver;
    public ChromeOptions options;
   
    
    @BeforeMethod
	public void setup() throws Exception {
    	driver= initializeBrowserChrome();

	}
    
    
    @Test (priority =1)
	public void verifySearchwithValidProduct() {
    	SearchPage search = new SearchPage(driver);
    	search.enterProduct(dataProp.getProperty("ValidProduct"));
    	search.clickOnButton();
    	Assert.assertTrue(search.productName());
    }
    
    
    @Test (priority =2)
	public void verifySearchwithInvalidproduct() {
    	SearchPage search = new SearchPage(driver);
    	search.enterProduct(dataProp.getProperty("InvalidProduct"));
    	search.clickOnButton();
    	String ActualWarning = dataProp.getProperty("SearchWarningMsg");
    	String ExpectedWarning =  search.Warning();
    	Assert.assertEquals(ActualWarning, ExpectedWarning);
    }
    
    
    
    @Test (priority =3)
	public void verifySearchWithoutEnteringAnyProduct() {
    	SearchPage search = new SearchPage(driver);
    	search.clickOnButton();
    	String ActualWarning = dataProp.getProperty("SearchWarningMsg");
    	String ExpectedWarning =  search.Warning();
    	Assert.assertEquals(ActualWarning, ExpectedWarning);
    	
    	
    }
    
   
    @AfterMethod
	public void ClosePage() {
		driver.quit();
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    		
}

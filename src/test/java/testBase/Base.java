package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Base {

	public WebDriver driver;
    public ChromeOptions options;
    public Properties prop;
    public FileInputStream fis;
    public Properties dataProp;
    public FileInputStream datafis;
   
    
    public Base() {
    	prop = new Properties();
    	File propFile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\config\\config.properties");
    	dataProp = new Properties();
    	File dataPropFile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\TestData\\testData.properties");
        
    	try {
    	datafis = new FileInputStream(dataPropFile);
    	dataProp.load(datafis);
        }catch(Throwable e) {
        	e.printStackTrace();
        }
        
    	try {
    	fis = new FileInputStream(propFile);
    	prop.load(fis);
    	}catch(Throwable e) {
    		e.printStackTrace();
    	}
    }
    
	public WebDriver initializeBrowserChrome() throws Exception {
		
			options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			options.addArguments("--start-maximized");
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			driver.get(prop.getProperty("url"));
			driver.manage().deleteAllCookies();
			Thread.sleep(3000);
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
			//driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(1000));
			
			return driver;
	}
	
	
	
	
}

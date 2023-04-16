package ExtentReport;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	public static ExtentReports generateExtentReport() {
		
	ExtentReports extent = new ExtentReports();
	File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
	ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
	
	sparkReporter.config().setTheme(Theme.DARK);
	sparkReporter.config().setReportName("TutorialsNinja Test Automation Results report");
	sparkReporter.config().setDocumentTitle("TN Automation Report");
	sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm::ss");
	
	extent.attachReporter(sparkReporter);
	
	Properties configProp = new Properties();
	File configPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.properties");
	try {
	FileInputStream fisConfigProp = new FileInputStream(configPropFile);
	configProp.load(fisConfigProp);
	}catch(Throwable e) {
		e.printStackTrace();
	}
	extent.setSystemInfo("Application URL",configProp.getProperty("url"));
	extent.setSystemInfo("Email", configProp.getProperty("ValidEmail"));
	extent.setSystemInfo("Password", configProp.getProperty("ValidPassword"));
	
	
	
	return extent;
	
		
	}
	
	
	
}

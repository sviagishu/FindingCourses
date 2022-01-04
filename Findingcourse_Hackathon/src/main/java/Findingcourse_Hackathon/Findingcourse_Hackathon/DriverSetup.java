package Findingcourse_Hackathon.Findingcourse_Hackathon;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utility.Report;


public class DriverSetup extends Report {
	public WebDriver driver;
	public Properties prop;
	public ExtentReports report = Report.getExtentReport();
	public ExtentTest logger;
	
	public void getDriver(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("chrome")) 
			{
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} 
			else if(browserName.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\drivers\\msedgedriver.exe");
				driver = new EdgeDriver();
			}
		}catch (Exception e) 
		{
			
		}
		
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	if(prop==null) {
		
		prop=new Properties();
		
		try {
				FileReader file = new FileReader(System.getProperty("user.dir")+"\\Config.properties");
				prop = new Properties();
				prop.load(file);
			} catch (Exception e) {
			e.printStackTrace();
		}
			
	}

	}
}

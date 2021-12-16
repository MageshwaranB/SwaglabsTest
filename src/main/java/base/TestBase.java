package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	//public static Logger logger;
	public static String browser;
	public TestBase() {
		prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream("./src/main/java/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void initialization() {
		//logger=Logger.getLogger(TestBase.class);
		 browser=prop.getProperty("browser");
		if (browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
//		eventDriver=new EventFiringWebDriver(driver);
//		eListener=new WebListener();
//		eventDriver.register(eListener);
//		driver=eventDriver;
		//logger.info(browser + " is started successully");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	public void tearDown() {
		//logger.info(browser+" is closed successfully");
		driver.close();
	}
}

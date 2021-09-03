package datadriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Excel_Utility;

public class DataDrivenTest
{
	public static WebDriver driver;
	public static Excel_Utility excelReader;
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		String path="./src/main/java/testdata/CheckoutData.xlsx";
		excelReader=new Excel_Utility(path);
		int rowCount=excelReader.getRowCount("Info");
		int colCount=excelReader.getColumnCount("Info");
		for (int row = 2; row <=rowCount; row++) 
		{
			driver=new ChromeDriver();
			driver.get("https://www.saucedemo.com/");
			driver.manage().window().maximize();
			String username=excelReader.getCellData("Info", "username", row);
			String password=excelReader.getCellData("Info", "password", row);
			driver.findElement(By.id("user-name")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.id("login-button")).click();
			driver.close();
		}
	}
}

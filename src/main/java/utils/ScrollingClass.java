package utils;

import java.awt.Window;

import javax.swing.JScrollBar;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollingClass extends TestBase
{
	public static void scrollToThatElement() {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1000)");
	}
	
	

}

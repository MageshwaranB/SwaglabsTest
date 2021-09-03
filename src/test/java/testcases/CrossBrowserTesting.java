package testcases;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CrossBrowserPage;
import pages.Homepage;
import pages.LoginPage;
import pages.SauceLabWebsite;
import utils.ScrollingClass;

public class CrossBrowserTesting extends TestBase
{
	public CrossBrowserTesting() {
		super();
	}
	LoginPage lp;
	Homepage hp;
	SauceLabWebsite sauce;
	CrossBrowserPage cross;
	
	@BeforeMethod
	public void setup() {
		initialization();
		lp=new LoginPage();
		hp=lp.loginDetails(prop.getProperty("username"), prop.getProperty("password"));
		sauce=hp.navigateToAbout();
		cross=sauce.navigateToCross();
	}
	
	@Test
	public void carouselTest() throws InterruptedException {
		ScrollingClass.scrollToThatElement();
		Thread.sleep(5000);
		cross.carouselBtn();
	}
	@AfterMethod
	public void setupClose() {
		tearDown();
	}
}

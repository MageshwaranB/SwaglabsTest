package testcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Homepage;
import pages.LoginPage;
import pages.SauceLabWebsite;
import utils.ScrollingClass;

public class SauceLabsMainWebsiteTest extends TestBase
{
	ScrollingClass sd;
	SauceLabWebsite sauce;
	Homepage hp;
	LoginPage lp;
	public SauceLabsMainWebsiteTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		lp=new LoginPage();
		
		hp=lp.loginDetails(prop.getProperty("username"), prop.getProperty("password"));
		sauce=hp.navigateToAbout();
		sd=new ScrollingClass();
	}
	@Test(priority = 1)
	public void VerifingSauceTitleTest() 
	{
		String actTitle=sauce.verifyPageTitle();
		String expTitle="Cross Browser Testing, Selenium Testing, Mobile Testing | Sauce Lab";
		Assert.assertEquals(actTitle, expTitle,"Title did not match");	
	}
	
	@Test(priority = 2)
	public void navigateToReadMorePageTest() {
		
		ScrollingClass.scrollToThatElement();
		sauce.readStuff();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Test(priority = 3)
	public void navigateToPricingTest() 
	{
		sauce.gotoPricing();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void navigateToCrossBrowserTest() {
		sauce.navigateToCross();
	}
	@AfterMethod
	public void closeSetup() {
		tearDown();
		
	}
}

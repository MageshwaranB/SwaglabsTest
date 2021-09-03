package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Homepage;
import pages.LoginPage;
import pages.Pricing;
import pages.SauceLabWebsite;

public class PricingTest extends TestBase 
{
	LoginPage lp;
	Homepage hp;
	SauceLabWebsite sauce;
	Pricing price;
	public PricingTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		lp=new LoginPage();
		hp = lp.loginDetails(prop.getProperty("username"), prop.getProperty("password"));
		sauce=hp.navigateToAbout();
		price=sauce.gotoPricing();
	}
	
	@Test
	public void verifyPricePageTitle() {
		String expTitle=price.validatePricePageTitle();
		String actTitle="Pricing | Sauce Labs";
		Assert.assertEquals(actTitle, expTitle,"Title doesn't match");
	}
	
	@Test
	public void sortingPrices() 
	{
		price.liveTestingPlan();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void choosingPlanTest() 
	{
		price.selectingPlan();
	}
	@AfterMethod
	public void setupClose() {
		tearDown();
	}
}

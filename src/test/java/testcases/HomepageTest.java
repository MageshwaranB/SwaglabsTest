package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import datadriven.DDTForSwag;
import pages.Homepage;
import pages.LoginPage;
import pages.SauceLabWebsite;
import utils.ExcelUtils;

public class HomepageTest extends TestBase {
	Homepage hp;
	LoginPage lp;
	ExcelUtils excel;
	SauceLabWebsite sauce;
	String sheetname="Info";
	public HomepageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		lp=new LoginPage();
		
		hp = lp.loginDetails(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void validatingHomepageTitleTest() {
		String actText = hp.verifyHomepageTitle();
		String expText = "PRODUCTS";
		Assert.assertEquals(actText, expText, "Text doesn't match with one another");
	}
	
	@DataProvider
	public Object[][] getCheckoutTestData() 
	{
		Object[][] data=excel.getTestData(sheetname);
		return data;
	}
	
	@Test(dataProvider = "getCheckoutTestData")
	public void checkingOutTest(String firstname,String lastname,String zipcode) {
		hp.cartList();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hp.checkingOut(firstname,lastname,zipcode);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void navigateToMainWebsiteTest() {
		sauce=hp.navigateToAbout();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void logoutTest() {
		hp.logout();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void setupClose() {
		tearDown();
	}

}

package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import base.TestBase;
import pages.Homepage;
import pages.LoginPage;

public class LoginTest extends TestBase
{
	Homepage hp;
	LoginPage lp;
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		lp=new LoginPage();
	}
	
	@Test
	public void verifyingLoginTitleTest() {
		
		String actTit=lp.validateTitle();
		String expTitle="Swag Labs";
		Assert.assertEquals(actTit, expTitle,"Login title is not matched");
		
	}
	@Test
	public void logintoWebsiteTest() {
		
		hp=lp.loginDetails(prop.getProperty("username"), prop.getProperty("password"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@AfterMethod
	public void closingSetup() {
		tearDown();
		
	}
	
}

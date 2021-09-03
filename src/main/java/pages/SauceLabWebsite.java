package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utils.ScrollingClass;

public class SauceLabWebsite extends TestBase
{
	@FindBy(xpath = "(//span[text()='Pricing'])[2]")
	WebElement pricing;
	@FindBy(xpath = "//span[text()='Learn More']")
	WebElement readbtn;
	@FindBy(id = "onetrust-accept-btn-handler")
	WebElement acceptBtn;
	@FindBy(xpath = "(//a[text()='Platform'])[2]")
	WebElement platform;
	@FindBy(xpath = "(//span[text()='Cross-browser Testing'])[2]")
	WebElement crossBrowser;
	@FindBy(xpath = "(//section/div/div/div)[12]")
	WebElement scroll;
	
	public SauceLabWebsite() {
		PageFactory.initElements(driver, this);
	}
	public String verifyPageTitle() 
	{
		return driver.getTitle();
	}
	public Pricing gotoPricing() {
		pricing.click();
		return new Pricing();
	}
	public ReadAboutCompany readStuff()
	{
		acceptBtn.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		readbtn.click();
		return new ReadAboutCompany();
	}
	public CrossBrowserPage navigateToCross() {
		Actions actions=new Actions(driver);
		actions.moveToElement(platform).build().perform();
		crossBrowser.click();
		return new CrossBrowserPage();
	}
	
	
}

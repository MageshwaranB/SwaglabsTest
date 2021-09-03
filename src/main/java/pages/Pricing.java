package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class Pricing extends TestBase
{
	@FindBy(name = "live-testing-options")
	WebElement liveTesting;
	@FindBy(xpath = "(//span[text()='Get Started'])[1]")
	WebElement startedBtn;
	@FindBy(xpath = "(//div[@class='link-list']/ul/li/a)[1]")
	WebElement choosePlanBtn;
	@FindBy(xpath = "//a[text()='Test Manually']")
	WebElement needtoBtn;
	@FindBy(xpath = "//a[text()='Website']")
	WebElement wantToBtn;
	@FindBy(xpath = "//a[text()='Desktop']")
	WebElement testToBtn;
	@FindBy(xpath = "//a[text()='Cancel']")
	WebElement cancelBtn;
	@FindBy(className = "browser-default")
	WebElement parallelTest;
	
	public Pricing() {
		PageFactory.initElements(driver,this);
	}
	public String validatePricePageTitle() {
		return driver.getTitle();
	}
	public void liveTestingPlan() {
		Select select=new Select(liveTesting);
		int i=0;
		do {
			select.selectByIndex(i);
			i++;
		}while(i<=12);
		startedBtn.click();
	}
	public void selectingPlan() {
		choosePlanBtn.click();
		needtoBtn.click();
		wantToBtn.click();
		testToBtn.click();
		Select select=new Select(parallelTest);
		int i=0;
		do {
			select.selectByIndex(i);
			i++;
		}while(i<=12);
		cancelBtn.click();
	}
}

package pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class CrossBrowserPage extends TestBase {
	@FindBy(className = "indicators")
	WebElement indicators;
	@FindBy(tagName = "li")
	List<WebElement> links;
	@FindBy(className = "carousel-next")
	WebElement nextBtn;
	
	public CrossBrowserPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyCrossBrowsingTitle() {
		return driver.getTitle();
	}

	public void carouselBtn() {

		List<WebElement> active = indicators.findElements(By.tagName("li"));
		System.out.println(active.size());
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(nextBtn));
		Actions action=new Actions(driver);
		for (int i = 0; i < active.size(); i++) {
			action.moveToElement(nextBtn).click().perform();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		

	}
}

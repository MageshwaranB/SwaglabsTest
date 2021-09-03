package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Homepage extends TestBase 
{
	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	WebElement addBag;
	@FindBy(id = "add-to-cart-sauce-labs-bike-light")
	WebElement addLight;
	@FindBy(id = "shopping_cart_container")
	WebElement clickingShopTrolleybtn;
	@FindBy(id = "checkout")
	WebElement checkoutBtn;
	@FindBy(id = "first-name")
	WebElement fname;
	@FindBy(id = "last-name")
	WebElement lname;
	@FindBy(id = "postal-code")
	WebElement zipCode;
	@FindBy(id = "continue")
	WebElement continueBtn;
	@FindBy(id = "finish")
	WebElement finishBtn;
	@FindBy(id = "react-burger-menu-btn")
	WebElement burgerBtn;
	@FindBy(id = "about_sidebar_link")
	WebElement aboutLink;
	@FindBy(xpath = "//span[text()='Products']")
	WebElement product;
	@FindBy(id = "logout_sidebar_link")
	WebElement logoutBtn;
	
	public Homepage() {
		PageFactory.initElements(driver, this);
	}
	public String verifyHomepageTitle() {
		return product.getText();
	}
	
	public void cartList()
	{
		addBag.click();
		addLight.click();
		clickingShopTrolleybtn.click();
	}
	public void checkingOut(String first,String last,String postalCode) {
		checkoutBtn.click();
		fname.sendKeys(first);
		lname.sendKeys(last);
		zipCode.sendKeys(postalCode);
		continueBtn.click();	
		finishBtn.click();
	}
	public SauceLabWebsite navigateToAbout() {
		burgerBtn.click();
		aboutLink.click();
		return new SauceLabWebsite();
	}
	public SauceLabWebsite logout() {
		burgerBtn.click();
		logoutBtn.click();
		return new SauceLabWebsite();
	}
}

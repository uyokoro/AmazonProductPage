package PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPageObjects {

	WebDriver driver;

	@FindBy(id = "sp-cc-accept")
	public WebElement AcceptButton;

	@FindBy(id = "twotabsearchtextbox")
	public WebElement SearchforItem;

	@FindBy(id = "nav-search-submit-button")
	public WebElement ClickOnSearchButton;

	@FindBy(xpath = "(//img[@class='s-image'])[1]")
	public WebElement ClickOnFirstItemMonitor;

	@FindBy(xpath = "(//img[@class='s-image'])[2]")
	public WebElement ClickOnSecondItemLaptop;

	@FindBy(id = "add-to-cart-button")
	public WebElement AddItemToCart;

	@FindBy(xpath = "//input[@aria-labelledby='attachSiNoCoverage-announce']")
	public WebElement NoThanksButton;

	@FindBy(xpath = "//a[@href='/cart?ref_=sw_gtc']")
	public WebElement ClickOnCart;

	@FindBy(xpath = "(//span[@class='a-offscreen'])[2]")
	public WebElement ProductPagePrice;

	@FindBy(xpath = "(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold'])[1]")
	public WebElement CartPagePrice;

	@FindBy(xpath = "(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap'])[2]")
	public WebElement CartPageSubTotal;

	public AmazonPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void AcceptButton() {

		AcceptButton.click();
	}

	public void SearchforItem(String item) {

		SearchforItem.sendKeys(item);
	}

	public void ClickOnSearchButton() {

		ClickOnSearchButton.click();
	}

	public void ClickOnFirstItemMonitor() {

		ClickOnFirstItemMonitor.click();
	}

	public void ClickOnSecondItemLaptop() {

		ClickOnSecondItemLaptop.click();
	}

	public void AddItemToCart() {

		AddItemToCart.click();
	}

	public void NoThanksButton() {

		NoThanksButton.click();
	}

	public void ClickOnCart() {

		ClickOnCart.sendKeys(Keys.ENTER);
	}

	public String ProductPagePrice() {

		return ProductPagePrice.getAttribute("textContent");
	}

	public String CartPagePrice() {

		return CartPagePrice.getAttribute("textContent");
	}

	public String CartPageSubTotal() {

		return CartPageSubTotal.getAttribute("textContent");

	}

}
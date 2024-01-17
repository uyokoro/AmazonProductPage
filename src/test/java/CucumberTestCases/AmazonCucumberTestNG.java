package CucumberTestCases;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import PageObject.AmazonPageObjects;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonCucumberTestNG {

	public static WebDriver driver;
	public static AmazonPageObjects amazonPageObjects;
	static SoftAssert softAssert = new SoftAssert();
	public String PagePrice;

	@Before
	public static void before() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		amazonPageObjects = new AmazonPageObjects(driver);
		driver.manage().window().maximize();

	}

	@Given("open Amazon.com")
	public void open_amazon_com() {

		driver.get("https://www.amazon.co.uk/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		amazonPageObjects.AcceptButton();
	}

	@Given("in the Search field type “Monitor”")
	public void in_the_search_field_type_monitor() {

		amazonPageObjects.SearchforItem.sendKeys("Monitor");
	}

	@Then("press “Enter”")
	public void press_enter() {

		amazonPageObjects.ClickOnSearchButton();
	}

	@Then("select the 1st item in the List")
	public void select_the_1st_item_in_the_list() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		amazonPageObjects.ClickOnFirstItemMonitor();
	}

	@Then("add the item to cart by clicking on \"Add to Cart”")
	public void add_the_item_to_cart_by_clicking_on_add_to_cart() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		amazonPageObjects.AddItemToCart();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		amazonPageObjects.NoThanksButton();
		PagePrice = amazonPageObjects.ProductPagePrice();
		System.out.println(PagePrice);
	}

	@Then("open “Cart” from the top-left")
	public void open_cart_from_the_top_left() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		amazonPageObjects.ClickOnCart();
	}

	@Then("verify that the price is identical to the product page")
	public void verify_that_the_price_is_identical_to_the_product_page() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String CartPrice = amazonPageObjects.CartPagePrice();
		softAssert.assertEquals(PagePrice, CartPrice,
				"Attribute value mismatch for Product Page Price and Cart Page Price");
		System.out.println(CartPrice);

	}

	@Then("verify that the sub total is identical to the product page")
	public void verify_that_the_sub_total_is_identical_to_the_product_page() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String CartPageSubTotal = amazonPageObjects.CartPageSubTotal();
		softAssert.assertEquals(PagePrice, CartPageSubTotal,
				"Attribute value mismatch for Product Page Price and Cart Page SubTotal");
		System.out.println(CartPageSubTotal);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Given("in the Search field type “Laptop”")
	public void in_the_search_field_type_laptop() {

		amazonPageObjects.SearchforItem.sendKeys("Laptop");
	}

	@Then("select the 2nd item in the List")
	public void select_the_2nd_item_in_the_list() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		amazonPageObjects.ClickOnSecondItemLaptop();

	}

	@After
	public static void after() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		softAssert.assertAll();

		if (driver != null) {
			driver.quit();
		}

	}

}

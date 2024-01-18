package TestNGTestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObject.AmazonPageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LaptopTestNG {
	public WebDriver driver;
	public AmazonPageObjects amazonPageObjects;
	SoftAssert softAssert = new SoftAssert();

	@Test
	public void LaptopTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		amazonPageObjects = new AmazonPageObjects(driver);
		amazonPageObjects.AcceptButton();
		amazonPageObjects.SearchforItem.sendKeys("Laptop");
		amazonPageObjects.ClickOnSearchButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		amazonPageObjects.ClickOnSecondItemLaptop();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String PagePrice = amazonPageObjects.ProductPagePrice();
		System.out.println(PagePrice);

		amazonPageObjects.AddItemToCart();
		amazonPageObjects.NoThanksButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		amazonPageObjects.ClickOnCart();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		String CartPrice = amazonPageObjects.CartPagePrice();
		System.out.println(CartPrice);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String CartSubTotal = amazonPageObjects.CartPageSubTotal();
		System.out.println(CartSubTotal);

		softAssert.assertEquals(PagePrice, CartPrice,
				"Attribute value mismatch for Product Page Price and Cart Page Price");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		softAssert.assertEquals(PagePrice, CartSubTotal,
				"Attribute value mismatch for Product Page Price and Cart Page SubTotal");

		softAssert.assertAll();

	}

	@BeforeTest
	public void beforeTest() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.co.uk/");
		driver.manage().window().maximize();
		
		//Enter CAPTCHA - for Next Test Step to Run
	}

	@AfterTest
	public void afterTest() {

		if (driver != null) {
			driver.quit();
		}
	}

}

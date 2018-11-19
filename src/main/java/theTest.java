import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import Pages.Home;
import Pages.Solutions;
import Pages.searchResults;

public class theTest {

	private String url = "http://automationpractice.com/index.php";
	private WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\Downloads\\chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();

	}

	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void testShoppingSearch() {

		driver.manage().window().maximize();
		driver.get(url);

		// searches and submits request
		Home page = PageFactory.initElements(driver, Home.class);

		page.searchFor("dress");

		// Selects the dress from next page
		searchResults summerDress = PageFactory.initElements(driver, searchResults.class);

		summerDress.selectDress();

		// Extracts string from Summer Dress page
		Solutions dressPage = PageFactory.initElements(driver, Solutions.class);

		assertEquals("Printed Summer Dress", dressPage.getName());

	}

}
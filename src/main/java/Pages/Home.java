package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class Home {

	@FindBy(name = "search_query")
	private WebElement searchBox;

	@FindBy(xpath = "//*[@id=\"searchbox\"]/button")
	private WebElement gotButton;

	public void searchFor(String text) {

		searchBox.sendKeys(text);
		searchBox.submit();
		gotButton.click();

	}
}

package selenium.web.automation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LinkPrint {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\eclipse-workspace\\Practice\\chromedriver.exe");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //for page loading
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);//for element loading
		
		driver.get("https://www.wikipedia.org/");
		List<WebElement> link = driver.findElements(By.tagName("a"));

		System.out.println(link.size());

		for (WebElement el : link) {
			System.out.println(el.getAttribute("href"));
		}
	}
}
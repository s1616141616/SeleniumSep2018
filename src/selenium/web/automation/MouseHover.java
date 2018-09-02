package selenium.web.automation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\eclipse-workspace\\Practice\\chromedriver.exe");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); // for page loading
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// for element loading

		driver.get("https://www.viasat.com/");

		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(
				By.xpath("//a[@href='/services-systems'" + " and @class='sf-depth-1 menuparent sf-with-ul']"))).build()
				.perform();

		List<WebElement> list = driver
				.findElements(By.xpath("//div[@class='sf-megamenu-column']//a[@class='sf-depth-2 menuparent']"));
		System.out.println(list.size());

		for (WebElement element : list) {
			// System.out.println(element.getText());
			System.out.println(element.getAttribute("href"));
		}

		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@href='/services/business'" + " and @class='column-2-wide sf-depth-3']"))
				.click();

		Thread.sleep(5000);
		driver.quit();
	}
}
package selenium.web.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BootStrapPopup {

	WebDriver driver;

	@BeforeMethod

	public void launchBrowser() throws Exception {

		System.setProperty("webdriver.chrome.driver", "D:\\eclipse-workspace\\Practice\\chromedriver.exe");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");

		driver = new ChromeDriver(chromeOptions);
		// WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); // for page loading
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// for element loading

		driver.get("https://www.honest.com");

	}

	@Test

	public void popupClosingTest() {

		driver.findElement(By.xpath("//div[@id='bx-element-622589-Fb4KQ0e']//button[@type='reset']")).click();

		driver.quit();
	}
}
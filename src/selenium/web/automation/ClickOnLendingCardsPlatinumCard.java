package selenium.web.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ClickOnLendingCardsPlatinumCard {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "D:\\eclipse-workspace\\July2018\\src\\Driver\\geckodriver.exe");

		DesiredCapabilities cap = new DesiredCapabilities();

		cap = DesiredCapabilities.firefox();
		cap.setBrowserName("firefox");
		cap.setVersion("your firefox version");
		cap.setPlatform(Platform.WINDOWS);
		cap.setCapability("marionette", false);

		WebDriver driver = new FirefoxDriver(cap);

		driver.get("http://www.cnb.com");

		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.id("cnb-menu-ourservices"))).build().perform();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[text()='Cards']")).click();
		Thread.sleep(3000);

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,300)", "");
		
		
		// both works
		/*
		 * je.executeScript("arguments[0].scrollIntoView(true);",
		 * driver.findElement(By.xpath("//img[@src='/images/Platinum-Card-sm.png']")));
		 */

		driver.findElement(By.xpath("//img[@src='/images/Platinum-Card-sm.png']")).click();

		Thread.sleep(3000);

		driver.close();

	}
}
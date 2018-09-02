package selenium.web.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverOurServicw {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
					"D:/eclipse-workspace/July2018/src/Driver/chromedriver.exe");
		ChromeOptions winMax = new ChromeOptions();
		winMax.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(winMax);

		driver.get("http://www.cnb.com");

		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.id("cnb-menu-ourservices"))).build().perform();

		Thread.sleep(3000);
		driver.quit();

	}
}
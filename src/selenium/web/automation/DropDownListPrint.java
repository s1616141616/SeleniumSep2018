package selenium.web.automation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
/*to find related xpath
	a[text ='....']//parent::td[@class='....']//preceding-sibling::td[@class='']//input
	a[text ='....']//parent::td[@class='....']//forward-sibling::td[@class='']//input
	
	//www.freecrm.com 
*/

public class DropDownListPrint {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "D:\\eclipse-workspace\\BasicWebDriver\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); // for page loading
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// for element loading

		driver.get("https://www.wikipedia.org/");
		// Thread.sleep(3000);

		List<WebElement> drop = driver.findElements(By.name("language"));

		for (WebElement element : drop) {
			System.out.println(element.getText());
		}
		// different way
		/*
		 * java.util.Iterator<WebElement> i = drop.iterator(); while (i.hasNext()) {
		 * WebElement row = i.next(); System.out.println(row.getText()); }
		 */

		driver.quit();
	}
}
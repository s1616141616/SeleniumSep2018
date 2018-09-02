package selenium.web.automation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MacysMenuList {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "D:\\eclipse-workspace\\Practice\\chromedriver.exe");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); // for page loading
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// for element loading

		driver.get("https://www.macys.com/");

		// this to close temporary pop-up window! can ignore if pop-up dosen't exist :)
		driver.findElement(By.xpath(".//*[@id='closeIcon']")).click();

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"flexid_22672\"]/a/span"))).build().perform();

		List <WebElement> list = driver.findElements(By.xpath("//ul[@class='flexLabelLinksContainer']"));
		System.out.println(list.size());

		for (WebElement element : list) {
			 System.out.printf(element.getText().trim());
			//System.out.println(element.getText().trim());
		}
		
		driver.findElement(By.xpath("//*[@id=\"mainNavigationFlyouts\"]/div[3]/div[2]/ul[1]/li[8]/a")).click();
		
		Thread.sleep(3000);
		
		driver.quit();
	}
}
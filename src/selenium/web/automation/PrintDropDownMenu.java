package selenium.web.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PrintDropDownMenu {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"D:\\eclipse-workspace\\SeleniumPractice\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.espn.com/soccer/");

		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Teams')]//parent::a"))).build()
				.perform();
		Thread.sleep(3000);

		/*// List<WebElement> list=
		// driver.findElements(By.xpath("//*[contains(@id,'global-nav-secondary')]"));
		// List<WebElement> list=
		// driver.findElements(By.xpath("//nav[@class='global-nav-secondary-soccer']"));
		// List<WebElement> list=
		// driver.findElements(By.xpath("//nav[@class='global-nav-secondary-soccer']//div//ul//li[6]"));
		 */		
		
		List<WebElement> list = driver.findElements(By.xpath("//nav[@class='global-nav-secondary-soccer']//div//ul//li[6]//div//ul//li//a//span[2]"));

		System.out.println(list.size());

		for (WebElement element : list) {

			System.out.println(element.getText());
		}

		driver.findElement(By.xpath("//span[contains(text(),'Liverpool')]//parent::a")).click();

		Thread.sleep(3000);

		driver.quit();
	}
}
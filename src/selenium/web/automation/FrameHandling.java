package selenium.web.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FrameHandling {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\eclipse-workspace\\Practice\\chromedriver.exe");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //for page loading
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);//for element loading
		
		driver.get("https://www.freecrm.com/index.html");

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("saifqae");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("saifqae");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();

		//Thread.sleep(3000);

		driver.quit();
	}
}
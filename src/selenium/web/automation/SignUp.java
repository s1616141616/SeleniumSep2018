package selenium.web.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//driver.findElement(By.xpath("//a//button[@class='btn']")).click();
//
//WebDriverWait wait =new WebDriverWait(driver,30);
//WebElement element =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn']")));

public class SignUp {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\eclipse-workspace\\Practice\\chromedriver.exe");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //for page loading
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);//for element loading
		
		driver.get("http://www.freecrm.com");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@class='btn']")).click();
		
		Thread.sleep(2000);
		driver.quit();
	}
}
package selenium.web.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AlertPopUpHandle {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "D:\\eclipse-workspace\\Practice\\chromedriver.exe");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //for page loading
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);//for element loading
		
		driver.navigate().to("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		String text =alert.getText();
		
		if (text.equals("Please enter a valid user name")) {
			System.out.println("Test Pass!!!");
		}else {
			System.out.println("Test failed!!!");
		}
		Thread.sleep(3000); //to read the alert msg!!!
		
		alert.accept();		//alert.dismiss(); to click on cancel button

		Thread.sleep(3000);

		driver.quit();
	}
}
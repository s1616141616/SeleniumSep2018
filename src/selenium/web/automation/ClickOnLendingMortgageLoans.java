package selenium.web.automation;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class ClickOnLendingMortgageLoans {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", 
				"D:\\eclipse-workspace\\July2018\\src\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.cnb.com");

		Actions actn = new Actions(driver);

		actn.moveToElement(driver.findElement(By.xpath
				("//a[contains(text(),'Our Services')]"))).build().perform();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Mortgage Loans')]")).click();
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(
				"D:\\eclipse-workspace\\July2018\\src\\Screenshot\\img" + System.currentTimeMillis() + ".png"));
		
		Thread.sleep(3000);
		driver.close();
		
	}
}
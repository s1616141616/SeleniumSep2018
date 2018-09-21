package selenium.web.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DatePicker {
	WebDriver driver;

	@Test
	public void selectDate() throws InterruptedException {

		System.setProperty("webdriver.gecko.driver",
				"D:\\eclipse-workspace\\SeleniumPractice\\Driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.tripadvisor.com/");

		driver.findElement(By.xpath("//span[contains(text(),'Check In')]")).click();
		Thread.sleep(3000);

		List<WebElement> list = driver.findElements(By.xpath("//span[@class='rsdc-month-title']"));

		for (WebElement i : list) {
			System.out.println(i.getText());
		}

		String inDate = "27-September-2018";
		String inDateArr[] = inDate.split("-");
		String inDay = inDateArr[0];
		String inMonth = inDateArr[1];
		String inYear = inDateArr[2];

		String outDate = "27-October-2018";
		String outDateArr[] = outDate.split("-");
		String outDay = outDateArr[0];
		String outMonth = outDateArr[1];
		String outYear = outDateArr[2];

		List<WebElement> inDates = driver.findElements(By.xpath("//span[contains(@class, 'rsdc-cell rsdc-day')]"));

		for (WebElement e : inDates) {
			String DateIn = e.getText();
				if (DateIn.equals(inDay)) {
				e.click();
				break;
			}
		}

		List<WebElement> outDates = driver.findElements(By.xpath("//span[@class='rsdc-cell rsdc-day']"));

		for (WebElement e : outDates) {
			String DateOut = e.getText();
				if (DateOut.equals(outDay)) {
				e.click();
				break;
			}
		}
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
}
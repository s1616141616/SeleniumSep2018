package selenium.web.automation;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Psi {

	//public static void main(String[] args) throws Exception {
	
@Test
public void psiTest() throws Exception{
	
		System.setProperty("webdriver.chrome.driver",
				"D:\\eclipse-workspace\\July2018\\src\\Driver\\chromedriver.exe");

		ChromeOptions winMax = new ChromeOptions();
		winMax.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(winMax);

		driver.get("http://www.psionline.com");

		Actions action = new Actions(driver);
				
		//Mouse Hover To Markets Link
		action.moveToElement(driver.findElement(By.xpath(
						"//a[contains(@class,'layout-text_only')]"
					  +	"//following::span[contains(text(),'Markets')]"))).build().perform();
						Thread.sleep(3000);
		System.out.println("Mouse Hover To Markets Link Successful!!!");
		
		//Clicking on Selection SubMenu From Markets
		driver.findElement(By.xpath(
				"//a[contains(@class,'')]"
			  + "//following::img[contains(@src,'/wp-content/uploads/block-ta-hire-300x300.jpg')][2]")).click();
				Thread.sleep(3000);
		System.out.println("Clicking on Selection SubMenu From Markets Successful!!!");
		
		//Validating
		
		String text = driver.findElement(By.xpath("//h1")).getText();
		System.out.println(text);
		Assert.assertEquals("Selection",text);
		System.out.println("Validation Successful!!!");
		
		//Taking Screenshot
		
		TakesScreenshot ts =(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(
				"D:\\eclipse-workspace\\July2018\\src\\Screenshot\\img" + System.currentTimeMillis() + ".png"));
		System.out.println("Screenshot Taken");
		
		//Navigating back to Home
		driver.findElement(By.xpath("//a[contains(@class,'navbar-brand')]")).click();
		System.out.println("You are now in Home!!!");
		
		//For Mouse Hover To Company Link
		Actions actn = new Actions(driver);

		actn.moveToElement(driver.findElement(
				By.xpath("//a[contains(@class,'')]"
					   + "//following::span[contains(text(),'Company')][2]"))).build().perform();
						Thread.sleep(3000);
		System.out.println("Mouse Hover To Company Link Successful!!!");
		
		//Navigating back to Home
		driver.findElement(By.xpath("//a[contains(@class,'navbar-brand')]")).click();
		Thread.sleep(3000);
		System.out.println("Wellcome back Home again!!!");
		driver.close();
		
		System.out.println("Well Done!!! Test Succeded :D");
	}
}
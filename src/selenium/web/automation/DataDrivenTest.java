package selenium.web.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class DataDrivenTest {

	public static void main(String[] args) throws Exception {

		Logger logger = Logger.getLogger("DataDriverTest");
		PropertyConfigurator.configure("log4j.properties");

		System.setProperty("webdriver.gecko.driver",
				"D:\\eclipse-workspace\\SeleniumPractice\\Driver\\geckodriver.exe");
		WebDriver fxDriver = new FirefoxDriver();

		logger.info("firefox");
		fxDriver.get(
				"https://login.yahoo.com/account/create?lang=&done=https%3A%2F%2Fmail.yahoo.com%2F&src=ym&specId=yidReg");
		logger.info("page opened");

		// Connect data source
		Xls_Reader reader = new Xls_Reader("D:\\eclipse-workspace\\SeleniumPractice\\Utility\\testData.xlsx");

		int rowCount = reader.getRowCount("Sheet1");

		// reader.addColumn("Sheet1", "Status"); //ADD new Column

		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			String firstname = reader.getCellData("Sheet1", "firstname", rowNum);
			System.out.println(firstname);

			String lastname = reader.getCellData("Sheet1", "lastname", rowNum);
			System.out.println(lastname);

			String emailaddress = reader.getCellData("Sheet1", 2, rowNum);
			System.out.println(emailaddress);

			String password = reader.getCellData("Sheet1", 3, rowNum);
			System.out.println(password);

			String cell = reader.getCellData("Sheet1", "cell", rowNum);
			System.out.println(cell);

			String month = reader.getCellData("Sheet1", "month", rowNum);
			System.out.println(month);

			String day = reader.getCellData("Sheet1", "day", rowNum);
			System.out.println(day);

			String year = reader.getCellData("Sheet1", "year", rowNum);
			System.out.println(year);

			String gender = reader.getCellData("Sheet1", "gender", rowNum);
			System.out.println(gender);

			// Registration

			fxDriver.findElement(By.xpath("//input[contains(@class, 'ureg-fname ')]")).clear();
			fxDriver.findElement(By.xpath("//input[contains(@class, 'ureg-fname ')]")).sendKeys(firstname);

			fxDriver.findElement(By.xpath("//input[contains(@class, 'ureg-lname ')]")).clear();
			fxDriver.findElement(By.xpath("//input[contains(@class, 'ureg-lname ')]")).sendKeys(lastname);

			fxDriver.findElement(By.xpath("//input[@name= 'yid']")).clear();
			fxDriver.findElement(By.xpath("//input[@name= 'yid']")).sendKeys(emailaddress);

			fxDriver.findElement(By.xpath("//input[@name= 'password']")).clear();
			fxDriver.findElement(By.xpath("//input[@name= 'password']")).sendKeys(password);

			fxDriver.findElement(By.xpath("//input[@name='phone']")).clear();
			fxDriver.findElement(By.xpath("//input[@name='phone']")).sendKeys(cell);
			Thread.sleep(1000);
			Select select = new Select(fxDriver.findElement(By.xpath("//select [@id]")));
			select.selectByVisibleText(month);

			fxDriver.findElement(By.xpath("//input[@name='dd']")).clear();
			fxDriver.findElement(By.xpath("//input[@name='dd']")).sendKeys(day);

			fxDriver.findElement(By.xpath("//input[@name='yyyy']")).clear();
			fxDriver.findElement(By.xpath("//input[@name='yyyy']")).sendKeys(year);

			fxDriver.findElement(By.xpath("//input [@name ='freeformGender']")).clear();
			fxDriver.findElement(By.xpath("//input [@name ='freeformGender']")).sendKeys(gender);

			// reader.setCellData("Sheet1", "Status", rowNum, "Pass"); //WRITE to a column
			Thread.sleep(2000);

//			fxDriver.close();
		}
	}

}
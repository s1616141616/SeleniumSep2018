package selenium.web.automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadWriteDataFromXL {

	@Test
	public void readWriteXLFile() throws IOException {

		Xls_Reader reader = new Xls_Reader("D:\\eclipse-workspace\\SeleniumPractice\\Utility\\testData.xlsx");
		reader.addColumn("Sheet2", "Status");

		int rowCount = reader.getRowCount("Sheet2");

		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {

			String Name = reader.getCellData("Sheet2", "Name", rowNum);
			System.out.println("Name is: " + Name);

			String Age = reader.getCellData("Sheet2", "Age", rowNum);
			System.out.println("Age is: " + Age);

			reader.setCellData("Sheet2", "Status", rowNum, "Pass");
		}
	}

	@Test
	public void readWriteXLFileTest() throws IOException {

		File src = new File("D:\\eclipse-workspace\\SeleniumPractice\\Utility\\testData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheetAt(2);

		int rowCount = ws.getLastRowNum();

		for (int i = 1; i <= rowCount; i++) {
			System.out.println("First Name is: " + ws.getRow(i).getCell(0).getStringCellValue());
			System.out.println("Last Name is: " + ws.getRow(i).getCell(1).getStringCellValue());
		}

		ws.getRow(0).createCell(2).setCellValue("Status");
		ws.getRow(1).createCell(2).setCellValue("Pass");
		ws.getRow(2).createCell(2).setCellValue("Fail");
		FileOutputStream fout = new FileOutputStream(src);
		wb.write(fout);

	}
}
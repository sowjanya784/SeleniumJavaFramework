package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelDataProvider {
	
	WebDriver driver = null;
	
	public void setupTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}

	@Test(dataProvider = "test1data")
	public void test1(String username, String password) {
		System.out.println(username + " | " + password);
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		
	}
	
	@DataProvider(name = "test1data")
	public Object getData() {
		
		String excelPath = "/Users/sowjanya/eclipse-workspace/SeleniumFrameworkWithJava/Excel/data.xlsx";
		Object data = (Object) testData(excelPath, "sheet1");
		return data;
	}

	private Object testData(String excelPath, String sheetName) {

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		
		int rowCount = excel.getRowCount();
		int colCount = excel.getColumnCount();
		
		Object data[][] = new Object[rowCount - 1][colCount];
		
		for(int i = 1; i < rowCount; i++) {
			for(int j = 0; j < colCount; j++) {
				String cellData = excel.getCellDataString(i, j);
				data[i-1][j] = cellData;
			}
		}
		
		return data;
		
	}

}

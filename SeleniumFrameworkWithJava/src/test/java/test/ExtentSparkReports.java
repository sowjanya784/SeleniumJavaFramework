package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentSparkReports {

	public static void main(String[] args) {

		//create extent report and attach reporters
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");
		extent.attachReporter(spark);

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		//create a toggle for the given test, to log all events and info
		ExtentTest test = extent.createTest("GoogleSearch test one", "This is a test to validate google functionality");

		test.log(Status.INFO, "Starting testcase");
		driver.get("https://google.com");
		test.pass("Navigated to google");

		driver.findElement(By.name("q")).sendKeys("Selenium");
		test.pass("Entered Selenium");

		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test.pass("Pressed Enter on keyboard ");

		driver.quit();
		test.pass("Exited browser");

		test.info(" Test finished");

		//test2 for fail
		//create a toggle for the given test, to log all events and info
		ExtentTest testF = extent.createTest("GoogleSearch test two/fail", "This is a test to validate google functionality");

		testF.log(Status.INFO, "Starting testcase");
		driver.get("https://google.com");
		test.pass("Navigated to google");

		driver.findElement(By.name("q")).sendKeys("Selenium");
		testF.pass("Entered Selenium");

		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		testF.fail("Pressed Enter on keyboard, sample fail");

		driver.quit();
		testF.pass("Exited browser");

		testF.info(" Test finished");

		//Have to flush the report otherwise report is not generated
		extent.flush();
	}

}

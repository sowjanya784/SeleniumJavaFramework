package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportswithTestNG {
	
	ExtentReports extent;
	WebDriver driver;
	ExtentTest test;
	
	@BeforeSuite
	public void setup() {
		
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");
		extent.attachReporter(spark);
	}
	
	@BeforeTest
	public void setupTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}

	@Test
	public void test1() {
		
		test = extent.createTest("Extent Reports with TestNG", "HSample reports");

		driver.get("https://google.com");
		test.pass("Navigated to google");
		
		test.log(Status.INFO, "shows usage of logs");
		test.info("shows usage of info");
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("./img/screenshot.png").build());
		test.addScreenCaptureFromPath("./img/screenshot.png");
		
	}
	
	@Test
	public void test2() {
	
		test.log(Status.INFO, "shows usage of logs");
		test.info("shows usage of info");
		test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test.addScreenCaptureFromPath("screenshot.png");
		
	}
	
	@AfterTest
	public void tearDownTest() {
		driver.quit();
		test.pass("Browser closed");
	}
	@AfterSuite
	public void tearDown() {
		
		extent.flush();
	}
}

package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGParallelMethods {
	
	//for a single test in a multithreaded way this methos is run 3 times
	@Test(threadPoolSize = 3, invocationCount = 3, timeOut = 1000)
	public void test1() throws InterruptedException {
		System.out.println("In test one |" + Thread.currentThread().getName());
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		Thread.sleep(4000);
		driver.quit();
	}
	
	@Test
	public void test2() throws InterruptedException {
		System.out.println("In test test2 |" + Thread.currentThread().getName());
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/");
		Thread.sleep(4000);
		driver.quit();
	}
}

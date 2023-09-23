package Listeners_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(TestNGListeners.class)
public class TestNGListenersDemo {
	
	@Test
	public void test1() {
		System.out.println("In test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("In test 2");
//		Assert.assertTrue(false);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
		
		driver.findElement(By.name("q")).sendKeys("abc");
		driver.findElement(By.name("qst")).sendKeys("abc");	//intended to fail
		
		driver.quit();
	}
	@Test
	public void test3() {
		System.out.println("In test 3");
//		throw new SkipException("this test is skipped");
	}

}

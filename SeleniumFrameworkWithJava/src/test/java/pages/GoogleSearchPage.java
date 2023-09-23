package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {
	
	public static WebElement textBoxSearch(WebDriver driver) {
		return driver.findElement(By.name("q"));
	}
	
	public static WebElement buttonSearch(WebDriver driver) {
		return driver.findElement(By.name("btnK"));
	}

}

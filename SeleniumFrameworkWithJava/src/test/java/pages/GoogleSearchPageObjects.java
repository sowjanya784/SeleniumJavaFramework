package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObjects {

	By textBox_Search = By.id("APjFqb");
	By search_Button = By.name("btnK");
	
	WebDriver driver = null;
	public GoogleSearchPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setTextInSearch(String text) {
		driver.findElement(textBox_Search).sendKeys(text);
	}
	
	public void clickSearchButton() {
		driver.findElement(search_Button).click();
	}

}

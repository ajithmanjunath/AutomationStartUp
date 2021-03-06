package qsp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		//usage of navigate() instead of get()
		driver.navigate().to("http://www.google.com/");
		String url = driver.getCurrentUrl();
		System.out.println("WebPage URL:"+url);
		//usage ENTER key instead of clicking on Google Search button
		driver.findElement(By.id("lst-ib")).sendKeys("Selenium WebDriver",Keys.ENTER);
		driver.findElement(By.linkText("Selenium WebDriver")).click();
		driver.findElement(By.xpath("(//a[text()='Selenium WebDriver'])[1]")).click();
		//refreshing page
		driver.navigate().refresh();
		String title = driver.getTitle();
		System.out.println("WebPage Title:"+ title);
		//navigating back
		driver.navigate().back();
		driver.quit();
	}

}

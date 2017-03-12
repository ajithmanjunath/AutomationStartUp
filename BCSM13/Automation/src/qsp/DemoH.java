package qsp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DemoH {

	public static ArrayList<String> allTextFromListBox(WebElement monthList){
		Select month = new Select(monthList);
		List<WebElement> allOptions = month.getOptions();
		ArrayList<String> allTexts = new ArrayList<String>();
		for(WebElement option:allOptions){
			String text = option.getText();
			allTexts.add(text);
		}
		return allTexts;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		WebElement monthList = driver.findElement(By.id("month"));
		ArrayList<String> allTexts = allTextFromListBox(monthList);
		//Collections.sort(allTexts);
		for(String text:allTexts){
			System.out.println(text);
		}
		
	}

}

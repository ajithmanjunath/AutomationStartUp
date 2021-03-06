package generic;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public abstract class BasePage {

	public WebDriver driver;
	public WebDriverWait wait;
	
	public BasePage(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
		PageFactory.initElements(driver, this);
	}
	
	public void verifyTitle(String eTitle){
		try{
			wait.until(ExpectedConditions.titleIs(eTitle));
			Reporter.log("Title Matched : PASS",true);
		}
		catch(TimeoutException t){
			Reporter.log("Title did not Match : FAIL",true);
			Assert.fail();
		}	
	}
	
	
	public void verifyElementIsPresent(WebElement element){
		try{
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("Element is present",true);

		}
		catch(TimeoutException e){
			Reporter.log("Element is not present",true);
			Assert.fail();
		}
	}
}

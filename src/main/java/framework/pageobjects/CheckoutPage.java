package framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.Abstractcomponent.Abstractcomponent;

public class CheckoutPage extends Abstractcomponent {

	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	 @FindBy(css="[placeholder='Select Country']")
	    WebElement country;
	 
	 @FindBy(xpath="(//a[normalize-space()='Place Order'])[1]")
	    WebElement submit;
	 
	 @FindBy(xpath= "(//button[@type='button'])[2]")
	    WebElement selectCountry;
	 
	 By results = By.cssSelector(".ta-results");
	 
	 public void selectCountry(String countryName) throws InterruptedException
	 {
		 
	      Actions a =new Actions(driver);
	      a.sendKeys(country,countryName).build().perform();
	      waitForElementToAppear(By.cssSelector(".ta-results"));
	      selectCountry.click();
	      
	 }
	 
	 public ConfirmationPage submitOrder() {
		 try {
		     submit.click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", submit);	  
	}

	  return new ConfirmationPage(driver);
 }
}

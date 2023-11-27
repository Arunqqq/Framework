package framework.Abstractcomponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.pageobjects.CartPage;
import framework.pageobjects.OrderPage;

public class Abstractcomponent {
	
	WebDriver driver;
    public Abstractcomponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
	}

    //driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
    @FindBy(css="[routerlink*='cart']")
    WebElement cartHeader;
    
    @FindBy(css="[routerlink*='myorders']")
    WebElement orderHeader;

	public void waitForElementToAppear(By findBy) throws InterruptedException
    {
			Thread.sleep(1000);
    //WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    //Wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
	
	public void waitForWebElementToAppear(WebElement findBy) throws InterruptedException 
    {
		Thread.sleep(1000);
    //WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    //Wait.until(ExpectedConditions.visibilityOf(findBy));
    }
	
	public CartPage goToCartPage()
	{
		cartHeader.click();
		CartPage cartPage=new CartPage(driver);
		return cartPage;
	}
	
	public OrderPage goToOrderPage()
	{
		orderHeader.click();
	    OrderPage orderPage=new OrderPage(driver);
		return orderPage;
	}
	
	
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException
	{
	
	 Thread.sleep(1000);
	// WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(3));
	 //wait.until(ExpectedConditions.invisibilityOf(ele));
		
	}
}

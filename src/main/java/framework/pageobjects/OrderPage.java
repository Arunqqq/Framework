package framework.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import framework.Abstractcomponent.Abstractcomponent;

public class OrderPage extends Abstractcomponent {
	
	WebDriver driver;
		
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement> cartProducts;
	
    public OrderPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
    	super(driver);
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
	}
    
    public Boolean verifyOrderDisplay(String productName) 
    { 
    Boolean match=cartProducts.stream().anyMatch(cartProduct->
    cartProduct.getText().equalsIgnoreCase(productName));
    return match; 	
    }
    
    
}
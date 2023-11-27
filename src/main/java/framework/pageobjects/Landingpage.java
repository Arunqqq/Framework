package framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.Abstractcomponent.Abstractcomponent;

public class Landingpage extends Abstractcomponent {
	
	WebDriver driver;
	
	public Landingpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement Passwordele;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public Productcatalogue loginApplication(String email,String password) {
		userEmail.sendKeys(email);
		Passwordele.sendKeys(password);
     	submit.click();
     	Productcatalogue productcatalogue=new Productcatalogue(driver);
     	return productcatalogue;
	}
	
	public String getErrorMessage() throws InterruptedException {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
	public void goTo() {
		  driver.get("https://rahulshettyacademy.com/client");
	}
	
	}
	

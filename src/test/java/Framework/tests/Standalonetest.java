package Framework.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import framework.pageobjects.Landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Standalonetest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	  String productname="ADIDAS ORIGINAL";
      WebDriverManager.chromedriver().setup();
      WebDriver driver=new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.manage().window().maximize();
      driver.get("https://rahulshettyacademy.com/client");
      Landingpage landingpage=new Landingpage(driver);
      driver.findElement(By.id("userEmail")).sendKeys("arunkumar1@gmail.com");
      driver.findElement(By.id("userPassword")).sendKeys("Framework$1247");
      driver.findElement(By.id("login")).click();
      WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-lg-4")));
      
      List<WebElement> products=driver.findElements(By.cssSelector(".col-lg-4"));
      WebElement prod= products.stream().filter(product-> 
      product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
      prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
      wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
      driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
      
      List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
      Boolean match=cartProducts.stream().anyMatch(cartProduct->
      cartProduct.getText().equalsIgnoreCase(productname));
      Assert.assertTrue(match);
      driver.findElement(By.cssSelector(".totalRow button")).click();
      
      Actions a =new Actions(driver);
      a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
      
      
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
      driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
      WebElement ele=driver.findElement(By.cssSelector(".btnn"));
      JavascriptExecutor jse = (JavascriptExecutor)driver;
	  jse.executeScript("arguments[0].click()", ele);

      String confirmMessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
      Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
      
	}   
	

}

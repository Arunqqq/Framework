package Framework.tests;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Framework.tests.testcomponent.Basetest;
import framework.pageobjects.CartPage;
import framework.pageobjects.CheckoutPage;
import framework.pageobjects.ConfirmationPage;
import framework.pageobjects.OrderPage;
import framework.pageobjects.Productcatalogue;


public class SubmitOrderTest extends Basetest{
	  
	 String productname="ADIDAS ORIGINAL";
    @Test(dataProvider="getData",groups= {"Purchase"})
	public void submitorder(HashMap<String,String> input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
	
      Productcatalogue productcatalogue=landingpage.loginApplication(input.get("email"),input.get("password"));

		List<WebElement> products = productcatalogue.getProductList();
		productcatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productcatalogue.goToCartPage();

		Boolean match = cartPage.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
    @Test(dependsOnMethods="submitorder")
    public void OrderHistoryTest()
    {
    	  Productcatalogue productcatalogue=landingpage.loginApplication("arunkumar1@gmail.com", "Framework$1247");
    	  OrderPage orderPage=productcatalogue.goToOrderPage();
    	  Assert.assertTrue(orderPage.verifyOrderDisplay(productname));
    	
    }
    
   
@DataProvider
public Object[][] getData()
{
	HashMap<String,String> map = new HashMap<String,String>();
	map.put("email", "arunkumar1@gmail.com");
	map.put("password", "Framework$1247");
	map.put("product", "ADIDAS ORIGINAL");
   return new Object[][]  {{map}};
} 
}

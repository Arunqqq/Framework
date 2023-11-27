package Framework.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



import Framework.tests.testcomponent.Basetest;
import Framework.tests.testcomponent.Retry;
import framework.pageobjects.CartPage;
import framework.pageobjects.CheckoutPage;
import framework.pageobjects.ConfirmationPage;
import framework.pageobjects.Landingpage;
import framework.pageobjects.Productcatalogue;


public class ErrorValidationsTest extends Basetest{
    @Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void loginErrorValidation() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
	  
	  String productname="ADIDAS ORIGINAL";
     
	  Productcatalogue productcatalogue=landingpage.loginApplication("anshika@gmail.com", "Iamki=ng@000");
      Assert.assertEquals("Incorrect email or password.",landingpage.getErrorMessage()); 
      
	}
    
    @Test
    public void productErrorValidation() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
	  
	  String productname="ADIDAS ORIGINAL";
      Productcatalogue productcatalogue=landingpage.loginApplication("arunkumar1@gmail.com", "Framework$1247");

		List<WebElement> products = productcatalogue.getProductList();
		productcatalogue.addProductToCart(productname);
		CartPage cartPage = productcatalogue.goToCartPage();

		Boolean match = cartPage.verifyProductDisplay("ADIDAS ORIGINAL");
		Assert.assertTrue(match);

	}

}

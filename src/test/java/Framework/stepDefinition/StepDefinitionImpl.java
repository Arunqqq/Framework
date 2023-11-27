package Framework.stepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Framework.tests.testcomponent.Basetest;
import framework.pageobjects.CartPage;
import framework.pageobjects.CheckoutPage;
import framework.pageobjects.ConfirmationPage;
import framework.pageobjects.Landingpage;
import framework.pageobjects.Productcatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends Basetest{
	public Landingpage landingpage;
	public Productcatalogue productcatalogue;
	public ConfirmationPage confirmationPage;
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		 landingpage = launchApplication();
	}
	@Given ("^Logged in with username (.+) and password (.+)$")
	public void logged_in_username_password(String username,String password)
	{
	      productcatalogue=landingpage.loginApplication(username,password);
	 }
	@When ("^I add product (.+) to cart$")
	public void I_add_product_to_cart(String produtname) throws InterruptedException
	{
		List<WebElement> products = productcatalogue.getProductList();
		productcatalogue.addProductToCart(produtname);
	}
	@When("^Checkout (.+) and submit the order$")
	public void  Checkout_submit_order(String productname ) throws InterruptedException 
	{
		CartPage cartPage = productcatalogue.goToCartPage();

		Boolean match = cartPage.verifyProductDisplay(productname);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		confirmationPage = checkoutPage.submitOrder();
	}
	
	@Then("{string} message is displayed on ConfirmationPage")
	public void message_displayed_ConfirmationPage(String string)
	{
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
	}
	
	@Then("^\"([^\"]*)\" message is displayed$")
	public void something_message_is_displayed(String strArg) throws Throwable{
		Assert.assertEquals(strArg,landingpage.getErrorMessage());
		

	}
	
}

package stepdefinitions.demosite;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import io.cucumber.java.en.Then;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import pages.demosites.Homepage;
import pages.demosites.Shoppage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WishlistValidationStepDefinitions {

	private static final Logger LOGGER = LoggerFactory.getLogger(CucumberWithSerenity.class);
	@Steps
	Homepage homePage;

	@Steps
	Shoppage shopPage;
	
    @Given("I add four different products to my wish list")
    public void i_add_4_different_products_to_my_wish_list() throws InterruptedException {
    	homePage.openApplication();
    	homePage.add4ProductToWishlist();
    }

    @When("I view my wishlist table")
    public void i_view_my_wishlist_table() {
    	homePage.viewWishlist();
    }


    @Then("I find total (.*) selected items in my Wishlist")
    public void i_find_total_four_selected_items_in_my_Wishlist(String listSize) {
    	assertThat(homePage.getWishlistItem(listSize),equalTo(4));
    }
    
    @When("I search for lowest price product")
    public void i_search_for_lowest_price_product() throws InterruptedException {
    	shopPage.lowestPriceProduct();
    }
    
    @And("I am able to add the lowest price item to my cart")
    public void i_am_able_to_add_the_lowest_price_item_to_my_cart() {
    	shopPage.addLowestPriceProduct();
    }
    
      
    @Then("I am able to verify the item in my cart")
    public void i_am_able_to_verify_the_item_in_my_cart() {
        assertThat(shopPage.getProductName(),equalTo("Bikini"));
    }
}




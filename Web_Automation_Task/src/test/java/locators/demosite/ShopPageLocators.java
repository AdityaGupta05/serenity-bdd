package locators.demosite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.hamcrest.generator.qdox.tools.QDoxTester.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.serenitybdd.screenplay.waits.Wait;
import net.thucydides.core.webdriver.WebDriverFactory;

public class ShopPageLocators extends PageObject {

	private String SHOP_BUTTON = "//a[(@title='Shop')]";
	private String VIEW_CART = "//a[(@title='View cart')]";
	private String CART_BUTTON = "//a[(@title='Cart')]";
	private String CART_PRODUCT_NAME = "//a[contains(text(),'Bikini')]";

	private static final Logger LOGGER = LoggerFactory.getLogger(CucumberWithSerenity.class);



	public void lowestPriceProduct() throws InterruptedException {

		LOGGER.info("Click on Shop button");
		$(SHOP_BUTTON).click();
		Thread.sleep(3000);
		List<WebElement> list_of_products_price = getDriver().findElements(By.xpath("//span[(@class='price')]/ins"));
		String product_price;
		int int_product_price;
		HashMap<Integer, String> map_final_products = new HashMap<Integer, String>();
		for (int i = 0; i < list_of_products_price.size(); i++) {

			try {
				product_price = list_of_products_price.get(i).getText();
				product_price = product_price.replaceAll("[^0-9]", "");
				int_product_price = Integer.parseInt(product_price);				
				map_final_products.put(int_product_price, product_price);
			} catch (NumberFormatException ex) { 
				System.out.println("We can catch the NumberFormatException");
			}
		}
		LOGGER.info("Price fetched from UI and saved in HashMap as:" + map_final_products.toString() + "<br>", true);

		
		Set<Integer> allkeys = map_final_products.keySet();
		ArrayList<Integer> array_list_values_product_prices = new ArrayList<Integer>(allkeys);

		
		Collections.sort(array_list_values_product_prices);
		LOGGER.info("product_price:" + array_list_values_product_prices);

		
		int high_price = array_list_values_product_prices.get(array_list_values_product_prices.size() - 1);

		
		int low_price = array_list_values_product_prices.get(0);

		LOGGER.info("High Product Price is: " + high_price);
		LOGGER.info("Low Product Price is: " + low_price);

		List<WebElement> addCartbtn = getDriver().findElements(By.xpath("//a[contains(@class,'button product_type')]"));
		Thread.sleep(3000);
		for (int i = 0; i < list_of_products_price.size(); i++) {
			try {
				Integer priceInt1 = Integer.valueOf(list_of_products_price.get(i).getText().replaceAll("[^0-9]", ""));
				System.out.println(priceInt1);
				if (priceInt1 == low_price) {
					LOGGER.info("Inside If" + addCartbtn);
					addCartbtn.get(i).click();
					waitFor(getDriver().findElement(By.xpath(VIEW_CART)));
					break;
				}
			} catch (NumberFormatException ex) { 

				System.out.println("We can catch the NumberFormatException");
			}
		}
	}

	public void addLowestPriceProduct() {

		LOGGER.info("Click on cart button");
		$(CART_BUTTON).click();
	}

	public String getProductName() {
		LOGGER.info("Get product name");
		return $(CART_PRODUCT_NAME).getText();
	}
}

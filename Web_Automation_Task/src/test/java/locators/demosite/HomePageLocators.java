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

public class HomePageLocators extends PageObject {

	private String BROWSE_WISHLIST_URL = "//a[contains(text(),'Browse wishlist')]";
	private String ADD_TO_WISHLIST_URL = "//span[contains(text(),'Add to wishlist')]";
	private String FEEDBACK = "(//span[contains(@class,'feedback')])[\"+i+\"]";
	private String WISHLIST_ITEMS = "//tr[contains(@id,'yith-wcwl-row')]";


	private static final Logger LOGGER = LoggerFactory.getLogger(CucumberWithSerenity.class);

	public void add4ProductToWishlist() throws InterruptedException {
		LOGGER.info("Adding 4 different items to wishlist");
		for (int i = 1; i < 5; i++) {
			$(ADD_TO_WISHLIST_URL).click();
			Thread.sleep(5000);
			waitFor(getDriver().findElement(By.xpath(FEEDBACK)));
		}
	}

	public void viewWishlist() {
		$(BROWSE_WISHLIST_URL).click();
	}

	public int getWishlistItem(String listSize) {
		List<WebElement> wishlist_item = getDriver().findElements(By.xpath(WISHLIST_ITEMS));

		LOGGER.info("Number of wishlist item: " + wishlist_item.size());
		
		return wishlist_item.size();

	}

}

package pages.demosites;

import java.util.List;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.Step;
import locators.demosite.ShopPageLocators;

public class Shoppage {

	ShopPageLocators shopPageLocators;

	@Step
	public void lowestPriceProduct() throws InterruptedException {
		shopPageLocators.lowestPriceProduct();

	}

	@Step
	public void addLowestPriceProduct() {
		shopPageLocators.addLowestPriceProduct();

	}

	@Step
	public void openApplication() {
		shopPageLocators.open();

	}

	@Step
	public String getProductName() {
		return shopPageLocators.getProductName();
	}
}
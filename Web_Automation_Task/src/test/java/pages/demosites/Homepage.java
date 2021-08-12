package pages.demosites;

import java.util.List;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.Step;
import locators.demosite.HomePageLocators;

public class Homepage {

	HomePageLocators homePageLocators;

	@Step
	public void add4ProductToWishlist() throws InterruptedException {
		homePageLocators.add4ProductToWishlist();

	}

	@Step
	public void viewWishlist() {
		homePageLocators.viewWishlist();

	}

	@Step
	public void openApplication() {
		homePageLocators.open();

	}

	@Step
	public int getWishlistItem(String listSize) {
		return homePageLocators.getWishlistItem(listSize);
	}

}
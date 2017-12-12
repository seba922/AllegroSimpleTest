package pages.executors;

import org.openqa.selenium.support.PageFactory;
import pages.locators.ItemPageLocators;
import util.SeleniumExecutor;

public class ItemPage {
    private ItemPageLocators locators;

    public ItemPage() {
        locators = new ItemPageLocators();
        PageFactory.initElements(SeleniumExecutor.getDriver(), locators);
    }

    public void addItemToTheBasket() throws InterruptedException {
        locators.addToTheBasketButton.click();
    }

    public double getPrice() {
        String price = locators.priceLabel.getText().substring(0, locators.priceLabel.getText().length() - 3).replace(',', '.');
        return Double.parseDouble(price.replaceAll("\\s", ""));
    }

    public void clickGoToBasketButton() {
        SeleniumExecutor.waitForElementToBeVisible(locators.goToBasketButton);
        locators.goToBasketButton.click();
    }

    public void switchToModalWindow() {
        SeleniumExecutor.waitForElementToBeVisible(locators.modalWindowElement);
        SeleniumExecutor.getDriver().switchTo().activeElement();
    }
}

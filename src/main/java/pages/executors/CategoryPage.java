package pages.executors;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.locators.CategoryPageLocators;
import util.SeleniumExecutor;

public class CategoryPage {
    private CategoryPageLocators locators;
    private String numberOfItems;

    public CategoryPage() {
        locators = new CategoryPageLocators();
        PageFactory.initElements(SeleniumExecutor.getDriver(), locators);
    }

    public void setMaxPrice(int price) {
        numberOfItems = locators.numberOfItems.getText();
        locators.priceTo.sendKeys(String.valueOf(price));
    }

    public void openItem(int index) {
        locators.listOfItems.get(index).click();
    }

    public void waitForChangeNumberOfItems() {
        WebDriverWait wait = new WebDriverWait(SeleniumExecutor.getDriver(), 30);
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(locators.numberOfItems, numberOfItems)));
    }
}

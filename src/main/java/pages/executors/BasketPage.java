package pages.executors;

import org.openqa.selenium.support.PageFactory;
import pages.locators.BasketPageLocators;
import util.SeleniumExecutor;

public class BasketPage {
    private BasketPageLocators locators;

    public BasketPage() {
        locators = new BasketPageLocators();
        PageFactory.initElements(SeleniumExecutor.getDriver(), locators);
    }

    public double getSummaryPrice() {
        String summaryPrice = locators.summaryPrice.getText().substring(0, locators.summaryPrice.getText().length() - 3).replace(',', '.');
        return Double.parseDouble(summaryPrice.replaceAll("\\s", ""));
    }

    public String getPageHeader(){
        return locators.pageHeader.getText();
    }
}

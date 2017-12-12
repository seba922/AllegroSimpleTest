package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BasketPageLocators {
    @FindBy(how = How.XPATH, using = ".//*[@id='summary']//span[@class='total']/strong[@class='ng-binding']")
    public WebElement summaryPrice;

    @FindBy(how = How.XPATH, using = ".//h1")
    public WebElement pageHeader;
}

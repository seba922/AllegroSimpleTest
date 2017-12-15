package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ItemPageLocators {
    @FindBy(how = How.ID, using = "add-to-cart")
    public WebElement addToTheBasketButton;

    @FindBy(how = How.XPATH, using = ".//div[@class='inline']/div[@class='price'] | .//*[@class='m-price m-price--primary']")
    public WebElement priceLabel;

    @FindBy(how = How.ID, using = "add-to-cart-si-precart")
    public WebElement goToBasketButton;

    @FindBy(how = How.XPATH, using = ".//*[@class='modal info-modal modal-precart show']/div[@class='modal-dialog']")
    public WebElement modalWindowElement;
}


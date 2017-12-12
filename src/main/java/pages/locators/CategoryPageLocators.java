package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class CategoryPageLocators {
    @FindBy(how = How.ID, using = "do")
    public WebElement priceTo;

    @FindBy(how = How.XPATH, using = "(.//article)")
    public List<WebElement> listOfItems;

    @FindBy(how = How.XPATH, using = ".//*[@class='listing-title__counter-value']")
    public WebElement numberOfItems;
}

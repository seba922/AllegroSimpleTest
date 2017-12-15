package pages.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import util.SeleniumExecutor;

import java.util.List;

public class MainPageLocators {
    @FindBy(how = How.CSS, using = "[class='offer-tile__photo']")
    public List<WebElement> promotedItemsList;

    @FindBy(how = How.XPATH, using = ".//*[@data-dropdown-id='categories_dropdown']")
    public WebElement categoryDropdownButton;

    public WebElement getSubcategory(String subcategory) {
        return SeleniumExecutor.getDriver().findElement(By.xpath(".//*[@title='" + subcategory + "']"));
    }
}

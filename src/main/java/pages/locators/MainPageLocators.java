package pages.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import util.SeleniumExecutor;

import java.util.List;

public class MainPageLocators {
    @FindBy(how = How.XPATH, using = ".//*[@id='carousel--carousel1']//div[@class='offer-grid__col offer-grid__col--12 offer-grid__col--6@sm offer-grid__col--4@md offer-grid__col--3@lg']")
    public List<WebElement> promotedItemsList;

    @FindBy(how = How.XPATH, using = ".//*[@data-dropdown-id='categories_dropdown']")
    public WebElement categoryDropdownButton;

    public WebElement getSubcategory(String subcategory) {
        return SeleniumExecutor.getDriver().findElement(By.xpath(".//*[@title='" + subcategory + "']"));
    }
}

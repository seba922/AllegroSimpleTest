package pages.executors;

import org.openqa.selenium.support.PageFactory;
import pages.locators.MainPageLocators;
import util.SeleniumExecutor;

public class MainPage {
    private MainPageLocators locators;

    public MainPage(){
        locators = new MainPageLocators();
        PageFactory.initElements(SeleniumExecutor.getDriver(), locators);
    }

    public void openPromotedItem(int index){
        locators.promotedItemsList.get(index).click();
    }

    public void clickOnCategoryDropdownButton(){
        locators.categoryDropdownButton.click();
    }

    public void clickOnSubcategory(String SubcategoryName){
        locators.getSubcategory(SubcategoryName).click();
    }
}

package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.executors.BasketPage;
import pages.executors.CategoryPage;
import pages.executors.ItemPage;
import pages.executors.MainPage;
import util.AbstractPage;
import util.SeleniumExecutor;

public class ShopBasketSteps extends AbstractPage {
    private MainPage mainPage;
    private ItemPage itemPage;
    private CategoryPage categoryPage;
    private BasketPage basketPage;
    private double summaryPrice = 0;

    public ShopBasketSteps() {
        this.mainPage = new MainPage();
        this.itemPage = new ItemPage();
        this.categoryPage = new CategoryPage();
        this.basketPage = new BasketPage();
    }

    @When("^Wejść na stronę allegro\\.pl$")
    public void wejść_na_stronę_allegro_pl() throws Throwable {
        openPage();
    }

    @When("^Dodać do koszyka dwie sztuki dowolnego produktu polecanego na stronie głównej$")
    public void dodać_do_koszyka_dwie_sztuki_dowolnego_produktu_polecanego_na_stronie_głównej() throws Throwable {
        for (int i = 0; i < 2; i++) {
            mainPage.openPromotedItem(i);

            if (SeleniumExecutor.getPageUrl().contains("uzytkownik")) {
                categoryPage.openItem(i);
                summaryPrice = summaryPrice + itemPage.getPrice();
                itemPage.addItemToTheBasket();
                SeleniumExecutor.getDriver().navigate().back();
            } else {
                summaryPrice = summaryPrice + itemPage.getPrice();
                itemPage.addItemToTheBasket();
            }

            SeleniumExecutor.getDriver().navigate().back();
        }
    }

    @And("^Wejść w kategorię Elektronika / \"([^\"]*)\"$")
    public void wejśćWKategorięElektronika(String subcategoryName) throws Throwable {
        mainPage.clickOnCategoryDropdownButton();
        mainPage.clickOnSubcategory(subcategoryName);
    }

    @When("^Wybrać w filtrach cenę do (\\d+) zł i dodać do koszyka drugi laptop w wynikowej listy$")
    public void wybrać_w_filtrach_cenę_do_zł_i_dodać_do_koszyka_drugi_laptop_w_wynikowej_listy(int price) throws Throwable {
        categoryPage.setMaxPrice(price);
        categoryPage.waitForChangeNumberOfItems();
        categoryPage.openItem(1);
        summaryPrice = summaryPrice + itemPage.getPrice();
        itemPage.addItemToTheBasket();
        itemPage.switchToModalWindow();
        itemPage.clickGoToBasketButton();
    }

    @Then("^Sprawdzić czy użytkownik został przeniesiony na widok koszyka$")
    public void sprawdzić_czy_użytkownik_został_przeniesiony_na_widok_koszyka() throws Throwable {
        Assert.assertTrue(SeleniumExecutor.getPageUrl().endsWith("/cart"));
        Assert.assertEquals(basketPage.getPageHeader(), "Twój koszyk");
    }

    @Then("^Sprawdzić czy ceny, ilości dodanych produktów oraz sumaryczna wartość koszyka są poprawne$")
    public void sprawdzić_czy_ceny_ilości_dodanych_produktów_oraz_sumaryczna_wartość_koszyka_są_poprawne() throws Throwable {
        Assert.assertEquals(basketPage.getSummaryPrice(), summaryPrice, 0);
    }
}

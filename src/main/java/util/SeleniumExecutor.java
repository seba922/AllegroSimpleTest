package util;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SeleniumExecutor {
    private final static int TIMEOUT = 10;
    public static String pageDefaultUrl;
    private static SeleniumExecutor executor;
    private static WebDriver driver;

    public SeleniumExecutor() {

        this.driver = createDriver();

        this.pageDefaultUrl = "https://allegro.pl/";
    }

    public static String getPageUrl() {
        return driver.getCurrentUrl();
    }

    @After
    public static void teardown() {
        driver.close();
        driver.quit();
        executor = null;
    }

    private static void start() {
        if (executor == null)
            executor = new SeleniumExecutor();
    }

    public static SeleniumExecutor getExecutor() {
        start();
        return executor;
    }

    private static WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", "chrome/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);

        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public void openPage(String url) {
        driver.navigate().to(url);
    }

    public static void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}



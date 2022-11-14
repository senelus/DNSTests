package test.dns.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

abstract public class BaseTest {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static final String BASE_URL = "https://www.dns-shop.ru/";
    public static final String SEARCH_XPATH = "(//input[@name='q'])[2]";
    public static final String SEARCH_BUTTON_XPATH = "//div[2]/span[2]";
    public static final String FIRST_ARTICLE_CSS = ".catalog-products:nth-child(2) > .catalog-product:nth-child(1) > .catalog-product__name > span";
    public static final String BUY_BUTTON_CSS = ".buy-btn:nth-child(3)";
    public static final String GOODS_COUNT_CSS = ".cart-link__badge";
    public static final String BASKET_BUTTON_XPATH = "//button[2]/span";
    public static final String REMOVE_GOODS_BUTTON_CSS = ".remove-button__title";



    public void addGoods(String keys) {
        //поиск товара по вводимой категории
        driver.findElement(By.xpath(SEARCH_XPATH)).sendKeys(keys);
        driver.findElement(By.xpath(SEARCH_BUTTON_XPATH)).click();

        //выбор первого в списке товара
        driver.findElement(By.cssSelector(FIRST_ARTICLE_CSS)).click();

        //ожидание кликабельности кнопки "Купить"
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(BUY_BUTTON_CSS)));

        //добавление товара в корзину
        driver.findElement(By.cssSelector(BUY_BUTTON_CSS)).click();
    }

    @Before
    public void init(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.get(BASE_URL);
        wait = new WebDriverWait(driver, '5');
    }

    @After
    public void close() {
        driver.quit();
    }
}

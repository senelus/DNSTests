package test.dns.selenide;

import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;

abstract public class BaseTest {

    public static final String BASE_URL = "https://www.dns-shop.ru/";
    public static final String SEARCH_KEYS = "клавиатура";

    @Before
    public void init(){
        WebDriverManager.chromedriver().setup();
    }

    @After
    public void close(){
        Selenide.closeWebDriver();
    }
}

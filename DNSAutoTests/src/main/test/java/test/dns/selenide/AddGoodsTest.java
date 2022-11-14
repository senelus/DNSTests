package test.dns.selenide;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$x;

public class AddGoodsTest extends BaseTest {

    @Test
    public void addGoods(){
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.sendKeys(SEARCH_KEYS);
        ElementPage elementPage = mainPage.search().openFirstElement();
        elementPage.buy();
        BasketPage basketPage = elementPage.openBasket();
        String goodsCount = basketPage.getGoodsCount();
        var errorMessage = String.format("Полученное количество товаров: %s, Ожидалось: %s", goodsCount, "1 товар");
        Assert.assertTrue(errorMessage, goodsCount.equals("1 товар"));
    }
}

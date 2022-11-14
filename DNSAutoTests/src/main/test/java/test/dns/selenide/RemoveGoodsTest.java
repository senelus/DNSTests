package test.dns.selenide;

import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$x;

public class RemoveGoodsTest extends BaseTest{

    @Test
    public void removeGoods(){
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.sendKeys(SEARCH_KEYS);
        ElementPage elementPage = mainPage.search().openFirstElement();
        elementPage.buy();
        BasketPage basketPage = elementPage.openBasket();
        basketPage.removeElement();
        String basketCondition = basketPage.getBasketCondition();
        String errorMessage = String.format("Полученно: %s, Ожидалось: %s", basketCondition, "Корзина пуста");
        Assert.assertTrue(errorMessage, basketCondition.equals("Корзина пуста"));
    }
}

package test.dns.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddGoodsTest extends BaseTest {
    private static final String SEARCH_KEYS = "клавиатура";
    private static final String TOTAL_GOODS_CSS = ".summary-header__total-items";

    @Test
    public void addGoods() {
        //добавление товара в корзину
        addGoods(SEARCH_KEYS);

        //ожидание отображения добавления товара в корзине
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(GOODS_COUNT_CSS)));

        //переход в корзину
        driver.findElement(By.xpath(BASKET_BUTTON_XPATH)).click();

        //проверка добавления товара в корзину
        var goodsCount = driver.findElement(By.cssSelector(TOTAL_GOODS_CSS)).getText();
        var errorMessage = String.format("Полученное количество товаров: %s, Ожидалось: %s", goodsCount, "1 товар");
        Assert.assertTrue(errorMessage, goodsCount.equals("1 товар"));

        //удаление товара из корзины
        driver.findElement(By.cssSelector(REMOVE_GOODS_BUTTON_CSS)).click();

    }
}

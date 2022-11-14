package test.dns.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RemoveGoodsTest extends BaseTest {
    private static final String SEARCH_KEYS = "наушники";
    private static final String EMPTY_BASKET_MESSAGE_CSS = ".empty-message__title-empty-cart";
    private static final String RESTORE_DELETED_GOODS_CSS = ".empty-message-restore-btn";

    @Test
    public void removeGoods() {
        //добавление товара в корзину
        addGoods(SEARCH_KEYS);

        //ожидание отображения добавления товара в корзине
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(GOODS_COUNT_CSS)));

        //переход в корзину
        driver.findElement(By.xpath(BASKET_BUTTON_XPATH)).click();

        //удаление товара из корзины
        driver.findElement(By.cssSelector(REMOVE_GOODS_BUTTON_CSS)).click();

        //ожидание удаления товара из корзины
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(RESTORE_DELETED_GOODS_CSS)));

        //проверка удаления товара из корзины
        var basketCondition = driver.findElement(By.cssSelector(EMPTY_BASKET_MESSAGE_CSS)).getText();
        var errorMessage = String.format("Полученно: %s, Ожидалось: %s", basketCondition, "Корзина пуста");
        Assert.assertTrue(errorMessage, basketCondition.equals("Корзина пуста"));
    }
}

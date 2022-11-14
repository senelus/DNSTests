package test.dns.selenide;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class BasketPage {

    private static final SelenideElement removeButton = $(".remove-button__title");
    private static final SelenideElement basketCondition = $x("//div[2]/div[2]/div[2]/div[1]");
    private static final SelenideElement goodsCount = $(".cart-products-count");

    public void removeElement() {
        removeButton.click();
    }

    public String getBasketCondition(){
        return basketCondition.getText();
    }

    public String getGoodsCount(){
        return goodsCount.getText();
    }
}

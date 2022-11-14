package test.dns.selenide;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ElementPage {

    private static final SelenideElement buyButton = $(".buy-btn:nth-child(3)");
    private static final SelenideElement basketButton = $x("//div[2]/button[2]");
    public void buy(){
        buyButton.click();
    }

    public BasketPage openBasket() {
        basketButton.click();
        return new BasketPage();
    }
}

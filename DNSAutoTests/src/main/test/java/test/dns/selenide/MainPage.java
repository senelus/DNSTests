package test.dns.selenide;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private static final SelenideElement searchInput = $x("(//input[@name='q'])[2]");
    private static final SelenideElement searchButton = $x("//div[2]/span[2]");

    public MainPage(String url) {
        Selenide.open(url);
    }

    public void sendKeys(String keys) {
        searchInput.sendKeys(keys);
    }

    public FoundedPage search() {
        searchButton.click();
        return new FoundedPage();
    }

}

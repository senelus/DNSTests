package test.dns.selenide;

import com.codeborne.selenide.ElementsCollection;


import static com.codeborne.selenide.Selenide.$$x;

public class FoundedPage {
    private final ElementsCollection elements = $$x("//div[@id='search-results']/div[2]/div/div/div/a");

    public ElementPage openFirstElement(){
        elements.first().click();
        return new ElementPage();
    }


}

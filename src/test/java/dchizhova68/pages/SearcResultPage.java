package dchizhova68.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearcResultPage {
    private SelenideElement
            searchTitleWrapper = $(byAttribute("data-testid", "search-title__wrapper"));


    private ElementsCollection
            bookTitleTag = $$(byAttribute("data-testid", "art__title"));

    @Step("Проверяем, что в результатах поиска есть книга {bookTitle}")
    public SearcResultPage checkSearchResultHavePopularBookByAuthor(String bookTitle) {
        bookTitleTag.shouldHave(itemWithText(bookTitle));
        return this;
    }


    @Step("Проверяем, что в результате поимка ничего не найдено")
    public SearcResultPage checkResultsIsEmpty() {
        searchTitleWrapper.shouldHave(text("ничего не найдено"));
        return this;
    }
}

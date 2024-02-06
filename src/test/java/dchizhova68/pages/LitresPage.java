package dchizhova68.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class LitresPage {
    private SelenideElement
            searchInput = $(byAttribute("data-testid", "header__search-input--desktop")),
            linkDetailFormBook = $(byAttribute("data-testid", "art__cover--desktop")).$("a"),
            addToCartButton = $(byAttribute("data-testid", "book__addToCartButton--desktop")),
            closeModalButton = $(byAttribute("data-testid", "modal-book-label__wrapper")).$("use"),
            tabBasket = $(byAttribute("data-testid", "tab-basket")).$("a"),
            breadcrumbsSelector = $("#breadcrumbs li:last-child"),
            searchTitleWrapper = $(byAttribute("data-testid", "search-title__wrapper")),
            promoBanner = $(byAttribute("data-testid", "mainPromoBanner--desktop")).parent();

    private ElementsCollection
            bookTitleTag = $$(byAttribute("data-testid", "art__title--desktop")),
            bookCardTitle = $$(byAttribute("data-testid", "cart__bookCardTitle--wrapper"));


    @Step("Открываем главную страницу")
    public LitresPage openPage() {
        open("/");
        return this;
    }

    @Step("Вводим в поисковую строку {author}")
    public LitresPage setSearchValue(String author) {
        searchInput.setValue(author).pressEnter();
        return this;
    }

    @Step("Проверяем, что в результатах поиска есть книга {bookTitle}")
    public LitresPage checkSearchResultHavePopularBookByAuthor(String bookTitle) {
        bookTitleTag.shouldHave(itemWithText(bookTitle));
        return this;
    }

    @Step("Переходим в детальную форм просмотра первой книги из списка")
    public LitresPage openDetailFormBook() {
        linkDetailFormBook.click();
        return this;
    }

    @Step("Закрываем модальное окно")
    public LitresPage closeModalWindow() {
        closeModalButton.click();
        return this;
    }

    @Step("Добавляем книгу в корзину")
    public LitresPage addToBasket() {
        addToCartButton.click();
        return this;
    }

    @Step("Переходим в корзину")
    public LitresPage openBasket() {
        tabBasket.click();
        return this;
    }

    @Step("Проверяем, что в корзине есть книга{bookTitle}")
    public LitresPage checkBasketContainsAddedBook(String bookTitle) {
        bookCardTitle.shouldHave(itemWithText(bookTitle));
        return this;
    }

    @Step("Открываем раздел {pageName}")
    public LitresPage openPageByName(String pageName) {
        $(byTagAndText("a", pageName)).click();
        return this;
    }

    @Step("Проверяем навигационную цепочку")
    public LitresPage checkBreadCrumbs(String navLastChildName) {
        breadcrumbsSelector.shouldHave(text(navLastChildName));
        return this;
    }

    @Step("Проверяем, что в результате поимка ничего не найдено")
    public LitresPage checkResultsIsEmpty() {
        searchTitleWrapper.shouldHave(text("ничего не найдено"));
        return this;
    }

    @Step("Проверяем видимость рекламного баннера")
    public LitresPage checkPromoBanner() {
        promoBanner.shouldBe(visible);
        return this;
    }
}

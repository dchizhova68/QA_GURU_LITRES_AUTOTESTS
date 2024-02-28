package dchizhova68.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class PageObject {
    private SelenideElement
            searchInput = $(byAttribute("data-testid", "header__search-input--desktop")),
            linkDetailFormBook = $(byAttribute("data-testid", "art__cover")),
            addToCartButton = $(byAttribute("data-testid", "book__addToCartButton--desktop")),
            closeModalButton = $(byAttribute("data-testid", "modal-book-label__wrapper")).$("use"),
            tabBasket = $(byAttribute("data-testid", "tab-basket")).$("a"),
            breadcrumbsSelector = $("#breadcrumbs li:last-child"),
            searchTitleWrapper = $(byAttribute("data-testid", "search-title__wrapper")),
            promoBanner = $(byAttribute("data-testid", "mainPromoBanner--desktop")).parent(),
            searchResultList = $(byAttribute("data-testid", "popover__content")),
            catalogButton = $(byTagAndText("button", "Каталог")),
            genresPopup = $(byAttribute("data-testid", "genres_popup")),
            deleteButton = $(byAttribute("data-testid", "cart__listDeleteButton--desktop")),
            deleteModalButton = $(byAttribute("data-testid", "modal-book-label__wrapper")).$(byTagAndText("div", "Удалить")),
            cartEmptyState = $(byAttribute("data-testid", "cart__emptyState--wrapper")),
            menuMoreButton = $(byAttribute("data-testid", "lowerMenu_moreButtonWrap")),
            menuMoreItems = $(byAttribute("data-testid", "lowerMenu_moreItems"));


    private ElementsCollection
            bookTitleTag = $$(byAttribute("data-testid", "art__title")),
            bookCardTitle = $$(byAttribute("data-testid", "cart__bookCardTitle--wrapper"));


    @Step("Открываем главную страницу")
    public PageObject openPage() {
        open("/");
        return this;
    }

    @Step("Вводим в поисковую строку {author}")
    public PageObject setSearchValue(String author) {
        searchInput.setValue(author).pressEnter();
        return this;
    }

    @Step("Проверяем, что в результатах поиска есть книга {bookTitle}")
    public PageObject checkSearchResultHavePopularBookByAuthor(String bookTitle) {
        bookTitleTag.shouldHave(itemWithText(bookTitle));
        return this;
    }

    @Step("Переходим в детальную форм просмотра первой книги из списка")
    public PageObject openDetailFormBook() {
        linkDetailFormBook.click();
        return this;
    }

    @Step("Закрываем модальное окно")
    public PageObject closeModalWindow() {
        closeModalButton.click();
        return this;
    }

    @Step("Добавляем книгу в корзину")
    public PageObject addBookToBasket() {
        addToCartButton.click();
        return this;
    }

    @Step("Переходим в корзину")
    public PageObject openBasket() {
        tabBasket.click();
        return this;
    }

    @Step("Удаляем книгу из корзины")
    public PageObject deleteBook() {
        deleteButton.click();
        deleteModalButton.click();
        return this;
    }

    @Step("Проверяем, что карзина пустая")
    public PageObject checkCartEmptyState() {
        cartEmptyState.shouldBe(visible);
        return this;
    }


    @Step("Проверяем, что в корзине есть книга{bookTitle}")
    public PageObject checkBasketContainsAddedBook(String bookTitle) {
        bookCardTitle.shouldHave(itemWithText(bookTitle));
        return this;
    }

    @Step("Открываем раздел {pageName}")
    public PageObject openPageByName(String pageName) {
        $(byTagAndText("a", pageName)).click();
        return this;
    }

    @Step("Проверяем навигационную цепочку")
    public PageObject checkBreadCrumbs(String navLastChildName) {
        breadcrumbsSelector.shouldHave(text(navLastChildName));
        return this;
    }

    @Step("Проверяем, что в результате поимка ничего не найдено")
    public PageObject checkResultsIsEmpty() {
        searchTitleWrapper.shouldHave(text("ничего не найдено"));
        return this;
    }

    @Step("Проверяем видимость рекламного баннера")
    public PageObject checkPromoBanner() {
        promoBanner.shouldBe(visible);
        return this;
    }

    @Step("Нажмаем на кнопку Каталог")
    public PageObject openCatalog() {
        catalogButton.click();
        return this;
    }

    @Step("Проверяем видимость всплывающего окна с каталогом книг")
    public PageObject checkGenresPopupVisible() {
        genresPopup.shouldBe(visible);
        return this;
    }

    @Step("Раскрываем дополнительные пункты меню")
    public PageObject openMoreItemsMenu() {
        menuMoreButton.click();
        return this;
    }

    @Step("Проверяем видимость дополнительных пунктов меню")
    public PageObject checkMoreItemsMenuVisible() {
        menuMoreItems.shouldBe(visible);
        return this;
    }
}

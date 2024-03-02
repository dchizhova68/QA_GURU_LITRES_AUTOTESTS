package dchizhova68.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BasketPage {
    private SelenideElement
            deleteButton = $(byAttribute("data-testid", "cart__listDeleteButton--desktop")),
            deleteModalButton = $(byAttribute("data-testid", "modal-book-label__wrapper")).$(byTagAndText("div", "Удалить")),
            cartEmptyState = $(byAttribute("data-testid", "cart__emptyState--wrapper"));


    private ElementsCollection
            bookCardTitle = $$(byAttribute("data-testid", "cart__bookCardTitle--wrapper"));

    @Step("Удалить книгу из корзины")
    public BasketPage deleteBook() {
        deleteButton.click();
        deleteModalButton.click();
        return this;
    }

    @Step("Проверить, что в корзине нет книг")
    public BasketPage checkCartEmptyState() {
        cartEmptyState.shouldBe(visible);
        return this;
    }


    @Step("Проверить, что в корзине есть книга {bookTitle}")
    public BasketPage checkBasketContainsAddedBook(String bookTitle) {
        bookCardTitle.shouldHave(itemWithText(bookTitle));
        return this;
    }
}

package dchizhova68.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class BookPage {
    private SelenideElement
            addToCartButton = $(byAttribute("data-testid", "book__addToCartButton--desktop")),
            closeModalButton = $(byAttribute("data-testid", "modal-book-label__wrapper")).$("use"),
            tabBasket = $(byAttribute("data-testid", "tab-basket")).$("a");


    @Step("Закрыть модальное окно")
    public BookPage closeModalWindow() {
        closeModalButton.click();
        return this;
    }

    @Step("Добавить книгу в корзину")
    public BookPage addBookToBasket() {
        addToCartButton.click();
        return this;
    }

    @Step("Открыть корзину")
    public BookPage openBasket() {
        tabBasket.click();
        return this;
    }


}

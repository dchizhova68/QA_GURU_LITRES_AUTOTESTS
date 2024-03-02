package dchizhova68.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private SelenideElement
            searchInput = $(byAttribute("data-testid", "header__search-input--desktop")),
            linkDetailFormBook = $(byAttribute("data-testid", "art__cover")),
            promoBanner = $(byAttribute("data-testid", "mainPromoBanner--desktop")).parent(),
            catalogButton = $(byTagAndText("button", "Каталог")),
            genresPopup = $(byAttribute("data-testid", "genres_popup")),
            menuMoreButton = $(byAttribute("data-testid", "lowerMenu_moreButtonWrap")),
            menuMoreItems = $(byAttribute("data-testid", "lowerMenu_moreItems"));

    @Step("Открыть главную страницу")
    public MainPage openPage() {
        open("/");
        return this;
    }

    @Step("Ввести в поисковую строку {author} и нажать Enter")
    public MainPage setSearchValue(String author) {
        searchInput.setValue(author).pressEnter();
        return this;
    }

    @Step("Открыть детальную форму просмотра первой книги из списка")
    public MainPage openDetailFormBook() {
        linkDetailFormBook.click();
        return this;
    }


    @Step("Проверить видимость рекламного баннера")
    public MainPage checkPromoBanner() {
        promoBanner.shouldBe(visible);
        return this;
    }

    @Step("Нажать на кнопку Каталог")
    public MainPage openCatalog() {
        catalogButton.click();
        return this;
    }

    @Step("Проверить видимость всплывающего окна с каталогом книг")
    public MainPage checkGenresPopupVisible() {
        genresPopup.shouldBe(visible);
        return this;
    }

    @Step("Нажать на кнопку 'Еще' в меню")
    public MainPage openMoreItemsMenu() {
        menuMoreButton.click();
        return this;
    }

    @Step("Проверить видимость дополнительных пунктов меню")
    public MainPage checkMoreItemsMenuVisible() {
        menuMoreItems.shouldBe(visible);
        return this;
    }

}

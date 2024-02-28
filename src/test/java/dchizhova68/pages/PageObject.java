package dchizhova68.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

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


}

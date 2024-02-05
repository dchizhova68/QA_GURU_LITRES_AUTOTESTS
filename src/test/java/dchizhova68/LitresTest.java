package dchizhova68;

import dchizhova68.TestBase;
import dchizhova68.pages.LitresPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


public class LitresTest extends TestBase {
    LitresPage litres = new LitresPage();

    @CsvFileSource(resources = "/test_data/findBookByAuthorTest.csv")
    @ParameterizedTest(name = "В результатах поиска по автору {0} должна быть книга {1}")
    @Tag("BLOKER")
    void findBookByAuthorTest(String author, String bookName) {
        litres.openPage()
                .setSearchValue(author)
                .checkSearchResultHavePopularBookByAuthor(bookName);
    }

    @CsvSource(value = {
            "Гранатовый браслет",
            "Отцы и дети"
    })
    @DisplayName("Проверка добавления книги в корзину")
    @Tag("BLOKER")
    @ParameterizedTest
    void addBookToBasketTest(String bookTitle) {
        litres.openPage()
                .setSearchValue(bookTitle)
                .openDetailFormBook()
                .addToBasket()
                .closeModalWindow()
                .openBasket()
                .checkBasketContainsAddedBook(bookTitle);
    }

    @ValueSource(strings = {
            "Новинки",
            "Подборки"
    })
    @Tag("MINOR")
    @ParameterizedTest
    @DisplayName("Навигационная цепочка в разделе должна содержать название раздела")
    void checkBreadcrumbsTest(String pageName) {
        litres.openPage()
                .openPageByName(pageName)
                .checkBreadCrumbs(pageName);

    }

    @DisplayName("Проверка поиска несуществующей книги")
    @Tag("MINOR")
    @Test
    void CheckEmptySearchTest() {
        litres.openPage()
                .setSearchValue("sjekja;s,dxbek")
                .checkResultsIsEmpty();
    }

    @DisplayName("Проверка видимости рекламного баннера")
    @Tag("MINOR")
    @Test
    void promoBannerVisibleTest() {
        litres.openPage()
                .checkPromoBanner();
    }

}

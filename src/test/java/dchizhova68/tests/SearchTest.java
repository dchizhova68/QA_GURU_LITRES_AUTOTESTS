package dchizhova68.tests;

import dchizhova68.pages.PageObject;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.CsvFileSource;

@Tag("SEARCH_TEST")
@DisplayName("Тесты на поиск")
public class SearchTest extends TestBase {
    PageObject litres = new PageObject();

    @ParameterizedTest(name = "В результатах поиска по автору {0} должна быть книга {1}")
    @Owner("Darya Chizhova")
    @CsvFileSource(resources = "/test_data/findBookByAuthorTest.csv")
    void successfulSearchTest(String author, String bookName) {
        litres.openPage()
                .setSearchValue(author)
                .checkSearchResultHavePopularBookByAuthor(bookName);
    }

    @Test
    @DisplayName("Проверка поиска несуществующей книги")
    @Owner("Darya Chizhova")
    void unsuccessfulSearchTest() {
        litres.openPage()
                .setSearchValue("sjekja;s,dxbek")
                .checkResultsIsEmpty();
    }

}

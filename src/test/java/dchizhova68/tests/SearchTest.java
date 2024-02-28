package dchizhova68.tests;

import dchizhova68.pages.MainPage;
import dchizhova68.pages.SearcResultPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@Tag("SEARCH_TEST")
@Feature("Тестирования поиска")
@DisplayName("Тесты на поиск")
public class SearchTest extends TestBase {
    MainPage mainPage = new MainPage();
    SearcResultPage searcResultPage = new SearcResultPage();

    @ParameterizedTest(name = "В результатах поиска по автору {0} должна быть книга {1}")
    @Owner("Darya Chizhova")
    @Severity(SeverityLevel.BLOCKER)
    @CsvFileSource(resources = "/test_data/findBookByAuthorTest.csv")
    void successfulSearchTest(String author, String bookName) {
        mainPage.openPage()
                .setSearchValue(author);
        searcResultPage.checkSearchResultHavePopularBookByAuthor(bookName);
    }

    @Test
    @DisplayName("Проверка поиска несуществующей книги")
    @Owner("Darya Chizhova")
    @Severity(SeverityLevel.NORMAL)
    void unsuccessfulSearchTest() {
        mainPage.openPage()
                .setSearchValue("sjekja;s,dxbek");
        searcResultPage.checkResultsIsEmpty();
    }

}

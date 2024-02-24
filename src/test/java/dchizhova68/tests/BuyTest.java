package dchizhova68.tests;

import dchizhova68.pages.PageObject;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Tag("BUY_TEST")
@Feature("Тестирования покупки")
@DisplayName("Тесты на добавление в корзину и покупку")
public class BuyTest extends TestBase {
    PageObject litres = new PageObject();

    @ParameterizedTest(name = "Проверка добавления книги в корзину")
    @Owner("Darya Chizhova")
    @Severity(SeverityLevel.BLOCKER)
    @CsvSource(value = {
            "Гранатовый браслет",
            "Отцы и дети"
    })
    void addBookToBasketTest(String bookTitle) {
        litres.openPage()
                .setSearchValue(bookTitle)
                .openDetailFormBook()
                .addBookToBasket()
                .closeModalWindow()
                .openBasket()
                .checkBasketContainsAddedBook(bookTitle);
    }

    @ParameterizedTest(name = "Проверка удаления книги из корзины")
    @Owner("Darya Chizhova")
    @ValueSource(strings = {
            "Гранатовый браслет"
    })
    @Severity(SeverityLevel.NORMAL)
    void deleteBookFromBasketTest(String bookTitle) {
        litres.openPage()
                .setSearchValue(bookTitle)
                .openDetailFormBook()
                .addBookToBasket()
                .closeModalWindow()
                .openBasket()
                .checkBasketContainsAddedBook(bookTitle)
                .deleteBook()
                .checkCartEmptyState();
    }
}
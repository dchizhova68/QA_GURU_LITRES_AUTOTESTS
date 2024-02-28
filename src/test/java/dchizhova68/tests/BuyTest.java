package dchizhova68.tests;

import dchizhova68.pages.BasketPage;
import dchizhova68.pages.BookPage;
import dchizhova68.pages.MainPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@Tag("BUY_TEST")
@Feature("Тестирования покупки")
@DisplayName("Тесты на добавление в корзину и покупку")
public class BuyTest extends TestBase {
    MainPage mainPage = new MainPage();
    BasketPage basketPage = new BasketPage();
    BookPage bookPage = new BookPage();

    @ParameterizedTest(name = "Проверка добавления книги в корзину")
    @Owner("Darya Chizhova")
    @Severity(SeverityLevel.BLOCKER)
    @CsvSource(value = {
            "Гранатовый браслет",
            "Отцы и дети"
    })
    void addBookToBasketTest(String bookTitle) {
        mainPage.openPage()
                .setSearchValue(bookTitle)
                .openDetailFormBook();
        bookPage.addBookToBasket()
                .closeModalWindow()
                .openBasket();
        basketPage.checkBasketContainsAddedBook(bookTitle);
    }

    @ParameterizedTest(name = "Проверка удаления книги из корзины")
    @Owner("Darya Chizhova")
    @ValueSource(strings = {
            "Гранатовый браслет"
    })
    @Severity(SeverityLevel.NORMAL)
    void deleteBookFromBasketTest(String bookTitle) {
        mainPage.openPage()
                .setSearchValue(bookTitle)
                .openDetailFormBook();
        bookPage.addBookToBasket()
                .closeModalWindow()
                .openBasket();
        basketPage.checkBasketContainsAddedBook(bookTitle)
                .deleteBook()
                .checkCartEmptyState();
    }
}
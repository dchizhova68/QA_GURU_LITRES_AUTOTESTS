package dchizhova68.tests;

import dchizhova68.pages.MainPage;
import dchizhova68.pages.NavigationPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@DisplayName("Проверка элементов навигации системы")
@Tag("NAVIGATION_TEST")
@Feature("Тестирования навигации по сайту")
public class NavigationTest extends TestBase {
    MainPage mainPage = new MainPage();
    NavigationPage navigationPage = new NavigationPage();


    @ParameterizedTest(name = "Навигационная цепочка в разделе {pageName} должна содержать пункт {navLastChildName}")
    @Owner("Darya Chizhova")
    @Severity(SeverityLevel.MINOR)
    @CsvFileSource(resources = "/test_data/checkBreadcrumbsTest.csv")
    void checkBreadcrumbsTest(String pageName, String navLastChildName) {
        mainPage.openPage();
        navigationPage.openPageByName(pageName)
                .checkBreadCrumbs(navLastChildName);
    }

    @Test
    @DisplayName("Проверка видимости рекламного баннера")
    @Owner("Darya Chizhova")
    @Severity(SeverityLevel.NORMAL)
    @Disabled("Баннер скрыт")
    void promoBannerVisibleTest() {
        mainPage.openPage()
                .checkPromoBanner();
    }

    @Test
    @DisplayName("Проверка отображения каталога")
    @Owner("Darya Chizhova")
    @Severity(SeverityLevel.BLOCKER)
    void openCatalogTest() throws InterruptedException {
        mainPage.openPage()
                .openCatalog()
                .checkGenresPopupVisible();
    }

    @Test
    @DisplayName("Проверка дополнительных пунктов меню")
    @Owner("Darya Chizhova")
    @Severity(SeverityLevel.CRITICAL)
    void openMoreItemsMenuTest() throws InterruptedException {
        mainPage.openPage()
                .openMoreItemsMenu()
                .checkMoreItemsMenuVisible();
    }
}

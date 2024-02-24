package dchizhova68.tests;

import dchizhova68.pages.PageObject;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@DisplayName("Проверка элементов навигации системы")
@Tag("NAVIGATION_TEST")
public class NavigationTest extends TestBase {
    PageObject litres = new PageObject();

    @ParameterizedTest(name = "Навигационная цепочка в разделе должна содержать название раздела")
    @Owner("Darya Chizhova")
    @CsvFileSource(resources = "/test_data/checkBreadcrumbsTest.csv")
    void checkBreadcrumbsTest(String pageName, String navLastChildName) {
        litres.openPage()
                .openPageByName(pageName)
                .checkBreadCrumbs(navLastChildName);
    }

    @Test
    @DisplayName("Проверка видимости рекламного баннера")
    @Owner("Darya Chizhova")
    void promoBannerVisibleTest() {
        litres.openPage()
                .checkPromoBanner();
    }

    @Test
    @DisplayName("Проверка каталога")
    @Owner("Darya Chizhova")
    void openCatalogTest() throws InterruptedException {
        litres.openPage();
        Thread.sleep(10000);
        litres.openCatalog()
                .checkGenresPopupVisible();
    }

    @Test
    @DisplayName("Проверка дополнительных пунктов меню")
    @Owner("Darya Chizhova")
    void openMoreItemsMenuTest() throws InterruptedException {
        litres.openPage();
        Thread.sleep(10000);
        litres.openMoreItemsMenu()
                .checkMoreItemsMenuVisible();
    }
}

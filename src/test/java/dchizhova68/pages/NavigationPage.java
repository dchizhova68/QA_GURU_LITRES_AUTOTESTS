package dchizhova68.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class NavigationPage {
    private SelenideElement

            breadcrumbsSelector = $("#breadcrumbs li:last-child");

    @Step("Открыть раздел '{pageName}'")
    public NavigationPage openPageByName(String pageName) {
        $(byTagAndText("a", pageName)).click();
        return this;
    }

    @Step("Проверить, что в навигационной цепочке присутствует пункт '{navLastChildName}'")
    public NavigationPage checkBreadCrumbs(String navLastChildName) {
        breadcrumbsSelector.shouldHave(text(navLastChildName));
        return this;
    }

}

package dchizhova68.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import dchizhova68.config.WebDriverConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

        Configuration.browser = config.getBrowserName();
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 30000;
        Configuration.baseUrl = System.getProperty("baseUrl", "https://www.litres.ru");

        if (config.isRemote()) {
            Configuration.remote
                    = config.getRemoteWebDriver();
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();

    }

}

package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",
})

public interface WebDriverConfig extends Config {

    @Key("browser")
    String getBrowserName();

    @Key("version")
    String getBrowserVersion();

    @Key("remote")
    String getRemoteWebDriver();

    @Key("isRemote")
    @DefaultValue("false")
    boolean isRemote();
}

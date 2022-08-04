package autotests.drivers;

import autotests.config.ConfigKey;
import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class BrowserstackMobileDriver implements WebDriverProvider {


    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        mutableCapabilities.setCapability("browserstack.user", ConfigKey.browserStackConfig.login());
        mutableCapabilities.setCapability("browserstack.key", ConfigKey.browserStackConfig.password());

        mutableCapabilities.setCapability("app", ConfigKey.browserStackConfig.app());

        mutableCapabilities.setCapability("device", ConfigKey.browserStackConfig.device());
      //  mutableCapabilities.setCapability("os_version", config.osVersion());

        mutableCapabilities.setCapability("project", ConfigKey.browserStackConfig.project());
        mutableCapabilities.setCapability("build", ConfigKey.browserStackConfig.build());
        mutableCapabilities.setCapability("name", ConfigKey.browserStackConfig.name());
        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    private URL getBrowserstackUrl() {
        try {
            return new URL(ConfigKey.browserStackConfig.baseUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

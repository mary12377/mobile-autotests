package autotests.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/local.properties",
        "classpath:config/app.properties"
})
public interface DoramaliveConfig extends Config {

    @Key("device.name")
    String deviceName();

    @Key("platform.name")
    String platformName();

    @Key("platform.version")
    String platformVersion();

    @DefaultValue("http://hub.browserstack.com/wd/hub")
    String browserstackUrl();

    @DefaultValue("emulator")
    String device();

    String login();

    String password();
}

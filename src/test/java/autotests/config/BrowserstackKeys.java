package autotests.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/browserstack.properties"
})
public interface BrowserstackKeys extends Config {

    String login();

    String password();

    String project();

    String build();

    String name();

    String app();

    String device();

    String osVersion();

    String baseUrl();

}

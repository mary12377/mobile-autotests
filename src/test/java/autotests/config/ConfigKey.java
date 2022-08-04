package autotests.config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigKey {
    public static BrowserstackKeys browserStackConfig = ConfigFactory.create(BrowserstackKeys.class,
            System.getProperties());
    public static LocalConfig configLocal = ConfigFactory.create(LocalConfig.class,
            System.getProperties());
}

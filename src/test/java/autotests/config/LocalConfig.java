package autotests.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:resources/config/local.properties")
public interface LocalConfig extends Config {
    @DefaultValue("android")
    String platformName();

    @DefaultValue("Pixel 3 API 33")
    String device();


    @DefaultValue("http://localhost:4723/wd/hub")
    String localURL();

}

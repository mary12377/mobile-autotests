package autotests.helpers;


import autotests.config.LocalConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class BrowserStack {
    static LocalConfig configLocal = ConfigFactory.create(LocalConfig.class, System.getProperties());
    public static String videoUrl(String sessionId) {
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic("selenideandroidt_Y8LeNs", "GpccRGqKdLTBd25dix34")
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .path("automation_session.video_url");
    }
}


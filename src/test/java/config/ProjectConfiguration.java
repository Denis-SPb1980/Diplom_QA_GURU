package config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;


public class ProjectConfiguration {
    private final WebConfig webConfig;

    public ProjectConfiguration(WebConfig webConfig) {
        this.webConfig = webConfig;
    }

    public void webConfig() {
        Configuration.baseUrl = webConfig.getBaseUrl();
        Configuration.browserSize = webConfig.getBrowserSize();
        Configuration.browser = webConfig.getBrowserName();
        Configuration.browserVersion = webConfig.getBrowserVersion();
        Configuration.pageLoadStrategy = "eager";

        if (webConfig.isRemote()) {
            Configuration.remote = String.valueOf(webConfig.getRemoteUrl());
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }
    }
}
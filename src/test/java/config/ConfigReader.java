package config;

import org.aeonbits.owner.ConfigFactory;

public enum ConfigReader {
    Instance;

    private static final WebConfig webConfig;

    static {
        if (System.getProperty("env") == null) {
            System.setProperty("env", "test");
        }

        webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());
    }

    public WebConfig read() {
        return webConfig;
    }
}
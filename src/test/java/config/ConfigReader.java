package config;

import org.aeonbits.owner.ConfigFactory;

public enum ConfigReader {
    Instance;

    private static final TestDataConfig webConfig;

    static {
        if (System.getProperty("env") == null) {
            System.setProperty("env", "test");
        }

        webConfig = ConfigFactory.create(TestDataConfig.class, System.getProperties());
    }

    public TestDataConfig read() {
        return webConfig;
    }
}
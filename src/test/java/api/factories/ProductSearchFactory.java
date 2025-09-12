package api.factories;

import config.ConfigReader;
import config.TestDataConfig;

public class ProductSearchFactory {

    private static final TestDataConfig apiConfig = ConfigReader.Instance.read();

    public String getApiKey() {
        String apiKey = System.getenv("API_KEY");
        if (apiKey == null) {
            apiKey = apiConfig.getApiKey();
        }
        return apiKey;
    }
}
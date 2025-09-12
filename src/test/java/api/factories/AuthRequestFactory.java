package api.factories;

import api.models.AuthorizationRequest;
import config.ConfigReader;
import config.TestDataConfig;

public class AuthRequestFactory {

    private static final TestDataConfig apiConfig = ConfigReader.Instance.read();

    public String getUsername() {
        String username = System.getenv("LOGIN");
        if (username == null) {
            username = apiConfig.getLogin();
        }
        return username;
    }

    public String getPassword() {
        String password = System.getenv("PASSWORD");
        if (password == null) {
            password = apiConfig.getPassword();
        }
        return password;
    }

    public String getIncorrectPassword() {
        return "1234567";
    }

    public AuthorizationRequest createAuthRequest() {
        return new AuthorizationRequest(getUsername(), getPassword());
    }

    public AuthorizationRequest createIncorrectAuthRequest() {
        return new AuthorizationRequest(getUsername(), getIncorrectPassword());
    }
}
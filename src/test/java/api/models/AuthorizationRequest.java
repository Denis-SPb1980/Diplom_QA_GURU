package api.models;

import lombok.Data;

@Data
public class AuthorizationRequest {
    private final String username = "5z6zx@mechanicspedia.com";
    private final String password = "123456";
    private final String incorrectPassword = "1234567";
}
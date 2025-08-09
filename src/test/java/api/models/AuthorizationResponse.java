package api.models;

import lombok.Data;

@Data
public class AuthorizationResponse {
    private String message;
    private boolean success;
}
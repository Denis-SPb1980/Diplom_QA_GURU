package api.models;

import lombok.Data;

@Data
public class AddToCartResponse {
    private String error;
    private boolean success;
    private Object item;
    private Object html;
}
package api.models;

import lombok.Data;

@Data
public class ProductSearchRequest {
    private String st;
    private String size;
    private final String apiKey = "9750TN84X6";
}
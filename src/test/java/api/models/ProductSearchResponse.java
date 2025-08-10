package api.models;

import lombok.Data;

@Data
public class ProductSearchResponse {
    private String error;
    private boolean zeroQueries;
    private String message;
    private String query;
    private int totalHits;
    private int status;
    private long timestamp;
    private String correction;
    private String path;
    private Object products;
}
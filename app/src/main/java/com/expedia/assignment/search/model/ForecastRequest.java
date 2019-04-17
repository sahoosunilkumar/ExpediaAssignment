package com.expedia.assignment.search.model;

public class ForecastRequest {
    private final String location;
    private final String query;

    public ForecastRequest(String location, String query) {
        this.location = location;
        this.query = query;
    }

    public String getLocation() {
        return location;
    }

    public String getQuery() {
        return query;
    }
}

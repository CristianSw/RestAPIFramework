package org.example.resources;

public enum APIResources {
    addPlaceAPI("/maps/api/place/add/json"),
    deletePlaceAPI("/maps/api/place/delete/json"),
    getPlaceAPI("/maps/api/place/get/json");

    private final String APIEndpoint;

    APIResources(String APIEndpoint) {
        this.APIEndpoint = APIEndpoint;
    }

    public String getAPIEndpoint() {
        return APIEndpoint;
    }
}
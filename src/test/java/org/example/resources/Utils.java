package org.example.resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Utils {

    public RequestSpecification requestSpecification(){
        return new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .addHeader("Content-Type","application/json")
                .addQueryParam("key","qaclick123")
                .build();
    }
}
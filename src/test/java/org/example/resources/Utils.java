package org.example.resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {

    public RequestSpecification requestSpecification() throws IOException {
        PrintStream ps = new PrintStream(new FileOutputStream("log.txt"));
        return new RequestSpecBuilder()
                .setBaseUri(getGlobalProperties("baseUrl"))
                .addHeader("Content-Type","application/json")
                .addQueryParam("key","qaclick123")
                .addFilter(RequestLoggingFilter.logRequestTo(ps))
                .addFilter(ResponseLoggingFilter.logResponseTo(ps))
                .build();
    }

    public String getGlobalProperties(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("/home/cristian/Development/RestAPIFramework/src/test/java/org/example/resources/global.properties");
        properties.load(fis);
        return properties.getProperty(key);

    }
}
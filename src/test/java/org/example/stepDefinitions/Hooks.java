package org.example.stepDefinitions;

import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks{

    @Before("@DeletePlace")
    public void beforeScenario() throws IOException {
        StepDefinition stepDefinition = new StepDefinition();
        if (StepDefinition.placeId == null) {
            stepDefinition.add_place_payload_with("CD", "Romanian", "Cahul");
            stepDefinition.user_call_s_with_http_request("addPlaceAPI", "post");
            stepDefinition.verifyCreatedMapsToUsingWithHttpRequest("place_id", "CD", "getPlaceAPI", "get");

        }
    }
}
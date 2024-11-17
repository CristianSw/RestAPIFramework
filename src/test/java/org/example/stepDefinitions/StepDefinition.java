package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.example.resources.APIResources;
import org.example.resources.TestDataBuild;
import org.example.resources.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepDefinition extends Utils {
    Response response;
    ResponseSpecification responseSpec;
    RequestSpecification res;
    TestDataBuild tdb = new TestDataBuild();
    String placeId;

    @Given("Add place payload with {string} {string} {string}")
    public void add_place_payload_with(String name, String language, String address) throws IOException {
        res = given()
                .spec(requestSpecification())
                .body(tdb.addPlacePayLoad(name, language, address));
    }

    @When("User call's {string} with {string} http request")
    public void user_call_s_with_http_request(String apiResource, String httpMethod) {

        APIResources apiResources = APIResources.valueOf(apiResource);

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();


        if (httpMethod.equalsIgnoreCase("post"))
            response = res.when().post(apiResources.getAPIEndpoint());
        else if (httpMethod.equalsIgnoreCase("get"))
            response = res.when().get(apiResources.getAPIEndpoint());
        else if (httpMethod.equalsIgnoreCase("delete"))
            response = res.when().delete(apiResources.getAPIEndpoint());

    }

    @Then("API call is success with {int} status code")
    public void api_call_is_success_with_status_code(int statusCode) {
        assertEquals(response.getStatusCode(), statusCode);
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String key, String value) {
        assertEquals(getJsonPathValue(response, key), value);
    }

    @And("Verify {string} created maps to {string} using {string} with {string} http request")
    public void verifyCreatedMapsToUsingWithHttpRequest(String key, String name, String apiResource, String httpMethod) throws IOException {
        placeId = getJsonPathValue(response, key);
        res = given()
                .spec(requestSpecification())
                .queryParam("place_id", placeId);
        user_call_s_with_http_request(apiResource, httpMethod);
        assertEquals(name, getJsonPathValue(response, "name"));
    }
}
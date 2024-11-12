package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.client.methods.RequestBuilder;
import org.example.pojo.AddPlace;
import org.example.pojo.Location;
import org.example.resources.TestDataBuild;
import org.example.resources.Utils;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepDefinition extends Utils {
    Response response;
    ResponseSpecification responseSpec;
    RequestSpecification res;
    TestDataBuild tdb = new TestDataBuild();

    @Given("Add place payload")
    public void add_place_payload() {
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();

        res = given()
                .spec(requestSpecification())
                .body(tdb.addPlacePayLoad());
    }
    @When("User call's {string} with post http request")
    public void user_call_s_with_post_http_request(String string) {
        response = res.when().post("/maps/api/place/add/json")
                .then().spec(responseSpec).extract().response();
    }
    @Then("API call is success with {int} status code")
    public void api_call_is_success_with_status_code(int statusCode) {
       assertEquals(response.getStatusCode(),statusCode);
    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String key, String value) {
        String strResponse = response.asString();
        JsonPath  js = new JsonPath(strResponse);
        assertEquals(js.get(key).toString(), value);
    }
}

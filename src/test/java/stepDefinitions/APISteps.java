package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class APISteps {

    RequestSpecification httpRequest;
    Response response;
    @When("I issue a GET request")
    public void iIssueAGETRequest() {

        RestAssured.baseURI = "https://randomuser.me/api/";
         httpRequest = RestAssured.given();

        response = httpRequest.get("");
    }

    @Then("I validate a successful response")
    public void iValidateASuccessfulResponse() {
        Assert.assertEquals("Unsuccessful response code - "+response.getStatusCode(),response.getStatusCode(),200);
    }
}

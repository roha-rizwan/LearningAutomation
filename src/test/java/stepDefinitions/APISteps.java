package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;
import org.junit.Assert;

import java.util.List;

public class APISteps {

    RequestSpecification httpRequest;
    Response response;
    @When("I issue a GET request")
    public void iIssueAGETRequest() {
        RestAssured.baseURI = "https://randomuser.me/api/";
        httpRequest = RestAssured.given();
        response = httpRequest.get("");
        response.prettyPrint();
    }
    @Then("I validate a successful response")
    public void iValidateASuccessfulResponse() {
        Assert.assertEquals("Unsuccessful response code - "+response.getStatusCode(),response.getStatusCode(),200);
    }
    @Then("I validate email detail is not null")
    public void iValidateEmailDetailIsNotNull() {
        JsonPath jsonPathEvaluator = response.jsonPath();
        List<String> emails = jsonPathEvaluator.getList("results.email");
        for (String email : emails) {
            Assert.assertFalse("Email address is null", email.isEmpty());
        }
    }

    @When("I issue an invalid GET request")
    public void iIssueAnInvalidGETRequest() {
        RestAssured.baseURI = "https://randomuser.me/apis/";
        httpRequest = RestAssured.given();
        response = httpRequest.get("");

    }
    @Then("I validate a unsuccessful response")
    public void iValidateAUnsuccessfulResponse() {
        Assert.assertEquals("Unsuccessful response code - "+response.getStatusCode(),response.getStatusCode(),404 );
    }
    @And("response body is not empty")
    public void responseBodyIsNotEmpty() {
        String responseBody = response.getBody().asString();
        Assert.assertFalse("Empty response body", responseBody.isEmpty());
    }
    @Then("I validate username and password detail is not null")
    public void iValidateUsernameAndPasswordDetailIsNotNull() {
        JsonPath jsonPathEvaluator = response.jsonPath();
        List<String> usernames = jsonPathEvaluator.getList("results.login.username");
        List<String> passwords = jsonPathEvaluator.getList("results.login.password");
        for (String username : usernames) {
            Assert.assertFalse("username is null", username.isEmpty());
        }
        for (String password : passwords) {
            Assert.assertFalse("password is null", password.isEmpty());
        }

    }
    @Then("I validate content type")
    public void iValidateContentType() {
        Assert.assertEquals("wrong content type- "+response.getContentType(),response.getContentType(),"application/json; charset=utf-8");
    }
    }




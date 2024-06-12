package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
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

    @And("Then i validate the body")
    public void thenIValidateTheBody() {
        String responseBody= response.asString();

        Assert.assertTrue("Response body contains Norway ", responseBody.contains("Lasalle"));
    }


    @Then("Then i validate email detail is not null")
    public void thenIValidateemailDetailsIsNotNull() {
        JsonPath jsonPathEvaluator=response.jsonPath();

        List<String> emails = jsonPathEvaluator.getList("results.email");

        for(String email : emails)
        {
            System.out.println("Login details: " + email);
            Assert.assertFalse("Email address is null", email.isEmpty());

        }

    }

    @When("I issue an invalid GET request")
    public void iIssueAnInvalidGETRequest() {
        RestAssured.baseURI = "https://randomuser.me/apis/";
        httpRequest = RestAssured.given();

        response = httpRequest.get("");
        response.prettyPrint();
    }

    @Then("I validate a unsuccessful response")
    public void iValidateAUnsuccessfulResponse() {
        Assert.assertEquals("Unsuccessful response code - "+response.getStatusCode(),response.getStatusCode(),404);
    }
    }



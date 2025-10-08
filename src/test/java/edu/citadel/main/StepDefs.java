package edu.citadel.main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefs extends SpringIntegrationTest {

    @Value("${info.app.name}")
    private String applicationName;

    @Value("${info.app.description}")
    private String applicationDescription;

    @Value("${info.app.version}")
    private String applicationVersion;

    @When("the client sends a GET request to {string}")
    public void theClientSendsAGETRequestTo(String path) {
        executeGet(creatURLWithPort(path));
    }

    @Then("the client receives a status code of {int}")
    public void theClientReceivesAStatusCodeOf(int statusCode) {
        assertEquals(statusCode, lastResponse.getStatusCode().value());
    }

    @And("the response body contains the JSON")
    public void theResponseBodyContainsTheJSON(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        assertEquals(mapper.readTree(json), mapper.readTree(lastResponse.getBody()));
    }

    @And("the response body contains the application name")
    public void theResponseBodyContainsTheApplicationName() {
        assertTrue(lastResponse.getBody().contains(applicationName));
    }

    @And("the response body contains the application version")
    public void theResponseBodyContainsTheApplicationVersion() {
        assertTrue(lastResponse.getBody().contains(applicationVersion));
    }

    @And("the response body contains the application description")
    public void theResponseBodyContainsTheApplicationDescription() {
        assertTrue(lastResponse.getBody().contains(applicationDescription));
    }

    @And("the response header {string} is {string}")
    public void theResponseHeaderIs(String headerName, String headerValue) {
        assertTrue(lastResponse.getHeaders().get(headerName).contains(headerValue));
    }
}

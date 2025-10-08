package edu.citadel.main;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;


@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringIntegrationTest {

    @LocalServerPort
    private int port;

    protected TestRestTemplate restTemplate = new TestRestTemplate();
    protected ResponseEntity<String> lastResponse;

    protected void executeGet(String url){
        lastResponse = restTemplate.getForEntity(url, String.class);
    }

    protected String creatURLWithPort(String url){
        return "http://localhost:"+port+url;
    }
}
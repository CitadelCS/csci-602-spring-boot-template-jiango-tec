Feature: Application Status and Information

  Scenario: The application health check endpoint is operational
    When the client sends a GET request to "/health"
    Then the client receives a status code of 200
    And the response body contains the JSON
      """
      {"status": "ok"}
      """

  Scenario: The application information endpoint returns correct data
    When the client sends a GET request to "/info"
    Then the client receives a status code of 200
    And the response body contains the application name
    And the response body contains the application version
    And the response body contains the application description

  Scenario: The application information endpoint returns the correct content type
    When the client sends a GET request to "/info"
    Then the client receives a status code of 200
    And the response header "Content-Type" is "application/json"

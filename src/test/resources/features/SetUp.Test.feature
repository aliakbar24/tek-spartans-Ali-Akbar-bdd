Feature: This feature to setup framework

  Scenario: Validate top left corner logo
    # Given open browser and navigate to retail app
    Then validate top left corner is TEKSCHOOL
    # Then close the browser

  Scenario: Validate logo on top left and Sign in button
    Then validate top left corner is TEKSCHOOL
    Then validate Sign in button is enabled
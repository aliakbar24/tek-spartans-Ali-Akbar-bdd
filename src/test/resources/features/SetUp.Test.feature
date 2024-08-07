Feature: This feature to setup framework

  @Smoke
  Scenario: Validate top left corner logo
    # Given open browser and navigate to retail app
    Then validate top left corner is TEKSCHOOL
    # Then close the browser
  @Smoke
  Scenario: Validate Logo and Sign in button
    Then validate top left corner is TEKSCHOOL
    Then Validate Sign in button is Enabled

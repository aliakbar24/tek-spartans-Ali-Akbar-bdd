@Regression
Feature: Creating account scenarios

  Background: Setup create account scenarios
    Given user click on "Sign in" link
    Then validate user is in sign in page
    Given user click on "Create New Account" link

  Scenario: create valid account with random email
    When user enter "Ali" and "random" and "Password@123"
    When user click on "Sign Up" button
    Then validate user is in account page
    Then validate email address in account page match

    @UserStory1
  Scenario: Create account with existing email
    When user enter "Ali" and "akbar.ali@gmail.com" and "Password@123"
    When user click on "Sign Up" button
    Then user should see error "this email already exists, please use another email address"
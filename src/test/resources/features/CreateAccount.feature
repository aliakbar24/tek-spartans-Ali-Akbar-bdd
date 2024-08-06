Feature: Creating account scenarios

  Scenario: navigate to account page then create an account then validate the new account creation
    Given user click on "Sign in" link
    Then validate user is in sign in page
    Given user click on "Create New Account" link
    When user enter "Ali" and "random" and "Password@123"
    When user click on "Sign Up" button
    Then validate user is in account page
    Then validate email address in account page match
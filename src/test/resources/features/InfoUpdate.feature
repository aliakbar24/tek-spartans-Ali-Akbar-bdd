Feature: Update account information
  Background: Login to account and setups
    When user click on sign in link
    Then validate user is in sign in page
    When user enter "akbar.ali@gmail.com" and "Password@123" and click on login
    Then user should be able to see account link
    Given user click on "Account" link

    @UserStory5
  Scenario: Update account information and validate it
      Then validate user is in account page
      When user enter "Ali" on "Name" field
      When user enter "6826826822" on "Phone Number" field
      When user click on "Update" button
      Then validate Toast Displayed
      When wait for 5 seconds
      Then validate account name is "Ali"
      When user enter "Akbar" on "Name" field
      When user enter "1234567890" on "Phone Number" field
      When user click on "Update" button
      Then validate Toast Displayed

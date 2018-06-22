@Amazon
Feature: Login feature file

  @Login
  Scenario: Verify login functionality of customer
    Given I am on Amazon page
    When I enter user name and password
    Then I should be on the Home Page

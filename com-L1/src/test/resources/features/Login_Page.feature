@login @regression
Feature: Feature: WebDriver University - Login Page


  Background:
    Given i access the webdriver university Login Page


  Scenario: Validate Sucessful Login - Specific Data

    When i enter a specific username
    And i enter a specific password
    And i click on the login botton
    Then i should get a succession pop-up


  Scenario: Validate Succesful Login - Given Data

    When i enter a username "webdriver"
    And i enter a password webdriver123
    And i click on the login botton
    Then i should get a succession pop-up


  Scenario: Validate Unsuccesful Login - Given Data

    When i enter a username "webdriver"
    And i enter a password webdriver1
    And i click on the login botton
    Then i should get an unseccesful login pop-up

  @ananinami
  Scenario Outline: Validate Succesful & Unsuccesful Login
    When i enter a unique username <username>
    And i enter a password <password>
    And i click on the login botton
    Then i should be presented with the following login validation message <loginValidationMessage>

    Examples:
      | username  | password     | loginValidationMessage |
      | webdriver | webdriver123 | validation succeeded   |
      | webdriver | webdriver1   | validation failed      |
      | burak     | ananinami    | validation failed      |


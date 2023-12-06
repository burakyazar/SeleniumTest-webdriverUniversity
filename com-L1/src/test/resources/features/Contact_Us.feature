@contact-us @regression
Feature: WebDriver University - Contact Us Page


  Scenario Validate Succesful Submission - Unique Data
    Given i access the webdriver university contact us page
    When i enter a unique first name
    And i enter a unique last name
    And i enter a unique e-mail adress
    And i enter a unique comment
    And i click on the submit botton
    Then i should be presented with a succesful contact us submission message
    And i want to run the scenario 10 times



  Scenario: Validate Succesful Submission - Specific Data
    Given i access the webdriver university contact us page
    When i enter a specific first name burak
    And i enter a specific last name yazar
    And i enter a specific email adress burakyazar@gmail.com
    And i enter a specific comment "How are you?"
    And i click on the submit botton
    Then i should be presented with a succesful contact us submission message




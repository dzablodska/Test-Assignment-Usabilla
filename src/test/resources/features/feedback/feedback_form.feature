Feature: Feedback form

  Scenario: Create generic feedback with all fields filled in
    Given the user is on the Usabilla home page
    When the user selects General feedback
    And the user fills in all fields
    Then feedback should be submitted

  Scenario: Create specific feedback with all fields filled in
    Given the user is on the Usabilla home page
    When the user selects Specific feedback
    And the user fills in all fields
    Then feedback should be submitted

  Scenario: Create generic feedback with mandatory fields filled in
    Given the user is on the Usabilla home page
    When the user selects General feedback
    And the user fills in all mandatory fields
    Then feedback should be submitted

  Scenario: Create generic feedback with incorrect email address
    Given the user is on the Usabilla home page
    When the user selects General feedback
    And the user fills all mandatory fields with incorrect email
    Then email validation error should be shown


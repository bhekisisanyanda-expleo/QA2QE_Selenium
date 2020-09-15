Feature: Select Product

  Scenario: View and Select Product

    Given I am a visitor
    When I search for a product
    And I view a product
    Then I am able to select the product

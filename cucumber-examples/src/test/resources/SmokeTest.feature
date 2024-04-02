Feature: Login to sauce labs page

  Scenario: Login to sauce labs successfully
    Given user opens sauce labs demo page
    And user enters login "standard_user" on Login page
    And user enters password "secret_sauce" on Login page
    When user clicks login button on Login page
    Then user redirected to Inventory page


  Scenario: Add item to basket and check notifications count
    Given user opens sauce labs demo page
    And user enters login "standard_user" on Login page
    And user enters password "secret_sauce" on Login page
    When user clicks login button on Login page
    Then user redirected to Inventory page
    When user adds to cart "Sauce Labs Fleece Jacket" item on Inventory page
    And user see 1 notifications on the basket icon on Inventory page

  Scenario: Check click on basket redirects to Cart page
    Given user opens sauce labs demo page
    And user enters login "standard_user" on Login page
    And user enters password "secret_sauce" on Login page
    When user clicks login button on Login page
    Then user redirected to Inventory page
    And user clicks on basket button on Inventory page
    Then user redirected to Cart page





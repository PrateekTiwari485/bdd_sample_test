Feature: Product Search
  As a user, I should navigate to the home page of filpkart and validate search option.

  Scenario: As a user, I should able search product through product name in home page.
    Given I navigate to "https://www.flipkart.com/"
    When I entered "MOTOROLA Edge 50" in search box and enter
    Then I navigated to the page contains title "MOTOROLA Edge 50"

  Scenario: As a user, I can see filters for search results.
    Given I navigate to "https://www.flipkart.com/"
    When I entered "MOTOROLA Edge 50" in search box and enter
    Then I can see below filters present for search results
    |Relevance|
    |Popularity|
    |Price -- Low to High|
    |Price -- High to Low|
    |Newest First|
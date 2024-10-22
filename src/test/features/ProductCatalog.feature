Feature: Product Catalog
  As a user, I should navigate to the home page of filpkart and validate items.

  Scenario: As a user, I should able see categories in home page.
    Given I navigate to "https://www.flipkart.com/"
    When I am at home page
    Then I can see below categories listed there
    |Mobiles & Tablets|
    |TVs & Appliances|
    |Electronics|
    |Fashion|
    |Beauty|
    |Home & Kitchen|
    |Furniture|
    |Travel|
    |Grocery|

  Scenario: As a user, I should able select mobile as category in home page.
    Given I navigate to "https://www.flipkart.com/"
    When I selected "Mobiles & Tablets" in the listed categories
    Then  I navigated to the page with title "Mobile Phones Online at Best Prices in India"
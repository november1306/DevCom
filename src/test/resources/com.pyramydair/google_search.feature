Feature: Google Search

  Scenario: Search for YouTube and verify the YouTube page
    Given I am on the Google homepage
    When I search for "YouTube"
    And I click on the "YouTube" link
    Then I should be redirected to the YouTube page
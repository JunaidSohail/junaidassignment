Feature: test Api search

  Scenario: API search assignment
    Given Open URL with chrome
    When user type furry rabbits
    Then check page title
   
   
  Scenario: Check timestamp after searching
  
  Given user is on the search page
  When seasme page details requested
  Then get timestamp
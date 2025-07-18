
Feature: Test Login fucntionality for Orange Hrm 

  Scenario Outline: Login functionality with different credentials
  
    Given User opened the Browser
    And Navigate to URL and open the login page
    When User enter "<Username>" and "<Password>"
    And Click on login button
    Then Message Should display "<Message>" 
    And Close the Browser

    Examples: 
      | Username  | Password | Message  |
      | Admin |     admin123 | success |
      | arjun |     password | Invalid credentials |
      | 		  |              | Username and password should not be empty |


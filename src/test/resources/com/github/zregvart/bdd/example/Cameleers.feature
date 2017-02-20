Feature: Manage cameleers 
    As a Cameleers app user
    I wish to manage cameleers
    To get a better understanding of how many cameleers are out there and what camels do they own

Background: 
    Given a cameleer "Zoran" with camels: 
        | Name      | Description               |
        | Camelia   | Two humps, slight limp    |
    And a cameleer "This Danish guy" with camels: 
        | Name      | Description               |
        | Al Fahl   | Male, procreative         |
        | Addawser  | Very big one              |
        | Al Mataya | Young, rideable           |
        | Al Rahila | Young, rideable           |
        | Al Gasreed| Does not drink much water |
        | Al Ghab   | Drinks once every two days|
        | Al Rabea  | Drinks every three days   |
        | Melwah    | Always thirsty            |
        | Al Riffa  | Drinks water at any time  |

Scenario: Listing cameleers 
    When I open the Cameleers application 
    Then I am presented with cameleer "Zoran" with 1 camel 
    And I am presented with cameleer "This Danish guy" with 9 camels 

Scenario: Add a camel to cameleers herd 
    When I open the Cameleers application 
    When I edit the cameleer "Zoran" 
    And I add a camel named "Humpy Dumpy" with description "A very mary one" 
    Then I am presented with cameleer "Zoran" with 2 camel 

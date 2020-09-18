Feature: Logged in user can create new address
  Scenario Outline:
    Given user has an open browser with open coderslab shop
    When user logs in to his account
    And user goes to addresses and adds new <alias>,<address>,<city>,<postcode>
    Then new address contains correct <alias>,<address>,<city>,<postcode>
    Then user can delete the address

    Examples:
    |alias|address|city|postcode|
    |newAddress|ul.Dluga 17|Krakow|31-432|

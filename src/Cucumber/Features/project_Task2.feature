Feature: user is able to log into his account and to by items of various size and quantity
  Scenario Outline:
    Given user has an open page of CodersLab store
    Then user logs in to his account using valid <email> and <password>
    Then user finds the item <item>
    And user is able to choose the size <size> and the quantity <quantity> and adds the product
    Then user goes to checkout option and confirms the address
    Then user chooses the delivery method,payment option and clicks "order with an obligation to pay"
    Then it is possible to make screenshot of the order

    Examples:
    |email|password|item|size|quantity|
    |kislaya.ann@mail.ru|a1234567a|Hummingbird Printed Sweater|XL|5|


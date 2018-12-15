Feature: Math operations


  Scenario: Can add two  numbers
    Given number is 1
    And  number is 2
    When I add numbers
    Then I get 3 in result


  Scenario Outline: Can add two  numbers
    Given number is <first_added>
    Given number is <second_added>
    When I add numbers
    Then I get <result> in result

    Examples:

      | first_added | second_added | result |
      | 2           | 2            | 4      |


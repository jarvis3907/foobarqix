Feature: Testing a Foobarqix API
  Users should able to compute the foobarqix for the given input

  Scenario: 1st Scenario to compute
    When users wants to compute foobarqix for '5'
    Then the server should handle it and the status code is 200
    And the response should be 'BarBar'

  Scenario: 2nd Scenario to compute
    When users wants to compute foobarqix for '10101'
    Then the server should handle it and the status code is 200
    And the response should be 'FooQix**'

  Scenario: 3rd Scenario to compute
    When users wants to compute foobarqix for 'asdad'
    Then the server should handle it and the status code is 400
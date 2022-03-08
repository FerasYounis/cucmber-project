Feature: loan offers

  Background:
    Given Data setup loan offers

  @WebReady @Regression @Smoke @HappyBath @StoryTicket-1234 @RestMissing
  Scenario Outline: A loan borrower, you can see loan offers after filling the required information
    When loan borrower enter loan amount as "2000" and select "any purpose"
    And Check your Rate
    And They fill out personal information <firstName> <lastName>, <address> <city> <state> <zipcode>, and <birthday>
    And They fill out financial situation <annualAmount> and <additionalAmount>
    Then Create user account with <password>
    And They accept the Terms of Use and Check their Rate and sign out
    And They Sign In with the new USERNAME to their account
    Then Check your offer
    Examples:
      | firstName | lastName | address      | city   | state | zipcode | birthday   | annualAmount | additionalAmount | password  |
      | feras     | younis   | 123rd Street | Queens | NY    | 11428   | 01/22/1989 | 140000       | 20000            | Feras1985 |

  @RestReady @Regression @Smoke @StoryTIcket-1235 @WebMissing
  Scenario: Check if the loan application exists and do contract testing for the response
    When Check loan exist by id "b8096ec7-2150-405f-84f5-ae99864b3e96" and Side Effects is set to "ture"
#    Then validate details of the loan


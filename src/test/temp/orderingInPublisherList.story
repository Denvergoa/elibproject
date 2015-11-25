Meta:

Narrative:


As a User
I want to order publishers in Publisher page
So that could see them in ascending or descending order

Scenario 1
Given I am a User browsing publishers list
When I click $value button on Publishers page
Then Ascending arrow appears on $value button on Publishers page
And All books are displayed in correct order on Publishers page of $value
And Books with null values of the $value are displayed in the end of the list on Publishers page

Examples:
|$value|
|Name|
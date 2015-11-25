Meta:

Narrative:
As a User
I want to order Authors in Authors page
So that could see them in ascending or descending order

Scenario 1
Given I am a User browsing Authors list
When I click $value button on Authors page
Then Ascending arrow appears on $value button on Authors page
And All books are displayed in correct order of $value on Authors page
And Books with null values of the $value are displayed in the end of the list on Authors page

Examples:
|$value|
|FirstName|
|LastName|
|DateOfBirth|



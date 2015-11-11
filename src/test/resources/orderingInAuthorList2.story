Meta:

Narrative:
As a User
I want to order Authors in Authors page
So that could see them in ascending or descending order

Scenario 2
Given I am a User browsing Authors list
When I click $value button once more on Authors page
Then Descending arrow appears on $value button on Authors page
And All books are displayed in descending order of $value on Authors page
And Books with null values of the $value are displayed in the end of the list on Authors page

Examples:
|$value|
|FirstName|
|LastName|
|DateOfBirth|


Narrative:
As a User
I want to order books in books page
So that could see them in ascending or descending order

Scenario 1
Given I am a User browsing book list
When I click $value button on Book page
Then Ascending arrow appears on $value button on Book page
And All books are displayed in correct order of $value on Book page
And Books with null values of the $value are displayed in the end of the list on Book page

Examples:
|$value|
|Title|
|Year|
|Authors|
|Publishers|
|Rating|
|Date|
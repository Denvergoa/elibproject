Narrative:
As a User
I want to order books in books page
So that could see them in ascending or descending order

Scenario 2
Given I am a User browsing book list
When I click $value button once more on Book page
Then Descending arrow appears on $value button on Book page
And All books are displayed in descending order of $value on Book page
And Books with null values of the $value are displayed in the end of the list on Book page

Examples:
|$value|
|Title|
|Year|
|Authors|
|Publishers|
|Rating|
|Date|
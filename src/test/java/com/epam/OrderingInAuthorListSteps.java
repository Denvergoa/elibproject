package com.epam;

import com.epam.steps.StepsOrderingInAuthorList;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.text.ParseException;

public class OrderingInAuthorListSteps {

    @Steps
    StepsOrderingInAuthorList stepsOrderingInAuthorList;

    @Given("I am a User browsing Authors list")
    public void userBrowsingAuthorList(){
        stepsOrderingInAuthorList.userOpensAuthorPage();
    }

    @When("I click $value button on Authors page")
    public void userClickValueButton(@Named("$value") String value){
        stepsOrderingInAuthorList.userClickValueButton(value);
    }

    @When("I click $value button once more on Authors page")
    public void userClickValueButtonOnceMore(@Named("$value") String value){
        stepsOrderingInAuthorList.userClickValueButton(value);
        stepsOrderingInAuthorList.userClickValueButton(value);
    }

    @Then("Ascending arrow appears on $value button on Authors page")
    public void ascendingArrowAppears(@Named("$value") String value){
        stepsOrderingInAuthorList.ascendingArrowIsPresent(value);
    }

    @Then("All books are displayed in correct order of $value on Authors page")
     public void allBooksAreDisplayedInCorrectOrder(@Named("$value") String value) throws ParseException {
        stepsOrderingInAuthorList.correctBookOrder(value);
    }

    @Then("All books are displayed in descending order of $value on Authors page")
    public void allBooksAreDisplayedInDescendingOrder(@Named("$value") String value) throws ParseException {
        stepsOrderingInAuthorList.correctBookDescendingOrder(value);
    }

    @Then("Books with null values of the $value are displayed in the end of the list on Authors page")
    public void booksWithNullValuesAreDisplayedInTheEnd(@Named("$value") String value){
        stepsOrderingInAuthorList.correctNullBookOrder(value);
    }

    @Then("Descending arrow appears on $value button on Authors page")
    public void descendingArrowAppears(@Named("$value") String value){
        stepsOrderingInAuthorList.ascendingArrowIsPresent(value);
    }

}

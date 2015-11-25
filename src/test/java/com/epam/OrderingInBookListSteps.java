package com.epam;

import com.epam.steps.StepsOrderingInBookList;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;


import java.text.ParseException;

public class OrderingInBookListSteps {

    @Steps
    StepsOrderingInBookList stepsOrderingInBookList;

    @Given("I am a User browsing book list")
    public void userBrowsingBookList(){
        stepsOrderingInBookList.userOpensBookPage();
    }

    @When("I click $value button on Book page")
    public void userClickValueButton(@Named("$value") String value){
        stepsOrderingInBookList.userClickValueButton(value);
    }

    @When("I click $value button once more on Book page")
    public void userClickValueButtonOnceMore(@Named("$value") String value){
        stepsOrderingInBookList.userClickValueButton(value);
        stepsOrderingInBookList.userClickValueButton(value);
    }

    @Then("Ascending arrow appears on $value button on Book page")
    public void ascendingArrowAppears(@Named("$value") String value){
        stepsOrderingInBookList.ascendingArrowIsPresent(value);
    }

    @Then("Descending arrow appears on $value button on Book page")
    public void descendingArrowAppears(@Named("$value") String value){
        stepsOrderingInBookList.ascendingArrowIsPresent(value);
    }

    @Then("All books are displayed in correct order of $value on Book page")
    public void allBooksAreDisplayedInCorrectOrder(@Named("$value") String value) throws ParseException {
        stepsOrderingInBookList.correctBookOrder(value);
    }

    @Then("All books are displayed in descending order of $value on Book page")
    public void allBooksAreDisplayedInDescendingOrder(@Named("$value") String value) throws ParseException {
        stepsOrderingInBookList.correctBookDescendingOrder(value);
    }

    @Then("Books with null values of the $value are displayed in the end of the list on Book page")
    public void booksWithNullValuesAreDisplayedInTheEnd(@Named("$value") String value){
        stepsOrderingInBookList.correctNullBookOrder(value);
    }



}

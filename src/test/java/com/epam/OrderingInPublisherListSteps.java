package com.epam;


import com.epam.steps.StepsOrderingInPublisherList;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.text.ParseException;

public class OrderingInPublisherListSteps {

    @Steps
    StepsOrderingInPublisherList stepsOrderingInPublisherList;

    @Given("I am a User browsing publishers list")
    public void userBrowsingBookList(){

    }

    @When("I click $value button on Publishers page")
    public void userClickValueButton(@Named("$value") String value){
        stepsOrderingInPublisherList.userClickValueButton(value);
    }

    @When("I click $value button once more on Publishers page")
    public void userClickValueButtonOnceMore(@Named("$value") String value){
        stepsOrderingInPublisherList.userClickValueButton(value);
        stepsOrderingInPublisherList.userClickValueButton(value);
    }

    @Then("Ascending arrow appears on $value button on Publishers page")
    public void ascendingArrowAppears(@Named("$value") String value){
        stepsOrderingInPublisherList.ascendingArrowIsPresent(value);
    }

    @Then("All books are displayed in correct order on Publishers page of $value")
    public void allBooksAreDisplayedInCorrectOrder(@Named("$value") String value) throws ParseException {
        stepsOrderingInPublisherList.correctBookOrder(value);
    }

    @Then("All books are displayed in descending order on Publishers page of $value")
    public void allBooksAreDisplayedInDescendingOrder(@Named("$value") String value) throws ParseException {
        stepsOrderingInPublisherList.correctBookDescendingOrder(value);
    }

    @Then("Books with null values of the $value are displayed in the end of the list on Publishers page")
    public void booksWithNullValuesAreDisplayedInTheEnd(@Named("$value") String value){
        stepsOrderingInPublisherList.correctNullBookOrder(value);
    }

    @Then("Descending arrow appears on $value button on Publishers page")
    public void descendingArrowAppears(@Named("$value") String value){
        stepsOrderingInPublisherList.ascendingArrowIsPresent(value);
    }

}

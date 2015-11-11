package com.epam.steps;


import com.epam.pageObject.AuthorsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;


import java.text.ParseException;

import static org.junit.Assert.assertTrue;


public class StepsOrderingInAuthorList extends ScenarioSteps {
    AuthorsPage authorsPage;
    @Step
    public void userOpensAuthorPage() {
        authorsPage.open();
    }
    @Step
    public void userClickValueButton(String value) {
        authorsPage.orderByValue(value);
    }
    @Step
    public void ascendingArrowIsPresent(String value) {
        assertTrue("Arrow is not displayed", authorsPage.checkPresenceOfArrow(value));
    }
    @Step
    public void correctBookOrder(String value) throws ParseException {
        assertTrue("Book ordering is not correct", authorsPage.checkCorrectBookOrdering(value));
    }
    @Step
    public void correctBookDescendingOrder(String value) throws ParseException {
        assertTrue("Descending book ordering is not correct", authorsPage.checkBookDescendingOrder(value));
    }
    @Step
    public void correctNullBookOrder(String value) {
        assertTrue("Null book ordering is not correct", authorsPage.checkNullBookOrder(value));
    }
}

package com.epam.steps;


import com.epam.pageObject.AuthorsListPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;


import java.text.ParseException;

import static org.junit.Assert.assertTrue;


public class StepsOrderingInAuthorList extends ScenarioSteps {
    AuthorsListPage authorsListPage;
    @Step
    public void userOpensAuthorPage() {
        authorsListPage.open();
    }
    @Step
    public void userClickValueButton(String value) {
        authorsListPage.orderByValue(value);
    }
    @Step
    public void ascendingArrowIsPresent(String value) {
        assertTrue("Arrow is not displayed", authorsListPage.checkPresenceOfArrow(value));
    }
    @Step
    public void correctBookOrder(String value) throws ParseException {
        assertTrue("Book ordering is not correct", authorsListPage.checkCorrectBookOrdering(value));
    }
    @Step
    public void correctBookDescendingOrder(String value) throws ParseException {
        assertTrue("Descending book ordering is not correct", authorsListPage.checkBookDescendingOrder(value));
    }
    @Step
    public void correctNullBookOrder(String value) {
        assertTrue("Null book ordering is not correct", authorsListPage.checkNullBookOrder(value));
    }
}

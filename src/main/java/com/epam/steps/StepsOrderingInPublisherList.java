package com.epam.steps;


import com.epam.pageObject.PublishersPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;


import java.text.ParseException;

import static org.junit.Assert.assertTrue;


public class StepsOrderingInPublisherList extends ScenarioSteps {
    PublishersPage publishersPage;
    @Step
    public void userOpensBookPage() {
        publishersPage.open();
    }
    @Step
    public void userClickValueButton(String value) {
        publishersPage.orderByValue(value);
    }
    @Step
    public void ascendingArrowIsPresent(String value) {
        assertTrue("Arrow is not displayed", publishersPage.checkPresenceOfArrow(value));
    }
    @Step
    public void correctBookOrder(String value) throws ParseException {
        assertTrue("Book ordering is not correct", publishersPage.checkCorrectBookOrdering(value));
    }
    @Step
    public void correctBookDescendingOrder(String value) throws ParseException {
        assertTrue("Descending book ordering is not correct", publishersPage.checkBookDescendingOrder(value));
    }
    @Step
    public void correctNullBookOrder(String value) {
        assertTrue("Null book ordering is not correct", publishersPage.checkNullBookOrder(value));
    }
}

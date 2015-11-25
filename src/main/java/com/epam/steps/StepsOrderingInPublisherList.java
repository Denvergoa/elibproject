package com.epam.steps;


import com.epam.pageObject.PublishersListPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;


import java.text.ParseException;

import static org.junit.Assert.assertTrue;


public class StepsOrderingInPublisherList extends ScenarioSteps {
    PublishersListPage publishersListPage;
    @Step
    public void userOpensPublisherPage() {
        publishersListPage.open();
    }
    @Step
    public void userClickValueButton(String value) {
        publishersListPage.orderByValue(value);
    }
    @Step
    public void ascendingArrowIsPresent(String value) {
        assertTrue("Arrow is not displayed", publishersListPage.checkPresenceOfArrow(value));
    }
    @Step
    public void correctBookOrder(String value) throws ParseException {
        assertTrue("Book ordering is not correct", publishersListPage.checkCorrectBookOrdering(value));
    }
    @Step
    public void correctBookDescendingOrder(String value) throws ParseException {
        assertTrue("Descending book ordering is not correct", publishersListPage.checkBookDescendingOrder(value));
    }
    @Step
    public void correctNullBookOrder(String value) {
        assertTrue("Null book ordering is not correct", publishersListPage.checkNullBookOrder(value));
    }


}

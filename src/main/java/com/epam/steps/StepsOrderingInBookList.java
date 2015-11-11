package com.epam.steps;

import com.epam.pageObject.BookPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.text.ParseException;

import static org.junit.Assert.assertTrue;


public class StepsOrderingInBookList extends ScenarioSteps {
    BookPage bookPage;
    @Step
    public void userOpensBookPage() {
        bookPage.open();
    }
    @Step
    public void userClickValueButton(String value) {
        bookPage.orderByValue(value);
    }
    @Step
    public void ascendingArrowIsPresent(String value) {
        assertTrue("Arrow is not displayed", bookPage.checkPresenceOfArrow(value));
    }
    @Step
    public void correctBookOrder(String value) throws ParseException {
        assertTrue("Book ordering is not correct", bookPage.checkBookOrder(value));
    }
    @Step
    public void correctBookDescendingOrder(String value) throws ParseException {
        assertTrue("Descending book ordering is not correct", bookPage.checkBookDescendingOrder(value));
    }
    @Step
    public void correctNullBookOrder(String value) {
        assertTrue("Null book ordering is not correct", bookPage.checkNullBookOrder(value));
    }
}

package com.epam.steps;

import com.epam.pageObject.BooksListPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.text.ParseException;

import static org.junit.Assert.assertTrue;


public class StepsOrderingInBookList extends ScenarioSteps {
    BooksListPage booksListPage;
    @Step
    public void userOpensBookPage() {
        booksListPage.open();
    }
    @Step
    public void userClickValueButton(String value) {
        booksListPage.orderByValue(value);
    }
    @Step
    public void ascendingArrowIsPresent(String value) {
        assertTrue("Arrow is not displayed", booksListPage.checkPresenceOfArrow(value));
    }
    @Step
    public void correctBookOrder(String value) throws ParseException {
        assertTrue("Book ordering is not correct", booksListPage.checkBookOrder(value));
    }
    @Step
    public void correctBookDescendingOrder(String value) throws ParseException {
        assertTrue("Descending book ordering is not correct", booksListPage.checkBookDescendingOrder(value));
    }
    @Step
    public void correctNullBookOrder(String value) {
        assertTrue("Null book ordering is not correct", booksListPage.checkNullBookOrder(value));
    }
}

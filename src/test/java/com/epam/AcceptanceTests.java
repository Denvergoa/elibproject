package com.epam;

import net.serenitybdd.jbehave.SerenityStories;

public class AcceptanceTests extends SerenityStories {
    //run in one session
    public AcceptanceTests() {
        runSerenity().inASingleSession();
    }
}
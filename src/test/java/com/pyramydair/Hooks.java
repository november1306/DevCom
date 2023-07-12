package com.pyramydair;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hooks {

//    @BeforeAll
//    public static void setUpDriver() {
//        DriverManager.setup();
//    }

    @Before
    public void startDriver() {
        DriverManager.getDriver();
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}

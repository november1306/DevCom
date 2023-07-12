package com.pyramydair.pages;

import com.pyramydair.DriverManager;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverManager.getDriver();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
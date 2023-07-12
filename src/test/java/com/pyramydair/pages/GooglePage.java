package com.pyramydair.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GooglePage extends BasePage {

    public static final String GOOGLE_URL = "https://www.google.com";
    private final By searchBox = By.name("q");
    private final By searchButton = By.name("btnK");
    private final By linkResults = By.cssSelector("div.rc a");

    public GooglePage () {
        waitOnPage();
    }

    public void navigateTo() {
        driver.get(GOOGLE_URL);
    }

    public void searchFor(String keyword) {
        WebElement searchInput = driver.findElement(searchBox);
        searchInput.sendKeys(keyword);
        searchInput.submit();
    }

    public void clickLink(String linkText) {

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.partialLinkText(linkText)));
        WebElement link = driver.findElement(By.partialLinkText(linkText));
        link.click();
    }

    public void waitOnPage() {
//        wait.until(ExpectedConditions.presenceOfElementLocated(searchButton));
    }
}

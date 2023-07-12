package com.pyramydair.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class YoutubePage extends BasePage {
    public static final String YOUTUBE_URL = "https://www.youtube.com";
    private final By logoIcon = By.cssSelector("a#logo");


    public YoutubePage() {
        waitOnPage();
    }

    public void waitOnPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(logoIcon));
    }
}

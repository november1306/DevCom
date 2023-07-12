package com.pyramydair.steps;

import com.pyramydair.pages.GooglePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class GoogleSearchSteps {
    private GooglePage googlePage;

    @Given("I am on the Google homepage")
    public void navigateToGoogleHomepage() {
        googlePage = new GooglePage();
        googlePage.navigateTo();
    }

    @When("I search for {string}")
    public void searchForKeyword(String keyword) {
        googlePage.searchFor(keyword);
    }

    @And("I click on the {string} link")
    public void clickOnLink(String linkText) {
        googlePage.clickLink(linkText);
    }

    @Then("I should be redirected to the YouTube page")
    public void verifyRedirectedToYouTubePage() {
        String currentUrl = googlePage.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("youtube.com"), "Not redirected to the YouTube page");
    }
}
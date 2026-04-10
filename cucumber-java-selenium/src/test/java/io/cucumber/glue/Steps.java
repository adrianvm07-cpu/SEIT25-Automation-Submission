package io.cucumber.glue;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.pages.herokuHomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class Steps {

    private ChromeDriver driver;
    private herokuHomePage homePage;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        homePage = new herokuHomePage(driver);
        System.out.println("Made driver");
    }

    @After
    public void tearDown() {
        driver.quit();
        System.out.println("Quit driver");
    }

    @Given("the page under test is {string}")
    public void goToHomePage(String url) {
        driver.get(url);
        System.out.println("Current Page to: " + url);
    }

    @And("I can see the \"Available Examples\" header")
    public void verifyHeader() {
        String headerText = homePage.getHeaderText();
        System.out.println("Header detected: " + headerText);
    }

    @Then("The links are displayed")
    public void displayLinks() {
        List<WebElement> links = homePage.getAllLinks();
        System.out.println("The links in the Available Examples are: ");
        for (WebElement link : links) {
            System.out.println("- " + link.getText());
        }
    }
}

package io.cucumber.glue;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.pages.herokuHomePage;
import org.openqa.selenium.By;
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

    @When("the Basic Auth example is opened")
    public void selectBasicAuth(){
        //String message = driver.findElement(By.linkText("Basic Auth")).getText();
        System.out.println("Link detected: " + homePage.basicAuthLink());
        homePage.basicAuthLink().click();
    }

    @And("valid credentials are supplied")
    public void enterBasicAuth(){
        // Format: https://username:password@domain.com
        // For this site, the credentials are admin / admin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    }

    @Then("Congratulations should be displayed")
    public void verifyText(){
    String message = homePage.basicAuthHeader();
        if(message.contains("Congratulations!")){
            System.out.println("Success! Message detected: " + message);
        }
        else{
            System.out.println("Failed! Message not detected");
        }
        //System.out.println("Navigated to: " + driver.getCurrentUrl());
    }

    @When("the Sortable Data Tables page is opened")
    public void sortableTableLabel() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Link detected: " + homePage.sortableDataTablesLink());
        homePage.sortableDataTablesLink().click();
    }

    @And("Example 1 header is displayed")
    public void example1Header(){
        System.out.println("Header detected: " + homePage.getExample1Text());
    }

    @Then("rows of Example 1 is displayed")
    public void example1Table(){

        // 1. Get the list of row elements
        List<WebElement> rows = homePage.getTableRows();

        // 2. Loop through them one by one
        for (int i = 0; i < rows.size(); i++) {
            // Get the text of the current row
            String rowData = rows.get(i).getText();

            // Print it out
            System.out.println("Row " + (i + 1) + " contains: " + rowData);
        }
    }
}

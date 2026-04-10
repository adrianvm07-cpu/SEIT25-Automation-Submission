package io.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class herokuHomePage {

    protected ChromeDriver driver;

    public herokuHomePage(ChromeDriver driver) {
        this.driver = driver;
    }

    public String getHeaderText() {
        return driver.findElement(By.tagName("h2")).getText();
    }

    public List<WebElement> getAllLinks() {
        return driver.findElements(By.cssSelector("li a"));
    }
}


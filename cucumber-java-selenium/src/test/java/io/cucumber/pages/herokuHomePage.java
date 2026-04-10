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
        return driver.findElements(By.cssSelector("ul li a"));
    }

    public WebElement basicAuthLink(){
        return driver.findElement(By.linkText("Basic Auth"));
    }

    public String basicAuthHeader(){
        return driver.findElement(By.cssSelector("p")).getText();
    }

    public WebElement sortableDataTablesLink(){
        return driver.findElement(By.xpath("//a[text()='Sortable Data Tables']"));
    }

    public WebElement getExample1Text(){
        return driver.findElement(By.xpath("//h4[text()='Example 1']"));
    }

    public List<WebElement> getTableRows() {
        // This finds every row inside the body of Example 1
        return driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
    }
}


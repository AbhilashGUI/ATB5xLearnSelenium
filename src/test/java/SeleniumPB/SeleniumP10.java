package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumP10 {

    @Test(groups = "QA")
    @Description("Verify by css selector path")
    public void testawesomeqa() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/css/");

        //<div class="first">
        //  <span>Span 1!</span>
        //  <span>Span 2</span>
        //  <span>Span 3!</span>
        //  <span>Span 4</span>
        //  <span>Span 5!</span>
        //  <span>Span 6</span>
        //  <span>Span 7!</span>
        //</div>
        List<WebElement> oddSpans = driver.findElements(By.cssSelector(".first > span:nth-child(odd)"));
        System.out.println("Found " + oddSpans.size() + " odd-numbered spans:");
        for (WebElement span : oddSpans) {
            System.out.println("Text: " + span.getText());

        }
            driver.quit();
        }
    }


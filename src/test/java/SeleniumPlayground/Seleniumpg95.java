package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Seleniumpg95 {

    @Test
    @Description("Verify the iframes")
    public void MultipleIframes() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://qaplayground.com/practice/iframes");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //name="frame-one"
        WebElement iframe1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("frame-one")));
        driver.switchTo().frame(iframe1);

        //<button id="f1-action-btn" data-testid="iframe-f1-action-btn" type="button" onclick="act()">
        //    Click Me
        //  </button>

        WebElement button1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("f1-action-btn")));
        button1.click();

        //<p id="f1-result" class="done">Frame One clicked ✓</p>
        WebElement result1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Frame One clicked ✓']")));
        System.out.println(result1.getText());
        Assert.assertEquals(result1.getText(), "Frame One clicked ✓");
        driver.switchTo().defaultContent();

        //name="frame-two"
        WebElement iframe2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("frame-two")));
        driver.switchTo().frame(iframe2);

        //<button id="f2-action-btn" name="frame-two-action" type="button" aria-label="Activate Frame Two" onclick="act()">
        //    Activate
        //  </button>
        WebElement button2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("f2-action-btn")));
        button2.click();

        //<p id="f2-result" class="done">Frame Two activated ✓</p>
        WebElement result2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Frame Two activated ✓']")));
        System.out.println(result2.getText());
        Assert.assertEquals(result2.getText(), "Frame Two activated ✓");
        driver.switchTo().defaultContent();

        driver.quit();

    }


    @Test
    @Description("Verified the same in different browser")
    public void excludingtheframe3() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaplayground.com/practice/iframes");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //name="frame-one"
        WebElement iframe1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("frame-one")));
        driver.switchTo().frame(iframe1);

        //<button id="f1-action-btn" data-testid="iframe-f1-action-btn" type="button" onclick="act()">
        //    Click Me

        WebElement clickmebutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='iframe-f1-action-btn']")));
        clickmebutton.click();

        driver.switchTo().defaultContent();


//name="frame-two"
        WebElement iframe2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("frame-two")));
        driver.switchTo().frame(iframe2);

        //<button id="f2-action-btn" name="frame-two-action" type="button" aria-label="Activate Frame Two" onclick="act()">
        //    Activate
        //  </button>

        WebElement Activatebutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Activate Frame Two']")));
        Activatebutton.click();


        //<p id="f2-result" class="done">Frame Two activated ✓</p>

        WebElement result2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("done")));
        System.out.println(result2.getText());
        Assert.assertTrue(result2.isDisplayed());

        driver.quit();


    }
}


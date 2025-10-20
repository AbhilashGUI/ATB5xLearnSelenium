package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumP15 {

    EdgeDriver driver;

    @BeforeTest
    public void openbrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Verify using fluent wait methods")
    public void positivecase() {
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("login-username")).sendKeys("vemulaabhilash8433@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("VAS1933@hyd");
        driver.findElement(By.id("js-login-btn")).click();

        Wait<EdgeDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement loggedin_username = wait.until(driver -> driver.findElement(By.cssSelector("[data-qa='lufexuloga']")));
        System.out.println("login userdetails-->" + loggedin_username.getText());

    }

    @AfterTest
    public void closebrowser() {

        driver.quit();
    }
}
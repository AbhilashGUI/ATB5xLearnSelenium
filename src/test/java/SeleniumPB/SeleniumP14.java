package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumP14 {

    EdgeDriver driver;

    @BeforeTest
    public void openbrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Verified using the wait method")
    public void positivecase() {
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("login-username")).sendKeys("vemulaabhilash8433@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("VAS1933@hyd");
            driver.findElement(By.id("js-login-btn")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10000));
        //<span
        // class="Fw(semi-bold) ng-binding"
        // data-qa="lufexuloga"
        // translate-placeholder="vwouser">
        // Vemula Abhilash
        // </span>
        //logging the path of username showing in the dashboard
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-qa=lufexuloga]")));
        WebElement loggedin_username = driver.findElement(By.cssSelector("[data-qa=lufexuloga]"));
        System.out.println("Loggedin userdetails-->" + loggedin_username.getText());
    }

        @AfterTest
         public void  closebrowser()
        {
            driver.quit();
        }
    }


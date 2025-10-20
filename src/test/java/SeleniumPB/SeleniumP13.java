package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumP13 {


    EdgeDriver driver;
    @BeforeTest
    public void openbrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
    }

        @Test(groups = "QA")
        @Description("Verified using the wait methods")
        public void negativecase()
        {
            driver.get("https://app.vwo.com");
            driver.manage().window().maximize();
            //OLD/INCORRECT SYNTAX (Selenium 3 or earlier):
            //driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);

            //<input
            //type="email"
            // class="text-input W(100%)"
            // name="username"
            // placeholder="Enter email ID"
            // id="login-username"
            // data-qa="hocewoqisi"
            // data-gtm-form-interact-field-id="1">

            driver.findElement(By.id("login-username")).sendKeys("Abhilash03@gmail.com");
            //<input
            // type="password"
            // class="text-input W(100%)"
            // placeholder="Enter password"
            // name="password"
            // id="login-password"
            // data-qa="jobodapuxe"
            // data-gtm-form-interact-field-id="0">
            driver.findElement(By.id("login-password")).sendKeys("VAS1933@hyd");
            //<button
            // type="submit"
            // id="js-login-btn"
            // class="btn btn--primary btn--inverted W(100%) Mb(8px) Mb(0):lc" onclick="login.login(event)"
            // data-qa="sibequkica">
            // <span class="icon loader hidden" data-qa="zuyezasugu">
            // </span>
            // <span data-qa="ezazsuguuy">
            // Sign in
            // </span>
            // </button>
            driver.findElement(By.id("js-login-btn")).click();

            //<div
            // class="notification-box-description"
            // id="js-notification-box-msg"
            // data-qa="rixawilomi">
            // Your email, password, IP address or location did not match
            // </div>

            WebElement error_msg= driver.findElement(By.id("js-notification-box-msg"));
            WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(300));
            wait.until(ExpectedConditions.textToBePresentInElement(error_msg,"Your email, password, IP address or location did not match"));
            System.out.println("1-->"+error_msg.getText());
            driver.quit();


        }
    }


package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SeleniumP13 {

    EdgeDriver driver;

    @BeforeTest
    public void openbrowser() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(edgeOptions);
    }

    @Test(groups = "QA")
    @Description("Verify the wait method")
    public void Negativecase() {

        driver.get("https://app.vwo.com/");
        driver.manage().window().maximize();
        //OLD/INCORRECT SYNTAX (Selenium 3 or earlier):
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)


    /*<input
    type="email"
    class="text-input W(100%)"
    name="username"
    vwo-html-translate-attr="placeholder"
    vwo-html-translate-placeholder="login:enterEmailID"
    id="login-username"
    data-qa="hocewoqisi"
    placeholder="Enter email ID">*/

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Abhilash03@gmail.com");

     /*<input
        type="password"
        class="text-input W(100%) Pend(36px)"
        vwo-html-translate-attr="placeholder"
        vwo-html-translate-placeholder="login:enterPassword"
        name="password"
        id="login-password"
        data-qa="jobodapuxe"
        placeholder="Enter password"
        data-gtm-form-interact-field-id="0">
         */

        driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys("VAS1933@hyd");

/*<button
    type="submit"
    id="js-login-btn"
    class="btn btn--primary btn--inverted W(100%) Mb(24px) Mb(0):lc"
    onclick="login.login(event)"
    data-qa="sibequkica">
    <span class="icon loader D(n)"
    data-qa="zuyezasugu">
    </span>
    <span data-qa="ezazsuguuy"
    vwo-html-translate="login:signIn">Sign in</span> </button>
     */

        driver.findElement(By.xpath("//button[@class='btn btn--primary btn--inverted W(100%) Mb(24px) Mb(0):lc']")).click();

    /*<div
        class="notification-box-description"
        id="js-notification-box-msg"
        data-qa="rixawilomi">
        Your email, password, IP address or location did not match</div>
         */
        //Webdriver wait

        WebElement error_text = driver.findElement(By.xpath("//div[@data-qa='rixawilomi']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(error_text, "Your email, password, IP address or location did not match"));
        System.out.println("Error message -->" + error_text.getText());

    }
    @AfterTest
        public void closebrowser()
        {
            driver.quit();
        }

    }

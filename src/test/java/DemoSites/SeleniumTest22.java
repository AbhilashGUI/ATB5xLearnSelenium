package DemoSites;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest22 {

    @Test
    @Description("Verify the Forgot password functionality")
    public void forgotpassword() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Navigate to url
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //<p data-v-7b563373="" data-v-0af708be="" class="oxd-text oxd-text--p orangehrm-login-forgot-header">Forgot your password? </p>
        WebElement forgotpassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Forgot your password? ']")));
        forgotpassword.click();

        //<input data-v-1f99f73c="" class="oxd-input oxd-input--active" name="username" placeholder="Username">
        WebElement username=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
        username.sendKeys("admin");

        //<button data-v-10d463b7="" data-v-76e562c4="" type="button" class="oxd-button oxd-button--large oxd-button--ghost orangehrm-forgot-password-button orangehrm-forgot-password-button--cancel"><!----> Cancel <!----></button>
        WebElement cancelbutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Cancel']")));
        cancelbutton.click();

        WebElement forgotpassword2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Forgot your password? ']")));
        forgotpassword2.click();

        WebElement username2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
        username2.sendKeys("admin");

        //<button data-v-10d463b7="" data-v-76e562c4="" type="submit" class="oxd-button oxd-button--large oxd-button--secondary orangehrm-forgot-password-button orangehrm-forgot-password-button--reset"><!----> <button data-v-10d463b7="" data-v-76e562c4="" type="submit" class="oxd-button oxd-button--large oxd-button--secondary orangehrm-forgot-password-button orangehrm-forgot-password-button--reset"><!----> Reset Password <!----></button> <!----></button>
        WebElement resetbutton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Reset Password']")));
        resetbutton.click();

        //<h1>504 Gateway Time-out</h1>

        //Navigating to expected page
        String errortext=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='504 Gateway Time-out']"))).getText();
        System.out.println(errortext);
        Assert.assertEquals(errortext,"504 Gateway Time-out");
        driver.quit();

    }
}


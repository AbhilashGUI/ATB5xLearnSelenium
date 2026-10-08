package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Seleniumpg98 {

    @Test
    @Description("Verify the iFrames")
    public void FormValidationInsideiframe()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/iframes");
        driver.manage().window().maximize();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        //name="validation-frame"

        WebElement iframe=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("validation-frame")));
        driver.switchTo().frame(iframe);

        //<input type="text" id="val-name" data-testid="iframe-val-name" name="fullName" placeholder="Jane Smith" autocomplete="off">
        WebElement fullname=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Jane Smith']")));
        fullname.sendKeys("Abhilash");

        //<input type="email" id="val-email" data-testid="iframe-val-email" name="email" placeholder="jane@example.com" autocomplete="off">
        WebElement Emailaddres=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-testid='iframe-val-email']")));
        Emailaddres.sendKeys("Testcheck@gmail.com");

        //<input type="text" id="val-company" name="company" placeholder="Acme Corp" autocomplete="off">
        WebElement Company=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='company']")));
        Company.sendKeys("XYZ");

        //<button id="iframe-val-submit" data-testid="iframe-val-submit" type="button" onclick="validate()">
        //      Register
        //    </button>

        WebElement Registerbutton=wait.until(ExpectedConditions.elementToBeClickable(By.id("iframe-val-submit")));
        Registerbutton.click();


        //<p id="form-success" class="visible">Registered successfully ✓</p>

        WebElement result=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("form-success")));
        System.out.println(result.getText());
        Assert.assertTrue(result.isDisplayed(),"working as expected");
        driver.switchTo().defaultContent();
        driver.quit();
    }
}

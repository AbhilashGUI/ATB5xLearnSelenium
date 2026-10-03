package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg66 {

    @Test
    @Description("Verify the Form Automation Practice")
    public void InterestForm() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://qaplayground.com/practice/forms");
        driver.manage().window().maximize();


        //<input id="interest-selenium" type="checkbox" data-testid="checkbox-interest-selenium" data-interest="selenium" class="forms-module__ZLwUJq__checkboxInput" name="interests" value="selenium" data-gtm-form-interact-field-id="0">

        WebElement check1 = driver.findElement(By.id("interest-selenium"));
        check1.click();


        //<input id="interest-appium" type="checkbox" data-testid="checkbox-interest-appium" data-interest="appium" class="forms-module__ZLwUJq__checkboxInput" name="interests" value="appium" data-gtm-form-interact-field-id="1">
        WebElement check2 = driver.findElement(By.xpath("//input[@data-interest='appium']"));
        check2.click();

        //<button id="interestsSubmitBtn" type="submit" data-testid="btn-interests-submit" class="forms-module__ZLwUJq__submitBtn">Save Interests</button>

        WebElement saveinterest = driver.findElement(By.xpath("//button[@id='interestsSubmitBtn']"));
        saveinterest.click();

        Thread.sleep(2000);

        //<div id="interestsResult" data-testid="result-interests" class="forms-module__ZLwUJq__successBanner" role="status">Interests saved: Selenium, Appium</div>
        WebElement successmessage = driver.findElement(By.xpath("//div[@role='status']"));
        Assert.assertEquals(successmessage.getText(), "Interests saved: Selenium, Appium");

        driver.quit();


    }

    @Test
    @Description("Verify the Form Automation Practice")
    public void invalidInterestForm() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaplayground.com/practice/forms");
        driver.manage().window().maximize();


        //<button id="interestsSubmitBtn" type="submit" data-testid="btn-interests-submit" class="forms-module__ZLwUJq__submitBtn">Save Interests</button>

        WebElement saveinterest = driver.findElement(By.xpath("//button[@id='interestsSubmitBtn']"));
        saveinterest.click();

        Thread.sleep(2000);

        //<p class="forms-module__ZLwUJq__errorMsg" role="alert">Please select at least one interest.</p>
        WebElement errormessage = driver.findElement(By.xpath("//p[@role='alert']"));
        Assert.assertEquals(errormessage.getText(), "Please select at least one interest.");
        System.out.println(errormessage.getText());

        driver.quit();
    }
}
package SeleniumPlayground;

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

public class Seleniumpg97 {

    @Test
    @Description("Verify the iFrames")
    public void DynamicIframe()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/iframes");
        driver.manage().window().maximize();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        //iframe: [data-testid="iframe-dynamic"]

        WebElement dynamiciframe=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@data-testid='iframe-dynamic']")));
        driver.switchTo().frame(dynamiciframe);
        System.out.println("Switched to Dynamic Frame");

        //<input type="text" class="dyn-input" id="dyn-code-input" name="dynamic_code" placeholder="Enter reveal code" aria-label="Reveal code input" autocomplete="off">
        WebElement inputfield=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter reveal code'] ")));
        inputfield.sendKeys("Checked");

        //<button type="button" class="dyn-btn" aria-label="Reveal Secret" onclick="reveal()">
        //        Reveal Secret
        //      </button>

        WebElement button=wait.until(ExpectedConditions.elementToBeClickable(By.className("dyn-btn")));
        button.click();

        //<p id="dyn-result" class="done">Secret revealed: Checked ✓</p>
        WebElement result=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Secret revealed: Checked ✓']")));
        System.out.println(result.getText());
        Assert.assertTrue(result.isDisplayed(),"Working as intended");
        driver.switchTo().defaultContent();
        driver.quit();

    }
}

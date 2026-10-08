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

public class Seleniumpg96 {

    @Test
    @Description("Verify nested iframes- 2 levels deep")
    public void Nestediframes()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/iframes");
        driver.manage().window().maximize();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        //[data-testid="iframe-outer"]
        WebElement Outerframe=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@data-testid='iframe-outer']")));
        driver.switchTo().frame(Outerframe);
        System.out.println("Switched to Outer Frame");

        //iframe[title="Inner Frame"]
        WebElement innerframe=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@title='Inner Frame']")));
        driver.switchTo().frame(innerframe);

        //<input type="text" id="inner-secret-input" data-testid="iframe-inner-input" name="secret" placeholder="Enter secret code" autocomplete="off">
        WebElement inputbox=driver.findElement(By.id("inner-secret-input"));
        inputbox.sendKeys("Test");

        //<button id="inner-submit-btn" data-testid="iframe-inner-submit" type="button" onclick="handleSubmit()">
        //      Unlock
        //    </button>

        WebElement unlockbutton=driver.findElement(By.id("inner-submit-btn"));
        unlockbutton.click();

        //<p id="inner-result" class="done">Unlocked with: Test ✓</p>
        WebElement result=driver.findElement(By.id("inner-result"));
        System.out.println(result.getText());
        Assert.assertTrue(result.isEnabled());
        driver.quit();

    }

    @Test
    @Description("Verify the same scenario in different browser")
    public void nestediframes()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/iframes");
        driver.manage().window().maximize();

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

        //iframe: [data-testid="iframe-outer"]

        WebElement outerframe=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@data-testid ='iframe-outer']")));
        driver.switchTo().frame(outerframe);
        System.out.println("Switched to Outer Frame");


        //iframe[title="Inner Frame"]

        WebElement innerframe=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@title='Inner Frame']")));
        driver.switchTo().frame(innerframe);

        //<input type="text" id="inner-secret-input" data-testid="iframe-inner-input" name="secret" placeholder="Enter secret code" autocomplete="off">
        WebElement inputbox=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-testid='iframe-inner-input']")));
        inputbox.sendKeys("Unlock");

        //<button id="inner-submit-btn" data-testid="iframe-inner-submit" type="button" onclick="handleSubmit()">
        //      Unlock
        //    </button>

        WebElement unlockbutton=wait.until(ExpectedConditions.elementToBeClickable(By.id("inner-submit-btn")));
        unlockbutton.click();


        //<p id="inner-result" class="done">Unlocked with: Test ✓</p>
        WebElement savedresult=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inner-result")));
        System.out.println(savedresult.getText());
        driver.switchTo().defaultContent();
        System.out.println("Returned to main document");
        driver.quit();
    }
}

package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Seleniumpg94 {

    @Test
    @Description("Verify the iFrames")
    public void iFrameWithCheckBoxAndSelect()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/iframes");
        driver.manage().window().maximize();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        //name="form-frame"
        WebElement iframe=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("form-frame")));
        driver.switchTo().frame(iframe);

        //<select id="iframe-lang-select" data-testid="iframe-lang-select" name="language">
        //        <option value="">Select language</option>
        //        <option value="javascript">JavaScript</option>
        //        <option value="python">Python</option>
        //        <option value="java">Java</option>
        //        <option value="csharp">C#</option>
        //      </select>

        Select selectlanguage=new Select(driver.findElement(By.id("iframe-lang-select")));
        selectlanguage.selectByIndex(3);

        //<input type="checkbox" id="iframe-agree-chk" data-testid="iframe-agree-chk" name="agree">
        WebElement checkbox=driver.findElement(By.xpath("//input[@data-testid='iframe-agree-chk']"));
        checkbox.click();

        //<button id="iframe-save-btn" data-testid="iframe-save-btn" type="button" onclick="handleSave()">
        //      Save Preferences
        //    </button>

        WebElement savebutton=driver.findElement(By.xpath("//button[@ onclick='handleSave()']"));
        savebutton.click();

        //<p id="result" class="success">Saved: python + terms accepted ✓</p>
        WebElement result=driver.findElement(By.id("result"));
        System.out.println(result.getText());

        Assert.assertTrue(result.isDisplayed());

       driver.switchTo().defaultContent();
       driver.quit();

    }

    @Test
    @Description("Verify the same scenario in different browser")
    public void iframewithcheckboxesandselect()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/iframes");
        driver.manage().window().maximize();

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

        //name="form-frame"
        WebElement iframe=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("form-frame")));
        driver.switchTo().frame(iframe);

        //<select id="iframe-lang-select" data-testid="iframe-lang-select" name="language">
        //        <option value="">Select language</option>
        //        <option value="javascript">JavaScript</option>
        //        <option value="python">Python</option>
        //        <option value="java">Java</option>
        //        <option value="csharp">C#</option>
        //      </select>

        Select selectlang=new Select(driver.findElement(By.name("language")));
        selectlang.selectByIndex(2);


        //<input type="checkbox" id="iframe-agree-chk" data-testid="iframe-agree-chk" name="agree">
        WebElement checkbox=driver.findElement(By.id("iframe-agree-chk"));
        checkbox.click();


        //<button id="iframe-save-btn" data-testid="iframe-save-btn" type="button" onclick="handleSave()">
        //      Save Preferences
        //    </button>

        WebElement submitbutton=driver.findElement(By.id("iframe-save-btn"));
        submitbutton.click();


        //<p id="result" class="success">Saved: python + terms accepted ✓</p>

        WebElement result=driver.findElement(By.xpath("//p[text()='Saved: python + terms accepted ✓']"));
        System.out.println(result.getText());
        Assert.assertTrue(result.isDisplayed());

        driver.switchTo().defaultContent();
        driver.quit();

    }

}

package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Seleniumpg93 {

    @Test
    @Description("Verify the iFrames")
    public void Basiciframe() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://qaplayground.com/practice/iframes");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("basic-frame")));
        driver.switchTo().frame(iframe);


        //<input type="text" id="iframe-name-input" data-testid="iframe-name-input" name="name" placeholder="Enter your name" autocomplete="off">
        WebElement inputfield = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("iframe-name-input")));
        inputfield.sendKeys("Abhilash");

        //<button id="iframe-submit-btn" data-testid="iframe-submit-btn" type="button" onclick="handleSubmit()">Submit</button>

        WebElement submitbutton = wait.until(ExpectedConditions.elementToBeClickable(By.id("iframe-submit-btn")));
        submitbutton.click();

        //<p id="result" class="success">Hello, Abhilash!</p>
       WebElement result=driver.findElement(By.id("result"));
       System.out.println(result.getText());
       Assert.assertEquals(result.getText(),"Hello, Abhilash!");

       driver.switchTo().defaultContent();

       driver.quit();
    }


    @Test
    @Description("Verify the same scenario in the different browser")
    public void basiciframe(){

        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/iframes");
        driver.manage().window().maximize();

        //data-testid="iframe-basic"
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

        WebElement iframe=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("basic-frame")));
        driver.switchTo().frame(iframe);

        //<input type="text" id="iframe-name-input" data-testid="iframe-name-input" name="name" placeholder="Enter your name" autocomplete="off">
        WebElement inputfield=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter your name']")));
        inputfield.sendKeys("Vicky");

        //<button id="iframe-submit-btn" data-testid="iframe-submit-btn" type="button" onclick="handleSubmit()">
        //      Submit
        //    </button>

        WebElement submitbutton=wait.until(ExpectedConditions.elementToBeClickable(By.id("iframe-submit-btn")));
        submitbutton.click();

        //<p id="result" class="success">Hello, Vicky!</p>
        WebElement result=driver.findElement(By.id("result"));
        System.out.println(result.getText());
        Assert.assertTrue(result.isDisplayed());

        driver.switchTo().defaultContent();

        driver.quit();

    }
    @Test
    @Description("Verify the same scenario in different browser")
    public void iframe()
    {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://qaplayground.com/practice/iframes");
        driver.manage().window().maximize();

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

        //name="basic-frame"
        WebElement iframe=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("basic-frame")));
        driver.switchTo().frame(iframe);

        //<input type="text" id="iframe-name-input" data-testid="iframe-name-input" name="name" placeholder="Enter your name" autocomplete="off">
        WebElement inputbox=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-testid='iframe-name-input']")));
        inputbox.sendKeys("Tegimpu");

        //<button id="iframe-submit-btn" data-testid="iframe-submit-btn" type="button" onclick="handleSubmit()">
        //      Submit
        //    </button>

        WebElement submitbutton=wait.until(ExpectedConditions.elementToBeClickable(By.id("iframe-submit-btn")));
        submitbutton.click();


        //<p id="result" class="success">Hello, Abhilash!</p>

        WebElement result=driver.findElement(By.id("result"));
        System.out.println(result.getText());
        Assert.assertTrue(result.isEnabled());

        driver.quit();


    }
}

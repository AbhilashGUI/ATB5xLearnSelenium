package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumP17 {
    EdgeDriver driver;

    @BeforeTest
    public void openbrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        driver = new EdgeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Verify the alerts")
    public void alertscheck() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");


        //<button
        // id="alertButton"
        // type="button"
        // class="btn btn-primary"
        // >Click me
        // </button>

        //WebElement button1= driver.findElement(By.id("alertButton"));
        //button1.click();
        //Thread.sleep(3000);

        // <button
        // id="timerAlertButton"
        // type="button"
        // class="btn btn-primary">
        // Click me
        // </button>

        //WebElement button2 = driver.findElement(By.id("timerAlertButton"));
        //button2.click();

        //<button
        // id="confirmButton"
        // type="button"
        // class="btn btn-primary">
        // Click me
        // </button>

       // WebElement  confirmButton= driver.findElement(By.id("confirmButton"));
        //confirmButton.click();

        //<button
        // id="promtButton"
        // type="button"
        // class="btn btn-primary">
        // Click me
        // </button>
        WebElement promtButton= driver.findElement(By.id("promtButton"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", promtButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", promtButton);;

        //Wait for alert to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.alertIsPresent());

        //Handle to alert
        //Alert alert = driver.switchTo().alert();
        //System.out.println("Alert text: " + alert.getText());
        //alert.accept();

        Alert alert=driver.switchTo().alert();
        System.out.println("Alert text-->"+alert.getText());
        alert.sendKeys("Abhilash");
        alert.accept();


        //<span
        // id="confirmResult"
        // class="text-success">
        // You selected Ok
        // </span>

        //Validate the result
        //String result = driver.findElement(By.id("confirmResult")).getText();
        //Assert.assertEquals(result, "You selected Ok");

        // <span
        // id="promptResult"
        // class="text-success">
        // You entered Abhilash
        // </span>
        String result1=driver.findElement(By.id("promptResult")).getText();
        System.out.println("Result text-->"+ result1);
        Assert.assertEquals(result1,"You entered Abhilash");
    }


    @AfterTest
    public void closebrowser()
    {
       if(driver !=null)
        driver.quit();
    }

}

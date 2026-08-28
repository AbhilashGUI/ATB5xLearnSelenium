package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
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
    public void openbrowser()
    {
        EdgeOptions edgeOptions=new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--disable-extensions");
        edgeOptions.addArguments("--disable-notifications");
        edgeOptions.addArguments("--disable-infobars");
        driver= new EdgeDriver(edgeOptions);

    }

    @Test(groups = "QA")
    @Description("Verify the alerts check")
    public void alertscheck() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();


        /*<button type="button" id="alertButton" class="btn btn-primary">Click me</button>*/

        //WebElement button1=driver.findElement(By.id("alertButton"));
        //button1.click();
        //Thread.sleep(3000);

        /*<button type="button" id="timerAlertButton" class="btn btn-primary">Click me</button>*/

        //WebElement button2= driver.findElement(By.id("timerAlertButton"));
        //button2.click();
        //Thread.sleep(3000);

        /*<button type="button" id="confirmButton" class="btn btn-primary">Click me</button>*/
        //WebElement button3=driver.findElement(By.id("confirmButton"));
        //button3.click();
        //Thread.sleep(3000);

        //Alert alert=driver.switchTo().alert();
        //System.out.println("Alert text-->"+alert);
        //alert.accept();

        /*<span id="confirmResult" class="text-success">You selected Ok</span>*/

        //String result=driver.findElement(By.id("confirmResult")).getText();
        //Assert.assertEquals(result,"You selected Ok");

        /*<button type="button" id="promtButton" class="btn btn-primary">Click me</button>*/


        WebElement button4 = driver.findElement(By.id("promtButton"));
        button4.click();

        /*Note: We can also use javascriptexecutor as shown below
          WebElement promtButton= driver.findElement(By.id("promtButton"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", promtButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", promtButton);;

         */

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text-->" + alert.getText());
        alert.sendKeys("Abhilash");
        alert.accept();

        /*<span id="promptResult" class="text-success">You entered Abhilash</span>*/
        String result = driver.findElement(By.id("promptResult")).getText();
        System.out.println("Result text-->" + result);
        Assert.assertEquals(result, "You entered Abhilash");

    }

    @AfterTest
    public void closebrowser()
    {
        if(driver!=null)
            driver.quit();


    }
}
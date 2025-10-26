package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumP32 {


    EdgeDriver driver;
    @BeforeTest
    public void openbrowser()
    {
        EdgeOptions options= new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver= new EdgeDriver();

    }

    @Test(groups = "QA")
    @Description("Verify the iframe")
    public void positivecase() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");
        Thread.sleep(3000);

      //Switching to iframe
        driver.switchTo().frame("result");

        //
        WebElement submit=driver.findElement(By.xpath("//*[@id=\"form\"]/button"));
        submit.click();

        Thread.sleep(3000);
    }

    @AfterTest
    public void closebrowser()
    {
        driver.quit();
    }

}


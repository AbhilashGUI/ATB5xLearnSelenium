package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class SeleniumP34 {

    EdgeDriver driver;

    @BeforeTest
    public void openbrowser()
    {
        EdgeOptions options= new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new EdgeDriver(options);
    }

    @Test(groups="QA")
    @Description("Verify the relative locator functions")
    public void positivecase() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");


        //Without Switching to iframe when run the scipt, get to see the below error
        //org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element:
        // {"method":"xpath","selector":"//*[@id="form"]/button"}

        WebElement submit=driver.findElement(By.xpath("//*[@id=\"form\"]/button"));
        submit.click();

        WebElement usernamebox=driver.findElement(By.xpath("//input[@id=\"username\"]"));
        WebElement errorelement= driver.findElement(with(By.tagName("small")).below(usernamebox));
        String errortext=errorelement.getText();
        Assert.assertTrue(errorelement.isDisplayed());
        Assert.assertEquals(errortext,"Username must be at least 3 characters");
        Thread.sleep(3000);
    }
    @AfterTest
    public void closebrowser()
    {
        driver.quit();
    }
}



package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumP25 {

    EdgeDriver driver;

    @BeforeTest
    public void openbrowser()
    {
        EdgeOptions options= new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new EdgeDriver();
    }

    @Test(groups = "QA")
    @Description("Verify the Actions via click events")
    public void positivecase() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.spicejet.com/");

        WebElement From = driver.findElement(By.xpath("//div[@data-testid=\"to-testID-origin\"]/div/div/input"));

        Actions actions = new Actions(driver);
        actions.moveToElement(From).click().build().perform();
        actions.moveToElement(From).click().sendKeys("BLR").build().perform();



        Thread.sleep(10000);

    }
  @AfterTest
    public void closebrowser()
  {
      driver.quit();
  }

}

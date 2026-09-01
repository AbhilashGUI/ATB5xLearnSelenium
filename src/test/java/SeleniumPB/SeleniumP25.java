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
        EdgeOptions edgeOptions=new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--disable-notifications");
        driver=new EdgeDriver(edgeOptions);
    }

    @Test(groups = "QA")
    @Description("Verify the actions items")
    public void actionscheck() throws InterruptedException {
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();

        WebElement source= driver.findElement(By.xpath("//div[@data-testid=\"to-testID-origin\"]/div/div/input"));

        Actions actions=new Actions(driver);
        actions.moveToElement(source).click().sendKeys("AYJ").build().perform();
        Thread.sleep(5000);

    }

    @AfterTest
    public void closebrowser()
    {
        driver.quit();
    }
}
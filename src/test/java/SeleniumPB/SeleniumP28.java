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

public class SeleniumP28 {


    EdgeDriver driver;

    @BeforeTest
    public void openbrowser()
    {
        EdgeOptions options= new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver= new EdgeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Verify drag and drop")
    public void positivecase() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        //<div class="column"
        // id="column-a"
        // draggable="true"
        // style="opacity: 1;">
        // <header>A
        // </header>
        // </div>
        WebElement Fromelement=driver.findElement(By.id("column-a"));
        //<div
        // class="column"
        // id="column-b"
        // draggable="true"
        // style="opacity: 1;">
        // <header>
        // B</header>
        // </div>
        WebElement Toelement= driver.findElement(By.id("column-b"));
        Actions actions= new Actions(driver);
        //actions.dragAndDrop(Fromelement,Toelement).perform();

        actions.clickAndHold(Fromelement).moveToElement(Toelement).release().build().perform();
        Thread.sleep(3000);
    }
    @AfterTest
    public void closebrowser()
    {
        driver.quit();
    }
}

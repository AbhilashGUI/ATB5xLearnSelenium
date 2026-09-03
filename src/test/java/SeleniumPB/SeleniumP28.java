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
        EdgeOptions edgeOptions= new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver= new EdgeDriver(edgeOptions);
    }


    @Test(groups = "QA")
    @Description("Verify drag and drop")
    public void draganddropcheck() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        driver.manage().window().maximize();


        //<div class="column" id="column-a" draggable="true"><header>A</header></div>

        WebElement fromelement=driver.findElement(By.id("column-a"));

        //<div class="column" id="column-b" draggable="true"><header>B</header></div>

        WebElement toelement= driver.findElement(By.id("column-b"));

        Actions actions=new Actions(driver);
        //actions.dragAndDrop(fromelement,toelement).perform();

        actions.clickAndHold(fromelement).moveToElement(toelement).release().build().perform();
        Thread.sleep(5000);

    }

    @AfterTest
    public void closebrowser()
    {
        driver.quit();
    }
}









package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumP16 {

    EdgeDriver driver;
    @BeforeTest
    public void openbrowser()
    {
        EdgeOptions edgeOptions=new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--disable-popup-blocking");
        edgeOptions.addArguments("--disable-notifications");
        edgeOptions.addArguments("--disable-extensions");
        edgeOptions.addArguments("--disable-infobars");
        edgeOptions.addArguments("--disable-blink-features=Automationcontrolled");
        driver=new EdgeDriver(edgeOptions);


    }

    @Test(groups = "QA")
    @Description("Verify the dropdowns")
    public void dropdowncheck() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");
        driver.manage().window().maximize();

        //<select
        // id="oldSelectMenu">
        // <option value="red">
        // Red</option><option value="1">
        // Blue</option><option value="2">
        // Green</option><option value="3">
        // Yellow</option><option value="4">
        // Purple</option><option value="5">
        // Black</option><option value="6">
        // White</option><option value="7">
        // Voilet</option><option value="8">
        // Indigo</option><option value="9">
        // Magenta</option><option value="10">
        // Aqua
        // </option></select>

        WebElement dropdownfetch=driver.findElement(By.id("oldSelectMenu"));
        Select select= new Select(dropdownfetch);
        //select.selectByValue("10");
        select.selectByIndex(10);
        //Note: Both functions work in the same manner

        Thread.sleep(2000);

    }

    @AfterTest
    public void closebrowser()
    {
        driver.quit();
    }
}